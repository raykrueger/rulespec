package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;
import static simple.base.Conditions.*;

/**
 * @author Ray Krueger
 */
public class BetweenCondition<T extends Comparable> extends AbstractCondition<T> {

    private final Comparable floor;
    private final Comparable ceiling;
    private final boolean inclusive;

    public BetweenCondition(Comparable floor, Comparable ceiling) {
        this(floor, ceiling, false);
    }

    public BetweenCondition(Comparable floor, Comparable ceiling, boolean inclusive) {
        this.floor = floor;
        this.ceiling = ceiling;
        this.inclusive = inclusive;
    }

    @SuppressWarnings("unchecked")
    public boolean isSatifiedBy(T fact) throws EvaluationException {

        if (inclusive) {
            return greaterThanOrEqualTo(floor)
                    .and(lessThanOrEqualTo(ceiling))
                    .isSatifiedBy(fact);

        } else {
            return greaterThan(floor).and(lessThan(ceiling))
                    .isSatifiedBy(fact);

        }

    }
}
