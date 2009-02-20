package simple;

import junit.framework.TestCase;

/**
 * @author Ray Krueger
 */
@SuppressWarnings("unchecked")
public class RuleTest extends TestCase {

    public void testSatisfyMultiple() throws Exception {

        Condition<String> con1 = new AbstractCondition<String>() {
            public boolean isSatifiedBy(String fact) throws EvaluationException {
                return true;
            }
        };

        Condition<String> con2 = new AbstractCondition<String>() {
            public boolean isSatifiedBy(String fact) throws EvaluationException {
                return true;
            }
        };

        Consequence<String> consequence = new Consequence<String>() {
            public boolean execute(String fact) throws ConsequenceException {
                throw new UnsupportedOperationException();
            }
        };

        Rule<String> rule = new RuleImpl<String>(String.class, consequence, con1, con2);

        assertTrue(rule.isSatifiedBy("hello"));

    }


}
