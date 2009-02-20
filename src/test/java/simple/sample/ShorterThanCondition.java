package simple.sample;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class ShorterThanCondition extends AbstractCondition<Person> {

    private final Person other;

    public ShorterThanCondition(Person other) {
        this.other = other;
    }

    public boolean isSatifiedBy(Person fact) throws EvaluationException {
        return fact.getHeight() < other.getHeight();
    }
}
