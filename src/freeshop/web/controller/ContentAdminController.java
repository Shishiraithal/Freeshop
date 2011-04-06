package freeshop.web.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import freeshop.model.Content;
import freeshop.service.AdminService;

@Resource
public class ContentAdminController {

	private Result result;
	
	private AdminService service;
	
	public ContentAdminController(Result result, AdminService service) {
        this.result = result;
		this.service = service;
	}

	@Path("/admin/contents")
	public void list() {
		
		List<Content> content = service.findAllContents();
		result.include("list", content);
	}

	@Path("/admin/content")
	public void form() {
	}

	@Path({"/admin/content/{id}", "/admin/content/{id}/view"})
	public void view(long id) {
		
		Content content = service.findContent(id);
		result.include("content", content);
	}

	@Path("/admin/content/{id}/edit")
	public void edit(long id) {
		
		Content content = service.findContent(id);
		result.include("content", content);

		result.forwardTo(this.getClass()).form();
	}

	@Path("/admin/content/save")
	public void save(Content content) {
		
		service.saveContent(content);
		result.forwardTo(this.getClass()).view(content.getId());
	}

	@Path("/admin/content/{id}/delete")
	public void delete(long id) {
		
		service.deleteContent(id);
		result.forwardTo(this.getClass()).list();
	}
}
