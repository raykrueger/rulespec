package simple.sample;

import junit.framework.TestCase;
import simple.Condition;
import simple.base.Conditions;

/**
 * @author Ray Krueger
 */
public class ConditionSampleTest extends TestCase {

    public void testSimple() throws Exception {

        Person hailey = new Person(4, 3);
        Person sean = new Person(1, 2);
        Person ellie = new Person(1, 2);

        assertTrue(new OlderThanCondition(sean)
                .isSatifiedBy(hailey));

        assertTrue(new YoungerThanCondition(hailey)
                .isSatifiedBy(ellie));

        Condition<Person> youngerAndShorterThan = new YoungerThanCondition(hailey)
                .and(new ShorterThanCondition(hailey));

        assertTrue(
                youngerAndShorterThan.isSatifiedBy(ellie)
        );

        assertTrue(new OlderThanCondition(hailey).not().isSatifiedBy(ellie));

        assertTrue(Conditions.like("test").and(Conditions.equalTo("test")).isSatifiedBy("test"));

    }


}

