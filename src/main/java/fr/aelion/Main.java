package fr.aelion;

import fr.aelion.models.Person;
import fr.aelion.models.Student;

public class Main {

    private static Main app;

    public static void main(String[] args) {
        app = new Main();
        if (app instanceof Main){
            System.out.println("You are a Main object");
        } else {
            System.out.println("You are not a Main objet ");
        }
        System.out.println("i'm the main method");

        app.userlife();

    }

    // constructeur de classe Main qui s'execute quan instancie
    public Main() {
        Person jL= new Person();
        jL.setLastName("Aubert");
        jL.setFirstName("Jean-Luc");
        jL.setEmail("jean.luc@aelion.fr");
        jL.setPhoneNumber("06 11 11 11 11");

        System.out.println("my name is " + jL.greetings());

        Person jT= new Person();
        jT.setLastName("Talut");
        jT.setFirstName("Jean");
        jT.setEmail("jean.talut@aelion.fr");
        jT.setPhoneNumber("06 44 44 44 44");

        System.out.println("my name is "+ jT.greetings());

        Person mel= new Person("flemme", "mel", "06 51 51 51 51","mel@aelion.fr");
        System.out.println("my name is " + mel.greetings());

        Person bond = new Person("Bond","james.bond@mi16.co.uk");
        System.out.println("my name is " +  bond.greetings());
    }
    public Main(String name) {
        System.out.println("hello" + name);
    }
    public void userlife() {
        Student student = new Student("pierre", "gwen","stef@alion.fr");
        student.setUsername("useme");
        student.setPassword("usemoi");

        if (student.isLoggin()){
            if(!student.login("useme", "usemoi")){
            System.out.println( "yo "+ student.firstName + " " + student.lastName );
            }else{
                System.out.println("vai foder ");
            }

        }
        if(student.isLoggin()) {
            student.logout();
        }
            if(!student.login("frere", "toi")){
              
                System.out.println("vai foder ");
            }

    }
}
