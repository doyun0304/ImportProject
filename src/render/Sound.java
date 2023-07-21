package render;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.net.URL;

public class Sound {
    private Clip clip;
    private FloatControl floatControl;
    private boolean muted = false;
    private float volume = 0.0f;
    private float previousVolume = 0.0f;
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
            floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void play(){
        clip.start();
        floatControl.setValue(volume);
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        if(clip!=null) clip.stop();
    }

    public void volumeUp() {
        volume += 1.0f;
        if(volume > 6.0f) volume = 6.0f;

        muted = false;

        floatControl.setValue(volume);
    }

    public void volumeDown() {
        volume -= 0.1f;
        if(volume < -80.0f) volume = -80.0f;

        floatControl.setValue(volume);
    }

    public void mute() {
        if(muted) {
            muted = false;

            volume = previousVolume;
        }

        else {
            muted = true;

            previousVolume = volume;
            volume = -80.0f;
        }

        floatControl.setValue(volume);
    }

    public void setVolume(float volume) {
        muted = false;
        this.volume = volume;
    }

    public boolean isMuted() {
        return muted;
    }
}
