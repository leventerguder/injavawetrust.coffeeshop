package product.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import product.domain.order.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertOrder(Order order) {
		Session session = getCurrentSession();
		session.persist(order);
	}

	@Override
	public List<Order> getOrderList() {
		Session session = getCurrentSession();
		TypedQuery<Order> query = session.createQuery("from CustomerOrder", Order.class);
		return query.getResultList();

	}

	@Override
	public BigDecimal getOrdersTotalAmount() {
		Session session = getCurrentSession();
		TypedQuery<BigDecimal> query = session.createQuery("Select sum(o.amount) from CustomerOrder o",
				BigDecimal.class);
		return query.getSingleResult();
	}

	public List<Object[]> getOrdersTotalAmountByCustomerName() {
		Session session = getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(
				"Select o.customer.customerName , sum(o.amount) from CustomerOrder o group by o.customer.customerName",
				Object[].class);
		return query.getResultList();
	}
}
