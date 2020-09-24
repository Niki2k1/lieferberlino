package de.oszimt.objects;

public class Session {

    private String username;
    private String mail;
    private String[] address;
    private String firstName;
    private String lastName;
    private Integer age;

    /**
     * Getter & Setter.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String[] getAddress() {
        return address;
    }
    public Integer getAge() {
        return age;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMail() {
        return mail;
    }
    public String getUsername() {
        return username;
    }
}
