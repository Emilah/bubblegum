package com.jagex.config;

import com.jagex.Client;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.utils.Huffman;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.io.ArchiveWorker;
import unpackaged.Class1;
import unpackaged.Class15;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub5_Sub11;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class4;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class66;

/* Class39_Sub5_Sub13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class NpcDefinition extends SubNode {

    public int anInt1859;
    public static AbstractFileLoader aClass9_1860;
    public int anInt1861;
    public int anInt1862;
    public int anInt1863;
    public static Widget aClass39_Sub5_Sub17_1864 = null;
    public int anInt1865;
    public JString[] options;
    public static AbstractImage aClass57_1867;
    public int[] anIntArray1868;
    public int[] anIntArray1869;
    public int anInt1870;
    public int anInt1871;
    public int anInt1872;
    public int[] anIntArray1873;
    public int id;
    public int anInt1875;
    public int anInt1876 = 128;
    public int anInt1877;
    public int[] anIntArray1878;
    public int anInt1879;
    public int anInt1880;
    public JString name;
    public int anInt1882;
    public boolean aBoolean1883;
    public int varbitId;
    public int[] anIntArray1885;
    public boolean aBoolean1886;
    public int anInt1887;
    public boolean aBoolean1888;
    public int stateId;

    public static void method714(AbstractFileLoader class9, byte i, AbstractFileLoader class9_0_,
            AbstractFileLoader class9_1_) {
        Class37.aClass9_658 = class9_0_;
        VarpDefinition.wigetFileLoader = class9_1_;
        Huffman.aClass9_760 = class9;
        AbstractMidiHandler.widgets = (new Widget[VarpDefinition.wigetFileLoader.getAmountArchives()][]);
        Entity.widgetsLoaded = new boolean[VarpDefinition.wigetFileLoader.getAmountArchives()];
    }

    public static void method715(byte i, AbstractFileLoader class9, AbstractFileLoader class9_2_) {
        Class43.aClass9_816 = class9;
        Class39_Sub5_Sub5.aClass9_1740 = class9_2_;
    }

    public boolean method716(boolean bool) {
        if (anIntArray1878 == null) {
            return true;
        }
        int i = -1;
        if (varbitId != -1) {
            i = Class44.getVarbitValue(varbitId);
        } else if (stateId != -1) {
            i = Client.stateValues[stateId];
        }
        if (i < 0 || anIntArray1878.length <= i || anIntArray1878[i] == -1) {
            return false;
        }
        return true;
    }

    public static void method717(byte i) {
        aClass9_1860 = null;
        aClass39_Sub5_Sub17_1864 = null;
        aClass57_1867 = null;
    }

    public Model getModel(int i) {
        if (anIntArray1878 != null) {
            NpcDefinition class39_sub5_sub13_3_ = method721(i ^ 0x15d1);
            if (class39_sub5_sub13_3_ == null) {
                return null;
            }
            return class39_sub5_sub13_3_.getModel(0);
        }
        if (anIntArray1873 == null) {
            return null;
        }
        boolean bool = false;
        for (int i_4_ = i; anIntArray1873.length > i_4_; i_4_++) {
            if (!ObjectDefinition.modelFileLoader.isArchiveLoaded(anIntArray1873[i_4_], 0)) {
                bool = true;
            }
        }
        if (bool) {
            return null;
        }
        Model[] class39_sub5_sub4_sub6s = new Model[anIntArray1873.length];
        for (int i_5_ = 0; i_5_ < anIntArray1873.length; i_5_++) {
            class39_sub5_sub4_sub6s[i_5_] = Model.getModel((ObjectDefinition.modelFileLoader),
                    anIntArray1873[i_5_], 0);
        }
        Model class39_sub5_sub4_sub6;
        if (class39_sub5_sub4_sub6s.length == 1) {
            class39_sub5_sub4_sub6 = class39_sub5_sub4_sub6s[0];
        } else {
            class39_sub5_sub4_sub6 = new Model(class39_sub5_sub4_sub6s,
                    class39_sub5_sub4_sub6s.length);
        }
        if (anIntArray1868 != null) {
            for (int i_6_ = 0; i_6_ < anIntArray1868.length; i_6_++) {
                class39_sub5_sub4_sub6.method563(anIntArray1868[i_6_],
                        anIntArray1869[i_6_]);
            }
        }
        return class39_sub5_sub4_sub6;
    }

    public void decodeOpcode(int i, Buffer class39_sub6, int i_7_) {
        if (i_7_ == 1) {
            int i_8_ = class39_sub6.getUint8();
            anIntArray1885 = new int[i_8_];
            for (int i_9_ = 0; i_8_ > i_9_; i_9_++) {
                anIntArray1885[i_9_] = class39_sub6.getUint16();
            }
        } else if (i_7_ != 2) {
            if (i_7_ != 12) {
                if (i_7_ != 13) {
                    if (i_7_ == 14) {
                        anInt1861 = class39_sub6.getUint16();
                    } else if (i_7_ != 15) {
                        if (i_7_ == 16) {
                            anInt1875 = class39_sub6.getUint16();
                        } else if (i_7_ != 17) {
                            if (i_7_ < 30 || i_7_ >= 35) {
                                if (i_7_ == 40) {
                                    int i_10_ = class39_sub6.getUint8();
                                    anIntArray1869 = new int[i_10_];
                                    anIntArray1868 = new int[i_10_];
                                    for (int i_11_ = 0; i_10_ > i_11_;
                                            i_11_++) {
                                        anIntArray1868[i_11_] = class39_sub6.getUint16();
                                        anIntArray1869[i_11_] = class39_sub6.getUint16();
                                    }
                                } else if (i_7_ == 60) {
                                    int i_12_ = class39_sub6.getUint8();
                                    anIntArray1873 = new int[i_12_];
                                    for (int i_13_ = 0; i_13_ < i_12_; i_13_++) {
                                        anIntArray1873[i_13_] = class39_sub6.getUint16();
                                    }
                                } else if (i_7_ != 93) {
                                    if (i_7_ != 95) {
                                        if (i_7_ != 97) {
                                            if (i_7_ == 98) {
                                                anInt1876 = (class39_sub6.getUint16());
                                            } else if (i_7_ == 99) {
                                                aBoolean1883 = true;
                                            } else if (i_7_ != 100) {
                                                if (i_7_ != 101) {
                                                    if (i_7_ == 102) {
                                                        anInt1871 = (class39_sub6.getUint16());
                                                    } else if (i_7_ == 103) {
                                                        anInt1882 = (class39_sub6.getUint16());
                                                    } else if (i_7_ == 106) {
                                                        varbitId = (class39_sub6.getUint16());
                                                        if (varbitId == 65535) {
                                                            varbitId = -1;
                                                        }
                                                        stateId = (class39_sub6.getUint16());
                                                        if (stateId == 65535) {
                                                            stateId = -1;
                                                        }
                                                        int i_14_ = (class39_sub6.getUint8());
                                                        anIntArray1878 = (new int[i_14_ + 1]);
                                                        for (int i_15_ = 0;
                                                                i_14_ >= i_15_;
                                                                i_15_++) {
                                                            anIntArray1878[i_15_] = (class39_sub6.getUint16());
                                                            if ((anIntArray1878[i_15_])
                                                                    == 65535) {
                                                                anIntArray1878[i_15_] = -1;
                                                            }
                                                        }
                                                    } else if (i_7_ == 107) {
                                                        aBoolean1886 = false;
                                                    }
                                                } else {
                                                    anInt1880 = (class39_sub6.getInt8()
                                                            * 5);
                                                }
                                            } else {
                                                anInt1865 = class39_sub6.getInt8();
                                            }
                                        } else {
                                            anInt1862 = class39_sub6.getUint16();
                                        }
                                    } else {
                                        anInt1859 = class39_sub6.getUint16();
                                    }
                                } else {
                                    aBoolean1888 = false;
                                }
                            } else {
                                options[i_7_ - 30] = class39_sub6.getJstr();
                                if (options[i_7_ - 30].equalTo(FileLoader.aClass3_1299)) {
                                    options[i_7_ - 30] = null;
                                }
                            }
                        } else {
                            anInt1861 = class39_sub6.getUint16();
                            anInt1877 = class39_sub6.getUint16();
                            anInt1863 = class39_sub6.getUint16();
                            anInt1879 = class39_sub6.getUint16();
                        }
                    } else {
                        anInt1872 = class39_sub6.getUint16();
                    }
                } else {
                    anInt1887 = class39_sub6.getUint16();
                }
            } else {
                anInt1870 = class39_sub6.getUint8();
            }
        } else {
            name = class39_sub6.getJstr();
        }
    }

    public void decode(Buffer buffer) {
        for (;;) {
            int opcode = buffer.getUint8();
            if (opcode == 0) {
                break;
            }
            decodeOpcode(-31, buffer, opcode);
        }
    }

    public NpcDefinition method721(int i) {
        int i_16_ = -1;
        if (varbitId == -1) {
            if (stateId != -1) {
                i_16_ = Client.stateValues[stateId];
            }
        } else {
            i_16_ = Class44.getVarbitValue(varbitId);
        }
        if (i_16_ < 0 || i_16_ >= anIntArray1878.length
                || anIntArray1878[i_16_] == -1) {
            return null;
        }
        return ArchiveWorker.getNpcDefinition(anIntArray1878[i_16_]);
    }

    public static void spawnStillObject(int i, int posY, int i_18_, int height, int rotation, int i_22_, int type, int i_24_, int posX) {
        StillObject stillObject = null;
        for (StillObject class39_sub11_26_ = (StillObject) Class15.stillObjects.getFirst();
                class39_sub11_26_ != null;
                class39_sub11_26_ = (StillObject) Class15.stillObjects.getNext()) {
            if (height == class39_sub11_26_.height
                    && class39_sub11_26_.positionX == posX
                    && class39_sub11_26_.positionY == posY
                    && type == class39_sub11_26_.type) {
                stillObject = class39_sub11_26_;
                break;
            }
        }
        if (stillObject == null) {
            stillObject = new StillObject();
            stillObject.height = height;
            stillObject.positionY = posY;
            stillObject.positionX = posX;
            stillObject.type = type;
            Class66.method1106(1, stillObject);
            Class15.stillObjects.offerLast(stillObject);
        }
        stillObject.rotation = rotation;
        stillObject.anInt1476 = i;
        stillObject.anInt1456 = i_18_;
        stillObject.anInt1457 = i_22_;
        stillObject.anInt1459 = i_24_;
    }

    public static void method723(byte i) {
        for (Class39_Sub10 class39_sub10 = (Class39_Sub10) Class4.aClass49_74.getFirst();
                class39_sub10 != null;
                class39_sub10 = (Class39_Sub10) Class4.aClass49_74.getNext()) {
            if (class39_sub10.aClass39_Sub1_Sub2_1418 != null) {
                Class1.aClass39_Sub1_Sub1_32.method424(class39_sub10.aClass39_Sub1_Sub2_1418);
                class39_sub10.aClass39_Sub1_Sub2_1418 = null;
            }
            if (class39_sub10.aClass39_Sub1_Sub2_1441 != null) {
                Class1.aClass39_Sub1_Sub1_32.method424(class39_sub10.aClass39_Sub1_Sub2_1441);
                class39_sub10.aClass39_Sub1_Sub2_1441 = null;
            }
        }
        Class4.aClass49_74.removeAll();
    }

    public void method724(byte i) {
        /* empty */
    }

    public Model method725(int i, int i_27_, Class39_Sub5_Sub11 class39_sub5_sub11,
            Class39_Sub5_Sub11 class39_sub5_sub11_28_, int i_29_) {
        if (anIntArray1878 != null) {
            NpcDefinition class39_sub5_sub13_30_ = method721(i_27_ ^ 0xea2e);
            if (class39_sub5_sub13_30_ == null) {
                return null;
            }
            return class39_sub5_sub13_30_.method725(i, 65535,
                    class39_sub5_sub11,
                    class39_sub5_sub11_28_,
                    i_29_);
        }
        Model class39_sub5_sub4_sub6 = ((Model) Class37.aClass7_655.get((long) id));
        if (class39_sub5_sub4_sub6 == null) {
            boolean bool = false;
            for (int i_31_ = 0; anIntArray1885.length > i_31_; i_31_++) {
                if (!ObjectDefinition.modelFileLoader.isArchiveLoaded(anIntArray1885[i_31_], 0)) {
                    bool = true;
                }
            }
            if (bool) {
                return null;
            }
            Model[] class39_sub5_sub4_sub6s = new Model[anIntArray1885.length];
            for (int i_32_ = 0; anIntArray1885.length > i_32_; i_32_++) {
                class39_sub5_sub4_sub6s[i_32_] = Model.getModel((ObjectDefinition.modelFileLoader),
                        anIntArray1885[i_32_],
                        0);
            }
            if (class39_sub5_sub4_sub6s.length == 1) {
                class39_sub5_sub4_sub6 = class39_sub5_sub4_sub6s[0];
            } else {
                class39_sub5_sub4_sub6 = (new Model(class39_sub5_sub4_sub6s,
                        class39_sub5_sub4_sub6s.length));
            }
            if (anIntArray1868 != null) {
                for (int i_33_ = 0; anIntArray1868.length > i_33_; i_33_++) {
                    class39_sub5_sub4_sub6.method563(anIntArray1868[i_33_],
                            anIntArray1869[i_33_]);
                }
            }
            class39_sub5_sub4_sub6.initializeTriAndVertexGroups();
            class39_sub5_sub4_sub6.applyLightingVector(anInt1865 + 64, anInt1880 + 850,
                    -30, -50, -30, true);
            Class37.aClass7_655.put(class39_sub5_sub4_sub6,
                    (long) id);
        }
        Model class39_sub5_sub4_sub6_34_;
        if (class39_sub5_sub11_28_ != null && class39_sub5_sub11 != null) {
            class39_sub5_sub4_sub6_34_ = class39_sub5_sub11_28_.method701(i, class39_sub5_sub4_sub6,
                    class39_sub5_sub11,
                    -249009456, i_29_);
        } else if (class39_sub5_sub11_28_ != null) {
            class39_sub5_sub4_sub6_34_ = class39_sub5_sub11_28_.method703(class39_sub5_sub4_sub6, i,
                    true);
        } else if (class39_sub5_sub11 != null) {
            class39_sub5_sub4_sub6_34_ = class39_sub5_sub11.method703(class39_sub5_sub4_sub6, i_29_,
                    true);
        } else {
            class39_sub5_sub4_sub6_34_ = class39_sub5_sub4_sub6.method567(true);
        }
        if (i_27_ != 65535) {
            aClass9_1860 = null;
        }
        if (anInt1862 != 128 || anInt1876 != 128) {
            class39_sub5_sub4_sub6_34_.method559(anInt1862, anInt1876,
                    anInt1862);
        }
        return class39_sub5_sub4_sub6_34_;
    }

    public NpcDefinition() {
        anInt1875 = -1;
        options = new JString[5];
        anInt1863 = -1;
        anInt1871 = -1;
        anInt1877 = -1;
        anInt1879 = -1;
        aBoolean1883 = false;
        anInt1861 = -1;
        anInt1882 = 32;
        name = FrameBuffer.aClass3_2151;
        anInt1859 = -1;
        anInt1862 = 128;
        anInt1880 = 0;
        anInt1865 = 0;
        anInt1870 = 1;
        anInt1887 = -1;
        aBoolean1886 = true;
        varbitId = -1;
        anInt1872 = -1;
        stateId = -1;
        aBoolean1888 = true;
    }
}
