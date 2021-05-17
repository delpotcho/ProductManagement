package org.eheio.productmanagement.service.heberante;

import java.util.List;
import java.util.Optional;

import org.eheio.productmanagement.dao.ProductRepository;
import org.eheio.productmanagement.entities.Product;
import org.eheio.productmanagement.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ServiceProductv2 implements IServiceProduct {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
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
		
		if (!ProductOptional.isPresent()) {
			
			throw new RuntimeException("Product not Font" + id);
		}
		return product;

	}
}
