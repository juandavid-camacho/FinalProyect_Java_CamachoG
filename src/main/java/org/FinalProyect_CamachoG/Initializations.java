package main.java.org.FinalProyect_CamachoG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializations {

    public static void fullInitializations(University u) {

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Juan", 21, 1));
        studentList.add(new Student("Maria Paula", 22, 2));
        studentList.add(new Student("Ivan", 20, 3));
        studentList.add(new Student("Mariana", 25, 4));
        studentList.add(new Student("José", 19, 5));
        studentList.add(new Student("Isabella", 28, 6));

        u.setStudentList(studentList);

        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(new Teacher("Luis", 41, 10000, 40, false, 1));
        teacherList.add(new Teacher("Ximena", 38, 10000, 40, false, 2));
        teacherList.add(new Teacher("Gabriel", 52, 8000, 20, true, 3));
        teacherList.add(new Teacher("Sonia", 43, 15000, 15, true, 4));

        u.setTeacherList(teacherList);

        List<Course> classList = new ArrayList<Course>();
        classList.add(new Course("Intoduction to Programming", "A201", Arrays.asList(
                new Student[] { u.getStudentByID("STU1"), u.getStudentByID("STU3"), u.getStudentByID("STU5") }),
                u.getTeacherByID("PROF1"), 4, "Intro to programming in Java & Python"));
        classList.add(new Course("Object Oriented Programming", "B108",
                Arrays.asList(new Student[] { u.getStudentByID("STU2") }), u.getTeacherByID("PROF2"), 6,
                "POO in Java"));

    }

}
