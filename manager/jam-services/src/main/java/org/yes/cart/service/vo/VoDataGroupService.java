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

package org.yes.cart.service.vo;

import org.yes.cart.domain.vo.VoDataDescriptor;
import org.yes.cart.domain.vo.VoDataGroup;

import java.util.List;

/**
 * User: denispavlov
 * Date: 30/03/2019
 * Time: 12:25
 */
public interface VoDataGroupService {


    /**
     * Get all available data groups
     *
     * @return vos
     *
     * @throws Exception errors
     */
    List<VoDataGroup> getAllDataGroups() throws Exception;

    /**
     * Get vo by id.
     *
     * @param id group id
     *
     * @return vo
     *
     * @throws Exception errors
     */
    VoDataGroup getDataGroupById(long id) throws Exception;

    /**
     * Create new vo
     *
     * @param vo vo
     *
     * @return persistent version
     *
     * @throws Exception errors
     */
    VoDataGroup createDataGroup(VoDataGroup vo)  throws Exception;

    /**
     * Update vo
     *
     * @param vo vo
     *
     * @return persistent version
     *
     * @throws Exception errors
     */
    VoDataGroup updateDataGroup(VoDataGroup vo)  throws Exception;

    /**
     * Remove vo.
     *
     * @param id group id
     *
     * @throws Exception errors
     */
    void removeDataGroup(long id) throws Exception;



    /**
     * Get all available data descriptors
     *
     * @return vos
     *
     * @throws Exception errors
     */
    List<VoDataDescriptor> getAllDataDescriptors() throws Exception;

    /**
     * Get vo by id.
     *
     * @param id descriptor id
     *
     * @return vo
     *
     * @throws Exception errors
     */
    VoDataDescriptor getDataDescriptorById(long id) throws Exception;

    /**
     * Create new vo
     *
     * @param vo vo
     *
     * @return persistent version
     *
     * @throws Exception errors
     */
    VoDataDescriptor createDataDescriptor(VoDataDescriptor vo)  throws Exception;

    /**
     * Update vo
     *
     * @param vo vo
     *
     * @return persistent version
     *
     * @throws Exception errors
     */
    VoDataDescriptor updateDataDescriptor(VoDataDescriptor vo)  throws Exception;

    /**
     * Remove vo.
     *
     * @param id descriptor id
     *
     * @throws Exception errors
     */
    void removeDataDescriptor(long id) throws Exception;



}
