package simple.expressions;

import ognl.Ognl;
import ognl.OgnlException;
import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * Compares an ognl expression to the fact present in the {@link #isSatifiedBy(Object)} method.
 * The expression given must evaluate to a boolean.
 *
 * @author Ray Krueger
 */
public class ExpressionCondition<T> extends AbstractCondition<T> {

    private final String expression;

    public ExpressionCondition(String expression) {
        this.expression = expression;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        try {
            return notNull(fact) && expressionEvaluatesToTrue(fact);
        } catch (OgnlException e) {
            throw new EvaluationException(e);
        }
    }

    private Boolean expressionEvaluatesToTrue(T fact) throws OgnlException {
        return (Boolean) Ognl.getValue(expression, fact, Boolean.class);
    }

    public String getExpression() {
        return expression;
    }
}
