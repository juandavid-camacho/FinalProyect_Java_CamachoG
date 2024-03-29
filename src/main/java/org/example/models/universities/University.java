package main.java.org.example.models.universities;

import main.java.org.example.models.courses.Course;
import main.java.org.example.models.people.Student;
import main.java.org.example.models.people.Teacher;

import java.util.List;

public class University {

    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> classList;

    // empty constructor to declare in Main before initializing
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

    public void addStudent(Student student) {
        studentList.add(student);
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

    // the "print" methods will return a HTML formatted (for better display in
    // JOptionPanes) string will all the relevant info of a Student, Teacher or
    // Class
    public String printStudents(List<Student> specifiedStudentList) {

        String print = "<html> <strong> ID | Name | Age </strong><br>";

        for (Student student : specifiedStudentList) {

            print += "<font style = 'font-weight: normal;'>" + student.getID() + " | " + student.getName() + " | "
                    + student.getAge() + "</font><br>";

        }
        print += "</html>";
        return print;

    }

    // the "getButtons" methods will return an array of Strings that contain ID |
    // Name of the type specified, this is usefull to populate the buttons and
    // dropdown menus of JOptionPanes
    // Each respective ID will be later read on in Menu using the substring String
    // method
    public String[] getStudentsButtons() {

        String[] print = new String[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {

            print[i] = studentList.get(i).getID() + " | " + studentList.get(i).getName();

        }

        return print;

    }

    public String getClassesofStudent(Student student) {

        String print = "<html> The student " + student.getName()
                + " is in the following classes: <br><strong> ID | Name | Classroom | </strong><br>";

        for (Course course : classList) {

            if (course.isStudentInClass(student) == true) {

                print += "<font style = 'font-weight: normal;'>" + (course.getID() + " | " + course.getName() + " | "
                        + course.getClassroom() + "</font><br>");

            }

        }
        return print;
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

        String print = "<html><strong> ID | Name | Age | Hourly Salary | Weekly Hours | Monthly Salary | Full Time? |</strong><br>";

        for (Teacher teacher : teacherList) {

            print += "<font style = 'font-weight: normal;'>" + (teacher.getID() + " | " + teacher.getName() + " | "
                    + teacher.getAge() + " | "
                    + teacher.getBaseSalary() + " | " + teacher.getWeeklyHours() + " | " + teacher.getSalary() + " | ");
            print += (teacher.isPartTime()) ? "Part Time</font><br>" : "Full Time</font><br>";

        }
        print += "</html>";
        return print;

    }

    public String[] getTeachersButtons() {

        String[] print = new String[teacherList.size()];

        for (int i = 0; i < teacherList.size(); i++) {

            print[i] = teacherList.get(i).getID() + " | " + teacherList.get(i).getName();

        }

        return print;

    }

    public List<Course> getClassList() {
        return this.classList;
    }

    public void setClassList(List<Course> classList) {
        this.classList = classList;
    }

    public Course getClassByID(String ID) {

        Course course = null;

        for (Course course1 : classList) {

            if (ID.equals(course1.getID())) {
                course = course1;
            }

        }
        return course;

    }

    public String printClasses() {

        String print = "<html> <strong> ID | Name | Classroom | </strong><br>";

        for (Course course : classList) {

            print += "<font style = 'font-weight: normal;'>" + (course.getID() + " | " + course.getName() + " | "
                    + course.getClassroom() + "</font><br>");

        }
        print += "<br>Choose one of the options down below to learn more about a specific class: </html>";
        return print;

    }

    public String[] getClassesButtons() {

        String[] print = new String[classList.size()];

        for (int i = 0; i < classList.size(); i++) {

            print[i] = classList.get(i).getID() + " | " + classList.get(i).getName();

        }

        return print;

    }

    public void addClass(Course course) {
        classList.add(course);
    }

}
