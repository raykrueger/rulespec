package simple;

/**
 * @author Ray Krueger
 */
public interface Consequence<T> {
    boolean execute(T fact) throws ConsequenceException;
}
