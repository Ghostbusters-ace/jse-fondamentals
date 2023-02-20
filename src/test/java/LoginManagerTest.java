import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import fr.aelion.user.LoginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginManagerTest {

    LoginManager loginManager;
    @BeforeEach
    public void setup(){
        loginManager = new LoginManager("bond","007");
    }

    @Test
    @DisplayName("Login and password should be 'bond' and '007' ")
    public void haveCredentials(){
        assertAll("Credentials",
                () -> assertEquals("bond", loginManager.getLogin()),
                () -> assertEquals("007", loginManager.getPassword())
                );
    }

    @Test
    @DisplayName("should be godd one")
    public void goodCredentials(){
        assertEquals("200", this.loginManager.login());
    }

    @Test
    @DisplayName("should be 404")
    public void basCredentials(){
        LoginManager  loginManager1 = new LoginManager("ouf", "bad");

    }

    @Test
    @DisplayName("bien connecté")
    public void studentLogin(){
        StudentRepository studentRepository = this.loginManager.getStudentRepository();

        Student student = studentRepository.findByNameAndPass("bond","007");

        assertEquals(false, student.isLoggin());

        this.loginManager.login();

        assertEquals(true, student.isLoggin());
    }
}
