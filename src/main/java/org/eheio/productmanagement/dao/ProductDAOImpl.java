package org.eheio.productmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eheio.productmanagement.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String SELECT_PRODUCT_BY_ID = "select id, Name, Price, Date, Description, category_id from productmanagement.product, where id =?;";
	final String SELECT_ALL_PRODUCTS = "select * from productmanagement.product;";
	
	final String INSERT_QUERY = "INSERT INTO productmanagement.product (Name, Price, Date, Description) VALUES  (?, ?, ?, ?);";
	final String UPDATE_QUERY = "update productmanagement.product set Name = ?, Price = ?, Date =?, Description = ? where id = ?;";
	final String DELETE_QUERY = "delete from productmanagement.product where id = ?;";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int CreateProduct(Product product) {
		return jdbcTemplate.update(INSERT_QUERY, product.getName(), product.getPrice(), product.getDate(),
				product.getDescription());
	}

	@Override
	public void UpdateProduct(Product product) {
		jdbcTemplate.update(UPDATE_QUERY, product.getName(), product.getPrice(), product.getDate(),
				product.getDescription(), product.getId());
	}

	@Override
	public void DeleteProduct(Product product) {
		jdbcTemplate.update(DELETE_QUERY, product.getId());
	}

	@Override
	public List<Product> getAllProducts() {

		return jdbcTemplate.query(SELECT_ALL_PRODUCTS, new ResultSetExtractor<List<Product>>() {

			public List<Product> extractData(ResultSet rs) throws SQLException {
				List<Product> products = new ArrayList<Product>();
				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					product.setDate(rs.getDate("date"));
					product.setDescription(rs.getString("Description"));
					products.add(product);
				}
				return products;
			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	public Product getProductById(Long id) {

		return jdbcTemplate.query(SELECT_PRODUCT_BY_ID, new Object[] {id}, new ResultSetExtractor<Product>() {

			public Product extractData(ResultSet rs) throws SQLException {
				
				Product product = new Product();
				while (rs.next()) {
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					product.setDate(rs.getDate("date"));
					product.setDescription(rs.getString("Description"));
				}
				return product;
			}
		});
	}
}