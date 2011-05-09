package org.yes.cart.service.domain.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yes.cart.constants.ServiceSpringKeys;
import org.yes.cart.domain.entity.Address;
import org.yes.cart.domain.entity.Customer;
import org.yes.cart.service.domain.AddressService;
import org.yes.cart.service.domain.CustomerService;
import org.yes.cart.service.domain.ShopService;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class AddressServiceImplTest extends BaseCoreDBTestCase {

    private AddressService addressService = null;
    private CustomerService customerService = null;
    private ShopService shopService = null;

    @Before
    public void setUp() throws Exception {
        super.setUp(new String [] {"testApplicationContext.xml" , "core-aspects.xml" });
        addressService = (AddressService) ctx.getBean(ServiceSpringKeys.ADDRESS_SERVICE);
        customerService = (CustomerService) ctx.getBean(ServiceSpringKeys.CUSTOMER_SERVICE);
        shopService = (ShopService)  ctx.getBean(ServiceSpringKeys.SHOP_SERVICE);
    }

    @After
    public void tearDown() {
        addressService = null;
        customerService = null;
        shopService = null;
        super.tearDown();
    }

    @Test
    public void testGetAddressesByCustomerId() {
        
        Customer customer = customerService.getGenericDao().getEntityFactory().getByIface(Customer.class);
        customer.setEmail("bender@domain.com");
        customer.setFirstname("Bender");
        customer.setLastname("Rodriguez");
        customer = customerService.create(customer, shopService.getById(10L));
        assertTrue (customer.getCustomerId() > 0);

        Address address = addressService.getGenericDao().getEntityFactory().getByIface(Address.class);
        address.setFirstname("Bender");
        address.setLastname("Rodriguez");        
        address.setCity("LA");
        address.setAddrline1("line1");
        address.setCountryCode("US");
        address.setAddressType(Address.ADDR_TYPE_BILLING);
        address.setCustomer(customer);

        addressService.create(address);


        address = addressService.getGenericDao().getEntityFactory().getByIface(Address.class);
        address.setFirstname("Bender");
        address.setLastname("Rodriguez");
        address.setCity("New-Vasyki");
        address.setAddrline1("line0");
        address.setCountryCode("ZH");
        address.setAddressType(Address.ADDR_TYPE_BILLING);
        address.setCustomer(customer);

        addressService.create(address);

        customer = customerService.getById(customer.getCustomerId());

        assertEquals(2, customer.getAddress().size());

        assertEquals(2, addressService.getAddressesByCustomerId(customer.getCustomerId()).size());

        assertTrue(addressService.getAddressesByCustomerId(customer.getCustomerId(), Address.ADDR_TYPE_SHIPING).isEmpty());

        assertEquals(2, addressService.getAddressesByCustomerId(customer.getCustomerId(), Address.ADDR_TYPE_BILLING).size());

    }
}
