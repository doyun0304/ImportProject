package render;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Sound {
    private Clip clip;
    private File[] soundFile = new File[11];
    private static final String assetPath = "src/assets/";

    public Sound(){
        soundFile[0] = new File(assetPath+"stage_0_music.wav");
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        if(clip!=null) clip.stop();
    }
}
