package freeshop.controller;

import java.util.List;

import freeshop.model.Product;
import freeshop.model.ProductGroup;
import freeshop.service.AdminService;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProductAdminController {

	private Result result;
	
	private AdminService service;
	
	public ProductAdminController(Result result, AdminService service) {
        this.result = result;
		this.service = service;
	}

	@Path("/admin/products")
	public void list() {
		
		List<Product> prods = service.findAllProducts();
		result.include("list", prods);
	}

	@Path("/admin/product")
	public void form() {
		
		List<ProductGroup> groups = service.findAllProductGroups();
		result.include("groups", groups);
	}

	@Path({"/admin/product/{id}", "/admin/product/{id}/view"})
	public void view(long id) {
		
		Product prod = service.findProduct(id);
		result.include("product", prod);
	}

	@Path("/admin/product/{id}/edit")
	public void edit(long id) {
		
		Product prod = service.findProduct(id);
		result.include("product", prod);

		result.forwardTo(ProductAdminController.class).form();
	}

	@Path("/admin/product/save")
	public void save(Product product) {
		
		service.saveProduct(product);
		result.forwardTo(ProductAdminController.class).view(product.getId());
	}

	@Path("/admin/product/{id}/delete")
	public void delete(long id) {
		
		service.deleteProduct(id);
		result.forwardTo(ProductAdminController.class).list();
	}
}
