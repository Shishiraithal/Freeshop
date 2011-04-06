package freeshop.service;

import java.util.List;

import freeshop.dao.ShopDAO;
import freeshop.model.Content;
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
		/*
		ProductGroup group = product.getGroup();
		group = (ProductGroup) dao.load(group);
		product.setGroup(group);
		*/
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
		Product prod = findEntityById(Product.class, id);
		ProductGroup group = findEntityById(ProductGroup.class, prod.getIdGroup());
		prod.setGroup(group);
		return prod;
	}
	
	public List<Product> findAllProducts() {
		return findAllEntities(Product.class);
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
	}
	
	public List<ProductGroup> findAllProductGroups() {
		return findAllEntities(ProductGroup.class);
	}
	
	/* ********************************************************* */

	public void saveContent(Content content) {
		saveEntity(content);
	}

	public void deleteContent(long id) {
		Content content = new Content();
		content.setId(id);
		deleteContent(content);
	}

	public void deleteContent(Content content) {
        dao.delete(content);
	}
	
	public Content findContent(long id) {
		return findEntityById(Content.class, id);
	}
	
	public List<Content> findAllContents() {
		return findAllEntities(Content.class);
	}
	
	public List<String> findAllContentNames() {
		return dao.findAllContentNames();
	}
	
	public Content findContentByName(String name) {
		return dao.findContentByName(name);
	}
	
	/* ********************************************************* */
	
	private void saveEntity(Entity entity) {
        if( entity.getId() == null ) {
        	dao.save(entity);
        
        } else {
        	dao.update(entity);
        }
	}
	
	private <T extends Entity> T findEntityById(Class<T> clazz, Long id) {
		if( id == null ) {
			return null;
		}
		return (T) dao.findById(clazz, id);
	}
	
	private <T extends Entity> List<T> findAllEntities(Class<T> clazz) {
		return (List<T>) dao.findAll(clazz);
	}
}
