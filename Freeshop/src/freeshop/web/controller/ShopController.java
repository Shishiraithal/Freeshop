package freeshop.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import freeshop.model.Cart;
import freeshop.model.Product;
import freeshop.model.ProductGroup;
import freeshop.service.ShopService;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ShopController {

	private HttpServletRequest req;
	private Result result;
	private ShopService service;
	
	public ShopController(HttpServletRequest req, Result result, ShopService service) {
		this.req = req;
		this.result = result;
		this.service = service;
	}

	@Path("/shop/")
	public void shop() {
		
		List<Product> prods = service.listProductsForHome();
		
		result.include("products", prods);
	}

	@Path("/shop/{id}")
	public void shop(long id) {

		ProductGroup group = service.findProductGroup(id);
		List<Product> prods = service.listProductsByGroup(id);

		result.include("group", group);
		result.include("products", prods);
	}

	@Path("/shop/product/{id}")
	public void product(long id) {

		Product prod = service.findProduct(id);

		result.include("prod", prod);
	}

	@Path("/shop/cart")
	public void cart() {
		
		Cart cart = getCart();
		if( cart == null ) {
			cart = createCart();
		}
		
		result.include("cart", cart);
	}

	@Path("/shop/add/{id}")
	public void add(long id) {
		
		Cart cart = getCart();
		if( cart == null ) {
			cart = createCart();
		}
		
		Product prod = service.findProduct(id);
		cart.add( prod );

		result.forwardTo(ShopController.class).cart();
	}

	@Path("/shop/remove/{id}")
	public void remove(long id) {
		
		Cart cart = getCart();
		if( cart != null ) {
			Product prod = service.findProduct(id);
			cart.remove( prod );
		}

		result.forwardTo(ShopController.class).cart();
	}

	@Path("/shop/exclude/{id}")
	public void exclude(long id) {
		
		Cart cart = getCart();
		if( cart != null ) {
			Product prod = service.findProduct(id);
			cart.exclude( prod );
		}

		result.forwardTo(ShopController.class).cart();
	}
	
	private Cart getCart() {
		HttpSession session = req.getSession(false);
		if( session == null ) {
			return null;
		}
		Cart cart = (Cart) session.getAttribute("cart");
		return cart;
	}
	
	private Cart createCart() {
		HttpSession session = req.getSession(true);
		Cart cart = new Cart();
		session.setAttribute("cart", cart);
		return cart;
	}
}
