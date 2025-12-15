package com.kt.shopping.service;

import com.kt.common.encoder.PasswordEncoder;
import com.kt.common.exception.CustomException;
import com.kt.common.exception.ErrorCode;
import com.kt.common.support.Preconditions;
import com.kt.shopping.jwt.JwtService;
import com.kt.shopping.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Pair<String, String> login(String loginId, String password) {
        var user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new CustomException(ErrorCode.FAIL_LOGIN));
        Preconditions.validate(passwordEncoder.matches(password, user.getPassword()), ErrorCode.FAIL_LOGIN);
        var accessToken = jwtService.issue(user.getId(), jwtService.getAccessExpiration());
        var refreshToken = jwtService.issue(user.getId(), jwtService.getRefreshExpiration());

        return Pair.of(accessToken, refreshToken);
    }
}
