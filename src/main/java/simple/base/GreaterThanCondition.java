package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class GreaterThanCondition<T extends Comparable> extends AbstractCondition<T> {

    private final T other;

    public GreaterThanCondition(T other) {
        this.other = other;
    }

    @SuppressWarnings("unchecked")
    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return fact.compareTo(other) > 0;
    }
}
