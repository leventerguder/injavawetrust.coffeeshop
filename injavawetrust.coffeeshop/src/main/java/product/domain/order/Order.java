package product.domain.order;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;


@Entity(name = "CustomerOrder")
public class Order {

	@TableGenerator(
			name = "ORDER_GEN_DETAILED", 
			table = "ORDER_ID_GEN", 
			pkColumnName = "ID_GEN_NAME", 
			valueColumnName = "ID_GEN_COUNT", 
			initialValue = 1, 
			allocationSize = 10)
	@Id
	@GeneratedValue(generator = "ORDER_GEN_DETAILED")
	private int id;

	private BigDecimal amount;

	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", customer=" + customer + "]";
	}

}
