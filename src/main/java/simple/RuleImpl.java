package simple;

/**
 * @author Ray Krueger
 */
public class RuleImpl<T> implements Rule<T> {

    private final Class<T> supportedType;
    private final Consequence<T> consequence;
    private final Condition<T>[] conditions;

    public RuleImpl(Class<T> type, Consequence<T> consequence, Condition<T>... conditions) {
        this.supportedType = type;
        this.consequence = consequence;
        this.conditions = conditions;
    }

    public Class<T> getSupportedType() {
        return supportedType;
    }

    public boolean supports(Class cls) {
        return supportedType.isAssignableFrom(cls);
    }

    public boolean isSatifiedBy(T fact) throws EvaluationException {
        if (!supports(fact.getClass())) {
            throw new IllegalArgumentException("Fact type [" + fact.getClass().getName() + "] " +
                    "is not an instance of [" + supportedType.getName() + "]");
        }

        return satisfiesConditions(fact);
    }

    @SuppressWarnings("unchecked")
    public Rule addCondition(Condition<T> condition) {
        Condition<T>[] newConditions = new Condition[conditions.length + 1];
        System.arraycopy(conditions, 0, newConditions, 0, conditions.length);
        return new RuleImpl(supportedType, consequence, newConditions);
    }

    protected boolean satisfiesConditions(T fact) {
        for (Condition<T> condition : conditions) {
            if (!condition.isSatifiedBy(fact)) {
                return false;
            }
        }
        return true;
    }

    public Condition<T>[] getConditions() {
        return conditions;
    }

    public Consequence<T> getConsequence() {
        return consequence;
    }
}
