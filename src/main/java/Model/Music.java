package Model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class is used to play music
 * @author Chung Hao Xian
 */

public class Music {

    MediaPlayer mediaPlayer;
    private String MUSIC_PATH = "src/main/resources/Media/FroggerMedia.mp3";

    public Music() {

    }

    /**
     * Method to locate mp3 file and play
     */
    public void playMusic() {
        String musicFile = MUSIC_PATH;
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * method to stop the music
     */
    public void stopMusic(){
        mediaPlayer.stop();

    }

}
