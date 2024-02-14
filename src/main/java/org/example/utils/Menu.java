package main.java.org.example.utils;

import main.java.org.example.models.courses.Course;
import main.java.org.example.models.people.Student;
import main.java.org.example.models.people.Teacher;
import main.java.org.example.models.universities.University;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {

    static ImageIcon universityLogo = new ImageIcon("resources/GlobantUniversity_logo.png");

    public static void mainMenu(University u) {

        int mainMenu;

        do {

            String[] buttons = { "List of all Teachers", "List of all Classes", "List of all Students",
                    "Create a new Student",
                    "Create a new Class", "Classes a Student is in", "Exit" };

            mainMenu = JOptionPane.showOptionDialog(null, "Welcome to Globant University!\n please choose an option",
                    "Globant University - Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, universityLogo, buttons, buttons[0]);

            switch (mainMenu) {
                case 0:

                    JOptionPane.showMessageDialog(null, u.printTeachers(), "Teachers List",
                            JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 1:

                    String[] buttonsCL = u.getClassesButtons();
                    String classListMenu = JOptionPane.showInputDialog(null, u.printClasses(), "List of Classes",
                            JOptionPane.INFORMATION_MESSAGE, null, buttonsCL, buttonsCL[0]).toString();
                    handleUserInputClassList(classListMenu.substring(0, classListMenu.indexOf(" | ")), u);
                    break;

                case 2:

                    JOptionPane.showMessageDialog(null, u.printStudents(u.getStudentList()), "Students List",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    addStudent(u);
                    break;

                case 4:
                    addClass(u);
                    break;

                case 5:
                    classStudentIn(u);
                    break;

            }

        } while (mainMenu != 6);

    }

    private static void handleUserInputClassList(String classID, University u) {

        String print = "";
        String name = "";

        Course course = u.getClassByID(classID);
        name = course.getName();
        print = "<html> <strong> Displaying information for " + course.getName() + " </strong><br>"
                + "<br> Description: <br><font style = 'font-weight: normal;'>" + course.getDescription()
                + "</font><br>"
                + "Classroom: <br><font style = 'font-weight: normal;'>" + course.getClassroom() + "</font><br>"
                + "Weekly Hours: <br><font style = 'font-weight: normal;'>" + course.getWeeklyHours()
                + "</font><br>"
                + "Teacher & ID: <br><font style = 'font-weight: normal;'>"
                + course.getAssignedTeacher().getName() + " | " + course.getAssignedTeacher().getID()
                + "</font><br>"
                + "Student list: <br>"
                + u.printStudents(course.getStudentList())
                + "</font><br>";

        JOptionPane.showMessageDialog(null, print, name, JOptionPane.INFORMATION_MESSAGE);

    }

    private static void addStudent(University u) {

        String name = JOptionPane.showInputDialog("Please enter the student's name: ");
        int age = validateInt(JOptionPane.showInputDialog("Now please enter the student's age: "), u);

        String[] buttonsAS = u.getClassesButtons();
        String classListMenu = JOptionPane.showInputDialog(null,
                "Now please select the ID of class you want to enroll " + name + " in:",
                "Enroll student in a class",
                JOptionPane.QUESTION_MESSAGE, null, buttonsAS, buttonsAS[0]).toString();

        Student newStu = new Student(name, age, u.getStudentList().size() + 1);
        u.addStudent(newStu);
        u.getClassByID(classListMenu.substring(0, classListMenu.indexOf(" | "))).addStudent(newStu);

        JOptionPane.showMessageDialog(null,
                name + " Was successfully added to our DB with ID:" + newStu.getID() + " and to the "
                        + u.getClassByID(classListMenu.substring(0, classListMenu.indexOf(" | "))).getName()
                        + " class.",
                "Successfully added a student",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private static void addClass(University u) {

        String name = JOptionPane.showInputDialog("Please enter the class' name: ");
        String description = JOptionPane.showInputDialog("Please enter a description for " + name + ": ");
        String classroom = JOptionPane.showInputDialog("Please enter the classroom of " + name + ": ");
        int weeklyHours = validateInt(
                JOptionPane.showInputDialog("Now please enter the weekly hours for this class: "), u);
        Teacher assignedTeacher = null;
        List<Student> studentList = u.getStudentList();

        String[] buttonsAC_T = u.getTeachersButtons();
        String teacherListMenu = JOptionPane.showInputDialog(null,
                "Now please select the ID of the teacher that will dictate " + name + ":",
                "Select teacher", JOptionPane.QUESTION_MESSAGE, null, buttonsAC_T, buttonsAC_T[0]).toString();

        assignedTeacher = u.getTeacherByID(teacherListMenu.substring(0, teacherListMenu.indexOf(" | ")));

        int numStudents = validateInt(JOptionPane.showInputDialog(
                "Please the amount of students this class will start with (more can be added later): "), u);

        if (numStudents <= studentList.size()) {

            List<Student> studentList1 = new ArrayList<Student>();
            String[] buttonsAC_S = u.getStudentsButtons();

            for (int i = 0; i < numStudents; i++) {

                String studentListMenu = JOptionPane.showInputDialog(null,
                        "Please select your " + i + 1 + "° student to enroll in " + name + ": ",
                        "Select Students",
                        JOptionPane.QUESTION_MESSAGE, null, buttonsAC_S, buttonsAC_S[0]).toString();

                Student student = u.getStudentByID(studentListMenu.substring(0, studentListMenu.indexOf(" | ")));
                studentList1.add(student);
                buttonsAC_S = removeItem(buttonsAC_S, getIndexOf(buttonsAC_S, studentListMenu));

            }

            Course course = new Course(name, classroom, studentList1, assignedTeacher, weeklyHours,
                    u.getClassList().size() + 1, description);
            u.addClass(course);
            JOptionPane.showMessageDialog(null,
                    name + " Was successfully added to our DB with ID:" + course.getID(),
                    "Successfully added a class",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (numStudents <= studentList.size()) {

            JOptionPane.showMessageDialog(null,
                    "Invalid number of students, please enter a number lower than the amount of current active students: "
                            + studentList.size(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            mainMenu(u);

        }

    }

    private static void classStudentIn(University u) {

        String[] buttonsAC_S = u.getStudentsButtons();

        String stuMenu = JOptionPane.showInputDialog(null, "Please select the student to check: ",
                "Select Students",
                JOptionPane.QUESTION_MESSAGE, null, buttonsAC_S, buttonsAC_S[0]).toString();
        Student student = u.getStudentByID(stuMenu.substring(0, stuMenu.indexOf(" | ")));

        JOptionPane.showMessageDialog(null, u.getClassesofStudent(student), "Classes of " + student.getName(),
                JOptionPane.INFORMATION_MESSAGE);

    }

    private static String[] removeItem(String[] list, int index) {

        String[] removed = new String[list.length - 1];
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (flag == false && i != index) {
                removed[i] = list[i];
            } else if (i == index && i < list.length - 1 && flag == false) {
                flag = true;
                removed[i] = list[i + 1];
            } else if (i < list.length - 1) {
                removed[i] = list[i + 1];
            }
        }
        return removed;
    }

    private static int getIndexOf(String[] list, String item) {

        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (item.equals(list[i])) {
                index = i;
                break;
            }

        }
        return index;

    }

    private static int validateInt(String pane, University u) {

        int integer = 0;

        try {
            integer = Integer.parseInt(pane);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a number", "Error",
                    JOptionPane.ERROR_MESSAGE);
            mainMenu(u);
        }

        return integer;

    }

}
