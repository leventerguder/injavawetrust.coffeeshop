package product.utility;

public interface ViewURLs {

	public static final String PRODUCT_LIST_VIEW = "product.views/productList";
	public static final String PRODUCT_DETAIL_VIEW = "product.views/productDetail";
	public static final String PRODUCT_DETAIL_VIEW_REDIRECT = "redirect:/menu/product.detail?productId=";
	public static final String PRODUCT_SHOPPING_CART_VIEW = "product.views/shoppingCart";
	public static final String PRODUCT_SHOPPING_CART_VIEW_REDIRECT = "redirect:/menu/product.shopping.cart";	
	
	public static final String PRODUCT_ADD_VIEW="product.views/addProduct";
	public static final String PRODUCT_ADD_VIEW_REDIRECT="redirect:/product.add";
	
	public static final String ORDER_PAYMENT_FORM_VIEW = "product.views/paymentForm";
	public static final String ORDER_PAYMENT_VIEW_SUCCESS ="product.views/paymentSuccess";
	public static final String ORDER_PAYMENT_VIEW_SUCCESS_REDIRECT ="redirect:/order.payment.success";
	
	public static final String ORDER_LIST_VIEW="product.views/orderList";
	
}
