package product.dao;

import java.util.List;

import product.domain.Product;

public interface ProductRepositoryDAO {

	public List<Product> getAllProducts();

	public List<Product> getAllCondiments();

	public List<Product> getAllProductsAndCondiments();

	public Product getProductById(int productID);

	public List<Product> getProductsByCategory(String category);	

	public void addProduct(Product product);

	public void deleteProduct(int id);

	public void updateProduct(Product product);
		
}
