package lesson_07;

public class Cat extends Animal {

    public Cat(String name) {
        super.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }
}
