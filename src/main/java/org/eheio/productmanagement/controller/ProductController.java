package org.eheio.productmanagement.controller;

import org.eheio.productmanagement.dao.CategoryDAOImpl;
import org.eheio.productmanagement.dao.ProductDAOImpl;
import org.eheio.productmanagement.entities.Product;
import org.eheio.productmanagement.service.IServiceCategorie;
import org.eheio.productmanagement.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class ProductController {
	@Autowired
	IServiceProduct serviceProduct;
	@Autowired
	IServiceCategorie serviceCategorie;
	@Autowired
	ProductDAOImpl productDAOImpl;
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	Product product;

	/* ----------------- Hibernate ------------------------- */
	
	@GetMapping("/products")
	public String viewProduct(Model model) {
		model.addAttribute("ListProduct", serviceProduct.getAllProduct());
		return "ListProduct";
	}

	@GetMapping("/createProduct")
	public String AddProduct (Model model){ 
	product = new Product();
	model.addAttribute("product",product);	
	model.addAttribute("listCategory",serviceCategorie.getAllCategory());
	return "NewProduct";
	}
	
	@PostMapping("/saveProduct")
	 public String SaveProduct (@ModelAttribute Product product)
	 {	
		 serviceProduct.CreateProduct(product);
		 return "redirect:/products";
	 }

	/* ----------------- JDBC ------------------------- */
	
	@GetMapping("/productsList")
	public String getAllProducts(Model model) {
		model.addAttribute("ListProduct", productDAOImpl.getAllProducts());
		return "ListProduct";
	}
	
	@GetMapping("/NewProduct")
	public String CreateProduct(Model model){ 
	product = new Product();
	model.addAttribute("product",product);	
	model.addAttribute("listCategory", categoryDAOImpl.getAllCategories());
	return "NewProduct";
	}
}