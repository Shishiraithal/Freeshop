package freeshop.dao;

import java.util.List;

import freeshop.model.Content;
import freeshop.model.Customer;
import freeshop.model.Entity;
import freeshop.model.Product;

public interface ShopDAO {
	
	void save(Entity obj);

	void delete(Entity obj);

	void update(Entity obj);

	Entity load(Entity obj);

	<T extends Entity> T findById(Class<T> clazz, long id);

	<T extends Entity> List<T> findAll(Class<T> clazz);
	
	List<Product> findProductByGroup(long id);
	
	List<Product> findProductByTag(String tag);
	
	List<Product> findProductByTags(List<String> tags);
	
	List<String> findAllContentNames();
	
	Content findContentByName(String name);
	
	Customer findCustomerByEmail(String email);
}
