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

package org.yes.cart.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.task.TaskExecutor;
import org.yes.cart.service.domain.MailService;
import org.yes.cart.service.mail.MailComposer;
import org.yes.cart.service.theme.ThemeService;

/**
 * User: denispavlov
 * Date: 03/11/2015
 * Time: 09:09
 */
@Aspect
public class ContactFormAspect extends AbstractSimpleNotificationAspect {

    /**
     * Construct customer aspect.
     *
     * @param taskExecutor    {@link TaskExecutor} to execute task.
     * @param mailService     persists mail object to be picked up by bulk email job
     * @param mailComposer    mail composer generates message to be sent
     * @param themeService    theme service
     */
    public ContactFormAspect(final TaskExecutor taskExecutor,
                             final MailService mailService,
                             final MailComposer mailComposer,
                             final ThemeService themeService) {
        super(taskExecutor, mailService, mailComposer, themeService);
    }


    /**
     * Handle reset password operation.
     *
     * @param pjp {@link ProceedingJoinPoint}
     * @return Object
     * @throws Throwable in case of target method errors
     */
    @Around("execution(* org.yes.cart.web.support.service.impl.CustomerServiceFacadeImpl.contactUsEmailRequest(..))")
    public Object doSignupNewsletter(final ProceedingJoinPoint pjp) throws Throwable {
        return notifyInternal(pjp, "adm-contactform-request");
    }

}
