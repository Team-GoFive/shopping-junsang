package com.kt.shopping.service;

import com.kt.common.exception.ErrorCode;
import com.kt.common.support.Lock;
import com.kt.common.support.Message;
import com.kt.common.support.Preconditions;
import com.kt.shopping.domain.order.Order;
import com.kt.shopping.domain.order.Receiver;
import com.kt.shopping.domain.orderproduct.OrderProduct;
import com.kt.shopping.repository.order.OrderRepository;
import com.kt.shopping.repository.orderproduct.OrderProductRepository;
import com.kt.shopping.repository.product.ProductRepository;
import com.kt.shopping.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderProductRepository orderProductRepository;
	private final ApplicationEventPublisher applicationEventPublisher;

	@Lock(key = Lock.Key.STOCK, index = 1)
	public void create(
		Long userId,
		Long productId,
		String receiverName,
		String receiverAddress,
		String receiverMobile,
		Long quantity
	) {
		var product = productRepository.findByIdOrThrow(productId);

		System.out.println(product.getStock());
		Preconditions.validate(product.canProvide(quantity), ErrorCode.NOT_ENOUGH_STOCK);

		var user = userRepository.findByIdOrThrow(userId, ErrorCode.NOT_FOUND_USER);

		var receiver = new Receiver(
			receiverName,
			receiverAddress,
			receiverMobile
		);

		var order = orderRepository.save(Order.create(receiver, user));
		var orderProduct = orderProductRepository.save(new OrderProduct(order, product, quantity));

		product.decreaseStock(quantity);

		product.mapToOrderProduct(orderProduct);
		order.mapToOrderProduct(orderProduct);

		applicationEventPublisher.publishEvent(
			new Message("User: " + user.getName() + " ordered :" + quantity * product.getPrice())
		);
	}
}
