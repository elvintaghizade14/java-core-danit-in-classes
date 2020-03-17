package module_01.lesson_07.ZooApp;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Animal{name='%s'}", name);
    }
}