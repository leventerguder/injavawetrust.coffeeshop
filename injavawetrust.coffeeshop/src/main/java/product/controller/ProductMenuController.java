package product.controller;

import static product.utility.URLs.ALL;
import static product.utility.URLs.CATEGORY;
import static product.utility.URLs.DEFAULT_URL;
import static product.utility.URLs.MENU;
import static product.utility.URLs.ORDER_DELETE_FROM_CART;
import static product.utility.URLs.PRODUCT_ADD_CONDIMENT;
import static product.utility.URLs.PRODUCT_ADD_TO_CART;
import static product.utility.URLs.PRODUCT_DELETE_ALL_CART;
import static product.utility.URLs.PRODUCT_DELETE_CONDIMENT;
import static product.utility.URLs.PRODUCT_DELETE_FROM_CART;
import static product.utility.URLs.PRODUCT_DETAIL;
import static product.utility.URLs.PRODUCT_SHOPPING_CART;
import static product.utility.ViewURLs.PRODUCT_DETAIL_VIEW;
import static product.utility.ViewURLs.PRODUCT_DETAIL_VIEW_REDIRECT;
import static product.utility.ViewURLs.PRODUCT_LIST_VIEW;
import static product.utility.ViewURLs.PRODUCT_SHOPPING_CART_VIEW;
import static product.utility.ViewURLs.PRODUCT_SHOPPING_CART_VIEW_REDIRECT;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import product.domain.Product;
import product.domain.ShoppingCartData;
import product.service.ProductCartService;
import product.service.ProductService;

@Controller
@RequestMapping(value = { MENU, DEFAULT_URL })
@SessionAttributes(value = { "product", "allCondimentsInShop", "shoppingCart" })

public class ProductMenuController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCartService productCartService;

	@ModelAttribute("shoppingCart")
	public void initializeShoppingCart(Model model) {

		Map<Integer, TreeMap<Integer, Product>> shoppingCart = new HashMap<Integer, TreeMap<Integer, Product>>();
		model.addAttribute("shoppingCart", shoppingCart);

	}

	@RequestMapping(value = { ALL, DEFAULT_URL }, method = RequestMethod.GET)
	public String listAllProducts(Model model) {

		model.addAttribute("products", productService.getAllProducts());
		return PRODUCT_LIST_VIEW;

	}

	@RequestMapping(value = CATEGORY, method = RequestMethod.GET)
	public String listAllProductsByCategory(@PathVariable("category") String productCategory, Model model) {

		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return PRODUCT_LIST_VIEW;

	}

	@RequestMapping(value = PRODUCT_DETAIL, method = RequestMethod.GET)
	public String getProductDetail(@RequestParam("productId") int productId, Model model) {

		Map<Integer, Product> allCondimentsInShop = productService.getAllCondiments();
		model.addAttribute("product", productService.getProductById(productId));
		model.addAttribute("allCondimentsInShop", allCondimentsInShop);
		return PRODUCT_DETAIL_VIEW;
	}

	@RequestMapping(value = PRODUCT_ADD_TO_CART, method = RequestMethod.GET)
	public String addProductToCart(@ModelAttribute("product") Product product,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		ShoppingCartData data = new ShoppingCartData.ShoppingCartDataBuilder(shoppingCart, product).build();
		productCartService.addProductToShoppingCart(data);

		return PRODUCT_DETAIL_VIEW_REDIRECT + product.getId();
	}

	@RequestMapping(value = PRODUCT_DELETE_FROM_CART, method = RequestMethod.GET)
	public String deleteProductFromCart(@RequestParam("indexId") int productIndexIdInShoppingCart,
			@ModelAttribute("product") Product product,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		ShoppingCartData data = new ShoppingCartData.ShoppingCartDataBuilder(shoppingCart, product)
				.orderIndexId(productIndexIdInShoppingCart).build();

		productCartService.deleteProductFromShoppingCart(data);

		return PRODUCT_DETAIL_VIEW_REDIRECT + product.getId();
	}

	@RequestMapping(value = PRODUCT_DELETE_ALL_CART, method = RequestMethod.GET)
	public String deleteAllProductFromCart(@ModelAttribute("product") Product product,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		ShoppingCartData data = new ShoppingCartData.ShoppingCartDataBuilder(shoppingCart, product).build();
		productCartService.deleteAllProductFromShoppingCartByProductId(data);

		return PRODUCT_DETAIL_VIEW_REDIRECT + product.getId();
	}

	@RequestMapping(value = PRODUCT_ADD_CONDIMENT, method = RequestMethod.GET)
	public String addNewCondimentToProduct(@RequestParam("indexId") int orderIndexId,
			@RequestParam("condimentId") int condimentId, @ModelAttribute("product") Product product,
			@ModelAttribute("allCondimentsInShop") Map<Integer, Product> allCondimentsInShop,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		ShoppingCartData data = new ShoppingCartData.ShoppingCartDataBuilder(shoppingCart, product)
				.orderIndexId(orderIndexId).allCondimentsInShop(allCondimentsInShop).condimentId(condimentId).build();

		productCartService.addCondimentToProductInShoppingCart(data);

		return PRODUCT_DETAIL_VIEW_REDIRECT + product.getId();
	}

	@RequestMapping(value = PRODUCT_DELETE_CONDIMENT, method = RequestMethod.GET)
	public String deleteCondimentFromProduct(@RequestParam("indexId") int orderIndexId,
			@RequestParam("condimentId") int condimentId, @ModelAttribute("product") Product product,
			@ModelAttribute("allCondimentsInShop") Map<Integer, Product> allCondimentsInShop,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		ShoppingCartData data = new ShoppingCartData.ShoppingCartDataBuilder(shoppingCart, product)
				.orderIndexId(orderIndexId).allCondimentsInShop(allCondimentsInShop).condimentId(condimentId).build();

		productCartService.deleteCondimentFromProductInShoppingCart(data);

		return PRODUCT_DETAIL_VIEW_REDIRECT + product.getId();
	}

	@RequestMapping(value = PRODUCT_SHOPPING_CART, method = RequestMethod.GET)
	public String goToShoppingCart(@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart,
			Model model, final RedirectAttributes redirectAttributes) {

		TreeMap<Integer, BigDecimal> calculatedPrices = productCartService
				.calculateProductsSumByIdInShoppingCart(shoppingCart);

		BigDecimal totalAll = productCartService.calculateProductsSumAllInShoppingCart(calculatedPrices);

		Map<Integer, Product> products = new HashMap<Integer, Product>();

		for (Product product : productService.getAllProducts()) {
			products.put(product.getId(), product);
		}

		model.addAttribute("products", products);
		model.addAttribute("calculatedPrices", calculatedPrices);
		model.addAttribute("totalAll", totalAll);
		model.addAttribute("reducedPrice", productCartService.calculateDiscount(shoppingCart));
		return PRODUCT_SHOPPING_CART_VIEW;
	}

	@RequestMapping(value = ORDER_DELETE_FROM_CART, method = RequestMethod.GET)
	public String deleteOrderFromCart(@RequestParam("productId") int productId,
			@ModelAttribute("shoppingCart") Map<Integer, TreeMap<Integer, Product>> shoppingCart) {

		shoppingCart.remove(productId);

		return PRODUCT_SHOPPING_CART_VIEW_REDIRECT;
	}

}
