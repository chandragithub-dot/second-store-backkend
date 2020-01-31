package com.secondstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondstore.domain.CartItem;
import com.secondstore.domain.Products;
import com.secondstore.domain.ProductsToCartItem;
import com.secondstore.domain.ShoppingCart;
import com.secondstore.domain.User;
import com.secondstore.repository.CartItemRepository;
import com.secondstore.repository.ProductsToCartItemRepository;
import com.secondstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductsToCartItemRepository productsToCartItemRepository;

	public CartItem addProductsToCartItem(Products products, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if (products.getId() == cartItem.getProduct().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(products.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setProduct(products);
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(products.getOurPrice()).multiply(new BigDecimal(qty)));
		
		cartItem =cartItemRepository.save(cartItem);
		
		ProductsToCartItem productsToCartItem = new ProductsToCartItem();
		productsToCartItem.setProducts(products);
		productsToCartItem.setCartItem(cartItem);
		productsToCartItemRepository.save(productsToCartItem);
		
		return cartItem;
	}
	
	@Transactional
	public void removeCartItem(CartItem cartItem) {
		productsToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getProduct().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
		
	}
	
	public CartItem findById(Long id) {
		return cartItemRepository.findOne(id);
	}
	
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
//	public List<CartItem> findByOrder(Order order) {
//		return cartItemRepository.findByOrder(order);
//	}
}
