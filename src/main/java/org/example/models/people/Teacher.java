package main.java.org.example.models.people;

public class Teacher extends Person {

    private double baseSalary;
    private double salary;
    private int weeklyHours;
    private boolean partTime;

    public Teacher(String name, int age, double baseSalary, int weeklyHours, boolean partTime, int ID) {
        super(name, age, "PROF" + ID);
        this.baseSalary = baseSalary;
        this.weeklyHours = weeklyHours;
        this.partTime = partTime;
        calculateSalary(baseSalary, weeklyHours, partTime);
    }

    private void calculateSalary(double baseSalary, int hours, boolean partTime) {

        if (partTime) {

            salary = baseSalary * hours * 4;

        } else {

            salary = baseSalary * hours * 4 * 1.1;

        }

    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWeeklyHours() {
        return this.weeklyHours;
    }

    public void setWeeklyHours(int hours) {
        this.weeklyHours = hours;
    }

    public boolean isPartTime() {
        return this.partTime;
    }

    public void setPartTime(boolean partTime) {
        this.partTime = partTime;
    }
}