package org.aadi.powerMockitoDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

import org.aadi.powerMockitoDemo.dto.OrderRequest;
import org.aadi.powerMockitoDemo.dto.OrderResponse;
import org.aadi.powerMockitoDemo.email.Email;
import org.aadi.powerMockitoDemo.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="org.aadi.powerMockitoDemo.*")
class JUnitWithPowerMockitoDemoApplicationTests {
	
	public JUnitWithPowerMockitoDemoApplicationTests() {
		super();
	}

	@InjectMocks
	private OrderService service;

	OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "aadi@gmail.com", true);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(Email.class);
	}

	@Test
	public void testStaticMethod() {
		// Given
		String emailid = "aadi@gmail.com";
		PowerMockito.mockStatic(Email.class);
		// When
		when(Email.sendEmail(emailid)).thenReturn("success");
		// Then
		OrderResponse response = service.checkoutOrder(request);
		assertEquals("success", response.getMessage());
	}

	@Test
	public void testPrivateMethod() throws Exception {
		// When
		OrderService spy = PowerMockito.spy(service);
		doReturn(2000).when(spy, "addDiscount", ArgumentMatchers.any());
		// Then
		OrderResponse response = spy.checkoutOrder(request);
		int price = response.getResponse().getPrice();// 9000
		System.out.println("price : " + price);
		assertEquals(8000, price);
	}

}