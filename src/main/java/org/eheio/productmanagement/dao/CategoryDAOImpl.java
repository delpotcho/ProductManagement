package org.eheio.productmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eheio.productmanagement.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String SELECT_CATEGORY_BY_ID = "select id, Name, Description, from productmanagement.category, where id =?;";
	final String SELECT_ALL_CATEGORIES = "select * from productmanagement.category;";

	final String INSERT_QUERY = "INSERT INTO productmanagement.category (Name, Description) VALUES  (?, ?);";
	final String UPDATE_QUERY = "update productmanagement.category set Name = ?, Description = ? where id = ?;";
	final String DELETE_QUERY = "delete from productmanagement.category where id = ?;";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int CreateCategory(Category category) {
		return jdbcTemplate.update(INSERT_QUERY, category.getName(), category.getDescription());
	}

	@Override
	public void UpdateCategory(Category category) {
		jdbcTemplate.update(UPDATE_QUERY, category.getName(), category.getDescription(), category.getId());
	}

	@Override
	public void DeleteCategory(Category category) {
		jdbcTemplate.update(DELETE_QUERY, category.getId());

	}

	@Override
	public List<Category> getAllCategories() {
		
		return jdbcTemplate.query(SELECT_ALL_CATEGORIES, new ResultSetExtractor<List<Category>>() {

			public List<Category> extractData(ResultSet rs) throws SQLException {
				List<Category> categories = new ArrayList<Category>();
				while (rs.next()) {
					Category category = new Category();
					category.setId(rs.getLong("p.id"));
					category.setName(rs.getString("p.name"));
					category.setDescription(rs.getString("p.Description"));
					categories.add(category);
				}
				return categories;
			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	public Category getCategoryById(Long id) {

		return jdbcTemplate.query(SELECT_CATEGORY_BY_ID, new Object[] {id}, new ResultSetExtractor<Category>() {

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
