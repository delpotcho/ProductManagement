package org.eheio.productmanagement.service.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eheio.productmanagement.entities.Category;
import org.eheio.productmanagement.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Primary
@Component
public class ServiceCategory implements IServiceCategorie {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	static String SELECT_CATEGORY_BY_ID = "select id, Name, Description, from category, where id =?;";
	final String SELECT_ALL_CATEGORIES = "select * from category;";

	final String INSERT_QUERY = "INSERT INTO category (Name, Description) VALUES  (?, ?);";
	final String UPDATE_QUERY = "update category set Name = ?, Description = ? where id = ?;";
	final String DELETE_QUERY = "delete from category where id = ?;";

	

	@Override
	public void createCategory(Category category) {
		
		jdbcTemplate.update(INSERT_QUERY, category.getName(), category.getDescription());
	}

	@Override
	public void updateCategory(Category category) {
		jdbcTemplate.update(UPDATE_QUERY, category.getName(), category.getDescription(), category.getId());
	}

	@Override
	public void deleteCategory(Category category) {
		jdbcTemplate.update(DELETE_QUERY, category.getId());

	}

	@Override
	public List<Category> getAllCategory() {

		return jdbcTemplate.query(SELECT_ALL_CATEGORIES, new ResultSetExtractor<List<Category>>() {

			public List<Category> extractData(ResultSet rs) throws SQLException {
				List<Category> categories = new ArrayList<Category>();
				while (rs.next()) {
					Category category = new Category();
					category.setId(rs.getLong("id"));
					category.setName(rs.getString("name"));
					category.setDescription(rs.getString("Description"));
					categories.add(category);
				}
				return categories;
			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	public Category getCategoryById(Long id) {

		return jdbcTemplate.query(SELECT_CATEGORY_BY_ID, new Object[] { id }, new ResultSetExtractor<Category>() {

			public Category extractData(ResultSet rs) throws SQLException {

				Category category = new Category();
				while (rs.next()) {
					category.setId(rs.getLong("id"));
					category.setName(rs.getString("name"));
					category.setDescription(rs.getString("Description"));
				}
				return category;
			}
		});
	}

}
