package org.eheio.productmanagement.service;

import java.util.List;

import org.eheio.productmanagement.dao.CategorieRepository;
import org.eheio.productmanagement.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceCategoryImpl implements IServiceCategorie {
	@Autowired
	CategorieRepository categorieRepository ;
	@Override
	public void CreateCategory(Category category) {
		categorieRepository.save(category);
		
	}

	@Override
	public void UpdateCategory(Category category) {
		categorieRepository.save(category);
		
	}

	@Override
	public void DeleteCategory(Category category) {
		categorieRepository.delete(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categorieRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
