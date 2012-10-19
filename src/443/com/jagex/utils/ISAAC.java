package com.jagex.utils;

import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.Buffer;
import com.jagex.io.ArchiveWorker;
import com.jagex.io.BufferedFile;
import unpackaged.Class2;
import unpackaged.Class30;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Class37;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import com.jagex.graphics.TriangleRasterizer;
import unpackaged.Class39_Sub5_Sub12;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import unpackaged.Class44;
import unpackaged.Class53;
import com.jagex.audio.AudioHandler;
import unpackaged.Class66;
import com.jagex.Client;
import com.jagex.awt.JApplet;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.io.FileLoader;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.config.Widget;
import com.jagex.script.ScriptExecutor;

/* Class61 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class ISAAC {

    public static byte[][][] aByteArrayArrayArray1081;
    public static JString aClass3_1082;
    public int anInt1083;
    public static int mSectorY;
    public static JString aClass3_1085;
    public static JString aClass3_1086;
    public static int width;
    public int anInt1088;
    public static boolean aBoolean1089;
    public static JString aClass3_1090 = JString.create("backhmid2");
    public static int mousePositionX;
    public static JString aClass3_1092;
    public int anInt1093;
    public static JString aClass3_1094;
    public static int chatboxWidgetId;
    public static DirectColorSprite aClass39_Sub5_Sub10_Sub3_1096;
    public static JString aClass3_1097 = JString.create("wishes to duel with you)3");
    public static JString aClass3_1098;
    public static JString aClass3_1099;
    public static boolean aBoolean1100;
    public int anInt1101;
    public int[] anIntArray1102;
    public static JString aClass3_1103;
    public static Buffer[] appearanceBuffers;
    public int[] anIntArray1105 = new int[256];

    public static void method1038(int i, int i_0_, int i_1_, int i_2_,
            Widget[] widgets,
            int i_3_, int i_4_, int i_5_, int flags,
            int i_7_) {
        for (int i_8_ = 0; i_8_ < widgets.length; i_8_++) {
            Widget widget = widgets[i_8_];
            if (widget != null
                    && (widget.type == 0
                    || widget.aBoolean2047)
                    && widget != null
                    && i == widget.anInt2050
                    && !widget.method754(HashTable.aBoolean361)) {
                int i_9_ = i_0_ + (widget.displayOffsetX - i_5_);
                int i_10_ = -i_2_ + widget.displayOffsetY + i_7_;
                int i_11_ = i_9_ + widget.width;
                int i_12_ = i_10_ + widget.height;
                int i_13_ = i_10_ <= i_7_ ? i_7_ : i_10_;
                int i_14_ = i_4_ > i_11_ ? i_11_ : i_4_;
                int i_15_ = i_0_ < i_9_ ? i_9_ : i_0_;
                int i_16_ = i_12_ < i_3_ ? i_12_ : i_3_;
                if (widget.type == 0) {
                    method1038(widget.id, i_15_, i_1_,
                            widget.scrollY,
                            widgets, i_16_, i_14_,
                            widget.scrollX, flags, i_13_);
                    if (widget.children
                            != null) {
                        method1038(widget.id, i_15_, 1,
                                widget.scrollY,
                                (widget.children),
                                i_16_, i_14_, widget.scrollX,
                                flags, i_13_);
                    }
                }
                if (widget.aBoolean2047) {
                    boolean bool = false;
                    boolean bool_17_;
                    if (mousePositionX < i_15_ || Class33.mousePositionY < i_13_
                            || i_14_ <= mousePositionX || i_16_ <= Class33.mousePositionY) {
                        bool_17_ = false;
                    } else {
                        bool_17_ = true;
                    }
                    boolean bool_18_ = false;
                    if (Class30.anInt541 == 1 && bool_17_) {
                        bool = true;
                    }
                    if (Timer.anInt887 == 1
                            && Class39_Sub4.mouseClickPositionX >= i_15_
                            && Bzip2Block.mouseClickPositionY >= i_13_
                            && i_14_ > Class39_Sub4.mouseClickPositionX
                            && Bzip2Block.mouseClickPositionY < i_16_) {
                        bool_18_ = true;
                    }
                    if (bool_18_ && NpcDefinition.aClass39_Sub5_Sub17_1864 == null
                            && (flags & 0x200) != 0 && !Class39_Sub12.aBoolean1493
                            && (Class44.method914(widget, (byte) -128)
                            != null)) {
                        FileLoader.anInt1303 = Class33.mousePositionY;
                        JApplet.anInt8 = 0;
                        ItemDefinition.anInt1684 = mousePositionX;
                        NpcDefinition.aClass39_Sub5_Sub17_1864 = widget;
                        Class37.aBoolean654 = false;
                    }
                    if (NpcDefinition.aClass39_Sub5_Sub17_1864 != null
                            || Class39_Sub12.aBoolean1493) {
                        bool_17_ = false;
                        bool_18_ = false;
                        bool = false;
                    }
                    if (!widget.aBoolean2106 && bool_18_ && (flags & 0x1) != 0) {
                        widget.aBoolean2106 = true;
                        if (widget.anObjectArray2035 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2035, null,
                                    125, -i_9_ + Class39_Sub4.mouseClickPositionX,
                                    widget,
                                    Bzip2Block.mouseClickPositionY - i_10_);
                        }
                    }
                    if (widget.aBoolean2106 && bool
                            && (flags & 0x4) != 0
                            && widget.anObjectArray2044 != null) {
                        ScriptExecutor.executeClientScript(0, widget.anObjectArray2044, null,
                                -119, mousePositionX - i_9_, widget,
                                Class33.mousePositionY - i_10_);
                    }
                    if (widget.aBoolean2106 && !bool
                            && (flags & 0x2) != 0) {
                        widget.aBoolean2106 = false;
                        if (widget.anObjectArray2085 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2085, null,
                                    122, mousePositionX - i_9_, widget,
                                    -i_10_ + Class33.mousePositionY);
                        }
                    }
                    if (bool && (flags & 0x8) != 0
                            && widget.anObjectArray2080 != null) {
                        ScriptExecutor.executeClientScript(0, widget.anObjectArray2080, null,
                                118, mousePositionX - i_9_, widget,
                                Class33.mousePositionY - i_10_);
                    }
                    if (!widget.aBoolean2042 && bool_17_
                            && (flags & 0x10) != 0) {
                        widget.aBoolean2042 = true;
                        if (widget.anObjectArray2019 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2019, null,
                                    127, -i_9_ + mousePositionX, widget,
                                    -i_10_ + Class33.mousePositionY);
                        }
                    }
                    if (widget.aBoolean2042 && bool_17_
                            && (flags & 0x40) != 0
                            && widget.anObjectArray2075 != null) {
                        ScriptExecutor.executeClientScript(0, widget.anObjectArray2075, null,
                                i_1_ - 122, mousePositionX - i_9_, widget,
                                Class33.mousePositionY - i_10_);
                    }
                    if (widget.aBoolean2042 && !bool_17_
                            && (flags & 0x20) != 0) {
                        widget.aBoolean2042 = false;
                        if (widget.anObjectArray2100 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2100, null,
                                    -44, -i_9_ + mousePositionX, widget,
                                    Class33.mousePositionY - i_10_);
                        }
                    }
                    if (widget.anObjectArray2016 != null
                            && (flags & 0x80) != 0) {
                        ScriptExecutor.executeClientScript(0,
                                (widget.anObjectArray2016),
                                null, 106, 0,
                                widget,
                                0);
                    }
                    if (bool_17_ && AudioHandler.anInt1107 != 0
                            && widget.anObjectArray2039 != null
                            && (flags & 0x400) != 0) {
                        ScriptExecutor.executeClientScript(0,
                                (widget.anObjectArray2039),
                                null, -86, 0,
                                widget,
                                AudioHandler.anInt1107);
                    }
                    if ((flags & 0x100) != 0) {
                        if (widget.anInt2012 < Class66.anInt1153
                                && widget.anObjectArray2101 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2101, null,
                                    -19, 0, widget, 0);
                        }
                        if ((Buffer.anInt1364
                                > widget.anInt2012)
                                && widget.anObjectArray2061 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2061, null,
                                    i_1_ ^ 0x7a, 0, widget, 0);
                        }
                        if (widget.anInt2012 < Client.anInt1269
                                && widget.anObjectArray2062 != null) {
                            ScriptExecutor.executeClientScript(0, widget.anObjectArray2062, null,
                                    123, 0, widget, 0);
                        }
                        widget.anInt2012 = Class2.logicCycle;
                    }
                }
            }
        }
        if (i_1_ != 1) {
            aByteArrayArrayArray1081 = null;
        }
    }

    public int getNextValue() {
        if (anInt1093-- == 0) {
            method1042(true);
            anInt1093 = 255;
        }
        return anIntArray1105[anInt1093];
    }

    public void method1040(int i) {
        if (i < 59) {
            aClass3_1097 = null;
        }
        int i_20_;
        int i_21_;
        int i_22_;
        int i_23_;
        int i_24_;
        int i_25_;
        int i_26_;
        int i_19_ = (i_20_ = i_21_ = i_22_ = i_23_ = i_24_ = i_25_ = i_26_ = -1640531527);
        for (int i_27_ = 0; i_27_ < 4; i_27_++) {
            i_19_ ^= i_20_ << 11;
            i_22_ += i_19_;
            i_20_ += i_21_;
            i_20_ ^= i_21_ >>> 2;
            i_23_ += i_20_;
            i_21_ += i_22_;
            i_21_ ^= i_22_ << 8;
            i_22_ += i_23_;
            i_24_ += i_21_;
            i_22_ ^= i_23_ >>> 16;
            i_25_ += i_22_;
            i_23_ += i_24_;
            i_23_ ^= i_24_ << 10;
            i_26_ += i_23_;
            i_24_ += i_25_;
            i_24_ ^= i_25_ >>> 4;
            i_25_ += i_26_;
            i_19_ += i_24_;
            i_25_ ^= i_26_ << 8;
            i_26_ += i_19_;
            i_20_ += i_25_;
            i_26_ ^= i_19_ >>> 9;
            i_21_ += i_26_;
            i_19_ += i_20_;
        }
        for (int i_28_ = 0; i_28_ < 256; i_28_ += 8) {
            i_21_ += anIntArray1105[i_28_ + 2];
            i_23_ += anIntArray1105[i_28_ + 4];
            i_19_ += anIntArray1105[i_28_];
            i_24_ += anIntArray1105[i_28_ + 5];
            i_25_ += anIntArray1105[i_28_ + 6];
            i_20_ += anIntArray1105[i_28_ + 1];
            i_19_ ^= i_20_ << 11;
            i_22_ += anIntArray1105[i_28_ + 3];
            i_22_ += i_19_;
            i_26_ += anIntArray1105[i_28_ + 7];
            i_20_ += i_21_;
            i_20_ ^= i_21_ >>> 2;
            i_21_ += i_22_;
            i_23_ += i_20_;
            i_21_ ^= i_22_ << 8;
            i_22_ += i_23_;
            i_22_ ^= i_23_ >>> 16;
            i_25_ += i_22_;
            i_24_ += i_21_;
            i_23_ += i_24_;
            i_23_ ^= i_24_ << 10;
            i_24_ += i_25_;
            i_26_ += i_23_;
            i_24_ ^= i_25_ >>> 4;
            i_19_ += i_24_;
            i_25_ += i_26_;
            i_25_ ^= i_26_ << 8;
            i_20_ += i_25_;
            i_26_ += i_19_;
            i_26_ ^= i_19_ >>> 9;
            i_19_ += i_20_;
            i_21_ += i_26_;
            anIntArray1102[i_28_] = i_19_;
            anIntArray1102[i_28_ + 1] = i_20_;
            anIntArray1102[i_28_ + 2] = i_21_;
            anIntArray1102[i_28_ + 3] = i_22_;
            anIntArray1102[i_28_ + 4] = i_23_;
            anIntArray1102[i_28_ + 5] = i_24_;
            anIntArray1102[i_28_ + 6] = i_25_;
            anIntArray1102[i_28_ + 7] = i_26_;
        }
        for (int i_29_ = 0; i_29_ < 256; i_29_ += 8) {
            i_20_ += anIntArray1102[i_29_ + 1];
            i_19_ += anIntArray1102[i_29_];
            i_21_ += anIntArray1102[i_29_ + 2];
            i_25_ += anIntArray1102[i_29_ + 6];
            i_19_ ^= i_20_ << 11;
            i_22_ += anIntArray1102[i_29_ + 3];
            i_26_ += anIntArray1102[i_29_ + 7];
            i_22_ += i_19_;
            i_23_ += anIntArray1102[i_29_ + 4];
            i_20_ += i_21_;
            i_20_ ^= i_21_ >>> 2;
            i_21_ += i_22_;
            i_21_ ^= i_22_ << 8;
            i_23_ += i_20_;
            i_24_ += anIntArray1102[i_29_ + 5];
            i_22_ += i_23_;
            i_22_ ^= i_23_ >>> 16;
            i_25_ += i_22_;
            i_24_ += i_21_;
            i_23_ += i_24_;
            i_23_ ^= i_24_ << 10;
            i_24_ += i_25_;
            i_24_ ^= i_25_ >>> 4;
            i_19_ += i_24_;
            i_26_ += i_23_;
            i_25_ += i_26_;
            i_25_ ^= i_26_ << 8;
            i_26_ += i_19_;
            i_26_ ^= i_19_ >>> 9;
            i_21_ += i_26_;
            i_20_ += i_25_;
            i_19_ += i_20_;
            anIntArray1102[i_29_] = i_19_;
            anIntArray1102[i_29_ + 1] = i_20_;
            anIntArray1102[i_29_ + 2] = i_21_;
            anIntArray1102[i_29_ + 3] = i_22_;
            anIntArray1102[i_29_ + 4] = i_23_;
            anIntArray1102[i_29_ + 5] = i_24_;
            anIntArray1102[i_29_ + 6] = i_25_;
            anIntArray1102[i_29_ + 7] = i_26_;
        }
        method1042(true);
        anInt1093 = 256;
    }

    public static void method1041(boolean bool) {
        aClass3_1097 = null;
        aClass3_1090 = null;
        appearanceBuffers = null;
        aClass3_1086 = null;
        aByteArrayArrayArray1081 = null;
        aClass3_1092 = null;
        aClass3_1098 = null;
        aClass3_1082 = null;
        aClass3_1085 = null;
        aClass39_Sub5_Sub10_Sub3_1096 = null;
        aClass3_1103 = null;
        aClass3_1099 = null;
        aClass3_1094 = null;
    }

    public void method1042(boolean bool) {
        if (bool == true) {
            anInt1083 += ++anInt1088;
            for (int i = 0; i < 256; i++) {
                int i_30_ = anIntArray1102[i];
                if ((i & 0x2) != 0) {
                    if ((i & 0x1) != 0) {
                        anInt1101 ^= anInt1101 >>> 16;
                    } else {
                        anInt1101 ^= anInt1101 << 2;
                    }
                } else if ((i & 0x1) != 0) {
                    anInt1101 ^= anInt1101 >>> 6;
                } else {
                    anInt1101 ^= anInt1101 << 13;
                }
                anInt1101 += anIntArray1102[i + 128 & 0xff];
                int i_31_;
                anIntArray1102[i] = i_31_ = (anInt1101
                        + (anIntArray1102[Class34.and(1020, i_30_) >> 2]
                        + anInt1083));
                anIntArray1105[i] = anInt1083 = (anIntArray1102[Class34.and(i_31_, 261338) >> 8 >> 2]) + i_30_;
            }
        }
    }

    public static void method1043(int i) {
        TraversalMap.aClass57_514.method1006(i + 1540585344);
        if (i != -1540585334) {
            logout();
        }
        BufferedFile.aClass39_Sub5_Sub10_Sub4_350.method695(0, 0);
        Class53.anIntArray970 = TriangleRasterizer.method657(Class53.anIntArray970);
    }

    public static void logout() {
        if (Class37.gameSocket != null) {
            Class37.gameSocket.hault();
            Class37.gameSocket = null;
        }
        AudioHandler.method1045(false);
        Class44.world.method378();
        for (int i_32_ = 0; i_32_ < 4; i_32_++) {
            Class39_Sub5_Sub12.traversalMaps[i_32_].reset((byte) -110);
        }
        System.gc();
        Class41.method900((byte) -100, 10);
        ArchiveWorker.anInt1205 = -1;
        JSocket.anInt313 = 0;
        NpcDefinition.method723((byte) 115);
        Client.setState(10);
    }

    public ISAAC(int[] is) {
        anIntArray1102 = new int[256];
        for (int i = 0; i < is.length; i++) {
            anIntArray1105[i] = is[i];
        }
        method1040(102);
    }

    static {
        aClass3_1094 = JString.create("Error loading your profile)3");
        aClass3_1085 = aClass3_1097;
        aClass3_1092 = JString.create("Wen m-Ochten Sie von der Liste entfernen?");
        aBoolean1100 = false;
        aClass3_1082 = aClass3_1094;
        aClass3_1099 = JString.create("Enter object name");
        aBoolean1089 = false;
        aClass3_1098 = aClass3_1099;
        aClass3_1103 = JString.create("backleft1");
        aClass3_1086 = JString.create("(U4");
        mousePositionX = 0;
        chatboxWidgetId = -1;
        appearanceBuffers = new Buffer[2048];
    }
}
