package product.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
public class Product implements ProductInterface {

	@TableGenerator(
			name = "PRODUCT_GEN_DETAILED", 
			table = "ID_GEN", 
			pkColumnName = "ID_GEN_NAME", 
			valueColumnName = "ID_GEN_COUNT", 
			initialValue = 100,
			allocationSize = 10)
	@Id
	@GeneratedValue(generator = "PRODUCT_GEN_DETAILED")
	private int id;
	private String name;
	private String description;
	
	private BigDecimal price;
	private boolean isCondiment;
	private String category;

	@Transient
	private Map<Product, Integer> condimentsInProduct = new LinkedHashMap<Product, Integer>();

	public Product() {
		super();
	}

	public Product(String name, String description, BigDecimal price, Map<Product, Integer> condimentsInProduct) {
		//TODO builder pattern
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.condimentsInProduct = condimentsInProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isCondiment() {
		return isCondiment;
	}

	public void setCondiment(boolean isCondiment) {
		this.isCondiment = isCondiment;
	}

	public Map<Product, Integer> getCondimentsInProduct() {
		return condimentsInProduct;
	}

	public void setCondimentsInProduct(Map<Product, Integer> condimentsInProduct) {
		this.condimentsInProduct = condimentsInProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
