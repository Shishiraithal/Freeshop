package freeshop.web.controller;

import java.util.List;

import freeshop.model.Product;
import freeshop.service.ShopService;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ShopController {
	
	private Result result;
	private ShopService service;
	
	public ShopController(Result result, ShopService service) {
		this.result = result;
		this.service = service;
	}

	@Path("/shop/")
	public void shop() {
		
		List<Product> prods = service.listProductsForHome();
		
		result.include("products", prods);
	}
}
