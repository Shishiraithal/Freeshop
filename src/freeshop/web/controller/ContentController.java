package freeshop.web.controller;

import freeshop.model.Content;
import freeshop.service.AdminService;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ContentController {

	private Result result;
	
	private AdminService service;

	public ContentController(Result result, AdminService service) {
        this.result = result;
		this.service = service;
	}

	@Path("/page/{page}")
	public void content(String page) {
		
		Content content = service.findContentByName(page);
		result.include("content", content);
	}
}
