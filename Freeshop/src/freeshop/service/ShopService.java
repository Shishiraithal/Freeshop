package freeshop.service;

import java.util.List;

import freeshop.dao.ShopDAO;
import freeshop.model.Product;
import freeshop.model.ProductGroup;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ShopService {

	private ShopDAO dao;
	
	public ShopService(ShopDAO dao) {
		this.dao = dao;
	}
	
	public List<Product> listProductsForHome() {
		return (List<Product>) dao.findAll(Product.class);
	}
	
	public List<Product> listProductsByGroup(long id) {
		return (List<Product>) dao.findProducByGroup(id);
	}
	
	public Product findProduct(long id) {
		return (Product) dao.findById(Product.class, id);
	}
	
	public List<ProductGroup> listProductGroups() {
		return (List<ProductGroup>) dao.findAll(ProductGroup.class);
	}
	
	public ProductGroup findProductGroup(long id) {
		return (ProductGroup) dao.findById(ProductGroup.class, id);
	}
}
