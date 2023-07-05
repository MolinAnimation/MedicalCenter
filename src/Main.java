import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // showMenu();
        // Crea instancia de doctor
        Doctor myDoctor = new Doctor("Anahi­ Salgado", "Pediatria");
        System.out.println(myDoctor.name);
        System.out.println(myDoctor.speciality);

        // agrega fechas citas disponibles
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        // for each por cada instancia almacenada en el array retornado por getAA llama
        // a sus getters de time y date y los muestra por consola
        // crea una variable aA que representa en cada iteracion al objeto
        // correspondiente dnetro del array list
        for (Doctor.AvailableAppointment aA : myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }
    }

}