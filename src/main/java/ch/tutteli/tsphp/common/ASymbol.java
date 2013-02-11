/*
 * Copyright 2012 Robert Stoll <rstoll@tutteli.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package ch.tutteli.tsphp.common;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public abstract class ASymbol implements ISymbol
{

    protected String name;
    protected IType type;
    protected IScope definitionScope;
    protected TSPHPAst definitionAst;

    public ASymbol(TSPHPAst theDefinitionAst, String theName) {
        name = theName;
        definitionAst = theDefinitionAst;
    }

    @Override
    public TSPHPAst getDefinitionAst() {
        return definitionAst;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IScope getDefinitionScope() {
        return definitionScope;
    }

    @Override
    public void setDefinitionScope(IScope newScope) {
        definitionScope = newScope;
    }

    @Override
    public IType getType() {
        return type;
    }

    @Override
    public void setType(IType newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return getName() + (type != null ? ":" + type : "");
    }    
}
