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
package org.apache.directory.shared.ldap.schema.normalizers;


import java.io.IOException;

import org.apache.directory.shared.i18n.I18n;
import org.apache.directory.shared.ldap.constants.SchemaConstants;
import org.apache.directory.shared.ldap.entry.StringValue;
import org.apache.directory.shared.ldap.entry.Value;
import org.apache.directory.shared.ldap.exception.LdapException;
import org.apache.directory.shared.ldap.exception.LdapInvalidDnException;
import org.apache.directory.shared.ldap.schema.Normalizer;
import org.apache.directory.shared.ldap.schema.PrepareString;


/**
 * Normalize Telephone Number Strings
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public class TelephoneNumberNormalizer extends Normalizer
{
    /** The serial UID */
    public static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of TelephoneNumberNormalizer.
     */
    public TelephoneNumberNormalizer()
    {
        super( SchemaConstants.TELEPHONE_NUMBER_MATCH_MR_OID );
    }



   /**
    * {@inheritDoc}
    */
   public Value<?> normalize( Value<?> value ) throws LdapException
   {
       try
       {
           String normalized = PrepareString.normalize( value.getString(),
               PrepareString.StringType.TELEPHONE_NUMBER );
           
           return new StringValue( normalized );
       }
       catch ( IOException ioe )
       {
           throw new LdapInvalidDnException( I18n.err( I18n.ERR_04224, value ) );
       }
   }


   /**
    * {@inheritDoc}
    */
   public String normalize( String value ) throws LdapException
   {
       try
       {
           return PrepareString.normalize( value,
               PrepareString.StringType.TELEPHONE_NUMBER );
       }
       catch ( IOException ioe )
       {
           throw new LdapInvalidDnException( I18n.err( I18n.ERR_04224, value ) );
       }
   }
}