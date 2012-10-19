package com.jagex.config;

/* Class39_Sub5_Sub8 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.utils.NameTable;
import com.jagex.io.BufferedFile;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.ImageImpl;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.awt.Graphics;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import unpackaged.Class13;
import unpackaged.Class15;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import unpackaged.Class43;
import com.jagex.utils.Timer;
import unpackaged.TextureLoaderImpl;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.script.ScriptExecutor;
import unpackaged.Class63;
import unpackaged.Class65;

public class VarbitDefinition extends SubNode
{
    public static int anInt1790 = 0;
    public int stateId;
    public int anInt1793;
    public int anInt1794;
    public static AbstractFileLoader npcFileLoader;
    public static Cache aClass7_1796 = new Cache(10);
    public static JString aClass3_1797
	= JString.create("@whi@ )4 ");
    public static int anInt1798 = 0;
    
    public static void method590(boolean bool) {
	try {
	    Graphics graphics = Class41.canvas.getGraphics();
	    FrameBuffer.aClass57_2155.draw(graphics, 0, 4);
	    TextureLoaderImpl.aClass57_1248.draw(graphics, 0, 357);
	    ImageImpl.aClass57_1576.draw(graphics, 722, 4);
	    NameTable.aClass57_182.draw(graphics, 743, 205);
	    Class43.aClass57_812.draw(graphics, 0, 0);
	    Class63.aClass57_1122.draw(graphics, 516, 4);
	    TraversalMap.aClass57_516.draw(graphics, 516, 205);
	    Widget.aClass57_2114.draw(graphics, 496,
							357);
	    Queue.aClass57_981.draw(graphics, 0, 338);
	} catch (Exception exception) {
	    Class41.canvas.repaint();
	}
    }
    
    public static void method591(byte i) {
	StillObject stillObject
	    = (StillObject) Class15.stillObjects.getFirst();
	if (i != 92)
	    method591((byte) -28);
	for (/**/; stillObject != null;
	     stillObject = ((StillObject)
			      Class15.stillObjects.getNext())) {
	    if (stillObject.anInt1456 > 0)
		stillObject.anInt1456--;
	    if (stillObject.anInt1456 == 0) {
		if (stillObject.objectId < 0 || ArchiveRequest.method862(i - 92, stillObject.anInt1451, stillObject.objectId)) {
		    TextureLoaderImpl.method1000(stillObject.type,
				       stillObject.height,
				       stillObject.anInt1449,
				       stillObject.positionY,
				       stillObject.objectId,
				       stillObject.anInt1451,
				       stillObject.positionX, false);
		    stillObject.unlinkDeque();
		}
	    } else {
		if (stillObject.anInt1476 > 0)
		    stillObject.anInt1476--;
		if (stillObject.anInt1476 == 0
		    && stillObject.positionX >= 1
		    && stillObject.positionY >= 1
		    && stillObject.positionX <= 102
		    && stillObject.positionY <= 102
		    && (stillObject.anInt1459 < 0
			|| ArchiveRequest.method862(0, stillObject.anInt1457,
						  stillObject.anInt1459))) {
		    TextureLoaderImpl.method1000(stillObject.type,
				       stillObject.height,
				       stillObject.rotation,
				       stillObject.positionY,
				       stillObject.anInt1459,
				       stillObject.anInt1457,
				       stillObject.positionX, false);
		    stillObject.anInt1476 = -1;
		    if (stillObject.anInt1459 != stillObject.objectId || stillObject.objectId != -1) {
			if (stillObject.anInt1459 == stillObject.objectId && (stillObject.rotation == stillObject.anInt1449) && (stillObject.anInt1451 == stillObject.anInt1457))
			    stillObject.unlinkDeque();
		    } else
			stillObject.unlinkDeque();
		}
	    }
	}
    }
    
    public void decode(Buffer buffer) {
	for (;;) {
	    int opcode = buffer.getUint8();
	    if (opcode == 0)
		break;
	    decodeOpcode(opcode, buffer);
	}
    }
    
    public static void method593(int i, int i_1_, boolean bool, byte[] is,
				 int i_2_) {
	if (TextureLoaderImpl.audioHandler != null) {
	    if (GroundItem.anInt2239 < 0) {
		if (ArchiveRequest.anInt1415 != 0) {
		    KeyListenerImpl.aBoolean628 = bool;
		    Class39_Sub5_Sub6.aByteArray1768 = is;
		    Class39_Sub5_Sub18.anInt2120 = i;
		} else {
                    ArchiveRequest.method857(i, bool, is, false);
                }
	    } else {
		Queue.anInt987 = i_2_;
		if (GroundItem.anInt2239 != 0) {
		    int i_3_ = (Mob.method512
				(929, GroundItem.anInt2239));
		    i_3_ -= Class65.anInt1141;
		    ArchiveRequest.anInt1415 = (i_3_ + 3600) / i_2_;
		    if (ArchiveRequest.anInt1415 < 1) {
                        ArchiveRequest.anInt1415 = 1;
                    }
		} else {
                    ArchiveRequest.anInt1415 = 1;
                }
		Class39_Sub5_Sub6.aByteArray1768 = is;
		Class39_Sub5_Sub18.anInt2120 = i;
		KeyListenerImpl.aBoolean628 = bool;
	    }
	}
    }
    
    public static void method594(int i, int i_4_) {
	if (JSocket.loadWidget(i_4_)) {
	    Widget[] widgets
		= AbstractMidiHandler.widgets[i_4_];
	    for (int i_5_ = 0; i_5_ < widgets.length; i_5_++) {
		Widget class39_sub5_sub17
		    = widgets[i_5_];
		if (class39_sub5_sub17 != null) {
		    class39_sub5_sub17.anInt2079 = 0;
		    class39_sub5_sub17.anInt1999 = 0;
		}
	    }
	}
    }
    
    public static void method595(int i) {
	synchronized (Npc.aClass35_2499) {
	    Buffer.readQueueOffset = Entity.anInt1731;
	    if (BufferedFile.writeActiveOffset < 0) {
		for (int i_6_ = 0; i_6_ < 112; i_6_++) {
                    Class13.activeKeys[i_6_] = false;
                }
		BufferedFile.writeActiveOffset = Timer.readOffset;
	    } else {
		while (BufferedFile.writeActiveOffset != Timer.readOffset) {
		    int keyCode = Class39_Sub5_Sub11.activeKeyQueue[Timer.readOffset];
		    Timer.readOffset = Timer.readOffset + 1 & 0x7f;
		    if (keyCode >= 0)
			Class13.activeKeys[keyCode] = true;
		    else
			Class13.activeKeys[keyCode ^ 0xffffffff] = false;
		}
	    }
	    Entity.anInt1731 = Mob.writeQueueOffset;
	}
    }
    
    public void decodeOpcode(int opcode, Buffer buffer) {
	if (opcode == 1) {
	    stateId = buffer.getUint16();
	    anInt1793 = buffer.getUint8();
	    anInt1794 = buffer.getUint8();
	}
    }
    
    public static void method597(int i) {
	ArchiveWorker.aClass57_1196.method1006(10);
    }
    
    public static void method598(byte i) {
	aClass3_1797 = null;
	ScriptExecutor.strStack = null;
	aClass7_1796 = null;
	npcFileLoader = null;
    }
}
