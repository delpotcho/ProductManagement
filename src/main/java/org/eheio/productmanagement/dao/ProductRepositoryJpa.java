package org.eheio.productmanagement.dao;

import org.eheio.productmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long>{

}
