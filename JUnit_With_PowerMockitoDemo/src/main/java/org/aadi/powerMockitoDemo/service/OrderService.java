package org.aadi.powerMockitoDemo.service;

import org.aadi.powerMockitoDemo.dto.OrderRequest;
import org.aadi.powerMockitoDemo.dto.OrderResponse;
import org.aadi.powerMockitoDemo.email.Email;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	public OrderResponse checkoutOrder(OrderRequest order) {
		// call DAO
		int discount=addDiscount(order);
		order.setPrice(order.getPrice() - discount);
		String message = Email.sendEmail(order.getEmailId());
		return new OrderResponse(order, message, HttpStatus.OK.value());
	}

	private int addDiscount(OrderRequest order) {
		System.out.println("called...");
		int price = order.getPrice();
		int discountAmount = 0;
		if (order.isDiscountable()) {
			if (order.getPrice() > 1000) {
				discountAmount = price * 10 / 100;
			} else {
				discountAmount = price;
			}
		} else {
			discountAmount = price;
		}
		return discountAmount;
	}
}
