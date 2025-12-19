package com.kt.shopping.dto.faq;

import com.kt.shopping.domain.faq.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FAQRequest {
    public record Create(
            @NotBlank
            String title,
            @NotBlank
            String content,
            @NotNull
            Category category

    ) {}
}
