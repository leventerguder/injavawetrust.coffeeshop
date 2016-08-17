package product.utility;

public interface URLs {

	public static final String MENU = "/menu";
	public static final String ALL = "/all";
	public static final String CATEGORY = "/{category}"; // URI template
	public static final String PRODUCT_DETAIL = "/product.detail";
	public static final String PRODUCT_ADD_TO_CART = "/product.add.to.cart";
	public static final String PRODUCT_DELETE_FROM_CART = "/product.delete.from.cart";
	public static final String PRODUCT_DELETE_ALL_CART = "/product.delete.all.cart";
	public static final String PRODUCT_ADD_CONDIMENT = "/product.add.condiment";
	public static final String PRODUCT_DELETE_CONDIMENT = "/product.delete.condiment";
	public static final String PRODUCT_SHOPPING_CART = "/product.shopping.cart";
	public static final String ORDER_DELETE_FROM_CART = "/order.delete.from.cart";

	public static final String DEFAULT_URL = "/";

	// CRUD menu
	public static final String ADMIN_LOGIN ="/login.admin";
	public static final String PRODUCT_ADD = "/product.add";
	public static final String PRODUCT_EDIT = "/product.edit";
	public static final String PRODUCT_UPDATE = "/product.update";
	public static final String PRODUCT_DELETE = "/product.delete";
	
	//PAYMENT
	public static final String ORDER_PAYMENT = "/order.payment";
	public static final String ORDER_PAYMENT_CONFIRM = "/order.payment.confirm";
	public static final String ORDER_PAYMENT_SUCCESS ="/order.payment.success";
	public static final String ORDER_LIST ="/order.list";
}
