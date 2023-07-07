package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = { "Enero", "Febrero", "Marzo", "Abril", "mayo", "Junio", "Juilo", "julio",
            "Agosto", "Septimebre", "Octubre", "Noviembre", "Dicimebre" };

    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("Doctor");
            System.out.println("Patient");
            System.out.println(" Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {
        // userType =1 Doctor

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro martinez", "alejandro@gmail.com"));
        doctors.add(new Doctor("Akaren sosa", "karen@gmail.com"));
        doctors.add(new Doctor("rocio gomez", "rocio@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("anahi salgado", "anahi@gmail.com"));
        patients.add(new Patient("andres salgado", "andresss@gmail.com"));
        patients.add(new Patient("sergio palomino", "sergio@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("insert yout email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1) {
                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        // obtener datos de usuario logeado
                        doctorLogged = d;
                        // show doctor menu
                    }
                }
            } else if (userType == 2) {
                for (Patient p : patients) {
                    if (p.getEmail().equals(email)) {
                        emailCorrect = true;
                        patientLogged = p;
                    }
                }
            }
        } while (!emailCorrect);
    }
}