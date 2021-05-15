package org.eheio.productmanagement.entities;

import java.util.List;

public class Category {

    private Long categoryID;
    private String name;
    private String description;
    private List<Product> products;
    
	public Category(Long categoryID, String name, String description, List<Product> products) {
		super();
		this.categoryID = categoryID;
		this.name = name;
		this.description = description;
		this.products = products;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
