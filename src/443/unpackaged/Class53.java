package unpackaged;

/* Class53 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.Entity;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.ItemContainer;
import com.jagex.config.Widget;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.ImageImpl;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;
import java.awt.Component;

public class Class53
{
    public static int[] experienceForLevel = new int[99];
    public static JString spaceJstr;
    public static JString aClass3_954;
    public static Cache itemDefinitionCache;
    public static JString aClass3_956;
    public static JString aClass3_957;
    public static JString aClass3_958;
    public static JString crown2Jstr;
    public static JString aClass3_960;
    public static JString aClass3_961;
    public static int anInt962;
    public static JString aClass3_963;
    public static int[] anIntArray964;
    public static int anInt965;
    public static JString aClass3_966;
    public static JString aClass3_967;
    public static int anInt968;
    public static int[] anIntArray969;
    public static int[] anIntArray970;
    
    public static void method982(int i, Component component) {
	component.removeMouseListener(ItemContainer.aClass42_1502);
	component.removeMouseMotionListener(ItemContainer.aClass42_1502);
	component.removeFocusListener(ItemContainer.aClass42_1502);
    }
    
    public static void method983(byte i) {
	aClass3_958 = null;
	aClass3_963 = null;
	anIntArray969 = null;
	spaceJstr = null;
	itemDefinitionCache = null;
	aClass3_966 = null;
	anIntArray964 = null;
	experienceForLevel = null;
	aClass3_961 = null;
	aClass3_960 = null;
	anIntArray970 = null;
	aClass3_967 = null;
	crown2Jstr = null;
	aClass3_954 = null;
	aClass3_956 = null;
	aClass3_957 = null;
    }
    
    public static void method984(int i) {
	Class39_Sub5_Sub11.incomingBuffer.initBitAccess();
	int i_0_
	    = Class39_Sub5_Sub11.incomingBuffer.getBits(8);
	if (i_0_ < ArchiveWorker.anInt1210) {
	    for (int i_1_ = i_0_; i_1_ < ArchiveWorker.anInt1210; i_1_++)
		Class26.anIntArray496[Huffman.anInt749++]
		    = Entity.anIntArray1734[i_1_];
	}
	if (ArchiveWorker.anInt1210 < i_0_)
	    throw new RuntimeException("gnpov1");
	ArchiveWorker.anInt1210 = 0;
	for (int i_2_ = 0; i_2_ < i_0_; i_2_++) {
	    int i_3_ = Entity.anIntArray1734[i_2_];
	    Npc npc
		= (GroundItem.npcs
		   [i_3_]);
	    int i_4_
		= Class39_Sub5_Sub11.incomingBuffer.getBits(1);
	    if (i_4_ == 0) {
		Entity.anIntArray1734[ArchiveWorker.anInt1210++] = i_3_;
		npc.anInt2290 = Class2.logicCycle;
	    } else {
		int i_5_ = Class39_Sub5_Sub11.incomingBuffer
			       .getBits(2);
		if (i_5_ == 0) {
		    Entity.anIntArray1734[ArchiveWorker.anInt1210++]
			= i_3_;
		    npc.anInt2290 = Class2.logicCycle;
		    ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++]
			= i_3_;
		} else if (i_5_ == 1) {
		    Entity.anIntArray1734[ArchiveWorker.anInt1210++]
			= i_3_;
		    npc.anInt2290 = Class2.logicCycle;
		    int i_6_ = Class39_Sub5_Sub11.incomingBuffer
				   .getBits(3);
		    npc.queueStep(i_6_, false);
		    int i_7_ = Class39_Sub5_Sub11.incomingBuffer
				   .getBits(1);
		    if (i_7_ == 1)
			ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++]
			    = i_3_;
		} else if (i_5_ == 2) {
		    Entity.anIntArray1734[ArchiveWorker.anInt1210++]
			= i_3_;
		    npc.anInt2290 = Class2.logicCycle;
		    int i_8_ = Class39_Sub5_Sub11.incomingBuffer
				   .getBits(3);
		    npc.queueStep(i_8_, true);
		    int i_9_ = Class39_Sub5_Sub11.incomingBuffer
				   .getBits(3);
		    npc.queueStep(i_9_, true);
		    int i_10_ = Class39_Sub5_Sub11.incomingBuffer
				    .getBits(1);
		    if (i_10_ == 1)
			ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++]
			    = i_3_;
		} else if (i_5_ == 3)
		    Class26.anIntArray496[Huffman.anInt749++] = i_3_;
	    }
	}
    }
    
    public static void writeOutgoingBuffer(boolean flush) {
	Class41.anInt780++;
	if (Class41.anInt780 >= 50 || flush) {
	    Class41.anInt780 = 0;
	    do {
		if (!Widget.aBoolean2116
		    && Class37.gameSocket != null) {
		    Class34.anInt604++;
		    FrameBuffer.outgoingBuffer.putFrame(86);
		    try {
			Class37.gameSocket.write((FrameBuffer.outgoingBuffer.payload), 0, (FrameBuffer.outgoingBuffer.offset));
			FrameBuffer.outgoingBuffer.offset  = 0;
		    } catch (java.io.IOException ioexception) {
			Widget.aBoolean2116 = true;
			break;
		    }
		    break;
		}
	    } while (false);
	}
    }
    
    public static boolean method986(int i, int i_12_, int i_13_) {
	if (i_12_ == 0 && Class39_Sub5_Sub6.anInt1760 == i)
	    return true;
	if (i_13_ == i_12_ && Class39_Sub10.anInt1440 == i)
	    return true;
	if ((i_12_ == 2 || i_12_ == 3) && i == VarpDefinition.anInt1982)
	    return true;
	return false;
    }
    
    static {
	int i = 0;
	for (int i_14_ = 0; i_14_ < 99; i_14_++) {
	    int i_15_ = i_14_ + 1;
	    int i_16_ = (int) (Math.pow(2.0, (double) i_15_ / 7.0) * 300.0
			       + (double) i_15_);
	    i += i_16_;
	    experienceForLevel[i_14_] = i / 4;
	}
	aClass3_956
	    = (JString.create
	       ("Sie befinden sich in einem Mitglieder)2Gebiet(Q"));
	aClass3_954 = JString.create("wave:");
	aClass3_957 = JString.create(" ");
	spaceJstr = aClass3_957;
	crown2Jstr = JString.create("@cr2@");
	aClass3_958 = aClass3_954;
	itemDefinitionCache = new Cache(64);
	aClass3_961
	    = JString.create("Das ist eine Mitglieder)2Welt(Q");
	aClass3_960
	    = JString
		  .create("Your profile will be transferred in:");
	anInt962 = -1;
	aClass3_966
	    = JString
		  .create("m-Ochte sich mit Ihnen duellieren)3");
	aClass3_963 = JString.create("Classic");
	aClass3_967 = aClass3_960;
	anIntArray964 = new int[] { 0, -1, 0, 1 };
	anInt968 = 0;
    }
}
