/*
 * Copyright 2009 Inspire-Software.com
 *
 *    Licensed under the Apache License, Version 2.0 (the 'License');
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an 'AS IS' BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.yes.cart.domain.vo.converter;

import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.ValueConverter;
import org.yes.cart.domain.dto.CustomerDTO;
import org.yes.cart.domain.dto.CustomerShopDTO;
import org.yes.cart.domain.vo.VoCustomerShopLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: denispavlov
 * Date: 14/11/2019
 * Time: 06:36
 */
public class MapToCustomerShopLinkConverter implements ValueConverter {

    @Override
    public Object convertToDto(final Object object, final BeanFactory beanFactory) {
        final List<VoCustomerShopLink>  shops = new ArrayList<>();
        if (object instanceof CustomerDTO) {
            final CustomerDTO customer = (CustomerDTO) object;
            if (customer.getAssignedShops() != null) {
                for (final CustomerShopDTO entry : customer.getAssignedShops()) {
                    final VoCustomerShopLink link = new VoCustomerShopLink();
                    link.setCustomerId(customer.getCustomerId());
                    link.setShopId(entry.getShopId());
                    link.setDisabled(entry.isDisabled());
                    link.setCustomerId(entry.getCustomerId());
                    shops.add(link);
                }
            }
        }
        return shops;
    }

    @Override
    public Object convertToEntity(final Object object, final Object oldEntity, final BeanFactory beanFactory) {
        throw new UnsupportedOperationException("read only");
    }
}
