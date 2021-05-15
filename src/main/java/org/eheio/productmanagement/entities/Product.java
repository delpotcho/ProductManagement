package org.eheio.productmanagement.entities;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Product {
@Id 
    private Long ID;
    private String name;
    private Double price;
    private LocalDateTime date;
    private String description;
    private Category category;
    
	public Product(Long productID, String name, Double price, LocalDateTime date, String description,
			Category category) {
		super();
		this.ID = productID;
		this.name = name;
		this.price = price;
		this.date = date;
		this.description = description;
		this.category = category;
	}

	public Long getProductID() {
		return ID;
	}

	public void setProductID(Long productID) {
		this.ID = productID;
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
