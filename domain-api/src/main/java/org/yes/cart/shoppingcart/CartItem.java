/*
 * Copyright 2009 Inspire-Software.com
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

package org.yes.cart.shoppingcart;

import org.yes.cart.service.order.DeliveryBucket;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Cart item object that hold information about a single shopping item.
 * <p/>
 * User: dogma
 * Date: Jan 15, 2011
 * Time: 10:25:01 PM
 */
public interface CartItem extends Serializable {

    /**
     * @return product sku code.
     */
    String getProductSkuCode();

    /**
     * Get product name in CustomerOrder.locale.
     *
     * @return copy of product name
     */
    String getProductName();

    /**
     * @return supplier code.
     */
    String getSupplierCode();

    /**
     * @return delivery group.
     */
    String getDeliveryGroup();

    /**
     * @return item group.
     */
    String getItemGroup();

    /**
     * @return delivery bucket.
     */
    DeliveryBucket getDeliveryBucket();

    /**
     * @return quantity of the above sku to be purchased
     */
    BigDecimal getQty();

    /**
     * Get the sku sale price including all promotions.
     *
     * @return sku price.
     */
    BigDecimal getPrice();

    /**
     * Get the sku sale price including all promotions.
     *
     * @return after tax price
     */
    BigDecimal getNetPrice();

    /**
     * Get the sku sale price including all promotions.
     *
     * @return before tax price
     */
    BigDecimal getGrossPrice();

    /**
     * Get tax code used for this item.
     *
     * @return tax code
     */
    String getTaxCode();

    /**
     * Get tax rate for this item.
     *
     * @return tax rate 0-99
     */
    BigDecimal getTaxRate();

    /**
     * Tax exclusive of price flag.
     *
     * @return true if exclusive, false if inclusive
     */
    boolean isTaxExclusiveOfPrice();

    /**
     * Get sale price.
     *
     * @return price
     */
    BigDecimal getSalePrice();

    /**
     * Get list / catalog price.
     *
     * @return price
     */
    BigDecimal getListPrice();

    /**
     * This is a configurable product.
     *
     * @return true if this is a configurable product.
     */
    boolean isConfigurable();

    /**
     * This product not to be sold separately.
     *
     * @return not to be sold separately product.
     */
    boolean isNotSoldSeparately();

    /**
     * Returns true if this item has been added as gift as
     * a result of promotion.
     *
     * @return true if this is a promotion gift
     */
    boolean isGift();

    /**
     * Returns true if promotions have been applied to this
     * item.
     *
     * @return true if promotions have been applied
     */
    boolean isPromoApplied();

    /**
     * Returns true if this item has been added as fixed price offer.
     * {@link #getAppliedPromo()} will contain authorisation code
     *
     * @return true if this is a fixed price offer
     */
    boolean isFixedPrice();

    /**
     * Comma separated list of promotion codes that have been applied
     * for this cart item.
     *
     * @return comma separated promo codes
     */
    String getAppliedPromo();

}