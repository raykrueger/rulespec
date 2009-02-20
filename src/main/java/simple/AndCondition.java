package simple;

/**
 * @author Ray Krueger
 */
public class AndCondition<T> extends AbstractCondition<T> {

    private final Condition<T> one;
    private final Condition<T> other;

    public AndCondition(Condition<T> one, Condition<T> other) {
        this.one = one;
        this.other = other;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return one.isSatifiedBy(fact) &&
                other.isSatifiedBy(fact);
    }
}
