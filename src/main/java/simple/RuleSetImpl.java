package simple;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.ArrayUtils;

/**
 * @author Ray Krueger
 */
public class RuleSetImpl<T> implements RuleSet<T> {

    private final Class<T> supportedType;
    private final Rule<T>[] rules;

    public RuleSetImpl(Class<T> supportedType, Rule<T>[] rules) {
        this.supportedType = supportedType;
        this.rules = rules;
        validate();
    }

    protected void validate() {
        Validate.notNull(supportedType, "supportedType must not be null");
        Validate.notNull(rules, "rules array must not be null");
        Validate.notEmpty(rules, "rules array must not be empty");
        Validate.noNullElements(rules, "rule array most not contain nulls");

        for (int i = 0; i < rules.length; i++) {
            Rule<T> rule = rules[i];

            Validate.isTrue(rule.supports(supportedType),
                    "Rule number [" + i + "] of the rule array" +
                            " does not support the type [" + supportedType.getName() + "]" +
                            " it only supports [" + rule.getSupportedType().getName() + "]");
        }
    }

    public Class<T> getSupportedType() {
        return supportedType;
    }

    public boolean supports(Class cls) {
        return supportedType.isAssignableFrom(cls);
    }

    @SuppressWarnings("unchecked")
    public Rule<T>[] getRules() {
        return (Rule<T>[]) ArrayUtils.clone(rules);
    }
}
