package simple;

/**
 * @author Ray Krueger
 */
public interface RuleSet<T> {

    Class<T> getSupportedType();

    boolean supports(Class cls);

    Rule<T>[] getRules();

}
