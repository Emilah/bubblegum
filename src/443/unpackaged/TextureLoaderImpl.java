package unpackaged;

import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.Texture;
import com.jagex.script.ClientScript;
import com.jagex.Client;
import com.jagex.audio.AudioHandler;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.JCanvas;
import com.jagex.utils.NameTable;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;

/* Class55 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class TextureLoaderImpl implements TextureLoader
{
    public static FileLoader fileLoader13;
    public static IndexedColorSprite[] aClass39_Sub5_Sub10_Sub4Array1243;
    public static JString aClass3_1244;
    public static byte[][][] tileFlags;
    public static JString aClass3_1246;
    public static IndexedColorSprite[] aClass39_Sub5_Sub10_Sub4Array1247;
    public static AbstractImage aClass57_1248;
    public static JString aClass3_1249;
    public static JString aClass3_1250;
    public static AudioHandler audioHandler;
    public static int anInt1252 = 0;
    public static JString aClass3_1253;
    public Deque aClass49_1254 = new Deque();
    public static int[] anIntArray1255;
    public Texture[] textures;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1257;
    public int anInt1258 = 0;
    public AbstractFileLoader aClass9_1259;
    public int anInt1260;
    public int anInt1261 = 128;
    public double aDouble1262 = 1.0;
    
    public int[] method8(int i, int i_0_) {
	if (i_0_ != -9039)
	    method998((byte) -28);
	Texture class39_sub8 = textures[i];
	if (class39_sub8 != null) {
	    if (class39_sub8.anIntArray1395 != null) {
		aClass49_1254.offerFirst(class39_sub8);
		class39_sub8.aBoolean1398 = true;
		return class39_sub8.anIntArray1395;
	    }
	    boolean bool
		= class39_sub8.method853(aDouble1262, anInt1261, aClass9_1259);
	    if (bool) {
		if (anInt1258 != 0)
		    anInt1258--;
		else {
		    Texture class39_sub8_1_
			= (Texture) aClass49_1254.pollLast();
		    class39_sub8_1_.method854();
		}
		aClass49_1254.offerFirst(class39_sub8);
		class39_sub8.aBoolean1398 = true;
		return class39_sub8.anIntArray1395;
	    }
	}
	return null;
    }
    
    public static void method998(byte i) {
	audioHandler = null;
	aClass3_1244 = null;
	tileFlags = null;
	anIntArray1255 = null;
	aClass3_1246 = null;
	aClass39_Sub5_Sub10_Sub4_1257 = null;
	fileLoader13 = null;
	aClass39_Sub5_Sub10_Sub4Array1243 = null;
	aClass3_1253 = null;
	aClass3_1249 = null;
	aClass57_1248 = null;
	aClass3_1250 = null;
	aClass39_Sub5_Sub10_Sub4Array1247 = null;
    }
    
    public static void closeOverlays() {
	FrameBuffer.outgoingBuffer.putFrame(70);
	if (StillGraphic.tabOverlayId != -1) {
	    Class62_Sub2.method1084((byte) 126,
				    StillGraphic.tabOverlayId);
	    StillGraphic.tabOverlayId = -1;
	    ISAAC.aBoolean1089 = true;
	    Class39_Sub14.updateTab = true;
	    Class39_Sub10.anInt1420 = -1;
	}
	if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
	    Class62_Sub2.method1084((byte) 122, Class39_Sub5_Sub14.chatboxOverlayId);
	    Class39_Sub5_Sub14.chatboxOverlayId = -1;
	    Class14.aBoolean245 = true;
	    Class39_Sub10.anInt1420 = -1;
	}
	if (SubNode.screenWidgetId != -1) {
	    Class62_Sub2.method1084((byte) 119, SubNode.screenWidgetId);
	    SubNode.screenWidgetId = -1;
	    Client.setState(30);
	}
	if (ClientScript.screenOverlayId != -1) {
	    Class62_Sub2.method1084((byte) -31, ClientScript.screenOverlayId);
	    ClientScript.screenOverlayId = -1;
	}
	if (StillObject.viewOverlayId != -1) {
	    Class62_Sub2.method1084((byte) -75, StillObject.viewOverlayId);
	    Class39_Sub10.anInt1420 = -1;
	    StillObject.viewOverlayId = -1;
	}
    }
    
    public static void method1000(int type, int i_2_, int i_3_, int i_4_,
				  int i_5_, int i_6_, int i_7_, boolean bool) {
	if (bool)
	    aClass3_1246 = null;
	if (i_7_ >= 1 && i_4_ >= 1 && i_7_ <= 102 && i_4_ <= 102) {
	    if (!PlayerApperance.isLowMemory || i_2_ == NameTable.height) {
		int i_8_ = -1;
		boolean bool_9_ = false;
		boolean bool_10_ = false;
		int i_11_ = 0;
		if (type == 0)
		    i_11_ = Class44.world.method379(i_2_, i_7_, i_4_);
		if (type == 1)
		    i_11_ = Class44.world.method363(i_2_, i_7_, i_4_);
		if (type == 2)
		    i_11_ = Class44.world.method384(i_2_, i_7_, i_4_);
		if (type == 3)
		    i_11_ = Class44.world.method404(i_2_, i_7_, i_4_);
		if (i_11_ != 0) {
		    i_8_ = i_11_ >> 14 & 0x7fff;
		    int i_12_ = Class44.world.method359(i_2_, i_7_,
							       i_4_, i_11_);
		    int i_13_ = i_12_ & 0x1f;
		    int i_14_ = (i_12_ & 0xdd) >> 6;
		    if (type == 0) {
			Class44.world.method380(i_2_, i_7_, i_4_);
			ObjectDefinition class39_sub5_sub15
			    = JCanvas.getObjectDefinition(i_8_);
			if (class39_sub5_sub15.aBoolean1928)
			    Class39_Sub5_Sub12.traversalMaps[i_2_]
				.method299
				((byte) 40, i_14_, i_7_, i_4_, i_13_,
				 class39_sub5_sub15.aBoolean1949);
		    }
		    if (type == 1)
			Class44.world.method366(i_2_, i_7_, i_4_);
		    if (type == 2) {
			Class44.world.method398(i_2_, i_7_, i_4_);
			ObjectDefinition class39_sub5_sub15
			    = JCanvas.getObjectDefinition(i_8_);
			if (i_7_ + class39_sub5_sub15.anInt1925 > 103
			    || i_4_ + class39_sub5_sub15.anInt1925 > 103
			    || i_7_ + class39_sub5_sub15.anInt1948 > 103
			    || i_4_ + class39_sub5_sub15.anInt1948 > 103)
			    return;
			if (class39_sub5_sub15.aBoolean1928)
			    Class39_Sub5_Sub12.traversalMaps[i_2_]
				.method295
				(i_14_, class39_sub5_sub15.anInt1948, i_4_,
				 i_7_, (byte) -27,
				 class39_sub5_sub15.aBoolean1949,
				 class39_sub5_sub15.anInt1925);
		    }
		    if (type == 3) {
			Class44.world.method364(i_2_, i_7_, i_4_);
			ObjectDefinition class39_sub5_sub15
			    = JCanvas.getObjectDefinition(i_8_);
			if (class39_sub5_sub15.aBoolean1928
			    && class39_sub5_sub15.anInt1941 == 1)
			    Class39_Sub5_Sub12.traversalMaps[i_2_]
				.method300(i_7_, i_4_, (byte) 61);
		    }
		}
		if (i_5_ >= 0) {
		    int i_15_ = i_2_;
		    if (i_15_ < 3 && (tileFlags[1][i_7_][i_4_]
				      & 0x2) == 2)
			i_15_++;
		    Class39_Sub5_Sub12.method712((Class39_Sub5_Sub12
						  .traversalMaps[i_2_]),
						 i_7_, i_3_, i_2_, i_15_, i_5_,
						 i_6_, Class44.world,
						 -114, i_4_);
		}
	    }
	}
    }
    
    public static Class39_Sub5_Sub12 method1001(byte i, int i_16_) {
	Class39_Sub5_Sub12 class39_sub5_sub12
	    = ((Class39_Sub5_Sub12)
	       ArchiveWorker.aClass7_1197.get((long) i_16_));
	if (class39_sub5_sub12 != null)
	    return class39_sub5_sub12;
	class39_sub5_sub12
	    = NameTable.method182(i_16_, NpcDefinition.aClass9_1860,
				Node.aClass9_739, 66, false);
	if (class39_sub5_sub12 != null)
	    ArchiveWorker.aClass7_1197.put(class39_sub5_sub12, (long) i_16_);
	return class39_sub5_sub12;
    }
    
    public boolean method10(int i, int i_17_) {
	if (i != -11819)
	    return false;
	if (anInt1261 != 64)
	    return false;
	return true;
    }
    
    public void method1002(int i) {
	for (int i_18_ = 0; i_18_ < textures.length; i_18_++) {
	    if (textures[i_18_] != null)
		textures[i_18_].method854();
	}
	aClass49_1254 = new Deque();
	anInt1258 = anInt1260;
    }
    
    public void method1003(double d, boolean bool) {
	aDouble1262 = d;
	method1002(66);
    }
    
    public int method7(int i, int i_19_) {
	if (i != 105)
	    method8(90, 89);
	if (textures[i_19_] != null)
	    return textures[i_19_].anInt1396;
	return 0;
    }
    
    public boolean method9(byte i, int i_20_) {
	if (i != -50)
	    aClass9_1259 = null;
	return textures[i_20_].aBoolean1393;
    }
    
    public void method1004(int i, boolean bool) {
	for (int i_21_ = 0; i_21_ < textures.length; i_21_++) {
	    Texture class39_sub8 = textures[i_21_];
	    if (class39_sub8 != null && class39_sub8.anInt1394 != 0
		&& class39_sub8.aBoolean1398) {
		class39_sub8.method855(i);
		class39_sub8.aBoolean1398 = false;
	    }
	}
    }
    
    public TextureLoaderImpl(AbstractFileLoader texturesLoader, AbstractFileLoader class9_22_, int i, double d,
		   int i_23_) {
	aClass9_1259 = class9_22_;
	aDouble1262 = d;
	anInt1261 = i_23_;
	anInt1260 = i;
	anInt1258 = anInt1260;
	int[] children = texturesLoader.getChildrenEntries(0);
	int i_24_ = children.length;
	textures = new Texture[texturesLoader.getAmountChildren(0)];
	for (int i_25_ = 0; i_24_ > i_25_; i_25_++) {
	    Buffer buffer = new Buffer(texturesLoader.lookupFile(0, children[i_25_]));
	    textures[children[i_25_]] = new Texture(buffer);
	}
    }
    
    static {
	aClass3_1249
	    = JString
		  .create("zur-Uck auf die RuneScape)2Webseite gehen");
	aClass3_1250
	    = JString
		  .create("Wen m-Ochten Sie der Liste hinzuf-Ugen?");
	aClass3_1244 = JString.create("scroll:");
	tileFlags = new byte[4][104][104];
	aClass3_1246
	    = JString
		  .create("-5berpr-Ufen Sie Ihr Mitteilungsfach)3");
	aClass3_1253 = aClass3_1244;
    }
}
