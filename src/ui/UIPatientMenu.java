package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Date;
import model.Doctor;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book new appointment");
            System.out.println("2. My appointments");
            System.out.println("0. LogOut");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
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
            System.out.println(":: Select Date");
            // numeracion lista de fechas
            // indice fecha seleccionada
            // [doctors]
            // 1.-doctor1
            // -1 fecha 1
            // -2 fecha 2
            // 2. -doctor 2
            // 3. -doctor3
            // crea el map externo
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            // contador
            int k = 0;
            // recorre la lista de doctores con citas disponibles
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                // crea un array de citas disponibles
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointment
                        .get(i).getAvailableAppointments();
                // crea un mapInterno key-doctor
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                // recorre el array de citas disponibles
                for (int j = 0; j < availableAppointments.size(); j++) {
                    // contador
                    k++;
                    // muestra las fechas en las que hay citas disponibles
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    // ingresa en map key-doctor con cita disponible
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointment.get(i));
                    // ingresa en el mapPrincipal valor(k)-mapInterno<int-doctor>
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            // map doctores con citas disponibles

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);

            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            // recorre al doctor seleccionado sacando la clave-valor inicializando indexDate
            // y al doctor.selecionado
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            // imprime al doctor seleccionado + fecha + hora de la cita
            System.out.println(doctorSelected.getName() + ". Date: "
                    + doctorSelected.getAvailableAppointments().get(indexDate).getDate() + ". Time "
                    + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm yout appointment: \n1. Yes \n 2. No");

            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatientMenu();
            }

        } while (response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println("::My Appointments");
            ;
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointments yet.");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println("Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " \nTime: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor());

            }
            System.out.println("0. Return");
        } while (response != 0);
    }
}
