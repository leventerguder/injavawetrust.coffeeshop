package product.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.dao.OrderDAO;
import product.domain.order.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAOImpl;

	@Transactional
	public void insertOrder(Order order) {
		orderDAOImpl.insertOrder(order);
	}

	@Override
	@Transactional
	public List<Order> getOrderList() {
		return orderDAOImpl.getOrderList();
	}

	@Override
	@Transactional
	public BigDecimal getOrdersTotalAmount() {
		return orderDAOImpl.getOrdersTotalAmount();
	}

	@Override
	@Transactional
	public List<Object[]> getOrdersTotalAmountByCustomerName() {
		return orderDAOImpl.getOrdersTotalAmountByCustomerName();
	}
}
