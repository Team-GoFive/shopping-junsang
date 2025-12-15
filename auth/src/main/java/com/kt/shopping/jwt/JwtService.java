package com.kt.shopping.jwt;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties jwtProperties;

    public String issue(Long id, Date expiration) {

        return Jwts.builder()
                .subject("kt-cloud-shopping")
                .issuer("roy")
                .issuedAt(new Date())
                .id(id.toString())
                .expiration(expiration)
                .signWith(jwtProperties.getSecret())
                .compact();
    }

    public Date getAccessExpiration() {
        return jwtProperties.getAccessTokenExpiration();
    }

    public Date getRefreshExpiration() {
        return jwtProperties.getRefreshTokenExpiration();
    }

    public boolean validate(String token) {
        return Jwts.parser()
                .verifyWith(jwtProperties.getSecret())
                .build()
                .isSigned(token);
    }

    public Long parseId(String token) {
        System.out.println(token);
        var id = Jwts.parser()
                .verifyWith(jwtProperties.getSecret())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getId();

        return Long.valueOf(id);
    }
}
