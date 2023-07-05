package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User implements IScheduable {
    // Atributos
    String speciality;

    public Doctor(String name, String email) {
        super(name, email);
        System.out.println("Construyendo el Objeto Doctor");
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setAvailableAppointments(ArrayList<AvailableAppointment> availableAppointments) {
        this.availableAppointments = availableAppointments;
    }

    // Comportamientos
    // Crea array, almacenamiento objetos tipo AvailableAppointments (AA)
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    // Crea instancias de AA y las agrega al array
    public void addAvailableAppointment(Date date, String time) {
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    // retorna la lista de instancias guardada en el array (direccion stack)
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    // Creacion de la clase anidada citas disponibles (AA)
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;

        // Metodo constructor
        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        // getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime " + time;
        }
    }

    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'schedule'");
    }
}