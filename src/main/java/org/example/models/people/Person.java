package main.java.org.example.models.people;

public abstract class Person {

    private String name;
    private int age;
    private String ID;

    public Person(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getID() {
        return this.ID;
    }

}
