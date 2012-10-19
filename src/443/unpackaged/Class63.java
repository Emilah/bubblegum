package unpackaged;

import com.jagex.utils.ItemContainer;
import com.jagex.config.Widget;
import com.jagex.config.VarbitDefinition;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.JString;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.od.OndemandHandler;

/* Class63 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class63
{
    public static int anInt1117;
    public static JString aClass3_1118;
    public static JString aClass3_1119;
    public static boolean isCustomMap = false;
    public static JString aClass3_1121;
    public static AbstractImage aClass57_1122;
    public static JString aClass3_1123;
    public static JString aClass3_1124;
    public static JString aClass3_1125;
    public static int isMember;
    public static JString aClass3_1127
	= JString
	      .create("Please wait )2 attempting to reestablish");
    public static int useWithItemId;
    public static JString aClass3_1129;
    public static JString aClass3_1130;
    public static JString aClass3_1131;
    
    public static void method1085(int i) {
	Widget.varbitCache.clear();
    }
    
    public static void removeItemContainer(byte i, int i_0_) {
	ItemContainer class39_sub13
	    = ((ItemContainer)
	       Class14.itemContainerCache.get((long) i_0_));
	if (class39_sub13 != null)
	    class39_sub13.unlinkDeque();
    }
    
    public static void method1087(int i, int i_1_) {
	VarbitDefinition.method593(0, 1, false, null, i_1_);
    }
    
    public static void method1088(int i) {
	aClass3_1123 = null;
	aClass57_1122 = null;
	aClass3_1121 = null;
	aClass3_1130 = null;
	aClass3_1125 = null;
	if (i != 0)
	    removeItemContainer((byte) -76, -93);
	aClass3_1124 = null;
	aClass3_1118 = null;
	aClass3_1131 = null;
	aClass3_1127 = null;
	aClass3_1129 = null;
	aClass3_1119 = null;
    }
    
    public static JString decodeHuffmans(Buffer buffer) {
	return StillGraphic.decodeHuffmans(buffer, 32767);
    }
    
    static {
	isMember = 0;
	aClass3_1124 = JString.create("glow2:");
	aClass3_1118 = aClass3_1127;
	anInt1117 = 0;
	aClass3_1125 = JString.create("k");
	aClass3_1129 = aClass3_1124;
	aClass3_1131 = JString.create("Bad session id)3");
	aClass3_1121 = JString.create("Texturen geladen)3");
	aClass3_1119 = aClass3_1131;
	aClass3_1130
	    = JString.create("Unexpected loginserver response)3");
	aClass3_1123 = aClass3_1130;
    }
}
