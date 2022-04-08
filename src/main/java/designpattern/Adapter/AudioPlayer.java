package designpattern.Adapter;

import org.junit.Test;

public class AudioPlayer implements MediaPlay{
    AdvanceMediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equals("mp3")){
            System.out.println("mp3");
        }else if(audioType.equals("vlc") || audioType.equals("mp4")){
            mediaAdapter = new AdvanceMediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }
    }

    @Test
    public void test(){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","1");
        audioPlayer.play("vlc","2");
        audioPlayer.play("mp4","3");
    }
}
