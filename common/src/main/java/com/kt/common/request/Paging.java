package com.kt.common.request;

import org.springframework.data.domain.PageRequest;

public record Paging(
	int page,
	int size
) {
	public PageRequest toPageable() {
		return PageRequest.of(page - 1, size);
	}
}
