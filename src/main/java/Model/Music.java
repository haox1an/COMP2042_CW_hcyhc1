package Model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Music {

    MediaPlayer mediaPlayer;
    public static final String MUSIC_PATH = "src/main/resources/Media/FroggerMedia.mp3";
    public Music() {

    }

    public void playMusic() {
        String musicFile = MUSIC_PATH;
        Media sound = new Media(new File(MUSIC_PATH).toURI().toString());
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
