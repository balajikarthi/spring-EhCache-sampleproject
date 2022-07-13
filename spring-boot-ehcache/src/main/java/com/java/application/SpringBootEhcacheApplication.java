package com.java.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.java.application.configuration.AppConfig;
import com.java.application.service.ProductService;

public class SpringBootEhcacheApplication {

	/**
	 * Caching Annotations:
	 * @Cacheable - triggers cache population
	 * @CacheEvict - triggers cache eviction
	 * @CachePut - update the cache without interfering with the method execution
	 * @Caching - re-groups multiple cache operation to be applied on a method
	 * @CacheConfig - shares some common cache-related setting at class-level
	 * @EnableCaching - configuration level annotation which enable caching
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		{

			ProductService service = (ProductService) context.getBean("productService");
			System.out.println("Laptop ->" + service.getByName("Laptop"));
			System.out.println("Laptop ->" + service.getByName("Laptop"));
			System.out.println("Laptop ->" + service.getByName("Laptop"));

			System.out.println("Refreshing all products");
			service.refreshAllProducts();

			System.out.println("Laptop [after refresh]->" + service.getByName("Laptop"));
			System.out.println("Laptop [after refresh]->" + service.getByName("Laptop"));
			System.out.println("Laptop [after refresh]->" + service.getByName("Laptop"));

			((AbstractApplicationContext) context).close();
		}
	}
}