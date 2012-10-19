package unpackaged;

import com.jagex.graphics.GouraudVertex;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.script.ScriptState;
import com.jagex.utils.Timer;
import com.jagex.world.Mob;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.JMouseListener;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;

/* Class39_Sub5_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub5_Sub5 extends SubNode
{
    public static JString aClass3_1735
	= JString.create("Versteckt");
    public static JString aClass3_1736;
    public static JString aClass3_1737;
    public static JString aClass3_1738;
    public static int anInt1739 = 0;
    public static AbstractFileLoader aClass9_1740;
    public static JString aClass3_1741;
    public static int anInt1742 = 3353893;
    public static JString aClass3_1743
	= JString.create("Your account is already logged in)3");
    public static JString aClass3_1744;
    public static JString aClass3_1745;
    public int anInt1746 = 0;
    public static JString aClass3_1747;
    public static AbstractFileLoader aClass9_1748;
    public static boolean aBoolean1749;
    /*synthetic*/ public static Class aClass1750;
    
    public static void method569(byte i) {
	if (Timer.anInt887 == 1) {
	    if (Class39_Sub4.mouseClickPositionX >= 6 && Class39_Sub4.mouseClickPositionX <= 106
		&& Bzip2Entry.mouseClickPositionY >= 467 && Bzip2Entry.mouseClickPositionY <= 499) {
		Projectile.anInt2203++;
		Bzip2Entry.anInt1051 = (Bzip2Entry.anInt1051 + 1) % 4;
		Class14.aBoolean245 = true;
		Mob.aBoolean2253 = true;
		FrameBuffer.outgoingBuffer.putFrame(76);
		FrameBuffer.outgoingBuffer
		    .putByte(Bzip2Entry.anInt1051);
		FrameBuffer.outgoingBuffer
		    .putByte(NameTable.anInt177);
		FrameBuffer.outgoingBuffer
		    .putByte(Cache.anInt118);
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 135 && Class39_Sub4.mouseClickPositionX <= 235
		&& Bzip2Entry.mouseClickPositionY >= 467 && Bzip2Entry.mouseClickPositionY <= 499) {
		Projectile.anInt2203++;
		NameTable.anInt177 = (NameTable.anInt177 + 1) % 3;
		Mob.aBoolean2253 = true;
		Class14.aBoolean245 = true;
		FrameBuffer.outgoingBuffer.putFrame(76);
		FrameBuffer.outgoingBuffer
		    .putByte(Bzip2Entry.anInt1051);
		FrameBuffer.outgoingBuffer
		    .putByte(NameTable.anInt177);
		FrameBuffer.outgoingBuffer
		    .putByte(Cache.anInt118);
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 273 && Class39_Sub4.mouseClickPositionX <= 373
		&& Bzip2Entry.mouseClickPositionY >= 467 && Bzip2Entry.mouseClickPositionY <= 499) {
		Mob.aBoolean2253 = true;
		Cache.anInt118 = (Cache.anInt118 + 1) % 3;
		Projectile.anInt2203++;
		Class14.aBoolean245 = true;
		FrameBuffer.outgoingBuffer.putFrame(76);
		FrameBuffer.outgoingBuffer
		    .putByte(Bzip2Entry.anInt1051);
		FrameBuffer.outgoingBuffer
		    .putByte(NameTable.anInt177);
		FrameBuffer.outgoingBuffer
		    .putByte(Cache.anInt118);
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 412 && Class39_Sub4.mouseClickPositionX <= 512
		&& Bzip2Entry.mouseClickPositionY >= 467 && Bzip2Entry.mouseClickPositionY <= 499) {
		if (StillObject.viewOverlayId == -1) {
		    TextureLoaderImpl.closeOverlays();
		    if (GouraudVertex.anInt907 != -1) {
			Class39_Sub12.aBoolean1487 = false;
			Class26.anInt473 = StillObject.viewOverlayId
			    = GouraudVertex.anInt907;
			Class66.reportUsername = Class66.blankString;
		    }
		} else
		    JMouseListener.printMessage(0,Class66.blankString,
				      MouseRecorder.aClass3_572);
	    }
	}
    }
    
    public void method570(byte i, Buffer class39_sub6, int i_0_) {
	if (i >= 9) {
	    if (i_0_ == 2)
		anInt1746 = class39_sub6.getUword();
	}
    }
    
    public static void method571(int i) {
	aClass3_1735 = null;
	aClass3_1743 = null;
	aClass3_1747 = null;
	aClass3_1745 = null;
	aClass3_1744 = null;
	aClass3_1741 = null;
	aClass9_1740 = null;
	aClass3_1737 = null;
	aClass9_1748 = null;
	aClass3_1738 = null;
	aClass3_1736 = null;
    }
    
    public void method572(Buffer class39_sub6, byte i) {
	for (;;) {
	    int i_1_ = class39_sub6.getUbyte();
	    if (i_1_ == 0)
		break;
	    method570((byte) 31, class39_sub6, i_1_);
	}
	int i_2_ = 111 / ((i + 88) / 34);
    }
    
    public static void method573(int i) {
	if (Class20.aClass13_395 != null) {
	    long l = Class2.getSystemTime();
	    if (VarpDefinition.aLong1985 < l) {
		Class20.aClass13_395.method193(l);
		int i_3_ = (int) (l + -VarpDefinition.aLong1985);
		VarpDefinition.aLong1985 = l;
		synchronized (aClass1750 != null ? aClass1750
			      : (aClass1750 = getClass("unpackaged.Class13"))) {
		    StillGraphic.anInt2334
			+= i_3_ * Class15.anInt274;
		    int i_4_ = ((-(Class15.anInt274 * 2000)
				 + StillGraphic.anInt2334)
				/ 1000);
		    if (i_4_ > 0) {
			if (ScriptState.aClass39_Sub1_439 != null)
			    ScriptState.aClass39_Sub1_439.method417(i_4_);
			StillGraphic.anInt2334 -= i_4_ * 1000;
		    }
		}
	    }
	}
    }
    
    public static Class39_Sub5_Sub9 method574(int i, byte i_5_) {
	Class39_Sub5_Sub9 class39_sub5_sub9
	    = ((Class39_Sub5_Sub9)
	       Class2.aClass7_54.get((long) i));
	if (class39_sub5_sub9 != null)
	    return class39_sub5_sub9;
	byte[] is = HashTable.aClass9_369.lookupFile(1, i);
	class39_sub5_sub9 = new Class39_Sub5_Sub9();
	if (is != null)
	    class39_sub5_sub9.method603(i, (byte) 90, new Buffer(is));
	class39_sub5_sub9.method608(-84);
	Class2.aClass7_54.put(class39_sub5_sub9, (long) i);
	return class39_sub5_sub9;
    }
    
    /*synthetic*/ public static Class getClass(String string) {
	try {
	    return Class.forName(string);
	} catch (ClassNotFoundException classnotfoundexception) {
	    throw new NoClassDefFoundError(classnotfoundexception
					       .getMessage());
	}
    }
    
    static {
	aClass3_1738
	    = JString
		  .create("This computers address has been blocked");
	aClass3_1744
	    = (JString.create
	       ("Too many incorrect logins from your address)3"));
	aClass3_1747 = aClass3_1743;
	aClass3_1745 = aClass3_1738;
	aClass3_1737
	    = JString.create("Prepared visibility map");
	aClass3_1736 = aClass3_1744;
	aClass3_1741 = aClass3_1737;
	aBoolean1749 = false;
    }
}
