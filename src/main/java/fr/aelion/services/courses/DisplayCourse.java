package fr.aelion.services.courses;

import fr.aelion.repositories.course.Course;

public class DisplayCourse {

    private Course course;

    public void display(){
        System.out.println("Course : " + course.getTitle());
        //next display the list of title of specific Medias
        course.getMedias().forEach(media -> {
            System.out.println(media.getTitle());
        });
    }

    public String displaBuilder(){
        String [] output = new  String[1];
        output[0] = "Course : " + course.getTitle() + "\n";
        //next display the list of title of specific Medias
        course.getMedias().forEach(media -> {
            output[0] += media.getTitle() + "\n";
        });

        return output[0];
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
