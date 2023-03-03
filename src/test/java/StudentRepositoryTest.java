import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    StudentRepository studentRepository;

    @BeforeEach
    public void setup(){
        studentRepository = new StudentRepository(Student.class);
    }

   /* @Test
    @DisplayName("Student list should have 1 lement")
    public void studentInstanciationTest() throws SQLException {

        List<Student> students = studentRepository.findAll();
        assertEquals(100, students.size());
    }*/

   /* @Test
    @DisplayName("Should have Adam Paterne with id 89 as first result")
    public void firstStudentMustMatch() throws SQLException {
        List<Student> students = studentRepository.findAll();
        Student student = students.get(0);
        assertAll(
                () -> assertEquals("Adam", student.getLastName()),
                () -> assertEquals(89, student.getId()),
                () -> assertEquals("Paterne", student.getFirstName())
        );
    }*/

/*    @Test
    @DisplayName("Should find by login and password")
    void findByLoginAndPassword() throws SQLException, StudentException {

        Student student = studentRepository.findByLoginAndPassword("Adam.Paterne","RT3Sv50wqVgK9bzVKdHS");
        assertAll(
                () -> assertEquals("Adam.Paterne", student.getLogin()),
                () -> assertEquals("RT3Sv50wqVgK9bzVKdHS", student.getPassword())
        );
    }

    @Test
    @DisplayName("Should find by id")
    void findById() throws SQLException, StudentException {
        Student student = studentRepository.findById(89);
        assertAll(
                () -> assertEquals(89, student.getId()),
                () -> assertEquals("Adam", student.getLastName()),
                () -> assertEquals("Paterne", student.getFirstName())
        );
    }

    @Test
    @DisplayName("Should find by credentials")
    void findByCredentials() throws SQLException, StudentException {

        Student student = studentRepository.findByLoginAndPassword("Adam.Paterne","RT3Sv50wqVgK9bzVKdHS");
        assertAll(
                () -> assertEquals("Adam.Paterne", student.getLogin()),
                () -> assertEquals("RT3Sv50wqVgK9bzVKdHS", student.getPassword())
        );
    }*/

   /* @Test
    @DisplayName("Should raise an exception if the student is not found findByLoginAndPassword")
    void findByLoginAndPasswordNotFound() {
        assertThrows(StudentException.class, () -> {
            studentRepository.findByLoginAndPassword("bbla", "adsadsawq");
        });
    }

    @Test
    @DisplayName("Should raise an exception if the student is not found findById")
    void findByIdNotFound() {
        assertThrows(StudentException.class, () -> {
            studentRepository.findById(184951);
        });
    }*/

   /* @Test
    @DisplayName("Should return student from modele student")
    void shouldReturnTableName(){
        assertEquals("student", studentRepository.getTableName());
    }

    @Test
    @DisplayName("Should give 'student s' from Student class")
    void shouldGiveAliasedTableName() {
        assertEquals("student s", studentRepository.getAliasedTableName());
    }

    @Test
    @DisplayName("Should get all attributes from model")
    void shouldListAllAttributes() {
        String[] expectedFields = {"email", "firstName", "id", "lastName", "login", "password", "phoneNumber"};
        String[] classFields = studentRepository.getFields();
        Arrays.sort(classFields);

        assertTrue(Arrays.equals(expectedFields, classFields));
    }*/

  /*  @Test
    @DisplayName("Should return a comma separate list of column names")
    void shouldReturnCommaSeparatedList() {
        String expected = "s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number";
        assertEquals(expected, studentRepository.getCommaSeparatedColumns());
    }

    @Test
    @DisplayName("Should return a full SELECT query")
    void shouldReturnSelectQuery() {
        String expected = "SELECT s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number FROM student s";
        assertEquals(expected, studentRepository.getSelectQuery());
    }*/
}
