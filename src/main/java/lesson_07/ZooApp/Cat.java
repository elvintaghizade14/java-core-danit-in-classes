package lesson_07.ZooApp;

public class Cat extends Animal {
    public Cat(String name) {
        super.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }
}
