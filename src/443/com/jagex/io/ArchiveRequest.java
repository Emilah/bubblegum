package com.jagex.io;

/* Class39_Sub9 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.config.ObjectDefinition;
import com.jagex.awt.JCanvas;
import com.jagex.io.CacheIO;
import com.jagex.utils.Bzip2Entry;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DrawingArea;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.awt.Graphics;
import unpackaged.Class1;
import unpackaged.Class14;
import unpackaged.Class30;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class34;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub4;
import com.jagex.graphics.TriangleRasterizer;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import unpackaged.Class43;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.TextureLoaderImpl;
import unpackaged.Class65;
import unpackaged.Class67;
import com.jagex.script.ClientScript;

public class ArchiveRequest extends Node
{
    public static int[] anIntArray1400;
    public static int anInt1401;
    public static JString aClass3_1402
	= JString.create("W-=hlen Sie eine Option");
    public static int swapSlotFrom;
    public byte[] payload;
    public static int runEnergy;
    public FileLoader loader;
    public static int anInt1407;
    public static int anInt1408;
    public CacheIO cache;
    public int type;
    public static int anInt1411;
    public static int[][][] anIntArrayArrayArray1412;
    public static int loginAttempts;
    public static JString aClass3_1414;
    public static int anInt1415;
    
    public static void method857(int i, boolean loop, byte[] is,
				 boolean bool_0_) {
	if (TextureLoaderImpl.audioHandler != null) {
	    if (GroundItem.anInt2239 >= 0) {
		TextureLoaderImpl.audioHandler.method1048(false);
		GroundItem.anInt2239 = -1;
		Class65.anInt1141 = 0;
		Class39_Sub5_Sub6.aByteArray1768 = null;
		anInt1415 = 20;
	    }
	    if (is != null) {
		if (anInt1415 > 0) {
		    TextureLoaderImpl.audioHandler.method1053(i, (byte) 58);
		    anInt1415 = 0;
		}
		GroundItem.anInt2239 = i;
		TextureLoaderImpl.audioHandler.updateSequencer(i, is, (byte) 84, loop);
	    }
	}
    }
    
    public static void method858(byte i) {
	Class39_Sub4.updateWidgets(SubNode.screenWidgetId);
	if (ClientScript.screenOverlayId != -1)
	    Class39_Sub4.updateWidgets(ClientScript.screenOverlayId);
	PlayerApperance.anInt856 = 0;
	Class34.aClass57_610.method1006(10);
	Buffer.anIntArray1355
	    = TriangleRasterizer.method657(Buffer.anIntArray1355);
	DrawingArea.reset();
	Deque.drawWidgets(503, 765, 0, SubNode.screenWidgetId, 0, -1, 0);
	if (ClientScript.screenOverlayId != -1)
	    Deque.drawWidgets(503, 765, 0, ClientScript.screenOverlayId, 0, -1, 0);
	if (!Class39_Sub12.aBoolean1493) {
	    JString.method95(18);
	    MouseRecorder.method320(-23401);
	} else
	    Class1.method49(-112);
	try {
	    Graphics graphics = Class41.canvas.getGraphics();
	    Class34.aClass57_610.draw(graphics, 0, 0);
	} catch (Exception exception) {
	    Class41.canvas.repaint();
	}
    }
    
    public static void method859(boolean bool) {
	aClass3_1402 = null;
	anIntArray1400 = null;
	anIntArrayArrayArray1412 = null;
	aClass3_1414 = null;
    }
    
    public static IndexedColorSprite method860(AbstractFileLoader class9, int i,
						    int i_1_) {
	if (!TraversalMap.method310(class9, i_1_, 84))
	    return null;
	return Bzip2Entry.method1036(false);
    }
    
    public static int method861(byte i, AbstractFileLoader class9) {
	int i_2_ = 0;
	if (class9.method152(22411, Class30.aClass3_533,
			     StillObject.aClass3_1455))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Class43.aClass3_803))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Class34.aClass3_609))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Bzip2Entry.aClass3_1056))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Class30.aClass3_545))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Cache.aClass3_107))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, ISAAC.aClass3_1103))
	    i_2_++;
	if (class9.method152(i ^ ~0x57b5, Class30.aClass3_533,
			     Class67.aClass3_1169))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, BufferedFile.aClass3_348))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Class41.aClass3_771))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533,
			     Class39_Sub5_Sub14.aClass3_1904))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533,
			     Class39_Sub5_Sub18.aClass3_2125))
	    i_2_++;
	if (i != -63)
	    method859(false);
	if (class9.method152(22411, Class30.aClass3_533,
			     Class39_Sub4.aClass3_1340))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, Class43.aClass3_822))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, ISAAC.aClass3_1090))
	    i_2_++;
	if (class9.method152(i + 22474, Class30.aClass3_533,
			     Npc.aClass3_2489))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533,
			     ObjectDefinition.aClass3_1937))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533,
			     FrameBuffer.aClass3_2149))
	    i_2_++;
	if (class9.method152(22411, Class30.aClass3_533, ArchiveWorker.aClass3_1200))
	    i_2_++;
	return i_2_;
    }
    
    public static boolean method862(int i, int i_3_, int i_4_) {
	ObjectDefinition class39_sub5_sub15
	    = JCanvas.getObjectDefinition(i_4_);
	if (i_3_ == 11)
	    i_3_ = 10;
	if (i_3_ >= 5 && i_3_ <= 8)
	    i_3_ = 4;
	return class39_sub5_sub15.method740(127, i_3_);
    }
    
    public static void resetItemContainer(int id) {
	ItemContainer class39_sub13 = ((ItemContainer) Class14.itemContainerCache.get((long) id));
	if (class39_sub13 != null) {
	    for (int i_6_ = 0; i_6_ < class39_sub13.itemIds.length; i_6_++) {
		class39_sub13.itemIds[i_6_] = -1;
		class39_sub13.itemAmts[i_6_] = 0;
	    }
	}
    }
    
    static {
	anIntArray1400 = new int[2048];
	anInt1407 = 0;
	anInt1411 = -1;
	anInt1401 = 0;
	runEnergy = 0;
	aClass3_1414 = JString.create("::qa_op_test");
	swapSlotFrom = 0;
	loginAttempts = 0;
	anInt1415 = 0;
    }
}
