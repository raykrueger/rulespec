package simple.base;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * Matches a given fact string to a regular expression
 *
 * @author Ray Krueger
 */
public class LikeCondition extends AbstractCondition<String> {

    private final String regex;

    public LikeCondition(String regex) {
        this.regex = regex;
    }

    public boolean isSatifiedBy(String fact) throws EvaluationException {
        return fact.matches(regex);
    }
}
