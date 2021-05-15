package org.eheio.productmanagement.entities;

import java.time.LocalDateTime;

public class Product {

    private Long productID;
    private String name;
    private Double price;
    private LocalDateTime date;
    private String description;
    private Category category;
    
	public Product(Long productID, String name, Double price, LocalDateTime date, String description,
			Category category) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.date = date;
		this.description = description;
		this.category = category;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
}
