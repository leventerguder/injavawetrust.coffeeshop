package product.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.domain.Product;

@Repository
public class ProductRepositoryDAOImpl implements ProductRepositoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Product> getAllProductsAndCondiments() {
		Session session = getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product", Product.class);
		return query.getResultList();
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product where isCondiment = false", Product.class);
		return query.getResultList();
	}

	@Override
	public List<Product> getAllCondiments() {
		Session session = getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product where isCondiment = true", Product.class);
		return query.getResultList();
	}

	@Override
	public Product getProductById(int id) {
		Session session = getCurrentSession();
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		Session session = getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product p where p.category =:category", Product.class)
				.setParameter("category", category);
		return query.getResultList();
	}

	@Override
	public void addProduct(Product product) {
		Session session = getCurrentSession();
		session.persist(product);
	}

	@Override
	public void deleteProduct(int id) {
		Session session = getCurrentSession();
		Product p = (Product) session.get(Product.class, id);
		System.out.println(p);
		if (p != null) {
			session.delete(p);
		}

	}

	@Override
	public void updateProduct(Product product) {
		Session session = getCurrentSession();
		session.update(product);
	}

}
