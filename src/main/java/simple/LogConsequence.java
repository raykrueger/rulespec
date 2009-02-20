package simple;

import org.apache.log4j.Logger;

/**
 * @author Ray Krueger
 */
public class LogConsequence implements Consequence<Object> {

    private static final Logger log = Logger.getLogger(LogConsequence.class);

    public boolean execute(Object fact) throws ConsequenceException {
        log.info("LogConsequence executed for fact [" + fact + "]");
        return false;
    }
}