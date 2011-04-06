package freeshop.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import freeshop.model.Customer;
import freeshop.web.controller.ContentController;
import freeshop.web.controller.ShopController;

@Intercepts
@RequestScoped
public class LoginInterceptor implements Interceptor {

	private Result result;
	private HttpServletRequest req;
	
	public LoginInterceptor(Result result, HttpServletRequest req) {
		this.result = result;
		this.req = req;
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
		
		HttpSession session = req.getSession(false);
		if( session != null ) {
			Customer customer = (Customer) session.getAttribute("customer");
			result.include("customer", customer);
		}

		stack.next(method, resourceInstance);
	}

}
