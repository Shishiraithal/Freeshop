package freeshop.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import freeshop.exception.CEPInvalidoException;
import freeshop.exception.CustomerAlreadyExistsException;
import freeshop.exception.CustomerNotFoundException;
import freeshop.exception.InvalidPasswordException;
import freeshop.i18n.I18nMessages;
import freeshop.model.Cart;
import freeshop.model.Customer;
import freeshop.model.Product;
import freeshop.model.ProductGroup;
import freeshop.service.ShopService;

@Resource
public class ShopController {

	private HttpServletRequest req;
	private Result result;
	private I18nMessages i18n;
	
	private ShopService service;
	
	public ShopController(HttpServletRequest req, Result result, I18nMessages i18n, ShopService service) {
		this.req = req;
		this.result = result;
		this.i18n = i18n;
		
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

	@Path("/shop/tag/{tag}")
	public void shop(String tag) {

		List<Product> prods = service.findProductsByTag(tag);
		result.include("products", prods);
	}

	@Path({"/shop/product/{id}","/shop/product/{id}/*"})
	public void product(long id) {

		Product prod = service.findProduct(id);
		result.include("prod", prod);
		
		List<Product> prods = service.findProductsRelatedByTags( prod.getTags() );
		result.include("products", prods);
	}

	@Path("/shop/register")
	public void register() {
	}

	@Path("/shop/signon")
	public void register(Customer costumer) {
		
		System.out.println(costumer.getEmail()+", "+costumer.getPassword()+", "+costumer.getName());
		
		try {
			service.registerCustomer(costumer);

			result.forwardTo(this.getClass()).shop();
			
		} catch (CustomerAlreadyExistsException e) {
			String msg = i18n.i18n("msg.customer.already.exists");
			result.include("error", msg);
		}
	}

	@Path("/shop/login")
	public void login(String email, String password, String lostPassword) {
		
		System.out.println(email+", "+password+", "+lostPassword);
		
		if( email==null || email.trim().length()<=0 ) {
			String msg = i18n.i18n("msg.email.mandatory");
			result.include("error", msg);
			
		} else {

			if( lostPassword!=null && lostPassword.trim().length()>0 ) {
				// Lost password
				Customer costumer = service.findCustomerByEmail(email);
				if( costumer==null ) {
					String msg = i18n.i18n("msg.login.user.not.found");
					result.include("error", msg);
					
				} else {
					//TODO: send email with new password...
				}
				
			} else {
				// Login
				try {
					Customer costumer = service.login(email, password);
					storeCostumer(costumer);
					
				} catch (CustomerNotFoundException e) {
					String msg = i18n.i18n("msg.login.user.not.found");
					result.include("error", msg);
					
				} catch (InvalidPasswordException e) {
					String msg = i18n.i18n("msg.login.invalid.pwd");
					result.include("error", msg);
				}
			}
		}

		result.forwardTo(this.getClass()).register();
	}

	@Path("/shop/cart/cep")
	public void cep(long cep) {
		
		Cart cart = getCart();
		if( cart != null ) {
			cart.setCep(cep);
			
			Double frete = null;
			try {
				frete = service.calcularFrete(cep);

			} catch (CEPInvalidoException e) {
				frete = null;
				cart.setCep(null);
				
				String msg = i18n.i18n("cep.frete.invalido");
				result.include("error", msg);
			}
			cart.setFrete(frete);
		}

		result.forwardTo(this.getClass()).cart();
	}

	@Path("/shop/cart")
	public void cart() {
		
		Cart cart = getCart();
		if( cart != null ) {
			result.include("cart", cart);
		}
	}

	@Path("/shop/add/{id}")
	public void add(long id) {
		
		Cart cart = getCart();
		if( cart == null ) {
			cart = createCart();
		}
		
		Product prod = service.findProduct(id);
		cart.add( prod );

		result.forwardTo(this.getClass()).cart();
	}

	@Path("/shop/remove/{id}")
	public void remove(long id) {
		
		Cart cart = getCart();
		if( cart != null ) {
			Product prod = service.findProduct(id);
			cart.remove( prod );
		}

		result.forwardTo(this.getClass()).cart();
	}

	@Path("/shop/exclude/{id}")
	public void exclude(long id) {
		
		Cart cart = getCart();
		if( cart != null ) {
			Product prod = service.findProduct(id);
			cart.exclude( prod );
		}

		result.forwardTo(this.getClass()).cart();
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
	
	private Customer getCostumer() {
		HttpSession session = req.getSession(false);
		if( session == null ) {
			return null;
		}
		Customer customer = (Customer) session.getAttribute("customer");
		return customer;
	}
	
	private void storeCostumer(Customer customer) {
		HttpSession session = req.getSession(true);
		session.setAttribute("customer", customer);
	}
}
