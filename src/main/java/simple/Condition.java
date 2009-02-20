package simple;

/**
 * @author Ray Krueger
 */
public interface Condition<T> {

    boolean isSatifiedBy(T fact) throws EvaluationException;

    Condition<T> and(Condition<T> other) throws EvaluationException;

    Condition<T> or(Condition<T> other) throws EvaluationException;

    Condition<T> not() throws EvaluationException;

}
