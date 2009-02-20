package simple;

/**
 * @author Ray Krueger
 */
public interface Rule<T> {

    Class<T> getSupportedType();

    boolean supports(Class cls);

    //void evaluate(T fact);

    boolean isSatifiedBy(T fact) throws EvaluationException;

    Consequence getConsequence();

    Rule addCondition(Condition<T> condition);
}
