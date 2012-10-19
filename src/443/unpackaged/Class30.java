package unpackaged;

import com.jagex.script.ClientScript;
import com.jagex.io.FileLoader;
import com.jagex.awt.listeners.JMouseListener;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.od.OndemandHandler;
import com.jagex.script.ScriptExecutor;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;

/* Class30 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class30
{
    public static JString aClass3_533 = JString.create("");
    public static int anInt534;
    public static JString aClass3_535;
    public static long aLong536;
    public static JString aClass3_537;
    public static JString aClass3_538;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_539;
    public static int anInt541;
    public static int anInt542 = 0;
    public static JString aClass3_543;
    public static int anInt544;
    public static JString aClass3_545;
    public static JString aClass3_546;
    public static JString aClass3_547;
    public static int anInt548;
    
    public static void method316(int i) {
	aClass39_Sub5_Sub10_Sub4_539 = null;
	aClass3_543 = null;
	aClass3_546 = null;
	aClass3_538 = null;
	aClass3_547 = null;
	aClass3_537 = null;
	aClass3_545 = null;
	aClass3_535 = null;
	ScriptExecutor.arrays = null;
	aClass3_533 = null;
    }
    
    public static JString createJstr(int i) {
	JString class3 = new JString();
	class3.length = 0;
	class3.bytes = new byte[i];
	return class3;
    }
    
    public static void method318(int i) {
	for (int i_1_ = -1; TraversalMap.anInt515 > i_1_; i_1_++) {
	    int i_2_;
	    if (i_1_ == -1)
		i_2_ = 2047;
	    else
		i_2_ = Class1.anIntArray40[i_1_];
	    Player class39_sub5_sub4_sub4_sub2
		= Class14.players[i_2_];
	    if (class39_sub5_sub4_sub4_sub2 != null)
		ClientScript.method480((byte) 116,
					    class39_sub5_sub4_sub4_sub2, 1);
	}
    }
    
    public static int method319(int i, int i_3_, int i_4_) {
	long l = (long) (i_3_ + (i << 16));
	if (FileLoader.currentOdRequest == null  || FileLoader.currentOdRequest.hash != l)
	    return 0;
	return ((OndemandHandler.requestBuffer.offset * 99 / (-FileLoader.currentOdRequest.footerSize + OndemandHandler.requestBuffer.payload.length)) + 1);
    }
    
    static {
	aLong536 = 0L;
	anInt541 = 0;
	aClass3_543 = JString.create(" x ");
	anInt544 = 0;
	aClass3_538 = (JString.create
		       ("Please wait 5 minutes before trying again)3"));
	aClass3_537 = aClass3_538;
	aClass3_547
	    = JString.create("wishes to trade with you)3");
	ScriptExecutor.arrays = new int[5][5000];
	aClass3_546
	    = JString
		  .create(" steht bereits auf Ihrer Freunde)2Liste(Q");
	anInt548 = 50;
	anInt534 = 0;
	aClass3_545 = JString.create("backbase2");
	aClass3_535 = aClass3_547;
    }
}
