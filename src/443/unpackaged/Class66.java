package unpackaged;

/* Class66 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.entities.StillObject;
import com.jagex.Client;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.sign.Signlink;
import com.jagex.config.ItemDefinition;
import com.jagex.io.FileLoader;
import com.jagex.io.CacheIO;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.utils.Cache;
import java.awt.Graphics;

public class Class66
{
    public static JString aClass3_1148
	= (JString.create
	   ("Press (Wrecover a locked account(W on front page)3"));
    public static JString aClass3_1149
	= JString.create("m-Ochte mit Ihnen handeln)3");
    public static JString aClass3_1150;
    public static JString inputMessageJstr;
    public static int anInt1153;
    public static JString socialListMessage;
    public static FileLoader fileLoader10;
    public static AbstractImage aClass57_1156;
    public static int anInt1157;
    public static int anInt1158 = 0;
    public static JString aClass3_1159;
    public static JString chatMessageJstr;
    public static JString aClass3_1161;
    public static JString aClass3_1162;
    public static JString reportUsername;
    public static JString blankString;
    public static JString aClass3_1165;
    
    public static void method1100() {
	ItemDefinition.aClass7_1663.clear();
    }
    
    public static boolean method1101(int i, Signlink class21, int i_0_,
				     boolean bool) {
	if (!CacheIO.method122(class21, 21597, bool))
	    return false;
	if (i > 0)
	    Npc.aClass7_2493 = new Cache(i);
	return true;
    }
    
    public static void method1102(byte i) {
	blankString = null;
	Client.stateValues = null;
	fileLoader10 = null;
	aClass3_1150 = null;
	aClass3_1161 = null;
	socialListMessage = null;
	inputMessageJstr = null;
	reportUsername = null;
	chatMessageJstr = null;
	aClass3_1148 = null;
	aClass3_1162 = null;
	aClass57_1156 = null;
	aClass3_1149 = null;
	aClass3_1165 = null;
	aClass3_1159 = null;
    }
    
    public static void method1103(int i) {
	Npc.aClass7_2490.clear();
    }
    
    public static void method1104(boolean bool) {
	try {
	    Graphics graphics = Class41.canvas.getGraphics();
	    ArchiveWorker.aClass57_1196.draw(graphics, 550, 4);
	} catch (Exception exception) {
	    Class41.canvas.repaint();
	}
    }
    
    public static void method1105
	(int i, Mob class39_sub5_sub4_sub4) {
	class39_sub5_sub4_sub4.anInt2303 = class39_sub5_sub4_sub4.anInt2317;
	if (class39_sub5_sub4_sub4.amountStepsQueued == 0)
	    class39_sub5_sub4_sub4.anInt2274 = 0;
	else {
	    if (class39_sub5_sub4_sub4.anInt2268 != -1
		&& class39_sub5_sub4_sub4.anInt2305 == 0) {
		Class39_Sub5_Sub11 class39_sub5_sub11
		    = AbstractMidiHandler.method1064(class39_sub5_sub4_sub4.anInt2268,
					      (byte) 54);
		if (class39_sub5_sub4_sub4.anInt2254 > 0
		    && class39_sub5_sub11.anInt1840 == 0) {
		    class39_sub5_sub4_sub4.anInt2274++;
		    return;
		}
		if (class39_sub5_sub4_sub4.anInt2254 <= 0
		    && class39_sub5_sub11.anInt1837 == 0) {
		    class39_sub5_sub4_sub4.anInt2274++;
		    return;
		}
	    }
	    int i_1_ = class39_sub5_sub4_sub4.fPositionY;
	    int i_2_ = class39_sub5_sub4_sub4.fPositionX;
	    int i_3_ = ((class39_sub5_sub4_sub4.queueY
			 [class39_sub5_sub4_sub4.amountStepsQueued - 1]) * 128
			+ class39_sub5_sub4_sub4.anInt2297 * 64);
	    int i_4_ = ((class39_sub5_sub4_sub4.queueX
			 [class39_sub5_sub4_sub4.amountStepsQueued - 1]) * 128
			+ class39_sub5_sub4_sub4.anInt2297 * 64);
	    if (i_4_ - i_1_ > 256 || i_4_ - i_1_ < -256 || -i_2_ + i_3_ > 256
		|| -i_2_ + i_3_ < -256) {
		class39_sub5_sub4_sub4.fPositionX = i_3_;
		class39_sub5_sub4_sub4.fPositionY = i_4_;
	    } else {
		if (i_4_ > i_1_) {
		    if (i_2_ < i_3_)
			class39_sub5_sub4_sub4.anInt2294 = 1280;
		    else if (i_2_ > i_3_)
			class39_sub5_sub4_sub4.anInt2294 = 1792;
		    else
			class39_sub5_sub4_sub4.anInt2294 = 1536;
		} else if (i_1_ <= i_4_) {
		    if (i_3_ <= i_2_) {
			if (i_3_ < i_2_)
			    class39_sub5_sub4_sub4.anInt2294 = 0;
		    } else
			class39_sub5_sub4_sub4.anInt2294 = 1024;
		} else if (i_3_ <= i_2_) {
		    if (i_2_ > i_3_)
			class39_sub5_sub4_sub4.anInt2294 = 256;
		    else
			class39_sub5_sub4_sub4.anInt2294 = 512;
		} else
		    class39_sub5_sub4_sub4.anInt2294 = 768;
		int i_5_ = ((class39_sub5_sub4_sub4.anInt2294
			     - class39_sub5_sub4_sub4.anInt2251)
			    & 0x7ff);
		int i_6_ = class39_sub5_sub4_sub4.anInt2262;
		int i_7_ = 4;
		if ((class39_sub5_sub4_sub4.anInt2294
		     != class39_sub5_sub4_sub4.anInt2251)
		    && class39_sub5_sub4_sub4.anInt2260 == -1
		    && class39_sub5_sub4_sub4.anInt2250 != 0)
		    i_7_ = 2;
		if (i_5_ > 1024)
		    i_5_ -= 2048;
		if (i_5_ >= -256 && i_5_ <= 256)
		    i_6_ = class39_sub5_sub4_sub4.anInt2264;
		else if (i_5_ < 256 || i_5_ >= 768) {
		    if (i_5_ >= -768 && i_5_ <= -256)
			i_6_ = class39_sub5_sub4_sub4.anInt2257;
		} else
		    i_6_ = class39_sub5_sub4_sub4.anInt2282;
		if (class39_sub5_sub4_sub4.amountStepsQueued > 2)
		    i_7_ = 6;
		if (i_6_ == -1)
		    i_6_ = class39_sub5_sub4_sub4.anInt2264;
		class39_sub5_sub4_sub4.anInt2303 = i_6_;
		if (class39_sub5_sub4_sub4.amountStepsQueued > 3)
		    i_7_ = 8;
		if (class39_sub5_sub4_sub4.anInt2274 > 0
		    && class39_sub5_sub4_sub4.amountStepsQueued > 1) {
		    i_7_ = 8;
		    class39_sub5_sub4_sub4.anInt2274--;
		}
		if (class39_sub5_sub4_sub4.queueRunning
		    [class39_sub5_sub4_sub4.amountStepsQueued - 1])
		    i_7_ <<= 1;
		if (i_2_ < i_3_) {
		    class39_sub5_sub4_sub4.fPositionX += i_7_;
		    if (i_3_ < class39_sub5_sub4_sub4.fPositionX)
			class39_sub5_sub4_sub4.fPositionX = i_3_;
		} else if (i_2_ > i_3_) {
		    class39_sub5_sub4_sub4.fPositionX -= i_7_;
		    if (class39_sub5_sub4_sub4.fPositionX < i_3_)
			class39_sub5_sub4_sub4.fPositionX = i_3_;
		}
		if (i_7_ >= 8
		    && (class39_sub5_sub4_sub4.anInt2303
			== class39_sub5_sub4_sub4.anInt2264)
		    && class39_sub5_sub4_sub4.anInt2293 != -1)
		    class39_sub5_sub4_sub4.anInt2303
			= class39_sub5_sub4_sub4.anInt2293;
		if (i_4_ > i_1_) {
		    class39_sub5_sub4_sub4.fPositionY += i_7_;
		    if (class39_sub5_sub4_sub4.fPositionY > i_4_)
			class39_sub5_sub4_sub4.fPositionY = i_4_;
		} else if (i_1_ > i_4_) {
		    class39_sub5_sub4_sub4.fPositionY -= i_7_;
		    if (i_4_ > class39_sub5_sub4_sub4.fPositionY)
			class39_sub5_sub4_sub4.fPositionY = i_4_;
		}
		if (class39_sub5_sub4_sub4.fPositionY == i_4_
		    && i_3_ == class39_sub5_sub4_sub4.fPositionX) {
		    class39_sub5_sub4_sub4.amountStepsQueued--;
		    if (class39_sub5_sub4_sub4.anInt2254 > 0)
			class39_sub5_sub4_sub4.anInt2254--;
		}
	    }
	}
    }
    
    public static void method1106(int i, StillObject stillObject) {
	int objectId = -1;
	int hash = 0;
	if (stillObject.type == 0)
	    hash = Class44.world.method379(stillObject.height,
						  stillObject.positionX,
						  stillObject.positionY);
	int i_10_ = 0;
	int i_11_ = 0;
	if (stillObject.type == 1)
	    hash = Class44.world.method363(stillObject.height,
						  stillObject.positionX,
						  stillObject.positionY);
	if (stillObject.type == 2)
	    hash = Class44.world.method384(stillObject.height,
						  stillObject.positionX,
						  stillObject.positionY);
	if (stillObject.type == 3)
	    hash = Class44.world.method404(stillObject.height,
						  stillObject.positionX,
						  stillObject.positionY);
	if (hash != 0) {
	    int i_12_ = Class44.world.method359(stillObject.height,
						       stillObject.positionX,
						       stillObject.positionY,
						       hash);
	    i_11_ = (i_12_ & 0xd6) >> 6;
	    objectId = hash >> 14 & 0x7fff;
	    i_10_ = i_12_ & 0x1f;
	}
	stillObject.anInt1451 = i_10_;
	stillObject.objectId = objectId;
	stillObject.anInt1449 = i_11_;
    }
    
    static {
	Client.stateValues = new int[2000];
	aClass3_1162 = aClass3_1148;
	anInt1153 = 0;
	anInt1157 = 1;
	blankString = JString.create("");
	inputMessageJstr = blankString;
	aClass3_1150 = blankString;
	aClass3_1159 = blankString;
	chatMessageJstr = blankString;
	socialListMessage = blankString;
	reportUsername = blankString;
	aClass3_1161
	    = JString.create("Malformed login packet)3");
	aClass3_1165 = aClass3_1161;
    }
}
