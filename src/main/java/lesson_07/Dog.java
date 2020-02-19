package lesson_07;

public class Dog extends Animal {
    public Dog(String name) {
        super.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + '}';
    }
}
