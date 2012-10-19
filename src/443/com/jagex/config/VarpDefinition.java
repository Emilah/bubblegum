package com.jagex.config;

/* Class39_Sub5_Sub16 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.io.ArchiveRequest;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.utils.NameTable;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.utils.Queue;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.zip.CRC32;
import unpackaged.Class14;
import unpackaged.Class20;
import unpackaged.Class30;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class65;
import unpackaged.Class67;
import unpackaged.Class68;
import unpackaged.TextureLoaderImpl;

public class VarpDefinition extends SubNode
{
    public static Cache aClass7_1975 = new Cache(30);
    public static int anInt1976;
    public static int[] anIntArray1977;
    public int type = 0;
    public static AbstractFileLoader wigetFileLoader;
    public static CRC32 crc;
    public static JString aClass3_1981;
    public static int anInt1982;
    public static JString aClass3_1983
	= JString.create(" is already on your friend list");
    public static int[] anIntArray1984;
    public static long aLong1985;
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array1986;
    public static JString aClass3_1987;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1988;
    public static byte[][] aByteArrayArray1989;
    public static JString aClass3_1990;
    public static JString aClass3_1991;
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array1992;
    public static JString aClass3_1993;
    
    public void decodeOpcode(Buffer buffer, int opcode) {
	if (opcode == 5)
	    type = buffer.getUint16();
    }
    
    public static int method744(KeyEvent keyevent, int i) {
	int i_2_ = keyevent.getKeyChar();
	if (i_2_ <= 0 || i_2_ >= 256)
	    i_2_ = -1;
	return i_2_;
    }
    
    public void decode(Buffer buffer) {
	for (;;) {
	    int opcode = buffer.getUint8();
	    if (opcode == 0)
		break;
	    decodeOpcode(buffer, opcode);
	}
    }
    
    public static void detachListeners(Component component) {
	component.removeKeyListener(Npc.aClass35_2499);
	component
	    .removeFocusListener(Npc.aClass35_2499);
    }
    
    public static void method747(int i) {
	Class39_Sub5_Sub4_Sub2.anIntArray2231 = null;
	Class14.anIntArray239 = null;
	Class39_Sub14.aByteArrayArrayArray1516 = null;
	Class20.anIntArrayArray391 = null;
	ISAAC.aByteArrayArrayArray1081 = null;
	Class39_Sub5_Sub9.anIntArray1809 = null;
	anIntArray1984 = null;
	Class33.aByteArrayArrayArray596 = null;
	ItemDefinition.aByteArrayArrayArray1671 = null;
	ArchiveRequest.anIntArrayArrayArray1412 = null;
	NameTable.anIntArray187 = null;
	Class67.aByteArrayArrayArray1179 = null;
    }
    
    public static void method748(int[] is, boolean bool, byte i, int i_4_,
				 int i_5_) {
	NpcDefinition.aClass57_1867.method1006(10);
	Queue.aClass39_Sub5_Sub10_Sub4_973.method695(0, 0);
	if (bool) {
	    if (is[i_5_] != -1) {
		if (i_5_ == 0)
		    Class68.aClass39_Sub5_Sub10_Sub4_1188.method695(22, 10);
		if (i_5_ == 1)
		    ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927
			.method695(54, 8);
		if (i_5_ == 2)
		    ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927
			.method695(82, 8);
		if (i_5_ == 3)
		    Npc
			.aClass39_Sub5_Sub10_Sub4_2500.method695(110, 8);
		if (i_5_ == 4)
		    Class65.aClass39_Sub5_Sub10_Sub4_1146.method695(153, 8);
		if (i_5_ == 5)
		    Class65.aClass39_Sub5_Sub10_Sub4_1146.method695(181, 8);
		if (i_5_ == 6)
		    KeyListenerImpl.aClass39_Sub5_Sub10_Sub4_629.method695(209, 9);
	    }
	    if (is[0] != -1 && i_4_ != 0)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[0].method695(29, 13);
	    if (is[1] != -1 && i_4_ != 1)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[1].method695(53, 11);
	    if (is[2] != -1 && i_4_ != 2)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[2].method695(82, 11);
	    if (is[3] != -1 && i_4_ != 3)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[3].method695(115,
								       12);
	    if (is[4] != -1 && i_4_ != 4)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[4].method695(153,
								       13);
	    if (is[5] != -1 && i_4_ != 5)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[5].method695(180,
								       11);
	    if (is[6] != -1 && i_4_ != 6)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[6].method695(208,
								       13);
	}
	BufferedFile.aClass57_346.method1006(10);
	Class68.aClass39_Sub5_Sub10_Sub4_1189.method695(0, 0);
	if (bool) {
	    if (is[i_5_] != -1) {
		if (i_5_ == 7)
		    Class4.aClass39_Sub5_Sub10_Sub4_67.method695(42, 0);
		if (i_5_ == 8)
		    aClass39_Sub5_Sub10_Sub4_1988.method695(74, 0);
		if (i_5_ == 9)
		    aClass39_Sub5_Sub10_Sub4_1988.method695(102, 0);
		if (i_5_ == 10)
		    Class34.aClass39_Sub5_Sub10_Sub4_606.method695(130, 1);
		if (i_5_ == 11)
		    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495.method695(173,
									  0);
		if (i_5_ == 12)
		    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495.method695(201,
									  0);
		if (i_5_ == 13)
		    Class30.aClass39_Sub5_Sub10_Sub4_539.method695(229, 0);
	    }
	    if (is[8] != -1 && i_4_ != 8)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[7].method695(74, 2);
	    if (is[9] != -1 && i_4_ != 9)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[8].method695(102, 3);
	    if (is[10] != -1 && i_4_ != 10)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[9].method695(137, 4);
	    if (is[11] != -1 && i_4_ != 11)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[10].method695(174,
									2);
	    if (is[12] != -1 && i_4_ != 12)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[11].method695(201,
									2);
	    if (is[13] != -1 && i_4_ != 13)
		TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243[12].method695(226,
									2);
	}
	try {
	    Graphics graphics = Class41.canvas.getGraphics();
	    NpcDefinition.aClass57_1867.draw(graphics, 516,
							160);
	    BufferedFile.aClass57_346.draw(graphics, 496, 466);
	} catch (Exception exception) {
	    Class41.canvas.repaint();
	}
    }
    
    public static void method749(int i) {
	aClass7_1975 = null;
	aClass39_Sub5_Sub10_Sub4_1988 = null;
	aClass3_1991 = null;
	aClass39_Sub5_Sub10_Sub3Array1992 = null;
	crc = null;
	aClass3_1990 = null;
	aClass3_1981 = null;
	wigetFileLoader = null;
	aClass3_1983 = null;
	anIntArray1977 = null;
	anIntArray1984 = null;
	aByteArrayArray1989 = null;
	aClass3_1993 = null;
	aClass39_Sub5_Sub10_Sub3Array1986 = null;
	aClass3_1987 = null;
    }
    
    static {
	anInt1982 = -1;
	aClass3_1981 = aClass3_1983;
	crc = new CRC32();
	aClass3_1990
	    = JString
		  .create("oberen Rand der Webseite ausw-=hlen)3");
	aClass3_1993 = JString.create("blaugr-Un:");
	aClass3_1987 = JString.create("From");
	aClass3_1991 = aClass3_1987;
    }
}
