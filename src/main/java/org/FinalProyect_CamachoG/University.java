package main.java.org.FinalProyect_CamachoG;

import java.util.List;

public class University {

    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> classList;

    public University() {

    }

    public University(List<Student> studentList, List<Teacher> teacherList, List<Course> classList) {
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.classList = classList;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudentByID(String ID) {

        Student stu = null;

        for (Student student : studentList) {

            if (ID.equals(student.getID())) {
                stu = student;
            }

        }
        return stu;

    }

    public List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public Teacher getTeacherByID(String ID) {

        Teacher tea = null;

        for (Teacher teacher : teacherList) {

            if (ID.equals(teacher.getID())) {
                tea = teacher;
            }

        }
        return tea;

    }

    public String printTeachers() {

        String print = "<html> <strong> ID | Name | Age | Hourly Salary | Weekly Hours | Monthly Salary | Full Time? |</strong><br>";

        for (Teacher teacher : teacherList) {

            print += "<font style = 'font-weight: normal;'>" + (teacher.getID() + " | " + teacher.getName() + " | "
                    + teacher.getAge() + " | "
                    + teacher.getBaseSalary() + " | " + teacher.getWeeklyHours() + " | " + teacher.getSalary() + " | ");
            print += (teacher.isPartTime()) ? "Part Time</font><br>" : "Full Time</font><br>";

        }
        print += "</html>";
        return print;

    }

    public List<Course> getClassList() {
        return this.classList;
    }

    public void setClassList(List<Course> classList) {
        this.classList = classList;
    }

}
