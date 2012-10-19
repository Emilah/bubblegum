package unpackaged;

import com.jagex.world.Entity;
import com.jagex.graphics.TriangleRasterizer;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.Model;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Mob;
import com.jagex.awt.JCanvas;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;

/* Class39_Sub5_Sub7 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub5_Sub7 extends SubNode
{
    public static int minimapState = 0;
    public static JString aClass3_1777;
    public static AbstractImage aClass57_1778;
    public static volatile int anInt1779;
    public static JString aClass3_1780;
    public static int anInt1781;
    public static JString aClass3_1782
	= JString.create("Loaded fonts");
    public static int anInt1783;
    public static int anInt1784;
    public byte[] aByteArray1785;
    public static JString aClass3_1786;
    public static JString aClass3_1787;
    public static JString aClass3_1788;
    public static int[] anIntArray1789;
    
    public static void method584(Mob class39_sub5_sub4_sub4,
				 byte i) {
	if (Class2.logicCycle == class39_sub5_sub4_sub4.anInt2261
	    || class39_sub5_sub4_sub4.anInt2268 == -1
	    || class39_sub5_sub4_sub4.anInt2305 != 0
	    || (class39_sub5_sub4_sub4.anInt2311 + 1
		> (AbstractMidiHandler.method1064
		   (class39_sub5_sub4_sub4.anInt2268, (byte) 54).anIntArray1831
		   [class39_sub5_sub4_sub4.anInt2265]))) {
	    int i_0_ = (class39_sub5_sub4_sub4.anInt2261
			- class39_sub5_sub4_sub4.anInt2256);
	    int i_1_ = Class2.logicCycle - class39_sub5_sub4_sub4.anInt2256;
	    int i_2_ = (class39_sub5_sub4_sub4.anInt2297 * 64
			+ class39_sub5_sub4_sub4.anInt2287 * 128);
	    int i_3_ = (class39_sub5_sub4_sub4.anInt2297 * 64
			+ class39_sub5_sub4_sub4.anInt2266 * 128);
	    int i_4_ = (class39_sub5_sub4_sub4.anInt2297 * 64
			+ class39_sub5_sub4_sub4.anInt2277 * 128);
	    class39_sub5_sub4_sub4.fPositionX
		= (i_4_ * i_1_ + (i_0_ - i_1_) * i_3_) / i_0_;
	    int i_5_ = (class39_sub5_sub4_sub4.anInt2279 * 128
			+ class39_sub5_sub4_sub4.anInt2297 * 64);
	    class39_sub5_sub4_sub4.fPositionY
		= (i_2_ * (-i_1_ + i_0_) + i_1_ * i_5_) / i_0_;
	}
	class39_sub5_sub4_sub4.anInt2274 = 0;
	if (class39_sub5_sub4_sub4.anInt2292 == 0)
	    class39_sub5_sub4_sub4.anInt2294 = 1024;
	if (class39_sub5_sub4_sub4.anInt2292 == 1)
	    class39_sub5_sub4_sub4.anInt2294 = 1536;
	if (class39_sub5_sub4_sub4.anInt2292 == 2)
	    class39_sub5_sub4_sub4.anInt2294 = 0;
	if (class39_sub5_sub4_sub4.anInt2292 == 3)
	    class39_sub5_sub4_sub4.anInt2294 = 512;
	class39_sub5_sub4_sub4.anInt2251 = class39_sub5_sub4_sub4.anInt2294;
    }
    
    public static Widget method585
	(int i, int i_6_, int i_7_, Widget[] class39_sub5_sub17s,
	 int i_8_, int i_9_, int i_10_, Widget class39_sub5_sub17,
	 int i_11_, int i_12_, int i_13_, int i_14_) {
	if (i_11_ > i_6_ || i_8_ < i_12_ || i_6_ >= i_7_ || i_10_ <= i_8_)
	    return null;
	for (int i_15_ = 0; i_15_ < class39_sub5_sub17s.length; i_15_++) {
	    Widget widget
		= class39_sub5_sub17s[i_15_];
	    if (widget != null
		&& i == widget.anInt2050
		&& !widget.method754(HashTable.aBoolean361)
		&& widget != class39_sub5_sub17) {
		int i_17_ = widget.displayOffsetY + i_12_ - i_14_;
		int i_18_ = widget.displayOffsetX - (-i_11_ + i_9_);
		if (widget.type == 0) {
		    Widget class39_sub5_sub17_19_
			= method585(widget.id, i_6_,
				    i_18_ + widget.width,
				    class39_sub5_sub17s, i_8_,
				    widget.scrollX,
				    widget.height + i_17_,
				    class39_sub5_sub17, i_18_, i_17_, -64,
				    widget.scrollY);
		    if (class39_sub5_sub17_19_ != null)
			return class39_sub5_sub17_19_;
		    if (widget.children
			!= null) {
			class39_sub5_sub17_19_
			    = method585(widget.id, i_6_,
					(i_18_
					 + widget.width),
					(widget
					 .children),
					i_8_, widget.scrollX,
					(widget.height
					 + i_17_),
					class39_sub5_sub17, i_18_, i_17_, -50,
					widget.scrollY);
			if (class39_sub5_sub17_19_ != null)
			    return class39_sub5_sub17_19_;
		    }
		}
		if (widget.method772(false) && i_18_ <= i_6_
		    && i_8_ >= i_17_
		    && i_6_ < widget.width + i_18_
		    && widget.height + i_17_ > i_8_)
		    return widget;
	    }
	}
	return null;
    }
    
    public static int method586(boolean bool, boolean bool_20_, int i) {
	int i_21_ = i;
	if (bool_20_)
	    i_21_ += Class1.pendingPriorityRequests + Class39_Sub5_Sub6.queuedPriorityRequests;
	if (bool)
	    i_21_ += Class41.queuedRegularRequests + JCanvas.pendingRegularRequests;
	return i_21_;
    }
    
    public static void method587(int i) {
	aClass3_1777 = null;
	aClass3_1787 = null;
	aClass3_1780 = null;
	anIntArray1789 = null;
	aClass3_1786 = null;
	aClass57_1778 = null;
	aClass3_1788 = null;
	aClass3_1782 = null;
    }
    
    public static boolean method588(int i) {
	synchronized (Npc.aClass35_2499) {
	    if (Entity.anInt1731 == Buffer.readQueueOffset)
		return false;
	    Class15.currentKeyCode = Timer.keyCodeQueue[Buffer.readQueueOffset];
	    Projectile.currentKey
		= MsTimer.keyQueue[Buffer.readQueueOffset];
	    Buffer.readQueueOffset = Buffer.readQueueOffset + 1 & 0x7f;
	    return true;
	}
    }
    
    public Class39_Sub5_Sub7(byte[] is) {
	aByteArray1785 = is;
    }
    
    public static void method589(byte i) {
	JCanvas.anInt15++;
	Class34.method335(-18587, true);
	Class1.method45(-11, true);
	Class34.method335(-18587, false);
	Class1.method45(-11, false);
	Class50.updateProjectiles();
	Class62_Sub2.method1072(6255);
	if (!TraversalMap.isCameraMoving) {
	    int i_22_ = JSocket.anInt301;
	    if (Cache.anInt101 / 256 > i_22_)
		i_22_ = Cache.anInt101 / 256;
	    int i_23_ = SubNode.anInt1344 + Class34.anInt605 & 0x7ff;
	    if (Class44.aBooleanArray837[4] && Class2.anIntArray49[4] + 128 > i_22_)
		i_22_ = Class2.anIntArray49[4] + 128;
	    JApplet.method26
		(1000, Class41.anInt765, i_23_, Class39_Sub10.anInt1431,
		 i_22_ * 3 + 600, i_22_,
		 Class14.method212((Cache.localPlayer
                                    .fPositionY), (Cache.localPlayer
				    .fPositionX), NameTable.height) - 50);
	}
	int i_24_;
	if (TraversalMap.isCameraMoving)
	    i_24_ = Class23.method274((byte) 108);
	else
	    i_24_ = Class33.method330(113);
	int i_25_ = StillObject.fCameraPositionX;
	int i_26_ = Class39_Sub10.cameraHeight;
	int i_27_ = Node.fCameraPositionY;
	int i_28_ = Class43.anInt799;
	int i_29_ = Mob.anInt2315;
	for (int i_30_ = 0; i_30_ < 5; i_30_++) {
	    if (Class44.aBooleanArray837[i_30_]) {
		int i_31_
		    = (int) (((double) (Class13.anIntArray197[i_30_] * 2 + 1)
			      * Math.random())
			     - (double) Class13.anIntArray197[i_30_]
			     + (Math.sin((double) Class4.anIntArray75[i_30_]
					 * ((double) (PlayerApperance.anIntArray857
						      [i_30_])
					    / 100.0))
				* (double) Class2.anIntArray49[i_30_]));
		if (i_30_ == 0)
		    StillObject.fCameraPositionX += i_31_;
		if (i_30_ == 3)
		    Mob.anInt2315
			= Mob.anInt2315 + i_31_ & 0x7ff;
		if (i_30_ == 2)
		    Node.fCameraPositionY += i_31_;
		if (i_30_ == 4) {
		    Class43.anInt799 += i_31_;
		    if (Class43.anInt799 < 128)
			Class43.anInt799 = 128;
		    if (Class43.anInt799 > 383)
			Class43.anInt799 = 383;
		}
		if (i_30_ == 1)
		    Class39_Sub10.cameraHeight += i_31_;
	    }
	}
	ClientScript.method481(-6414);
	Model.anInt2397 = ISAAC.mousePositionX - 4;
	Model.anInt2407 = Class33.mousePositionY - 4;
	Model.anInt2413 = 0;
	Model.aBoolean2398 = true;
	DrawingArea.reset();
	Class44.world.method382(StillObject.fCameraPositionX,
				       Class39_Sub10.cameraHeight,
				       Node.fCameraPositionY, Class43.anInt799,
				       Mob.anInt2315,
				       i_24_);
	Class44.world.method393();
	Class1.method48(false);
	ImageImpl.method1012(0);
	((TextureLoaderImpl) TriangleRasterizer.textureLoader)
	    .method1004(PlayerApperance.anInt856, false);
	JCanvas.method39(-32024);
	if (AbstractImage.aBoolean1000 && method586(false, true, 0) == 0)
	    AbstractImage.aBoolean1000 = false;
	if (AbstractImage.aBoolean1000) {
	    ClientScript.method481(-6414);
	    DrawingArea.reset();
	    Class26.method294(false, NameTable.aClass3_190, null, -77);
	}
	Timer.method940();
	Class39_Sub10.cameraHeight = i_26_;
	StillObject.fCameraPositionX = i_25_;
	Node.fCameraPositionY = i_27_;
	Mob.anInt2315 = i_29_;
	Class43.anInt799 = i_28_;
    }
    
    static {
	anInt1779 = 0;
	aClass3_1788 = JString.create("glow3:");
	aClass3_1787 = aClass3_1788;
	aClass3_1780
	    = JString.create("Welcome to RuneScape");
	aClass3_1777 = aClass3_1780;
	aClass3_1786 = aClass3_1782;
	anInt1783 = 0;
    }
}
