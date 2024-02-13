package main.java.org.example.models.people;

public class Student extends Person {

    public Student(String name, int age, int ID) {
        super(name, age, "STU" + ID);
    }

}
