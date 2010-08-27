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
package org.apache.acf.crawler.connectors.DCTM;

import org.apache.acf.core.interfaces.*;

public class FindDoc
{
        public static final String _rcsid = "@(#)$Id$";

        private FindDoc()
        {
        }


        public static void main(String[] args)
        {
                if (args.length != 6)
                {
                        System.err.println("Usage: FindDoc <docbase> <domain> <user> <password> <location> <name>");
                        System.exit(1);
                }

                try
                {
                        DCTMAddRemove handle = new DCTMAddRemove(args[0],args[1],args[2],args[3],args[4]);
                        String idValue = handle.FindDoc(args[5]);
                        if (idValue != null)
                                UTF8Stdout.print(idValue);
                        else
                                UTF8Stdout.print("");
                }
                catch (Exception e)
                {
                        e.printStackTrace(System.err);
                        System.exit(2);
                }
        }

}