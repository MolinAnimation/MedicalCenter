package model;

public class Nurse extends User {

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDatauser() {
        System.out.println("Hospital: cruz roja");
        System.out.println("Especialidad: nutriologia");
    }

}
