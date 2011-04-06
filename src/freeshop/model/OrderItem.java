package freeshop.model;

public class OrderItem implements Entity {

	private static final long serialVersionUID = 3692077138584440748L;
	
	private Long id;
	private int quantity;
	private Product product;
	
	public OrderItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int add() {
		return ++this.quantity;
	}
	
	public int remove() {
		if( this.quantity > 0 ) {
			--this.quantity;
		}
		return this.quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotal() {
		return quantity * product.getPrice();
	}
	
}
