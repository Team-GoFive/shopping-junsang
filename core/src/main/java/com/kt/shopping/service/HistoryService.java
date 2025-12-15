package com.kt.shopping.service;

import com.kt.common.enums.HistoryType;
import com.kt.shopping.domain.history.History;
import com.kt.shopping.repository.history.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {
	private final HistoryRepository historyRepository;

	public void create(HistoryType type, String content, Long userId) {
		historyRepository.save(
			new History(
				type, content, userId
			)
		);
	}
}
