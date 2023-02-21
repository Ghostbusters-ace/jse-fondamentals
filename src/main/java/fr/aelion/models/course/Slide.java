package fr.aelion.models.course;

public class Slide extends Media {
    @Override
    public void play() {
        System.out.println("J'ouvre un onglet avec un Slide");
    }
}
