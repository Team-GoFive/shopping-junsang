package com.kt.shopping.dto.request;

public record LoginRequest(
    @NotBlank
    String loginId,
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^])[A-Za-z\\d!@#$%^]{8,}$")
    String password
) {
}

