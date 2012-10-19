package unpackaged;

import com.jagex.script.ScriptState;
import com.jagex.config.Widget;
import com.jagex.config.VarbitDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.NameTable;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.JString;
import com.jagex.utils.Cache;

/* Class43 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class43
{
    public int anInt797;
    public static JString aClass3_798;
    public static int anInt799;
    public static JString aClass3_800 = JString.create("Sep");
    public static JString aClass3_801;
    public static boolean aBoolean802;
    public static JString aClass3_803;
    public static JString aClass3_804;
    public static JString aClass3_805
	= JString
	      .create("Unerwartete Antwort vom Anmelde)2Server");
    public static JString aClass3_806;
    public static int cameraMoveRate;
    public static JString[] aClass3Array808;
    public static JString aClass3_809;
    public static Widget aClass39_Sub5_Sub17_810;
    public static Cache aClass7_811;
    public static AbstractImage aClass57_812;
    public static JString aClass3_813;
    public static Class34 aClass34_814;
    public static int anInt815;
    public static AbstractFileLoader aClass9_816;
    public static JString aClass3_817;
    public static JString aClass3_818;
    public int anInt819;
    public static int[] actionVars2;
    public static JString aClass3_821;
    public static JString aClass3_822;
    public static int anInt823;
    public int[][] anIntArrayArray824;
    public static JString aClass3_825;
    public static JString aClass3_826;
    public static BufferedFile mainFile;
    public static JString aClass3_828;
    public static int anInt829;
    public static JString aClass3_830;
    
    public static void method904(int i) {
	aClass57_812 = null;
	mainFile = null;
	aClass3_803 = null;
	aClass3_801 = null;
	aClass3_821 = null;
	aClass3_809 = null;
	aClass3_798 = null;
	aClass3_800 = null;
	aClass3_818 = null;
	aClass3_822 = null;
	if (i != -1)
	    toJstr(true, -13, 112);
	aClass3_830 = null;
	aClass3_813 = null;
	aClass3_826 = null;
	aClass9_816 = null;
	aClass3_806 = null;
	aClass3_804 = null;
	aClass39_Sub5_Sub17_810 = null;
	aClass7_811 = null;
	aClass34_814 = null;
	aClass3Array808 = null;
	aClass3_828 = null;
	aClass3_805 = null;
	aClass3_817 = null;
	aClass3_825 = null;
	actionVars2 = null;
    }
    
    public static void method905(int i) {
	NameTable.objectDefinitionCache.clear();
	aClass7_811.clear();
	VarbitDefinition.aClass7_1796.clear();
	Class39_Sub5_Sub6.aClass7_1767.clear();
    }
    
    public int method906(int i, int i_0_) {
	if (anIntArrayArray824 != null)
	    i = (int) ((long) anInt819 * (long) i / (long) anInt797) + 6;
	return i;
    }
    
    public static JString toJstr(boolean displayPositive, int radix, int i) {
	int amountChars = 1;
	if (radix < 1 || radix > 36)
	    radix = 10;
	for (int i_4_ = i / radix; i_4_ != 0; i_4_ /= radix)
	    amountChars++;
	int length = amountChars;
	if (i < 0 || displayPositive)
	    length++;
	byte[] src = new byte[length];
	if (i >= 0) {
	    if (displayPositive)
		src[0] = (byte) 43;
	} else
	    src[0] = (byte) 45;
	for (int j = 0; j < amountChars; j++) {
	    int value = i % radix;
	    i /= radix;
	    if (value < 0)
		value = -value;
	    if (value > 9)
		value += 39;
	    src[length - j - 1] = (byte) (value + 48);
	}
	JString jstr = new JString();
	jstr.length = length;
	jstr.bytes = src;
	return jstr;
    }
    
    public int method908(int i, int i_8_) {
	if (anIntArrayArray824 != null)
	    i_8_ = (int) ((long) anInt819 * (long) i_8_ / (long) anInt797);
	return i_8_;
    }
    
    public Class43(int i, int i_9_) {
	if (i != i_9_) {
	    int i_10_ = ScriptState.method279(i, false, i_9_);
	    i /= i_10_;
	    anIntArrayArray824 = new int[i][14];
	    i_9_ /= i_10_;
	    anInt797 = i;
	    anInt819 = i_9_;
	    for (int i_11_ = 0; i > i_11_; i_11_++) {
		int[] is = anIntArrayArray824[i_11_];
		double d = (double) i_11_ / (double) i + 6.0;
		int i_12_ = (int) Math.floor(d - 7.0 + 1.0);
		if (i_12_ < 0)
		    i_12_ = 0;
		int i_13_ = (int) Math.ceil(d + 7.0);
		if (i_13_ > 14)
		    i_13_ = 14;
		double d_14_ = (double) i_9_ / (double) i;
		for (/**/; i_13_ > i_12_; i_12_++) {
		    double d_15_ = d_14_;
		    double d_16_ = (-d + (double) i_12_) * 3.141592653589793;
		    if (d_16_ < -1.0E-4 || d_16_ > 1.0E-4)
			d_15_ *= Math.sin(d_16_) / d_16_;
		    d_15_
			*= (Math.cos(((double) i_12_ - d) * 0.2243994752564138)
			    * 0.46) + 0.54;
		    is[i_12_] = (int) Math.floor(d_15_ * 65536.0 + 0.5);
		}
	    }
	}
    }
    
    public static boolean isNumericChar(int i) {
	if (i < 48 || i > 57)
	    return false;
	return true;
    }
    
    public byte[] method910(byte[] is, int i) {
	if (anIntArrayArray824 != null) {
	    int i_18_
		= ((int) ((long) is.length * (long) anInt819 / (long) anInt797)
		   + 14);
	    int[] is_19_ = new int[i_18_];
	    int i_20_ = 0;
	    int i_21_ = 0;
	    for (int i_22_ = 0; is.length > i_22_; i_22_++) {
		int i_23_ = is[i_22_];
		int[] is_24_ = anIntArrayArray824[i_21_];
		for (int i_25_ = 0; i_25_ < 14; i_25_++)
		    is_19_[i_20_ + i_25_] += i_23_ * is_24_[i_25_];
		i_21_ += anInt819;
		int i_26_ = i_21_ / anInt797;
		i_21_ -= anInt797 * i_26_;
		i_20_ += i_26_;
	    }
	    is = new byte[i_18_];
	    for (int i_27_ = 0; i_27_ < i_18_; i_27_++) {
		int i_28_ = is_19_[i_27_] + 32768 >> 16;
		if (i_28_ < -128)
		    is[i_27_] = (byte) -128;
		else if (i_28_ <= 127)
		    is[i_27_] = (byte) i_28_;
		else
		    is[i_27_] = (byte) 127;
	    }
	}
	return is;
    }
    
    static {
	aClass3_798 = JString.create("Nov");
	aClass3_804 = JString.create("Dec");
	aClass3_817
	    = JString.create("da dieser Computer gegen unsere ");
	aClass3_809 = JString.create("Jul");
	aClass3_803 = JString.create("chatback");
	aClass3_813 = JString.create("Apr");
	aClass3_821 = JString.create("Feb");
	aClass3_822 = JString.create("backvmid3");
	anInt815 = 0;
	aClass3_818 = JString.create("Oct");
	aClass3_801 = JString.create("Jun");
	anInt823 = 0;
	aClass3_806 = JString.create("Aug");
	aClass3_828
	    = JString.create("Freunde)2Server)3)3)3");
	aClass3_826 = JString.create("May");
	aClass3_825 = JString.create("Jan");
	anInt829 = 0;
	actionVars2 = new int[500];
	aClass3_830 = JString.create("Mar");
	aClass3Array808
	    = new JString[] { aClass3_825, aClass3_821, aClass3_830,
			     aClass3_813, aClass3_826, aClass3_801,
			     aClass3_809, aClass3_806, aClass3_800,
			     aClass3_818, aClass3_798, aClass3_804 };
	aClass7_811 = new Cache(500);
    }
}
