package dao;

import java.sql.SQLException;
import java.util.List;
import model.Product;

public interface ProductDao {
	Product selectProductById(long productId);
	List<Product> selectAllProduct();
	boolean deleteProduct(int id) throws SQLException;
	boolean updateProduct(Product product) throws SQLException;
}
