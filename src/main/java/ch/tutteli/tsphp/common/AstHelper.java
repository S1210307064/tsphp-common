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

import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.TreeAdaptor;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
public class AstHelper implements IAstHelper
{

    private ITSPHPAstAdaptor adaptor;

    public AstHelper(ITSPHPAstAdaptor theAdaptor) {
        adaptor = theAdaptor;
    }

    /**
     * Adopted from http://stackoverflow.com/questions/6781019/antlr-duplicate-a-tree
     */
    @Override
    public ITSPHPAst copyAst(ITSPHPAst original) {
        ITSPHPAst copy = null;
        //original can be null if backtrack is active
        if (original != null) {
            copy = adaptor.create(original); // Leverage constructor

            if (original.getChildren() != null) {
                for (Object child : original.getChildren()) {
                    ITSPHPAst childCopy = copyAst((ITSPHPAst) child);
                    childCopy.setParent(copy);
                    copy.addChild(childCopy);
                }
            }
        }
        return copy;
    }

    @Override
    public void addChildrenFromTo(ITSPHPAst source, ITSPHPAst target, TreeAdaptor adaptor) {
        if (source != null) {
            RewriteRuleSubtreeStream stream_mod = new RewriteRuleSubtreeStream(adaptor, "classMemberModifiers", source);
            while (stream_mod.hasNext()) {
                adaptor.addChild(target, stream_mod.nextTree());
            }
        }
    }
}
