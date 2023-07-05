public class User {
    private int id;
    private String name;
    private String email;
    private String adress;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 8) {
            System.out.println("El numero telefonico debe ser de 8 digitos maximo");

        } else if (phoneNumber.length() == 8) {
            this.phoneNumber = phoneNumber;
        }
    }

}
