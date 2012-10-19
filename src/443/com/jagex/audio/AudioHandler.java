package com.jagex.audio;

import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.FileLoader;
import com.jagex.awt.JApplet;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import unpackaged.Class1;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import com.jagex.graphics.TriangleRasterizer;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.Class47;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import com.jagex.script.ScriptState;
import unpackaged.TextureLoaderImpl;
import com.jagex.config.Widget;
import com.jagex.script.ScriptExecutor;

/* Class62 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public abstract class AudioHandler {

    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array1106;
    public static int anInt1107;
    public static JString aClass3_1108;
    public static JString aClass3_1109;
    public static JString aClass3_1110;
    public static JString aClass3_1111 = JString.create("The server is being updated)3");
    public static boolean aBoolean1112;
    public static JString aClass3_1113;
    public static JString aClass3_1114 = JString.create("Bitte entfernen Sie ");
    public static JString aClass3_1115;
    public static JString aClass3_1116;

    public static void method1045(boolean bool) {
        Class47.method949(-5794);
        FrameBuffer.method840();
        Class66.method1103(256);
        Class43.method905(3090);
        Huffman.method887((byte) 112);
        Class14.method208(true);
        Class67.method1107(-46);
        Class34.method341(bool);
        Class63.method1085(84);
        Class39_Sub5_Sub9.method604(false);
        Buffer.method787(3);
        ScriptState.method277(bool);
        ((TextureLoaderImpl) TriangleRasterizer.textureLoader).method1002(94);
        PlayerApperance.clientScriptCache.clear();
        Buffer.fileLoader0.removeAllFileBuffers();
        Class15.fileLoader1.removeAllFileBuffers();
        Node.fileLoader3.removeAllFileBuffers();
        Node.fileLoader4.removeAllFileBuffers();
        JSocket.fileLoader5.removeAllFileBuffers();
        Projectile.fileLoader6.removeAllFileBuffers();
        PlayerApperance.fileLoader7.removeAllFileBuffers();
        TraversalMap.fileLoader8.removeAllFileBuffers();
        Widget.fileLoader9.removeAllFileBuffers();
        Class66.fileLoader10.removeAllFileBuffers();
        Wall.fileLoader11.removeAllFileBuffers();
        Class33.fileLoader12.removeAllFileBuffers();
    }

    public static void method1046(byte i) {
        if (i != 22) {
            aClass3_1109 = null;
        }
        if (NpcDefinition.aClass39_Sub5_Sub17_1864 != null) {
            Widget class39_sub5_sub17 = NpcDefinition.aClass39_Sub5_Sub17_1864;
            Widget class39_sub5_sub17_0_ = Class44.method914(class39_sub5_sub17, (byte) -123);
            if (class39_sub5_sub17_0_ == null) {
                NpcDefinition.aClass39_Sub5_Sub17_1864 = null;
            } else {
                JApplet.anInt8++;
                int[] is = Class65.method1094(-6622, class39_sub5_sub17_0_);
                int[] is_1_ = Class65.method1094(i ^ ~0x19cb, class39_sub5_sub17);
                int i_2_ = ISAAC.mousePositionX - ItemDefinition.anInt1684;
                int i_3_ = -FileLoader.anInt1303 + Class33.mousePositionY;
                if (class39_sub5_sub17.anInt2056 >= i_2_
                        && i_2_ >= -class39_sub5_sub17.anInt2056
                        && class39_sub5_sub17.anInt2056 >= i_3_
                        && i_3_ >= -class39_sub5_sub17.anInt2056
                        && !Class37.aBoolean654) {
                    i_3_ = 0;
                    i_2_ = 0;
                } else if (class39_sub5_sub17.anInt2008 < JApplet.anInt8
                        || Class37.aBoolean654) {
                    Class37.aBoolean654 = true;
                } else {
                    i_3_ = 0;
                    i_2_ = 0;
                }
                int i_4_ = i_2_ + (is_1_[0] - is[0]);
                int i_5_ = i_3_ + (is_1_[1] - is[1]);
                if (i_5_ < 0) {
                    i_5_ = 0;
                }
                if (i_4_ < 0) {
                    i_4_ = 0;
                }
                if (class39_sub5_sub17_0_.height
                        < class39_sub5_sub17.height + i_5_) {
                    i_5_ = (-class39_sub5_sub17.height
                            + class39_sub5_sub17_0_.height);
                }
                if (class39_sub5_sub17_0_.width
                        < i_4_ + class39_sub5_sub17.width) {
                    i_4_ = (-class39_sub5_sub17.width
                            + class39_sub5_sub17_0_.width);
                }
                if ((NpcDefinition.aClass39_Sub5_Sub17_1864.anObjectArray2018) != null
                        && Class37.aBoolean654) {
                    ScriptExecutor.executeClientScript(0,
                            (class39_sub5_sub17.anObjectArray2018),
                            null, i - 63, i_4_,
                            class39_sub5_sub17, i_5_);
                }
                if (Class30.anInt541 == 0) {
                    if (Class37.aBoolean654) {
                        int i_6_ = -is[1] + Class33.mousePositionY;
                        int i_7_ = -is[0] + ISAAC.mousePositionX;
                        if (i_6_ < 0) {
                            i_6_ = 0;
                        }
                        if (i_7_ < 0) {
                            i_7_ = 0;
                        }
                        if (i_7_ > class39_sub5_sub17_0_.width - 1) {
                            i_7_ = class39_sub5_sub17_0_.width - 1;
                        }
                        if (i_6_ > class39_sub5_sub17_0_.height - 1) {
                            i_6_ = class39_sub5_sub17_0_.height - 1;
                        }
                        Widget widget = (GroundItem.method504(i_7_, i_6_, i - 22, class39_sub5_sub17,
                                class39_sub5_sub17_0_));
                        if ((NpcDefinition.aClass39_Sub5_Sub17_1864.anObjectArray2088)
                                != null) {
                            ScriptExecutor.executeClientScript(0, class39_sub5_sub17.anObjectArray2088,
                                    widget, 122, i_4_,
                                    class39_sub5_sub17, i_5_);
                        }
                        if (widget != null
                                && (class39_sub5_sub17.method767((byte) 120)
                                != null)) {
                            FrameBuffer.outgoingBuffer.putFrame(46);
                            FrameBuffer.outgoingBuffer.putWordLe128(widget.amountChildren);
                            FrameBuffer.outgoingBuffer.putWordLe128(class39_sub5_sub17.amountChildren);
                            FrameBuffer.outgoingBuffer.putDwordLe(widget.id);
                            FrameBuffer.outgoingBuffer.putDwordB(class39_sub5_sub17.id);
                        }
                    } else {
                        if ((NpcDefinition.aClass39_Sub5_Sub17_1864.anObjectArray2097)
                                != null) {
                            ScriptExecutor.executeClientScript(0, class39_sub5_sub17.anObjectArray2097, null,
                                    126, i_4_, class39_sub5_sub17, i_5_);
                        }
                        if ((PlayerApperance.anInt868 != 1
                                && !Class33.method327((Class39_Sub5_Sub11.actionOffset) - 1,
                                (byte) -128))
                                || Class39_Sub5_Sub11.actionOffset <= 2) {
                            if (Class39_Sub5_Sub11.actionOffset > 0) {
                                ScriptState.handleMenuAction((Class39_Sub5_Sub11.actionOffset
                                        - 1),
                                        1);
                            }
                        } else {
                            Class39_Sub5_Sub9.method607(701);
                        }
                    }
                    NpcDefinition.aClass39_Sub5_Sub17_1864 = null;
                }
            }
        }
    }

    public abstract void destroy();

    public abstract void method1048(boolean bool);

    public static void method1049(byte i) {
        for (int i_9_ = -1; TraversalMap.anInt515 > i_9_; i_9_++) {
            int i_10_;
            if (i_9_ == -1) {
                i_10_ = 2047;
            } else {
                i_10_ = Class1.anIntArray40[i_9_];
            }
            Player class39_sub5_sub4_sub4_sub2 = Class14.players[i_10_];
            if (class39_sub5_sub4_sub4_sub2 != null
                    && class39_sub5_sub4_sub4_sub2.anInt2259 > 0) {
                class39_sub5_sub4_sub4_sub2.anInt2259--;
                if (class39_sub5_sub4_sub4_sub2.anInt2259 == 0) {
                    class39_sub5_sub4_sub4_sub2.aClass3_2295 = null;
                }
            }
        }
        for (int i_11_ = 0; ArchiveWorker.anInt1210 > i_11_; i_11_++) {
            int i_12_ = Entity.anIntArray1734[i_11_];
            Npc class39_sub5_sub4_sub4_sub1 = (GroundItem.npcs[i_12_]);
            if (class39_sub5_sub4_sub4_sub1 != null
                    && class39_sub5_sub4_sub4_sub1.anInt2259 > 0) {
                class39_sub5_sub4_sub4_sub1.anInt2259--;
                if (class39_sub5_sub4_sub4_sub1.anInt2259 == 0) {
                    class39_sub5_sub4_sub4_sub1.aClass3_2295 = null;
                }
            }
        }
    }

    public static void method1050(int i, int i_13_, int i_14_, int i_15_,
            int i_16_, int i_17_, int i_18_) {
        if (JSocket.loadWidget(i_13_)) {
            ISAAC.method1038(-1, i_14_, 1, 0,
                    (AbstractMidiHandler.widgets[i_13_]),
                    i, i_18_, 0, i_17_, i_15_);
        }
    }

    public abstract void updateSequencer(int i, byte[] is, byte i_19_,
            boolean bool);

    public static Class39_Sub5_Sub14 method1052(int i, byte i_20_) {
        Class39_Sub5_Sub14 class39_sub5_sub14 = ((Class39_Sub5_Sub14) Class39_Sub5_Sub6.aClass7_1762.get((long) i));
        if (class39_sub5_sub14 != null) {
            return class39_sub5_sub14;
        }
        byte[] is = ItemDefinition.aClass9_1680.lookupFile(4, i);
        class39_sub5_sub14 = new Class39_Sub5_Sub14();
        if (is != null) {
            class39_sub5_sub14.method730(-1, new Buffer(is), i);
        }
        class39_sub5_sub14.method728((byte) -125);
        Class39_Sub5_Sub6.aClass7_1762.put(class39_sub5_sub14, (long) i);
        return class39_sub5_sub14;
    }

    public abstract void method1053(int i, byte i_21_);

    public abstract void method1054(int i);

    public abstract void method1055(int i, int i_22_, int i_23_);

    public static VarpDefinition getVarp(int i) {
        VarpDefinition class39_sub5_sub16 = ((VarpDefinition) Class39_Sub5_Sub12.varpDefinitionCache.get((long) i));
        if (class39_sub5_sub16 != null) {
            return class39_sub5_sub16;
        }
        byte[] is = Class39_Sub5_Sub5.aClass9_1748.lookupFile(16, i);
        class39_sub5_sub16 = new VarpDefinition();
        if (is != null) {
            class39_sub5_sub16.decode(new Buffer(is));
        }
        Class39_Sub5_Sub12.varpDefinitionCache.put(class39_sub5_sub16, (long) i);
        return class39_sub5_sub16;
    }

    public static int getPerlinNoise(int i, int i_25_, int i_26_) {
        int i_27_ = (Class32.method323(4, 113, i_25_ + 45365, i + 91923)
                - (-(Class32.method323(2, 54, i_25_ + 10294, i + 37821) - 128
                >> 1)
                + 128)
                + (Class32.method323(i_26_, i_26_ + 85, i_25_, i) - 128 >> 2));
        i_27_ = (int) ((double) i_27_ * 0.3) + 35;
        if (i_27_ < 10) {
            i_27_ = 10;
        } else if (i_27_ > 60) {
            i_27_ = 60;
        }
        return i_27_;
    }

    public static void method1058(int i) {
        aClass3_1110 = null;
        aClass3_1114 = null;
        aClass3_1109 = null;
        aClass3_1108 = null;
        aClass3_1113 = null;
        aClass3_1111 = null;
        aClass3_1115 = null;
        aClass3_1116 = null;
        aClass39_Sub5_Sub10_Sub3Array1106 = null;
    }

    static {
        aClass3_1108 = JString.create("Handel akzeptieren");
        aClass3_1115 = JString.create("Starting game engine)3)3)3");
        aClass3_1113 = aClass3_1115;
        aClass3_1110 = JString.create("RuneScape has been updated(Q");
        aClass3_1116 = aClass3_1111;
        anInt1107 = 0;
        aBoolean1112 = false;
        aClass3_1109 = aClass3_1110;
    }
}
