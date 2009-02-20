package simple;

import junit.framework.TestCase;

/**
 * @author Ray Krueger
 */
public class ConsequenceChainTest extends TestCase {

    private boolean executed;

    @Override
    protected void setUp() throws Exception {
        executed = false;
    }

    @SuppressWarnings("unchecked")
    public void testKnownGood() throws Exception {
        final Object expectedFact = new Object();

        ConsequenceChain<Object> chain = new ConsequenceChain<Object>(new Consequence[]{new Consequence<Object>() {
            public boolean execute(Object fact) throws ConsequenceException {
                assertSame(expectedFact, fact);
                executed = true;
                return false;
            }
        }});

        chain.execute(expectedFact);

        assertTrue(executed);
    }

    public void testNullValidation() throws Exception {
        try {
            new ConsequenceChain<Object>(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {

        }
    }

    public void testZeroLengthValidation() throws Exception {
        try {
            new ConsequenceChain<Object>(new Consequence[0]);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {

        }
    }

}
