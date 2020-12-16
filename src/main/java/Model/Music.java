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
    private String musicFile = "src/main/resources/Media/FroggerMedia.mp3";
    private Media sound;
    public Music() {

    }

    /**
     * Method to locate mp3 file
     */
    public void openMusic(){
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    /**
     * Method to play music
     */
    public void playMusic() {
        openMusic();
        mediaPlayer.play();
    }

    /**
     * method to stop the music
     */
    public void stopMusic(){
        mediaPlayer.stop();
    }

    /**
     * Method to get the Music file currently playing, for test purpose
     * @return String of music file
     */
    public String getMusicFile(){
        return musicFile;
    }

}
