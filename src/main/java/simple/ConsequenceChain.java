package simple;

/**
 * @author Ray Krueger
 */
public class ConsequenceChain<T> implements Consequence<T> {

    private final Consequence<T>[] consequences;

    public ConsequenceChain(Consequence<T>[] consequences) {
        if (consequences == null || consequences.length == 0) {
            throw new IllegalArgumentException("consequence array must not be null or zero-length");
        }
        this.consequences = consequences;
    }

    public boolean execute(T fact) throws ConsequenceException {
        boolean modified = false;
        for (Consequence<T> consequence : consequences) {
            modified = consequence.execute(fact) || modified;
        }
        return modified;
    }
}
