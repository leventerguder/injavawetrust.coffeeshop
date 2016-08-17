package product.service;

import java.math.BigDecimal;
import java.util.List;

import product.domain.order.Order;

public interface OrderService {
	
	public void insertOrder(Order order);
	
	public List<Order> getOrderList();
	
	public BigDecimal getOrdersTotalAmount();
	
	public List<Object[]> getOrdersTotalAmountByCustomerName();
}
