package edu.uci.ics.swe215;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.yes.cart.shoppingcart.impl.CartItemImpl;
import org.yes.cart.shoppingcart.impl.ShoppingCartImpl;

public class MockTest {

	@Test
	public void testPromotionRemovedForItemWithSalePrice() {
		ShoppingCartImpl cart = new ShoppingCartImpl();

		CartItemImpl item1 = mock(CartItemImpl.class);
		
		when(item1.isPromoApplied()).thenReturn(true);
		when(item1.getSalePrice()).thenReturn(new BigDecimal(10));
		
		
		cart.getItems().add(item1);
		
		cart.removeItemPromotions();
		verify(item1, times(1)).setPromoApplied(false);
		verify(item1, times(1)).setAppliedPromo(null);
		verify(item1, times(1)).setPrice(new BigDecimal(10));
	}

	@Test
	public void testPromotionRemovedForItemWithNoSalePrice() {
		ShoppingCartImpl cart = new ShoppingCartImpl();

		CartItemImpl item1 = mock(CartItemImpl.class);
		
		when(item1.isPromoApplied()).thenReturn(true);
		when(item1.getSalePrice()).thenReturn(null);
		when(item1.getListPrice()).thenReturn(new BigDecimal(20));
		
		
		cart.getItems().add(item1);
		
		cart.removeItemPromotions();
		verify(item1, times(1)).setPromoApplied(false);
		verify(item1, times(1)).setAppliedPromo(null);
		verify(item1, times(1)).setPrice(new BigDecimal(20));
	}
	
	@Test
	public void testPromotionRemovedForItemWithPromotion() {
		ShoppingCartImpl cart = new ShoppingCartImpl();

		CartItemImpl item1 = mock(CartItemImpl.class);
		when(item1.isPromoApplied()).thenReturn(true);
		
		CartItemImpl item2 = mock(CartItemImpl.class);
		when(item2.isPromoApplied()).thenReturn(false);

		cart.getItems().add(item1);
		cart.getItems().add(item2);
		
		cart.removeItemPromotions();
		verify(item1, times(1)).setPromoApplied(false);
		verify(item2, times(1)).isPromoApplied();
		verifyNoMoreInteractions(item2);
	}
}
