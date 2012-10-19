package com.jagex.world.entities;

import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.io.FrameBuffer;
import com.jagex.io.ArchiveRequest;
import unpackaged.Class14;
import unpackaged.Class26;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Class39_Sub10;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class43;
import com.jagex.utils.MsTimer;
import unpackaged.Class53;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.script.ClientScript;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.io.FileLoader;
import com.jagex.od.OndemandHandler;
import com.jagex.utils.Huffman;
import com.jagex.config.Model;
import com.jagex.utils.NameTable;
import com.jagex.od.OndemandRequest;
import com.jagex.script.ScriptState;

/* Class39_Sub5_Sub4_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Projectile extends Entity
{
    public int anInt2170;
    public double aDouble2171;
    public double aDouble2172;
    public double x;
    public int sourceX;
    public int anInt2175 = 0;
    public int anInt2176;
    public static FileLoader fileLoader6;
    public int anInt2178;
    public int sourceY;
    public static int queuedEffectOffset;
    public int anInt2181;
    public static JString aClass3_2182;
    public double y;
    public static JString aClass3_2184;
    public static JString aClass3_2185
	= JString
	      .create("We suspect someone knows your password)3");
    public double z;
    public int anInt2187;
    public static JString[] aClass3Array2188 = new JString[200];
    public int anInt2189 = 0;
    public static JString aClass3_2190;
    public static int currentKey;
    public static int anInt2192;
    public int anInt2193;
    public static JString aClass3_2194;
    public int anInt2195;
    public static JString aClass3_2196;
    public static int anInt2197;
    public Class39_Sub5_Sub11 aClass39_Sub5_Sub11_2198;
    public double aDouble2199;
    public boolean aBoolean2200 = false;
    public int anInt2201;
    public int anInt2202;
    public static int anInt2203;
    public int anInt2204;
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array2205;
    public int anInt2206;
    public static JString aClass3_2207;
    public static volatile int queuedMousePositionX;
    public double aDouble2209;
    public double aDouble2210;
    
    public static Class34 method492(boolean bool) {
	try {
	    return (Class34) Class.forName("Class34_Sub1").newInstance();
	} catch (Throwable throwable) {
	    return null;
	}
    }
    
    public static void method493(int i) {
	aClass3_2185 = null;
	aClass3Array2188 = null;
	aClass3_2196 = null;
	aClass3_2190 = null;
	aClass39_Sub5_Sub10_Sub3Array2205 = null;
	aClass3_2207 = null;
	aClass3_2182 = null;
	aClass3_2194 = null;
	fileLoader6 = null;
	aClass3_2184 = null;
    }
    
    public static void method494
	(int i, DirectColorSprite class39_sub5_sub10_sub3, int i_0_,
	 int i_1_) {
	int i_2_ = i_1_ * i_1_ + i_0_ * i_0_;
	if (i_2_ > 4225 && i_2_ < 90000) {
	    int i_3_ = ArchiveRequest.anInt1401 + Class34.anInt605 & 0x7ff;
	    int i_4_ = Model.anIntArray2394[i_3_];
	    i_4_ = i_4_ * 256 / (ClassCheckRequest.anInt1386 + 256);
	    int i_5_ = Model.anIntArray2418[i_3_];
	    i_5_ = i_5_ * 256 / (ClassCheckRequest.anInt1386 + 256);
	    int i_6_ = -(i_0_ * i_4_) + i_1_ * i_5_ >> 16;
	    int i_7_ = i_1_ * i_4_ + i_5_ * i_0_ >> 16;
	    double d = Math.atan2((double) i_7_, (double) i_6_);
	    int i_8_ = (int) (Math.sin(d) * 63.0);
	    int i_9_ = (int) (Math.cos(d) * 57.0);
	    ClientScript.aClass39_Sub5_Sub10_Sub3_1712.method686
		(i_8_ + 94 + 4 - 10, -i_9_ - 20 + 83, 20, 20, 15, 15, d, 256);
	} else
	    Player
		.method528(i_1_, class39_sub5_sub10_sub3, i_0_, 10064);
    }
    
    public static void requestArchive(int indexId, int archiveId) {
	long l = (long) (archiveId + (indexId << 16));
	OndemandRequest request = ((OndemandRequest) OndemandHandler.requests.get(l));
	if (request != null)
	    OndemandHandler.regularRequestsQueue.offerLast(request);
    }
    
    public static void updateCameraMovement(int i) {
	int i_11_ = Class26.cameraPositionY * 128 + 64;
	int i_12_ = GroundItem.cameraPositionX * 128 + 64;
	int i_13_
	    = (Class14.method212(i_12_, i_11_, NameTable.height)
	       - PlayerApperance.cameraHeightOffset);
	if (StillObject.fCameraPositionX < i_12_) {
	    StillObject.fCameraPositionX
		+= ((i_12_ - StillObject.fCameraPositionX) * Class43.cameraMoveRate / 1000
		    + MsTimer.cameraOffset);
	    if (StillObject.fCameraPositionX > i_12_)
		StillObject.fCameraPositionX = i_12_;
	}
	if (i_13_ > Class39_Sub10.cameraHeight) {
	    Class39_Sub10.cameraHeight
		+= MsTimer.cameraOffset + ((i_13_ - Class39_Sub10.cameraHeight)
					     * Class43.cameraMoveRate / 1000);
	    if (Class39_Sub10.cameraHeight > i_13_)
		Class39_Sub10.cameraHeight = i_13_;
	}
	if (StillObject.fCameraPositionX > i_12_) {
	    StillObject.fCameraPositionX
		-= (Class43.cameraMoveRate * (-i_12_ + StillObject.fCameraPositionX)
		    / 1000) + MsTimer.cameraOffset;
	    if (i_12_ > StillObject.fCameraPositionX)
		StillObject.fCameraPositionX = i_12_;
	}
	if (Class39_Sub10.cameraHeight > i_13_) {
	    Class39_Sub10.cameraHeight
		-= (Class43.cameraMoveRate * (-i_13_ + Class39_Sub10.cameraHeight)
		    / 1000) + MsTimer.cameraOffset;
	    if (i_13_ > Class39_Sub10.cameraHeight)
		Class39_Sub10.cameraHeight = i_13_;
	}
	if (Node.fCameraPositionY < i_11_) {
	    Node.fCameraPositionY
		+= (MsTimer.cameraOffset
		    + Class43.cameraMoveRate * (i_11_ - Node.fCameraPositionY) / 1000);
	    if (Node.fCameraPositionY > i_11_)
		Node.fCameraPositionY = i_11_;
	}
	if (i_11_ < Node.fCameraPositionY) {
	    Node.fCameraPositionY
		-= (MsTimer.cameraOffset
		    + Class43.cameraMoveRate * (-i_11_ + Node.fCameraPositionY) / 1000);
	    if (Node.fCameraPositionY < i_11_)
		Node.fCameraPositionY = i_11_;
	}
	i_12_ = Class53.anInt965 * 128 + 64;
	i_11_ = Class39_Sub5_Sub18.anInt2121 * 128 + 64;
	i_13_ = (Class14.method212(i_12_, i_11_, NameTable.height)
		 - ScriptState.anInt454);
	int i_14_ = i_11_ - Node.fCameraPositionY;
	int i_15_ = i_12_ - StillObject.fCameraPositionX;
	int i_16_ = i_13_ - Class39_Sub10.cameraHeight;
	int i_17_ = (int) Math.sqrt((double) (i_14_ * i_14_ + i_15_ * i_15_));
	int i_18_
	    = ((int) (Math.atan2((double) i_16_, (double) i_17_) * 325.949)
	       & 0x7ff);
	int i_19_
	    = ((int) (Math.atan2((double) i_15_, (double) i_14_) * -325.949)
	       & 0x7ff);
	if (i_18_ < 128)
	    i_18_ = 128;
	int i_20_ = i_19_ - Mob.anInt2315;
	if (i_20_ > 1024)
	    i_20_ -= 2048;
	if (i_18_ > 383)
	    i_18_ = 383;
	if (i_20_ < -1024)
	    i_20_ += 2048;
	if (i_18_ > Class43.anInt799) {
	    Class43.anInt799
		+= (FrameBuffer.anInt2156
		    + (-Class43.anInt799 + i_18_) * Class32.anInt590 / 1000);
	    if (Class43.anInt799 > i_18_)
		Class43.anInt799 = i_18_;
	}
	if (Class43.anInt799 > i_18_) {
	    Class43.anInt799
		-= (FrameBuffer.anInt2156
		    + Class32.anInt590 * (Class43.anInt799 - i_18_) / 1000);
	    if (i_18_ > Class43.anInt799)
		Class43.anInt799 = i_18_;
	}
	if (i_20_ > 0) {
	    Mob.anInt2315
		+= (FrameBuffer.anInt2156
		    + i_20_ * Class32.anInt590 / 1000);
	    Mob.anInt2315 &= 0x7ff;
	}
	if (i_20_ < 0) {
	    Mob.anInt2315
		-= (FrameBuffer.anInt2156
		    + -i_20_ * Class32.anInt590 / 1000);
	    Mob.anInt2315 &= 0x7ff;
	}
	int i_21_ = i_19_ - Mob.anInt2315;
	if (i_21_ > 1024)
	    i_21_ -= 2048;
	if (i_21_ < -1024)
	    i_21_ += 2048;
	if (i == 2048) {
	    if (i_21_ < 0 && i_20_ > 0 || i_21_ > 0 && i_20_ < 0)
		Mob.anInt2315 = i_19_;
	}
    }
    
    public Model method489(boolean bool) {
	Class39_Sub5_Sub18 class39_sub5_sub18
	    = Huffman.method881(0, anInt2170);
	Model class39_sub5_sub4_sub6
	    = class39_sub5_sub18.method778(180, anInt2175);
	if (class39_sub5_sub4_sub6 == null)
	    return null;
	if (bool != true)
	    aClass39_Sub5_Sub11_2198 = null;
	class39_sub5_sub4_sub6.method565(anInt2202);
	return class39_sub5_sub4_sub6;
    }
    
    public void method497(int i, int i_22_, int destY, int i_24_, int destX) {
	if (!aBoolean2200) {
	    double deltaX = (double) (destX - sourceX);
	    double deltaY = (double) (destY - sourceY);
	    double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	    y = deltaY * (double) anInt2176 / distance + (double) sourceY;
	    z = (double) anInt2181;
	    x = (double) anInt2176 * deltaX / distance + (double) sourceX;
	}
	double d = (double) (anInt2204 + 1 - i_24_);
	aDouble2172 = (-y + (double) destY) / d;
	aDouble2199 = ((double) destX - x) / d;
	aDouble2171
	    = Math.sqrt(aDouble2199 * aDouble2199 + aDouble2172 * aDouble2172);
	if (!aBoolean2200)
	    aDouble2209
		= -aDouble2171 * Math.tan((double) anInt2178 * 0.02454369);
	aDouble2210
	    = ((double) i - z - d * aDouble2209) * 2.0 / (d * d);
    }
    
    public void method498(int i, int i_28_) {
	aBoolean2200 = true;
	y += aDouble2172 * (double) i_28_;
	z
	    += ((double) i_28_ * aDouble2209
		+ (double) i_28_ * ((double) i_28_ * (aDouble2210 * 0.5)));
	x += aDouble2199 * (double) i_28_;
	aDouble2209 += (double) i_28_ * aDouble2210;
	anInt2206 = (i + (int) (Math.atan2(aDouble2199, aDouble2172) * 325.949)
		     & 0x7ff);
	anInt2202
	    = (int) (Math.atan2(aDouble2209, aDouble2171) * 325.949) & 0x7ff;
	if (aClass39_Sub5_Sub11_2198 != null) {
	    anInt2189 += i_28_;
	    while (anInt2189
		   > aClass39_Sub5_Sub11_2198.anIntArray1831[anInt2175]) {
		anInt2189
		    -= aClass39_Sub5_Sub11_2198.anIntArray1831[anInt2175];
		anInt2175++;
		if (anInt2175
		    >= aClass39_Sub5_Sub11_2198.anIntArray1833.length) {
		    anInt2175 -= aClass39_Sub5_Sub11_2198.anInt1839;
		    if (anInt2175 < 0 || anInt2175 >= (aClass39_Sub5_Sub11_2198
						       .anIntArray1833).length)
			anInt2175 = 0;
		}
	    }
	}
    }
    
    public Projectile(int i, int i_29_, int i_30_, int i_31_,
				  int i_32_, int i_33_, int i_34_, int i_35_,
				  int i_36_, int i_37_, int i_38_) {
	anInt2187 = i_29_;
	sourceY = i_31_;
	anInt2181 = i_32_;
	anInt2193 = i_37_;
	anInt2170 = i;
	anInt2178 = i_35_;
	anInt2176 = i_36_;
	sourceX = i_30_;
	aBoolean2200 = false;
	anInt2204 = i_34_;
	anInt2195 = i_38_;
	anInt2201 = i_33_;
	int i_39_ = Huffman.method881(0, anInt2170).anInt2126;
	if (i_39_ != -1)
	    aClass39_Sub5_Sub11_2198
		= AbstractMidiHandler.method1064(i_39_, (byte) 54);
	else
	    aClass39_Sub5_Sub11_2198 = null;
    }
    
    static {
	aClass3_2184
	    = JString.create("Login limit exceeded)3");
	anInt2197 = -1;
	anInt2192 = 0;
	queuedEffectOffset = 0;
	aClass3_2194 = JString.create("Take");
	aClass3_2196 = aClass3_2185;
	aClass3_2182 = aClass3_2184;
	aClass3_2190 = aClass3_2194;
	aClass3_2207 = JString.create("@gr3@");
	queuedMousePositionX = -1;
    }
}
