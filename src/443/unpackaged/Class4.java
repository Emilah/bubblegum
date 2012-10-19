package unpackaged;

import com.jagex.world.entities.StillObject;
import com.jagex.config.Model;
import com.jagex.world.Mob;
import com.jagex.config.ItemDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.NameTable;
import com.jagex.graphics.DrawingArea;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.utils.Cache;

/* Class4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class4
{
    public static JString aClass3_59;
    public static int anInt60;
    public static Object archiveWorkerLock;
    public static int anInt62;
    public static JString aClass3_63
	= (JString.create
	   ("Press (Wchange your password(W on front page)3"));
    public static JString aClass3_64;
    public static int anInt65;
    public static JString aClass3_66
	= JString.create("Lade Sprites )2 ");
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_67;
    public static JString aClass3_68;
    public static JString aClass3_69;
    public static Cache aClass7_70;
    public static AbstractFileLoader aClass9_71;
    public static JString aClass3_72;
    public static JString aClass3_73;
    public static Deque aClass49_74;
    public static int[] anIntArray75;
    public static JString aClass3_76;
    public static JString aClass3_77;
    public static JString aClass3_78;
    public static JString aClass3_79;
    public static int crossMode;
    public static int frameId;
    public static JString aClass3_82;
    
    public static synchronized byte[] getByteArray(int size) {
	if (size == 100 && Queue.anInt979 > 0) {
	    byte[] is
		= ItemDefinition.aByteArrayArray1688[--Queue.anInt979];
	    ItemDefinition.aByteArrayArray1688[Queue.anInt979] = null;
	    return is;
	}
	if (size == 5000 && Class53.anInt968 > 0) {
	    byte[] is = Class23.aByteArrayArray426[--Class53.anInt968];
	    Class23.aByteArrayArray426[Class53.anInt968] = null;
	    return is;
	}
	if (size == 30000 && Class50.anInt931 > 0) {
	    byte[] is = Queue.aByteArrayArray972[--Class50.anInt931];
	    Queue.aByteArrayArray972[Class50.anInt931] = null;
	    return is;
	}
	return new byte[size];
    }
    
    public static void method100(byte i) {
	aClass3_72 = null;
	aClass39_Sub5_Sub10_Sub4_67 = null;
	aClass3_73 = null;
	aClass3_66 = null;
	aClass49_74 = null;
	aClass3_78 = null;
	aClass3_68 = null;
	aClass9_71 = null;
	aClass3_64 = null;
	aClass7_70 = null;
	archiveWorkerLock = null;
	aClass3_79 = null;
	aClass3_76 = null;
	aClass3_69 = null;
	aClass3_77 = null;
	anIntArray75 = null;
	aClass3_82 = null;
	aClass3_59 = null;
	aClass3_63 = null;
    }
    
    public static void method101(byte i) {
	if (Npc.aClass35_2499 != null) {
	    synchronized (Npc.aClass35_2499) {
		Npc.aClass35_2499 = null;
	    }
	}
    }
    
    public static void method102(int i, int i_1_, int i_2_, int i_3_, int i_4_,
				 int i_5_) {
	Class62_Sub2.aClass39_Sub5_Sub10_Sub4Array1607[0].method695(i, i_3_);
	int i_6_ = i_5_ * (i_5_ - 32) / i_2_;
	Class62_Sub2.aClass39_Sub5_Sub10_Sub4Array1607[1]
	    .method695(i, i_3_ + i_5_ - 16);
	if (i_6_ < 8)
	    i_6_ = 8;
	int i_7_ = i_1_ * (i_5_ - i_6_ - 32) / (i_2_ - i_5_);
	DrawingArea.drawQuad(i, i_3_ + 16, 16, i_5_ - 32,
				     StillGraphic.anInt2326);
	DrawingArea.drawQuad(i, i_7_ + i_3_ + 16, 16, i_6_,
				     Class14.anInt264);
	DrawingArea.drawVerticalLine(i, i_3_ + 16 + i_7_, i_6_,
				     Class39_Sub5_Sub6.anInt1775);
	DrawingArea.drawVerticalLine(i + 1, i_7_ + i_3_ + 16, i_6_,
				     Class39_Sub5_Sub6.anInt1775);
	DrawingArea.drawHorizontalLine(i, i_3_ + 16 + i_7_, 16,
				     Class39_Sub5_Sub6.anInt1775);
	DrawingArea.drawHorizontalLine(i, i_3_ + 17 + i_7_, 16,
				     Class39_Sub5_Sub6.anInt1775);
	DrawingArea.drawVerticalLine(i + 15, i_3_ + 16 + i_7_, i_6_,
				     Class39_Sub5_Sub5.anInt1742);
	DrawingArea.drawVerticalLine(i + 14, i_3_ + (i_7_ + 17), i_6_ - 1,
				     Class39_Sub5_Sub5.anInt1742);
	DrawingArea.drawHorizontalLine(i, i_3_ + i_7_ + 15 + i_6_, 16,
				     Class39_Sub5_Sub5.anInt1742);
	DrawingArea.drawHorizontalLine(i + 1, i_6_ + (i_7_ + (i_3_ + 14)), 15,
				     Class39_Sub5_Sub5.anInt1742);
    }
    
    public static Class getTypeFromName(String string)
	throws ClassNotFoundException {
	if (string.equals("B"))
	    return Byte.TYPE;
	if (string.equals("I"))
	    return Integer.TYPE;
	if (string.equals("S"))
	    return Short.TYPE;
	if (string.equals("J"))
	    return Long.TYPE;
	if (string.equals("Z"))
	    return Boolean.TYPE;
	if (string.equals("F"))
	    return Float.TYPE;
	if (string.equals("D"))
	    return Double.TYPE;
	if (string.equals("C"))
	    return Character.TYPE;
	return Class.forName(string);
    }
    
    public static void method104(int i, int i_8_, int i_9_, int i_10_) {
	if (i_10_ < 128 || i_8_ < 128 || i_10_ > 13056 || i_8_ > 13056) {
	    Class14.anInt224 = -1;
	    Class53.anInt962 = -1;
	} else {
	    int i_11_
		= -i + Class14.method212(i_10_, i_8_, NameTable.height);
	    i_10_ -= StillObject.fCameraPositionX;
	    i_8_ -= Node.fCameraPositionY;
	    int i_12_
		= Model.anIntArray2394[Class43.anInt799];
	    i_11_ -= Class39_Sub10.cameraHeight;
	    int i_13_
		= Model.anIntArray2418[Class43.anInt799];
	    int i_14_ = (Model.anIntArray2394
			 [Mob.anInt2315]);
	    int i_15_ = (Model.anIntArray2418
			 [Mob.anInt2315]);
	    int i_16_ = i_10_ * i_15_ + i_8_ * i_14_ >> 16;
	    i_8_ = -(i_14_ * i_10_) + i_8_ * i_15_ >> 16;
	    i_10_ = i_16_;
	    i_16_ = -(i_8_ * i_12_) + i_13_ * i_11_ >> 16;
	    i_8_ = i_11_ * i_12_ + i_13_ * i_8_ >> 16;
	    i_11_ = i_16_;
	    if (i_8_ >= 50) {
		Class14.anInt224 = 256 + (i_10_ << 9) / i_8_;
		Class53.anInt962 = (i_11_ << 9) / i_8_ + 167;
	    } else {
		Class14.anInt224 = -1;
		Class53.anInt962 = -1;
	    }
	}
    }
    
    static {
	aClass3_64
	    = JString.create("Try again in 60 secs)3)3)3");
	aClass3_59 = aClass3_64;
	aClass3_68 = aClass3_63;
	anInt62 = 0;
	aClass3_69 = JString.create("title)3jpg");
	archiveWorkerLock = new Object();
	aClass7_70 = new Cache(64);
	aClass3_73 = JString.create("@yel@*V");
	aClass3_72
	    = (JString.create
	       ("Bitte warten Sie )2 es wird versucht)1 die Verbindung wiederherzustellen)3"));
	aClass49_74 = new Deque();
	crossMode = 0;
	aClass3_82 = JString.create("Message");
	aClass3_76
	    = JString
		  .create("go back to the main RuneScape webpage");
	aClass3_77 = aClass3_82;
	anIntArray75 = new int[5];
	aClass3_79 = aClass3_76;
	aClass3_78 = JString.create("(Udns");
	frameId = 0;
    }
}
