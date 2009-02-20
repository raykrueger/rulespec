package simple.sample;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class TallerThanCondition extends AbstractCondition<Person> {

    private final Person other;

    public TallerThanCondition(Person other) {
        this.other = other;
    }

    public boolean isSatifiedBy(Person fact) throws EvaluationException {
        return fact.getHeight() > other.getHeight();
    }
}
