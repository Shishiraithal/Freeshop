package freeshop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private long id;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Cart() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(List<OrderItem> items) {
		this.items.addAll(items);
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}

	public void add(Product prod) {
		/*
		for( OrderItem item: items ) {
			if( item.getProduct().equals(prod) ) {
				item.add();
				return;
			}
		}
		*/
		
		OrderItem item = getItem(prod);
		if( item != null ) {
			item.add();

		} else {
			item = new OrderItem();
			item.setProduct(prod);
			item.add();
			addItem(item);
		}
	}

	public void remove(Product prod) {
		OrderItem item = getItem(prod);
		if( item != null ) {
			item.remove();
		}
	}

	public void exclude(Product prod) {
		OrderItem item = getItem(prod);
		if( item != null ) {
			items.remove(item);
		}
	}
	
	public boolean hasProduct(Product prod) {
		for( OrderItem item: items ) {
			if( item.getProduct().equals(prod) ) {
				return true;
			}
		}
		return false;
	}
	
	public OrderItem getItem(Product prod) {
		for( OrderItem item: items ) {
			if( item.getProduct().equals(prod) ) {
				return item;
			}
		}
		return null;
	}
	
	public int countItems() {
		return items.size();
	}
	
	public int quantity(Product prod) {
		OrderItem item = getItem(prod);
		if( item != null ) {
			return item.getQuantity();
		}
		return 0;
	}
	
	public double getTotal() {
		double total = 0;
		for( OrderItem item: items ) {
			total += item.getTotal();
		}
		return total;
	}
	
}
