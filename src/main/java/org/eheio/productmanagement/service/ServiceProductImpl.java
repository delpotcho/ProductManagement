package org.eheio.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.eheio.productmanagement.dao.ProductRepository;
import org.eheio.productmanagement.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceProductImpl implements IServiceProduct {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void CreateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void UpdateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void DeleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		
		Product product = null;
		
	Optional<Product> ProductOptional = productRepository.findById(id);
	product = ProductOptional.get();
	if (!ProductOptional.isPresent())
	{
		throw new RuntimeException("Product not Font"+id);
	}
	 return product;
		
		
	}
}
