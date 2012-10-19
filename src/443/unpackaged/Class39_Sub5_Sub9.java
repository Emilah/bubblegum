package unpackaged;

import com.jagex.world.Entity;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.config.Widget;
import com.jagex.sign.Signlink;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.Bzip2Entry;
import com.jagex.utils.Huffman;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.io.Buffer;

/* Class39_Sub5_Sub9 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub5_Sub9 extends SubNode
{
    public static int[] anIntArray1799;
    public int anInt1800;
    public int anInt1801;
    public static Signlink fileSignlink;
    public static JString aClass3_1803;
    public static int[] bitMasks;
    public static JString aClass3_1805
	= JString.create("Lade Spiel)2Fenster )2 ");
    public static JString aClass3_1806;
    public static int anInt1807 = 0;
    public static long[] ignoreUsernames;
    public static int[] anIntArray1809;
    public static int effectVolume;
    public static int[] queuedEffectDelays;
    public int anInt1812;
    public int anInt1813;
    public static JString aClass3_1814;
    public int anInt1815 = 0;
    public static JString aClass3_1816;
    public static JString aClass3_1817;
    
    public static DirectColorSprite method599
	(JString class3, JString class3_0_, AbstractFileLoader class9) {
	int i_1_ = class9.lookupArchive(class3);
	int i_2_ = class9.lookupFile(i_1_, class3_0_);
	return PlayerApperance.loadSprite(class9, i_2_, i_1_);
    }
    
    public static void method600(int i) {
	aClass3_1805 = null;
	aClass3_1817 = null;
	anIntArray1799 = null;
	aClass3_1816 = null;
	aClass3_1803 = null;
	bitMasks = null;
	fileSignlink = null;
	aClass3_1806 = null;
	ignoreUsernames = null;
	aClass3_1814 = null;
	anIntArray1809 = null;
	if (i != -25312)
	    effectVolume = -98;
	queuedEffectDelays = null;
    }
    
    public void method601(int i, int i_3_) {
	double d = (double) ((i & 0xff1fe1) >> 16) / 256.0;
	double d_4_ = (double) ((i & 0xffeb) >> 8) / 256.0;
	double d_5_ = (double) (i & 0xff) / 256.0;
	double d_6_ = d;
	double d_7_ = 0.0;
	double d_8_ = d;
	if (d_8_ < d_4_)
	    d_8_ = d_4_;
	if (d_5_ > d_8_)
	    d_8_ = d_5_;
	if (d_6_ > d_4_)
	    d_6_ = d_4_;
	double d_9_ = 0.0;
	if (d_5_ < d_6_)
	    d_6_ = d_5_;
	double d_10_ = (d_6_ + d_8_) / 2.0;
	if (d_8_ != d_6_) {
	    if (d_10_ < 0.5)
		d_9_ = (-d_6_ + d_8_) / (d_6_ + d_8_);
	    if (d_8_ == d)
		d_7_ = (d_4_ - d_5_) / (-d_6_ + d_8_);
	    else if (d_8_ != d_4_) {
		if (d_5_ == d_8_)
		    d_7_ = (d - d_4_) / (d_8_ - d_6_) + 4.0;
	    } else
		d_7_ = (-d + d_5_) / (d_8_ - d_6_) + 2.0;
	    if (d_10_ >= 0.5)
		d_9_ = (-d_6_ + d_8_) / (-d_8_ + 2.0 - d_6_);
	}
	if (d_10_ > 0.5)
	    anInt1800 = (int) ((1.0 - d_10_) * d_9_ * 512.0);
	else
	    anInt1800 = (int) (d_9_ * d_10_ * 512.0);
	if (anInt1800 < 1)
	    anInt1800 = 1;
	anInt1812 = (int) (d_9_ * 256.0);
	anInt1801 = (int) (d_10_ * 256.0);
	d_7_ /= 6.0;
	int i_11_ = -74 / ((-14 - i_3_) / 52);
	if (anInt1812 < 0)
	    anInt1812 = 0;
	else if (anInt1812 > 255)
	    anInt1812 = 255;
	if (anInt1801 < 0)
	    anInt1801 = 0;
	else if (anInt1801 > 255)
	    anInt1801 = 255;
	anInt1813 = (int) ((double) anInt1800 * d_7_);
    }
    
    public static boolean method602(Widget widget,
				    boolean bool) {
	int i = widget.anInt2078;
	if (i >= 1 && i <= 200 || i >= 701 && i <= 900) {
	    if (i < 801) {
		if (i < 701) {
		    if (i >= 101)
			i -= 101;
		    else
			i--;
		} else
		    i -= 601;
	    } else
		i -= 701;
	    JString.queueAction(2, 0, 0, 0, Class25.aClass3_462,
			    (Class39_Sub5_Sub11.join
			     ((new JString[]
			       { Entity.whiPrefixJstr,
				 Projectile.aClass3Array2188[i] }))));
	    JString.queueAction(10, 0, 0, 0, Class4.aClass3_77,
			    (Class39_Sub5_Sub11.join
			     ((new JString[]
			       { Entity.whiPrefixJstr,
				 Projectile.aClass3Array2188[i] }))));
	    return true;
	}
	if (i >= 401 && i <= 500) {
	    JString.queueAction(50, 0, 0, 0, Class25.aClass3_462,
			    Class39_Sub5_Sub11.join((new JString[]
							  { (Entity
							     .whiPrefixJstr),
							    (widget
							     .inactiveText) })));
	    return true;
	}
	return false;
    }
    
    public void method603(int i, byte i_12_, Buffer class39_sub6) {
	for (;;) {
	    int i_13_ = class39_sub6.getUint8();
	    if (i_13_ == 0)
		break;
	    method605(i, i_13_, (byte) 35, class39_sub6);
	}
    }
    
    public static void method604(boolean bool) {
	Class39_Sub5_Sub12.varpDefinitionCache.clear();
    }
    
    public void method605(int i, int i_14_, byte i_15_,
			  Buffer class39_sub6) {
	if (i_15_ != 35)
	    method604(false);
	if (i_14_ == 1)
	    anInt1815 = class39_sub6.getUint24();
    }
    
    public static void method607(int i) {
	int i_20_ = Class32.aClass39_Sub5_Sub10_Sub1_587
			.method637(Wall.aClass3_647);
	for (int i_21_ = 0; Class39_Sub5_Sub11.actionOffset > i_21_; i_21_++) {
	    int i_22_ = Class32.aClass39_Sub5_Sub10_Sub1_587
			    .method646(Class33.actionNames[i_21_]);
	    if (i_22_ > i_20_)
		i_20_ = i_22_;
	}
	i_20_ += 8;
	int i_23_ = Class39_Sub5_Sub11.actionOffset * 15 + 21;
	if (Class39_Sub4.mouseClickPositionX > 4 && Bzip2Entry.mouseClickPositionY > 4
	    && Class39_Sub4.mouseClickPositionX < 516 && Bzip2Entry.mouseClickPositionY < 338) {
	    Class37.anInt653 = 0;
	    Huffman.anInt757 = Class39_Sub5_Sub11.actionOffset * 15 + 22;
	    Class39_Sub12.aBoolean1493 = true;
	    Class14.anInt227 = i_20_;
	    int i_24_ = -(i_20_ / 2) + Class39_Sub4.mouseClickPositionX - 4;
	    if (i_24_ + i_20_ > 512)
		i_24_ = -i_20_ + 512;
	    int i_25_ = Bzip2Entry.mouseClickPositionY - 4;
	    if (i_25_ + i_23_ > 334)
		i_25_ = -i_23_ + 334;
	    if (i_25_ < 0)
		i_25_ = 0;
	    if (i_24_ < 0)
		i_24_ = 0;
	    Widget.anInt2063 = i_24_;
	    Class39_Sub5_Sub7.anInt1784 = i_25_;
	}
	if (Class39_Sub4.mouseClickPositionX > 553 && Bzip2Entry.mouseClickPositionY > 205
	    && Class39_Sub4.mouseClickPositionX < 743 && Bzip2Entry.mouseClickPositionY < 466) {
	    Huffman.anInt757 = Class39_Sub5_Sub11.actionOffset * 15 + 22;
	    Class37.anInt653 = 1;
	    Class39_Sub12.aBoolean1493 = true;
	    int i_26_ = -(i_20_ / 2) + Class39_Sub4.mouseClickPositionX - 553;
	    int i_27_ = Bzip2Entry.mouseClickPositionY - 205;
	    Class14.anInt227 = i_20_;
	    if (i_27_ < 0)
		i_27_ = 0;
	    else if (i_27_ + i_23_ > 261)
		i_27_ = -i_23_ + 261;
	    Class39_Sub5_Sub7.anInt1784 = i_27_;
	    if (i_26_ < 0)
		i_26_ = 0;
	    else if (i_20_ + i_26_ > 190)
		i_26_ = -i_20_ + 190;
	    Widget.anInt2063 = i_26_;
	}
	if (Class39_Sub4.mouseClickPositionX > 17 && Bzip2Entry.mouseClickPositionY > 357
	    && Class39_Sub4.mouseClickPositionX < 496 && Bzip2Entry.mouseClickPositionY < 453) {
	    Class37.anInt653 = 2;
	    Class39_Sub12.aBoolean1493 = true;
	    Class14.anInt227 = i_20_;
	    Huffman.anInt757 = Class39_Sub5_Sub11.actionOffset * 15 + 22;
	    int i_28_ = Class39_Sub4.mouseClickPositionX - 17 - i_20_ / 2;
	    int i_29_ = Bzip2Entry.mouseClickPositionY - 357;
	    if (i_29_ >= 0) {
		if (i_23_ + i_29_ > 96)
		    i_29_ = -i_23_ + 96;
	    } else
		i_29_ = 0;
	    Class39_Sub5_Sub7.anInt1784 = i_29_;
	    if (i_28_ >= 0) {
		if (i_20_ + i_28_ > 479)
		    i_28_ = -i_20_ + 479;
	    } else
		i_28_ = 0;
	    Widget.anInt2063 = i_28_;
	}
    }
    
    public void method608(int i) {
	method601(anInt1815, 91);
    }
    
    static {
	bitMasks
	    = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047,
			  4095, 8191, 16383, 32767, 65535, 131071, 262143,
			  524287, 1048575, 2097151, 4194303, 8388607, 16777215,
			  33554431, 67108863, 134217727, 268435455, 536870911,
			  1073741823, 2147483647, -1 };
	ignoreUsernames = new long[100];
	queuedEffectDelays = new int[50];
	aClass3_1806 = JString.create("Public chat");
	effectVolume = 127;
	aClass3_1814 = JString.create("*6n");
	aClass3_1803 = aClass3_1806;
	aClass3_1816
	    = (JString.create
	       ("Ihre Ignorieren)2Liste ist voll)1 Sie k-Onnen nur 100 Spieler darauf eintragen)3"));
	aClass3_1817 = JString.create(" )2> @yel@");
    }
}
