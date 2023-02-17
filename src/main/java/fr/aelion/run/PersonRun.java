package fr.aelion.run;

import fr.aelion.models.Person;
import fr.aelion.models.Student;

public class PersonRun {

    public void run() {
        Person jL = new Person();
        jL.setLastName("Aubert");
        jL.setFirstName("Jean-Luc");
        jL.setEmail("jean.luc@aelion.fr");
        jL.setPhoneNumber("06 11 11 11 11");

        System.out.println("my name is " + jL.greetings());

        Person jT = new Person();
        jT.setLastName("Talut");
        jT.setFirstName("Jean");
        jT.setEmail("jean.talut@aelion.fr");
        jT.setPhoneNumber("06 44 44 44 44");

        System.out.println("my name is " + jT.greetings());

        Person mel = new Person("flemme", "mel", "06 51 51 51 51", "mel@aelion.fr");
        System.out.println("my name is " + mel.greetings());

        Person bond = new Person("Bond", "james.bond@mi16.co.uk");
        System.out.println("my name is " + bond.greetings());
    }
}
