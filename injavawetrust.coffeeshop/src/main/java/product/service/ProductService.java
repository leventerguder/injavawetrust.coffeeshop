package product.service;

import java.util.List;
import java.util.Map;

import product.domain.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public List<Product> getAllProductsAndCondiments();

	public Map<Integer, Product> getAllCondiments();

	public Product getProductById(int id);

	public List<Product> getProductsByCategory(String category);

	public void addProduct(Product product);

	public void deleteProduct(int id);

	public void updateProduct(Product product);

}
