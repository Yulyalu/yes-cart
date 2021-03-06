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

package org.yes.cart.domain.vo;

import java.util.Map;

/**
 * User: denispavlov
 * Date: 29/08/2016
 * Time: 15:14
 */
public class VoValidationRequest {

    private String subject;
    private String field;
    private String value;
    private long subjectId;
    private Map<String, String> context;

    public VoValidationRequest() {
    }

    public VoValidationRequest(final long subjectId, final String subject, final String field, final String value) {
        this.subjectId = subjectId;
        this.subject = subject;
        this.field = field;
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(final long subjectId) {
        this.subjectId = subjectId;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(final Map<String, String> context) {
        this.context = context;
    }
}
