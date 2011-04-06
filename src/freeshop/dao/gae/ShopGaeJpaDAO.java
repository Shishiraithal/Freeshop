package freeshop.dao.gae;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import freeshop.dao.ShopDAO;
import freeshop.model.Content;
import freeshop.model.Customer;
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
			obj = em.find(obj.getClass(), obj.getId());
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
	
	public <T extends Entity> T findById(Class<T> clazz, long id) {

		EntityManager em = getEntityManager();
		return em.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Entity> List<T> findAll(Class<T> clazz) {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select from " + clazz.getName());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Product> findProductByGroup(long id, Boolean active) {

		String sql = "select from " + Product.class.getName() + " where idGroup=:id";
		if( active!=null ) {
			sql += " and active=:active";
		}
		
		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		if( active!=null ) {
			query.setParameter("active", active);
		}
		
		return query.getResultList();
		
	}

	public List<Product> findProductByGroup(long id) {
		return findProductByGroup(id, null);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findProductByTag(String tag, Boolean active) {
		
		String sql = "select from " + Product.class.getName() + " where tags in (:tag)";
		if( active!=null ) {
			sql += " and active=:active";
		}

		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
		query.setParameter("tag", tag);
		if( active!=null ) {
			query.setParameter("active", active);
		}
		
		return query.getResultList();
		
	}

	public List<Product> findProductByTag(String tag) {
		return findProductByTag(tag, null);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findProductByTags(List<String> tags, Boolean active) {
		
		if( tags == null || tags.size()<=0 ) {
			return new ArrayList<Product>();
		}
		
		String sql = "select from " + Product.class.getName() + " where tags in (";
		for( int idx=0; idx<tags.size(); idx++ ) {
			sql += ":tag"+idx;
			if( (idx+1) < tags.size() ) {
				sql += ",";
			}
		}
		sql += ")";
		
		if( active!=null ) {
			sql += " and active=:active";
		}

		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
		for( int idx=0; idx<tags.size(); idx++ ) {
			query.setParameter("tag"+idx, tags.get(idx));
		}
		
		if( active!=null ) {
			query.setParameter("active", active);
		}
		
		return query.getResultList();
	}

	public List<Product> findProductByTags(List<String> tags) {
		return findProductByTags(tags, null);
	}

	@SuppressWarnings("unchecked")
	public List<String> findAllContentNames() {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select name from " + Content.class.getName());
		
		return query.getResultList();
	}
	
	public Content findContentByName(String name) {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select from " + Content.class.getName() + " where name=:name");
		query.setParameter("name", name);
		
		try {
			return (Content) query.getSingleResult();
			
		} catch(NoResultException e) {
			return null;
		}
	}

	public Customer findCustomerByEmail(String email) {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select from " + Customer.class.getName() + " where email=:email");
		query.setParameter("email", email);
		
		try {
			return (Customer) query.getSingleResult();
			
		} catch(NoResultException e) {
			return null;
		}
	}
}
