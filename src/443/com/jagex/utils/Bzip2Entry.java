package com.jagex.utils;

import com.jagex.graphics.BitmapFont;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import com.jagex.io.ArchiveRequest;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class53;
import com.jagex.audio.AudioHandler;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.script.ClientScript;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.config.ItemDefinition;
import com.jagex.awt.events.JKeyListener;
import com.jagex.awt.events.JMouseListener;
import com.jagex.config.ObjectDefinition;
import com.jagex.od.OndemandRequest;
import com.jagex.script.ScriptState;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.Widget;
import com.jagex.script.ScriptExecutor;

/* Class60 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Bzip2Entry {

    public byte[] aByteArray1038;
    public int anInt1039;
    public byte[] aByteArray1040 = new byte[256];
    public static JString aClass3_1041 = (JString.create("No matching objects found)1 please shorten search"));
    public byte[] aByteArray1042;
    public int anInt1043;
    public int[] anIntArray1044;
    public int anInt1045;
    public byte[][] aByteArrayArray1046 = new byte[6][258];
    public int anInt1047;
    public boolean[] aBooleanArray1048 = new boolean[16];
    public static JString aClass3_1049;
    public static JString aClass3_1050;
    public static int anInt1051;
    public int anInt1052;
    public int anInt1053;
    public static int mouseClickPositionY;
    public int[] anIntArray1055;
    public static JString aClass3_1056;
    public byte[] aByteArray1057;
    public static JString aClass3_1058 = JString.create("Trade)4compete");
    public byte[] aByteArray1059;
    public int anInt1060;
    public int anInt1061;
    public byte[] aByteArray1062;
    public static long aLong1063;
    public boolean[] aBooleanArray1064;
    public int[] anIntArray1065;
    public int anInt1066;
    public int[][] anIntArrayArray1067;
    public int anInt1068;
    public int[][] anIntArrayArray1069;
    public int[][] anIntArrayArray1070;
    public int anInt1071;
    public static AbstractFileLoader aClass9_1072;
    public int anInt1073;
    public static JString aClass3_1074;
    public int[] anIntArray1075;
    public int anInt1076;
    public int anInt1077;
    public static int anInt1078;
    public int anInt1079;
    public byte aByte1080;

    public static void method1031(int i) {
        aClass3_1056 = null;
        aClass3_1058 = null;
        aClass3_1049 = null;
        aClass3_1074 = null;
        aClass9_1072 = null;
        aClass3_1050 = null;
        aClass3_1041 = null;
    }

    public static void method1032(AbstractFileLoader class9, byte i, AbstractFileLoader class9_0_,
            BitmapFont class39_sub5_sub10_sub1, boolean bool) {
        Class47.aBoolean894 = bool;
        Class4.aClass9_71 = class9;
        MouseRecorder.itemFileLoader = class9_0_;
        Class37.anInt663 = MouseRecorder.itemFileLoader.getAmountChildren(10);
        FrameBuffer.aClass39_Sub5_Sub10_Sub1_2148 = class39_sub5_sub10_sub1;
    }

    public static void method1033(int i, int i_1_, boolean bool, int i_2_) {
        for (int i_3_ = 0; i_3_ < 8; i_3_++) {
            for (int i_4_ = 0; i_4_ < 8; i_4_++) {
                Class67.heightMap[i][i_3_ + i_2_][i_1_ + i_4_] = 0;
            }
        }
        if (i_2_ > 0) {
            for (int i_5_ = 1; i_5_ < 8; i_5_++) {
                Class67.heightMap[i][i_2_][i_1_ + i_5_] = (Class67.heightMap[i][i_2_ - 1][i_1_ + i_5_]);
            }
        }
        if (i_1_ > 0) {
            for (int i_6_ = 1; i_6_ < 8; i_6_++) {
                Class67.heightMap[i][i_6_ + i_2_][i_1_] = (Class67.heightMap[i][i_2_ + i_6_][i_1_ - 1]);
            }
        }
        if (i_2_ > 0
                && Class67.heightMap[i][i_2_ - 1][i_1_] != 0) {
            Class67.heightMap[i][i_2_][i_1_] = Class67.heightMap[i][i_2_ - 1][i_1_];
        } else if (i_1_ <= 0
                || Class67.heightMap[i][i_2_][i_1_ - 1] == 0) {
            if (i_2_ > 0 && i_1_ > 0
                    && (Class67.heightMap[i][i_2_ - 1][i_1_ - 1]
                    != 0)) {
                Class67.heightMap[i][i_2_][i_1_] = Class67.heightMap[i][i_2_ - 1][i_1_ - 1];
            }
        } else {
            Class67.heightMap[i][i_2_][i_1_] = Class67.heightMap[i][i_2_][i_1_ - 1];
        }
    }

    public static void method1034(IndexedColorSprite class39_sub5_sub10_sub4, byte i) {
        int i_7_ = 256;
        for (int i_8_ = 0; i_8_ < Cache.anIntArray112.length; i_8_++) {
            Cache.anIntArray112[i_8_] = 0;
        }
        for (int i_9_ = 0; i_9_ < 5000; i_9_++) {
            int i_10_ = (int) ((double) i_7_ * (Math.random() * 128.0));
            Cache.anIntArray112[i_10_] = (int) (Math.random() * 256.0);
        }
        for (int i_11_ = 0; i_11_ < 20; i_11_++) {
            for (int i_12_ = 1; i_12_ < i_7_ - 1; i_12_++) {
                for (int i_13_ = 1; i_13_ < 127; i_13_++) {
                    int i_14_ = i_13_ + (i_12_ << 7);
                    HashTable.anIntArray377[i_14_] = (Cache.anIntArray112[i_14_ - 128]
                            + Cache.anIntArray112[i_14_ - 1]
                            + Cache.anIntArray112[i_14_ + 1]
                            + Cache.anIntArray112[i_14_ + 128]) / 4;
                }
            }
            int[] is = Cache.anIntArray112;
            Cache.anIntArray112 = HashTable.anIntArray377;
            HashTable.anIntArray377 = is;
        }
        if (class39_sub5_sub10_sub4 != null) {
            int i_15_ = 0;
            for (int i_16_ = 0; i_16_ < class39_sub5_sub10_sub4.anInt2481;
                    i_16_++) {
                for (int i_17_ = 0; class39_sub5_sub10_sub4.anInt2480 > i_17_;
                        i_17_++) {
                    if (class39_sub5_sub10_sub4.index[i_15_++] != 0) {
                        int i_18_ = i_17_ + 16 + class39_sub5_sub10_sub4.offsetX;
                        int i_19_ = class39_sub5_sub10_sub4.offsetY + (i_16_ + 16);
                        int i_20_ = (i_19_ << 7) + i_18_;
                        Cache.anIntArray112[i_20_] = 0;
                    }
                }
            }
        }
    }

    public static void method1035(int i_21_, int i_22_) {
        FrameBuffer.outgoingBuffer.putFrame(153);
        FrameBuffer.outgoingBuffer.putWordLe(i_21_);
        FrameBuffer.outgoingBuffer.putDword(i_22_);
    }

    public static IndexedColorSprite method1036(boolean bool) {
        IndexedColorSprite class39_sub5_sub10_sub4 = new IndexedColorSprite();
        class39_sub5_sub10_sub4.colors = StillObject.anIntArray1460;
        class39_sub5_sub10_sub4.anInt2483 = Class39_Sub5_Sub12.anInt1854;
        class39_sub5_sub10_sub4.index = TraversalMap.aByteArrayArray517[0];
        class39_sub5_sub10_sub4.offsetY = SubNode.anIntArray1352[0];
        class39_sub5_sub10_sub4.anInt2480 = Class39_Sub5_Sub9.anIntArray1799[0];
        class39_sub5_sub10_sub4.anInt2482 = Class13.anInt203;
        class39_sub5_sub10_sub4.anInt2481 = Class39_Sub14.anIntArray1512[0];
        class39_sub5_sub10_sub4.offsetX = MsTimer.anIntArray1548[0];
        JRuntimeException.method1123();
        return class39_sub5_sub10_sub4;
    }

    public Bzip2Entry() {
        aByteArray1038 = new byte[4096];
        anIntArray1044 = new int[256];
        anIntArray1065 = new int[257];
        aBooleanArray1064 = new boolean[256];
        aByteArray1059 = new byte[18002];
        anIntArrayArray1069 = new int[6][258];
        anIntArrayArray1067 = new int[6][258];
        anIntArrayArray1070 = new int[6][258];
        anIntArray1075 = new int[6];
        anInt1077 = 0;
        anInt1076 = 0;
        anIntArray1055 = new int[16];
        aByteArray1042 = new byte[18002];
    }

    public static boolean readFrame() {
        if (Class37.gameSocket == null) {
            return false;
        }
        try {
            int available = Class37.gameSocket.available();
            if (available == 0) {
                return false;
            }
            if (Class4.frameId == -1) {
                available--;
                Class37.gameSocket.read((Class39_Sub5_Sub11.incomingBuffer.payload), 0, 1);
                Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                Class4.frameId = Class39_Sub5_Sub11.incomingBuffer.getFrame();
                Huffman.frameSize = Client.incomingSizes[Class4.frameId];
            }
            if (Huffman.frameSize == -1) {
                if (available > 0) {
                    available--;
                    Class37.gameSocket.read((Class39_Sub5_Sub11.incomingBuffer.payload), 0, 1);
                    Huffman.frameSize = (Class39_Sub5_Sub11.incomingBuffer.payload[0]) & 0xff;
                } else {
                    return false;
                }
            }
            if (Huffman.frameSize == -2) {
                if (available <= 1) {
                    return false;
                }
                Class37.gameSocket.read((Class39_Sub5_Sub11.incomingBuffer.payload), 0, 2);
                available -= 2;
                Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                Huffman.frameSize = Class39_Sub5_Sub11.incomingBuffer.getUword();
            }
            if (available < Huffman.frameSize) {
                return false;
            }
            Class39_Sub5_Sub11.incomingBuffer.offset = 0;
            Class37.gameSocket.read(Class39_Sub5_Sub11.incomingBuffer.payload, 0, Huffman.frameSize);
            ScriptState.anInt448 = FileLoader.anInt1283;
            FileLoader.anInt1283 = Class63.anInt1117;
            Class39_Sub5_Sub11.anInt1827 = 0;
            Class63.anInt1117 = Class4.frameId;
            if (Class4.frameId == 205) {
                int i_24_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                if (i_24_ == 65535) {
                    i_24_ = -1;
                }
                PlayerApperance.method916(i_24_, 118);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 155) {
                int i_25_ = Class39_Sub5_Sub11.incomingBuffer.getUtriA();
                int i_26_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                if (i_26_ == 65535) {
                    i_26_ = -1;
                }
                Class37.method351(i_25_, i_26_);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 156) {
                int i_27_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int i_28_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int i_29_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int i_30_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class44.aBooleanArray837[i_27_] = true;
                Class13.anIntArray197[i_27_] = i_28_;
                Class2.anIntArray49[i_27_] = i_29_;
                PlayerApperance.anIntArray857[i_27_] = i_30_;
                Class4.anIntArray75[i_27_] = 0;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 148) {
                ClientScript.anInt1703 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                Class4.frameId = -1;
                if (ClientScript.anInt1703 == Node.currentTabId) {
                    if (ClientScript.anInt1703 == 3) {
                        Node.currentTabId = 1;
                    } else {
                        Node.currentTabId = 3;
                    }
                    Class39_Sub14.updateTab = true;
                }
                return true;
            }
            if (Class4.frameId == 192) {
                JString paramStr = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                Object[] params = new Object[paramStr.getLength() + 1];
                for (int i = paramStr.getLength() - 1; i >= 0; i--) {
                    if (paramStr.charAt(i) != 's') {
                        params[i + 1] = new Integer(Class39_Sub5_Sub11.incomingBuffer.getDword());
                    } else {
                        params[i + 1] = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                    }
                }
                params[0] = new Integer(Class39_Sub5_Sub11.incomingBuffer.getDword());
                ScriptExecutor.executeClientScript(0, params, null, 115, 0, null, 0);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 111) {
                TraversalMap.isCameraMoving = true;
                GroundItem.cameraPositionX = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class26.cameraPositionY = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                PlayerApperance.cameraHeightOffset = Class39_Sub5_Sub11.incomingBuffer.getUword();
                MsTimer.cameraOffset = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class43.cameraMoveRate = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                if (Class43.cameraMoveRate >= 100) {
                    StillObject.fCameraPositionX = GroundItem.cameraPositionX * 128 + 64;
                    Node.fCameraPositionY = Class26.cameraPositionY * 128 + 64;
                    Class39_Sub10.cameraHeight = (Class14.method212(StillObject.fCameraPositionX, Node.fCameraPositionY, NameTable.height) - PlayerApperance.cameraHeightOffset);
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 41) {
                ISAAC.logout();
                Class4.frameId = -1;
                return false;
            }
            if (Class4.frameId == 137) {
                int i_32_ = Class39_Sub5_Sub11.incomingBuffer.getDword();
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDword();
                int itemId = Class39_Sub5_Sub11.incomingBuffer.getUword();
                if (itemId == 65535) {
                    itemId = -1;
                }
                Widget widget = Class37.getWidget(hash);
                if (!widget.isNewFormat) {
                    if (itemId == -1) {
                        Class4.frameId = -1;
                        widget.inactiveModelType = 0;
                        return true;
                    }
                    ItemDefinition definition = Class26.getItemDefinition(itemId);
                    widget.inactiveModelType = 4;
                    widget.modelCosineRotationX = definition.anInt1669;
                    widget.modelRotationY = definition.anInt1649 * 100 / i_32_;
                    widget.inactiveAnimationModelId = itemId;
                    widget.modelSineRotationX = definition.anInt1676;
                } else {
                    widget.anInt1997 = itemId;
                    widget.anInt2096 = i_32_;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 3) {
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                int color = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                int rChannel = color >> 10 & 0x1f;
                int gChannel = color >> 5 & 0x1f;
                int bChannel = color & 0x1f;
                Widget widget = Class37.getWidget(hash);
                widget.inactiveColor = (gChannel << 11) + (rChannel << 19) + (bChannel << 3);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 204) {
                MouseRecorder.parseClassCheckRequest(Class39_Sub5_Sub9.fileSignlink, Class39_Sub5_Sub11.incomingBuffer);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 77) {
                long encodedUsername = Class39_Sub5_Sub11.incomingBuffer.getQword();
                JString jstr = Class63.decodeHuffmans(Class39_Sub5_Sub11.incomingBuffer).method58(true);
                JMouseListener.printMessage(6,Deque.decodeBase37(encodedUsername).formatUsername(), jstr);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 58) {
                Class39_Sub14.updateTab = true;
                int id = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int i_41_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                int i_42_ = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                Class39_Sub14.levelExperience[id] = i_42_;
                MouseRecorder.dynamicLevels[id] = i_41_;
                Class39_Sub12.staticLevels[id] = 1;
                for (int i_43_ = 0; i_43_ < 98; i_43_++) {
                    if (i_42_ >= Class53.experienceForLevel[i_43_]) {
                        Class39_Sub12.staticLevels[id] = i_43_ + 2;
                    }
                }
                Client.anInt1269 = Class2.logicCycle;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 147) {
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                int i_45_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                int i_46_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                int i_47_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                Widget widget = Class37.getWidget(hash);
                widget.modelSineRotationX = i_46_;
                widget.modelRotationY = i_45_;
                widget.modelCosineRotationX = i_47_;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 159) {
                Class15.amountIgnores = Huffman.frameSize / 8;
                for (int i_48_ = 0; Class15.amountIgnores > i_48_; i_48_++) {
                    Class39_Sub5_Sub9.ignoreUsernames[i_48_] = Class39_Sub5_Sub11.incomingBuffer.getQword();
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 74) {
                int value = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                int id = Class39_Sub5_Sub11.incomingBuffer.getUword();
                Class39_Sub5_Sub4_Sub2.defaultStateValues[id] = value;
                if (value != Client.stateValues[id]) {
                    Client.stateValues[id] = value;
                    Node.handleVarp(id);
                    if (ISAAC.chatboxWidgetId != -1) {
                        Class14.aBoolean245 = true;
                    }
                    Class39_Sub14.updateTab = true;
                }
                Class4.frameId = -1;
                Class66.anInt1153 = Class2.logicCycle;
                return true;
            }
            if (Class4.frameId == 29) {
                Class2.parsePlayerUpdate();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 221) {
                int i_51_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                int i_52_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                VarbitDefinition.method594(-107, i_51_);
                if (i_52_ != -1) {
                    VarbitDefinition.method594(-95, i_52_);
                }
                if (StillObject.viewOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 105,
                            StillObject.viewOverlayId);
                    StillObject.viewOverlayId = -1;
                }
                if (StillGraphic.tabOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -35,
                            StillGraphic.tabOverlayId);
                    StillGraphic.tabOverlayId = -1;
                }
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -127,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                }
                if (SubNode.screenWidgetId != i_51_) {
                    Class62_Sub2.method1084((byte) -69,
                            SubNode.screenWidgetId);
                    SubNode.screenWidgetId = i_51_;
                    Client.setState(35);
                } else {
                    Node.method410(SubNode.screenWidgetId, true);
                }
                if (i_51_ != ClientScript.screenOverlayId) {
                    Class62_Sub2.method1084((byte) 125,
                            ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = i_52_;
                } else {
                    Node.method410(ClientScript.screenOverlayId, true);
                }
                Mob.keyboardInputType = 0;
                Class39_Sub10.anInt1420 = -1;
                Class39_Sub4.method457(84, SubNode.screenWidgetId);
                Class39_Sub4.method457(101, ClientScript.screenOverlayId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 228) {
                Class39_Sub14.updateTab = true;
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDword();
                int containerId = Class39_Sub5_Sub11.incomingBuffer.getUword();
                Widget widget;
                if (hash >= 0) {
                    widget = Class37.getWidget(hash);
                } else {
                    widget = null;
                }
                if (widget != null) {
                    for (int i_55_ = 0; i_55_ < widget.itemIds.length; i_55_++) {
                        widget.itemIds[i_55_] = 0;
                        widget.itemAmounts[i_55_] = 0;
                    }
                }
                ArchiveRequest.resetItemContainer(containerId);
                int amountItems = Class39_Sub5_Sub11.incomingBuffer.getUword();
                for (int i = 0; amountItems > i; i++) {
                    int itemAmount = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                    if (itemAmount == 255) {
                        itemAmount = Class39_Sub5_Sub11.incomingBuffer.getDword();
                    }
                    int itemId = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    if (widget != null && widget.itemIds.length > i) {
                        widget.itemIds[i] = itemId;
                        widget.itemAmounts[i] = itemAmount;
                    }
                    Huffman.updateItemContainer(containerId, i, itemId - 1, itemAmount);
                }
                Class4.frameId = -1;
                Buffer.anInt1364 = Class2.logicCycle;
                return true;
            }
            if (Class4.frameId == 57) {
                Class14.anInt232 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class4.frameId = -1;
                Class39_Sub14.updateTab = true;
                return true;
            }
            if (Class4.frameId == 109 || Class4.frameId == 79
                    || Class4.frameId == 129 || Class4.frameId == 94
                    || Class4.frameId == 115 || Class4.frameId == 101
                    || Class4.frameId == 84 || Class4.frameId == 207
                    || Class4.frameId == 170 || Class4.frameId == 69
                    || Class4.frameId == 122) {
                Class12.parseStillEntityFrame();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 146) {
                int v0 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                int v1 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 109, Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                    Class14.aBoolean245 = true;
                }
                if (SubNode.screenWidgetId != -1) {
                    Class62_Sub2.method1084((byte) 113, SubNode.screenWidgetId);
                    SubNode.screenWidgetId = -1;
                    Client.setState(30);
                }
                if (ClientScript.screenOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 119, ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = -1;
                }
                if (v0 != StillObject.viewOverlayId) {
                    Class62_Sub2.method1084((byte) 107, StillObject.viewOverlayId);
                    StillObject.viewOverlayId = v0;
                } else {
                    Node.method410(StillObject.viewOverlayId, true);
                }
                if (v1 == StillGraphic.tabOverlayId) {
                    Node.method410(StillGraphic.tabOverlayId, true);
                } else {
                    Class62_Sub2.method1084((byte) 108, StillGraphic.tabOverlayId);
                    StillGraphic.tabOverlayId = v1;
                }
                ISAAC.aBoolean1089 = true;
                Class39_Sub14.updateTab = true;
                Class39_Sub10.anInt1420 = -1;
                if (Mob.keyboardInputType != 0) {
                    Mob.keyboardInputType = 0;
                    Class14.aBoolean245 = true;
                }
                Class39_Sub4.method457(59, StillObject.viewOverlayId);
                Class39_Sub4.method457(106, StillGraphic.tabOverlayId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 154) {
                int i_62_ = Class39_Sub5_Sub11.incomingBuffer.getDwordLe();
                Player.aClass56_2529 = Class39_Sub5_Sub9.fileSignlink.method256(i_62_);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 179) {
                long l = Class39_Sub5_Sub11.incomingBuffer.getQword();
                int i_63_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                JString class3 = Deque.decodeBase37(l).formatUsername();
                for (int i_64_ = 0; i_64_ < Class4.anInt62; i_64_++) {
                    if (JApplet.aLongArray2[i_64_] == l) {
                        if (Player.anIntArray2533[i_64_]
                                != i_63_) {
                            Player.anIntArray2533[i_64_] = i_63_;
                            Class39_Sub14.updateTab = true;
                            if (i_63_ > 0) {
                                JMouseListener.printMessage(5,Class66.blankString,
                                        (Class39_Sub5_Sub11.join((new JString[]{class3,
                                            (Class39_Sub5_Sub6.aClass3_1769)}))));
                            }
                            if (i_63_ == 0) {
                                JMouseListener.printMessage(5,Class66.blankString,
                                        (Class39_Sub5_Sub11.join((new JString[]{class3,
                                            ScriptState.aClass3_442}))));
                            }
                        }
                        class3 = null;
                        break;
                    }
                }
                boolean bool = false;
                if (class3 != null && Class4.anInt62 < 200) {
                    JApplet.aLongArray2[Class4.anInt62] = l;
                    Projectile.aClass3Array2188[Class4.anInt62] = class3;
                    Player.anIntArray2533[Class4.anInt62] = i_63_;
                    Class39_Sub14.updateTab = true;
                    Class4.anInt62++;
                }
                while (!bool) {
                    bool = true;
                    for (int i_65_ = 0; Class4.anInt62 - 1 > i_65_; i_65_++) {
                        if (((Player.anIntArray2533[i_65_]
                                != BufferedFile.worldId)
                                && (Player.anIntArray2533[i_65_ + 1]) == BufferedFile.worldId)
                                || ((Player.anIntArray2533[i_65_]) == 0
                                && (Player.anIntArray2533[i_65_ + 1]) != 0)) {
                            bool = false;
                            int i_66_ = (Player.anIntArray2533[i_65_]);
                            Player.anIntArray2533[i_65_] = (Player.anIntArray2533[i_65_ + 1]);
                            Player.anIntArray2533[(i_65_
                                    + 1)] = i_66_;
                            JString class3_67_ = (Projectile.aClass3Array2188[i_65_]);
                            Projectile.aClass3Array2188[i_65_] = (Projectile.aClass3Array2188[i_65_ + 1]);
                            Projectile.aClass3Array2188[i_65_ + 1] = class3_67_;
                            long l_68_ = JApplet.aLongArray2[i_65_];
                            JApplet.aLongArray2[i_65_] = JApplet.aLongArray2[i_65_ + 1];
                            JApplet.aLongArray2[i_65_ + 1] = l_68_;
                            Class39_Sub14.updateTab = true;
                        }
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 87) {
                Class39_Sub5_Sub7.minimapState = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 72) {
                if (Node.currentTabId == 12) {
                    Class39_Sub14.updateTab = true;
                }
                MsTimer.runEnergy = Class39_Sub5_Sub11.incomingBuffer.getWord();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 140) {
                int i_69_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                Class63.removeItemContainer((byte) -73, i_69_);
                Class4.frameId = -1;
                Buffer.anInt1364 = Class2.logicCycle;
                return true;
            }
            if (Class4.frameId == 104) {
                for (int i_70_ = 0;
                        (Class14.players.length
                        > i_70_);
                        i_70_++) {
                    if (Class14.players[i_70_]
                            != null) {
                        Class14.players[i_70_].anInt2268 = -1;
                    }
                }
                for (int i_71_ = 0;
                        i_71_ < (GroundItem.npcs).length;
                        i_71_++) {
                    if ((GroundItem.npcs[i_71_])
                            != null) {
                        GroundItem.npcs[i_71_].anInt2268 = -1;
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 73) {
                int i_72_ = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                int i_73_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                int i_74_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                Widget widget = Class37.getWidget(i_72_);
                widget.anInt2069 = i_73_ + (i_74_ << 16);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 88) {
                int i_75_ = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                int i_76_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                Widget widget = Class37.getWidget(i_75_);
                if (widget != null
                        && widget.type == 0) {
                    if (i_76_ < 0) {
                        i_76_ = 0;
                    }
                    if (i_76_ > (widget.anInt2095
                            - widget.height)) {
                        i_76_ = (widget.anInt2095
                                - widget.height);
                    }
                    widget.scrollY = i_76_;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 219) {
                int i_77_ = Class39_Sub5_Sub11.incomingBuffer.getWord128();
                if (i_77_ >= 0) {
                    VarbitDefinition.method594(-125, i_77_);
                }
                if (i_77_ != Class26.viewWidgetId) {
                    Class62_Sub2.method1084((byte) 115, Class26.viewWidgetId);
                    Class26.viewWidgetId = i_77_;
                }
                Class39_Sub4.method457(94, Class26.viewWidgetId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 149) {
                int i_78_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                VarbitDefinition.method594(-98, i_78_);
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 115,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                    Class14.aBoolean245 = true;
                }
                if (SubNode.screenWidgetId != -1) {
                    Class62_Sub2.method1084((byte) 127,
                            SubNode.screenWidgetId);
                    SubNode.screenWidgetId = -1;
                    Client.setState(30);
                }
                if (ClientScript.screenOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 112,
                            ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = -1;
                }
                if (StillObject.viewOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 117,
                            StillObject.viewOverlayId);
                    StillObject.viewOverlayId = -1;
                }
                if (StillGraphic.tabOverlayId != i_78_) {
                    Class62_Sub2.method1084((byte) -62,
                            StillGraphic.tabOverlayId);
                    StillGraphic.tabOverlayId = i_78_;
                } else {
                    Node.method410(StillGraphic.tabOverlayId, true);
                }
                Class39_Sub14.updateTab = true;
                ISAAC.aBoolean1089 = true;
                Class39_Sub10.anInt1420 = -1;
                if (Mob.keyboardInputType != 0) {
                    Class14.aBoolean245 = true;
                    Mob.keyboardInputType = 0;
                }
                Class39_Sub4.method457(104, StillGraphic.tabOverlayId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 160) {
                int parentId = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                VarbitDefinition.method594(-99, parentId);
                if (StillGraphic.tabOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 117,
                            StillGraphic.tabOverlayId);
                    Class39_Sub14.updateTab = true;
                    ISAAC.aBoolean1089 = true;
                    StillGraphic.tabOverlayId = -1;
                }
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 115,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class14.aBoolean245 = true;
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                }
                if (SubNode.screenWidgetId != -1) {
                    Class62_Sub2.method1084((byte) 100,
                            SubNode.screenWidgetId);
                    SubNode.screenWidgetId = -1;
                    Client.setState(30);
                }
                if (ClientScript.screenOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 123,
                            ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = -1;
                }
                if (parentId != StillObject.viewOverlayId) {
                    Class62_Sub2.method1084((byte) 126,
                            StillObject.viewOverlayId);
                    StillObject.viewOverlayId = parentId;
                } else {
                    Node.method410(StillObject.viewOverlayId, true);
                }
                Class39_Sub10.anInt1420 = -1;
                if (Mob.keyboardInputType != 0) {
                    Class14.aBoolean245 = true;
                    Mob.keyboardInputType = 0;
                }
                Class39_Sub4.method457(65, StillObject.viewOverlayId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 121) {
                Class25.parseMapRebuild(false);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 238) {
                Class39_Sub14.parseNpcUpdate(0);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 62) {
                int i_80_ = Class39_Sub5_Sub11.incomingBuffer.getByteA();
                int i_81_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                Class39_Sub5_Sub4_Sub2.defaultStateValues[i_81_] = i_80_;
                if (Client.stateValues[i_81_] != i_80_) {
                    Client.stateValues[i_81_] = i_80_;
                    Node.handleVarp(i_81_);
                    if (ISAAC.chatboxWidgetId != -1) {
                        Class14.aBoolean245 = true;
                    }
                    Class39_Sub14.updateTab = true;
                }
                Class4.frameId = -1;
                Class66.anInt1153 = Class2.logicCycle;
                return true;
            }
            if (Class4.frameId == 242) {
                TraversalMap.isCameraMoving = false;
                for (int i_82_ = 0; i_82_ < 5; i_82_++) {
                    Class44.aBooleanArray837[i_82_] = false;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 230) {
                GouraudVertex.anInt907 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 244) {
                Node.mSectorX = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                ISAAC.mSectorY = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                while (Class39_Sub5_Sub11.incomingBuffer.offset
                        < Huffman.frameSize) {
                    Class4.frameId = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                    Class12.parseStillEntityFrame();
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 130) {
                int i_83_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                JString class3 = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                int i_84_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                if (i_83_ >= 1 && i_83_ <= 5) {
                    if (class3.equalTo(Wall.nullJstr)) {
                        class3 = null;
                    }
                    Class39_Sub14.playerOptions[i_83_ - 1] = class3;
                    JRuntimeException.aBooleanArray1225[i_83_ - 1] = i_84_ == 0;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 232) {
                int amountX = Class39_Sub5_Sub11.incomingBuffer.getWord128();
                int amountY = Class39_Sub5_Sub11.incomingBuffer.getWord();
                int widgetId = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                Widget widget = Class37.getWidget(widgetId);
                widget.displayOffsetY = widget.offsetY + amountX;
                widget.displayOffsetX = widget.offsetX + amountY;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 199) {
                int positionX = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                int positionY = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                int hash = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                NameTable.height = hash >> 1;
                Cache.localPlayer.setLocation(positionX, positionY, (hash & 0x1) == 1);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 163) {
                for (int i_91_ = 0; ObjectDefinition.amountVarpDefinitions > i_91_;
                        i_91_++) {
                    VarpDefinition definition = AudioHandler.getVarp(i_91_);
                    if (definition != null
                            && definition.type == 0) {
                        Class39_Sub5_Sub4_Sub2.defaultStateValues[i_91_] = 0;
                        Client.stateValues[i_91_] = 0;
                    }
                }
                Class39_Sub14.updateTab = true;
                if (ISAAC.chatboxWidgetId != -1) {
                    Class14.aBoolean245 = true;
                }
                Class66.anInt1153 = Class2.logicCycle;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 117) {
                ClassCheckRequest.systemUpdateTime = (Class39_Sub5_Sub11.incomingBuffer.getUword128()
                        * 30);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 96) {
                JMouseListener.anInt787 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                if (JMouseListener.anInt787 == 1) {
                    Class30.anInt542 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                }
                if (JMouseListener.anInt787 >= 2 && JMouseListener.anInt787 <= 6) {
                    if (JMouseListener.anInt787 == 2) {
                        Class43.anInt823 = 64;
                        Class39_Sub5_Sub18.anInt2124 = 64;
                    }
                    if (JMouseListener.anInt787 == 3) {
                        Class39_Sub5_Sub18.anInt2124 = 64;
                        Class43.anInt823 = 0;
                    }
                    if (JMouseListener.anInt787 == 4) {
                        Class39_Sub5_Sub18.anInt2124 = 64;
                        Class43.anInt823 = 128;
                    }
                    if (JMouseListener.anInt787 == 5) {
                        Class39_Sub5_Sub18.anInt2124 = 0;
                        Class43.anInt823 = 64;
                    }
                    if (JMouseListener.anInt787 == 6) {
                        Class39_Sub5_Sub18.anInt2124 = 128;
                        Class43.anInt823 = 64;
                    }
                    JMouseListener.anInt787 = 2;
                    JString.anInt1229 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    Class25.anInt471 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    Class66.anInt1158 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                }
                if (JMouseListener.anInt787 == 10) {
                    Class34.anInt607 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 6) {
                int i_92_ = Class39_Sub5_Sub11.incomingBuffer.getWordLe();
                if (ISAAC.chatboxWidgetId != i_92_) {
                    Class62_Sub2.method1084((byte) -61, ISAAC.chatboxWidgetId);
                    ISAAC.chatboxWidgetId = i_92_;
                }
                Class14.aBoolean245 = true;
                Class39_Sub4.method457(103, ISAAC.chatboxWidgetId);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 90) {
                int id = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int parentId = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                if (parentId == 65535) {
                    parentId = -1;
                }
                if (Class39_Sub5_Sub14.tabWidgetIds[id] == parentId) {
                    Node.method410(Class39_Sub5_Sub14.tabWidgetIds[id],
                            true);
                } else {
                    Class62_Sub2.method1084((byte) 109,
                            (Class39_Sub5_Sub14.tabWidgetIds[id]));
                    Class39_Sub5_Sub14.tabWidgetIds[id] = parentId;
                }
                ISAAC.aBoolean1089 = true;
                Class39_Sub14.updateTab = true;
                Class39_Sub4.method457(115, Class39_Sub5_Sub14.tabWidgetIds[id]);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 15) {
                Class30.anInt544 = 0;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 245) {
                int i_95_ = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                Widget class39_sub5_sub17 = Class37.getWidget(i_95_);
                for (int i_96_ = 0;
                        i_96_ < class39_sub5_sub17.itemIds.length;
                        i_96_++) {
                    class39_sub5_sub17.itemIds[i_96_] = -1;
                    class39_sub5_sub17.itemIds[i_96_] = 0;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 10) {
                Node.currentTabId = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class39_Sub14.updateTab = true;
                ISAAC.aBoolean1089 = true;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 180) {
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDwordLe();
                JString text = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                Widget widget = Class37.getWidget(hash);
                widget.inactiveText = text;
                if (hash >> 16 == Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId]) {
                    Class39_Sub14.updateTab = true;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 234) {
                boolean bool = (Class39_Sub5_Sub11.incomingBuffer.getUbyte128()
                        == 1);
                int widgetId = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                Widget class39_sub5_sub17 = Class37.getWidget(widgetId);
                Class4.frameId = -1;
                class39_sub5_sub17.aBoolean2055 = bool;
                return true;
            }
            if (Class4.frameId == 25) {
                long l = Class39_Sub5_Sub11.incomingBuffer.getQword();
                long l_99_ = (long) Class39_Sub5_Sub11.incomingBuffer.getUword();
                long l_100_ = (long) Class39_Sub5_Sub11.incomingBuffer.getUtri();
                int i_101_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                long l_102_ = (l_99_ << 32) - -l_100_;
                boolean bool = false;
                for (int i_103_ = 0; i_103_ < 100; i_103_++) {
                    if (ClassCheckRequest.aLongArray1385[i_103_] == l_102_) {
                        bool = true;
                        break;
                    }
                }
                if (i_101_ <= 1) {
                    for (int i_104_ = 0; Class15.amountIgnores > i_104_; i_104_++) {
                        if (l == Class39_Sub5_Sub9.ignoreUsernames[i_104_]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if (!bool && Wall.anInt630 == 0) {
                    ClassCheckRequest.aLongArray1385[Timer.anInt884] = l_102_;
                    Timer.anInt884 = (Timer.anInt884 + 1) % 100;
                    JString class3 = Class63.decodeHuffmans(Class39_Sub5_Sub11.incomingBuffer).method58(true);
                    if (i_101_ != 2 && i_101_ != 3) {
                        if (i_101_ != 1) {
                            JMouseListener.printMessage(3,Deque.decodeBase37(l).formatUsername(),
                                    class3);
                        } else {
                            JMouseListener.printMessage(7,(Class39_Sub5_Sub11.join(new JString[]{Class37.crown1Jstr, Deque.decodeBase37(l).formatUsername()})),
                                    class3);
                        }
                    } else {
                        JMouseListener.printMessage(7,(Class39_Sub5_Sub11.join((new JString[]{Class53.crown2Jstr, Deque.decodeBase37(l).formatUsername()}))), class3);
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 97) {
                int i_105_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                VarbitDefinition.method594(-90, i_105_);
                if (StillGraphic.tabOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 114,
                            StillGraphic.tabOverlayId);
                    StillGraphic.tabOverlayId = -1;
                    Class39_Sub14.updateTab = true;
                    ISAAC.aBoolean1089 = true;
                }
                if (SubNode.screenWidgetId != -1) {
                    Class62_Sub2.method1084((byte) -113, SubNode.screenWidgetId);
                    SubNode.screenWidgetId = -1;
                    Client.setState(30);
                }
                if (ClientScript.screenOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -75,
                            ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = -1;
                }
                if (StillObject.viewOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 107,
                            StillObject.viewOverlayId);
                    StillObject.viewOverlayId = -1;
                }
                if (i_105_ != Class39_Sub5_Sub14.chatboxOverlayId) {
                    Class62_Sub2.method1084((byte) 122,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = i_105_;
                } else {
                    Node.method410(Class39_Sub5_Sub14.chatboxOverlayId, true);
                }
                Class39_Sub10.anInt1420 = -1;
                Class39_Sub4.method457(45, Class39_Sub5_Sub14.chatboxOverlayId);
                Class14.aBoolean245 = true;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 213) {
                Class39_Sub14.updateTab = true;
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDword();
                int containerId = Class39_Sub5_Sub11.incomingBuffer.getUword();
                Widget widget;
                if (hash < 0) {
                    widget = null;
                } else {
                    widget = Class37.getWidget(hash);
                }
                while (Class39_Sub5_Sub11.incomingBuffer.offset < Huffman.frameSize) {
                    int slot = Class39_Sub5_Sub11.incomingBuffer.getSmartB();
                    int id = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    int amt = 0;
                    if (id != 0) {
                        amt = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                        if (amt == 255) {
                            amt = Class39_Sub5_Sub11.incomingBuffer.getDword();
                        }
                    }
                    if (widget != null && slot >= 0  && widget.itemIds.length > slot) {
                        widget.itemIds[slot] = id;
                        widget.itemAmounts[slot] = amt;
                    }
                    Huffman.updateItemContainer(containerId, slot, id - 1, amt);
                }
                Buffer.anInt1364 = Class2.logicCycle;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 82) {
                Node.mSectorX = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                ISAAC.mSectorY = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 95) {
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDwordLe();
                int i_112_ = Class39_Sub5_Sub11.incomingBuffer.getWordLe128();
                Widget widget = Class37.getWidget(hash);
                if (i_112_ != widget.anInt2103 || i_112_ == -1) {
                    widget.anInt2079 = 0;
                    widget.anInt2103 = i_112_;
                    widget.anInt1999 = 0;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 157) {
                JString message = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                if (!message.startsWith(FileLoader.tradeRequestJstr)) {
                    if (message.startsWith(Class34.duelRequestJstr)) {
                        boolean bool = false;
                        JString class3_113_ = (message.substring(0, message.method80(22938, (TextConstants.colon))));
                        long l = class3_113_.encodeBase37();
                        for (int i_114_ = 0; i_114_ < Class15.amountIgnores; i_114_++) {
                            if (Class39_Sub5_Sub9.ignoreUsernames[i_114_] == l) {
                                bool = true;
                                break;
                            }
                        }
                        if (!bool && Wall.anInt630 == 0) {
                            JMouseListener.printMessage(8,class3_113_, ISAAC.aClass3_1085);
                        }
                    } else if (!message.startsWith(JMouseListener.chalRequestJstr)) {
                        JMouseListener.printMessage(0, Class66.blankString, message);
                    } else {
                        JString class3_115_ = (message.substring(0, message.method80(22938, (TextConstants.colon))));
                        long l = class3_115_.encodeBase37();
                        boolean bool = false;
                        for (int i_116_ = 0; Class15.amountIgnores > i_116_;
                                i_116_++) {
                            if (l
                                    == Class39_Sub5_Sub9.ignoreUsernames[i_116_]) {
                                bool = true;
                                break;
                            }
                        }
                        if (!bool && Wall.anInt630 == 0) {
                            JString class3_117_ = (message.substring((message.method80(22938, (TextConstants.colon))
                                                             + 1), message.getLength() - 9));
                            JMouseListener.printMessage(8,class3_115_, class3_117_);
                        }
                    }
                } else {
                    JString class3_118_ = message.substring(0, message.method80(22938,
                               (TextConstants.colon)));
                    long l = class3_118_.encodeBase37();
                    boolean bool = false;
                    for (int i_119_ = 0; Class15.amountIgnores > i_119_; i_119_++) {
                        if (l == Class39_Sub5_Sub9.ignoreUsernames[i_119_]) {
                            bool = true;
                            break;
                        }
                    }
                    if (!bool && Wall.anInt630 == 0) {
                        JMouseListener.printMessage(4,class3_118_, Class30.aClass3_535);
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 193) {
                Class25.parseMapRebuild(true);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 24) {
                int i_120_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                int hash = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                Widget widget = Class37.getWidget(hash);
                widget.inactiveAnimationModelId = i_120_;
                widget.inactiveModelType = 1;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 241) {
                TraversalMap.isCameraMoving = true;
                Class53.anInt965 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class39_Sub5_Sub18.anInt2121 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                ScriptState.anInt454 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                FrameBuffer.anInt2156 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class32.anInt590 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                if (Class32.anInt590 >= 100) {
                    int i_122_ = Class53.anInt965 * 128 + 64;
                    int i_123_ = Class39_Sub5_Sub18.anInt2121 * 128 + 64;
                    int i_124_ = (Class14.method212(i_122_, i_123_,
                            NameTable.height)
                            - ScriptState.anInt454);
                    int i_125_ = i_122_ - StillObject.fCameraPositionX;
                    int i_126_ = -Class39_Sub10.cameraHeight + i_124_;
                    int i_127_ = i_123_ - Node.fCameraPositionY;
                    int i_128_ = (int) Math.sqrt((double) (i_125_ * i_125_
                            + i_127_ * i_127_));
                    Class43.anInt799 = (int) (Math.atan2((double) i_126_, (double) i_128_)
                            * 325.949) & 0x7ff;
                    Mob.anInt2315 = (int) (Math.atan2((double) i_125_, (double) i_127_)
                            * -325.949) & 0x7ff;
                    if (Class43.anInt799 < 128) {
                        Class43.anInt799 = 128;
                    }
                    if (Class43.anInt799 > 383) {
                        Class43.anInt799 = 383;
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 91) {
                anInt1051 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                NameTable.anInt177 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Cache.anInt118 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Mob.aBoolean2253 = true;
                Class14.aBoolean245 = true;
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 133) {
                ISAAC.mSectorY = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                Node.mSectorX = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                for (int i_129_ = Node.mSectorX;
                        i_129_ < Node.mSectorX + 8; i_129_++) {
                    for (int i_130_ = ISAAC.mSectorY;
                            i_130_ < ISAAC.mSectorY + 8; i_130_++) {
                        if ((Class20.groundItems[NameTable.height][i_129_][i_130_])
                                != null) {
                            Class20.groundItems[NameTable.height][i_129_][i_130_] = null;
                            Class65.updateGroundItems(i_129_, i_130_);
                        }
                    }
                }
                for (StillObject stillObject = ((StillObject) Class15.stillObjects.getFirst());
                        stillObject != null;
                        stillObject = ((StillObject) Class15.stillObjects.getNext())) {
                    if (Node.mSectorX <= stillObject.positionX
                            && Node.mSectorX + 8 > stillObject.positionX
                            && ISAAC.mSectorY <= stillObject.positionY
                            && stillObject.positionY < ISAAC.mSectorY + 8
                            && NameTable.height == stillObject.height) {
                        stillObject.anInt1456 = 0;
                    }
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 226) {
                if (Node.currentTabId == 12) {
                    Class39_Sub14.updateTab = true;
                }
                ArchiveRequest.runEnergy = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 32) {
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -40,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                }
                Class4.frameId = -1;
                Class14.aBoolean245 = true;
                Mob.keyboardInputType = 1;
                Class39_Sub12.aBoolean1489 = false;
                Class66.inputMessageJstr = Class66.blankString;
                return true;
            }
            if (Class4.frameId == 81) {
                int effectId = Class39_Sub5_Sub11.incomingBuffer.getUword();
                int loopCount = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                int delay = Class39_Sub5_Sub11.incomingBuffer.getUword();
                TraversalMap.queueSoundEffect(effectId, loopCount, delay);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 236) {
                Huffman.anInt756 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 178) {
                if (StillGraphic.tabOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -34,
                            StillGraphic.tabOverlayId);
                    ISAAC.aBoolean1089 = true;
                    Class39_Sub14.updateTab = true;
                    StillGraphic.tabOverlayId = -1;
                }
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -99,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class14.aBoolean245 = true;
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                }
                if (SubNode.screenWidgetId != -1) {
                    Class62_Sub2.method1084((byte) -125,
                            SubNode.screenWidgetId);
                    SubNode.screenWidgetId = -1;
                    Client.setState(30);
                }
                if (ClientScript.screenOverlayId != -1) {
                    Class62_Sub2.method1084((byte) 106,
                            ClientScript.screenOverlayId);
                    ClientScript.screenOverlayId = -1;
                }
                if (StillObject.viewOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -88,
                            StillObject.viewOverlayId);
                    StillObject.viewOverlayId = -1;
                }
                Class4.frameId = -1;
                Class39_Sub10.anInt1420 = -1;
                if (Mob.keyboardInputType != 0) {
                    Class14.aBoolean245 = true;
                    Mob.keyboardInputType = 0;
                }
                return true;
            }
            if (Class4.frameId == 22) {
                int childId = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                if (childId == 65535) {
                    childId = -1;
                }
                int flags = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                int widgetId = Class39_Sub5_Sub11.incomingBuffer.getDwordLe();
                Widget widget = Class62_Sub2.getWidgetChild(widgetId, childId);
                if (widget != null) {
                    widget.flags = flags;
                }
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 220) {
                for (int i = 0; Client.stateValues.length > i; i++) {
                    if (Class39_Sub5_Sub4_Sub2.defaultStateValues[i] != Client.stateValues[i]) {
                        Client.stateValues[i] = Class39_Sub5_Sub4_Sub2.defaultStateValues[i];
                        Node.handleVarp(i);
                        Class39_Sub14.updateTab = true;
                    }
                }
                Class4.frameId = -1;
                Class66.anInt1153 = Class2.logicCycle;
                return true;
            }
            if (Class4.frameId == 227) {
                int i_138_ = Class39_Sub5_Sub11.incomingBuffer.getUword();
                int i_139_ = Class39_Sub5_Sub11.incomingBuffer.getDword();
                Widget class39_sub5_sub17 = Class37.getWidget(i_139_);
                class39_sub5_sub17.inactiveAnimationModelId = i_138_;
                Class4.frameId = -1;
                class39_sub5_sub17.inactiveModelType = 2;
                return true;
            }
            if (Class4.frameId == 31) {
                int i_140_ = Class39_Sub5_Sub11.incomingBuffer.getDwordLe();
                Widget widget = Class37.getWidget(i_140_);
                widget.inactiveModelType = 3;
                widget.inactiveAnimationModelId = Cache.localPlayer.aClass45_2516.method928(102);
                Class4.frameId = -1;
                return true;
            }
            if (Class4.frameId == 51) {
                if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                    Class62_Sub2.method1084((byte) -41,
                            Class39_Sub5_Sub14.chatboxOverlayId);
                    Class39_Sub5_Sub14.chatboxOverlayId = -1;
                }
                Class4.frameId = -1;
                Mob.keyboardInputType = 2;
                Class39_Sub12.aBoolean1489 = false;
                Class66.inputMessageJstr = Class66.blankString;
                Class14.aBoolean245 = true;
                return true;
            }
            ClassCheckRequest.method849(null, 64, ("T1 - " + Class4.frameId + ","
                    + FileLoader.anInt1283 + ","
                    + ScriptState.anInt448 + " - "
                    + Huffman.frameSize));
            ISAAC.logout();
        } catch (java.io.IOException ioexception) {
            Class37.method354((byte) 39);
        } catch (Exception exception) {
            String string = ("T2 - " + Class4.frameId + "," + FileLoader.anInt1283 + ","
                    + ScriptState.anInt448 + " - " + Huffman.frameSize + ","
                    + (Cache.localPlayer.queueX[0]
                    + Class65.anInt1145)
                    + ","
                    + (JKeyListener.anInt618
                    + (Cache.localPlayer.queueY[0]))
                    + " - ");
            for (int i_141_ = 0; i_141_ < Huffman.frameSize && i_141_ < 50;
                    i_141_++) {
                string += (Class39_Sub5_Sub11.incomingBuffer.payload[i_141_]) + ",";
            }
            ClassCheckRequest.method849(exception, 64, string);
            ISAAC.logout();
        }
        return true;
    }

    static {
        aClass3_1049 = aClass3_1058;
        aClass3_1050 = aClass3_1041;
        mouseClickPositionY = 0;
        anInt1051 = 0;
        aClass3_1074 = JString.create("Willkommen auf RuneScape");
        aClass3_1056 = JString.create("backbase1");
    }
}
