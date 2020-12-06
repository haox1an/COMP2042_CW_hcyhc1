package Model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Music {

    MediaPlayer mediaPlayer;
    private String MUSIC_PATH = "file:src/main/resources/Img/FroggerMedia.mp3";

    public Music() {

    }

    public void playMusic() {
        String musicFile = MUSIC_PATH;
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic(){
        mediaPlayer.stop();

    }

    public void muteMusic(){
        mediaPlayer.setMute(true);
    }

    public void unmuteMusic(){
        mediaPlayer.setMute(false);
    }
}
