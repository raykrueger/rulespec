package simple;

/**
 * @author Ray Krueger
 */
public class OrCondition<T> extends AbstractCondition<T> {

    private Condition<T> one;
    private Condition<T> other;

    public OrCondition(Condition<T> one, Condition<T> other) {
        this.one = one;
        this.other = other;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return one.isSatifiedBy(fact) ||
                other.isSatifiedBy(fact);
    }
}
