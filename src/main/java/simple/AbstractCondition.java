package simple;

/**
 * @author Ray Krueger
 */
public abstract class AbstractCondition<T> implements Condition<T> {

    public Condition<T> and(Condition<T> other) throws EvaluationException {
        return new AndCondition<T>(this, other);
    }

    public Condition<T> or(Condition<T> other) throws EvaluationException {
        return new OrCondition<T>(this, other);
    }

    public Condition<T> not() throws EvaluationException {
        return new NotCondition<T>(this);
    }

    protected boolean notNull(T fact) {
        return fact != null;
    }
}
