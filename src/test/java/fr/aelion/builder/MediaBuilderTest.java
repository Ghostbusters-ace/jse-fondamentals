package fr.aelion.builder;

import fr.aelion.models.course.Author;
import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MediaBuilderTest {
    private MediaBuilder mediaBuilder = new MediaBuilder();

    private  MediaBuilder badBuilder  = new MediaBuilder();
    @BeforeEach
    void setUp() {
        mediaBuilder.setMediaType("Video");
        mediaBuilder
                .title("Test")
                .summary("Joli test de builder")
                .author(new Author())
                .duration(5.35F);

        badBuilder.setMediaType("slide");
        badBuilder
                .title("No name")
                .summary("")
                .duration(null)
                .author(new Author());
    }

    @Test
    @DisplayName("Should be an instanceof Video class")
    void build() {
        assertTrue(mediaBuilder.build().get() instanceof Video);
    }

    @Test
    @DisplayName("Title should be 'Test'")
    void titleAttributeTest() {
        Media video = mediaBuilder.build().get();
        assertEquals("Test", video.getTitle());
    }
    @Test
    @DisplayName("Should have correct attribute values")
    void attributesTest(){
        Media video = mediaBuilder.build().get();
        Float duration = 5.35F;
        assertAll(
                () -> assertEquals("Test", video.getTitle()),
                () -> assertEquals("Joli test de builder", video.getSummary()),
                () -> assertEquals(duration, video.getDuration()),
                () -> assertTrue(video.getAuthor() instanceof Author)
        );
    }

    @Test
    @DisplayName("Should have bad attribute values")
    void notEnoughAttributesTest(){
        Media video = mediaBuilder.build().get();
        Float duration = 5.35F;
        assertAll(
                () -> assertTrue((badBuilder.build() instanceof Optional)),
                () -> assertTrue(badBuilder.build().isEmpty())

        );
    }
}