package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.dao.CategoryRepository;
import org.eheio.productmanagement.dao.CategoryRepositoryJpa;
import org.eheio.productmanagement.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryRepositoryJpa cr;

	@Override
	public void create(Category category) {
		categoryRepository.add(category);
	}

	@Override
	public void update(Category category) {
		categoryRepository.update(category);
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

	@Override
	public Category getById(Long id) {
		return categoryRepository.getById(id);
	}

}
