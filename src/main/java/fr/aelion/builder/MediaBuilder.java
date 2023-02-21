package fr.aelion.builder;

import fr.aelion.interfaces.Builder;
import fr.aelion.models.course.*;

import java.util.Optional;

public class MediaBuilder implements Builder<Media> {

    private String title;

    private String summary;

    private Float duration;

    private Author author;

    private String mediaType;

    @Override
    public Optional <Media> build() {

        if (this.author ==null || this. duration == null){
            return Optional.empty();
        }

        Media media;

        switch (this.mediaType.toUpperCase()) {

            case "VIDEO":
                media = new Video();
                break;

            case "DOCUMENT":
                media = new Document();
                break;

            case "SLIDE":
                media = new Slide();
                break;

            default:
                //media = new Video();
                media = null;
        }

        // Next.. fill attributes
        media.setTitle(this.title);
        media.setSummary(this.summary);
        media.setAuthor(this.author);
        media.setDuration(this.duration);


        return Optional.of(media);
    }

    public MediaBuilder summary(String summary) {

        this.summary = summary;
        return this;
    }

    public MediaBuilder title(String title) {

        this.title = title;
        return this;
    }

    public MediaBuilder duration(Float duration) {

        this.duration = duration;
        return this;
    }

    public MediaBuilder author(Author author) {

        this.author = author;
        return this;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}