package fr.aelion.repositories;

import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        this.populate();
    }

    public boolean findByNameAndPass(String login, String password){
        for (Student student : this.students){
            if ( student.getUsername() == login && student.getPassword() == password){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.students.size();
    }
    private void populate(){
        Student student = new Student("bond", "James","stef@alion.fr");
        student.setUsername("bond");
        student.setPassword("007");

        //add student to list
        this.students.add(student);
    }
}
