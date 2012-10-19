package com.jagex.world.entities;

import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import com.jagex.io.ArchiveRequest;
import com.jagex.awt.JCanvas;
import unpackaged.Class25;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.FileLoader;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.graphics.ImageImpl;
import com.jagex.config.Model;
import com.jagex.utils.NameTable;
import com.jagex.config.Widget;

/* Class39_Sub5_Sub4_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class StillGraphic extends Entity {

    public int anInt2320;
    public int anInt2321;
    public int anInt2322;
    public int anInt2323;
    public static Cache aClass7_2324 = new Cache(50);
    public Class39_Sub5_Sub11 aClass39_Sub5_Sub11_2325;
    public static int anInt2326;
    public static JString aClass3_2327;
    public static JString aClass3_2328;
    public static JString aClass3_2329;
    public static JString aClass3_2330 = JString.create(" more options");
    public static long aLong2331;
    public static JString aClass3_2332;
    public boolean aBoolean2333 = false;
    public static int anInt2334;
    public static JString aClass3_2335;
    public int anInt2336;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_2337;
    public static int tabOverlayId;
    public static JString aClass3_2339 = JString.create("titlebutton");
    public static JString aClass3_2340;
    public static JString aClass3_2341 = (JString.create("sind fehlgeschlagen)3 Bitte warten Sie 5 Minuten)1"));
    public static boolean aBoolean2342;
    public static JString aClass3_2343;
    public static JString aClass3_2344;
    public static JString aClass3_2345;
    public static JString aClass3_2346;
    public int anInt2347;
    public static JString aClass3_2348;
    public int anInt2349 = 0;
    public static JString aClass3_2350;
    public static JString aClass3_2351;
    public int anInt2352 = 0;
    public static JString aClass3_2353;

    public static void method530(int i, int i_0_) {
        if (i_0_ != -1 && Entity.widgetsLoaded[i_0_]
                && AbstractMidiHandler.widgets[i_0_] != null) {
            for (int i_1_ = 0;
                    i_1_ < (AbstractMidiHandler.widgets[i_0_]).length;
                    i_1_++) {
                Widget class39_sub5_sub17 = (AbstractMidiHandler.widgets[i_0_][i_1_]);
                if (class39_sub5_sub17 != null) {
                    class39_sub5_sub17.flags = class39_sub5_sub17.anInt1998;
                }
            }
        }
    }

    public static void method531(byte i) {
        aClass3_2330 = null;
        aClass3_2346 = null;
        aClass3_2341 = null;
        aClass3_2353 = null;
        aClass3_2328 = null;
        aClass3_2327 = null;
        aClass3_2329 = null;
        aClass3_2344 = null;
        aClass3_2351 = null;
        aClass3_2335 = null;
        aClass3_2343 = null;
        aClass39_Sub5_Sub10_Sub4_2337 = null;
        aClass3_2340 = null;
        aClass3_2348 = null;
        aClass3_2350 = null;
        aClass7_2324 = null;
        aClass3_2345 = null;
        aClass3_2339 = null;
        aClass3_2332 = null;
    }

    public void method532(int i, int i_2_) {
        if (!aBoolean2333) {
            anInt2349 += i;
            while (anInt2349
                    > aClass39_Sub5_Sub11_2325.anIntArray1831[anInt2352]) {
                anInt2349 -= aClass39_Sub5_Sub11_2325.anIntArray1831[anInt2352];
                anInt2352++;
                if (anInt2352
                        >= aClass39_Sub5_Sub11_2325.anIntArray1833.length) {
                    aBoolean2333 = true;
                    break;
                }
            }
        }
    }

    public static void parseLocalPlayerUpdate() {
        Class39_Sub5_Sub11.incomingBuffer.initBitAccess();
        int update = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
        if (update != 0) {
            int type = Class39_Sub5_Sub11.incomingBuffer.getBits(2);
            if (type == 0) {
                ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = 2047;
            } else if (type == 1) {
                int i_5_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                Cache.localPlayer.queueStep(i_5_, false);
                int doUpdate = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                if (doUpdate == 1) {
                    ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = 2047;
                }
            } else if (type == 2) {
                int i_7_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                Cache.localPlayer.queueStep(i_7_, true);
                int i_8_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                Cache.localPlayer.queueStep(i_8_, true);
                int doUpdate = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                if (doUpdate == 1) {
                    ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = 2047;
                }
            } else if (type == 3) {
                int positionX = Class39_Sub5_Sub11.incomingBuffer.getBits(7);
                int doUpdate = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                if (doUpdate == 1) {
                    ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = 2047;
                }
                NameTable.height = Class39_Sub5_Sub11.incomingBuffer.getBits(2);
                int positionY = Class39_Sub5_Sub11.incomingBuffer.getBits(7);
                int i_13_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                Cache.localPlayer.setLocation(positionX, positionY, i_13_ == 1);
            }
        }
    }

    public static void validateArchives() {
        for (;;) {
            ArchiveRequest request;
            synchronized (JSocket.archiveRequests) {
                request = (ArchiveRequest) HashTable.aClass49_365.pollFirst();
            }
            if (request == null) {
                break;
            }
            request.loader.validateArchive(request.payload, (int) request.hash, false, request.cache);
        }
    }

    public static void method535(byte i, int i_14_) {
        FileLoader.anInt1302 = i_14_;
    }

    public Model method489(boolean bool) {
        Class39_Sub5_Sub18 class39_sub5_sub18 = Huffman.method881(0, anInt2320);
        if (bool != true) {
            method535((byte) -14, -80);
        }
        Model class39_sub5_sub4_sub6;
        if (!aBoolean2333) {
            class39_sub5_sub4_sub6 = class39_sub5_sub18.method778(180, anInt2352);
        } else {
            class39_sub5_sub4_sub6 = class39_sub5_sub18.method778(180, -1);
        }
        if (class39_sub5_sub4_sub6 == null) {
            return null;
        }
        return class39_sub5_sub4_sub6;
    }

    public static JString decodeHuffmans(Buffer buffer, int length) {
        try {
            JString jstr = new JString();
            jstr.length = buffer.getUsmart();
            if (jstr.length > length) {
                jstr.length = length;
            }
            jstr.bytes = new byte[jstr.length];
            buffer.offset += Class25.huffmans.decode(0, jstr.bytes, jstr.length, buffer.offset, buffer.payload);
            return jstr;
        } catch (Exception exception) {
            return JCanvas.aClass3_20;
        }
    }

    public StillGraphic(int i, int i_16_, int i_17_, int i_18_,
            int i_19_, int i_20_, int i_21_) {
        anInt2322 = i_16_;
        anInt2323 = i_17_;
        anInt2321 = i_18_;
        anInt2347 = i_19_;
        anInt2336 = i_20_ + i_21_;
        anInt2320 = i;
        int i_22_ = Huffman.method881(0, anInt2320).anInt2126;
        if (i_22_ == -1) {
            aBoolean2333 = true;
        } else {
            aBoolean2333 = false;
            aClass39_Sub5_Sub11_2325 = AbstractMidiHandler.method1064(i_22_, (byte) 54);
        }
    }

    static {
        aClass3_2332 = JString.create("Enter name:");
        anInt2326 = 2301979;
        tabOverlayId = -1;
        aClass3_2344 = JString.create("Keine Antwort vom Anmelde)2Server)3");
        aClass3_2328 = JString.create("Mem:");
        aClass3_2340 = aClass3_2332;
        aClass3_2346 = aClass3_2330;
        aClass3_2335 = JString.create("Absender:");
        aClass3_2351 = JString.create("Loading ignore list");
        aLong2331 = 0L;
        aClass3_2329 = JString.create("Sichtbare Karte vorbereitet)3");
        aClass3_2350 = JString.create("Close");
        aClass3_2348 = JString.create("Stufe)2");
        aClass3_2353 = aClass3_2351;
        aClass3_2345 = JString.create("Please reload this page)3");
        aClass3_2327 = aClass3_2345;
        aClass3_2343 = aClass3_2350;
    }
}
