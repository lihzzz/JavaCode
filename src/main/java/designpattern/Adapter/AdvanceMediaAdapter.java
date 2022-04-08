package designpattern.Adapter;

public class AdvanceMediaAdapter implements MediaPlay{
    AdvanceMediaPlay advanceMediaPlay;

    public AdvanceMediaAdapter(String type){
        if(type.equals("vlc")){
            advanceMediaPlay = new VlcMediaPlay();
        }else if(type.equals("mp4")){
            advanceMediaPlay = new Mp4MediaPlay();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equals("vlc")){
            advanceMediaPlay.playVlc();
        }else if(audioType.equals("mp4")){
            advanceMediaPlay.playMp4();
        }
    }
}
