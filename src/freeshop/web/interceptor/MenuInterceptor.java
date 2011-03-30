package freeshop.web.interceptor;

import java.util.List;

import freeshop.model.ProductGroup;
import freeshop.service.ShopService;
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
	
	public MenuInterceptor(Result result, ShopService service) {
		this.result = result;
		this.service = service;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		if( method.getResource().getType() == ShopController.class ) {
			return true;
		}
		return false;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		
		List<ProductGroup> groups = service.listProductGroups();
		result.include("MenuGroups", groups);

		stack.next(method, resourceInstance);
	}

}
