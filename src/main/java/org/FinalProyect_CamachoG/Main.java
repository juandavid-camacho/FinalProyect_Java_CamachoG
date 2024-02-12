package main.java.org.FinalProyect_CamachoG;

public class Main {
    public static void main(String[] args) {

        University u = new University();
        Initializations.fullInitializations(u);

        Menu.mainMenu(u);

    }
}