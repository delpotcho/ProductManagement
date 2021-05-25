package org.eheio.productmanagement.controller;

import java.util.Date;

import org.eheio.productmanagement.entities.Product;
import org.eheio.productmanagement.service.CategoryService;
import org.eheio.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	Product product;

	@GetMapping("/list")

	public String viewProduct(Model model) {

		model.addAttribute("ListProduct", productService.getAll());
		

		return "ListProduct";
	}

	@GetMapping("/add")
	public String AddProduct(Model model) {

		product = new Product();

		model.addAttribute("product", product);
		model.addAttribute("listCategory", categoryService.getAll());

		return "NewProduct";
	}

	@PostMapping("/save")
	public String SaveProduct(@ModelAttribute Product product) {

		product.setDate(new Date());

		productService.create(product);

		return "redirect:/product/list";
	}

	@GetMapping("/update/{id}")
	public String updateProduct(@PathVariable(value = "id") Long id, Model model)

	{
		Product product = productService.getById(id);

		model.addAttribute("product", product);

		model.addAttribute("listCategory", categoryService.getAll());

		return "UpdateProduct";
	}

	@GetMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable Long id) {

		Product product = productService.getById(id);

		productService.delete(product);

		return "redirect:/product/list";

	}

}