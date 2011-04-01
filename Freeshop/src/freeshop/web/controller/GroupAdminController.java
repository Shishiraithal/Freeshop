package freeshop.web.controller;

import java.util.List;

import freeshop.model.ProductGroup;
import freeshop.service.AdminService;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class GroupAdminController {

	private Result result;
	
	private AdminService service;
	
	public GroupAdminController(Result result, AdminService service) {
        this.result = result;
		this.service = service;
	}

	@Path("/admin/groups")
	public void list() {
		
		List<ProductGroup> groups = service.findAllProductGroups();
		result.include("list", groups);
	}

	@Path("/admin/group")
	public void form() {
	}

	@Path({"/admin/group/{id}", "/admin/group/{id}/view"})
	public void view(long id) {
		
		ProductGroup group = service.findProductGroup(id);
		result.include("group", group);
	}

	@Path("/admin/group/{id}/edit")
	public void edit(long id) {
		
		ProductGroup group = service.findProductGroup(id);
		result.include("group", group);

		result.forwardTo(GroupAdminController.class).form();
	}

	@Path("/admin/group/save")
	public void save(ProductGroup group) {
		
		service.saveProductGroup(group);
		result.forwardTo(GroupAdminController.class).view(group.getId());
	}

	@Path("/admin/group/{id}/delete")
	public void delete(long id) {
		
		service.deleteProductGroup(id);
		result.forwardTo(GroupAdminController.class).list();
	}
}
