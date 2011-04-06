package freeshop.model;

import static junit.framework.Assert.*;

import org.junit.Test;

public class CartTest {
	
	@Test
	public void testOK() {
		
		Cart cart = new Cart();
		
		Product book = new Product();
		book.setId(1L);
		book.setName("Book");
		
		assertFalse( cart.hasProduct(book) );
		assertEquals( 0, cart.countItems() );
		assertEquals( 0, cart.quantity(book) );
		
		cart.add(book);
		
		assertTrue( cart.hasProduct(book) );
		assertEquals( 1, cart.countItems() );
		assertEquals( 1, cart.quantity(book) );
		
		cart.add(book);
		
		assertTrue( cart.hasProduct(book) );
		assertEquals( 1, cart.countItems() );
		assertEquals( 2, cart.quantity(book) );

		cart.add(book);
		cart.add(book);
		
		assertTrue( cart.hasProduct(book) );
		assertEquals( 1, cart.countItems() );
		assertEquals( 4, cart.quantity(book) );
		
		Product dvd = new Product();
		dvd.setId(2L);
		dvd.setName("DVD");
		
		cart.add(dvd);

		assertTrue( cart.hasProduct(book) );
		assertTrue( cart.hasProduct(dvd) );
		assertEquals( 2, cart.countItems() );
		assertEquals( 4, cart.quantity(book) );
		assertEquals( 1, cart.quantity(dvd) );
		
		cart.remove(book);
		
		assertTrue( cart.hasProduct(book) );
		assertEquals( 2, cart.countItems() );
		assertEquals( 3, cart.quantity(book) );
		assertEquals( 1, cart.quantity(dvd) );
		
		cart.exclude(book);
		
		assertFalse( cart.hasProduct(book) );
		assertEquals( 1, cart.countItems() );
		assertEquals( 0, cart.quantity(book) );
		assertEquals( 1, cart.quantity(dvd) );
	}

}
