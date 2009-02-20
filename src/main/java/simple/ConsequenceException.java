package simple;

/**
 * @author Ray Krueger
 */
public class ConsequenceException extends RuntimeException {


    public ConsequenceException(String message) {
        super(message);
    }

    public ConsequenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsequenceException(Throwable cause) {
        super(cause);
    }
}
