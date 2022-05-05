package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import model.Product;
public class ProductDaoImpl implements ProductDao {
	private static final String SELECT_ALL_PRODUCT = "select * from products";
	private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?";
	private static final String DELETE_PRODUCT_BY_ID = "delete product where id = ?";
	private static final String UPDATE_PRODUCT_BY_ID = "update products set name = ?, title = ?, description = ?, target_date = ? where id = ?";
	@Override
	public Product selectProductById(long productId) {
		Product product = null;
		try {
			Connection connection = DBConnection.GET_CONNECTION();
			PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
			ps.setLong(1, productId);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				String name = rs.getString("name");
				String description = rs.getString("description");
				boolean isDone = rs.getBoolean("is_done");
				product = new Product(id, title, name, description, targetDate, isDone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public List<Product> selectAllProduct(){
		List<Product> product = new ArrayList<Product>();;
		try {
			Connection connection = DBConnection.GET_CONNECTION();
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCT);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String name = rs.getString("name");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				product.add(new Product(id, title, name, description, targetDate, isDone));
			}
		} catch (Exception e) {
				e.printStackTrace();
			}
			return product;
		}
	
	@Override
	public boolean deleteProduct(int productId) throws SQLException{
		boolean rowDeleted = false;
		try {
			Connection connection = DBConnection.GET_CONNECTION();
			PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
			ps.setLong(1,  productId);
			System.out.println(ps);
			rowDeleted = ps.executeUpdate() > 0;
			return rowDeleted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	@Override
	public boolean updateProduct(Product product) throws SQLException {
		boolean rowUpdate = false;
		try {
			Connection connection = DBConnection.GET_CONNECTION();
			PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
			ps.setString(1, product.getName());
			ps.setString(2, product.getTitle());
			ps.setString(3,  product.getDescription());
			ps.setDate(4, java.sql.Date.valueOf(product.getTargetDate()));
			ps.setFloat(5,  product.getId());
			System.out.println(ps);
			rowUpdate = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdate;
	}
}


