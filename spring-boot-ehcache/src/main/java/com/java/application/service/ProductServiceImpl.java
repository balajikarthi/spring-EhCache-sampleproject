package com.java.application.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.java.application.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {


/**
 *@Cacheable annotation indicates that the result of
 * invoking a method (or all methods in a class) can be cached.
 * A cache itself can be imagined as a key-value based Map
 */	
	
	@Cacheable("products")
	public Product getByName(String name) {
		slowDownLookupOperation();
		System.out.println("Inside getByName(String name) method");
		return new Product(name, 100);
	}
	
	
	/**
	 * @CacheEvict annotation indicates that a method 
	 * (or all methods on a class) triggers a cache evict operation, 
	 * removing specific[or all] items from cache
	 *
	 */
	@CacheEvict(value = "products", allEntries = true)
	public void refreshAllProducts() {
		/*
		 * This method will remove all 'products' from cache, say as a result of flush
		 * API.
		 */

	}

	private void slowDownLookupOperation() {

		try {
			long time = 10000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {

			throw new IllegalStateException(e);
		}

	}

}
