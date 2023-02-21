package fr.aelion;

import fr.aelion.models.Person;
import fr.aelion.models.Student;
import fr.aelion.run.CourseRun;
import fr.aelion.run.PersonRun;
import fr.aelion.run.StudentRun;

public class Main {

    private static Main app;

    public static void main(String[] args) {

        //PersonRun personRun = new PersonRun();
        //personRun.run();
        //StudentRun studentRun = new StudentRun();
        //new StudentRun().run();

        CourseRun courseRun = new CourseRun();
        courseRun.run();




    }
}
