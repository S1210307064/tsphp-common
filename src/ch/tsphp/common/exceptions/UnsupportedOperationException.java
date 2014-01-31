package ch.tsphp.common.exceptions;

import ch.tsphp.common.ITSPHPAst;

public class UnsupportedOperationException extends TypeCheckerException
{

    private final ITSPHPAst operator;

    public UnsupportedOperationException(String message, ITSPHPAst theOperator) {
        super(message);
        operator = theOperator;
    }

    public ITSPHPAst getOperator() {
        return operator;
    }
}
