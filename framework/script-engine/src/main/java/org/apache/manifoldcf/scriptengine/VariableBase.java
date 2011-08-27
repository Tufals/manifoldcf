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

package org.apache.manifoldcf.scriptengine;

import org.apache.manifoldcf.core.interfaces.*;

/** Base class for variables.
* Basically, everything is illegal until overridden.
*/
public class VariableBase implements Variable, VariableReference
{
  public VariableBase()
  {
  }
  
  /** Get the variable's value as a string */
  public String getStringValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to string");
  }
  
  /** Get the variable's value as a Configuration object */
  public Configuration getConfigurationValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to Configuration object");
  }
    
  /** Get the variable's value as a ConfigurationNode object */
  public ConfigurationNode getConfigurationNodeValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to ConfigurationNode object");
  }

  /** Get the variable's value as a boolean */
  public boolean getBooleanValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to boolean");
  }
  
  /** Get the variable's value as an integer */
  public int getIntValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to int");
  }
  
  /** Get the variable's value as a double */
  public double getDoubleValue()
    throws ScriptException
  {
    throw new ScriptException("Cannot convert variable to float");
  }

  // Operations
  
  public VariableReference plus(Variable v)
    throws ScriptException
  {
    throw new ScriptException("+ operator illegal for this type");
  }
    
  public VariableReference minus(Variable v)
    throws ScriptException
  {
    throw new ScriptException("- operator illegal for this type");
  }
    
  public VariableReference asterisk(Variable v)
    throws ScriptException
  {
    throw new ScriptException("* operator illegal for this type");
  }
    
  public VariableReference slash(Variable v)
    throws ScriptException
  {
    throw new ScriptException("/ operator illegal for this type");
  }
    
  public VariableReference unaryMinus()
    throws ScriptException
  {
    throw new ScriptException("Unary - operator illegal for this type");
  }
  
  public VariableReference greaterAngle(Variable v)
    throws ScriptException
  {
    throw new ScriptException("> operator illegal for this type");
  }
    
  public VariableReference lesserAngle(Variable v)
    throws ScriptException
  {
    throw new ScriptException("< operator illegal for this type");
  }
    
  public VariableReference doubleEquals(Variable v)
    throws ScriptException
  {
    throw new ScriptException("= operator illegal for this type");
  }
    
  public VariableReference greaterAngleEquals(Variable v)
    throws ScriptException
  {
    throw new ScriptException(">= operator illegal for this type");
  }
    
  public VariableReference lesserAngleEquals(Variable v)
    throws ScriptException
  {
    throw new ScriptException("<= operator illegal for this type");
  }
  
  public VariableReference exclamationEquals(Variable v)
    throws ScriptException
  {
    throw new ScriptException("!= operator illegal for this type");
  }
  
  public VariableReference ampersand(Variable v)
    throws ScriptException
  {
    throw new ScriptException("& operator illegal for this type");
  }
    
  public VariableReference pipe(Variable v)
    throws ScriptException
  {
    throw new ScriptException("| operator illegal for this type");
  }

  public VariableReference doubleAmpersand(Variable v)
    throws ScriptException
  {
    throw new ScriptException("&& operator illegal for this type");
  }
    
  public VariableReference doublePipe(Variable v)
    throws ScriptException
  {
    throw new ScriptException("|| operator illegal for this type");
  }
  
  public VariableReference unaryExclamation()
    throws ScriptException
  {
    throw new ScriptException("! operator illegal for this type");
  }

  // The following operations allow manipulation of a Configuration structure

  /** Get a named attribute of the variable; e.g. xxx.yyy */
  public VariableReference getAttribute(String attributeName)
    throws ScriptException
  {
    if (attributeName.equals(ATTRIBUTE_STRING))
      return new VariableString(getStringValue());
    else if (attributeName.equals(ATTRIBUTE_INT))
      return new VariableInt(getIntValue());
    else if (attributeName.equals(ATTRIBUTE_FLOAT))
      return new VariableFloat(getDoubleValue());
    else if (attributeName.equals(ATTRIBUTE_BOOLEAN))
      return new VariableBoolean(getBooleanValue());
    else if (attributeName.equals(ATTRIBUTE_SCRIPT))
      return new VariableString(toString());
    else
      throw new ScriptException("Variable has no attribute called '"+attributeName+"'");
  }
  
  /** Insert an object into this variable at a position. */
  public void insertAt(Variable v, int index)
    throws ScriptException
  {
    throw new ScriptException("Can't insert into variable");
  }

  /** Insert an object into this variable at end. */
  public void insert(Variable v)
    throws ScriptException
  {
    throw new ScriptException("Can't insert into variable");
  }

  /** Delete an object from this variable at a position. */
  public void removeAt(int index)
    throws ScriptException
  {
    throw new ScriptException("Can't remove from variable");
  }
    

  // The following two operations correspond to <xxx> and xxx[index]
  
  /** Get an indexed property of the variable */
  public VariableReference getIndexed(int index)
    throws ScriptException
  {
    throw new ScriptException("Variable has no member number "+Integer.toString(index));
  }

  // As a variable reference, refer to self
  
  /** Set the reference */
  public void setReference(Variable object)
    throws ScriptException
  {
    throw new ScriptException("Cannot set reference of this kind");
  }
  
  /** Resolve the reference */
  public Variable resolve()
    throws ScriptException
  {
    return this;
  }

  /** Check if this reference is null */
  public boolean isNull()
  {
    return false;
  }

}