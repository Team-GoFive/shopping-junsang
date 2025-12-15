package com.kt.shopping.repository.order;

import com.kt.shopping.domain.order.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@NotNull
	@EntityGraph(attributePaths = {"orderProducts", "orderProducts.product"})
	List<Order> findAllByUserId(Long userId);
}
