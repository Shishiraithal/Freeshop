package freeshop.dao;

import java.util.List;

import freeshop.model.Entity;
import freeshop.model.Product;

public interface ShopDAO {
	
	void save(Entity obj);

	void delete(Entity obj);

	void update(Entity obj);

	Entity load(Entity obj);

	Entity findById(Class clazz, long id);

	List<?> findAll(Class clazz);
	
	List<Product> findProducByGroup(long id);
}
