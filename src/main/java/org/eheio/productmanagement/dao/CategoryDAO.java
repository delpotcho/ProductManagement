package org.eheio.productmanagement.dao;

import java.util.List;

import org.eheio.productmanagement.entities.Category;

public interface CategoryDAO {

	public int CreateCategory(Category category);

	public void UpdateCategory(Category category);

	public void DeleteCategory(Category category);

	public List<Category> getAllCategories();

	public Category getCategoryById(Long id);
}
