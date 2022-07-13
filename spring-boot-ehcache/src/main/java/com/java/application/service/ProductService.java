package com.java.application.service;

import com.java.application.model.Product;

public interface ProductService {

	Product getByName(String name);

	void refreshAllProducts();

}
