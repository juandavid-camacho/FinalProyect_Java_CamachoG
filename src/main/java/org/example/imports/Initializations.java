package main.java.org.example.imports;

import main.java.org.example.models.courses.Course;
import main.java.org.example.models.people.Student;
import main.java.org.example.models.people.Teacher;
import main.java.org.example.models.universities.University;

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

                List<Student> studentList1 = new ArrayList<Student>(Arrays.asList(
                                new Student[] { u.getStudentByID("STU1"), u.getStudentByID("STU3"),
                                                u.getStudentByID("STU5") }));

                classList.add(new Course("Intoduction to Programming", "A201", studentList1,
                                u.getTeacherByID("PROF1"), 4, 1, "Intro to basic programming in Java & Python"));

                List<Student> studentList2 = new ArrayList<Student>(Arrays.asList(
                                new Student[] { u.getStudentByID("STU2") }));

                classList.add(new Course("Object Oriented Programming", "B108",
                                studentList2, u.getTeacherByID("PROF2"), 6, 2,
                                "Basic Object Oriented Programming concepts in java aking into account the 4 pillars."));

                List<Student> studentList3 = new ArrayList<Student>(Arrays.asList(
                                new Student[] { u.getStudentByID("STU4"), u.getStudentByID("STU6") }));

                classList.add(new Course("Testing", "B108",
                                studentList3, u.getTeacherByID("PROF3"), 6, 3,
                                "Learning the basiscs of testing on web with selenium"));

                List<Student> studentList4 = new ArrayList<Student>(Arrays.asList(
                                new Student[] { u.getStudentByID("STU1"), u.getStudentByID("STU3") }));

                classList.add(new Course("Intro to UX", "C311",
                                studentList4, u.getTeacherByID("PROF4"), 4, 4,
                                "An introduction to the User Experience while browsing"));

                u.setClassList(classList);

        }

}
