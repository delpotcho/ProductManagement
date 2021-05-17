package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface IServiceProduct {

	public void createProduct (Product product);
	public void updateProduct (Product product);
	public void deleteProduct (Product product);
	public List<Product> getAllProduct();
	public Product getProductById (Long id);
	
}
