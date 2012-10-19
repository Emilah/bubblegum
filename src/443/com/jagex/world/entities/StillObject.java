package com.jagex.world.entities;

/* Class39_Sub11 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.ItemContainer;
import com.jagex.script.ScriptExecutor;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import java.awt.Image;
import unpackaged.Class14;

public class StillObject extends Node
{
    public int anInt1449;
    public static JString aClass3_1450;
    public int anInt1451;
    public static JString aClass3_1452
	= JString.create("Please remove ");
    public static JString aClass3_1453;
    public static JString aClass3_1454;
    public static JString aClass3_1455;
    public int anInt1456 = -1;
    public int anInt1457;
    public int height;
    public int anInt1459;
    public static int[] anIntArray1460;
    public static JString[] messagePrefixes;
    public static JString aClass3_1463;
    public static Image anImage1464;
    public static JString aClass3_1465;
    public int positionX;
    public static JString aClass3_1467;
    public static JString aClass3_1468;
    public int type;
    public static int fCameraPositionX;
    public int objectId;
    public int rotation;
    public static int anInt1473;
    public int positionY;
    public static JString aClass3_1475;
    public int anInt1476 = 0;
    public static JString aClass3_1477;
    public static int viewOverlayId;
    public static JString aClass3_1479;
    public static JString aClass3_1480;
    public static JString aClass3_1481;
    
    public static void method868(int i) {
	aClass3_1467 = null;
	messagePrefixes = null;
	aClass3_1454 = null;
	aClass3_1468 = null;
	aClass3_1455 = null;
	aClass3_1475 = null;
	aClass3_1452 = null;
	aClass3_1480 = null;
	anIntArray1460 = null;
	anImage1464 = null;
	aClass3_1450 = null;
	aClass3_1479 = null;
	aClass3_1463 = null;
	aClass3_1465 = null;
	aClass3_1453 = null;
	aClass3_1481 = null;
	aClass3_1477 = null;
    }
    
    public static int getItemId(int id, int slot) {
	ItemContainer class39_sub13
	    = ((ItemContainer)
	       Class14.itemContainerCache.get((long) id));
	if (class39_sub13 == null)
	    return -1;
	if (slot < 0 || class39_sub13.itemIds.length <= slot)
	    return -1;
	return class39_sub13.itemIds[slot];
    }
    
    static {
	aClass3_1450 = JString.create(" million");
	aClass3_1455 = JString.create("invback");
	aClass3_1453 = JString.create("Loaded config");
	aClass3_1467 = aClass3_1452;
	aClass3_1454 = aClass3_1452;
	messagePrefixes = new JString[100];
	aClass3_1463 = JString.create("Welt");
	aClass3_1468 = aClass3_1450;
	ScriptExecutor.sp = 0;
	aClass3_1475 = aClass3_1453;
	aClass3_1477 = JString.create("World");
	aClass3_1465 = aClass3_1477;
	aClass3_1480 = JString.create("headicons_pk");
	aClass3_1479 = JString.create("hitmarks");
	viewOverlayId = -1;
	aClass3_1481 = JString.create("logo");
    }
}
