package product.domain;

import java.math.BigDecimal;
import java.util.Map;

public class CondimentDecorator extends Product {

	private ProductInterface productInterface;

	public CondimentDecorator(ProductInterface beverage, String name, String description, BigDecimal price,
			Map<Product, Integer> condimentsInProduct) {
		super(name, description, price, condimentsInProduct);
		this.productInterface = beverage;
	}

	public String getName() {
		return this.productInterface.getName() + ", " + super.getName();
	}

	@Override
	public BigDecimal getPrice() {
		return super.getPrice().add(this.productInterface.getPrice());
	}

	@Override
	public String toString() {
		return this.getName() + " = " + this.getPrice();
	}

}
