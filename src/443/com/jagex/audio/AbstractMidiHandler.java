package com.jagex.audio;

import com.jagex.TextConstants;
import com.jagex.world.World;
import com.jagex.io.ArchiveRequest;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.awt.JCanvas;
import com.jagex.utils.Huffman;
import com.jagex.graphics.ImageImpl;
import com.jagex.utils.JString;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import unpackaged.Class25;
import unpackaged.Class39_Sub5_Sub11;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MsTimer;
import unpackaged.Class47;
import unpackaged.Class53;
import unpackaged.Class67;
import com.jagex.config.Model;
import unpackaged.TextureLoaderImpl;
import com.jagex.config.Widget;

/* Class62_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public abstract class AbstractMidiHandler extends AudioHandler {

    public static Cache spriteCache;
    public static int[] anIntArray1588;
    public static int[] anIntArray1589 = new int[100];
    public static int crossPositionX;
    public static Widget[][] widgets;
    public static int anInt1595;

    public static void method1059(int i, World class38, int i_0_, int i_1_,
            int i_2_, int i_3_, TraversalMap class27,
            boolean bool, int i_4_) {
        if (!PlayerApperance.isLowMemory
                || (TextureLoaderImpl.tileFlags[0][i_3_][i_0_] & 0x2) != 0
                || (((TextureLoaderImpl.tileFlags[i_2_][i_3_][i_0_] & 0x10)
                == 0)
                && (PlayerApperance.method927(i_0_, i_3_, i_2_, (byte) 23)
                == ImageImpl.lastHeight))) {
            if (i_2_ < TraversalMap.anInt518) {
                TraversalMap.anInt518 = i_2_;
            }
            int i_5_ = Class67.heightMap[i_2_][i_3_][i_0_];
            int i_6_ = Class67.heightMap[i_2_][i_3_][i_0_ + 1];
            int i_7_ = Class67.heightMap[i_2_][i_3_ + 1][i_0_ + 1];
            int i_8_ = Class67.heightMap[i_2_][i_3_ + 1][i_0_];
            int i_9_ = i_7_ + (i_5_ + i_8_ + i_6_) >> 2;
            ObjectDefinition class39_sub5_sub15 = JCanvas.getObjectDefinition(i_1_);
            int i_10_ = i_3_ + (i_0_ << 7) - (-(i_1_ << 14) - 1073741824);
            if (class39_sub5_sub15.anInt1941 == 0) {
                i_10_ -= -2147483648;
            }
            int i_11_ = (i_4_ << 6) + i;
            if (class39_sub5_sub15.anInt1967 == 1) {
                i_11_ += 256;
            }
            if (class39_sub5_sub15.method734(31739)) {
                Class39_Sub5_Sub4_Sub2.method500((byte) -73, i_0_, i_4_, i_3_,
                        class39_sub5_sub15, i_2_);
            }
            if (i == 22) {
                if (!PlayerApperance.isLowMemory || class39_sub5_sub15.anInt1941 != 0
                        || class39_sub5_sub15.aBoolean1969) {
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 == -1
                            && class39_sub5_sub15.anIntArray1961 == null) {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 22, i_5_, i_4_,
                                i_6_, i_7_, i_8_);
                    } else {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 22, i_4_, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    }
                    class38.method381(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4, i_10_, i_11_);
                    if (class39_sub5_sub15.aBoolean1928
                            && class39_sub5_sub15.anInt1941 == 1
                            && class27 != null) {
                        class27.method306((byte) -85, i_0_, i_3_);
                    }
                }
            } else if (i == 10 || i == 11) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 != -1
                        || class39_sub5_sub15.anIntArray1961 != null) {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 10, i_4_, i_5_,
                            i_8_, i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                } else {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, 10, i_5_, i_4_,
                            i_6_, i_7_, i_8_);
                }
                if (class39_sub5_sub4 != null) {
                    int i_12_;
                    int i_13_;
                    if (i_4_ != 1 && i_4_ != 3) {
                        i_12_ = class39_sub5_sub15.anInt1948;
                        i_13_ = class39_sub5_sub15.anInt1925;
                    } else {
                        i_12_ = class39_sub5_sub15.anInt1925;
                        i_13_ = class39_sub5_sub15.anInt1948;
                    }
                    int i_14_ = 0;
                    if (i == 11) {
                        i_14_ += 256;
                    }
                    if (class38.method383(i_2_, i_3_, i_0_, i_9_, i_13_, i_12_,
                            class39_sub5_sub4, i_14_, i_10_,
                            i_11_)
                            && class39_sub5_sub15.aBoolean1959) {
                        Model class39_sub5_sub4_sub6;
                        if (!(class39_sub5_sub4 instanceof Model)) {
                            class39_sub5_sub4_sub6 = class39_sub5_sub15.method742(66, 10, i_5_,
                                    i_4_, i_6_,
                                    i_7_, i_8_);
                        } else {
                            class39_sub5_sub4_sub6 = (Model) class39_sub5_sub4;
                        }
                        if (class39_sub5_sub4_sub6 != null) {
                            for (int i_15_ = 0; i_13_ >= i_15_; i_15_++) {
                                for (int i_16_ = 0; i_16_ <= i_12_; i_16_++) {
                                    int i_17_ = (class39_sub5_sub4_sub6.method561()
                                            / 4);
                                    if (i_17_ > 30) {
                                        i_17_ = 30;
                                    }
                                    if (i_17_
                                            > (ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + i_15_][i_16_ + i_0_])) {
                                        ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + i_15_][i_0_ + i_16_] = (byte) i_17_;
                                    }
                                }
                            }
                        }
                    }
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method304(class39_sub5_sub15.aBoolean1949, i_3_,
                            class39_sub5_sub15.anInt1925, (byte) -54,
                            i_0_, class39_sub5_sub15.anInt1948,
                            i_4_);
                }
            } else if (i >= 12) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 != -1
                        || class39_sub5_sub15.anIntArray1961 != null) {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, i, i_4_, i_5_, i_8_,
                            i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                } else {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, i, i_5_, i_4_, i_6_,
                            i_7_, i_8_);
                }
                class38.method383(i_2_, i_3_, i_0_, i_9_, 1, 1,
                        class39_sub5_sub4, 0, i_10_, i_11_);
                if (i >= 12 && i <= 17 && i != 13 && i_2_ > 0) {
                    ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                            2340);
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method304(class39_sub5_sub15.aBoolean1949, i_3_,
                            class39_sub5_sub15.anInt1925, (byte) -54,
                            i_0_, class39_sub5_sub15.anInt1948,
                            i_4_);
                }
            } else if (i == 0) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 != -1
                        || class39_sub5_sub15.anIntArray1961 != null) {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 0, i_4_, i_5_, i_8_,
                            i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                } else {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, 0, i_5_, i_4_, i_6_,
                            i_7_, i_8_);
                }
                class38.method405(i_2_, i_3_, i_0_, i_9_, class39_sub5_sub4,
                        null,
                        Widget.anIntArray2005[i_4_], 0,
                        i_10_, i_11_);
                if (i_4_ != 0) {
                    if (i_4_ == 1) {
                        if (class39_sub5_sub15.aBoolean1959) {
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_ + 1] = (byte) 50;
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_ + 1] = (byte) 50;
                        }
                        if (class39_sub5_sub15.aBoolean1929) {
                            ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1]),
                                    1170);
                        }
                    } else if (i_4_ == 2) {
                        if (class39_sub5_sub15.aBoolean1959) {
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_] = (byte) 50;
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_ + 1] = (byte) 50;
                        }
                        if (class39_sub5_sub15.aBoolean1929) {
                            ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_]),
                                    585);
                        }
                    } else if (i_4_ == 3) {
                        if (class39_sub5_sub15.aBoolean1959) {
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_] = (byte) 50;
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_] = (byte) 50;
                        }
                        if (class39_sub5_sub15.aBoolean1929) {
                            ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                    1170);
                        }
                    }
                } else {
                    if (class39_sub5_sub15.aBoolean1959) {
                        ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_] = (byte) 50;
                        ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_ + 1] = (byte) 50;
                    }
                    if (class39_sub5_sub15.aBoolean1929) {
                        ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                585);
                    }
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method302(i_3_, 16384,
                            class39_sub5_sub15.aBoolean1949, i_0_,
                            i_4_, i);
                }
                if (class39_sub5_sub15.anInt1936 != 16) {
                    class38.method367(i_2_, i_3_, i_0_,
                            class39_sub5_sub15.anInt1936);
                }
            } else if (i == 1) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 == -1
                        && class39_sub5_sub15.anIntArray1961 == null) {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, 1, i_5_, i_4_, i_6_,
                            i_7_, i_8_);
                } else {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 1, i_4_, i_5_, i_8_,
                            i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                }
                class38.method405(i_2_, i_3_, i_0_, i_9_, class39_sub5_sub4,
                        null, anIntArray1588[i_4_], 0, i_10_, i_11_);
                if (class39_sub5_sub15.aBoolean1959) {
                    if (i_4_ != 0) {
                        if (i_4_ != 1) {
                            if (i_4_ != 2) {
                                if (i_4_ == 3) {
                                    ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_] = (byte) 50;
                                }
                            } else {
                                ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_] = (byte) 50;
                            }
                        } else {
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_ + 1] = (byte) 50;
                        }
                    } else {
                        ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_ + 1] = (byte) 50;
                    }
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method302(i_3_, 16384,
                            class39_sub5_sub15.aBoolean1949, i_0_,
                            i_4_, i);
                }
            } else if (i == 2) {
                int i_18_ = i_4_ + 1 & 0x3;
                Entity class39_sub5_sub4;
                Entity class39_sub5_sub4_19_;
                if (class39_sub5_sub15.anInt1939 == -1
                        && class39_sub5_sub15.anIntArray1961 == null) {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, 2, i_5_, i_4_ + 4,
                            i_6_, i_7_, i_8_);
                    class39_sub5_sub4_19_ = class39_sub5_sub15.method742(66, 2, i_5_, i_18_,
                            i_6_, i_7_, i_8_);
                } else {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 2, 4 + i_4_, i_5_,
                            i_8_, i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                    class39_sub5_sub4_19_ = new Class39_Sub5_Sub4_Sub2(i_1_, 2, i_18_, i_5_,
                            i_8_, i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                }
                class38.method405(i_2_, i_3_, i_0_, i_9_, class39_sub5_sub4,
                        class39_sub5_sub4_19_,
                        Widget.anIntArray2005[i_4_],
                        Widget.anIntArray2005[i_18_],
                        i_10_, i_11_);
                if (class39_sub5_sub15.aBoolean1929) {
                    if (i_4_ != 0) {
                        if (i_4_ != 1) {
                            if (i_4_ == 2) {
                                ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_] = (Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_]),
                                        585));
                                ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = (Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                        1170));
                            } else if (i_4_ == 3) {
                                ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = (Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                        1170));
                                ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = (Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                        585));
                            }
                        } else {
                            ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1]),
                                    1170);
                            ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_ + 1][i_0_]),
                                    585);
                        }
                    } else {
                        ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_]),
                                585);
                        ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1] = Queue.or((ArchiveRequest.anIntArrayArrayArray1412[i_2_][i_3_][i_0_ + 1]),
                                1170);
                    }
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method302(i_3_, 16384,
                            class39_sub5_sub15.aBoolean1949, i_0_,
                            i_4_, i);
                }
                if (class39_sub5_sub15.anInt1936 != 16) {
                    class38.method367(i_2_, i_3_, i_0_,
                            class39_sub5_sub15.anInt1936);
                }
            } else if (i == 3) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 != -1
                        || class39_sub5_sub15.anIntArray1961 != null) {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 3, i_4_, i_5_, i_8_,
                            i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                } else {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, 3, i_5_, i_4_, i_6_,
                            i_7_, i_8_);
                }
                class38.method405(i_2_, i_3_, i_0_, i_9_, class39_sub5_sub4,
                        null, anIntArray1588[i_4_], 0, i_10_, i_11_);
                if (class39_sub5_sub15.aBoolean1959) {
                    if (i_4_ != 0) {
                        if (i_4_ != 1) {
                            if (i_4_ == 2) {
                                ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_] = (byte) 50;
                            } else if (i_4_ == 3) {
                                ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_] = (byte) 50;
                            }
                        } else {
                            ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_ + 1][i_0_ + 1] = (byte) 50;
                        }
                    } else {
                        ItemDefinition.aByteArrayArrayArray1671[i_2_][i_3_][i_0_ + 1] = (byte) 50;
                    }
                }
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method302(i_3_, 16384,
                            class39_sub5_sub15.aBoolean1949, i_0_,
                            i_4_, i);
                }
            } else if (i == 9) {
                Entity class39_sub5_sub4;
                if (class39_sub5_sub15.anInt1939 != -1
                        || class39_sub5_sub15.anIntArray1961 != null) {
                    class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, i, i_4_, i_5_, i_8_,
                            i_7_, i_6_,
                            (class39_sub5_sub15.anInt1939),
                            true, null);
                } else {
                    class39_sub5_sub4 = class39_sub5_sub15.method742(66, i, i_5_, i_4_, i_6_,
                            i_7_, i_8_);
                }
                class38.method383(i_2_, i_3_, i_0_, i_9_, 1, 1,
                        class39_sub5_sub4, 0, i_10_, i_11_);
                if (class39_sub5_sub15.aBoolean1928 && class27 != null) {
                    class27.method304(class39_sub5_sub15.aBoolean1949, i_3_,
                            class39_sub5_sub15.anInt1925, (byte) -54,
                            i_0_, class39_sub5_sub15.anInt1948,
                            i_4_);
                }
            } else {
                if (class39_sub5_sub15.aBoolean1951) {
                    if (i_4_ != 1) {
                        if (i_4_ == 2) {
                            int i_20_ = i_6_;
                            i_6_ = i_8_;
                            i_8_ = i_20_;
                            i_20_ = i_7_;
                            i_7_ = i_5_;
                            i_5_ = i_20_;
                        } else if (i_4_ == 3) {
                            int i_21_ = i_6_;
                            i_6_ = i_5_;
                            i_5_ = i_8_;
                            i_8_ = i_7_;
                            i_7_ = i_21_;
                        }
                    } else {
                        int i_22_ = i_6_;
                        i_6_ = i_7_;
                        i_7_ = i_8_;
                        i_8_ = i_5_;
                        i_5_ = i_22_;
                    }
                }
                if (i == 4) {
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 == -1
                            && class39_sub5_sub15.anIntArray1961 == null) {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 4, i_5_, 0,
                                i_6_, i_7_, i_8_);
                    } else {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 4, 0, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    }
                    class38.method365(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4,
                            Widget.anIntArray2005[i_4_],
                            i_4_ * 512, 0, 0, i_10_, i_11_);
                } else if (i == 5) {
                    int i_23_ = 16;
                    int i_24_ = class38.method379(i_2_, i_3_, i_0_);
                    if (i_24_ > 0) {
                        i_23_ = JCanvas.getObjectDefinition((i_24_ & 0x1fffef0d) >> 14).anInt1936;
                    }
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 != -1
                            || class39_sub5_sub15.anIntArray1961 != null) {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 4, 0, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    } else {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 4, i_5_, 0,
                                i_6_, i_7_, i_8_);
                    }
                    class38.method365(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4,
                            Widget.anIntArray2005[i_4_],
                            i_4_ * 512,
                            i_23_ * Queue.anIntArray978[i_4_],
                            i_23_ * Class53.anIntArray964[i_4_],
                            i_10_, i_11_);
                } else if (i == 6) {
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 == -1
                            && class39_sub5_sub15.anIntArray1961 == null) {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 4, i_5_, 0,
                                i_6_, i_7_, i_8_);
                    } else {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 4, 0, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    }
                    class38.method365(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4, 256, i_4_, 0, 0,
                            i_10_, i_11_);
                } else if (i == 7) {
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 != -1
                            || class39_sub5_sub15.anIntArray1961 != null) {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 4, 0, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    } else {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 4, i_5_, 0,
                                i_6_, i_7_, i_8_);
                    }
                    class38.method365(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4, 512, i_4_, 0, 0,
                            i_10_, i_11_);
                } else if (i == 8) {
                    Entity class39_sub5_sub4;
                    if (class39_sub5_sub15.anInt1939 != -1
                            || class39_sub5_sub15.anIntArray1961 != null) {
                        class39_sub5_sub4 = new Class39_Sub5_Sub4_Sub2(i_1_, 4, 0, i_5_,
                                i_8_, i_7_, i_6_,
                                (class39_sub5_sub15.anInt1939),
                                true, null);
                    } else {
                        class39_sub5_sub4 = class39_sub5_sub15.method742(66, 4, i_5_, 0,
                                i_6_, i_7_, i_8_);
                    }
                    class38.method365(i_2_, i_3_, i_0_, i_9_,
                            class39_sub5_sub4, 768, i_4_, 0, 0,
                            i_10_, i_11_);
                }
            }
        }
    }

    public boolean method1060(int i, int i_25_, int i_26_, long l) {
        if ((i & 0xe0) == 128) {
            int i_27_ = 1 << (i & 0xf);
            int i_28_ = TraversalMap.anIntArray506[i_25_];
            if (i >= 144 && i_26_ != 0) {
                if ((i_28_ & i_27_) != 0) {
                    send(i, i_25_, 0, l);
                } else {
                    TraversalMap.anIntArray506[i_25_] = i_28_ | i_27_;
                }
            } else {
                TraversalMap.anIntArray506[i_25_] = i_28_ & (i_27_ ^ 0xffffffff);
            }
            return false;
        }
        if ((i & 0xf0) == 176) {
            if (i_25_ == 121) {
                send(i, i_25_, i_26_, l);
                int i_29_ = i & 0xf;
                Deque.anIntArray911[i_29_] = 12800;
                int i_30_ = getChannelVolume(i_29_);
                send(i, 7, i_30_ >> 7, l);
                send(i, 39, i_30_ & 0x7f, l);
                return true;
            }
            if (i_25_ == 7 || i_25_ == 39) {
                int i_31_ = i & 0xf;
                if (i_25_ == 7) {
                    Deque.anIntArray911[i_31_] = (Deque.anIntArray911[i_31_] & 0x7f) + (i_26_ << 7);
                } else {
                    Deque.anIntArray911[i_31_] = (Deque.anIntArray911[i_31_] & 0x3f80) + i_26_;
                }
                int i_32_ = getChannelVolume(i_31_);
                send(i, 7, i_32_ >> 7, l);
                send(i, 39, i_32_ & 0x7f, l);
                return true;
            }
        }
        return false;
    }

    public void method1061(long l, boolean bool, int i) {
        MsTimer.anInt1553 = i;
        for (int i_33_ = 0; i_33_ < 16; i_33_++) {
            Deque.anIntArray911[i_33_] = 12800;
        }
        for (int i_34_ = 0; i_34_ < 16; i_34_++) {
            int i_35_ = getChannelVolume(i_34_);
            send(176 + i_34_, 7, i_35_ >> 7, l);
            send(176 + i_34_, 39, i_35_ & 0x7f, l);
        }
    }

    public void method1062(long l, int i) {
        for (int i_36_ = 0; i_36_ < 128; i_36_++) {
            int i_37_ = TraversalMap.anIntArray506[i_36_];
            TraversalMap.anIntArray506[i_36_] = 0;
            for (int i_38_ = 0; i_38_ < 16; i_38_++) {
                if ((1 << i_38_ & i_37_) != 0) {
                    send(i_38_ + 144, i_36_, 0, l);
                }
            }
        }
        for (int i_39_ = 0; i_39_ < 16; i_39_++) {
            send(i_39_ + 176, 123, 0, l);
        }
        for (int i_40_ = 0; i_40_ < 16; i_40_++) {
            send(i_40_ + 176, 120, 0, l);
        }
        for (int i_41_ = 0; i_41_ < 16; i_41_++) {
            send(i_41_ + 176, 121, 0, l);
        }
        for (int i_42_ = 0; i_42_ < 16; i_42_++) {
            send(176 + i_42_, 0, 0, l);
        }
        for (int i_43_ = i; i_43_ < 16; i_43_++) {
            send(i_43_ + 176, 32, 0, l);
        }
        for (int i_44_ = 0; i_44_ < 16; i_44_++) {
            send(192 + i_44_, 0, 0, l);
        }
    }

    public static void setHuffmans(Huffman huffmans) {
        Class25.huffmans = huffmans;
    }

    public static Class39_Sub5_Sub11 method1064(int i, byte i_45_) {
        Class39_Sub5_Sub11 class39_sub5_sub11 = ((Class39_Sub5_Sub11) JString.aClass7_1227.get((long) i));
        if (class39_sub5_sub11 != null) {
            return class39_sub5_sub11;
        }
        byte[] is = Class47.aClass9_898.lookupFile(12, i);
        class39_sub5_sub11 = new Class39_Sub5_Sub11();
        if (is != null) {
            class39_sub5_sub11.method698(new Buffer(is), 17877);
        }
        class39_sub5_sub11.method702((byte) -106);
        JString.aClass7_1227.put(class39_sub5_sub11, (long) i);
        return class39_sub5_sub11;
    }

    public abstract void send(int i, int i_46_, int i_47_, long l);

    public static int getChannelVolume(int channelId) {
        int i_48_ = Deque.anIntArray911[channelId];
        i_48_ = (i_48_ * MsTimer.anInt1553 >> 8) * i_48_;
        return (int) (Math.sqrt((double) i_48_) + 0.5);
    }

    public static void method1067(int i) {
        TextConstants.aClass3_1593 = null;
        TextConstants.sorryInvitedPlayersEng = null;
        spriteCache = null;
        widgets = null;
        anIntArray1588 = null;
        TextConstants.sidePanelRedrawnEng = null;
        anIntArray1589 = null;
    }

    public void updateVolume(int i_49_, long l, int i_50_) {
        i_50_ = (int) (Math.pow(0.1, (double) i_49_ * 5.0E-4) * (double) i_50_ + 0.5);
        if (MsTimer.anInt1553 != i_50_) {
            MsTimer.anInt1553 = i_50_;
            for (int channelId = 0; channelId < 16; channelId++) {
                int i_52_ = getChannelVolume(channelId);
                send(channelId + 176, 7, i_52_ >> 7, l);
                send(176 + channelId, 39, i_52_ & 0x7f, l);
            }
        }
    }

    static {
        anIntArray1588 = new int[]{16, 32, 64, 128};
        spriteCache = new Cache(200);
        TextConstants.aClass3_1593 = TextConstants.sorryInvitedPlayersEng;
        crossPositionX = 0;
        anInt1595 = 0;
    }
}
