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

    public StudentRepository getStudentRepository() {
        return this.studentRepository;
    }
    public String  login(){
        if (this.login.equals(null) || this.password.equals(null)){
            return "403";
        }
        // autre facon mettre (student instanof Student) dans if
        Student student = this.studentRepository.findByNameAndPass(this.login,this.password);
        if (this.studentRepository.findByNameAndPass(this.login, this.password) instanceof Student){
            student.isLoggin(true);
return "200";
        }
        //return this.studentRepository.findByNameAndPass(this.login,this.password) ? "200" : "404";
        return "404";
   }

    /**
     * if (this.studentRepository.findby){
     *     return "200"
     * }
     * return "404"
     */
    public void logout(){
    Student student =  this.studentRepository.findByNameAndPass(this.login, this.password);
    if ( student instanceof Student ){

    }

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
