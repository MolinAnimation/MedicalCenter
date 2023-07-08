package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableApponitment = new ArrayList<>();

    // problema de dispariedad con el uso del cero 0
    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointments");
            System.out.println("2. My scheduled appointmets");
            System.out.println("0. LogOut");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentMenu() {
        int response = 0;
        do {
            System.out.println();
            System.out.println(": :Add Available Appointment");
            System.out.println(": :Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4) {
                int monsthSelected = response;
                System.out.println(monsthSelected + ". " + UIMenu.MONTHS[monsthSelected - 1]);

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("You date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) {
                    continue;
                }
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Inster the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Yout time is : " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());

                } while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);

            } else if (response == 0) {
                showDoctorMenu();
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointment(Doctor doctor) {
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableApponitment.contains(doctor)) {
            doctorsAvailableApponitment.add(doctor);
        }
    }

}
