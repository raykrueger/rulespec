package simple;

/**
 * @author Ray Krueger
 */
public class RuleEngine {

    private final Rule[] rules;

    public RuleEngine(Rule... rules) {
        this.rules = rules;
    }

    public void assertFact(Object fact) {
        for (Rule rule : rules) {
            if (rule.isSatifiedBy(fact)) {
                executeConsequence(rule, fact);
            }
        }
    }

    protected boolean executeConsequence(Rule rule, Object fact) throws ConsequenceException {
        return rule.getConsequence().execute(fact);
    }
}
