package unpackaged;

/* Class41 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.ClassCheckRequest;
import com.jagex.world.Entity;
import com.jagex.utils.Timer;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.VarbitDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.JString;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import java.awt.Canvas;

public class Class41
{
    public static int anInt765;
    public static int queuedRegularRequests;
    public static JString aClass3_767;
    public static int anInt768 = 0;
    public static JString aClass3_769;
    public static JString aClass3_770;
    public static JString aClass3_771;
    public static JString aClass3_772
	= JString.create("Freunde");
    public static int anInt773 = 0;
    public static JString aClass3_774;
    public static int useWithWidgetId;
    public static int anInt776;
    public static boolean isCurrentRequestPriority;
    public static Canvas canvas;
    public static JString compassJstr;
    public static int anInt780;
    public static JString aClass3_781;
    public static volatile long aLong782;
    public static JString greenPrefixJstr;
    public static volatile int anInt784;
    
    public static synchronized void method891(int i_0_, int i_1_, boolean bool, AbstractFileLoader class9, int i_2_, int i_3_) {
	if (Class47.hasAudioHandler()) {
	    Class65.anInt1135 = -1;
	    FrameBuffer.loopMusic = bool;
	    Entity.anInt1730 = i_3_;
	    Class39_Sub5_Sub14.anInt1919 = i_1_;
	    Class39_Sub10.aClass9_1445 = class9;
	    Class39_Sub5_Sub5.aBoolean1749 = true;
	    Class23.anInt425 = i_0_;
	    JString.anInt1240 = -1;
	    Class65.anInt1143 = i_2_;
	}
    }
    
    public static synchronized void method892(byte i) {
	if (Class47.hasAudioHandler()) {
	    Timer.method941((byte) -77);
	    Class39_Sub5_Sub5.aBoolean1749 = false;
	    Class39_Sub10.aClass9_1445 = null;
	}
    }
    
    public static void method893(int i) {
	ArchiveWorker.aClass46_1206.reset(0);
	for (int i_4_ = 0; i_4_ < 32; i_4_++)
	    ClassCheckRequest.aLongArray1374[i_4_] = 0L;
	for (int i_5_ = 0; i_5_ < 32; i_5_++)
	    Class67.aLongArray1172[i_5_] = 0L;
	Class2.anInt50 = 0;
    }
    
    public static synchronized void method894(AbstractFileLoader class9, int i, int i_6_,
					      boolean loop, int i_7_, int i_8_,
					      int i_9_, int i_10_) {
	if (Class47.hasAudioHandler()) {
	    JString.anInt1240 = -1;
	    Class39_Sub5_Sub14.anInt1919 = i_8_;
	    Entity.anInt1730 = i;
	    Class65.anInt1135 = i_7_;
	    Class39_Sub10.aClass9_1445 = class9;
	    Class39_Sub5_Sub5.aBoolean1749 = true;
	    Class23.anInt425 = i_6_;
	    Class65.anInt1143 = i_10_;
	    FrameBuffer.loopMusic = loop;
	}
    }
    
    public static synchronized void method895(byte i) {
	if (Class47.hasAudioHandler()) {
	    if (Class39_Sub5_Sub5.aBoolean1749) {
		byte[] is = AbstractFileLoader.method160(Class23.anInt425, 2,
					     Entity.anInt1730,
					     Class39_Sub10.aClass9_1445,
					     Class39_Sub5_Sub14.anInt1919);
		if (is != null) {
		    if (Class65.anInt1135 < 0) {
			if (JString.anInt1240 >= 0)
			    Class26.method292(FrameBuffer.loopMusic,
					      false, JString.anInt1240,
					      Class65.anInt1143, is);
			else
			    ArchiveRequest.method857(Class65.anInt1143,
						   (FrameBuffer
						    .loopMusic),
						   is, false);
		    } else
			VarbitDefinition.method593(Class65.anInt1143, 1,
						    (FrameBuffer
						     .loopMusic),
						    is, Class65.anInt1135);
		    Class39_Sub5_Sub5.aBoolean1749 = false;
		    Class39_Sub10.aClass9_1445 = null;
		}
	    }
	    Class44.method912(-19093);
	}
    }
    
    public static synchronized void method896(int i) {
	Queue.method987(-30574);
    }
    
    public static void method897(int i) {
	aClass3_771 = null;
	aClass3_781 = null;
	canvas = null;
	aClass3_772 = null;
	greenPrefixJstr = null;
	aClass3_767 = null;
	aClass3_769 = null;
	compassJstr = null;
	aClass3_770 = null;
	aClass3_774 = null;
    }
    
    public static void method898(int i) {
	if (Class20.aClass13_395 != null) {
	    Class20.aClass13_395.method187();
	    Class20.aClass13_395 = null;
	}
	Class15.anInt274 = i;
    }
    
    public static synchronized void method899(int i, boolean bool, int i_11_, JString archiveName, boolean bool_12_, JString fileName, AbstractFileLoader fileLoader, int i_14_) {
	if (Class47.hasAudioHandler()) {
	    int archiveId = fileLoader.lookupArchive(archiveName);
	    int fileId = fileLoader.lookupFile(archiveId, fileName);
	    method894(fileLoader, archiveId, fileId, bool_12_, i_14_, i, -30, i_11_);
	}
    }
    
    public static synchronized void method900(byte i, int i_17_) {
	if (Class47.hasAudioHandler()) {
	    Class63.method1087(-26, i_17_);
	    Class39_Sub10.aClass9_1445 = null;
	    Class39_Sub5_Sub5.aBoolean1749 = false;
	}
    }
    
    static {
	aClass3_770 = JString.create("Konfig geladen)3");
	queuedRegularRequests = 0;
	aClass3_767 = (JString.create
		       ("Sie haben gerade eine andere Welt verlassen)3"));
	aClass3_774 = JString.create("Null");
	compassJstr = JString.create("compass");
	aClass3_769
	    = JString.create("Enter message to send to ");
	aClass3_771 = JString.create("backright2");
	greenPrefixJstr = JString.create("@gre@");
	anInt780 = 0;
	aClass3_781 = aClass3_769;
	anInt784 = 0;
	aLong782 = 0L;
    }
}
