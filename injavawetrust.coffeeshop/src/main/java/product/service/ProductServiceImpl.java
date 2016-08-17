package product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.dao.ProductRepositoryDAO;
import product.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositoryDAO productRepository;

	@Transactional
	@Override
	public List<Product> getAllProductsAndCondiments() {
		return productRepository.getAllProductsAndCondiments();
	}

	@Transactional
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Transactional
	@Override
	public Map<Integer, Product> getAllCondiments() {

		List<Product> results = productRepository.getAllCondiments();

		Map<Integer, Product> map = new HashMap<Integer, Product>();
		for (Product product : results) {
			map.put(product.getId(), product);
		}
		return map;

	}

	@Transactional
	@Override
	public Product getProductById(int productID) {
		return productRepository.getProductById(productID);
	}

	@Transactional
	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Transactional
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productRepository.deleteProduct(id);

	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productRepository.updateProduct(product);
	}

}
