

import Model.Music;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicTest {
    Music music;
    @BeforeEach
    void setup() throws Exception{
        music = new Music();
    }

    /**
     * Test if the music file in the application is the correct file
     */
    @Test
    void playMusic() {
        assertEquals("src/main/resources/Media/FroggerMedia.mp3", music.getMusicFile());

    }
}