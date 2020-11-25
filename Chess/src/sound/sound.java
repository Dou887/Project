package sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class sound {

    private Clip clip;
    public sound(String soundFile) {
        try {
            // Use URL (instead of File) to read from disk and JAR.
            URL url = this.getClass().getResource(soundFile);
            // Set up an audio input stream piped from the sound file.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(boolean loop){
        if(clip.isRunning()){
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
        if(loop){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    public void stop(){
        clip.stop();
        clip.setFramePosition(0);
    }


}
