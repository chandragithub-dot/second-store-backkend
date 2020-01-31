package com.secondstore.service.impl;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondstore.Utility.MailConstructor;
import com.secondstore.domain.BillingAddress;
import com.secondstore.domain.CartItem;
import com.secondstore.domain.Order;
import com.secondstore.domain.Payment;
import com.secondstore.domain.Products;
import com.secondstore.domain.ShippingAddress;
import com.secondstore.domain.ShoppingCart;
import com.secondstore.domain.User;
import com.secondstore.repository.BillingAddressRepository;
import com.secondstore.repository.OrderRepository;
import com.secondstore.repository.PaymentRepository;
import com.secondstore.repository.ShippingAddressRepository;
import com.secondstore.service.CartItemService;
import com.secondstore.service.OrderService;
import com.secondstore.service.ProductsService;

@Service
public class OrderServiceImpl implements OrderService{
		
		@Autowired
		private OrderRepository orderRepository;
		
		@Autowired
		private BillingAddressRepository billingAddressRepository;
		
		@Autowired
		private ShippingAddressRepository shippingAddressRepository;
		
		@Autowired
		private PaymentRepository paymentRepository;
		
		@Autowired
		private CartItemService cartItemService;
		
		@Autowired
		private ProductsService productsService;
		
		@Autowired
		private MailConstructor mailConstructor;
		
		public synchronized Order createOrder(
				ShoppingCart shoppingCart,
				ShippingAddress shippingAddress,
				BillingAddress billingAddress,
				Payment payment,
				String shippingMethod,
				User user
				){
			Order order = new Order();
			order.setBillingAddress(billingAddress);
			order.setOrderStatus("created");
			order.setPayment(payment);
			order.setShippingAddress(shippingAddress);
			order.setShippingMethod(shippingMethod);
			
			List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
			
			for (CartItem cartItem : cartItemList) {
				Products products = cartItem.getProduct();
				cartItem.setOrder(order);
				products.setInStockNumber(products.getInStockNumber()-cartItem.getQty());
			}
			
			order.setCartItemList(cartItemList);
			order.setOrderDate((Date) Calendar.getInstance().getTime());
			order.setOrderTotal(shoppingCart.getGrandTotal());
			shippingAddress.setOrder(order);
			billingAddress.setOrder(order);
			payment.setOrder(order);
			order.setUser(user);
			order = orderRepository.save(order);
			
			return order;
		}
		
		public Optional<Order> findOne(Long id) {
			return orderRepository.findById(id);
		}

}
