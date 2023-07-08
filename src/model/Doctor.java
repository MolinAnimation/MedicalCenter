package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User implements IScheduable {
    // Atributos
    String speciality;

    // metodo constructor
    public Doctor(String name, String email) {
        super(name, email);
    }

    // getters & setters
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
    public void addAvailableAppointment(String date, String time) {
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        // Metodo constructor
        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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

        public String getDate(String date) {
            return format.format(date);
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

    @Override
    public void showDatauser() {
        System.out.println("Hospital: Cruz roja");
        System.out.println("Departamento: Oncologia");
    }
}