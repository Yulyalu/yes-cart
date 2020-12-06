package edu.uci.ics.swe215;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.yes.cart.BaseCoreDBTestCase;
import org.yes.cart.constants.AttributeNamesKeys;
import org.yes.cart.domain.entity.Shop;
import org.yes.cart.promotion.impl.PromotionCouponCodeGeneratorImpl;
import org.yes.cart.service.domain.ShopService;

public class TestableDesign extends BaseCoreDBTestCase {

	@Test
	public void testDefaultLengthWhenShopIsNull() {
		final ShopService shopService = ctx().getBean("shopService", ShopService.class);
		
		PromotionCouponCodeGeneratorImpl generator = new PromotionCouponCodeGeneratorImpl(5, shopService);
		
		assertEquals(5, generator.determineCouponSize(null));
	}
	
	@Test
	public void testShopLengthLongerThanFive() {
		final ShopService shopService = ctx().getBean("shopService", ShopService.class);
		PromotionCouponCodeGeneratorImpl generator = new PromotionCouponCodeGeneratorImpl(5, shopService);
		Shop shop = mock(Shop.class);
		when(shop.getAttributeValueByCode(AttributeNamesKeys.Shop.SHOP_COUPON_CODE_LENGTH)).thenReturn("10");
		
		assertEquals(10, generator.determineCouponSize(shop));
	}
	
	@Test
	public void testShopLengthShorterThanFive() {
		final ShopService shopService = ctx().getBean("shopService", ShopService.class);
		PromotionCouponCodeGeneratorImpl generator = new PromotionCouponCodeGeneratorImpl(5, shopService);
		Shop shop = mock(Shop.class);
		when(shop.getAttributeValueByCode(AttributeNamesKeys.Shop.SHOP_COUPON_CODE_LENGTH)).thenReturn("3");
		
		assertEquals(5, generator.determineCouponSize(shop));
	}
	
	@Test
	public void testShopLengthEmptyString() {
		final ShopService shopService = ctx().getBean("shopService", ShopService.class);
		PromotionCouponCodeGeneratorImpl generator = new PromotionCouponCodeGeneratorImpl(5, shopService);
		Shop shop = mock(Shop.class);
		when(shop.getAttributeValueByCode(AttributeNamesKeys.Shop.SHOP_COUPON_CODE_LENGTH)).thenReturn("");
		
		assertEquals(5, generator.determineCouponSize(shop));
	}
	
	

}
