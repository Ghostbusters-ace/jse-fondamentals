package fr.aelion.models.course;

public class Video extends Media{
    @Override
    public void play() {
        System.out.println("Je lance la video");
    }
}
