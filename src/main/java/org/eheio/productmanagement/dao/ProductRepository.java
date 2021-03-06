package org.eheio.productmanagement.dao;

import java.util.List;

import org.eheio.productmanagement.entities.Product;

public interface ProductRepository {

	public void add(Product product);

	public void update(Product product);

	public void delete(Product product);

	public List<Product> getAll();

	public Product getById(Long id);
}
