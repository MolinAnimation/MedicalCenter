package model;

public class Patient extends User {
    String birthday;
    double weight;
    double height;
    String blood;

    public Patient(String name, String email) {
        super(name, email);
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlodd() {
        return this.blood;
    }

    public void setBlodd(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\n Weight: " + getWeight() + "\n Height" + getHeight()
                + "\nBlood" + blood;
    }
}
