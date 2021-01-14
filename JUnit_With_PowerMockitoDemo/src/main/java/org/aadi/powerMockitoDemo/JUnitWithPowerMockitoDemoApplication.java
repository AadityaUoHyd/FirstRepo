package org.aadi.powerMockitoDemo;

import org.aadi.powerMockitoDemo.dto.OrderRequest;
import org.aadi.powerMockitoDemo.dto.OrderResponse;
import org.aadi.powerMockitoDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JUnitWithPowerMockitoDemoApplication {

	@Autowired
	private OrderService service;

	@PostMapping("/placeOrder")
	public OrderResponse placeOrder(@RequestBody OrderRequest request){
		return service.checkoutOrder(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(JUnitWithPowerMockitoDemoApplication.class, args);
	}

}
