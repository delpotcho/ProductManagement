package org.eheio.productmanagement.dao;

import org.eheio.productmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {

}
