package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;

import java.util.Collection;

/**
 * @author Ray Krueger
 */
public class InCondition<T> extends AbstractCondition<T> {

    private final Collection items;

    public InCondition(Collection items) {
        this.items = items;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return items.contains(fact);
    }
}
