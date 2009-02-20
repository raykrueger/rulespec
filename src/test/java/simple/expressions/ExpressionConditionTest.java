package simple.expressions;

import junit.framework.TestCase;
import simple.sample.Person;
import simple.EvaluationException;

/**
 * @author Ray Krueger
 */
public class ExpressionConditionTest extends TestCase {
    public void test() throws Exception {
        assertTrue(new ExpressionCondition<Person>("age > 10").isSatifiedBy(new Person(30, 6)));

        assertFalse(new ExpressionCondition<Person>("age > height").not().isSatifiedBy(new Person(30, 6)));

        try {
            new ExpressionCondition<Object>("boogey woogey").isSatifiedBy(new Object());   
        } catch (EvaluationException e) {

        }
    }

}
