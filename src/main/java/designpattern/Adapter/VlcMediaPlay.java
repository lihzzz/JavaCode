package designpattern.Adapter;

public class VlcMediaPlay implements AdvanceMediaPlay{
    @Override
    public void playVlc() {
        System.out.println("play vlc");
    }

    @Override
    public void playMp4() {

    }
}
