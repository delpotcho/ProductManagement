package org.eheio.productmanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.eheio.productmanagement.entities.Product;
import org.eheio.productmanagement.service.IServiceCategorie;
import org.eheio.productmanagement.service.IServiceProduct;


@Controller
public class ProductController {
	@Autowired
	IServiceProduct serviceProduct;
	@Autowired
	IServiceCategorie serviceCategorie;

	Product product;

	@GetMapping("/")
	
	public String viewProduct(Model model) {
		
		model.addAttribute("ListProduct", serviceProduct.getAllProduct());
		
		return "ListProduct";
	}

	@GetMapping("/createProduct")
	public String AddProduct(Model model) {
		product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("listCategory", serviceCategorie.getAllCategory());
		return "NewProduct";
	}

	@PostMapping("/saveProduct")
	public String SaveProduct(@ModelAttribute Product product) {
		serviceProduct.createProduct(product);
		return "redirect:/";
	}

	@GetMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable(value = "id") Long id, Model model)

	{
		Product product = serviceProduct.getProductById(id);

		model.addAttribute("product", product);

		return "UpdateProduct";
	}

	@GetMapping("/deleteProduct/{id}")
	public String DeleteProduct(@PathVariable Long id) {
		Product product = serviceProduct.getProductById(id);
		serviceProduct.deleteProduct(product);
		return "redirect:/";
	}

}