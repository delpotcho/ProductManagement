package org.eheio.productmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.eheio.productmanagement.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public abstract class ProductRepositoryHibernate implements ProductRepository {

	@Autowired
	ProductRepositoryJpa productRepositoryJpa;

	@Override
	public void add(Product product) {
		productRepositoryJpa.save(product);
	}

	@Override
	public void update(Product product) {
		productRepositoryJpa.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepositoryJpa.delete(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepositoryJpa.findAll();
	}

	@Override
	public Product getById(Long id) {

		Product product = null;

		Optional<Product> ProductOptional = productRepositoryJpa.findById(id);
		
		product = ProductOptional.get();
		
		if (!ProductOptional.isPresent()) {
			
			throw new RuntimeException("Product not Font" + id);
		}
		return product;

	}
}
