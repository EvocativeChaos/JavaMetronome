import java.io.InputStream;
import java.util.*;
import java.awt.*;

public class Metronome
{

    // everything called into here from this Class must be static
    public static void main(String[] args)
    {
        System.out.println("Starting...");

        BPM metronome_0 = new BPM();
        Sounds click_0 = new Sounds();
        Scanner input = new Scanner(System.in);


        // How would we handle incorrect output?
        System.out.println("Enter desired Beats Per Minute: ");
        short bpm = input.nextShort();
        metronome_0.setBpm(bpm);

        // How Long do you want program to run option (in minutes)
        System.out.println("How long do you want metronome to run?");
        System.out.println("Enter mins, or -1 if you want it to run until Heat Death");
        long time = input.nextLong();


        // *** SOLVED *** IT NEEDED TO BE A FLOAT!
        // BUG! BPM starts ok, but then it slows down or speeds up
        // pot sols: create a separate class for this? NO!
        if (time == -1)
        {
            InfiniteRun(metronome_0, click_0);
        }

        else
        {
            TimedRun(time, metronome_0, click_0);
        }
    }


    private static void InfiniteRun(BPM metronome, Sounds click)
    {
        System.out.println("UNTIL BLACK HOLES DO APART"); // inform user of its action

        while (true)
        {
            while (true)
            {
                try
                {
                    // to play another sound
                    // https://stackoverflow.com/questions/27533617/play-sound-on-button-click
                    //Toolkit.getDefaultToolkit().beep();
                    click.ClaveSound();
                    System.out.println("beep! BPM is " + metronome.getBpm());


                    Thread.sleep((long)(1000 * (60.0 / metronome.getBpm())));

                } catch (Exception ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }
        }
    }


    /**
     * private static void TimedRun
     * - will run the metronome for x desired mins
     *
     * BUGS:
     * - timer not running for appropriate time
     *
     * pot sols:
     * - implementing a Runnable
     * - other methods/approaches to the Time Class
     * - https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java (See Runnable)
     */

    private static void TimedRun(long mins, BPM metronome, Sounds click)
    {
        System.out.println("Running for " + mins + " minutes.");

        Timer program_timer = new Timer();

        program_timer.schedule(new TimerTask() {
            @Override // what the heck does this do?
            public void run() {

                while (true)
                {
                    try
                    {
                        // to play another sound
                        // https://stackoverflow.com/questions/27533617/play-sound-on-button-click
                        //Toolkit.getDefaultToolkit().beep();
                        click.ClaveSound();
                        System.out.println("beep! BPM is " + metronome.getBpm());


                        Thread.sleep((long)(1000 * (60.0 / metronome.getBpm())));

                    } catch (Exception ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

            }
        }, 0, mins*60*1000);
    }
}
