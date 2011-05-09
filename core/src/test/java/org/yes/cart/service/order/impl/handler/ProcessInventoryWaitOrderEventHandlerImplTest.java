package org.yes.cart.service.order.impl.handler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yes.cart.domain.entity.Customer;
import org.yes.cart.domain.entity.CustomerOrder;
import org.yes.cart.domain.entity.CustomerOrderDelivery;
import org.yes.cart.service.domain.CustomerOrderService;
import org.yes.cart.service.order.impl.OrderAssemblerImplTest;
import org.yes.cart.service.order.impl.OrderEventImpl;

/**
* User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class ProcessInventoryWaitOrderEventHandlerImplTest extends AbstractEventHandlerImplTest {

    private CustomerOrderService orderService = null;
    private ProcessInventoryWaitOrderEventHandlerImpl handler = null;

    @Before
    public void setUp() throws Exception {
        super.setUp(new String [] {"testApplicationContext.xml" , "core-aspects.xml" });


        handler = (ProcessInventoryWaitOrderEventHandlerImpl) ctx.getBean("processInventoryWaitOrderEventHandler");
        orderService =  (CustomerOrderService)  ctx.getBean("customerOrderService");
    }

    @After
    public void tearDown() {
        orderService = null;
        handler = null;
        super.tearDown();
    }

    @Test
    public void testHandle() {

        final Customer customer = OrderAssemblerImplTest.createCustomer(ctx);
        assertFalse(customer.getAddress().isEmpty());

        final CustomerOrder customerOrder = orderService.createFromCart(getStdCard(ctx), false);
        assertEquals(CustomerOrder.ORDER_STATUS_NONE, customerOrder.getOrderStatus());

        CustomerOrderDelivery delivery = customerOrder.getDelivery().iterator().next();

        handler.handle(
                new OrderEventImpl(
                        "", //evt.payment.offline
                        customerOrder,
                        delivery

                )
        );
        assertEquals(CustomerOrderDelivery.DELIVERY_STATUS_INVENTORY_WAIT, delivery.getDeliveryStatus());

    }
}
