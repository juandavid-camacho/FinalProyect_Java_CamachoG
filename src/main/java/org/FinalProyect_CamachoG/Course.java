package main.java.org.FinalProyect_CamachoG;

import java.util.List;

public class Course {

    private String name;
    private String description;
    private String classroom;
    private List<Student> studentList;
    private Teacher assignedTeacher;
    private int weeklyHours;

    public Course(String name, String classroom, List<Student> studentList, Teacher assignedTeacher, int weeklyHours,
            String description) {
        this.name = name;
        this.classroom = classroom;
        this.studentList = studentList;
        this.assignedTeacher = assignedTeacher;
        this.weeklyHours = weeklyHours;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getAssignedTeacher() {
        return this.assignedTeacher;
    }

    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeeklyHours() {
        return this.weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public void addWeeklyHours(int hoursToAdd) {
        weeklyHours += hoursToAdd;
    }

}
