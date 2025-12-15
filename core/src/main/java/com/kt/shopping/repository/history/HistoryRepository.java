package com.kt.shopping.repository.history;

import com.kt.shopping.domain.history.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
