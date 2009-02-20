package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class LessThanCondition<T extends Comparable> extends AbstractCondition<T> {

    private final T other;

    public LessThanCondition(T other) {
        this.other = other;
    }

    @SuppressWarnings("unchecked")
    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return fact.compareTo(other) < 0;
    }
}
