package freeshop.web.interceptor;

import java.util.List;

import freeshop.model.Content;
import freeshop.model.ProductGroup;
import freeshop.service.AdminService;
import freeshop.service.ShopService;
import freeshop.web.controller.ContentController;
import freeshop.web.controller.ShopController;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class MenuInterceptor implements Interceptor {

	private Result result;
	private ShopService service;
	private AdminService adminService;
	
	public MenuInterceptor(Result result, ShopService service, AdminService adminService) {
		this.result = result;
		this.service = service;
		this.adminService = adminService;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		if( method.getResource().getType() == ShopController.class ||
				method.getResource().getType() == ContentController.class ) {
			return true;
		}
		return false;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		
		List<Content> items = adminService.findAllContents();
		result.include("MenuItems", items);
		
		List<ProductGroup> groups = service.listProductGroups();
		result.include("MenuProdGroups", groups);

		stack.next(method, resourceInstance);
	}

}
