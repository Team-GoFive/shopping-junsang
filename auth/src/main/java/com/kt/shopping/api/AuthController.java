package com.kt.shopping.api;

import com.kt.common.enums.HistoryType;
import com.kt.common.response.ApiResult;
import com.kt.common.support.TechUpLogger;
import com.kt.shopping.dto.request.LoginRequest;
import com.kt.shopping.dto.response.LoginResponse;
import com.kt.shopping.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @TechUpLogger(type = HistoryType.LOGIN, content = "사용자 로그인")
    @PostMapping("/login")
    public ApiResult<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        var pair = authService.login(request.loginId(), request.password());

        return ApiResult.ok(new LoginResponse(pair.getFirst(), pair.getSecond()));
    }

}
