package org.eheio.productmanagement.dao;

import org.eheio.productmanagement.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategorieRepository extends JpaRepository<Category, Long>  {

	
}
