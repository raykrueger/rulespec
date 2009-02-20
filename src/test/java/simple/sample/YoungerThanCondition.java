package simple.sample;

import simple.AbstractCondition;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class YoungerThanCondition extends AbstractCondition<Person> {

    private final Person other;

    public YoungerThanCondition(Person other) {
        this.other = other;
    }

    public boolean isSatifiedBy(Person fact) throws EvaluationException {
        return fact.getAge() < other.getAge();
    }
}
