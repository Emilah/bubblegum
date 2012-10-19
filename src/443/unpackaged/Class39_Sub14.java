package unpackaged;

import com.jagex.world.Entity;
import com.jagex.world.entities.StillObject;
import com.jagex.Client;
import com.jagex.utils.JRuntimeException;
import com.jagex.config.Widget;
import com.jagex.world.Barrier;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.graphics.BitmapFont;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.JImage;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.Buffer;

/* Class39_Sub14 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub14 extends Node
{
    public static JString aClass3_1510
	= (JString.create
	   ("Spieler)3 Bitte w-=hlen Sie eine andere Welt)3"));
    public static int anInt1511;
    public static int[] anIntArray1512;
    public static JString aClass3_1513;
    public static JString toJstr;
    public static JString aClass3_1515;
    public static byte[][][] aByteArrayArrayArray1516;
    public static int anInt1517;
    public static JString aClass3_1518;
    public static JString[] playerOptions = new JString[5];
    public static boolean updateTab;
    public static JString aClass3_1521;
    public static JString aClass3_1522;
    public int anInt1523;
    public Barrier[] aClass10Array1524;
    public boolean aBoolean1525;
    public int anInt1526;
    public int anInt1527;
    public Wall aClass36_1528;
    public boolean aBoolean1529;
    public Class44 aClass44_1530;
    public Class17 aClass17_1531;
    public int[] anIntArray1532 = new int[5];
    public int anInt1533;
    public int anInt1534;
    public int anInt1535;
    public int anInt1536;
    public boolean aBoolean1537;
    public int anInt1538;
    public Class50 aClass50_1539;
    public Class39_Sub14 aClass39_Sub14_1540;
    public Class67 aClass67_1541;
    public Class32 aClass32_1542;
    public static int[] levelExperience;
    public int anInt1544;
    public int anInt1545;
    public int anInt1546;
    
    public static void parseNpcUpdate(int i) {
	JImage.anInt1586 = 0;
	Huffman.anInt749 = 0;
	Class53.method984(-93);
	Class62_Sub2.method1075((byte) 126);
	Widget.method763(-4322);
	for (int i_0_ = i; i_0_ < Huffman.anInt749; i_0_++) {
	    int i_1_ = Class26.anIntArray496[i_0_];
	    if ((GroundItem.npcs
		 [i_1_].anInt2290)
		!= Class2.logicCycle) {
		GroundItem
		    .npcs[i_1_]
		    .definition
		    = null;
		GroundItem
		    .npcs[i_1_]
		    = null;
	    }
	}
	if (Class39_Sub5_Sub11.incomingBuffer.offset
	    != Huffman.frameSize)
	    throw new RuntimeException("gnp1 pos:"
				       + (Class39_Sub5_Sub11
					  .incomingBuffer.offset)
				       + " psize:" + Huffman.frameSize);
	for (int i_2_ = 0; ArchiveWorker.anInt1210 > i_2_; i_2_++) {
	    if ((GroundItem.npcs
		 [Entity.anIntArray1734[i_2_]])
		== null)
		throw new RuntimeException("gnp2 pos:" + i_2_ + " size:"
					   + ArchiveWorker.anInt1210);
	}
    }
    
    public static BitmapFont createBitmapFont() {
	BitmapFont bitmapFont
	    = new BitmapFont(SubNode.anIntArray1352,
					  Class39_Sub5_Sub9.anIntArray1799,
					  anIntArray1512,
					  StillObject.anIntArray1460,
					  TraversalMap.aByteArrayArray517);
	JRuntimeException.method1123();
	return bitmapFont;
    }
    
    public static int method878(int i, int i_3_, int i_4_) {
	int i_5_ = (Class50.method976(i_3_ - 1, i_4_ - 1, (byte) 118)
		    - (-Class50.method976(i_3_ - 1, i_4_ + 1, (byte) 118)
		       - Class50.method976(i_3_ + 1, i_4_ - 1, (byte) 118)
		       - Class50.method976(i_3_ + 1, i_4_ + 1, (byte) 118)));
	int i_6_ = (Class50.method976(i_3_, i_4_ - 1, (byte) 118)
		    + (Class50.method976(i_3_, i_4_ + 1, (byte) 118)
		       - (-Class50.method976(i_3_ - 1, i_4_, (byte) 118)
			  - Class50.method976(i_3_ + 1, i_4_, (byte) 118))));
	int i_7_ = Class50.method976(i_3_, i_4_, (byte) 118);
	return i_7_ / 4 + i_5_ / 16 + i_6_ / 8;
    }
    
    public static void method880(int i) {
	levelExperience = null;
	aClass3_1510 = null;
	aClass3_1518 = null;
	aClass3_1522 = null;
	toJstr = null;
	playerOptions = null;
	aClass3_1513 = null;
	anIntArray1512 = null;
	aClass3_1515 = null;
	if (i == 5) {
	    aClass3_1521 = null;
	    aByteArrayArrayArray1516 = null;
	}
    }
    
    public Class39_Sub14(int i, int i_9_, int i_10_) {
	aClass10Array1524 = new Barrier[5];
	anInt1535 = 0;
	anInt1534 = anInt1546 = i;
	anInt1544 = i_10_;
	anInt1526 = i_9_;
    }
    
    static {
	anInt1511 = 0;
	aClass3_1518
	    = JString.create("Invalid username or password)3");
	aClass3_1513
	    = JString.create("60 Sekunden noch einmal)3)3)3");
	anInt1517 = 0;
	aClass3_1522
	    = JString
		  .create(" zuerst von Ihrer Ignorieren)2Liste(Q");
	aClass3_1515 = JString.create("To");
	aClass3_1521 = aClass3_1518;
	updateTab = false;
	toJstr = aClass3_1515;
	levelExperience = new int[25];
    }
}
