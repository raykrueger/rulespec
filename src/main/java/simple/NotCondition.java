package simple;

/**
 * @author Ray Krueger
 */
public class NotCondition<T> extends AbstractCondition<T> {

    private final Condition<T> other;

    public NotCondition(Condition<T> condition) {
        this.other = condition;
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        return !other.isSatifiedBy(fact);
    }
}
