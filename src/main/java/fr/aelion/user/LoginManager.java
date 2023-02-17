package fr.aelion.user;

import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;

public class LoginManager {

    private String login;
    private String password;
    private StudentRepository studentRepository =  new StudentRepository();

    public LoginManager(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String  login(){
        if (this.login.equals(null) || this.password.equals(null)){
            return "403";
        }
        return this.studentRepository.findByNameAndPass(this.login,this.password) ? "200" : "404";
   }

    /**
     * if (this.studentRepository.findby){
     *     return "200"
     * }
     * return "404"
     */
    public void logout(){


    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
