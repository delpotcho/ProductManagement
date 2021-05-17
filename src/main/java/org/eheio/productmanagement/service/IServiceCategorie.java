package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Category;


public interface IServiceCategorie {

	public void createCategory (Category category);
	public void updateCategory (Category category);
	public void deleteCategory (Category category);
	public List<Category> getAllCategory();
	public Category getCategoryById (Long id);

}
