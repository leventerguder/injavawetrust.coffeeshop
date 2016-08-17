package product.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import product.domain.CondimentDecorator;
import product.domain.Product;
import product.domain.ShoppingCartData;

@Service
public class ProductCartServiceImpl implements ProductCartService {

	@Override
	public void addProductToShoppingCart(ShoppingCartData data) {

		TreeMap<Integer, Product> productMap = data.getShoppingCart().get(data.getProduct().getId());
		if (productMap == null) {
			productMap = new TreeMap<Integer, Product>();
		}

		int count = 0;
		if (productMap.size() > 0) {
			count = productMap.lastKey();
		}

		productMap.put(++count, data.getProduct());
		data.getShoppingCart().put(data.getProduct().getId(), productMap);

	}

	public TreeMap<Integer, BigDecimal> calculateProductsSumByIdInShoppingCart(
			Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		TreeMap<Integer, BigDecimal> sumByProductId = new TreeMap<Integer, BigDecimal>();

		for (Map.Entry<Integer, TreeMap<Integer, Product>> productsByIds : shoppingCart.entrySet()) {

			BigDecimal totalPriceByProductId = new BigDecimal(0);

			TreeMap<Integer, Product> mapByProductId = productsByIds.getValue();

			for (Map.Entry<Integer, Product> entry : mapByProductId.entrySet()) {
				totalPriceByProductId = totalPriceByProductId.add(entry.getValue().getPrice());
				sumByProductId.put(productsByIds.getKey(), totalPriceByProductId);
			}

		}

		for (Map.Entry<Integer, BigDecimal> abc : sumByProductId.entrySet()) {
			System.out.println("product id : " + abc.getKey() + " total : " + abc.getValue());
		}

		return sumByProductId;

	}

	public BigDecimal calculateProductsSumAllInShoppingCart(TreeMap<Integer, BigDecimal> sumByProductId) {

		BigDecimal total = new BigDecimal(0);

		for (Map.Entry<Integer, BigDecimal> entry : sumByProductId.entrySet()) {
			total = total.add(entry.getValue());
		}

		return total;
	}

	@Override
	public BigDecimal calculateDiscount(Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		List<BigDecimal> priceList = new ArrayList<BigDecimal>();

		BigDecimal totalPrice = new BigDecimal(0);

		for (Map.Entry<Integer, TreeMap<Integer, Product>> productsByIds : shoppingCart.entrySet()) {

			TreeMap<Integer, Product> mapByProductId = productsByIds.getValue();

			for (Map.Entry<Integer, Product> entry : mapByProductId.entrySet()) {

				Product product = entry.getValue();
				totalPrice = totalPrice.add(product.getPrice());
				priceList.add(product.getPrice());

			}

		}

		BigDecimal reducedPriceByProductCount = totalPrice; // default total
															// price
		
		//TODO , make it dynamic by properties
		if (priceList.size() >= 3) {
			BigDecimal minimumPriceInShoppingCart = Collections.min(priceList);
			reducedPriceByProductCount = totalPrice.subtract(minimumPriceInShoppingCart);
		}
		
		BigDecimal reducedPriceByPercentage = totalPrice; // detault total price
		if (totalPrice.compareTo(new BigDecimal(12)) > 0) {
			BigDecimal remainder = totalPrice.divide(new BigDecimal(4));
			reducedPriceByPercentage = totalPrice.subtract(remainder);
		}

		if (reducedPriceByPercentage.compareTo(reducedPriceByProductCount) < 0) {
			return reducedPriceByPercentage;
		} else {
			return reducedPriceByProductCount;
		}
	}

	@Override
	public void deleteProductFromShoppingCart(ShoppingCartData data) {
		TreeMap<Integer, Product> productMap = data.getShoppingCart().get(data.getProduct().getId());
		productMap.remove(data.getOrderIndexId());

	}

	@Override
	public void deleteAllProductFromShoppingCartByProductId(ShoppingCartData data) {
		data.getShoppingCart().remove(data.getProduct().getId());
	}

	public void addCondimentToProductInShoppingCart(ShoppingCartData data) {

		TreeMap<Integer, Product> productMap = data.getShoppingCart().get(data.getProduct().getId());
		Product selectedProductForCondimentProcess = productMap.get(data.getOrderIndexId());

		Product condiment = data.getAllCondimentsInShop().get(data.getCondimentId());

		selectedProductForCondimentProcess = new CondimentDecorator(selectedProductForCondimentProcess,
				condiment.getName(), condiment.getDescription(), condiment.getPrice(),
				selectedProductForCondimentProcess.getCondimentsInProduct());

		Map<Product, Integer> map = selectedProductForCondimentProcess.getCondimentsInProduct();

		Integer count = map.get(condiment);

		if (count == null) {
			count = 0;
		}

		selectedProductForCondimentProcess.getCondimentsInProduct().put(condiment, ++count);

		productMap.put(data.getOrderIndexId(), selectedProductForCondimentProcess);

	}

	@Override
	public void deleteCondimentFromProductInShoppingCart(ShoppingCartData data) {

		TreeMap<Integer, Product> productMap = data.getShoppingCart().get(data.getProduct().getId());
		Product selectedProductForCondimentProcess = productMap.get(data.getOrderIndexId());

		Product condiment = data.getAllCondimentsInShop().get(data.getCondimentId());

		Map<Product, Integer> map = selectedProductForCondimentProcess.getCondimentsInProduct();

		Integer count = map.get(condiment);

		selectedProductForCondimentProcess = new CondimentDecorator(selectedProductForCondimentProcess,
				condiment.getName(), condiment.getDescription(),
				(condiment.getPrice().multiply(new BigDecimal(count)).negate()),
				selectedProductForCondimentProcess.getCondimentsInProduct());

		selectedProductForCondimentProcess.getCondimentsInProduct().remove(condiment);

		productMap.put(data.getOrderIndexId(), selectedProductForCondimentProcess);

	}

}
