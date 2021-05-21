package org.eheio.productmanagement.controller;

import org.eheio.productmanagement.entities.Category;
import org.eheio.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	Category category;

	@GetMapping("/list")
	
	public String viewCategory(Model model) {
		
		model.addAttribute("ListCategory", categoryService.getAll());
		
		return "ListCategory";
	}

	@GetMapping("/add")
	public String AddCategory(Model model) {
		
		category = new Category();
		
		model.addAttribute("category", category);
		
		return "New";
	}

	@PostMapping("/save")
	public String SaveCategory(@ModelAttribute Category category) {
		
		categoryService.create(category);
		
		return "redirect:/category/list";
	}

	@GetMapping("/update/{id}")
	public String updateCategory(@PathVariable(value = "id") Long id, Model model)

	{
		Category category = categoryService.getById(id);

		model.addAttribute("category", category);

		return "Update";
	}

	@GetMapping("/delete/{id}")
	public String DeleteCategory(@PathVariable Long id) {
		
		Category category = categoryService.getById(id);
		
		categoryService.delete(category);
		
		return "redirect:/category/list";
		
	}

}
