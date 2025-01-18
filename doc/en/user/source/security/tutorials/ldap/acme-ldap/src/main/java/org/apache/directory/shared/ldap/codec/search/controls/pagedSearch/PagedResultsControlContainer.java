/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.directory.shared.ldap.codec.search.controls.pagedSearch;


import org.apache.directory.shared.asn1.ber.AbstractContainer;


/**
 * A container for the Paged Search Control.
 * 
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev: 664290 $, $Date: 2008-06-07 08:28:06 +0200 (Sat, 07 Jun 2008) $, 
 */
public class PagedResultsControlContainer extends AbstractContainer
{
    /** PagedSearchControl */
    private PagedResultsControl control;


    /**
     * Creates a new PagedSearchControl container object. We will store one grammar,
     * it's enough ...
     */
    public PagedResultsControlContainer()
    {
        super();
        stateStack = new int[1];
        grammar = PagedResultsControlGrammar.getInstance();
        states = PagedResultsControlStatesEnum.getInstance();
    }


    /**
     * @return Returns the paged search control.
     */
    public PagedResultsControl getPagedSearchControl()
    {

        return control;
    }


    /**
     * Set a PagedSearchControl Object into the container. It will be completed by
     * the ldapDecoder.
     * 
     * @param control the PagedSearchControl to set.
     */
    public void setPagedSearchControl( PagedResultsControl control )
    {
        this.control = control;
    }

    /**
     * Clean the container
     */
    public void clean()
    {
        super.clean();
        control = null;
    }
}
