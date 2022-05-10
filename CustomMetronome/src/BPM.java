import java.util.*;
import java.awt.*;

public class BPM
{
    private int bpm = 0;

    /**
     * void setBpm
     *
     * -will set the desired bpm for metronome
     */
    public void setBpm(int bpm)
    {
        this.bpm = bpm;
    }


    /**
     * int getBpm
     *
     * -will return current bpm of metronome
     */
    public int getBpm(){
        return this.bpm;
    }

    public int Delay()
    {
        return (60 / this.bpm) * 1000;
    }
}
