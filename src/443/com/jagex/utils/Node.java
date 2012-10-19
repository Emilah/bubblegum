package com.jagex.utils;

import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.awt.JCanvas;
import unpackaged.Class1;
import unpackaged.Class12;
import unpackaged.Class14;
import unpackaged.Class2;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import com.jagex.graphics.TriangleRasterizer;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import unpackaged.Class43;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import com.jagex.audio.AudioHandler;
import unpackaged.Class66;
import unpackaged.Class68;
import com.jagex.Client;
import com.jagex.script.ClientScript;
import com.jagex.graphics.DrawingArea;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.config.NpcDefinition;
import com.jagex.od.OndemandRequest;
import com.jagex.world.entities.Projectile;
import com.jagex.script.ScriptState;
import com.jagex.world.entities.StillGraphic;
import com.jagex.config.Widget;

/* Class39 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Node
{
    public static JString aClass3_727;
    public static int currentTabId = 3;
    public static JString aClass3_729
	= JString.create(" from your ignore list first");
    public Node prevNode;
    public static JString aClass3_731;
    public static FileLoader fileLoader4;
    public long hash;
    public Node nextNode;
    public static JString aClass3_735;
    public static int mSectorX;
    public static int anInt737;
    public static FileLoader fileLoader3;
    public static AbstractFileLoader aClass9_739;
    public static JString aClass3_740;
    public static int anInt741 = 0;
    public static int fCameraPositionY;
    public static JString aClass3_743;
    
    public static void method407(boolean bool) {
	JString class3 = null;
	for (int i = 0; Class39_Sub5_Sub11.actionOffset > i; i++) {
	    if (Class33.actionNames[i]
		    .method80(22938, FrameBuffer.lrePrefixJstr)
		!= -1) {
		class3
		    = (Class33.actionNames[i].substring
		       (Class33.actionNames[i]
			    .method80(22938, FrameBuffer.lrePrefixJstr)));
		break;
	    }
	}
	if (class3 == null)
	    Class1.method49(118);
	else {
	    int i = Widget.anInt2063;
	    if (i < 0)
		i = 0;
	    int i_0_ = Class39_Sub5_Sub7.anInt1784;
	    int i_1_ = Huffman.anInt757;
	    int i_2_ = Class14.anInt227;
	    int i_3_ = 6116423;
	    if (i_2_ > 190)
		i_2_ = 190;
	    DrawingArea.drawQuad(i, i_0_, i_2_, i_1_, i_3_);
	    DrawingArea.drawQuad(i + 1, i_0_ + 1, i_2_ - 2, 16, 0);
	    DrawingArea.drawQuadOutline(i + 1, i_0_ + 18, i_2_ - 2, i_1_ - 19,
					 0);
	    Class32.aClass39_Sub5_Sub10_Sub1_587
		.method635(class3, i + 3, i_0_ + 14, i_3_, bool);
	    int i_4_ = Class33.mousePositionY;
	    int i_5_ = ISAAC.mousePositionX;
	    if (Class37.anInt653 == 0) {
		i_5_ -= 4;
		i_4_ -= 4;
	    }
	    if (Class37.anInt653 == 1) {
		i_4_ -= 205;
		i_5_ -= 553;
	    }
	    if (Class37.anInt653 == 2) {
		i_4_ -= 357;
		i_5_ -= 17;
	    }
	    for (int i_6_ = 0; i_6_ < Class39_Sub5_Sub11.actionOffset; i_6_++) {
		int i_7_
		    = (i_0_
		       - (-((Class39_Sub5_Sub11.actionOffset + (-i_6_ - 1)) * 15)
			  - 31));
		int i_8_ = 16777215;
		JString class3_9_ = Class33.actionNames[i_6_];
		if (class3_9_.startsWith(class3)) {
		    class3_9_ = class3_9_.substring(0, (class3_9_.getLength()
                                                       - class3.getLength()));
		    if (class3_9_.startsWith(Class53.spaceJstr))
			class3_9_
			    = class3_9_.substring(0, (class3_9_.getLength()
                                                     - Class53.spaceJstr
                                                           .getLength()));
		}
		if (i < i_5_ && i + i_2_ > i_5_ && i_7_ - 13 < i_4_
		    && i_7_ + 3 > i_4_)
		    i_8_ = 16776960;
		Class32.aClass39_Sub5_Sub10_Sub1_587
		    .method635(class3_9_, i + 3, i_7_, i_8_, true);
	    }
	}
    }
    
    public static void handleVarp(int id) {
	JCanvas.method41((byte) 127);
	int type = AudioHandler.getVarp(id).type;
	if (type != 0) {
	    int state = Client.stateValues[id];
	    if (type == 1) {
		if (state == 1) {
		    TriangleRasterizer.method650(0.9);
		    ((TextureLoaderImpl) TriangleRasterizer.textureLoader)
			.method1003(0.9, false);
		}
		if (state == 2) {
		    TriangleRasterizer.method650(0.8);
		    ((TextureLoaderImpl) TriangleRasterizer.textureLoader)
			.method1003(0.8, false);
		}
		if (state == 3) {
		    TriangleRasterizer.method650(0.7);
		    ((TextureLoaderImpl) TriangleRasterizer.textureLoader)
			.method1003(0.7, false);
		}
		if (state == 4) {
		    TriangleRasterizer.method650(0.6);
		    ((TextureLoaderImpl) TriangleRasterizer.textureLoader)
			.method1003(0.6, false);
		}
		Class66.method1100();
		ClientScript.aBoolean1690 = true;
	    }
	    if (type == 3) {
		int i_13_ = 0;
		if (state == 0)
		    i_13_ = 255;
		if (state == 1)
		    i_13_ = 192;
		if (state == 2)
		    i_13_ = 128;
		if (state == 3)
		    i_13_ = 64;
		if (state == 4)
		    i_13_ = 0;
		if (i_13_ != Mob.musicVolume) {
		    if (Mob.musicVolume != 0
			|| ArchiveWorker.anInt1205 == -1) {
			if (i_13_ == 0) {
			    Class41.method892((byte) 94);
			    JSocket.anInt313 = 0;
			} else
			    Timer.method935(i_13_, 64);
		    } else {
			Class41.method891(0, 0, false,
					  (Projectile
					   .fileLoader6),
					  i_13_, ArchiveWorker.anInt1205);
			JSocket.anInt313 = 0;
		    }
		    Mob.musicVolume = i_13_;
		}
	    }
	    if (type == 6)
		Class68.anInt1190 = state;
	    if (type == 5)
		PlayerApperance.anInt868 = state;
	    if (type == 10) {
		if (state == 0)
		    AbstractFileLoader.ambientEffectVolume = 127;
		if (state == 1)
		    AbstractFileLoader.ambientEffectVolume = 96;
		if (state == 2)
		    AbstractFileLoader.ambientEffectVolume = 64;
		if (state == 3)
		    AbstractFileLoader.ambientEffectVolume = 32;
		if (state == 4)
		    AbstractFileLoader.ambientEffectVolume = 0;
	    }
	    if (type == 9)
		Client.anInt1274 = state;
	    if (type == 8) {
		Class2.anInt53 = state;
		Class14.aBoolean245 = true;
	    }
	    if (type == 4) {
		if (state == 0)
		    Class39_Sub5_Sub9.effectVolume = 127;
		if (state == 1)
		    Class39_Sub5_Sub9.effectVolume = 96;
		if (state == 2)
		    Class39_Sub5_Sub9.effectVolume = 64;
		if (state == 3)
		    Class39_Sub5_Sub9.effectVolume = 32;
		if (state == 4)
		    Class39_Sub5_Sub9.effectVolume = 0;
	    }
	}
    }
    
    public static void method409(boolean bool) {
	aClass3_740 = null;
	aClass9_739 = null;
	fileLoader4 = null;
	aClass3_731 = null;
	aClass3_743 = null;
	fileLoader3 = null;
	aClass3_735 = null;
	aClass3_727 = null;
	aClass3_729 = null;
    }
    
    public static void method410(int i, boolean bool) {
	StillGraphic.method530(-92, i);
    }
    
    public static void method411(int i) {
	if (Class30.anInt534 == 0
	    && NpcDefinition.aClass39_Sub5_Sub17_1864 == null) {
	    int i_14_ = Timer.anInt887;
	    if (ISAAC.aBoolean1100 && Class39_Sub4.mouseClickPositionX >= 516
		&& Bzip2Entry.mouseClickPositionY >= 160 && Class39_Sub4.mouseClickPositionX <= 765
		&& Bzip2Entry.mouseClickPositionY <= 205)
		i_14_ = 0;
	    if (!Class39_Sub12.aBoolean1493) {
		if (i_14_ == 1 && Class39_Sub5_Sub11.actionOffset > 0) {
		    int types = (KeyListenerImpl.actionTypes [Class39_Sub5_Sub11.actionOffset - 1]);
		    if (types == 35 || types == 30 || types == 26
			|| types == 25 || types == 49 || types == 28
			|| types == 16 || types == 54 || types == 32
			|| types == 19 || types == 23 || types == 1004) {
			int i_16_ = (Class12.actionVars1[Class39_Sub5_Sub11.actionOffset - 1]);
			int widgetId = (Class43.actionVars2[Class39_Sub5_Sub11.actionOffset - 1]);
			Widget widget = Class37.getWidget(widgetId);
			if (widget.method753((byte) 114) || widget.replaceSwap()) {
			    Cache.aBoolean121 = false;
			    Widget.anInt2031 = 0;
			    ArchiveWorker.swapWidgetHash = widgetId;
			    OndemandRequest.itemClickPositionY = Bzip2Entry.mouseClickPositionY;
			    Class30.anInt534 = 2;
			    if (widgetId >> 16 == StillObject.viewOverlayId) {
                                Class30.anInt534 = 1;
                            }
			    if (Class39_Sub5_Sub14.chatboxOverlayId == widgetId >> 16) {
                                Class30.anInt534 = 3;
                            }
			    ArchiveRequest.swapSlotFrom = i_16_;
			    ClientScript.itemClickPositionX = Class39_Sub4.mouseClickPositionX;
			    return;
			}
		    }
		}
		if (i_14_ == 1
		    && (PlayerApperance.anInt868 == 1
			|| Class33.method327(Class39_Sub5_Sub11.actionOffset - 1,
					     (byte) -128))
		    && Class39_Sub5_Sub11.actionOffset > 2)
		    i_14_ = 2;
		if (i_14_ == 1 && Class39_Sub5_Sub11.actionOffset > 0)
		    ScriptState.handleMenuAction(Class39_Sub5_Sub11.actionOffset - 1, 1);
		if (i_14_ == 2 && Class39_Sub5_Sub11.actionOffset > 0)
		    Class39_Sub5_Sub9.method607(701);
	    } else {
		if (i_14_ != 1) {
		    int i_18_ = Class33.mousePositionY;
		    int i_19_ = ISAAC.mousePositionX;
		    if (Class37.anInt653 == 0) {
			i_18_ -= 4;
			i_19_ -= 4;
		    }
		    if (Class37.anInt653 == 1) {
			i_18_ -= 205;
			i_19_ -= 553;
		    }
		    if (Class37.anInt653 == 2) {
			i_19_ -= 17;
			i_18_ -= 357;
		    }
		    if (Widget.anInt2063 - 10 > i_19_
			|| (Class14.anInt227 + Widget.anInt2063
			    + 10) < i_19_
			|| i_18_ < Class39_Sub5_Sub7.anInt1784 - 10
			|| (Huffman.anInt757 + Class39_Sub5_Sub7.anInt1784 + 10
			    < i_18_)) {
			Class39_Sub12.aBoolean1493 = false;
			if (Class37.anInt653 == 1)
			    Class39_Sub14.updateTab = true;
			if (Class37.anInt653 == 2)
			    Class14.aBoolean245 = true;
		    }
		}
		if (i_14_ == 1) {
		    int i_20_ = Class39_Sub5_Sub7.anInt1784;
		    int i_21_ = Widget.anInt2063;
		    int i_22_ = Class14.anInt227;
		    int positionX = Class39_Sub4.mouseClickPositionX;
		    int positionY = Bzip2Entry.mouseClickPositionY;
		    int i_25_ = -1;
		    if (Class37.anInt653 == 0) {
			positionY -= 4;
			positionX -= 4;
		    }
		    if (Class37.anInt653 == 1) {
			positionX -= 553;
			positionY -= 205;
		    }
		    if (Class37.anInt653 == 2) {
			positionY -= 357;
			positionX -= 17;
		    }
		    for (int i_26_ = 0; Class39_Sub5_Sub11.actionOffset > i_26_;
			 i_26_++) {
			int i_27_ = (i_20_ + 31
				     + (-i_26_ + (Class39_Sub5_Sub11.actionOffset
						  - 1)) * 15);
			if (positionX > i_21_ && positionX < i_22_ + i_21_
			    && i_27_ - 13 < positionY && i_27_ + 3 > positionY)
			    i_25_ = i_26_;
		    }
		    if (i_25_ != -1)
			ScriptState.handleMenuAction(i_25_, 1);
		    if (Class37.anInt653 == 2)
			Class14.aBoolean245 = true;
		    Class39_Sub12.aBoolean1493 = false;
		    if (Class37.anInt653 == 1)
			Class39_Sub14.updateTab = true;
		}
	    }
	    int i_28_ = 29 % ((36 - i) / 45);
	}
    }
    
    public static int method412(int i, int i_29_, byte i_30_) {
	if (i_29_ == -1)
	    return 12345678;
	i = i * (i_29_ & 0x7f) / 128;
	if (i >= 2) {
	    if (i > 126)
		i = 126;
	} else
	    i = 2;
	return i + (i_29_ & 0xff80);
    }
    
    public void unlinkDeque() {
	if (prevNode != null) {
	    prevNode.nextNode = nextNode;
	    nextNode.prevNode = prevNode;
	    prevNode = null;
	    nextNode = null;
	}
    }
    
    public boolean isLinked() {
	if (prevNode == null)
	    return false;
	return true;
    }
    
    static {
	anInt737 = (int) (Math.random() * 33.0) - 16;
	aClass3_727 = aClass3_729;
	aClass3_740 = JString.create("Titelbild geladen)3");
	aClass3_735
	    = JString.create("nicht hergestellt werden)3");
	aClass3_731 = JString.create("welle2:");
	aClass3_743 = JString.create(":0");
    }
}
