package com.jagex.world;

/* Class39_Sub5_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.utils.MouseRecorder;
import com.jagex.config.Model;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.world.Barrier;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.Client;
import com.jagex.utils.Bzip2Entry;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.od.OndemandHandler;
import com.jagex.world.entities.Player;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.utils.Cache;
import java.awt.Component;
import unpackaged.Class14;
import unpackaged.Class23;
import unpackaged.Class26;
import unpackaged.Class32;
import unpackaged.Wall;
import unpackaged.Class39_Sub10;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class53;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class68;
import unpackaged.TextureLoaderImpl;

public abstract class Entity extends SubNode {

    public int anInt1726 = 1000;
    public static boolean[] widgetsLoaded;
    public static JString whiPrefixJstr;
    public static JString aClass3_1729 = JString.create("Benutzen Sie die (WPasswort -=ndern(W Option");
    public static int anInt1730;
    public static int anInt1731 = 0;
    public static int anInt1732;
    public static JString aClass3_1733;
    public static int[] anIntArray1734;

    public static void method487(boolean bool) {
        int i = ((Cache.localPlayer.fPositionX >> 7)
                + KeyListenerImpl.anInt618);
        int i_0_ = ((Cache.localPlayer.fPositionY >> 7)
                + Class65.anInt1145);
        Wall.anInt630 = 0;
        if (i_0_ >= 3053 && i_0_ <= 3156 && i >= 3056 && i <= 3136) {
            Wall.anInt630 = 1;
        }
        if (i_0_ >= 3072 && i_0_ <= 3118 && i >= 9492 && i <= 9535) {
            Wall.anInt630 = 1;
        }
        if (Wall.anInt630 == 1 && i_0_ >= 3139 && i_0_ <= 3199 && i >= 3008
                && i <= 3062) {
            Wall.anInt630 = 0;
        }
    }

    public void method488(int i, int i_1_, int i_2_, int i_3_, int i_4_,
            int i_5_, int i_6_, int i_7_, int i_8_) {
        Model class39_sub5_sub4_sub6 = method489(true);
        if (class39_sub5_sub4_sub6 != null) {
            anInt1726 = class39_sub5_sub4_sub6.anInt1726;
            class39_sub5_sub4_sub6.method488(i, i_1_, i_2_, i_3_, i_4_, i_5_,
                    i_6_, i_7_, i_8_);
        }
    }

    public Model method489(boolean bool) {
        if (bool != true) {
            method489(false);
        }
        return null;
    }

    public static void method490(Component component, AbstractFileLoader class9, int i,
            AbstractFileLoader class9_9_) {
        if (!Class39_Sub12.aBoolean1498) {
            MouseRecorder.aClass57_551 = Queue.method994(component, 128, 265, (byte) -116);
            DrawingArea.reset();
            Class68.aClass57_1186 = Queue.method994(component, 128, 265, (byte) -109);
            DrawingArea.reset();
            Class26.aClass57_483 = Queue.method994(component, 509, 171, (byte) -114);
            DrawingArea.reset();
            Widget.aClass57_2115 = Queue.method994(component, 360, 132, (byte) -121);
            DrawingArea.reset();
            Class66.aClass57_1156 = Queue.method994(component, 360, 200, (byte) -114);
            DrawingArea.reset();
            Client.aClass57_1267 = Queue.method994(component, 202, 238, (byte) -118);
            DrawingArea.reset();
            Player.aClass57_2525 = Queue.method994(component, 203, 238, (byte) -118);
            DrawingArea.reset();
            Class14.aClass57_246 = Queue.method994(component, 74, 94, (byte) -107);
            DrawingArea.reset();
            Class32.aClass57_585 = Queue.method994(component, 75, 94, (byte) -123);
            DrawingArea.reset();
            byte[] is = class9_9_.lookupFile(Class4.aClass3_69,
                    Class39_Sub5_Sub14.blankJstr);
            DirectColorSprite class39_sub5_sub10_sub3 = new DirectColorSprite(is, component);
            MouseRecorder.aClass57_551.method1006(i ^ 0x42aa);
            class39_sub5_sub10_sub3.method677(0, 0);
            Class68.aClass57_1186.method1006(i ^ 0x42aa);
            class39_sub5_sub10_sub3.method677(-637, 0);
            Class26.aClass57_483.method1006(10);
            class39_sub5_sub10_sub3.method677(-128, 0);
            Widget.aClass57_2115.method1006(10);
            class39_sub5_sub10_sub3.method677(-202, -371);
            Class66.aClass57_1156.method1006(10);
            class39_sub5_sub10_sub3.method677(-202, -171);
            Client.aClass57_1267.method1006(10);
            class39_sub5_sub10_sub3.method677(0, -265);
            Player.aClass57_2525.method1006(10);
            class39_sub5_sub10_sub3.method677(-562, -265);
            Class14.aClass57_246.method1006(10);
            class39_sub5_sub10_sub3.method677(-128, -171);
            Class32.aClass57_585.method1006(10);
            class39_sub5_sub10_sub3.method677(-562, -171);
            int[] is_10_ = new int[class39_sub5_sub10_sub3.width];
            for (int i_11_ = 0; i_11_ < class39_sub5_sub10_sub3.height;
                    i_11_++) {
                for (int i_12_ = 0; class39_sub5_sub10_sub3.width > i_12_;
                        i_12_++) {
                    is_10_[i_12_] = (class39_sub5_sub10_sub3.pixelBuffer[(i_11_ * class39_sub5_sub10_sub3.width
                            + (class39_sub5_sub10_sub3.width
                            + (-i_12_ - 1)))]);
                }
                for (int i_13_ = 0; class39_sub5_sub10_sub3.width > i_13_;
                        i_13_++) {
                    class39_sub5_sub10_sub3.pixelBuffer[i_13_ + i_11_ * class39_sub5_sub10_sub3.width] = is_10_[i_13_];
                }
            }
            MouseRecorder.aClass57_551.method1006(10);
            class39_sub5_sub10_sub3.method677(382, 0);
            Class68.aClass57_1186.method1006(10);
            class39_sub5_sub10_sub3.method677(-255, 0);
            Class26.aClass57_483.method1006(10);
            class39_sub5_sub10_sub3.method677(254, 0);
            Widget.aClass57_2115.method1006(10);
            class39_sub5_sub10_sub3.method677(180, -371);
            Class66.aClass57_1156.method1006(10);
            class39_sub5_sub10_sub3.method677(180, -171);
            Client.aClass57_1267.method1006(i - 17046);
            class39_sub5_sub10_sub3.method677(382, -265);
            Player.aClass57_2525.method1006(10);
            class39_sub5_sub10_sub3.method677(-180, -265);
            Class14.aClass57_246.method1006(i - 17046);
            class39_sub5_sub10_sub3.method677(254, -171);
            Class32.aClass57_585.method1006(i ^ 0x42aa);
            class39_sub5_sub10_sub3.method677(-180, -171);
            class39_sub5_sub10_sub3 = Class39_Sub5_Sub9.method599(StillObject.aClass3_1481,
                    Class39_Sub5_Sub14.blankJstr,
                    class9);
            Class26.aClass57_483.method1006(10);
            class39_sub5_sub10_sub3.method670(382 - (class39_sub5_sub10_sub3.width) / 2 - 128,
                    18);
            TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4_1257 = Class39_Sub10.method867((byte) -79, class9,
                    Class23.aClass3_422,
                    Class39_Sub5_Sub14.blankJstr);
            StillGraphic.aClass39_Sub5_Sub10_Sub4_2337 = Class39_Sub10.method867((byte) -79, class9,
                    StillGraphic.aClass3_2339,
                    Class39_Sub5_Sub14.blankJstr);
            AbstractImage.aClass39_Sub5_Sub10_Sub4Array1002 = Class39_Sub5_Sub12.method713((byte) -106, class9,
                    Class39_Sub5_Sub14.blankJstr,
                    JSocket.aClass3_310);
            Deque.aClass39_Sub5_Sub10_Sub3_920 = new DirectColorSprite(128, 265);
            ISAAC.aClass39_Sub5_Sub10_Sub3_1096 = new DirectColorSprite(128, 265);
            for (int i_14_ = 0; i_14_ < 33920; i_14_++) {
                Deque.aClass39_Sub5_Sub10_Sub3_920.pixelBuffer[i_14_] = MouseRecorder.aClass57_551.buffer[i_14_];
            }
            for (int i_15_ = 0; i_15_ < 33920; i_15_++) {
                ISAAC.aClass39_Sub5_Sub10_Sub3_1096.pixelBuffer[i_15_] = Class68.aClass57_1186.buffer[i_15_];
            }
            BufferedFile.anIntArray338 = new int[256];
            for (int i_16_ = 0; i_16_ < 64; i_16_++) {
                BufferedFile.anIntArray338[i_16_] = i_16_ * 262144;
            }
            for (int i_17_ = 0; i_17_ < 64; i_17_++) {
                BufferedFile.anIntArray338[i_17_ + 64] = i_17_ * 1024 + 16711680;
            }
            for (int i_18_ = 0; i_18_ < 64; i_18_++) {
                BufferedFile.anIntArray338[i_18_ + 128] = i_18_ * 4 + 16776960;
            }
            for (int i_19_ = 0; i_19_ < 64; i_19_++) {
                BufferedFile.anIntArray338[i_19_ + 192] = 16777215;
            }
            Class23.anIntArray423 = new int[256];
            for (int i_20_ = 0; i_20_ < 64; i_20_++) {
                Class23.anIntArray423[i_20_] = i_20_ * 1024;
            }
            for (int i_21_ = 0; i_21_ < 64; i_21_++) {
                Class23.anIntArray423[i_21_ + 64] = i_21_ * 4 + 65280;
            }
            for (int i_22_ = 0; i_22_ < 64; i_22_++) {
                Class23.anIntArray423[i_22_ + 128] = i_22_ * 262144 + 65535;
            }
            if (i != 17056) {
                anInt1731 = -111;
            }
            for (int i_23_ = 0; i_23_ < 64; i_23_++) {
                Class23.anIntArray423[i_23_ + 192] = 16777215;
            }
            GroundItem.anIntArray2247 = new int[256];
            for (int i_24_ = 0; i_24_ < 64; i_24_++) {
                GroundItem.anIntArray2247[i_24_] = i_24_ * 4;
            }
            for (int i_25_ = 0; i_25_ < 64; i_25_++) {
                GroundItem.anIntArray2247[i_25_ + 64] = i_25_ * 262144 + 255;
            }
            for (int i_26_ = 0; i_26_ < 64; i_26_++) {
                GroundItem.anIntArray2247[i_26_ + 128] = i_26_ * 1024 + 16711935;
            }
            for (int i_27_ = 0; i_27_ < 64; i_27_++) {
                GroundItem.anIntArray2247[i_27_ + 192] = 16777215;
            }
            GroundItem.anIntArray2245 = new int[256];
            HashTable.anIntArray377 = new int[32768];
            Cache.anIntArray112 = new int[32768];
            Bzip2Entry.method1034(null, (byte) -107);
            Class39_Sub5_Sub14.password = Class39_Sub5_Sub14.blankJstr;
            Class53.anIntArray969 = new int[32768];
            Barrier.anInt155 = 0;
            ArchiveWorker.anIntArray1202 = new int[32768];
            Class39_Sub5_Sub14.username = Class39_Sub5_Sub14.blankJstr;
            if (Mob.musicVolume != 0 && !PlayerApperance.isLowMemory) {
                Class41.method899(0, true, Mob.musicVolume,
                        Player.scapeMainJstr,
                        false, Class39_Sub5_Sub14.blankJstr,
                        Projectile.fileLoader6,
                        10);
            } else {
                Class41.method900((byte) -73, 10);
            }
            OndemandHandler.writeStatus(false);
            Class39_Sub12.aBoolean1498 = true;
            ClientScript.aBoolean1690 = true;
        }
    }

    public static void method491(int i) {
        whiPrefixJstr = null;
        aClass3_1729 = null;
        aClass3_1733 = null;
        anIntArray1734 = null;
        widgetsLoaded = null;
    }

    static {
        whiPrefixJstr = JString.create("@whi@");
        anIntArray1734 = new int[32768];
        aClass3_1733 = JString.create("Lade Eingabe)2Steuerungsprogramm)3)3)3");
    }
}
