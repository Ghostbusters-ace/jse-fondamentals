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

    public void setCourse(Course course) {
        this.course = course;
    }
}
