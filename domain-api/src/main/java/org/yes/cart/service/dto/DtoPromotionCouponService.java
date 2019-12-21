/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.service.dto;

import org.yes.cart.domain.dto.PromotionCouponDTO;
import org.yes.cart.domain.misc.SearchContext;
import org.yes.cart.domain.misc.SearchResult;
import org.yes.cart.exception.UnableToCreateInstanceException;
import org.yes.cart.exception.UnmappedInterfaceException;

/**
 * User: denispavlov
 * Date: 13-10-22
 * Time: 5:45 PM
 */
public interface DtoPromotionCouponService extends GenericDTOService<PromotionCouponDTO> {

    /**
     * Get coupons list by criteria.
     *
     * @param filter filter
     *
     * @return list
     *
     * @throws UnmappedInterfaceException error
     * @throws UnableToCreateInstanceException error
     */
    SearchResult<PromotionCouponDTO> findCoupons(long promotionId,
                                                 SearchContext filter) throws UnmappedInterfaceException, UnableToCreateInstanceException;



    /**
     * Remove all coupons by promotion ID
     *
     * @param promotionId promo ID
     */
    void removeAll(long promotionId)
            throws UnmappedInterfaceException, UnableToCreateInstanceException;

}
