package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends Repository<Student> {

    private final DbConnect dbConnect;

    public StudentRepository(Class<Student> className) {
        super(className);
        this.dbConnect = PgConnect.getInstance();
    }

    /**
     * @return une list de student
     */
    protected List<Student> findAll() throws SQLException {

        ArrayList<Student> students = new ArrayList<>();

        //NEED SQL CRUD
        String sqlQuery = getSelectQuery() + " ORDER BY last_name, first_name;";

        //connect a la BDD
        Connection connection = this.dbConnect.connect();
        //Creer les statement a envoyer a la bdd
        Statement statement = connection.createStatement();
        // resultset contient les resultar du statement execute
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // get the resultat dans une boucle
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            //ajoute dans le tableau
            students.add(student);

        }

        //save ressources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();


        return students;
    }


    protected Student findByLoginAndPassword(String login, String password) throws SQLException, StudentException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        String sqlQuery = getSelectQuery() + " WHERE login = ? AND password = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            preparedStatement.close();
            resultSet.close();
            this.dbConnect.disconnect();

            return student;
        }
        preparedStatement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        throw StudentException.studentNotFound();
    }


    protected Student findByCredentials(String login, String password) throws SQLException, StudentException {

        Student student = new Student();
        String sqlQuery = "SELECT id, last_name, first_name, email, phone_number, login , password ";
        sqlQuery += "FROM student WHERE login ='" + login + "' AND password ='" + password + "' ORDER BY last_name, first_name";

        //connect a la BDD
        Connection connection = this.dbConnect.connect();
        //Creer les statement a envoyer a la bdd
        Statement statement = connection.createStatement();
        // resultset contient les resultar du statement execute
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // get the resultat dans une boucle

        if (!resultSet.next()) {
            throw StudentException.studentNotFound();
        } else {

            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

        }

        //save ressources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        //retourne l'etudiant
        return student;

    }

    protected Student findById(int id) throws SQLException, StudentException {
        Student student = new Student();
        String sqlQuery = getSelectQuery() + " WHERE id = ?;";

        //connect a la BDD
        Connection connection = this.dbConnect.connect();
        //Creer les statement a envoyer a la bdd
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1, id);
        // resultset contient les resultar du statement execute
        ResultSet resultSet = statement.executeQuery();

        // get the resultat dans une boucle

        if (!resultSet.next()) {
            throw StudentException.studentNotFound();
        } else {

            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

        }

        //save ressources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        //retourne l'etudiant
        return student;
    }
}
