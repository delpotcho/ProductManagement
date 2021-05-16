package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Category;


public interface IServiceCategorie {

	public void CreateCategory (Category category);
	public void UpdateCategory (Category category);
	public void DeleteCategory (Category category);
	public List<Category> getAllCategory();
	public Category getCategoryById (Long id);

}
