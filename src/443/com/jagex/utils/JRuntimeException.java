package com.jagex.utils;

import com.jagex.utils.MsTimer;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.utils.Cache;
import unpackaged.Class1;
import unpackaged.Class25;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class44;
import unpackaged.Class62_Sub2;

/* RuntimeException_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class JRuntimeException extends RuntimeException
{
    public static JString aClass3_1212
	= JString.create(" from your friend list first");
    public Throwable cause;
    public static JString aClass3_1214;
    public String message;
    public static int anInt1216 = 0;
    public static Deque stillGraphics;
    public static JString aClass3_1218;
    public static JString aClass3_1219;
    public static Cache aClass7_1220;
    public static boolean aBoolean1221;
    public static int anInt1222;
    public static JString examineJstrEng;
    public static JString examineJstr;
    public static boolean[] aBooleanArray1225;
    
    public static void method1122(byte i) {
	aClass3_1212 = null;
	examineJstrEng = null;
	aClass3_1218 = null;
	aClass7_1220 = null;
	aBooleanArray1225 = null;
	aClass3_1219 = null;
	examineJstr = null;
	aClass3_1214 = null;
	stillGraphics = null;
    }
    
    public static void method1123() {
	Class39_Sub5_Sub9.anIntArray1799 = null;
	TraversalMap.aByteArrayArray517 = null;
	SubNode.anIntArray1352 = null;
	Class39_Sub14.anIntArray1512 = null;
	StillObject.anIntArray1460 = null;
	MsTimer.anIntArray1548 = null;
    }
    
    public JRuntimeException(Throwable throwable, String string) {
	cause = throwable;
	message = string;
    }
    
    public static void method1124(byte i) {
	Class44.aBoolean833 = true;
	Class25.method288((byte) -112);
	if (StillGraphic.tabOverlayId == -1) {
	    if (Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId] != -1) {
		boolean bool
		    = Deque.drawWidgets(261, 190, 0, (Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId]), 0, -1, 1);
		if (!bool)
		    Class39_Sub14.updateTab = true;
	    }
	} else {
	    boolean bool = Deque.drawWidgets(261, 190, 0, StillGraphic.tabOverlayId, 0, -1, 1);
	    if (!bool)
		Class39_Sub14.updateTab = true;
	}
	if (Class39_Sub12.aBoolean1493 && Class37.anInt653 == 1) {
	    if (HashTable.languageId != 1)
		Class1.method49(94);
	    else
		Node.method407(false);
	}
	Class62_Sub2.method1079(8);
    }
    
    static {
	aClass3_1214 = aClass3_1212;
	stillGraphics = new Deque();
	aClass3_1218
	    = JString.create("Ung-Ultiger Benutzername");
	aClass3_1219 = JString.create("Einloggen");
	aClass7_1220 = new Cache(260);
	anInt1222 = 0;
	aBooleanArray1225 = new boolean[5];
	aBoolean1221 = false;
	examineJstrEng = JString.create("Examine");
	examineJstr = examineJstrEng;
    }
}
