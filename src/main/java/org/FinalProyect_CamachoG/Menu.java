package main.java.org.FinalProyect_CamachoG;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {

    static ImageIcon universityLogo = new ImageIcon("resources/GlobantUniversity_logo.png");

    public static void mainMenu(University u) {

        String[] buttons = { "List of Teachers", "List of Classes", "List of Students" };

        int mainMenu = JOptionPane.showOptionDialog(null, "Welcome to Globant University!\n please choose an option",
                "Globant University - Main Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, universityLogo, buttons, buttons[0]);

        switch (mainMenu) {
            case 0:
                JOptionPane.showMessageDialog(null, u.printTeachers(), "Teachers List",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            default:
                break;
        }

    }

}
