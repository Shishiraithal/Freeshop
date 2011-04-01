package freeshop.dao.gae;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import freeshop.dao.ShopDAO;
import freeshop.model.Entity;
import freeshop.model.Product;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ShopGaeJpaDAO implements ShopDAO {
	
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_STORE = new ThreadLocal<EntityManager>();

	public static void setEntityManager(EntityManager em) {
		ENTITY_MANAGER_STORE.set(em);
	}
	
	public static void resetEntityManager() {
		setEntityManager(null);
	}
	
	public static EntityManager getEntityManager() {
		return ENTITY_MANAGER_STORE.get();
	}

	public void save(Entity obj) {
		
		EntityManager em = getEntityManager();
		em.persist(obj);
		em.flush();
	}

	public void delete(Entity obj) {
		
		EntityManager em = getEntityManager();
		if( !em.contains(obj) ) {
			obj = (Entity) em.find(obj.getClass(), obj.getId());
		}
		em.remove(obj);
		em.flush();
	}

	public void update(Entity obj) {

		EntityManager em = getEntityManager();
		em.persist(obj);
		em.flush();
	}

	public Entity load(Entity obj) {

		EntityManager em = getEntityManager();
		obj = em.find(obj.getClass(), obj.getId());
		return obj;
	}
	
	public Entity findById(Class clazz, long id) {

		EntityManager em = getEntityManager();
		return em.find(clazz, id);
	}
	
	public List<?> findAll(Class clazz) {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select from " + clazz.getName());
		
		return query.getResultList();
	}

	@Override
	public List<Product> findProducByGroup(long id) {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select from " + Product.class.getName() + " where idGroup=:id");
		query.setParameter("id", id);
		
		return query.getResultList();
	}
}
