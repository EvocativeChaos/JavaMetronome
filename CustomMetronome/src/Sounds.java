import java.io.*;
import sun.audio.*;


public class Sounds
{
    public void ClaveSound()
    {
        String dir = "C:\\Users\\Angel Junior\\Desktop\\Game Music\\ClaveSoundClip\\ClaveBeatLong.wav";

        try
        {
            // ClassLoader CLDR = this.getClass().getClassLoader();
            // InputStream clave_beat = CLDR.getResourceAsStream(dir); // might be null...
            InputStream clave_beat = new FileInputStream(dir);
            AudioStream audioStream = new AudioStream(clave_beat);

            AudioPlayer.player.start(audioStream); // play the sound

        } catch (Exception ex) { System.out.println(ex.getMessage()); }

    }

}
