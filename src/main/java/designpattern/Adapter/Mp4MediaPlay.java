package designpattern.Adapter;

public class Mp4MediaPlay implements AdvanceMediaPlay{
    @Override
    public void playVlc() {

    }

    @Override
    public void playMp4() {
        System.out.println("play mp4");
    }
}
