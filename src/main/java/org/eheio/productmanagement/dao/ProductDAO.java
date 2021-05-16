package org.eheio.productmanagement.dao;

import java.util.List;

import org.eheio.productmanagement.entities.Product;

public interface ProductDAO {

	public int CreateProduct (Product product);
	public void UpdateProduct (Product product);
	public void DeleteProduct (Product product);
	public List<Product> getAllProducts();
	public Product getProductById (Long id);
	
}