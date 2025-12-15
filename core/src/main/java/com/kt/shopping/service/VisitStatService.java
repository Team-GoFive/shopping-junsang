package com.kt.shopping.service;

import com.kt.shopping.domain.visitstat.VisitStat;
import com.kt.shopping.repository.visitstat.VisitStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitStatService {
	private final VisitStatRepository visitStatRepository;

	public void create(Long userId, String ip, String userAgent) {
		visitStatRepository.save(new VisitStat(ip, userAgent, userId));
	}
}
