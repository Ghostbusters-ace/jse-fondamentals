package fr.aelion.repositories;

import fr.aelion.models.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        this.populate();
    }

    public Student findByNameAndPass(String login, String password){
        for (Student student : this.students){
            if ( student.getUsername() == login && student.getPassword() == password){
                return student;
            }
        }
        return null;
    }

    public int size(){
        return this.students.size();
    }
    private void populate(){
        Student student = new Student("bond", "James","stef@alion.fr");
        student.setUsername("bond");
        student.setPassword("007");

        System.out.println(student);

        //add student to list
        this.students.add(student);
    }
}
