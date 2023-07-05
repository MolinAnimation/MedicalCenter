public class Patient extends User {
    String birthday;
    double weight;
    double height;
    String blodd;

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
        return this.blodd;
    }

    public void setBlodd(String blodd) {
        this.blodd = blodd;
    }

}
