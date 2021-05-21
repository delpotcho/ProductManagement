package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Product;

public interface ProductService {

	public void create (Product product);
	public void update (Product product);
	public void delete (Product product);
	public List<Product> getAll();
	public Product getById (Long id);
	
}
