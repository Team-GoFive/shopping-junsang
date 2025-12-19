package com.kt.shopping.domain.faq;

import com.kt.common.support.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FAQ extends BaseEntity {
	private String title;
	private String content;
	@Enumerated(EnumType.STRING)
	private Category category;
}
