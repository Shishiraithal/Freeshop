package freeshop.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import freeshop.dao.ShopDAO;
import freeshop.exception.CEPInvalidoException;
import freeshop.exception.CustomerAlreadyExistsException;
import freeshop.exception.CustomerNotFoundException;
import freeshop.exception.InvalidPasswordException;
import freeshop.model.Customer;
import freeshop.model.Product;
import freeshop.model.ProductGroup;

@Component
public class ShopService {

	private ShopDAO dao;
	
	public ShopService(ShopDAO dao) {
		this.dao = dao;
	}
	
	public List<Product> listProductsForHome() {
		return dao.findAll(Product.class);
	}
	
	public List<Product> listProductsByGroup(long id) {
		return dao.findProductByGroup(id);
	}
	
	public Product findProduct(long id) {
		return dao.findById(Product.class, id);
	}
	
	public List<ProductGroup> listProductGroups() {
		return dao.findAll(ProductGroup.class);
	}
	
	public ProductGroup findProductGroup(long id) {
		return dao.findById(ProductGroup.class, id);
	}
	
	public double calcularFrete( long cep ) throws CEPInvalidoException {
		double frete = 0;
		
		if( cep < 9999999 || cep > 99999999 ) {
			throw new CEPInvalidoException();
		}
		
		return frete;
	}
	
	public List<Product> findProductsRelatedByTags(List<String> tags) {
		return dao.findProductByTags(tags);
	}
	
	public List<Product> findProductsByTag(String tag) {
		return dao.findProductByTag(tag);
	}
	
	public Customer login( String username, String password ) throws CustomerNotFoundException, InvalidPasswordException {
		Customer customer = dao.findCustomerByEmail( username );
		if( customer==null ) {
			throw new CustomerNotFoundException();
		}
		if( !customer.getPassword().equals(password) ) {
			throw new InvalidPasswordException();
		}
		return customer;
	}
	
	public Customer findCustomerByEmail( String email ) {
		return dao.findCustomerByEmail( email );
	}
	
	public void registerCustomer( Customer customer ) throws CustomerAlreadyExistsException {
		
		Customer existingCustomer = dao.findCustomerByEmail(customer.getEmail());
		if( existingCustomer != null ) {
			throw new CustomerAlreadyExistsException();
		}
		
		dao.save( customer );
	}
}
