package fr.aelion.models.course;

public abstract class Media {

    protected  String title;

    protected  String summary;

    protected  float duration;

    protected  Author author;

    public abstract void play();
}
