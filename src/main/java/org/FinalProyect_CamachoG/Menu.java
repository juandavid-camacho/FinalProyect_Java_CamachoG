package main.java.org.FinalProyect_CamachoG;

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
                    int classListMenu = JOptionPane.showOptionDialog(null, u.printClasses(), "List of Classes",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttonsCL, buttonsCL[0]);
                    handleUserInputClassList(classListMenu, u);
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

            }

        } while (mainMenu != 6);

    }

    public static void handleUserInputClassList(int classListMenu, University u) {

        List<Course> classList = u.getClassList();
        String print = "";
        String name = "";

        for (int i = 0; i < classList.size(); i++) {

            if (i == classListMenu) {

                Course course = classList.get(i);
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

            }

        }

        JOptionPane.showMessageDialog(null, print, name, JOptionPane.INFORMATION_MESSAGE);

    }

    public static void addStudent(University u) {

        String name = JOptionPane.showInputDialog("Please enter the student's name: ");
        String age = JOptionPane.showInputDialog("Now please enter the student's age: ");

        String[] buttonsAS = u.getClassesButtons();
        int classListMenu = JOptionPane.showOptionDialog(null,
                "Now please select the ID of class you want to enroll " + name + " in:\nList of Classes: \n"
                        + u.printClasses(),
                "Enroll student in a class",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonsAS, buttonsAS[0]);

        for (int i = 0; i < u.getClassList().size(); i++) {

            if (i == classListMenu) {

                Student newStu = new Student(name, Integer.parseInt(age), u.getStudentList().size() + 1);
                u.addStudent(newStu);
                u.getClassList().get(i).addStudent(newStu);

                JOptionPane.showMessageDialog(null,
                        name + " Was successfully added to our DB with ID:" + newStu.getID() + " and to the "
                                + u.getClassList().get(i).getName() + " class.",
                        "Successfully added a student",
                        JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    public static void addClass(University u) {

        String name = JOptionPane.showInputDialog("Please enter the class' name: ");
        String description = JOptionPane.showInputDialog("Please enter a description for " + name + ": ");
        String weeklyHours = JOptionPane.showInputDialog("Now please enter the weekly hours for this class: ");
        Teacher assignedTeacher = null;

        String[] buttonsAC_T = u.getTeachersButtons();
        int teacherListMenu = JOptionPane.showOptionDialog(null,
                "Now please select the ID of the teacher that will dictate " + name + ".\n List of teachers: "
                        + u.printClasses(),
                "Select teacher",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonsAC_T, buttonsAC_T[0]);

        for (int i = 0; i < u.getTeacherList().size(); i++) {
            if (i == teacherListMenu) {
                assignedTeacher = u.getTeacherList().get(i);
            }
        }

    }

}
