package simple.base;

import simple.Condition;

/**
 * @author Ray Krueger
 */
public class Conditions {

    private Conditions() {
    }

    public static <T extends Comparable> Condition<T> greaterThan(T t) {
        return new GreaterThanCondition<T>(t);
    }

    public static <T extends Comparable> Condition<T> lessThan(T t) {
        return new LessThanCondition<T>(t);
    }

    public static <T> Condition<T> equalTo(T t) {
        return new EqualsCondition<T>(t);
    }

    public static <T extends Comparable> Condition<T> greaterThanOrEqualTo(T t) {
        return greaterThan(t).or(equalTo(t));
    }

    public static <T extends Comparable> Condition<T> lessThanOrEqualTo(T t) {
        return lessThan(t).or(equalTo(t));
    }

    public static Condition<String> like(String regex) {
        return new LikeCondition(regex);
    }
}
