package edu.uci.ics.swe215;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.yes.cart.BaseCoreDBTestCase;
import org.yes.cart.shoppingcart.AmountCalculationStrategy;
import org.yes.cart.shoppingcart.MutableShoppingCart;
import org.yes.cart.shoppingcart.ShoppingCartCommandFactory;
import org.yes.cart.shoppingcart.Total;
import org.yes.cart.shoppingcart.impl.ShoppingCartImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.JVM)
public class ShoppingCartInteractionTest extends BaseCoreDBTestCase {

	MutableShoppingCart cart;
	ShoppingCartCommandFactory commands;
    
	@Before
	public void before() {
		cart =  new ShoppingCartImpl();
		cart.initialise(ctx().getBean("amountCalculationStrategy", AmountCalculationStrategy.class));
		commands = ctx().getBean("shoppingCartCommandFactory", ShoppingCartCommandFactory.class);
		
	}
	
	@Test
	public void newShoppingCartShouldBeEmpty() {
		Assert.assertEquals(0, cart.getCartItemsCount());
		Assert.assertEquals(0, cart.getCartItemList().size());
	}
	
	@Test
	public void shoppingCartCanAddItem() {
		cart.addProductSkuToCart("supplier-Main", "sku-ABC", "name-ABC", BigDecimal.TEN, null, false, false);
		Assert.assertEquals(10, cart.getCartItemsCount());
		Assert.assertEquals("name-ABC", cart.getCartItemList().get(0).getProductName());
		Assert.assertEquals(BigDecimal.TEN, cart.getProductSkuQuantity("supplier-Main", "sku-ABC"));
	}
	
	@Test
	public void shoppingCartCanDeleteItem() {
		cart.addProductSkuToCart("Main", "ABC", "ABC", BigDecimal.TEN, null, false, false);
		cart.removeCartItem("Main", "ABC", null);
		Assert.assertEquals(0, cart.getCartItemsCount());
	}
	
	@Test
	public void shoppingCartCanIncreaseSkuQuantity() {
		cart.addProductSkuToCart("supplier-Main", "sku-ABC", "name-ABC", BigDecimal.TEN, null, false, false);
		cart.addProductSkuToCart("supplier-Main", "sku-ABC", "name-ABC", BigDecimal.TEN, null, false, false);
		Assert.assertEquals(20, cart.getCartItemsCount());
		Assert.assertEquals(new BigDecimal(20), cart.getProductSkuQuantity("supplier-Main", "sku-ABC"));
	}
	
	@Test
	public void shoppingCartCanDecreaseSkuQuantity() {
		cart.addProductSkuToCart("supplier-Main", "sku-ABC", "name-ABC", BigDecimal.TEN, null, false, false);
		cart.addProductSkuToCart("supplier-Main", "sku-ABC", "name-ABC", BigDecimal.TEN, null, false, false);
		
		cart.removeCartItemQuantity("supplier-Main", "sku-ABC", BigDecimal.ONE, null);

		Assert.assertEquals(new BigDecimal(19), cart.getProductSkuQuantity("supplier-Main", "sku-ABC"));
	}
	
	@Test
	public void shoppingCartCanBeCleared() {
		for(int i = 0; i < 10; ++i) {
			cart.addProductSkuToCart("Main", "ABC" + i, "ABC" + i, BigDecimal.TEN, null, false, false);
		}
		for(int i = 0; i < 10; ++i) {
			cart.addProductSkuToCart("Main", "ABC" + i, "ABC" + i, BigDecimal.TEN, null, false, false);
			cart.removeCartItem("Main", "ABC" + i, null);
		}
		Assert.assertEquals(0, cart.getCartItemsCount());
	}
	
	@Test
	public void shoppingCartCanCalculatePrice() {
		cart.addProductSkuToCart("Main", "ABC", "ABC", BigDecimal.TEN, null, false, false);
		cart.setProductSkuPrice("Main", "ABC", new BigDecimal(15), new BigDecimal(15));
		cart.recalculate();
		Total t = cart.getTotal();
		Assert.assertEquals("150.00", t.getSubTotal().toPlainString());
	}
	
	@Test
	public void shoppingCartCanAddCoupon() {
        cart.addCoupon("COUPON-1");
        Assert.assertTrue(cart.getCoupons().contains("COUPON-1"));
        Assert.assertEquals(1, cart.getCoupons().size());
	}
	
	@Test
	public void shoppingCartCanRemoveCoupon() {
		cart.addCoupon("COUPON-1");
		cart.removeCoupon("COUPON-1");
        Assert.assertFalse(cart.getCoupons().contains("COUPON-1"));
        Assert.assertEquals(0, cart.getCoupons().size());
	}
	

}