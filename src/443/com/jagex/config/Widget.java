package com.jagex.config;

import com.jagex.utils.MsTimer;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.events.JMouseListener;
import com.jagex.awt.events.JKeyListener;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.graphics.BitmapFont;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.JImage;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import unpackaged.Class1;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub12;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class65;
import unpackaged.Class66;
import com.jagex.utils.MouseRecorder;
import com.jagex.utils.JRuntimeException;

/* Class39_Sub5_Sub17 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class Widget extends SubNode {

    public int scrollY;
    public static Cache varbitCache;
    public int anInt1996;
    public int anInt1997;
    public int anInt1998;
    public int anInt1999 = 0;
    public int itemOffsetX;
    public int[] conditionOpcodes;
    public static JString aClass3_2002;
    public int anInt2003;
    public Object[] anObjectArray2004;
    public static int[] anIntArray2005;
    public static int[] anIntArray2006;
    public int anInt2007;
    public int anInt2008;
    public int inactiveModelType;
    public int itemOffsetY;
    public int modelSineRotationX = 0;
    public int anInt2012;
    public boolean isNewFormat;
    public boolean aBoolean2014;
    public int height;
    public Object[] anObjectArray2016;
    public int[] conditionValues;
    public Object[] anObjectArray2018;
    public Object[] anObjectArray2019;
    public int anInt2020;
    public int displayOffsetY;
    public int anInt2022;
    public JString use;
    public int offsetY;
    public Widget[] children;
    public int inactiveAnimationModelId;
    public JString[] options;
    public int[] itemOffsetsX;
    public JString inactiveText;
    public int alpha;
    public static int anInt2031;
    public int anInt2032;
    public Object[] anObjectArray2033;
    public int activeSpriteId;
    public Object[] anObjectArray2035;
    public int anInt2036;
    public int[] itemOffsetsY;
    public boolean invertHorizontal;
    public Object[] anObjectArray2039;
    public Widget aClass39_Sub5_Sub17_2040;
    public int anInt2041;
    public boolean aBoolean2042;
    public JString[] itemOptions;
    public Object[] anObjectArray2044;
    public Object[] anObjectArray2045;
    public static JString aClass3_2046;
    public boolean aBoolean2047;
    public JString activeText;
    public int flags;
    public int anInt2050;
    public int anInt2051;
    public int anInt2052;
    public int[] defaultSpriteIds;
    public int activeAnimationModelId;
    public boolean aBoolean2055;
    public int anInt2056;
    public int anInt2057;
    public int anInt2058;
    public boolean drawShadow;
    public static FileLoader fileLoader9;
    public Object[] anObjectArray2061;
    public Object[] anObjectArray2062;
    public static int anInt2063;
    public int scrollX;
    public JString aClass3_2065;
    public JString aClass3_2066;
    public int activeColor;
    public JString aClass3_2068;
    public int anInt2069;
    public static JString aClass3_2070 = JString.create("oder benutzen Sie eine andere Welt)3");
    public static int anInt2071;
    public int anInt2072;
    public int[] itemAmounts;
    public int modelRotationY;
    public Object[] anObjectArray2075;
    public boolean drawSolidQuad;
    public int inactiveColor;
    public int anInt2078;
    public int anInt2079;
    public Object[] anObjectArray2080;
    public boolean aBoolean2081;
    public int activeAnimateType;
    public int anInt2083;
    public int id;
    public Object[] anObjectArray2085;
    public int anInt2086;
    public int[] itemIds;
    public Object[] anObjectArray2088;
    public int anInt2089;
    public int offsetX;
    public int displayOffsetX;
    public int[][] scriptOpcodes;
    public int unactiveSpriteId;
    public int type;
    public int anInt2095;
    public int anInt2096;
    public Object[] anObjectArray2097;
    public int modelCosineRotationX;
    public Object[] anObjectArray2099;
    public Object[] anObjectArray2100;
    public Object[] anObjectArray2101;
    public int amountChildren;
    public int anInt2103;
    public int width;
    public int fontId;
    public boolean aBoolean2106;
    public boolean invertVertical;
    public boolean aBoolean2108;
    public static int[] anIntArray2109;
    public static JString aClass3_2110;
    public static int[] anIntArray2111;
    public static int[] anIntArray2112;
    public static DirectColorSprite aClass39_Sub5_Sub10_Sub3_2113;
    public static AbstractImage aClass57_2114;
    public static AbstractImage aClass57_2115;
    public static boolean aBoolean2116;
    public static JString aClass3_2117;

    public boolean method750(int i) {
        if ((flags >> 21 & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public int method751() {
        return flags >> 11 & 0x3f;
    }

    public BitmapFont getFont() {
        Class39_Sub5_Sub12.aBoolean1856 = false;
        if (fontId == -1) {
            return null;
        }
        BitmapFont font = ((BitmapFont) Deque.fontCache.get((long) fontId));
        if (font != null) {
            return font;
        }
        font = Queue.createBitmapFont(Class37.aClass9_658, fontId, 0);
        if (font != null) {
            Deque.fontCache.put(font, (long) fontId);
        } else {
            Class39_Sub5_Sub12.aBoolean1856 = true;
        }
        return font;
    }

    public boolean method753(byte i) {
        if ((flags >> 28 & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public boolean method754(boolean bool) {
        if (bool) {
            if (flags != 0) {
                return false;
            }
            if (type == 0) {
                return false;
            }
        }
        return aBoolean2055;
    }

    public void decodeOldFormat(Buffer buffer) {
        isNewFormat = false;
        type = buffer.getUbyte();
        anInt2089 = buffer.getUbyte();
        anInt2078 = buffer.getUword();
        offsetX = displayOffsetX = buffer.getWord();
        offsetY = displayOffsetY = buffer.getWord();
        width = buffer.getUword();
        height = buffer.getUword();
        alpha = buffer.getUbyte();
        anInt2050 = buffer.getUword();
        if (anInt2050 == 65535) {
            anInt2050 = -1;
        } else {
            anInt2050 = anInt2050 + (id & ~0xffff);
        }
        anInt2057 = buffer.getUword();
        if (anInt2057 == 65535) {
            anInt2057 = -1;
        }
        int amountConditions = buffer.getUbyte();
        if (amountConditions > 0) {
            conditionOpcodes = new int[amountConditions];
            conditionValues = new int[amountConditions];
            for (int i_1_ = 0; amountConditions > i_1_; i_1_++) {
                conditionOpcodes[i_1_] = buffer.getUbyte();
                conditionValues[i_1_] = buffer.getUword();
            }
        }
        int amountOpcodes = buffer.getUbyte();
        if (amountOpcodes > 0) {
            scriptOpcodes = new int[amountOpcodes][];
            for (int i_3_ = 0; amountOpcodes > i_3_; i_3_++) {
                int i_4_ = buffer.getUword();
                scriptOpcodes[i_3_] = new int[i_4_];
                for (int i_5_ = 0; i_4_ > i_5_; i_5_++) {
                    scriptOpcodes[i_3_][i_5_] = buffer.getUword();
                    if (scriptOpcodes[i_3_][i_5_] == 65535) {
                        scriptOpcodes[i_3_][i_5_] = -1;
                    }
                }
            }
        }
        if (type == 0) {
            anInt2095 = buffer.getUword();
            aBoolean2055 = buffer.getUbyte() == 1;
        }
        if (type == 1) {
            buffer.getUword();
            buffer.getUbyte();
        }
        if (type == 2) {
            itemIds = new int[width * height];
            itemAmounts = new int[height * width];
            int i_6_ = buffer.getUbyte();
            if (i_6_ == 1) {
                flags |= 0x10000000;
            }
            int i_7_ = buffer.getUbyte();
            if (i_7_ == 1) {
                flags |= 0x40000000;
            }
            int i_8_ = buffer.getUbyte();
            if (i_8_ == 1) {
                flags |= ~0x7fffffff;
            }
            int i_9_ = buffer.getUbyte();
            if (i_9_ == 1) {
                flags |= 0x20000000;
            }
            itemOffsetX = buffer.getUbyte();
            itemOffsetY = buffer.getUbyte();
            itemOffsetsY = new int[20];
            itemOffsetsX = new int[20];
            defaultSpriteIds = new int[20];
            for (int i_10_ = 0; i_10_ < 20; i_10_++) {
                int i_11_ = buffer.getUbyte();
                if (i_11_ == 1) {
                    itemOffsetsX[i_10_] = buffer.getWord();
                    itemOffsetsY[i_10_] = buffer.getWord();
                    defaultSpriteIds[i_10_] = buffer.getDword();
                } else {
                    defaultSpriteIds[i_10_] = -1;
                }
            }
            itemOptions = new JString[5];
            for (int i = 0; i < 5; i++) {
                JString class3 = buffer.getJstr();
                if (class3.getLength() > 0) {
                    itemOptions[i] = class3;
                    flags |= 1 << i + 23;
                }
            }
        }
        if (type == 3) {
            drawSolidQuad = buffer.getUbyte() == 1;
        }
        if (type == 4 || type == 1) {
            anInt2032 = buffer.getUbyte();
            anInt1996 = buffer.getUbyte();
            anInt2036 = buffer.getUbyte();
            fontId = buffer.getUword();
            if (fontId == 65535) {
                fontId = -1;
            }
            drawShadow = buffer.getUbyte() == 1;
        }
        if (type == 4) {
            inactiveText = buffer.getJstr();
            activeText = buffer.getJstr();
        }
        if (type == 1 || type == 3 || type == 4) {
            inactiveColor = buffer.getDword();
        }
        if (type == 3 || type == 4) {
            activeColor = buffer.getDword();
            anInt2041 = buffer.getDword();
            anInt2086 = buffer.getDword();
        }
        if (type == 5) {
            unactiveSpriteId = buffer.getDword();
            activeSpriteId = buffer.getDword();
        }
        if (type == 6) {
            inactiveModelType = 1;
            inactiveAnimationModelId = buffer.getUword();
            activeAnimateType = 1;
            if (inactiveAnimationModelId == 65535) {
                inactiveAnimationModelId = -1;
            }
            activeAnimationModelId = buffer.getUword();
            if (activeAnimationModelId == 65535) {
                activeAnimationModelId = -1;
            }
            anInt2103 = buffer.getUword();
            if (anInt2103 == 65535) {
                anInt2103 = -1;
            }
            anInt2052 = buffer.getUword();
            if (anInt2052 == 65535) {
                anInt2052 = -1;
            }
            modelRotationY = buffer.getUword();
            modelCosineRotationX = buffer.getUword();
            modelSineRotationX = buffer.getUword();
        }
        if (type == 7) {
            itemAmounts = new int[height * width];
            itemIds = new int[height * width];
            anInt2032 = buffer.getUbyte();
            fontId = buffer.getUword();
            if (fontId == 65535) {
                fontId = -1;
            }
            drawShadow = buffer.getUbyte() == 1;
            inactiveColor = buffer.getDword();
            itemOffsetX = buffer.getWord();
            itemOffsetY = buffer.getWord();
            int i_13_ = buffer.getUbyte();
            itemOptions = new JString[5];
            if (i_13_ == 1) {
                flags |= 0x40000000;
            }
            for (int i_14_ = 0; i_14_ < 5; i_14_++) {
                JString jstr = buffer.getJstr();
                if (jstr.getLength() > 0) {
                    itemOptions[i_14_] = jstr;
                    flags |= 1 << 23 + i_14_;
                }
            }
        }
        if (type == 8) {
            inactiveText = buffer.getJstr();
        }
        if (anInt2089 == 2 || type == 2) {
            use = buffer.getJstr();
            aClass3_2066 = buffer.getJstr();
            int i_15_ = buffer.getUword() & 0x3f;
            flags |= i_15_ << 11;
        }
        if (anInt2089 == 1 || anInt2089 == 4 || anInt2089 == 5 || anInt2089 == 6) {
            aClass3_2068 = buffer.getJstr();
            if (aClass3_2068.getLength() == 0) {
                if (anInt2089 == 1) {
                    aClass3_2068 = Class23.okJstr;
                }
                if (anInt2089 == 4) {
                    aClass3_2068 = HashTable.selectJstr;
                }
                if (anInt2089 == 5) {
                    aClass3_2068 = HashTable.selectJstr;
                }
                if (anInt2089 == 6) {
                    aClass3_2068 = Timer.continueJstr;
                }
            }
        }
        if (anInt2089 == 1 || anInt2089 == 4 || anInt2089 == 5) {
            flags |= 0x400000;
        }
        if (anInt2089 == 6) {
            flags |= 0x1;
        }
        anInt1998 = flags;
    }

    public void method756(int i, JString class3, int i_16_) {
        if (options == null || i_16_ >= options.length) {
            JString[] class3s = new JString[i_16_ + 1];
            if (options != null) {
                for (int i_17_ = 0; i_17_ < options.length; i_17_++) {
                    class3s[i_17_] = options[i_17_];
                }
            }
            options = class3s;
        }
        options[i_16_] = class3;
    }

    public void decodeNewFormat(Buffer buffer) {
        buffer.getUbyte();
        isNewFormat = true;
        type = buffer.getUbyte();
        anInt2078 = buffer.getUword();
        offsetX = displayOffsetX = buffer.getWord();
        offsetY = displayOffsetY = buffer.getWord();
        width = buffer.getUword();
        if (type != 9) {
            height = buffer.getUword();
        } else {
            height = buffer.getWord();
        }
        anInt2050 = buffer.getUword();
        if (anInt2050 == 65535) {
            anInt2050 = -1;
        } else {
            anInt2050 = anInt2050 + (id & ~0xffff);
        }
        aBoolean2055 = buffer.getUbyte() == 1;
        if (type == 0) {
            anInt2020 = buffer.getUword();
            anInt2095 = buffer.getUword();
        }
        if (type == 5) {
            unactiveSpriteId = buffer.getDword();
            anInt2051 = buffer.getUword();
            aBoolean2014 = buffer.getUbyte() == 1;
            alpha = buffer.getUbyte();
            anInt2022 = buffer.getUbyte();
            anInt2003 = buffer.getDword();
            invertVertical = buffer.getUbyte() == 1;
            invertHorizontal = buffer.getUbyte() == 1;
        }
        if (type == 6) {
            inactiveModelType = 1;
            inactiveAnimationModelId = buffer.getUword();
            if (inactiveAnimationModelId == 65535) {
                inactiveAnimationModelId = -1;
            }
            anInt2072 = buffer.getWord();
            anInt2058 = buffer.getWord();
            modelCosineRotationX = buffer.getUword();
            modelSineRotationX = buffer.getUword();
            anInt2007 = buffer.getUword();
            modelRotationY = buffer.getUword();
            anInt2103 = buffer.getUword();
            if (anInt2103 == 65535) {
                anInt2103 = -1;
            }
            aBoolean2081 = buffer.getUbyte() == 1;
        }
        if (type == 4) {
            fontId = buffer.getUword();
            if (fontId == 65535) {
                fontId = -1;
            }
            inactiveText = buffer.getJstr();
            anInt2036 = buffer.getUbyte();
            anInt2032 = buffer.getUbyte();
            anInt1996 = buffer.getUbyte();
            drawShadow = buffer.getUbyte() == 1;
            inactiveColor = buffer.getDword();
        }
        if (type == 3) {
            inactiveColor = buffer.getDword();
            drawSolidQuad = buffer.getUbyte() == 1;
            alpha = buffer.getUbyte();
        }
        if (type == 9) {
            anInt2083 = buffer.getUbyte();
            inactiveColor = buffer.getDword();
        }
        flags = anInt1998 = buffer.getUtri();
        aClass3_2065 = buffer.getJstr();
        int i = buffer.getUbyte();
        if (i > 0) {
            options = new JString[i];
            for (int i_18_ = 0; i > i_18_; i_18_++) {
                options[i_18_] = buffer.getJstr();
            }
        }
        anInt2056 = buffer.getUbyte();
        anInt2008 = buffer.getUbyte();
        aBoolean2108 = buffer.getUbyte() == 1;
        use = buffer.getJstr();
        anObjectArray2033 = getScriptParams(buffer);
        anObjectArray2019 = getScriptParams(buffer);
        anObjectArray2100 = getScriptParams(buffer);
        anObjectArray2004 = getScriptParams(buffer);
        anObjectArray2099 = getScriptParams(buffer);
        anObjectArray2101 = getScriptParams(buffer);
        anObjectArray2061 = getScriptParams(buffer);
        anObjectArray2062 = getScriptParams(buffer);
        anObjectArray2016 = getScriptParams(buffer);
        anObjectArray2045 = getScriptParams(buffer);
        anObjectArray2075 = getScriptParams(buffer);
        anObjectArray2035 = getScriptParams(buffer);
        anObjectArray2044 = getScriptParams(buffer);
        anObjectArray2085 = getScriptParams(buffer);
        anObjectArray2080 = getScriptParams(buffer);
        anObjectArray2018 = getScriptParams(buffer);
        anObjectArray2088 = getScriptParams(buffer);
        anObjectArray2097 = getScriptParams(buffer);
        anObjectArray2039 = getScriptParams(buffer);
    }

    public boolean method758(int i) {
        if ((flags >> 31 & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public DirectColorSprite method759(int i, int i_19_) {
        Class39_Sub5_Sub12.aBoolean1856 = false;
        if ((i ^ 0xffffffff) > i_19_ || i >= defaultSpriteIds.length) {
            return null;
        }
        int i_20_ = defaultSpriteIds[i];
        if (i_20_ == -1) {
            return null;
        }
        DirectColorSprite class39_sub5_sub10_sub3 = ((DirectColorSprite) AbstractMidiHandler.spriteCache.get((long) i_20_));
        if (class39_sub5_sub10_sub3 != null) {
            return class39_sub5_sub10_sub3;
        }
        class39_sub5_sub10_sub3 = PlayerApperance.loadSprite(Class37.aClass9_658, 0, i_20_);
        if (class39_sub5_sub10_sub3 == null) {
            Class39_Sub5_Sub12.aBoolean1856 = true;
        } else {
            AbstractMidiHandler.spriteCache.put(class39_sub5_sub10_sub3,
                    (long) i_20_);
        }
        return class39_sub5_sub10_sub3;
    }

    public void swapItem(int i, int i_21_) {
        int i_23_ = itemIds[i_21_];
        itemIds[i_21_] = itemIds[i];
        itemIds[i] = i_23_;
        i_23_ = itemAmounts[i_21_];
        itemAmounts[i_21_] = itemAmounts[i];
        itemAmounts[i] = i_23_;
    }

    public static void method761(byte i) {
        if (i != 45) {
            aBoolean2116 = true;
        }
        VarbitDefinition.method597(103);
        if (Class39_Sub5_Sub7.minimapState == 2) {
            byte[] is = Class47.aClass39_Sub5_Sub10_Sub4_891.index;
            int i_24_ = is.length;
            int[] is_25_ = DrawingArea.buffer;
            for (int i_26_ = 0; i_24_ > i_26_; i_26_++) {
                if (is[i_26_] == 0) {
                    is_25_[i_26_] = 0;
                }
            }
            AbstractFileLoader.aClass39_Sub5_Sub10_Sub3_141.method688(0, 0, 33, 33, 25, 25,
                    Class34.anInt605,
                    256,
                    (MsTimer.anIntArray1564),
                    anIntArray2109);
            Class66.method1104(false);
        } else {
            int i_27_ = Class34.anInt605 + ArchiveRequest.anInt1401 & 0x7ff;
            int i_28_ = 464 - Cache.localPlayer.fPositionX / 32;
            int i_29_ = 48 + Cache.localPlayer.fPositionY / 32;
            Class39_Sub5_Sub4_Sub2.aClass39_Sub5_Sub10_Sub3_2219.method688(25, 5, 146, 151, i_29_, i_28_, i_27_,
                    ClassCheckRequest.anInt1386 + 256, BufferedFile.anIntArray345,
                    Class32.anIntArray586);
            for (int i_30_ = 0; i_30_ < Deque.anInt915; i_30_++) {
                i_29_ = (MsTimer.anIntArray1549[i_30_] * 4
                        - Cache.localPlayer.fPositionY / 32
                        + 2);
                i_28_ = -(Cache.localPlayer.fPositionX
                        / 32) + 2 + anIntArray2111[i_30_] * 4;
                Player.method528(i_28_, MouseRecorder.aClass39_Sub5_Sub10_Sub3Array560[i_30_],
                        i_29_, 10064);
            }
            for (int i_31_ = 0; i_31_ < 104; i_31_++) {
                for (int i_32_ = 0; i_32_ < 104; i_32_++) {
                    Deque class49 = (Class20.groundItems[NameTable.height][i_31_][i_32_]);
                    if (class49 != null) {
                        i_29_ = -((Cache.localPlayer.fPositionY)
                                / 32) + (i_31_ * 4 + 2);
                        i_28_ = -((Cache.localPlayer.fPositionX)
                                / 32) + 2 + i_32_ * 4;
                        Player.method528(i_28_,
                                (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986[0]),
                                i_29_, 10064);
                    }
                }
            }
            for (int i_33_ = 0; i_33_ < ArchiveWorker.anInt1210; i_33_++) {
                Npc class39_sub5_sub4_sub4_sub1 = (GroundItem.npcs[Entity.anIntArray1734[i_33_]]);
                if (class39_sub5_sub4_sub4_sub1 != null
                        && class39_sub5_sub4_sub4_sub1.method510((byte) -77)) {
                    NpcDefinition class39_sub5_sub13 = class39_sub5_sub4_sub4_sub1.definition;
                    if (class39_sub5_sub13.anIntArray1878 != null) {
                        class39_sub5_sub13 = class39_sub5_sub13.method721(5585);
                    }
                    if (class39_sub5_sub13 != null
                            && class39_sub5_sub13.aBoolean1888
                            && class39_sub5_sub13.aBoolean1886) {
                        i_29_ = (-((Cache.localPlayer.fPositionY)
                                / 32)
                                + class39_sub5_sub4_sub4_sub1.fPositionY / 32);
                        i_28_ = (class39_sub5_sub4_sub4_sub1.fPositionX / 32
                                - (Cache.localPlayer.fPositionX) / 32);
                        Player.method528(i_28_,
                                (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986[1]),
                                i_29_, 10064);
                    }
                }
            }
            for (int i_34_ = 0; i_34_ < TraversalMap.anInt515; i_34_++) {
                Player class39_sub5_sub4_sub4_sub2 = (Class14.players[Class1.anIntArray40[i_34_]]);
                if (class39_sub5_sub4_sub4_sub2 != null
                        && class39_sub5_sub4_sub4_sub2.method510((byte) -77)) {
                    i_29_ = (class39_sub5_sub4_sub4_sub2.fPositionY / 32
                            - (Cache.localPlayer.fPositionY
                            / 32));
                    i_28_ = (class39_sub5_sub4_sub4_sub2.fPositionX / 32
                            - (Cache.localPlayer.fPositionX
                            / 32));
                    boolean bool = false;
                    long l = class39_sub5_sub4_sub4_sub2.aClass3_2521.encodeBase37();
                    for (int i_35_ = 0; i_35_ < Class4.anInt62; i_35_++) {
                        if (JApplet.aLongArray2[i_35_] == l
                                && (Player.anIntArray2533[i_35_]) != 0) {
                            bool = true;
                            break;
                        }
                    }
                    boolean bool_36_ = false;
                    if (Cache.localPlayer.anInt2526 != 0
                            && class39_sub5_sub4_sub4_sub2.anInt2526 != 0
                            && (Cache.localPlayer.anInt2526
                            == class39_sub5_sub4_sub4_sub2.anInt2526)) {
                        bool_36_ = true;
                    }
                    if (bool) {
                        Player.method528(i_28_,
                                (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986[3]),
                                i_29_, 10064);
                    } else if (bool_36_) {
                        Player.method528(i_28_,
                                (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986[4]),
                                i_29_, i + 10019);
                    } else {
                        Player.method528(i_28_,
                                (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986[2]),
                                i_29_, i + 10019);
                    }
                }
            }
            if (JMouseListener.anInt787 != 0 && Class2.logicCycle % 20 < 10) {
                if (JMouseListener.anInt787 == 1 && Class30.anInt542 >= 0
                        && ((GroundItem.npcs).length
                        > Class30.anInt542)) {
                    Npc class39_sub5_sub4_sub4_sub1 = (GroundItem.npcs[Class30.anInt542]);
                    if (class39_sub5_sub4_sub4_sub1 != null) {
                        i_28_ = (class39_sub5_sub4_sub4_sub1.fPositionX / 32
                                - (Cache.localPlayer.fPositionX) / 32);
                        i_29_ = (-((Cache.localPlayer.fPositionY)
                                / 32)
                                + class39_sub5_sub4_sub4_sub1.fPositionY / 32);
                        Projectile.method494(13552,
                                Wall.aClass39_Sub5_Sub10_Sub3Array648[1],
                                i_29_, i_28_);
                    }
                }
                if (JMouseListener.anInt787 == 2) {
                    i_28_ = ((Class25.anInt471 - JKeyListener.anInt618) * 4 + 2
                            - (Cache.localPlayer.fPositionX
                            / 32));
                    i_29_ = ((-Class65.anInt1145 + JString.anInt1229) * 4 + 2
                            - (Cache.localPlayer.fPositionY
                            / 32));
                    Projectile.method494(i + 13507,
                            Wall.aClass39_Sub5_Sub10_Sub3Array648[1], i_29_,
                            i_28_);
                }
                if (JMouseListener.anInt787 == 10 && Class34.anInt607 >= 0
                        && (Class14.players.length
                        > Class34.anInt607)) {
                    Player class39_sub5_sub4_sub4_sub2 = (Class14.players[Class34.anInt607]);
                    if (class39_sub5_sub4_sub4_sub2 != null) {
                        i_29_ = (class39_sub5_sub4_sub4_sub2.fPositionY / 32
                                - (Cache.localPlayer.fPositionY) / 32);
                        i_28_ = (class39_sub5_sub4_sub4_sub2.fPositionX / 32
                                - (Cache.localPlayer.fPositionX) / 32);
                        Projectile.method494(13552,
                                Wall.aClass39_Sub5_Sub10_Sub3Array648[1],
                                i_29_, i_28_);
                    }
                }
            }
            if (Class30.anInt544 != 0) {
                i_29_ = -(Cache.localPlayer.fPositionY
                        / 32) + (Class30.anInt544 * 4 + 2);
                i_28_ = (ArchiveRequest.anInt1407 * 4
                        - Cache.localPlayer.fPositionX / 32
                        + 2);
                Player.method528(i_28_, Wall.aClass39_Sub5_Sub10_Sub3Array648[0], i_29_,
                        10064);
            }
            DrawingArea.drawQuad(97, 78, 3, 3, 16777215);
            AbstractFileLoader.aClass39_Sub5_Sub10_Sub3_141.method688(0, 0, 33, 33, 25, 25,
                    Class34.anInt605,
                    256,
                    (MsTimer.anIntArray1564),
                    anIntArray2109);
            Class66.method1104(false);
        }
    }

    public JString method762(boolean bool) {
        if (method751() == 0) {
            return null;
        }
        if (use == null
                || use.method69().getLength() == 0) {
            if (bool) {
                return TraversalMap.hiddenUseJstr;
            }
            return null;
        }
        return use;
    }

    public static void method763(int i) {
        if (i == -4322) {
            for (int i_37_ = 0; i_37_ < JImage.anInt1586; i_37_++) {
                int i_38_ = ArchiveRequest.anIntArray1400[i_37_];
                Npc npc = (GroundItem.npcs[i_38_]);
                int i_39_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                if ((i_39_ & 0x2) != 0) {
                    npc.anInt2316 = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    npc.anInt2300 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                }
                if ((i_39_ & 0x20) != 0) {
                    int i_40_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                    int i_41_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                    if (i_40_ == 65535) {
                        i_40_ = -1;
                    }
                    if (npc.anInt2268 == i_40_
                            && i_40_ != -1) {
                        int i_42_ = (AbstractMidiHandler.method1064(i_40_, (byte) 54).anInt1830);
                        if (i_42_ == 1) {
                            npc.anInt2291 = 0;
                            npc.anInt2305 = i_41_;
                            npc.anInt2265 = 0;
                            npc.anInt2311 = 0;
                        }
                        if (i_42_ == 2) {
                            npc.anInt2291 = 0;
                        }
                    } else if (i_40_ == -1
                            || npc.anInt2268 == -1
                            || ((AbstractMidiHandler.method1064(i_40_, (byte) 54).anInt1826)
                            >= (AbstractMidiHandler.method1064(npc.anInt2268,
                            (byte) 54).anInt1826))) {
                        npc.anInt2305 = i_41_;
                        npc.anInt2311 = 0;
                        npc.anInt2291 = 0;
                        npc.anInt2254 = npc.anInt2312;
                        npc.anInt2265 = 0;
                        npc.anInt2268 = i_40_;
                    }
                }
                if ((i_39_ & 0x40) != 0) {
                    int i_43_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                    int i_44_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                    npc.method513(i + 4241, Class2.logicCycle, i_43_, i_44_);
                    npc.anInt2252 = Class2.logicCycle + 300;
                    npc.anInt2318 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                    npc.anInt2269 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                }
                if ((i_39_ & 0x4) != 0) {
                    npc.anInt2270 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                    int i_45_ = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
                    npc.anInt2288 = i_45_ >> 16;
                    npc.anInt2276 = 0;
                    if (npc.anInt2270 == 65535) {
                        npc.anInt2270 = -1;
                    }
                    npc.anInt2304 = 0;
                    npc.anInt2272 = (i_45_ & 0xffff) + Class2.logicCycle;
                    if (Class2.logicCycle < npc.anInt2272) {
                        npc.anInt2276 = -1;
                    }
                }
                if ((i_39_ & 0x10) != 0) {
                    npc.anInt2260 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
                    if (npc.anInt2260 == 65535) {
                        npc.anInt2260 = -1;
                    }
                }
                if ((i_39_ & 0x80) != 0) {
                    int i_46_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                    int i_47_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                    npc.method513(i + 4425, Class2.logicCycle, i_46_, i_47_);
                    npc.anInt2252 = Class2.logicCycle + 300;
                    npc.anInt2318 = Class39_Sub5_Sub11.incomingBuffer.getUbyte();
                    npc.anInt2269 = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                }
                if ((i_39_ & 0x1) != 0) {
                    npc.definition = ArchiveWorker.getNpcDefinition(Class39_Sub5_Sub11.incomingBuffer.getUwordLe());
                    npc.anInt2317 = (npc.definition.anInt1887);
                    npc.anInt2280 = (npc.definition.anInt1875);
                    npc.anInt2282 = (npc.definition.anInt1879);
                    npc.anInt2264 = (npc.definition.anInt1861);
                    npc.anInt2262 = (npc.definition.anInt1877);
                    npc.anInt2263 = (npc.definition.anInt1872);
                    npc.anInt2250 = (npc.definition.anInt1882);
                    npc.anInt2257 = (npc.definition.anInt1863);
                    npc.anInt2297 = (npc.definition.anInt1870);
                }
                if ((i_39_ & 0x8) != 0) {
                    npc.aClass3_2295 = Class39_Sub5_Sub11.incomingBuffer.getJstr();
                    npc.anInt2259 = 100;
                }
            }
        }
    }

    public static DirectColorSprite[] method764(int i) {
        DirectColorSprite[] class39_sub5_sub10_sub3s = new DirectColorSprite[JSocket.anInt302];
        for (int i_48_ = 0; i_48_ < JSocket.anInt302; i_48_++) {
            DirectColorSprite class39_sub5_sub10_sub3 = (class39_sub5_sub10_sub3s[i_48_] = new DirectColorSprite());
            class39_sub5_sub10_sub3.anInt2475 = Class13.anInt203;
            class39_sub5_sub10_sub3.anInt2477 = Class39_Sub5_Sub12.anInt1854;
            class39_sub5_sub10_sub3.anInt2473 = MsTimer.anIntArray1548[i_48_];
            class39_sub5_sub10_sub3.anInt2472 = SubNode.anIntArray1352[i_48_];
            class39_sub5_sub10_sub3.width = Class39_Sub5_Sub9.anIntArray1799[i_48_];
            class39_sub5_sub10_sub3.height = Class39_Sub14.anIntArray1512[i_48_];
            int i_49_ = (class39_sub5_sub10_sub3.height
                    * class39_sub5_sub10_sub3.width);
            byte[] is = TraversalMap.aByteArrayArray517[i_48_];
            class39_sub5_sub10_sub3.pixelBuffer = new int[i_49_];
            for (int i_50_ = 0; i_49_ > i_50_; i_50_++) {
                class39_sub5_sub10_sub3.pixelBuffer[i_50_] = StillObject.anIntArray1460[Class34.and(is[i_50_],
                        255)];
            }
        }
        JRuntimeException.method1123();
        return class39_sub5_sub10_sub3s;
    }

    public static void method765(byte i) {
        aClass57_2115 = null;
        fileLoader9 = null;
        anIntArray2109 = null;
        anIntArray2006 = null;
        aClass3_2070 = null;
        anIntArray2111 = null;
        aClass3_2117 = null;
        anIntArray2005 = null;
        aClass3_2110 = null;
        aClass57_2114 = null;
        varbitCache = null;
        aClass3_2046 = null;
        anIntArray2112 = null;
        aClass3_2002 = null;
        aClass39_Sub5_Sub10_Sub3_2113 = null;
    }

    public Object[] getScriptParams(Buffer buffer) {
        int amountParams = buffer.getUbyte();
        if (amountParams == 0) {
            return null;
        }
        Object[] params = new Object[amountParams];
        for (int i = 0; i < amountParams; i++) {
            int type = buffer.getUbyte();
            if (type != 0) {
                if (type == 1) {
                    params[i] = buffer.getJstr();
                }
            } else {
                params[i] = new Integer(buffer.getDword());
            }
        }
        aBoolean2047 = true;
        return params;
    }

    public Widget method767(byte i) {
        int i_54_ = (flags & 0xed60d) >> 17;
        if (i_54_ == 0) {
            return null;
        }
        Widget class39_sub5_sub17_55_ = this;
        for (int i_56_ = 0; i_56_ < i_54_; i_56_++) {
            class39_sub5_sub17_55_ = Class37.getWidget(class39_sub5_sub17_55_.anInt2050);
            if (class39_sub5_sub17_55_ == null) {
                return null;
            }
        }
        return class39_sub5_sub17_55_;
    }

    public boolean method768(int i) {
        if ((flags & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public boolean displayItemOptions() {
        if ((flags & 0x542c2685) >> 30 == 0) {
            return false;
        }
        return true;
    }

    public boolean getOptionActive(int i_57_) {
        if ((flags >> i_57_ + 1 & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public JString method771(boolean bool, byte i, int optionId) {
        if (!getOptionActive(optionId)) {
            return null;
        }
        if (options == null || options.length <= optionId || options[optionId] == null || (options[optionId].method69().getLength() == 0)) {
            if (bool) {
                return (Class39_Sub5_Sub11.join(new JString[]{MouseRecorder.aClass3_558, AbstractImage.toJstr(optionId)}));
            }
            return null;
        }
        return options[optionId];
    }

    public boolean method772(boolean bool) {
        if ((flags & 0x1c8f57) >> 20 == 0) {
            return false;
        }
        return true;
    }

    public boolean replaceSwap() {
        if ((flags >> 29 & 0x1) == 0) {
            return false;
        }
        return true;
    }

    public DirectColorSprite getSprite(boolean isActive) {
        Class39_Sub5_Sub12.aBoolean1856 = false;
        int id;
        if (!isActive) {
            id = unactiveSpriteId;
        } else {
            id = activeSpriteId;
        }
        if (-1 == id) {
            return null;
        }
        long l = (((long) anInt2022 << 36) + (long) id - (-((invertVertical ? 1L : 0L) << 38) + (-((invertHorizontal ? 1L : 0L) << 39) - ((long) anInt2003 << 40))));
        DirectColorSprite sprite = ((DirectColorSprite) AbstractMidiHandler.spriteCache.get(l));
        if (sprite != null) {
            return sprite;
        }
        sprite = PlayerApperance.loadSprite(Class37.aClass9_658, 0, id);
        if (sprite == null) {
            Class39_Sub5_Sub12.aBoolean1856 = true;
            return null;
        }
        if (invertVertical) {
            sprite.invertVertical();
        }
        if (invertHorizontal) {
            sprite.invertHorizontal();
        }
        if (anInt2022 > 0) {
            sprite.method673(anInt2022);
        }
        if (anInt2022 >= 1) {
            sprite.fill(1);
        }
        if (anInt2022 >= 2) {
            sprite.fill(16777215);
        }
        if (anInt2003 != 0) {
            sprite.method672(anInt2003);
        }
        AbstractMidiHandler.spriteCache.put(sprite, l);
        return sprite;
    }

    public Model method775(int i, int i_61_, boolean isActive, PlayerApperance class45,
            Class39_Sub5_Sub11 class39_sub5_sub11) {
        Class39_Sub5_Sub12.aBoolean1856 = false;
        int modelId;
        int type;
        if (isActive) {
            modelId = activeAnimationModelId;
            type = activeAnimateType;
        } else {
            modelId = inactiveAnimationModelId;
            type = inactiveModelType;
        }
        if (type == 0) {
            return null;
        }
        if (type == 1 && modelId == -1) {
            return null;
        }
        Model model = ((Model) Class2.widgetModelCache.get((long) ((type << 16) + modelId)));
        if (model == null) {
            if (type == 1) {
                model = Model.getModel(Huffman.aClass9_760, modelId, 0);
                if (model == null) {
                    Class39_Sub5_Sub12.aBoolean1856 = true;
                    return null;
                }
                model.initializeTriAndVertexGroups();
                model.applyLightingVector(64, 768, -50, -10, -50, true);
            }
            if (type == 2) {
                model = ArchiveWorker.getNpcDefinition(modelId).getModel(0);
                if (model == null) {
                    Class39_Sub5_Sub12.aBoolean1856 = true;
                    return null;
                }
                model.initializeTriAndVertexGroups();
                model.applyLightingVector(64, 768, -50, -10, -50, true);
            }
            if (type == 3) {
                if (class45 == null) {
                    return null;
                }
                model = class45.method924(1);
                if (model == null) {
                    Class39_Sub5_Sub12.aBoolean1856 = true;
                    return null;
                }
                model.initializeTriAndVertexGroups();
                model.applyLightingVector(64, 768, -50, -10, -50, true);
            }
            if (type == 4) {
                ItemDefinition itemDefinition = Class26.getItemDefinition(modelId);
                model = itemDefinition.getModel(10, false, (byte) -113);
                if (model == null) {
                    Class39_Sub5_Sub12.aBoolean1856 = true;
                    return null;
                }
                model.initializeTriAndVertexGroups();
                model.applyLightingVector((itemDefinition.anInt1647 + 64), (itemDefinition.anInt1673 + 768), -50, -10, -50, true);
            }
            Class2.widgetModelCache.put(model, (long) (modelId + (type << 16)));
        }
        if (class39_sub5_sub11 != null) {
            model = class39_sub5_sub11.method706(-2058442128,
                    model, i_61_);
        }
        return model;
    }

    public Widget() {
        anInt1997 = -1;
        itemOffsetY = 0;
        anInt2003 = 0;
        anInt1996 = 0;
        anInt2020 = 0;
        inactiveText = GouraudVertex.aClass3_905;
        anInt2008 = 0;
        anInt2041 = 0;
        anInt2022 = 0;
        scrollY = 0;
        anInt2036 = 0;
        use = GouraudVertex.aClass3_905;
        offsetY = 0;
        anInt2032 = 0;
        aBoolean2042 = false;
        height = 0;
        anInt2050 = -1;
        anInt2007 = 0;
        isNewFormat = false;
        aClass3_2065 = GouraudVertex.aClass3_905;
        drawShadow = false;
        alpha = 0;
        aBoolean2047 = false;
        anInt2057 = -1;
        activeColor = 0;
        scrollX = 0;
        anInt2052 = -1;
        modelRotationY = 100;
        itemOffsetX = 0;
        drawSolidQuad = false;
        anInt2079 = 0;
        anInt2078 = 0;
        inactiveColor = 0;
        anInt2051 = 0;
        flags = 0;
        activeAnimationModelId = -1;
        offsetX = 0;
        id = -1;
        anInt2056 = 0;
        aClass3_2066 = GouraudVertex.aClass3_905;
        anInt1998 = 0;
        activeSpriteId = -1;
        anInt2058 = 0;
        inactiveModelType = 1;
        activeAnimateType = 1;
        anInt2012 = -1;
        anInt2086 = 0;
        anInt2096 = 0;
        anInt2095 = 0;
        anInt2089 = 0;
        activeText = GouraudVertex.aClass3_905;
        aBoolean2055 = false;
        anInt2072 = 0;
        inactiveAnimationModelId = -1;
        unactiveSpriteId = -1;
        displayOffsetY = 0;
        aClass3_2068 = Class23.okJstr;
        displayOffsetX = 0;
        aBoolean2081 = false;
        anInt2069 = 0;
        modelCosineRotationX = 0;
        anInt2103 = -1;
        aClass39_Sub5_Sub17_2040 = null;
        fontId = -1;
        aBoolean2014 = false;
        width = 0;
        aBoolean2106 = false;
        amountChildren = -1;
        anInt2083 = 1;
        aBoolean2108 = false;
    }

    static {
        aClass3_2046 = JString.create("Accept challenge");
        aClass3_2002 = aClass3_2046;
        anInt2031 = 0;
        anInt2071 = -1;
        anIntArray2005 = new int[]{1, 2, 4, 8};
        varbitCache = new Cache(64);
        anIntArray2112 = new int[4000];
        aClass3_2110 = JString.create(" )2> @whi@");
        anIntArray2111 = new int[1000];
        aBoolean2116 = false;
        aClass3_2117 = JString.create("(U3");
    }
}
