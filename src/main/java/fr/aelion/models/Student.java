package fr.aelion.models;

public class Student extends Person {
    public String lastName;
    public String firstName;
    private String email;
    private String username;
    private String password;
    private boolean isLoggin = false;

    Person person;
    Student student;

    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
       this.student.setLastName(lastName);
    }

    public boolean login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            return isLoggin = true;
        } else {
            return isLoggin = false;
        }
    }

    public void logout() {
       this.isLoggin = false;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggin() { // Getter
        return this.isLoggin;
    }

    public void isLoggin(boolean isLoggin){ // Setter
        this.isLoggin = true;
    }
}
