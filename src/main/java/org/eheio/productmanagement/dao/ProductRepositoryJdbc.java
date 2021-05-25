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

//@Primary
@Repository
public class ProductRepositoryJdbc implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String SELECT_PRODUCT_BY_ID = "select id, Name, Price, Date, Description, category_id from product where `id` = ?;";
	final String SELECT_ALL_PRODUCTS = "select * from product;";

	final String INSERT_QUERY = "INSERT INTO product (Name, Price, Date, Description) VALUES  (?, ?, ?, ?);";
	final String UPDATE_QUERY = "update product set Name = ?, Price = ?, Date =?, Description = ? where `id` = ?;";
	final String DELETE_QUERY = "delete from product where id = ?;";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Product product) {

		jdbcTemplate.update(INSERT_QUERY, product.getName(), product.getPrice(), product.getDate(),

				product.getDescription());
	}

	@Override
	public void update(Product product) {

		jdbcTemplate.update(UPDATE_QUERY, product.getName(), product.getPrice(), product.getDate(),

				product.getDescription(), product.getId());
	}

	@Override
	public void delete(Product product) {

		jdbcTemplate.update(DELETE_QUERY, product.getId());
	}

	@Override
	public List<Product> getAll() {

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
	public Product getById(Long id) {

		return jdbcTemplate.query(SELECT_PRODUCT_BY_ID, new Object[] { id }, new ResultSetExtractor<Product>() {

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
