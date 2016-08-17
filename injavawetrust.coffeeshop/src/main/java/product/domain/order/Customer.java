package product.domain.order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Customer {

	@TableGenerator(
			name = "CUSTOMER_GEN_DETAILED", 
			table = "CUSTOMER_ID_GEN", 
			pkColumnName = "ID_GEN_NAME", 
			valueColumnName = "ID_GEN_COUNT", 
			initialValue = 1, allocationSize = 10)
	@Id
	@GeneratedValue(generator = "CUSTOMER_GEN_DETAILED")
	private int id;

	private String customerName;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer() {
		super();
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

}
