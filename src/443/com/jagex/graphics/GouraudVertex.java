package com.jagex.graphics;

/* Class48 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;
import java.awt.Component;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class23;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Class39_Sub10;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class47;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import unpackaged.TextureLoaderImpl;

public class GouraudVertex
{
    public static JString aClass3_899;
    public int anInt900;
    public int anInt901;
    public static JString aClass3_902
	= JString.create("Bitte versuchen Sie es in ");
    public int anInt903;
    public static int anInt904;
    public static JString aClass3_905;
    public static JString aClass3_906;
    public static int anInt907 = -1;
    public int anInt908;
    
    public static void method950(byte i) {
	aClass3_899 = null;
	aClass3_906 = null;
	aClass3_902 = null;
	aClass3_905 = null;
    }
    
    public static boolean method951(Widget class39_sub5_sub17) {
	int i_0_ = class39_sub5_sub17.anInt2078;
	if (Class14.anInt232 == 2) {
	    if (i_0_ == 201) {
		Class15.socialListMessageType = 1;
		Class39_Sub12.aBoolean1489 = true;
		Class66.socialListMessage = Class66.blankString;
		Mob.keyboardInputType = 0;
		Class14.aBoolean245 = true;
		Class66.aClass3_1150 = HashTable.aClass3_356;
	    }
	    if (i_0_ == 202) {
		Class15.socialListMessageType = 2;
		Class39_Sub12.aBoolean1489 = true;
		Class14.aBoolean245 = true;
		Mob.keyboardInputType = 0;
		Class66.aClass3_1150 = Huffman.aClass3_755;
		Class66.socialListMessage = Class66.blankString;
	    }
	}
	if (i_0_ == 205) {
	    ClientScript.anInt1692 = 250;
	    return true;
	}
	if (i_0_ == 501) {
	    Class66.socialListMessage = Class66.blankString;
	    Class66.aClass3_1150 = Class39_Sub12.aClass3_1496;
	    Class39_Sub12.aBoolean1489 = true;
	    Class15.socialListMessageType = 4;
	    Class14.aBoolean245 = true;
	    Mob.keyboardInputType = 0;
	}
	if (i_0_ == 502) {
	    Class66.socialListMessage = Class66.blankString;
	    Class66.aClass3_1150 = Class32.aClass3_592;
	    Class15.socialListMessageType = 5;
	    Class39_Sub12.aBoolean1489 = true;
	    Mob.keyboardInputType = 0;
	    Class14.aBoolean245 = true;
	}
	if (i_0_ >= 300 && i_0_ <= 313) {
	    int i_1_ = (i_0_ - 300) / 2;
	    int i_2_ = i_0_ & 0x1;
	    ClientScript.playerApperance.method919(0, i_2_ == 1, i_1_);
	}
	if (i_0_ >= 314 && i_0_ <= 323) {
	    int i_3_ = i_0_ & 0x1;
	    int i_4_ = (i_0_ - 314) / 2;
	    ClientScript.playerApperance.method931(i_3_ == 1, 7961, i_4_);
	}
	if (i_0_ == 324)
	    ClientScript.playerApperance.method918(-22411, false);
	if (i_0_ == 325)
	    ClientScript.playerApperance.method918(-22411, true);
	if (i_0_ == 326) {
	    FrameBuffer.outgoingBuffer.putFrame(118);
	    ClientScript.playerApperance.writeToBuffer(FrameBuffer.outgoingBuffer);
	    return true;
	}
	if (i_0_ == 620)
	    Class39_Sub12.aBoolean1487 = !Class39_Sub12.aBoolean1487;
	if (i_0_ >= 601 && i_0_ <= 613) {
	    TextureLoaderImpl.closeOverlays();
	    if (Class66.reportUsername.getLength() > 0) {
		FrameBuffer.outgoingBuffer.putFrame(119);
		FrameBuffer.outgoingBuffer.putQword(Class66.reportUsername.encodeBase37());
		FrameBuffer.outgoingBuffer.putByte(i_0_ - 601);
		FrameBuffer.outgoingBuffer.putByte(Class39_Sub12.aBoolean1487 ? 1 : 0);
	    }
	}
	return false;
    }
    
    public static void method952(Component component, AbstractFileLoader class9) {
	if (!SubNode.aBoolean1341) {
	    PlayerApperance.aClass39_Sub5_Sub10_Sub4_866
		= Class39_Sub10.method867((byte) -79, class9,
					  StillObject.aClass3_1455,
					  Class30.aClass3_533);
	    BufferedFile.aClass39_Sub5_Sub10_Sub4_350
		= Class39_Sub10.method867((byte) -79, class9,
					  Class43.aClass3_803,
					  Class30.aClass3_533);
	    Class47.aClass39_Sub5_Sub10_Sub4_891
		= Class39_Sub10.method867((byte) -79, class9,
					  Class34.aClass3_609,
					  Class30.aClass3_533);
	    Class39_Sub5_Sub14.aClass39_Sub5_Sub10_Sub4_1909
		= Class39_Sub10.method867((byte) -79, class9,
					  Bzip2Entry.aClass3_1056,
					  Class30.aClass3_533);
	    Class68.aClass39_Sub5_Sub10_Sub4_1189
		= Class39_Sub10.method867((byte) -79, class9,
					  Class30.aClass3_545,
					  Class30.aClass3_533);
	    Queue.aClass39_Sub5_Sub10_Sub4_973
		= Class39_Sub10.method867((byte) -79, class9,
					  Cache.aClass3_107,
					  Class30.aClass3_533);
	    TraversalMap.aClass57_514
		= Queue.method994(component, 479, 96, (byte) -111);
	    BufferedFile.aClass39_Sub5_Sub10_Sub4_350.method695(0, 0);
	    ArchiveWorker.aClass57_1196
		= Queue.method994(component, 172, 156, (byte) -127);
	    DrawingArea.reset();
	    Class47.aClass39_Sub5_Sub10_Sub4_891.method695(0, 0);
	    Class39_Sub5_Sub7.aClass57_1778
		= Queue.method994(component, 190, 261, (byte) -110);
	    PlayerApperance.aClass39_Sub5_Sub10_Sub4_866.method695(0, 0);
	    Class23.graphics
		= Queue.method994(component, 512, 334, (byte) -104);
	    DrawingArea.reset();
	    Class39_Sub5_Sub18.aClass57_2130
		= Queue.method994(component, 496, 50, (byte) -116);
	    BufferedFile.aClass57_346
		= Queue.method994(component, 269, 37, (byte) -122);
	    NpcDefinition.aClass57_1867
		= Queue.method994(component, 249, 45, (byte) -124);
	    DirectColorSprite class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(ISAAC.aClass3_1103,
					      Class30.aClass3_533, class9);
	    FrameBuffer.aClass57_2155
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -124);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class67.aClass3_1169,
					      Class30.aClass3_533, class9);
	    TextureLoaderImpl.aClass57_1248
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -126);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(BufferedFile.aClass3_348,
					      Class30.aClass3_533, class9);
	    ImageImpl.aClass57_1576
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -120);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class41.aClass3_771,
					      Class30.aClass3_533, class9);
	    NameTable.aClass57_182
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -127);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class39_Sub5_Sub14.aClass3_1904, Class30.aClass3_533,
					      class9);
	    Class43.aClass57_812
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -120);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class39_Sub5_Sub18.aClass3_2125, Class30.aClass3_533,
					      class9);
	    Class63.aClass57_1122
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -104);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class39_Sub4.aClass3_1340, Class30.aClass3_533,
					      class9);
	    TraversalMap.aClass57_516
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -125);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(Class43.aClass3_822,
					      Class30.aClass3_533, class9);
	    Widget.aClass57_2114
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -103);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    class39_sub5_sub10_sub3
		= Class39_Sub5_Sub9.method599(ISAAC.aClass3_1090,
					      Class30.aClass3_533, class9);
	    Queue.aClass57_981
		= Queue.method994(component,
				    class39_sub5_sub10_sub3.width,
				    class39_sub5_sub10_sub3.height,
				    (byte) -119);
	    class39_sub5_sub10_sub3.method677(0, 0);
	    Class68.aClass39_Sub5_Sub10_Sub4_1188
		= Class39_Sub10.method867((byte) -79, class9,
					  (Npc
					   .aClass3_2489),
					  Class30.aClass3_533);
	    ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927
		= Class39_Sub10.method867((byte) -79, class9,
					  ObjectDefinition.aClass3_1937,
					  Class30.aClass3_533);
	    Npc.aClass39_Sub5_Sub10_Sub4_2500
		= Class39_Sub10.method867((byte) -79, class9,
					  FrameBuffer.aClass3_2149,
					  Class30.aClass3_533);
	    KeyListenerImpl.aClass39_Sub5_Sub10_Sub4_629
		= Class68.aClass39_Sub5_Sub10_Sub4_1188.method692();
	    KeyListenerImpl.aClass39_Sub5_Sub10_Sub4_629.method691();
	    Class65.aClass39_Sub5_Sub10_Sub4_1146
		= ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927.method692();
	    Class65.aClass39_Sub5_Sub10_Sub4_1146.method691();
	    Class4.aClass39_Sub5_Sub10_Sub4_67
		= Class68.aClass39_Sub5_Sub10_Sub4_1188.method692();
	    Class4.aClass39_Sub5_Sub10_Sub4_67.method694();
	    VarpDefinition.aClass39_Sub5_Sub10_Sub4_1988
		= ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927.method692();
	    VarpDefinition.aClass39_Sub5_Sub10_Sub4_1988.method694();
	    Class34.aClass39_Sub5_Sub10_Sub4_606
		= Npc.aClass39_Sub5_Sub10_Sub4_2500
		      .method692();
	    Class34.aClass39_Sub5_Sub10_Sub4_606.method694();
	    Class30.aClass39_Sub5_Sub10_Sub4_539
		= Class68.aClass39_Sub5_Sub10_Sub4_1188.method692();
	    Class30.aClass39_Sub5_Sub10_Sub4_539.method691();
	    Class30.aClass39_Sub5_Sub10_Sub4_539.method694();
	    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495
		= ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927.method692();
	    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495.method691();
	    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495.method694();
	    TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243
		= Class39_Sub5_Sub12.method713((byte) 83, class9,
					       Class30.aClass3_533,
					       ArchiveWorker.aClass3_1200);
	    BufferedFile.anIntArray345 = new int[151];
	    MsTimer.anIntArray1564 = new int[33];
	    Class32.anIntArray586 = new int[151];
	    Widget.anIntArray2109 = new int[33];
	    for (int i_5_ = 0; i_5_ < 33; i_5_++) {
		int i_6_ = 999;
		int i_7_ = 0;
		for (int i_8_ = 0; i_8_ < 34; i_8_++) {
		    if ((Class47.aClass39_Sub5_Sub10_Sub4_891.index
			 [i_8_ + (Class47.aClass39_Sub5_Sub10_Sub4_891
				  .anInt2480) * i_5_])
			!= 0) {
			if (i_6_ != 999) {
			    i_7_ = i_8_;
			    break;
			}
		    } else if (i_6_ == 999)
			i_6_ = i_8_;
		}
		MsTimer.anIntArray1564[i_5_] = i_6_;
		Widget.anIntArray2109[i_5_] = i_7_ - i_6_;
	    }
	    for (int i_9_ = 5; i_9_ < 156; i_9_++) {
		int i_10_ = 999;
		int i_11_ = 0;
		for (int i_12_ = 25; i_12_ < 172; i_12_++) {
		    if ((Class47.aClass39_Sub5_Sub10_Sub4_891.index
			 [i_12_ + (Class47.aClass39_Sub5_Sub10_Sub4_891
				   .anInt2480) * i_9_]) == 0
			&& (i_12_ > 34 || i_9_ > 34)) {
			if (i_10_ == 999)
			    i_10_ = i_12_;
		    } else if (i_10_ != 999) {
			i_11_ = i_12_;
			break;
		    }
		}
		BufferedFile.anIntArray345[i_9_ - 5] = i_10_ - 25;
		Class32.anIntArray586[i_9_ - 5] = -i_10_ + i_11_;
	    }
	    SubNode.aBoolean1341 = true;
	}
    }
    
    static {
	anInt904 = -1;
	aClass3_905 = JString.create("");
	aClass3_899 = JString.create("null");
	aClass3_906 = JString.create("Lade Texturen )2 ");
    }
}
