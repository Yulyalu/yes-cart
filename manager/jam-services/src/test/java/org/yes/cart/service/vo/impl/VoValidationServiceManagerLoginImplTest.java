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
package org.yes.cart.service.vo.impl;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.yes.cart.domain.vo.VoValidationRequest;
import org.yes.cart.service.domain.ManagerService;
import org.yes.cart.service.vo.VoValidationService;

import static org.junit.Assert.*;

/**
 * User: inspiresoftware
 * Date: 17/10/2020
 * Time: 12:51
 */
public class VoValidationServiceManagerLoginImplTest {

    private final Mockery context = new JUnit4Mockery();

    @Test
    public void testValidate() throws Exception {

        final ManagerService managerService = context.mock(ManagerService.class);

        context.checking(new Expectations() {{
            allowing(managerService).findByLogin(with(any(String.class))); will(returnValue(null));
        }});

        final VoValidationService validationService = new VoValidationServiceManagerLoginImpl(managerService);

        assertEquals("INVALID_DATA", validationService.validate(request("zzzz")).getErrorCode());
        assertNull(validationService.validate(request("zzzz1234")).getErrorCode());
        assertNull(validationService.validate(request("zzzz09@test.com")).getErrorCode());
        assertNull(validationService.validate(request("zZ_Z-z.09@test.com")).getErrorCode());
        assertNull(validationService.validate(request("zzzz@test.com")).getErrorCode());
        assertNull(validationService.validate(request("z_z-AZ01")).getErrorCode());
        assertEquals("INVALID_DATA", validationService.validate(request("z_+z-AZ01")).getErrorCode());


    }

    private VoValidationRequest request(final String loginToCheck) {
        return new VoValidationRequest(0L, "manager", "login", loginToCheck);
    }

}