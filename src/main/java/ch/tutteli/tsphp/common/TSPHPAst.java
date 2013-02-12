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
 * 
 */
package ch.tutteli.tsphp.common;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public class TSPHPAst extends CommonTree
{

    public IScope scope;
    public ISymbol symbol;

    public TSPHPAst() {
    }

    public TSPHPAst(TSPHPAst ast) {
        super(ast);
        scope = ast.scope;
        symbol = ast.symbol;
    }

    public TSPHPAst(Token t) {
        super(t);
    }

    public Object errorNode(TokenStream input, Token start, Token stop,
            RecognitionException e) {
        TSPHPErrorNode errorNode = new TSPHPErrorNode(input, start, stop, e);
        return errorNode;
    }
}
