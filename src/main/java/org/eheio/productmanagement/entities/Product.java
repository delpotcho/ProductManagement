package org.eheio.productmanagement.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private Long id;
	private String name;
	private Double price;
	private Date date;
	private String description;
	private Category category;

	public Product() {
		
	}
	public Product(Long id, String name, Double price, Date date, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
		this.description = description;
	}
	
	public Product(Long id, String name, Double price, Date date, String description, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
		this.description = description;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
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
