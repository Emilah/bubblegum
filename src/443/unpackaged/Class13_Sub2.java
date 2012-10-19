package unpackaged;

/* Class13_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.io.AudioInputStream;
import sun.audio.AudioPlayer;

public class Class13_Sub2 extends Class13
{
    public AudioInputStream inputstream = new AudioInputStream();
    
    public Class13_Sub2() {
	AudioPlayer.player.start(inputstream);
    }
    
    public void method187() {
	AudioPlayer.player.stop(inputstream);
	synchronized (inputstream) {
	    inputstream.aBoolean27 = true;
	}
    }
}
