package edu.uci.ics.swe215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.yes.cart.BaseCoreDBTestCase;
import org.yes.cart.domain.entity.Promotion;
import org.yes.cart.service.domain.PromotionService;

@FixMethodOrder(MethodSorters.JVM)
public class PromotionServiceTest extends BaseCoreDBTestCase {

//	private PromotionService service;
	
//	@Before
//	public void beforeClass() {
//		service = ctx().getBean("promotionService", PromotionService.class);
//	}
//	
//	@Test
//	public void testGetPromotionsByShopCode() {
//		List<Promotion> list = service.getPromotionsByShopCode("SHOP10", "EUR", false);
//		Assert.assertNotNull(list);
//		Assert.assertEquals(6, list.size());
//	}
//	
//	@Test
//	public void testGetActivePromotionsByShopCode() {
//		List<Promotion> list = service.getPromotionsByShopCode("SHOP10", "EUR", true);
//		Assert.assertNotNull(list);
//		Assert.assertEquals(3, list.size());
//	}
//	
//	@Test
//	public void testFindPromotionByCode() {
//        Promotion promotion = service.getGenericDao().getEntityFactory().getByIface(Promotion.class);
//        promotion.setCode("SKU10%OFF");
//        promotion.setCanBeCombined(false);
//        promotion.setCurrency("EUR");
//        promotion.setShopCode("SHOP10");
//        promotion.setName("10% off SKU-001, SKU-002");
//        promotion.setDescription("10% discount to purchases of SKU-001, SKU-002");
//        promotion.setEligibilityCondition("['SKU-001','SKU-002'].contains(product.code)");
//        promotion.setPromoType(Promotion.TYPE_ITEM);
//        promotion.setPromoAction(Promotion.ACTION_PERCENT_DISCOUNT);
//        promotion.setPromoActionContext("10");
//        service.create(promotion);
//        
//        promotion.setEnabled(true);
//        service.update(promotion);
//        
//        Promotion p = service.findPromotionByCode("SKU10%OFF", true);
//        Assert.assertEquals(promotion.getPromotionId(), p.getPromotionId());
//        Assert.assertEquals(promotion.getCode(), p.getCode());
//        Assert.assertEquals(promotion.getCurrency(), p.getCurrency());
//        Assert.assertEquals(promotion.getShopCode(), p.getShopCode());
//	}
//	
//	@Test
//	public void testFindRandomPromotionByCode() {
//		Promotion p = service.findPromotionByCode("I_LOVE_SWE215", true);
//		Assert.assertNull(p);
//	}
//	
//	@Test 
//	public void testFindPromotionIdByCode() {
//		Promotion p0 = service.findPromotionByCode("SKU10%OFF", true);
//		Long id = service.findPromotionIdByCode("SKU10%OFF");
//		Long trueId = p0.getPromotionId();
//		Assert.assertEquals(trueId, id);
//	}
//	
//	@Test
//	public void testFindRandomPromotionIdByCode() {
//		Long id = service.findPromotionIdByCode("SWE215");
//		Assert.assertNull(id);
//	}
//	
//	@Test
//	public void testFindPromotions() {
//        Promotion promotion = service.getGenericDao().getEntityFactory().getByIface(Promotion.class);
//        promotion.setCode("SKU20%OFF");
//        promotion.setCanBeCombined(false);
//        promotion.setCurrency("EUR");
//        promotion.setShopCode("SHOP10");
//        promotion.setName("20% off SKU-001, SKU-002");
//        promotion.setDescription("20% discount to purchases of SKU-001, SKU-002");
//        promotion.setEligibilityCondition("['SKU-001','SKU-002'].contains(product.code)");
//        promotion.setPromoType(Promotion.TYPE_ITEM);
//        promotion.setPromoAction(Promotion.ACTION_PERCENT_DISCOUNT);
//        promotion.setPromoActionContext("10");
//        service.create(promotion);
//        
//		List<Promotion> list = service.findPromotions(0, 10, "", true, null);
//		Assert.assertEquals(10, list.size());
//	}
//	
//	private Map<String, List> getFilter(boolean activate) {
//		Map<String, List> filter = new HashMap();
//		ArrayList<Boolean> booleanList = new ArrayList<Boolean>();
//		booleanList.add(activate);
//		filter.put("active", booleanList);
//		return filter;
//	}
//	
//	@Test
//	public void testFindActivePromotions() {
//		Map<String, List> filter = getFilter(true);
//		List<Promotion> list = service.findPromotions(0, 10, "", true, filter);
//		Assert.assertEquals(7, list.size());
//	}
//	
//	@Test
//	public void testFindInActivePromotions() {
//		Map<String, List> filter = getFilter(false);
//		List<Promotion> list = service.findPromotions(0, 10, "", true, filter);
//		Assert.assertEquals(6, list.size());
//	}
//	
//	
//	@Test
//	public void testFindActivePromotionCount() {
//		Map<String, List> filter = getFilter(true);
//		Assert.assertEquals(7, service.findPromotionCount(filter));
//	}
//	
//	@Test
//	public void testFindInactivePromotionCount() {
//		Map<String, List> filter = getFilter(false);
//		Assert.assertEquals(6, service.findPromotionCount(filter));
//	}

}
