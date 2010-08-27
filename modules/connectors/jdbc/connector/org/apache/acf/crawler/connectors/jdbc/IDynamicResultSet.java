/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.acf.crawler.connectors.jdbc;

import org.apache.acf.core.interfaces.*;
import org.apache.acf.agents.interfaces.*;

/** This object describes an (open) jdbc resultset.  Semantics are identical to
* org.apache.acf.core.interfaces.IResultSet, EXCEPT that a close() method is
* provided and must be called, and there is no method to get the entire resultset
* at once.
*/
public interface IDynamicResultSet
{
  public static final String _rcsid = "@(#)$Id$";

  /** Get the next row from the resultset.
  *@return the immutable row description, or null if there is no such row.
  */
  public IResultRow getNextRow()
    throws ACFException, ServiceInterruption;

  /** Close this resultset.
  */
  public void close()
    throws ACFException, ServiceInterruption;
}