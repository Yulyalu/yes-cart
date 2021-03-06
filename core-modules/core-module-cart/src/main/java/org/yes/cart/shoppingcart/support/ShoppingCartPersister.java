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

package org.yes.cart.shoppingcart.support;

import org.yes.cart.shoppingcart.ShoppingCart;

/**
 * Igor Azarny iazarny@yahoo.com
 * Date: 18-Sep-2011
 * Time: 12:53:26
 */
public interface ShoppingCartPersister<S, T> {

    /**
     * Persist shopping cart to cookie.
     * @param source request.
     * @param target response
     * @param shoppingCart shopping cart
     */
    void persistShoppingCart(S source,
                             T target,
                             ShoppingCart shoppingCart);

}
