package fr.aelion.repositories;

import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> students = new ArrayList<>();

    public StudentRepository() {
        this.populate();
    }

    private void populate(){
        Student student = new Student("pierre", "gwen","stef@alion.fr");
        student.setUsername("useme");
        student.setPassword("usemoi");

        //add student to list
        this.students.add(student);
    }
}
