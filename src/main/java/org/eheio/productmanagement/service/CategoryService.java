package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.entities.Category;


public interface CategoryService {

	public void create (Category category);
	public void update (Category category);
	public void delete (Category category);
	public List<Category> getAll();
	public Category getById (Long id);

}
