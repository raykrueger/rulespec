package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class EqualsCondition<T> extends AbstractCondition<T> {

    private final T other;

    public EqualsCondition(T other) {
        this.other = other;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return fact.equals(other);
    }
}
