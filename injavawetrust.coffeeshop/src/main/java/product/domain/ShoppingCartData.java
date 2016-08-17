package product.domain;

import java.util.Map;
import java.util.TreeMap;

public class ShoppingCartData {

	private Map<Integer, TreeMap<Integer, Product>> shoppingCart;
	private Product product;
	private int orderIndexId;
	private int condimentId;
	private Map<Integer, Product> allCondimentsInShop;

	private ShoppingCartData(ShoppingCartDataBuilder builder) {
		this.shoppingCart = builder.shoppingCart;
		this.product = builder.product;
		this.orderIndexId = builder.orderIndexId;
		this.condimentId = builder.condimentId;
		this.allCondimentsInShop = builder.allCondimentsInShop;
	}

	public Map<Integer, TreeMap<Integer, Product>> getShoppingCart() {
		return shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public int getOrderIndexId() {
		return orderIndexId;
	}

	public int getCondimentId() {
		return condimentId;
	}

	public Map<Integer, Product> getAllCondimentsInShop() {
		return allCondimentsInShop;
	}

	public static class ShoppingCartDataBuilder {
		private Map<Integer, TreeMap<Integer, Product>> shoppingCart;
		private Product product;
		private int orderIndexId;
		private int condimentId;
		private Map<Integer, Product> allCondimentsInShop;

		public ShoppingCartDataBuilder(Map<Integer, TreeMap<Integer, Product>> shoppingCart, Product product) {
			this.shoppingCart = shoppingCart;
			this.product = product;
		}

		public ShoppingCartDataBuilder shoppingCart(Map<Integer, TreeMap<Integer, Product>> shoppingCart) {
			this.shoppingCart = shoppingCart;
			return this;
		}

		public ShoppingCartDataBuilder product(Product product) {
			this.product = product;
			return this;
		}

		public ShoppingCartDataBuilder orderIndexId(int orderIndexId) {
			this.orderIndexId = orderIndexId;
			return this;
		}

		public ShoppingCartDataBuilder condimentId(int condimentId) {
			this.condimentId = condimentId;
			return this;
		}

		public ShoppingCartDataBuilder allCondimentsInShop(Map<Integer, Product> allCondimentsInShop) {
			this.allCondimentsInShop = allCondimentsInShop;
			return this;
		}

		public ShoppingCartData build() {
			return new ShoppingCartData(this);
		}

	}

}
