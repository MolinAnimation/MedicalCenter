package ui;

import java.util.Scanner;

public class UIPatienteMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book new appointment");
            System.out.println("2. My appointments");
            System.out.println("0. LogOut");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("Book an appointment");
            System.out.println();

        } while (response != 0);
    }
}
