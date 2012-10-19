package unpackaged;

import com.jagex.graphics.BitmapFont;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.io.Buffer;

/* Class39_Sub5_Sub14 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub5_Sub14 extends SubNode
{
    public int anInt1890;
    public static JString aClass3_1891;
    public int anInt1892;
    public int anInt1893;
    public boolean aBoolean1894;
    public static JString aClass3_1895;
    public static JString aClass3_1896;
    public static JString username;
    public static JString aClass3_1898
	= JString.create("Hier klicken)1 um fortzufahren)3)3)3");
    public static JString aClass3_1899;
    public int anInt1900;
    public int anInt1901 = -1;
    public int anInt1902;
    public static BitmapFont p12fullFont;
    public static JString aClass3_1904
	= JString.create("backtop1");
    public static JString password;
    public static JString blankJstr = JString.create("");
    public int anInt1907;
    public static boolean aBoolean1908;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1909;
    public static JString aClass3_1910;
    public static JString aClass3_1911;
    public static int chatboxOverlayId;
    public static JString aClass3_1913;
    public static int[] tabWidgetIds;
    public int anInt1915;
    public static JString aClass3_1916;
    public int anInt1917;
    public static JString loadingMessage;
    public static int anInt1919;
    
    public void method726(int i, Buffer class39_sub6, byte i_0_,
			  int i_1_) {
	if (i_1_ != 1) {
	    if (i_1_ != 2) {
		if (i_1_ != 5) {
		    if (i_1_ == 7)
			anInt1907 = class39_sub6.getUint24();
		} else
		    aBoolean1894 = false;
	    } else
		anInt1901 = class39_sub6.getUint8();
	} else
	    anInt1915 = class39_sub6.getUint24();
	if (i_0_ == 106) {
	    /* empty */
	}
    }
    
    public void method727(int i, int i_2_) {
	double d = (double) (i_2_ >> 16 & 0xff) / 256.0;
	double d_3_ = (double) (i_2_ & 0xff) / 256.0;
	double d_4_ = d;
	double d_5_ = (double) (i_2_ >> 8 & 0xff) / 256.0;
	if (d_5_ < d_4_)
	    d_4_ = d_5_;
	if (d_4_ > d_3_)
	    d_4_ = d_3_;
	double d_6_ = 0.0;
	double d_7_ = d;
	if (d_7_ < d_5_)
	    d_7_ = d_5_;
	if (d_7_ < d_3_)
	    d_7_ = d_3_;
	if (i == 19991) {
	    double d_8_ = 0.0;
	    double d_9_ = (d_7_ + d_4_) / 2.0;
	    anInt1893 = (int) (d_9_ * 256.0);
	    if (d_7_ != d_4_) {
		if (d != d_7_) {
		    if (d_5_ == d_7_)
			d_6_ = (d_3_ - d) / (-d_4_ + d_7_) + 2.0;
		    else if (d_3_ == d_7_)
			d_6_ = (-d_5_ + d) / (-d_4_ + d_7_) + 4.0;
		} else
		    d_6_ = (-d_3_ + d_5_) / (-d_4_ + d_7_);
		if (d_9_ < 0.5)
		    d_8_ = (-d_4_ + d_7_) / (d_4_ + d_7_);
		if (d_9_ >= 0.5)
		    d_8_ = (d_7_ - d_4_) / (2.0 - d_7_ - d_4_);
	    }
	    d_6_ /= 6.0;
	    anInt1900 = (int) (d_6_ * 256.0);
	    if (anInt1893 < 0)
		anInt1893 = 0;
	    else if (anInt1893 > 255)
		anInt1893 = 255;
	    anInt1917 = (int) (d_8_ * 256.0);
	    if (anInt1917 < 0)
		anInt1917 = 0;
	    else if (anInt1917 > 255)
		anInt1917 = 255;
	}
    }
    
    public void method728(byte i) {
	if (anInt1907 != -1) {
	    method727(19991, anInt1907);
	    anInt1890 = anInt1917;
	    anInt1902 = anInt1893;
	    anInt1892 = anInt1900;
	}
	method727(19991, anInt1915);
    }
    
    public static void method729(int i) {
	password = null;
	aClass3_1913 = null;
	blankJstr = null;
	aClass3_1899 = null;
	tabWidgetIds = null;
	aClass3_1895 = null;
	aClass3_1904 = null;
	aClass3_1898 = null;
	aClass3_1911 = null;
	aClass3_1896 = null;
	aClass3_1916 = null;
	aClass3_1910 = null;
	aClass3_1891 = null;
	aClass39_Sub5_Sub10_Sub4_1909 = null;
	p12fullFont = null;
	loadingMessage = null;
	username = null;
    }
    
    public void method730(int i, Buffer class39_sub6, int i_10_) {
	for (;;) {
	    int i_11_ = class39_sub6.getUint8();
	    if (i_11_ == 0)
		break;
	    method726(i_10_, class39_sub6, (byte) 106, i_11_);
	}
    }
    
    public Class39_Sub5_Sub14() {
	aBoolean1894 = true;
	anInt1907 = -1;
	anInt1915 = 0;
    }
    
    static {
	password = blankJstr;
	aBoolean1908 = false;
	aClass3_1899 = blankJstr;
	aClass3_1911 = (JString.create
			(" steht bereits auf Ihrer Ignorieren)2Liste(Q"));
	aClass3_1896 = blankJstr;
	aClass3_1910
	    = JString.create(" hat sich ausgeloggt)3");
	chatboxOverlayId = -1;
	tabWidgetIds = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				     -1, -1, -1, -1, -1 };
	aClass3_1891 = JString.create("skill)2");
	aClass3_1916 = blankJstr;
	aClass3_1913 = aClass3_1891;
	aClass3_1895 = JString.create("p11_full");
	loadingMessage = blankJstr;
	username = blankJstr;
    }
}
