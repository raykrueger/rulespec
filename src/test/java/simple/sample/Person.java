package simple.sample;

/**
 * @author Ray Krueger
 */
public class Person {

    private final int age;
    private final int height;

    public Person(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}
