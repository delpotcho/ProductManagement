package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface IServiceProduct {

	public void CreateProduct (Product product);
	public void UpdateProduct (Product product);
	public void DeleteProduct (Product product);
	public List<Product> getAllProduct();
	public Product getProductById (Long id);
	
}
