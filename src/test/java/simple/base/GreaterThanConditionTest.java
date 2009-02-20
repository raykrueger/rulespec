package simple.base;

import junit.framework.TestCase;

/**
 * @author Ray Krueger
 */
public class GreaterThanConditionTest extends TestCase {
    public void test() throws Exception {
        assertTrue(new GreaterThanCondition<Long>(10L).isSatifiedBy(20L));
    }

}
