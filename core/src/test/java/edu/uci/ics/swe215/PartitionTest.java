package edu.uci.ics.swe215;

import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.Test;
import org.yes.cart.shoppingcart.impl.CartItemImpl;
import org.yes.cart.shoppingcart.impl.CartItemRequiresDeletion;

public class PartitionTest {

	@Test
	public void testRemoveInvalidQuantity() throws CartItemRequiresDeletion {
		CartItemImpl item = new CartItemImpl();
		item.setQuantity(BigDecimal.TEN);
		
		item.removeQuantity(null);
		Assert.assertEquals(BigDecimal.TEN, item.getQty());
	}
	
	@Test
	public void testRemoveNegativeQuantity() throws CartItemRequiresDeletion {
		CartItemImpl item = new CartItemImpl();
		BigDecimal number_n1 = new BigDecimal(-1);
		item.setQuantity(BigDecimal.TEN);
		
		item.removeQuantity(number_n1);
		Assert.assertEquals(BigDecimal.TEN, item.getQty());
	}
	
	@Test
	public void testRemoveZeroQuantity() throws CartItemRequiresDeletion {
		CartItemImpl item = new CartItemImpl();
		item.setQuantity(BigDecimal.TEN);
		
		item.removeQuantity(BigDecimal.ZERO);
		Assert.assertEquals(BigDecimal.TEN, item.getQty());
	}
	
	@Test
	public void testRemoveLessQuantity() throws CartItemRequiresDeletion {
		CartItemImpl item = new CartItemImpl();
		BigDecimal number_9 = new BigDecimal(9);
		
		item.setQuantity(BigDecimal.TEN);
		item.removeQuantity(number_9);
		
		Assert.assertEquals(BigDecimal.ONE, item.getQty());
	}
	
	@Test
	public void testRemoveEqualQuantity() {
		CartItemImpl item = new CartItemImpl();
		item.setQuantity(BigDecimal.TEN);
		
		Assert.assertThrows(CartItemRequiresDeletion.class, ()->{item.removeQuantity(BigDecimal.TEN);});
	}
	
	
	@Test
	public void testRemoveLargerQuantity() {
		CartItemImpl item = new CartItemImpl();
		item.setQuantity(BigDecimal.TEN);
		BigDecimal number_11 = new BigDecimal(11);
		
		Assert.assertThrows(CartItemRequiresDeletion.class, ()->{item.removeQuantity(number_11);});
	}

}
