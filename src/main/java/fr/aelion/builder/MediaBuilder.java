package fr.aelion.builder;

import fr.aelion.interfaces.Builder;
import fr.aelion.models.course.Media;

public class MediaBuilder implements Builder {

    String title;

    String summary;

    float duration;

    String author;
    String mediaType;

    public Media build(){

        return null;
    }

    public void summary(String summary){

    }


    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
