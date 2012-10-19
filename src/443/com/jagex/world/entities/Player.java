package com.jagex.world.entities;

import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.graphics.AbstractImage;
import com.jagex.io.ArchiveRequest;
import unpackaged.Class2;
import unpackaged.Class26;
import unpackaged.Class34;
import unpackaged.Class39_Sub5_Sub11;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class47;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.utils.Huffman;
import com.jagex.utils.JString;
import com.jagex.config.Model;
import com.jagex.sign.Resource;
import com.jagex.world.Mob;
import com.jagex.world.entities.GroundItem;

/* Class39_Sub5_Sub4_Sub4_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Player extends Mob
{
    public boolean aBoolean2505;
    public int combatLevel;
    public int anInt2507;
    public int anInt2508;
    public int anInt2509 = -1;
    public int anInt2510;
    public int anInt2511;
    public int anInt2512;
    public int anInt2513;
    public int anInt2514;
    public static Buffer aClass39_Sub6_2515;
    public PlayerApperance aClass45_2516;
    public static JString scapeMainJstr
	= JString.create("scape main");
    public int anInt2518;
    public int anInt2519;
    public Model aClass39_Sub5_Sub4_Sub6_2520;
    public JString aClass3_2521;
    public int anInt2522;
    public int anInt2523;
    public int anInt2524;
    public static AbstractImage aClass57_2525;
    public int anInt2526;
    public static JString cancelJstrEng;
    public static JString aClass3_2528;
    public static Resource aClass56_2529;
    public static JString aClass3_2530;
    public static JString cancelJstr;
    public static int[] keycodeValues;
    public static int[] anIntArray2533;
    public static JString aClass3_2534;
    public static JString aClass3_2535;
    
    public void parseAppearance(Buffer buffer) {
	buffer.offset = 0;
	int i_0_ = buffer.getUint8();
	anInt2509 = buffer.getInt8();
	int[] is = new int[12];
	anInt2507 = buffer.getInt8();
	anInt2526 = 0;
	int i_1_ = -1;
	for (int i_2_ = 0; i_2_ < 12; i_2_++) {
	    int i_3_ = buffer.getUint8();
	    if (i_3_ == 0)
		is[i_2_] = 0;
	    else {
		int i_4_ = buffer.getUint8();
		is[i_2_] = i_4_ + (i_3_ << 8);
		if (i_2_ == 0 && is[0] == 65535) {
		    i_1_ = buffer.getUint16();
		    break;
		}
		if (is[i_2_] >= 512) {
		    int i_5_
			= Class26.getItemDefinition(is[i_2_] - 512).anInt1650;
		    if (i_5_ != 0)
			anInt2526 = i_5_;
		}
	    }
	}
	int[] is_6_ = new int[5];
	for (int i_7_ = 0; i_7_ < 5; i_7_++) {
	    int i_8_ = buffer.getUint8();
	    if (i_8_ < 0
		|| (GroundItem.anIntArrayArray2233[i_7_].length
		    <= i_8_))
		i_8_ = 0;
	    is_6_[i_7_] = i_8_;
	}
	anInt2317 = buffer.getUint16();
	if (anInt2317 == 65535)
	    anInt2317 = -1;
	anInt2263 = buffer.getUint16();
	if (anInt2263 == 65535)
	    anInt2263 = -1;
	anInt2280 = anInt2263;
	anInt2264 = buffer.getUint16();
	if (anInt2264 == 65535)
	    anInt2264 = -1;
	anInt2262 = buffer.getUint16();
	if (anInt2262 == 65535)
	    anInt2262 = -1;
	anInt2257 = buffer.getUint16();
	if (anInt2257 == 65535)
	    anInt2257 = -1;
	anInt2282 = buffer.getUint16();
	if (anInt2282 == 65535)
	    anInt2282 = -1;
	anInt2293 = buffer.getUint16();
	if (anInt2293 == 65535)
	    anInt2293 = -1;
	aClass3_2521
	    = Deque.decodeBase37(buffer.getInt64())
		  .formatUsername();
	combatLevel = buffer.getUint8();
	anInt2508 = buffer.getUint16();
	if (aClass45_2516 == null)
	    aClass45_2516 = new PlayerApperance();
	aClass45_2516.method925(is, i_0_ == 1, is_6_, 104, i_1_);
    }
    
    public static void method528
	(int i, DirectColorSprite class39_sub5_sub10_sub3, int i_9_,
	 int i_10_) {
	if (class39_sub5_sub10_sub3 != null) {
	    int i_11_ = Class34.anInt605 + ArchiveRequest.anInt1401 & 0x7ff;
	    int i_12_ = i * i + i_9_ * i_9_;
	    if (i_12_ <= 6400) {
		int i_13_ = Model.anIntArray2394[i_11_];
		i_13_ = i_13_ * 256 / (ClassCheckRequest.anInt1386 + 256);
		int i_14_ = Model.anIntArray2418[i_11_];
		i_14_ = i_14_ * 256 / (ClassCheckRequest.anInt1386 + 256);
		int i_15_ = i_14_ * i_9_ + i_13_ * i >> 16;
		int i_16_ = i * i_14_ - i_13_ * i_9_ >> 16;
		if (i_12_ <= 2500)
		    class39_sub5_sub10_sub3.method670
			((-(class39_sub5_sub10_sub3.anInt2475 / 2)
			  + (i_15_ + 94) + 4),
			 (-(class39_sub5_sub10_sub3.anInt2477 / 2) - 4 + 83
			  - i_16_));
		else
		    class39_sub5_sub10_sub3.method668
			(Class47.aClass39_Sub5_Sub10_Sub4_891,
			 (i_15_ + 94 + 4
			  - class39_sub5_sub10_sub3.anInt2475 / 2),
			 (-(class39_sub5_sub10_sub3.anInt2477 / 2) - 4
			  + (83 - i_16_)));
	    }
	}
    }
    
    public Model method489(boolean bool) {
	if (aClass45_2516 == null)
	    return null;
	Class39_Sub5_Sub11 class39_sub5_sub11
	    = (anInt2268 == -1 || anInt2305 != 0 ? null
	       : AbstractMidiHandler.method1064(anInt2268, (byte) 54));
	Class39_Sub5_Sub11 class39_sub5_sub11_17_
	    = ((anInt2303 != -1 && !aBoolean2505
		&& (anInt2317 != anInt2303 || class39_sub5_sub11 == null))
	       ? AbstractMidiHandler.method1064(anInt2303, (byte) 54) : null);
	Model mode
	    = aClass45_2516.method922(-27537, class39_sub5_sub11_17_,
				      class39_sub5_sub11, anInt2265,
				      anInt2306);
	if (mode == null)
	    return null;
	mode.updateDimensions();
	anInt2308 = mode.anInt1726;
	if (!aBoolean2505 && anInt2270 != -1 && anInt2276 != -1) {
	    Model class39_sub5_sub4_sub6_18_
		= Huffman.method881(0, anInt2270).method778(180, anInt2276);
	    if (class39_sub5_sub4_sub6_18_ != null) {
		class39_sub5_sub4_sub6_18_.translateVertices(0, -anInt2288, 0);
		Model[] class39_sub5_sub4_sub6s
		    = { mode, class39_sub5_sub4_sub6_18_ };
		mode
		    = new Model(class39_sub5_sub4_sub6s, 2,
						 true);
	    }
	}
	if (!aBoolean2505 && aClass39_Sub5_Sub4_Sub6_2520 != null) {
	    if (anInt2523 <= Class2.logicCycle)
		aClass39_Sub5_Sub4_Sub6_2520 = null;
	    if (Class2.logicCycle >= anInt2512 && Class2.logicCycle < anInt2523) {
		Model model
		    = aClass39_Sub5_Sub4_Sub6_2520;
		model.translateVertices(anInt2514 - fPositionY,
						     -anInt2524 + anInt2519,
						     anInt2518 - fPositionX);
		Model[] class39_sub5_sub4_sub6s
		    = { mode, model };
		if (anInt2294 == 512) {
		    model.rotateAxisY();
		    model.rotateAxisY();
		    model.rotateAxisY();
		} else if (anInt2294 != 1024) {
		    if (anInt2294 == 1536)
			model.rotateAxisY();
		} else {
		    model.rotateAxisY();
		    model.rotateAxisY();
		}
		mode
		    = new Model(class39_sub5_sub4_sub6s, 2,
						 true);
		if (anInt2294 == 512)
		    model.rotateAxisY();
		else if (anInt2294 != 1024) {
		    if (anInt2294 == 1536) {
			model.rotateAxisY();
			model.rotateAxisY();
			model.rotateAxisY();
		    }
		} else {
		    model.rotateAxisY();
		    model.rotateAxisY();
		}
		model.translateVertices(-anInt2514 + fPositionY,
						     -anInt2519 + anInt2524,
						     -anInt2518 + fPositionX);
	    }
	}
	mode.aBoolean2374 = bool;
	return mode;
    }
    
    public boolean method510(byte i) {
	if (aClass45_2516 == null)
	    return false;
	return true;
    }
    
    public static void method529(boolean bool) {
	aClass39_Sub6_2515 = null;
	aClass3_2530 = null;
	scapeMainJstr = null;
	cancelJstr = null;
	keycodeValues = null;
	aClass57_2525 = null;
	anIntArray2533 = null;
	aClass56_2529 = null;
	aClass3_2528 = null;
	aClass3_2534 = null;
	aClass3_2535 = null;
	cancelJstrEng = null;
    }
    
    public Player() {
	anInt2507 = -1;
	anInt2512 = 0;
	aBoolean2505 = false;
	anInt2523 = 0;
	combatLevel = 0;
	anInt2508 = 0;
	anInt2526 = 0;
    }
    
    static {
	aClass39_Sub6_2515 = new Buffer(new byte[5000]);
	aClass3_2530
	    = JString.create("Update)2Liste geladen)3");
	cancelJstrEng = JString.create("Cancel");
	cancelJstr = cancelJstrEng;
	aClass3_2534 = JString.create("Loaded wordpack");
	anIntArray2533 = new int[200];
	aClass3_2528 = aClass3_2534;
	aClass3_2535 = (JString.create
			("und haben es deaktiviert)3 Benutzen Sie die"));
	keycodeValues
	    = (new int[]
	       { -1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1,
		 -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1,
		 -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1,
		 -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1,
		 -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54,
		 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37,
		 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225,
		 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7,
		 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		 -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 });
    }
}
