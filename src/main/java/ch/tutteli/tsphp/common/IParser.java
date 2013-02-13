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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.antlr.runtime.TokenStream;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
public interface IParser extends IErrorReporter
{

    /**
     * Parse the inputString and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html
     */
    ITSPHPAst parse(String inputString);

    /**
     * Parse the data and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html
     */
    ITSPHPAst parse(char[] data, int numberOfActualCharsInArray);

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html
     */
    ITSPHPAst parseInputStream(InputStream input) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html
     */
    ITSPHPAst parseInputStream(InputStream input, int size) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html
     */
    ITSPHPAst parseInputStream(InputStream input, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html
     */
    ITSPHPAst parseInputStream(InputStream input, int size, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html
     */
    ITSPHPAst parseInputStream(InputStream input, int size, int readBufferSize, String encoding) throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html
     */
    ITSPHPAst parseFile(String filename) throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html
     */
    ITSPHPAst parseFile(String fileName, String encoding) throws IOException;

    TokenStream getTokenStream();

    /**
     * Indicate whether one or more syntax errors have been found during the check.
     *
     * @return True if errors have been found otherwise false.
     */
    @Override
    boolean hasFoundError();

    /**
     * Return the found syntax errors as a list of exceptions.
     *
     * @return The found syntax errors
     */
    @Override
    List<Exception> getExceptions();
}
