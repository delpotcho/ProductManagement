package org.eheio.productmanagement.service.heberante;

import java.util.List;

import org.eheio.productmanagement.dao.CategorieRepository;
import org.eheio.productmanagement.entities.Category;
import org.eheio.productmanagement.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategoryV2 implements IServiceCategorie {
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public void createCategory(Category category) {
		categorieRepository.save(category);

	}

	@Override
	public void updateCategory(Category category) {
		categorieRepository.save(category);

	}

	@Override
	public void deleteCategory(Category category) {
		categorieRepository.delete(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categorieRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {

		return null;
	}

}
