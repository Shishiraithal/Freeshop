package freeshop.service;

import java.util.List;

import freeshop.dao.ShopDAO;
import freeshop.model.Entity;
import freeshop.model.Product;
import freeshop.model.ProductGroup;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class AdminService {

	private ShopDAO dao;
	
	public AdminService(ShopDAO dao) {
		this.dao = dao;
	}
	
	/* ********************************************************* */

	public void saveProduct(Product product) {
		saveEntity(product);
	}

	public void deleteProduct(long id) {
		Product product = new Product();
		product.setId(id);
		deleteProduct(product);
	}

	public void deleteProduct(Product product) {
        dao.delete(product);
	}
	
	public Product findProduct(long id) {
		return findEntityById(Product.class, id);
		//return (Product) dao.findById(Product.class, id);
	}
	
	public List<Product> findAllProducts() {
		return findAllEntities(Product.class);
		//return (List<Product>) dao.findAll(Product.class);
	}
	
	/* ********************************************************* */

	public void saveProductGroup(ProductGroup group) {
		saveEntity(group);
	}

	public void deleteProductGroup(long id) {
		ProductGroup group = new ProductGroup();
		group.setId(id);
		deleteProductGroup(group);
	}

	public void deleteProductGroup(ProductGroup group) {
        dao.delete(group);
	}
	
	public ProductGroup findProductGroup(long id) {
		return findEntityById(ProductGroup.class, id);
		//return (ProductGroup) dao.findById(ProductGroup.class, id);
	}
	
	public List<ProductGroup> findAllProductGroups() {
		return findAllEntities(ProductGroup.class);
		//return (List<ProductGroup>) dao.findAll(ProductGroup.class);
	}
	
	/* ********************************************************* */
	
	private void saveEntity(Entity entity) {
        if( entity.getId() == null ) {
        	dao.save(entity);
        
        } else {
        	dao.update(entity);
        }
	}
	
	private <T extends Entity> T findEntityById(Class<T> clazz, long id) {
		return (T) dao.findById(clazz, id);
	}
	
	private <T extends Entity> List<T> findAllEntities(Class<T> clazz) {
		return (List<T>) dao.findAll(clazz);
	}
}
