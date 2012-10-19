package unpackaged;

import com.jagex.config.VarpDefinition;
import com.jagex.utils.ItemContainer;
import com.jagex.config.Model;
import com.jagex.script.ClientScript;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Barrier;
import com.jagex.awt.events.JMouseListener;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.io.Buffer;

/* Class39_Sub5_Sub18 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub5_Sub18 extends SubNode
{
    public static JString aClass3_2118
	= JString.create(" (X");
    public static int anInt2119 = 0;
    public static int anInt2120;
    public static int anInt2121;
    public int anInt2122;
    public static JString aClass3_2123;
    public static int anInt2124;
    public static JString aClass3_2125
	= JString.create("backvmid1");
    public int anInt2126;
    public int anInt2127 = 0;
    public int anInt2128;
    public static JString aClass3_2129;
    public static AbstractImage aClass57_2130;
    public static JString aClass3_2131;
    public int anInt2132;
    public int anInt2133 = 128;
    public static JString percentJstr;
    public static JString aClass3_2135;
    public int[] anIntArray2136;
    public int anInt2137;
    public static JString aClass3_2138;
    public int anInt2139;
    public int[] anIntArray2140;
    
    public static void getMousePosition() {
	synchronized (ItemContainer.aClass42_1502) {
	    Class30.anInt541 = ClientScript.anInt1699;
	    ISAAC.mousePositionX = Projectile.queuedMousePositionX;
	    Class33.mousePositionY = Barrier.queuedMousePositionY;
	    Timer.anInt887 = Class23.anInt430;
	    Class39_Sub4.mouseClickPositionX = JMouseListener.anInt791;
	    Bzip2Entry.mouseClickPositionY = Class41.anInt784;
	    StillGraphic.aLong2331 = Class2.aLong55;
	    Class23.anInt430 = 0;
	}
    }
    
    public void method777(Buffer class39_sub6, int i, int i_0_) {
	if (i != 1) {
	    if (i != 2) {
		if (i != 4) {
		    if (i != 5) {
			if (i == 6)
			    anInt2128 = class39_sub6.getUword();
			else if (i == 7)
			    anInt2127 = class39_sub6.getUbyte();
			else if (i != 8) {
			    if (i >= 40 && i < 50)
				anIntArray2140[i - 40]
				    = class39_sub6.getUword();
			    else if (i >= 50 && i < 60)
				anIntArray2136[i - 50]
				    = class39_sub6.getUword();
			} else
			    anInt2132 = class39_sub6.getUbyte();
		    } else
			anInt2139 = class39_sub6.getUword();
		} else
		    anInt2133 = class39_sub6.getUword();
	    } else
		anInt2126 = class39_sub6.getUword();
	} else
	    anInt2122 = class39_sub6.getUword();
	int i_1_ = 43 / ((i_0_ + 61) / 47);
    }
    
    public Model method778(int i, int i_2_) {
	Model class39_sub5_sub4_sub6
	    = ((Model)
	       VarpDefinition.aClass7_1975.get((long) anInt2137));
	if (class39_sub5_sub4_sub6 == null) {
	    class39_sub5_sub4_sub6
		= Model
		      .getModel(Class39_Sub5_Sub5.aClass9_1740, anInt2122, 0);
	    if (class39_sub5_sub4_sub6 == null)
		return null;
	    for (int i_3_ = 0; i_3_ < 6; i_3_++) {
		if (anIntArray2140[0] != 0)
		    class39_sub5_sub4_sub6.method563(anIntArray2140[i_3_],
						     anIntArray2136[i_3_]);
	    }
	    class39_sub5_sub4_sub6.initializeTriAndVertexGroups();
	    class39_sub5_sub4_sub6.applyLightingVector(64 + anInt2127, anInt2132 + 850,
					     -30, -50, -30, true);
	    VarpDefinition.aClass7_1975.put(class39_sub5_sub4_sub6,
						      (long) anInt2137);
	}
	if (i != 180)
	    return null;
	Model class39_sub5_sub4_sub6_4_;
	if (anInt2126 != -1 && i_2_ != -1)
	    class39_sub5_sub4_sub6_4_
		= AbstractMidiHandler.method1064(anInt2126, (byte) 54)
		      .method705(class39_sub5_sub4_sub6, i_2_, i ^ ~0xc4);
	else
	    class39_sub5_sub4_sub6_4_ = class39_sub5_sub4_sub6.method547(true);
	if (anInt2133 != 128 || anInt2139 != 128)
	    class39_sub5_sub4_sub6_4_.method559(anInt2133, anInt2139,
						anInt2133);
	if (anInt2128 != 0) {
	    if (anInt2128 == 90)
		class39_sub5_sub4_sub6_4_.rotateAxisY();
	    if (anInt2128 == 180) {
		class39_sub5_sub4_sub6_4_.rotateAxisY();
		class39_sub5_sub4_sub6_4_.rotateAxisY();
	    }
	    if (anInt2128 == 270) {
		class39_sub5_sub4_sub6_4_.rotateAxisY();
		class39_sub5_sub4_sub6_4_.rotateAxisY();
		class39_sub5_sub4_sub6_4_.rotateAxisY();
	    }
	}
	return class39_sub5_sub4_sub6_4_;
    }
    
    public void method779(int i, Buffer class39_sub6) {
	for (;;) {
	    int i_5_ = class39_sub6.getUbyte();
	    if (i_5_ == 0)
		break;
	    method777(class39_sub6, i_5_, 86);
	}
    }
    
    public static void method780(boolean bool) {
	aClass3_2138 = null;
	aClass3_2129 = null;
	aClass3_2123 = null;
	aClass3_2135 = null;
	aClass3_2131 = null;
	aClass3_2118 = null;
	percentJstr = null;
	aClass3_2125 = null;
	aClass57_2130 = null;
    }
    
    public Class39_Sub5_Sub18() {
	anInt2132 = 0;
	anIntArray2136 = new int[6];
	anInt2126 = -1;
	anInt2128 = 0;
	anIntArray2140 = new int[6];
	anInt2139 = 128;
    }
    
    static {
	aClass3_2123 = JString.create("::errortest");
	percentJstr = JString.create("(U");
	anInt2124 = 0;
	aClass3_2129 = JString.create("Weiter");
	aClass3_2131
	    = JString.create("Gegenstand f-Ur Mitglieder");
	aClass3_2135 = JString.create("Benutzen");
	aClass3_2138 = JString.create("::clientdrop");
    }
}
