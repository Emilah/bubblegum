package com.jagex.world;

/* Class39_Sub5_Sub4_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.entities.Player;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.world.World;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.od.OndemandRequest;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.io.FileLoader;
import com.jagex.awt.listeners.MouseListenerImpl;
import com.jagex.graphics.BitmapFont;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.util.Date;
import unpackaged.Class1;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class34;
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
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Timer;
import com.jagex.utils.MsTimer;
import com.jagex.audio.AudioHandler;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import com.jagex.script.ClientScript;
import com.jagex.utils.MouseRecorder;
import com.jagex.utils.JRuntimeException;
import com.jagex.script.ScriptState;
import unpackaged.TextureLoaderImpl;
import com.jagex.config.Widget;
import com.jagex.script.ScriptExecutor;

public abstract class Mob extends Entity {

    public int anInt2250;
    public int anInt2251;
    public int anInt2252;
    public static boolean aBoolean2253 = false;
    public int anInt2254;
    public int[] queueY = new int[10];
    public int anInt2256;
    public int anInt2257;
    public int[] anIntArray2258;
    public int anInt2259;
    public int anInt2260;
    public int anInt2261;
    public int anInt2262;
    public int anInt2263;
    public int anInt2264;
    public int anInt2265;
    public int anInt2266;
    public int anInt2267;
    public int anInt2268;
    public int anInt2269;
    public int anInt2270;
    public int anInt2271;
    public int anInt2272;
    public int[] anIntArray2273;
    public int anInt2274;
    public int fPositionX;
    public int anInt2276;
    public int anInt2277;
    public static JString aClass3_2278 = JString.create("Name des Gegenstands eingeben:");
    public int anInt2279;
    public int anInt2280;
    public static JString useJstrEng;
    public int anInt2282;
    public int anInt2283;
    public boolean[] queueRunning;
    public static int keyboardInputType = 0;
    public int[] anIntArray2286;
    public int anInt2287;
    public int anInt2288;
    public static JString aClass3_2289;
    public int anInt2290;
    public int anInt2291;
    public int anInt2292;
    public int anInt2293;
    public int anInt2294;
    public JString aClass3_2295;
    public int anInt2296;
    public int anInt2297;
    public boolean aBoolean2298;
    public static int writeQueueOffset;
    public int anInt2300;
    public int fPositionY;
    public static JString aClass3_2302;
    public int anInt2303;
    public int anInt2304;
    public int anInt2305;
    public int anInt2306;
    public static JString aClass3_2307;
    public int anInt2308;
    public static JString aClass3_2309;
    public static JString useJstr;
    public int anInt2311;
    public int anInt2312;
    public static int musicVolume;
    public int[] queueX;
    public static int anInt2315;
    public int anInt2316;
    public int anInt2317;
    public int anInt2318;
    public static JString aClass3_2319;

    public static void method507(int i) {
        aClass3_2278 = null;
        aClass3_2319 = null;
        useJstrEng = null;
        aClass3_2289 = null;
        aClass3_2302 = null;
        aClass3_2307 = null;
        aClass3_2309 = null;
        useJstr = null;
    }

    public void setLocation(int i_1_, int i, boolean resetQueue) {
        if (anInt2268 != -1
                && AbstractMidiHandler.method1064(anInt2268, (byte) 54).anInt1837 == 1) {
            anInt2268 = -1;
        }
        if (!resetQueue) {
            int i_2_ = -queueX[0] + i_1_;
            int i_3_ = -queueY[0] + i;
            if (i_2_ >= -8 && i_2_ <= 8 && i_3_ >= -8 && i_3_ <= 8) {
                if (anInt2312 < 9) {
                    anInt2312++;
                }
                for (int i_4_ = anInt2312; i_4_ > 0; i_4_--) {
                    queueX[i_4_] = queueX[i_4_ - 1];
                    queueY[i_4_] = queueY[i_4_ - 1];
                    queueRunning[i_4_] = queueRunning[i_4_ - 1];
                }
                queueX[0] = i_1_;
                queueRunning[0] = false;
                queueY[0] = i;
                return;
            }
        }
        queueX[0] = i_1_;
        anInt2312 = 0;
        anInt2254 = 0;
        queueY[0] = i;
        anInt2274 = 0;
        fPositionY = queueX[0] * 128 + anInt2297 * 64;
        fPositionX = queueY[0] * 128 + anInt2297 * 64;
    }

    public static void method509(byte i) {
        if (ISAAC.aBoolean1100 && i == 39) {
            Widget class39_sub5_sub17 = Class62_Sub2.getWidgetChild(Class41.useWithWidgetId, MouseRecorder.useWithAmountChildren);
            if (class39_sub5_sub17 != null
                    && class39_sub5_sub17.anObjectArray2004 != null) {
                ScriptExecutor.executeClientScript(0, class39_sub5_sub17.anObjectArray2004, null, 111,
                        0, class39_sub5_sub17, 0);
            }
            ISAAC.aBoolean1100 = false;
        }
    }

    public boolean method510(byte i) {
        return false;
    }

    public static void method511(byte i) {
        Class30.aLong536 = 0L;
        Cache.mouseRecorder.anInt561 = 0;
        Timer.anInt882 = 0;
        Class39_Sub5_Sub4_Sub2.anInt2220 = 0;
        OndemandRequest.anInt1724 = 0;
        ArchiveRequest.anInt1408 = 0;
        Class39_Sub12.anInt1490 = 0;
        VarpDefinition.anInt1976 = 0;
        Class4.anInt65 = 0;
        Class4.anInt60 = 0;
        Class26.anInt482 = 0;
        StillObject.anInt1473 = 0;
        if (i != 95) {
            method507(-79);
        }
        Class39_Sub5_Sub12.anInt1848 = 0;
        Class39_Sub5_Sub6.anInt1759 = 0;
        Class34.anInt604 = 0;
        Projectile.anInt2203 = 0;
        JString.aBoolean1232 = true;
        Class43.aBoolean802 = true;
        FileLoader.method174(-122);
        FrameBuffer.outgoingBuffer.offset = 0;
        Class39_Sub12.aBoolean1493 = false;
        Class39_Sub5_Sub11.anInt1827 = 0;
        ScriptState.anInt448 = -1;
        Class4.frameId = -1;
        MouseListenerImpl.anInt787 = 0;
        FileLoader.anInt1283 = -1;
        Class39_Sub5_Sub11.incomingBuffer.offset = 0;
        ClassCheckRequest.systemUpdateTime = 0;
        Class63.anInt1117 = -1;
        Class39_Sub5_Sub11.actionOffset = 0;
        ClientScript.anInt1692 = 0;
        StillGraphic.method535((byte) 61, 0);
        for (int i_5_ = 0; i_5_ < 100; i_5_++) {
            Class2.messageBodies[i_5_] = null;
        }
        ArchiveRequest.anInt1411 = -1;
        Class13.anInt208 = 0;
        Class34.anInt605 = (int) (Math.random() * 20.0) - 10 & 0x7ff;
        ArchiveWorker.anInt1210 = 0;
        JRuntimeException.anInt1216 = (int) (Math.random() * 100.0) - 50;
        ClassCheckRequest.anInt1386 = (int) (Math.random() * 30.0) - 20;
        ArchiveRequest.anInt1401 = (int) (Math.random() * 120.0) - 60;
        SubNode.anInt1344 = (int) (Math.random() * 80.0) - 40;
        ArchiveRequest.anInt1407 = 0;
        Projectile.queuedEffectOffset = 0;
        ISAAC.aBoolean1100 = false;
        TraversalMap.anInt515 = 0;
        Class30.anInt544 = 0;
        Buffer.anInt1361 = (int) (Math.random() * 110.0) - 55;
        Class39_Sub5_Sub7.minimapState = 0;
        for (int i_6_ = 0; i_6_ < 2048; i_6_++) {
            Class14.players[i_6_] = null;
            ISAAC.appearanceBuffers[i_6_] = null;
        }
        for (int i_7_ = 0; i_7_ < 32768; i_7_++) {
            GroundItem.npcs[i_7_] = null;
        }
        Cache.localPlayer = Class14.players[2047] = new Player();
        Class23.projectiles.removeAll();
        JRuntimeException.stillGraphics.removeAll();
        for (int i_8_ = 0; i_8_ < 4; i_8_++) {
            for (int i_9_ = 0; i_9_ < 104; i_9_++) {
                for (int i_10_ = 0; i_10_ < 104; i_10_++) {
                    Class20.groundItems[i_8_][i_9_][i_10_] = null;
                }
            }
        }
        Class15.stillObjects = new Deque();
        Class14.anInt232 = 0;
        Class4.anInt62 = 0;
        for (int i_11_ = 0; ObjectDefinition.amountVarpDefinitions > i_11_; i_11_++) {
            VarpDefinition class39_sub5_sub16 = AudioHandler.getVarp(i_11_);
            if (class39_sub5_sub16 != null
                    && class39_sub5_sub16.type == 0) {
                Class39_Sub5_Sub4_Sub2.defaultStateValues[i_11_] = 0;
                Client.stateValues[i_11_] = 0;
            }
        }
        Class62_Sub2.method1084((byte) -87, ISAAC.chatboxWidgetId);
        ISAAC.chatboxWidgetId = -1;
        Class62_Sub2.method1084((byte) 107, Class39_Sub5_Sub14.chatboxOverlayId);
        Class39_Sub5_Sub14.chatboxOverlayId = -1;
        Class62_Sub2.method1084((byte) -121, StillObject.viewOverlayId);
        StillObject.viewOverlayId = -1;
        Class62_Sub2.method1084((byte) -122, SubNode.screenWidgetId);
        SubNode.screenWidgetId = -1;
        Class62_Sub2.method1084((byte) -45, ClientScript.screenOverlayId);
        ClientScript.screenOverlayId = -1;
        Class62_Sub2.method1084((byte) 107, StillGraphic.tabOverlayId);
        StillGraphic.tabOverlayId = -1;
        Class62_Sub2.method1084((byte) -108, Class26.viewWidgetId);
        Node.currentTabId = 3;
        ClientScript.anInt1703 = -1;
        TextConstants.aClass3_1714 = null;
        Class39_Sub10.anInt1420 = -1;
        keyboardInputType = 0;
        Class26.viewWidgetId = -1;
        Class39_Sub12.aBoolean1489 = false;
        Class39_Sub12.aBoolean1493 = false;
        Huffman.anInt756 = 0;
        ClientScript.playerApperance.method925(null, false, new int[5],
                i ^ 0x30, -1);
        for (int i_12_ = 0; i_12_ < 5; i_12_++) {
            Class39_Sub14.playerOptions[i_12_] = null;
            JRuntimeException.aBooleanArray1225[i_12_] = false;
        }
        ArchiveWorker.method1121(-116);
        AbstractImage.aBoolean1000 = true;
    }

    public static int method512(int i, int i_13_) {
        return (int) (Math.log((double) i_13_ * 0.00390625) * 868.5889638065036
                + 0.5);
    }

    public void method513(int i, int i_14_, int i_15_, int i_16_) {
        for (int i_17_ = 0; i_17_ < 4; i_17_++) {
            if (i_14_ >= anIntArray2286[i_17_]) {
                anIntArray2273[i_17_] = i_15_;
                anIntArray2258[i_17_] = i_16_;
                anIntArray2286[i_17_] = i_14_ + 70;
                break;
            }
        }
    }

    public void method515(int i) {
        anInt2312 = i;
        anInt2254 = 0;
    }

    public static void method516(World class38, byte i, int i_149_,
            TraversalMap[] class27s, byte[] is, int i_150_) {
        Buffer class39_sub6 = new Buffer(is);
        int i_151_ = -1;
        for (;;) {
            int i_152_ = class39_sub6.getUsmart();
            if (i_152_ == 0) {
                break;
            }
            i_151_ += i_152_;
            int i_153_ = 0;
            for (;;) {
                int i_154_ = class39_sub6.getUsmart();
                if (i_154_ == 0) {
                    break;
                }
                i_153_ += i_154_ - 1;
                int i_155_ = i_153_ & 0x3f;
                int i_156_ = class39_sub6.getUint8();
                int i_157_ = i_153_ >> 12;
                int i_158_ = i_156_ >> 2;
                int i_159_ = i_153_ >> 6 & 0x3f;
                int i_160_ = i_156_ & 0x3;
                int i_161_ = i_155_ + i_150_;
                int i_162_ = i_149_ + i_159_;
                if (i_162_ > 0 && i_161_ > 0 && i_162_ < 103 && i_161_ < 103) {
                    TraversalMap class27 = null;
                    int i_163_ = i_157_;
                    if ((TextureLoaderImpl.tileFlags[1][i_162_][i_161_]
                            & 0x2)
                            == 2) {
                        i_163_--;
                    }
                    if (i_163_ >= 0) {
                        class27 = class27s[i_163_];
                    }
                    AbstractMidiHandler.method1059(i_158_, class38, i_161_, i_151_,
                            i_157_, i_162_, class27, true,
                            i_160_);
                }
            }
        }
    }

    public static void method517(byte i) {
        synchronized (Class4.archiveWorkerLock) {
            if (Class23.archiveWorkerKeepAlive != 0) {
                Class23.archiveWorkerKeepAlive = 1;
                try {
                    Class4.archiveWorkerLock.wait();
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
    }

    public void queueStep(int type, boolean isRunning) {
        int positionY = queueY[0];
        int positionX = queueX[0];
        if (type == 0) {
            positionX--;
            positionY++;
        }
        if (anInt2268 != -1
                && AbstractMidiHandler.method1064(anInt2268, (byte) 54).anInt1837 == 1) {
            anInt2268 = -1;
        }
        if (anInt2312 < 9) {
            anInt2312++;
        }
        if (type == 1) {
            positionY++;
        }
        for (int i = anInt2312; i > 0; i--) {
            queueX[i] = queueX[i - 1];
            queueY[i] = queueY[i - 1];
            queueRunning[i] = queueRunning[i - 1];
        }
        queueRunning[0] = isRunning;
        if (type == 2) {
            positionY++;
            positionX++;
        }
        if (type == 3) {
            positionX--;
        }
        if (type == 4) {
            positionX++;
        }
        if (type == 5) {
            positionX--;
            positionY--;
        }
        if (type == 6) {
            positionY--;
        }
        if (type == 7) {
            positionX++;
            positionY--;
        }
        queueX[0] = positionX;
        queueY[0] = positionY;
    }

    public Mob() {
        anInt2252 = -1000;
        anInt2254 = 0;
        anInt2250 = 32;
        anInt2264 = -1;
        anInt2257 = -1;
        anInt2271 = 0;
        anInt2267 = 0;
        anInt2259 = 100;
        anInt2260 = -1;
        anInt2262 = -1;
        anInt2282 = -1;
        anInt2263 = -1;
        anIntArray2286 = new int[4];
        anInt2268 = -1;
        anInt2293 = -1;
        anInt2265 = 0;
        anInt2291 = 0;
        anInt2276 = 0;
        aClass3_2295 = null;
        aBoolean2298 = false;
        anInt2296 = 0;
        anInt2303 = -1;
        anIntArray2273 = new int[4];
        anInt2304 = 0;
        anInt2306 = 0;
        anIntArray2258 = new int[4];
        anInt2283 = 0;
        anInt2274 = 0;
        queueRunning = new boolean[10];
        anInt2312 = 0;
        anInt2305 = 0;
        anInt2300 = 0;
        queueX = new int[10];
        anInt2290 = 0;
        anInt2280 = -1;
        anInt2270 = -1;
        anInt2308 = 200;
        anInt2317 = -1;
        anInt2316 = 0;
        anInt2297 = 1;
        anInt2311 = 0;
    }

    static {
        useJstrEng = JString.create("Use");
        aClass3_2302 = JString.create("Unerwartete Antwort vom Anmelde)2Server)3");
        aClass3_2307 = JString.create("Members object");
        aClass3_2309 = JString.create("Registrierter Benutzer");
        writeQueueOffset = 0;
        musicVolume = 255;
        aClass3_2319 = JString.create("(X");
        useJstr = useJstrEng;
        aClass3_2289 = aClass3_2307;
    }
}
