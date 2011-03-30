package freeshop.web.conf;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Component
public class RefscallPathResolver extends DefaultPathResolver {

	public RefscallPathResolver(FormatResolver resolver) {
		super(resolver);
	}
    
    @Override
    protected String extractControllerFromName(String baseName) {
		
		String name = null;
		
		// muda o path do JSP (view) para os controllers administrativos (ex: "admin/product")
		if( baseName.endsWith("AdminController") && !baseName.equals("AdminController") ) {
			
			name = baseName.substring(0,baseName.length()-15).toLowerCase();
			name = "admin/" + name;
			
		} else {
		
			name = super.extractControllerFromName(baseName);
		}
        
		//System.out.println("extractControllerFromName() : "+name);
        return name;
    }
}
