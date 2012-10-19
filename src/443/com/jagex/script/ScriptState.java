package com.jagex.script;

import com.jagex.config.Widget;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.od.OndemandRequest;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.events.JMouseListener;
import com.jagex.awt.events.JKeyListener;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import unpackaged.Class1;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import unpackaged.Class39_Sub1;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub5;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import com.jagex.utils.MouseRecorder;
import unpackaged.TextureLoaderImpl;

/* Class24 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class ScriptState {

    public static Class39_Sub1 aClass39_Sub1_439;
    public int[] intVariables;
    public static JString aClass3_441;
    public static JString aClass3_442;
    public static JString aClass3_443;
    public static JString aClass3_444;
    public static JString aClass3_445;
    public static JString aClass3_446;
    public static JString aClass3_447 = JString.create(" has logged out)3");
    public static int anInt448;
    public static int[] arraySizes;
    public JString[] strVariables;
    public ClientScript clientScript;
    public static JString aClass3_452;
    public int offset = -1;
    public static int anInt454;
    public static int[][] anIntArrayArray455;
    public static JString aClass3_456;

    public static void method275(int i) {
        ArchiveWorker.aClass46_1206.method938((byte) -111);
        for (int i_0_ = 0; i_0_ < 32; i_0_++) {
            ClassCheckRequest.aLongArray1374[i_0_] = 0L;
        }
        for (int i_1_ = 0; i_1_ < 32; i_1_++) {
            Class67.aLongArray1172[i_1_] = 0L;
        }
        Class2.anInt50 = 0;
    }

    public static void setObjectFileLoaders(boolean bool, AbstractFileLoader class9, AbstractFileLoader class9_2_,
            int i) {
        Deque.objectFileLoader = class9_2_;
        JMouseListener.aBoolean785 = bool;
        Npc.modelFileLoader = class9;
    }

    public static void method277(boolean bool) {
        AbstractMidiHandler.spriteCache.clear();
        Class2.widgetModelCache.clear();
        Deque.fontCache.clear();
    }

    public static void handleMenuAction(int i, int i_3_) {
            int var1 = Class12.actionVars1[i];
            int var2 = Class43.actionVars2[i];
            int type = JKeyListener.actionTypes[i];
            if (type >= 2000) {
                type -= 2000;
            }
            int var0 = NameTable.actionVars0[i];
            if (Mob.keyboardInputType != 0 && type != 1002) {
                Class14.aBoolean245 = true;
                Mob.keyboardInputType = 0;
            }
            if (type == 32) { //
                FrameBuffer.outgoingBuffer.putFrame(182);
                FrameBuffer.outgoingBuffer.putWordLe(var0);
                FrameBuffer.outgoingBuffer.putWord(var1);
                FrameBuffer.outgoingBuffer.putDwordLe(var2);
                Class39_Sub5_Sub5.anInt1739 = var1;
                Class65.anInt1137 = var2;
                Class25.anInt459 = 2;
                GroundItem.anInt2242 = 0;
                if (var2 >> 16 == StillObject.viewOverlayId) {
                    Class25.anInt459 = 1;
                }
                if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                    Class25.anInt459 = 3;
                }
            }
            if (type == 1005) { //
                Npc.method526(var0, var1, false, var2);
                FrameBuffer.outgoingBuffer.putFrame(120);
                FrameBuffer.outgoingBuffer.putWord(JKeyListener.anInt618 + var2);
                FrameBuffer.outgoingBuffer.putWord(Class65.anInt1145 + var1);
                FrameBuffer.outgoingBuffer.putWord((var0 & 0x1ffff835) >> 14);
            }
            if (type == 12 && Npc.method526(var0, var1, false, var2)) { //widget on object
                FrameBuffer.outgoingBuffer.putFrame(78);
                FrameBuffer.outgoingBuffer.putDwordB(Class41.useWithWidgetId);
                FrameBuffer.outgoingBuffer.putWord(var1 + Class65.anInt1145);
                FrameBuffer.outgoingBuffer.putWord(MouseRecorder.useWithAmountChildren);
                FrameBuffer.outgoingBuffer.putWordLe(JKeyListener.anInt618 + var2);
                FrameBuffer.outgoingBuffer.putWord128(var0 >> 14 & 0x7fff);
            }
            if (type == 8 && Class39_Sub10.anInt1420 == -1) { //Continue
                Bzip2Entry.method1035(var1, var2);
                JString.anInt1231 = var1;
                Class39_Sub10.anInt1420 = var2;
            }
            if (type == 40) {
                boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0,
                        false, 0,
                        (Cache.localPlayer.queueX[0]),
                        (Cache.localPlayer.queueY[0]),
                        var1);
                if (!bool) {
                    bool = Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false,
                            0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                }
                Class4.crossMode = 2;
                Class26.crossFrameNum = 0;
                Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                FrameBuffer.outgoingBuffer.putFrame(149);
                FrameBuffer.outgoingBuffer.putWordLe128(Class65.anInt1145 + var1);
                FrameBuffer.outgoingBuffer.putWordLe128(JKeyListener.anInt618 + var2);
                FrameBuffer.outgoingBuffer.putWord(var0);
            }
            if (type == 31 || type == 21 || type == 2 || type == 50) {
                JString class3 = Class33.actionNames[i];
                int i_8_ = class3.method80(22938, Entity.whiPrefixJstr);
                if (i_8_ != -1) {
                    long l = class3.substring(i_8_ + 5).method69().encodeBase37();
                    if (type == 31) {
                        Class68.addFriend(l);
                    }
                    if (type == 21) {
                        Class65.addIgnore(l);
                    }
                    if (type == 2) {
                        Class20.removeFriend(l, (byte) -123);
                    }
                    if (type == 50) {
                        HashTable.removeIgnore(l);
                    }
                }
            }
            if (type == 38) {
                boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0, false, 0,
                        (Cache.localPlayer.queueX[0]),
                        (Cache.localPlayer.queueY[0]),
                        var1);
                if (!bool) {
                    bool = Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false,
                            0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                }
                Class4.crossMode = 2;
                Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                Class26.crossFrameNum = 0;
                FrameBuffer.outgoingBuffer.putFrame(252);
                FrameBuffer.outgoingBuffer.putWordLe128(var0);
                FrameBuffer.outgoingBuffer.putWordLe128(Class65.anInt1145 + var1);
                FrameBuffer.outgoingBuffer.putWordLe128(JKeyListener.anInt618 + var2);
            }
            if (type == 28) {
                FrameBuffer.outgoingBuffer.putFrame(0);
                FrameBuffer.outgoingBuffer.putWordLe(var1);
                FrameBuffer.outgoingBuffer.putWord(var0);
                FrameBuffer.outgoingBuffer.putDwordLe(var2);
                GroundItem.anInt2242 = 0;
                Class65.anInt1137 = var2;
                Class39_Sub5_Sub5.anInt1739 = var1;
                Class25.anInt459 = 2;
                if (StillObject.viewOverlayId == var2 >> 16) {
                    Class25.anInt459 = 1;
                }
                if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                    Class25.anInt459 = 3;
                }
            }
            if (type == 35) {
                FrameBuffer.outgoingBuffer.putFrame(144);
                FrameBuffer.outgoingBuffer.putWordLe128(var1);
                FrameBuffer.outgoingBuffer.putDword(var2);
                FrameBuffer.outgoingBuffer.putWordLe(var0);
                Class39_Sub5_Sub5.anInt1739 = var1;
                GroundItem.anInt2242 = 0;
                Class65.anInt1137 = var2;
                Class25.anInt459 = 2;
                if (StillObject.viewOverlayId == var2 >> 16) {
                    Class25.anInt459 = 1;
                }
                if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                    Class25.anInt459 = 3;
                }
            }
            if (type == 14) {
                Widget widget = Class62_Sub2.getWidgetChild(var2, var1);
                if (widget != null) {
                    Mob.method509((byte) 39);
                    Class25.method281(widget.method751(), var1, var2, true);
                    Class39_Sub14.updateTab = true;
                    Class13.anInt208 = 0;
                    TextConstants.aClass3_1273 = widget.method762(HashTable.aBoolean361);
                    if (TextConstants.aClass3_1273 == null) {
                        TextConstants.aClass3_1273 = Class41.aClass3_774;
                    }
                    if (widget.isNewFormat) {
                        Class14.aClass3_216 = (Class39_Sub5_Sub11.join((new JString[]{widget.aClass3_2065,
                                    Entity.whiPrefixJstr})));
                    } else {
                        Class14.aClass3_216 = (Class39_Sub5_Sub11.join((new JString[]{Class41.greenPrefixJstr,
                                    widget.aClass3_2066,
                                    Entity.whiPrefixJstr})));
                    }
                    if (Class41.anInt776 == 16 && !widget.isNewFormat) {
                        Node.currentTabId = 3;
                        ISAAC.aBoolean1089 = true;
                        Class39_Sub14.updateTab = true;
                    }
                }
            } else {
                if (type == 42) {
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        Class4.crossMode = 2;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class26.crossFrameNum = 0;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        FrameBuffer.outgoingBuffer.putFrame(154);
                        FrameBuffer.outgoingBuffer.putWord(var0);
                    }
                }
                if (type == 47) { //item on npc
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class26.crossFrameNum = 0;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(146);
                        FrameBuffer.outgoingBuffer.putDwordA(Class39_Sub10.useWithItemWidgetId);
                        FrameBuffer.outgoingBuffer.putWord(Class63.useWithItemId);
                        FrameBuffer.outgoingBuffer.putWord(Class23.useWithItemSlot);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    }
                }
                if (type == 53) {
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        Class26.crossFrameNum = 0;
                        Class4.crossMode = 2;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        FrameBuffer.outgoingBuffer.putFrame(222);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    }
                }
                if (type == 4) { //item on ground item
                    boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0,
                            false, 0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                    if (!bool) {
                        bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                var1));
                    }
                    Class4.crossMode = 2;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    Class26.crossFrameNum = 0;
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    FrameBuffer.outgoingBuffer.putFrame(114);
                    FrameBuffer.outgoingBuffer.putWordLe(Class63.useWithItemId);
                    FrameBuffer.outgoingBuffer.putWord128(var2 + JKeyListener.anInt618);
                    FrameBuffer.outgoingBuffer.putDword(Class39_Sub10.useWithItemWidgetId);
                    FrameBuffer.outgoingBuffer.putWord128(var1 + Class65.anInt1145);
                    FrameBuffer.outgoingBuffer.putWordLe(var0);
                    FrameBuffer.outgoingBuffer.putWordLe128(Class23.useWithItemSlot);
                }
                if (type == 49) {
                    FrameBuffer.outgoingBuffer.putFrame(171);
                    FrameBuffer.outgoingBuffer.putWord128(var1);
                    FrameBuffer.outgoingBuffer.putDword(var2);
                    FrameBuffer.outgoingBuffer.putWordLe(var0);
                    Class65.anInt1137 = var2;
                    Class25.anInt459 = 2;
                    GroundItem.anInt2242 = 0;
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    if (StillObject.viewOverlayId == var2 >> 16) {
                        Class25.anInt459 = 1;
                    }
                    if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                        Class25.anInt459 = 3;
                    }
                }
                if (type == 26) {
                    FrameBuffer.outgoingBuffer.putFrame(188);
                    FrameBuffer.outgoingBuffer.putWordLe128(var1);
                    FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    FrameBuffer.outgoingBuffer.putDwordA(var2);
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    Class25.anInt459 = 2;
                    if (StillObject.viewOverlayId == var2 >> 16) {
                        Class25.anInt459 = 1;
                    }
                    if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                        Class25.anInt459 = 3;
                    }
                    Class65.anInt1137 = var2;
                    GroundItem.anInt2242 = 0;
                }
                if (type == 11) {
                    boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0,
                            false, 0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                    if (!bool) {
                        bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                var1));
                    }
                    Class26.crossFrameNum = 0;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    Class4.crossMode = 2;
                    FrameBuffer.outgoingBuffer.putFrame(38);
                    FrameBuffer.outgoingBuffer.putWordLe(var0);
                    FrameBuffer.outgoingBuffer.putWord128(JKeyListener.anInt618 + var2);
                    FrameBuffer.outgoingBuffer.putWord(Class65.anInt1145 + var1);
                }
                if (type == 43) {
                    Npc.method526(var0, var1, false,
                            var2);
                    FrameBuffer.outgoingBuffer.putFrame(69);
                    FrameBuffer.outgoingBuffer.putWordLe((var0 & 0x1fffcb21) >> 14);
                    FrameBuffer.outgoingBuffer.putWord(var2 + JKeyListener.anInt618);
                    FrameBuffer.outgoingBuffer.putWord(Class65.anInt1145 + var1);
                }
                if (type == 48) { //widget on npc
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class26.crossFrameNum = 0;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(200);
                        FrameBuffer.outgoingBuffer.putWordLe(MouseRecorder.useWithAmountChildren);
                        FrameBuffer.outgoingBuffer.putDwordLe(Class41.useWithWidgetId);
                        FrameBuffer.outgoingBuffer.putWord(var0);
                    }
                }
                if (type == 58) { //item on player
                    Player player = Class14.players[var0];
                    if (player != null) {
                        Class26.sendWalkingRoute(0,
                                player.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                player.queueX[0]);
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class26.crossFrameNum = 0;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(104);
                        FrameBuffer.outgoingBuffer.putDwordB(Class39_Sub10.useWithItemWidgetId);
                        FrameBuffer.outgoingBuffer.putWordLe128(Class23.useWithItemSlot);
                        FrameBuffer.outgoingBuffer.putWordLe(var0);
                        FrameBuffer.outgoingBuffer.putWordLe128(Class63.useWithItemId);
                    }
                }
                if (type == 45
                        && Npc.method526(var0, var1, false,
                        var2)) { //item on object
                    FrameBuffer.outgoingBuffer.putFrame(195);
                    FrameBuffer.outgoingBuffer.putWordLe128(var2 + JKeyListener.anInt618);
                    FrameBuffer.outgoingBuffer.putWordLe((var0 & 0x1ffffabb) >> 14);
                    FrameBuffer.outgoingBuffer.putWord128(Class63.useWithItemId);
                    FrameBuffer.outgoingBuffer.putWordLe(Class23.useWithItemSlot);
                    FrameBuffer.outgoingBuffer.putWordLe128(var1 + Class65.anInt1145);
                    FrameBuffer.outgoingBuffer.putDwordLe(Class39_Sub10.useWithItemWidgetId);
                }
                if (type == 1004) {
                    Widget class39_sub5_sub17 = Class37.getWidget(var2);
                    if (class39_sub5_sub17 != null
                            && class39_sub5_sub17.itemAmounts[var1] >= 100000) {
                        JMouseListener.printMessage(0,Class66.blankString,
                                (Class39_Sub5_Sub11.join((new JString[]{AbstractImage.toJstr((class39_sub5_sub17.itemAmounts[var1])),
                                    Class30.aClass3_543,
                                    (Class26.getItemDefinition(var0).name)}))));
                    } else {
                        OndemandRequest.anInt1724++;
                        FrameBuffer.outgoingBuffer.putFrame(219);
                        FrameBuffer.outgoingBuffer.putWord128(var0);
                    }
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    Class25.anInt459 = 2;
                    if (StillObject.viewOverlayId == var2 >> 16) {
                        Class25.anInt459 = 1;
                    }
                    if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                        Class25.anInt459 = 3;
                    }
                    Class65.anInt1137 = var2;
                    GroundItem.anInt2242 = 0;
                }
                if (type == 25) {
                    FrameBuffer.outgoingBuffer.putFrame(221);
                    FrameBuffer.outgoingBuffer.putDwordB(var2);
                    FrameBuffer.outgoingBuffer.putWordLe128(var1);
                    FrameBuffer.outgoingBuffer.putWord(var0);
                    Class65.anInt1137 = var2;
                    Class25.anInt459 = 2;
                    GroundItem.anInt2242 = 0;
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    if (var2 >> 16 == StillObject.viewOverlayId) {
                        Class25.anInt459 = 1;
                    }
                    if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                        Class25.anInt459 = 3;
                    }
                }
                if (type == 6) {
                    Npc.method526(var0, var1, false,
                            var2);
                    FrameBuffer.outgoingBuffer.putFrame(202);
                    FrameBuffer.outgoingBuffer.putWord(var0 >> 14 & 0x7fff);
                    FrameBuffer.outgoingBuffer.putWord128(Class65.anInt1145 + var1);
                    FrameBuffer.outgoingBuffer.putWordLe128(JKeyListener.anInt618 + var2);
                }
                if (type == 19) {
                    FrameBuffer.outgoingBuffer.putFrame(178);
                    FrameBuffer.outgoingBuffer.putWordLe128(var1);
                    FrameBuffer.outgoingBuffer.putWord128(var0);
                    FrameBuffer.outgoingBuffer.putDwordA(var2);
                    Class25.anInt459 = 2;
                    if (var2 >> 16 == StillObject.viewOverlayId) {
                        Class25.anInt459 = 1;
                    }
                    GroundItem.anInt2242 = 0;
                    if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                        Class25.anInt459 = 3;
                    }
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    Class65.anInt1137 = var2;
                }
                if (type == 33) {
                    if (!Class39_Sub12.aBoolean1493) {
                        Class44.world.method355((Class39_Sub4.mouseClickPositionX
                                - 4),
                                Bzip2Entry.mouseClickPositionY - 4);
                    } else {
                        Class44.world.method355(var1 - 4, var2 - 4);
                    }
                }
                if (type == 24) {
                    Class62_Sub2.method1084((byte) -35, ISAAC.chatboxWidgetId);
                    ISAAC.chatboxWidgetId = -1;
                    Class14.aBoolean245 = true;
                }
                if (type == 34) {
                    boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0, false,
                            0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                    if (!bool) {
                        bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                var1));
                    }
                    Class4.crossMode = 2;
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    Class26.crossFrameNum = 0;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    FrameBuffer.outgoingBuffer.putFrame(85);
                    FrameBuffer.outgoingBuffer.putWord128(var2 + JKeyListener.anInt618);
                    FrameBuffer.outgoingBuffer.putWordLe128(Class65.anInt1145 + var1);
                    FrameBuffer.outgoingBuffer.putWordLe128(var0);
                }
                if (type == 51) {
                    Class34.method333(var2, var1, var0);
                }
                if (type == 1) {
                    Player player = Class14.players[var0];
                    if (player != null) {
                        Class26.sendWalkingRoute(0,
                                player.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                player.queueX[0]);
                        Class26.crossFrameNum = 0;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(206);
                        FrameBuffer.outgoingBuffer.putWord(var0);
                    }
                }
                if (type == 10) {
                    JString class3 = Class33.actionNames[i];
                    int i_9_ = class3.method80(22938,
                            Entity.whiPrefixJstr);
                    if (i_9_ != -1) {
                        long l = class3.substring(i_9_ + 5).method69().encodeBase37();
                        int i_10_ = -1;
                        for (int i_11_ = 0; Class4.anInt62 > i_11_; i_11_++) {
                            if (l == JApplet.aLongArray2[i_11_]) {
                                i_10_ = i_11_;
                                break;
                            }
                        }
                        if (i_10_ != -1 && (Player.anIntArray2533[i_10_]) > 0) {
                            Class14.aBoolean245 = true;
                            Class39_Sub12.aBoolean1489 = true;
                            Class15.socialListMessageType = 3;
                            Mob.keyboardInputType = 0;
                            Class66.socialListMessage = Class66.blankString;
                            Huffman.aLong752 = JApplet.aLongArray2[i_10_];
                            Class66.aClass3_1150 = (Class39_Sub5_Sub11.join(new JString[]{Class41.aClass3_781,
                                        (Projectile.aClass3Array2188[i_10_])}));
                        }
                    }
                }
                if (i_3_ != 1) {
                    handleMenuAction(87, -70);
                }
                if (type == 36) {
                    FrameBuffer.outgoingBuffer.putFrame(54);
                    FrameBuffer.outgoingBuffer.putDword(var2);
                    Class39_Sub5_Sub12.anInt1848++;
                    Widget widget = Class37.getWidget(var2);
                    if (widget.scriptOpcodes != null
                            && widget.scriptOpcodes[0][0] == 5) {
                        int opcode = widget.scriptOpcodes[0][1];
                        Client.stateValues[opcode] = 1 - Client.stateValues[opcode];
                        Node.handleVarp(opcode);
                        Class39_Sub14.updateTab = true;
                    }
                }
                if (type == 1001) {
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    Class26.crossFrameNum = 0;
                    Class4.crossMode = 2;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        NpcDefinition definition = (npc.definition);
                        if (definition.anIntArray1878 != null) {
                            definition = definition.method721(5585);
                        }
                        if (definition != null) {
                            FrameBuffer.outgoingBuffer.putFrame(158);
                            FrameBuffer.outgoingBuffer.putWord(definition.id);
                        }
                    }
                }
                if (type == 15 || type == 37) {
                    JString class3 = Class33.actionNames[i];
                    int i_13_ = class3.method80(22938,
                            Entity.whiPrefixJstr);
                    if (i_13_ != -1) {
                        class3 = class3.substring(i_13_ + 5).method69();
                        JString class3_14_ = class3.method81(-32769).formatUsername();
                        boolean bool = false;
                        for (int i_15_ = 0; i_15_ < TraversalMap.anInt515;
                                i_15_++) {
                            Player player = (Class14.players[Class1.anIntArray40[i_15_]]);
                            if (player != null
                                    && (player.aClass3_2521
                                    != null)
                                    && player.aClass3_2521.equalTo(class3_14_)) {
                                bool = true;
                                Class26.sendWalkingRoute(0,
                                        (player.queueY[0]),
                                        0, 2, 1, 1, false, 0,
                                        (Cache.localPlayer.queueX[0]),
                                        (Cache.localPlayer.queueY[0]),
                                        (player.queueX[0]));
                                if (type == 15) {
                                    FrameBuffer.outgoingBuffer.putFrame(101);
                                    VarpDefinition.anInt1976++;
                                    FrameBuffer.outgoingBuffer.putWordLe128(Class1.anIntArray40[i_15_]);
                                }
                                if (type == 37) {
                                    FrameBuffer.outgoingBuffer.putFrame(11);
                                    FrameBuffer.outgoingBuffer.putWordLe128(Class1.anIntArray40[i_15_]);
                                    Class39_Sub5_Sub4_Sub2.anInt2220++;
                                }
                                break;
                            }
                        }
                        if (!bool) {
                            JMouseListener.printMessage(0,Class66.blankString,
                                    (Class39_Sub5_Sub11.join((new JString[]{Buffer.aClass3_1365,
                                        class3_14_}))));
                        }
                    }
                }
                if (type == 27) { //widget on ground item
                    boolean bool = Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0,
                            false, 0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            var1);
                    if (!bool) {
                        bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                var1));
                    }
                    Class26.crossFrameNum = 0;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    Class4.crossMode = 2;
                    FrameBuffer.outgoingBuffer.putFrame(64);
                    FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    FrameBuffer.outgoingBuffer.putDwordB(Class41.useWithWidgetId);
                    FrameBuffer.outgoingBuffer.putWord(JKeyListener.anInt618 + var2);
                    FrameBuffer.outgoingBuffer.putWordLe128(Class65.anInt1145 + var1);
                    FrameBuffer.outgoingBuffer.putWordLe128(MouseRecorder.useWithAmountChildren);
                }
                if (type == 16) {
                    FrameBuffer.outgoingBuffer.putFrame(29);
                    FrameBuffer.outgoingBuffer.putDwordA(var2);
                    FrameBuffer.outgoingBuffer.putWord(var0);
                    FrameBuffer.outgoingBuffer.putWord128(var1);
                    Class25.anInt459 = 2;
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    GroundItem.anInt2242 = 0;
                    Class65.anInt1137 = var2;
                    if (var2 >> 16 == StillObject.viewOverlayId) {
                        Class25.anInt459 = 1;
                    }
                    if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                        Class25.anInt459 = 3;
                    }
                }
                if (type == 7) { //widget on player
                    Player player = Class14.players[var0];
                    if (player != null) {
                        Class26.sendWalkingRoute(0,
                                player.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                player.queueX[0]);
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class4.crossMode = 2;
                        Class26.crossFrameNum = 0;
                        FrameBuffer.outgoingBuffer.putFrame(236);
                        FrameBuffer.outgoingBuffer.putWord128(var0);
                        FrameBuffer.outgoingBuffer.putWord128(MouseRecorder.useWithAmountChildren);
                        FrameBuffer.outgoingBuffer.putDwordLe(Class41.useWithWidgetId);
                    }
                }
                if (type == 18) { //item on item
                    FrameBuffer.outgoingBuffer.putFrame(147);
                    FrameBuffer.outgoingBuffer.putWord128(Class23.useWithItemSlot);
                    FrameBuffer.outgoingBuffer.putWordLe(Class63.useWithItemId);
                    FrameBuffer.outgoingBuffer.putWordLe(var0);
                    FrameBuffer.outgoingBuffer.putDwordLe(var2);
                    FrameBuffer.outgoingBuffer.putDwordB(Class39_Sub10.useWithItemWidgetId);
                    FrameBuffer.outgoingBuffer.putWord(var1);
                    GroundItem.anInt2242 = 0;
                    Class65.anInt1137 = var2;
                    Class25.anInt459 = 2;
                    if (var2 >> 16 == StillObject.viewOverlayId) {
                        Class25.anInt459 = 1;
                    }
                    if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                        Class25.anInt459 = 3;
                    }
                    Class39_Sub5_Sub5.anInt1739 = var1;
                }
                if (type == 55) {
                    Npc.method526(var0, var1, false,
                            var2);
                    FrameBuffer.outgoingBuffer.putFrame(47);
                    FrameBuffer.outgoingBuffer.putWord128(JKeyListener.anInt618 + var2);
                    FrameBuffer.outgoingBuffer.putWordLe128(var0 >> 14 & 0x7fff);
                    FrameBuffer.outgoingBuffer.putWord128(Class65.anInt1145 + var1);
                }
                if (type == 46) {
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        Class26.crossFrameNum = 0;
                        Class4.crossMode = 2;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        FrameBuffer.outgoingBuffer.putFrame(87);
                        FrameBuffer.outgoingBuffer.putWord(var0);
                    }
                }
                if (type == 13) {
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class26.crossFrameNum = 0;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(89);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    }
                }
                if (type == 56) {
                    Player player = Class14.players[var0];
                    if (player != null) {
                        Class26.sendWalkingRoute(0,
                                player.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                player.queueX[0]);
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class26.crossFrameNum = 0;
                        VarpDefinition.anInt1976++;
                        Class4.crossMode = 2;
                        FrameBuffer.outgoingBuffer.putFrame(101);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    }
                }
                if (type == 20) {
                    boolean bool = true;
                    Widget widget = Class37.getWidget(var2);
                    if (widget.anInt2078 > 0) {
                        bool = GouraudVertex.method951(widget);
                    }
                    if (bool) {
                        FrameBuffer.outgoingBuffer.putFrame(54);
                        FrameBuffer.outgoingBuffer.putDword(var2);
                        Class39_Sub5_Sub12.anInt1848++;
                    }
                }
                if (type == 57) {
                    Npc.method526(var0, var1, false,
                            var2);
                    FrameBuffer.outgoingBuffer.putFrame(245);
                    FrameBuffer.outgoingBuffer.putWord(var1 + Class65.anInt1145);
                    FrameBuffer.outgoingBuffer.putWord(var0 >> 14 & 0x7fff);
                    FrameBuffer.outgoingBuffer.putWord128(JKeyListener.anInt618 + var2);
                }
                if (type == 41) {
                    Class39_Sub5_Sub12.anInt1848++;
                    FrameBuffer.outgoingBuffer.putFrame(54);
                    FrameBuffer.outgoingBuffer.putDword(var2);
                    Widget widget = Class37.getWidget(var2);
                    if (widget.scriptOpcodes != null && widget.scriptOpcodes[0][0] == 5) {
                        int opcode = widget.scriptOpcodes[0][1];
                        if (Client.stateValues[opcode] != widget.conditionValues[0]) {
                            Client.stateValues[opcode] = widget.conditionValues[0];
                            Node.handleVarp(opcode);
                            Class39_Sub14.updateTab = true;
                        }
                    }
                }
                if (type == 1003) {
                    OndemandRequest.anInt1724++;
                    AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                    Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                    Class4.crossMode = 2;
                    Class26.crossFrameNum = 0;
                    FrameBuffer.outgoingBuffer.putFrame(219);
                    FrameBuffer.outgoingBuffer.putWord128(var0);
                }
                if (type == 17) {
                    Npc npc = (GroundItem.npcs[var0]);
                    if (npc != null) {
                        Class26.sendWalkingRoute(0,
                                npc.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                npc.queueX[0]);
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class4.crossMode = 2;
                        Class26.crossFrameNum = 0;
                        FrameBuffer.outgoingBuffer.putFrame(224);
                        FrameBuffer.outgoingBuffer.putWord(var0);
                    }
                }
                if (type == 22) {
                    Player player = Class14.players[var0];
                    if (player != null) {
                        Class26.sendWalkingRoute(0,
                                player.queueY[0], 0,
                                2, 1, 1, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                player.queueX[0]);
                        Class4.crossMode = 2;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        Class26.crossFrameNum = 0;
                        FrameBuffer.outgoingBuffer.putFrame(169);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                    }
                }
                if (type == 30) {
                    FrameBuffer.outgoingBuffer.putFrame(113);
                    FrameBuffer.outgoingBuffer.putDwordB(var2);
                    FrameBuffer.outgoingBuffer.putWordLe(var0);
                    FrameBuffer.outgoingBuffer.putWordLe128(var1);
                    Class65.anInt1137 = var2;
                    Class39_Sub5_Sub5.anInt1739 = var1;
                    GroundItem.anInt2242 = 0;
                    Class25.anInt459 = 2;
                    if (var2 >> 16 == StillObject.viewOverlayId) {
                        Class25.anInt459 = 1;
                    }
                    if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                        Class25.anInt459 = 3;
                    }
                }
                if (type == 23) {
                    Mob.method509((byte) 39);
                    Class13.anInt208 = 1;
                    Class63.useWithItemId = var0;
                    Class23.useWithItemSlot = var1;
                    Class39_Sub14.updateTab = true;
                    Class39_Sub10.useWithItemWidgetId = var2;
                    Class39_Sub10.useWithItemJstr = (Class39_Sub5_Sub11.join((new JString[]{FrameBuffer.lrePrefixJstr,
                                Class26.getItemDefinition(var0).name,
                                Entity.whiPrefixJstr})));
                    if (Class39_Sub10.useWithItemJstr == null) {
                        Class39_Sub10.useWithItemJstr = Wall.nullJstr;
                    }
                } else {
                    if (type == 3) {
                        boolean bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 0, 0, false, 0,
                                (Cache.localPlayer.queueX[0]),
                                (Cache.localPlayer.queueY[0]),
                                var1));
                        if (!bool) {
                            bool = (Class26.sendWalkingRoute(0, var2, 0, 2, 1, 1, false, 0,
                                    (Cache.localPlayer.queueX[0]),
                                    (Cache.localPlayer.queueY[0]),
                                    var1));
                        }
                        Class26.crossFrameNum = 0;
                        Class4.crossMode = 2;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        FrameBuffer.outgoingBuffer.putFrame(136);
                        FrameBuffer.outgoingBuffer.putWord128(var1 + Class65.anInt1145);
                        FrameBuffer.outgoingBuffer.putWordLe(var0);
                        FrameBuffer.outgoingBuffer.putWord(var2 + JKeyListener.anInt618);
                    }
                    if (type == 29) {
                        TextureLoaderImpl.closeOverlays();
                    }
                    if (type == 39) { //widget on widget
                        FrameBuffer.outgoingBuffer.putFrame(145);
                        FrameBuffer.outgoingBuffer.putDword(Class41.useWithWidgetId);
                        FrameBuffer.outgoingBuffer.putDword(var2);
                        FrameBuffer.outgoingBuffer.putWord128(MouseRecorder.useWithAmountChildren);
                        FrameBuffer.outgoingBuffer.putWordLe128(var1);
                    }
                    if (type == 9) {
                        JString class3 = Class33.actionNames[i];
                        int i_17_ = class3.method80(22938,
                                Entity.whiPrefixJstr);
                        if (i_17_ != -1) {
                            if (StillObject.viewOverlayId == -1) {
                                TextureLoaderImpl.closeOverlays();
                                if (GouraudVertex.anInt907 != -1) {
                                    Class66.reportUsername = class3.substring(i_17_ + 5).method69();
                                    Class39_Sub12.aBoolean1487 = false;
                                    Class26.anInt473 = StillObject.viewOverlayId = GouraudVertex.anInt907;
                                }
                            } else {
                                JMouseListener.printMessage(0,Class66.blankString,
                                        MouseRecorder.aClass3_572);
                            }
                        }
                    }
                    if (type == 54) {
                        FrameBuffer.outgoingBuffer.putFrame(48);
                        FrameBuffer.outgoingBuffer.putWord128(var1);
                        FrameBuffer.outgoingBuffer.putDwordA(var2);
                        FrameBuffer.outgoingBuffer.putWordLe(var0);
                        Class25.anInt459 = 2;
                        Class65.anInt1137 = var2;
                        Class39_Sub5_Sub5.anInt1739 = var1;
                        if (StillObject.viewOverlayId == var2 >> 16) {
                            Class25.anInt459 = 1;
                        }
                        if (Class39_Sub5_Sub14.chatboxOverlayId == var2 >> 16) {
                            Class25.anInt459 = 3;
                        }
                        GroundItem.anInt2242 = 0;
                    }
                    if (type == 1006) {
                        Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                        AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                        Class4.crossMode = 2;
                        Class26.crossFrameNum = 0;
                        FrameBuffer.outgoingBuffer.putFrame(36);
                        FrameBuffer.outgoingBuffer.putWordLe(var0 >> 14 & 0x7fff);
                    }
                    if (type == 5) { //widget on item
                        FrameBuffer.outgoingBuffer.putFrame(243);
                        FrameBuffer.outgoingBuffer.putDword(var2);
                        FrameBuffer.outgoingBuffer.putWord128(var1);
                        FrameBuffer.outgoingBuffer.putDwordB(Class41.useWithWidgetId);
                        FrameBuffer.outgoingBuffer.putWordLe128(var0);
                        FrameBuffer.outgoingBuffer.putWordLe(MouseRecorder.useWithAmountChildren);
                        Class39_Sub5_Sub5.anInt1739 = var1;
                        Class25.anInt459 = 2;
                        Class65.anInt1137 = var2;
                        if (var2 >> 16 == StillObject.viewOverlayId) {
                            Class25.anInt459 = 1;
                        }
                        GroundItem.anInt2242 = 0;
                        if (var2 >> 16 == Class39_Sub5_Sub14.chatboxOverlayId) {
                            Class25.anInt459 = 3;
                        }
                    }
                    if (type == 52) {
                        Player player = (Class14.players[var0]);
                        if (player != null) {
                            Class26.sendWalkingRoute(0,
                                    player.queueY[0],
                                    0, 2, 1, 1, false, 0,
                                    (Cache.localPlayer.queueX[0]),
                                    (Cache.localPlayer.queueY[0]),
                                    (player.queueX[0]));
                            Class4.crossMode = 2;
                            Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                            AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                            Class26.crossFrameNum = 0;
                            FrameBuffer.outgoingBuffer.putFrame(229);
                            FrameBuffer.outgoingBuffer.putWord128(var0);
                        }
                    }
                    if (type == 44) {
                        Player player = (Class14.players[var0]);
                        if (player != null) {
                            Class26.sendWalkingRoute(0,
                                    player.queueY[0],
                                    0, 2, 1, 1, false, 0,
                                    (Cache.localPlayer.queueX[0]),
                                    (Cache.localPlayer.queueY[0]),
                                    (player.queueX[0]));
                            AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                            Class4.crossMode = 2;
                            Class26.crossFrameNum = 0;
                            Class39_Sub5_Sub4_Sub2.anInt2220++;
                            Class62_Sub2.crossPositionY = Bzip2Entry.mouseClickPositionY;
                            FrameBuffer.outgoingBuffer.putFrame(11);
                            FrameBuffer.outgoingBuffer.putWordLe128(var0);
                        }
                    }
                    if (Class13.anInt208 != 0) {
                        Class39_Sub14.updateTab = true;
                        Class13.anInt208 = 0;
                    }
                    if (ISAAC.aBoolean1100) {
                        Mob.method509((byte) 39);
                        Class39_Sub14.updateTab = true;
                    }
                }
            }
        
    }

    public static int method279(int i, boolean bool, int i_18_) {
        if (i < i_18_) {
            int i_19_ = i;
            i = i_18_;
            i_18_ = i_19_;
        }
        int i_20_;
        for (/**/; i_18_ != 0; i_18_ = i_20_) {
            i_20_ = i % i_18_;
            i = i_18_;
        }
        return i;
    }

    public static void method280(boolean bool) {
        aClass39_Sub1_439 = null;
        aClass3_444 = null;
        aClass3_452 = null;
        aClass3_456 = null;
        aClass3_443 = null;
        aClass3_445 = null;
        arraySizes = null;
        aClass3_442 = null;
        anIntArrayArray455 = null;
        aClass3_446 = null;
        aClass3_441 = null;
        aClass3_447 = null;
    }

    static {
        aClass3_445 = JString.create("Benutzen Sie bitte eine andere Welt)3");
        aClass3_446 = JString.create("cross");
        aClass3_452 = JString.create("Ung-Ultige Session)2ID)3");
        aClass3_441 = JString.create("Lade Freunde)2Liste)3)3)3");
        aClass3_444 = JString.create("Lade Wordpack )2 ");
        arraySizes = new int[5];
        aClass3_442 = aClass3_447;
        aClass3_443 = JString.create("(U1");
        anInt448 = 0;
        anIntArrayArray455 = new int[104][104];
        aClass3_456 = JString.create("(Z");
    }
}
