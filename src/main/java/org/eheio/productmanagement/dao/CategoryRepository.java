package org.eheio.productmanagement.dao;

import java.util.List;

import org.eheio.productmanagement.entities.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository {

	public void add(Category category);
	public void update(Category category);
	public void delete(Category category);
	public List<Category> getAll();
	public Category getById(Long id);
}
