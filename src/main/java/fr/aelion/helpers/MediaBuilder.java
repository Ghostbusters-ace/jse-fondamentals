package fr.aelion.helpers;

import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.models.course.*;

public class MediaBuilder implements Builder<Media> {

    private String title;

    private String summary;

    private Float duration;

    private Author author;

    private String mediaType;

    @Override
    public Media build() throws NotEnoughArgsException, NoMediaTypeException {

        if (this.author ==null || this. duration == null){

            throw new NotEnoughArgsException();
            //return Optional.empty();
        }

        if (this.mediaType == null){
            throw new NoMediaTypeException();
        }

        Media media = switch (this.mediaType.toUpperCase()) {
            case "VIDEO" -> new Video();
            case "DOCUMENT" -> new Document();
            case "SLIDE" -> new Slide();
            default ->
                //media = new Video();
                    null;
        };

        // Next.. fill attributes
        media.setTitle(this.title);
        media.setSummary(this.summary);
        media.setAuthor(this.author);
        media.setDuration(this.duration);

        return media;
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
