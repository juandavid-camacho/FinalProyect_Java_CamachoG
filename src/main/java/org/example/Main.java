package main.java.org.example;

import main.java.org.example.imports.Initializations;
import main.java.org.example.models.universities.University;
import main.java.org.example.utils.Menu;

public class Main {
    public static void main(String[] args) {

        University u = new University();
        Initializations.fullInitializations(u);

        Menu.mainMenu(u);

    }
}