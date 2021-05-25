package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.dao.ProductRepository;
import org.eheio.productmanagement.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void create(Product product) {
		productRepository.add(product);
	}

	@Override
	public void update(Product product) {
		productRepository.update(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.getAll();
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getById(id);
	}

}
