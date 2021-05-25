package org.eheio.productmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.eheio.productmanagement.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class CategoryRepositoryHibernate implements CategoryRepository {

	@Autowired
	CategoryRepositoryJpa categoryRepositoryJpa;

	@Override
	public void add(Category category) {
		categoryRepositoryJpa.save(category);

	}

	@Override
	public void update(Category category) {
		categoryRepositoryJpa.save(category);

	}

	@Override
	public void delete(Category category) {
		categoryRepositoryJpa.delete(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepositoryJpa.findAll();
	}

	@Override
	public Category getById(Long id) {

		Category category = null;

		Optional<Category> CategoryOptional = categoryRepositoryJpa.findById(id);

		category = CategoryOptional.get();

		if (!CategoryOptional.isPresent()) {

			throw new RuntimeException("Category not Font" + id);
		}
		return category;
	}
}
