package com.jagex.io;

/* Class69 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.TextConstants;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.io.CacheIO;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.BitmapFont;
import com.jagex.utils.HashTable;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.awt.Graphics;
import unpackaged.Class14;
import unpackaged.Class23;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class41;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Timer;
import unpackaged.Class67;

public class ArchiveWorker implements Runnable {

    public static JString aClass3_1195;
    public static AbstractImage aClass57_1196;
    public static Cache aClass7_1197;
    public static int anInt1198;
    public static JString aClass3_1199 = JString.create("Loaded title screen");
    public static JString aClass3_1200;
    public static int[] queuedEffectIds;
    public static int[] anIntArray1202;
    public static int swapWidgetHash;
    public static JString aClass3_1204;
    public static int anInt1205;
    public static Timer aClass46_1206;
    public static JString mapedgeJstr;
    public static JSocket odSocket;
    public static JString aClass3_1209;
    public static int anInt1210;
    public static int anInt1211;

    public static void method1116(int i, byte i_0_, int i_1_, int i_2_,
            int i_3_) {
        for (int i_4_ = i_1_; i_1_ + i_3_ >= i_4_; i_4_++) {
            for (int i_5_ = i; i_5_ <= i + i_2_; i_5_++) {
                if (i_5_ >= 0 && i_5_ < 104 && i_4_ >= 0 && i_4_ < 104) {
                    ItemDefinition.aByteArrayArrayArray1671[0][i_5_][i_4_] = (byte) 127;
                    if (i_5_ == i && i_5_ > 0) {
                        Class67.heightMap[0][i_5_][i_4_] = (Class67.heightMap[0][i_5_ - 1][i_4_]);
                    }
                    if (i + i_2_ == i_5_ && i_5_ < 103) {
                        Class67.heightMap[0][i_5_][i_4_] = (Class67.heightMap[0][i_5_ + 1][i_4_]);
                    }
                    if (i_1_ == i_4_ && i_4_ > 0) {
                        Class67.heightMap[0][i_5_][i_4_] = (Class67.heightMap[0][i_5_][i_4_ - 1]);
                    }
                    if (i_3_ + i_1_ == i_4_ && i_4_ < 103) {
                        Class67.heightMap[0][i_5_][i_4_] = (Class67.heightMap[0][i_5_][i_4_ + 1]);
                    }
                }
            }
        }
    }

    public void run() {
        try {
            for (;;) {
                ArchiveRequest request;
                synchronized (JSocket.archiveRequests) {
                    request = (ArchiveRequest) JSocket.archiveRequests.getFirst();
                }
                if (request != null) {
                    if (request.type != 0) {
                        if (request.type == 1) {
                            request.payload = (request.cache.lookup((int) request.hash));
                            synchronized (JSocket.archiveRequests) {
                                HashTable.aClass49_365.offerLast(request);
                            }
                        }
                    } else {
                        request.cache.insert(request.payload, (int) request.hash, request.payload.length);
                        synchronized (JSocket.archiveRequests) {
                            request.unlinkDeque();
                        }
                    }
                    synchronized (Class4.archiveWorkerLock) {
                        if (Class23.archiveWorkerKeepAlive <= 1) {
                            Class23.archiveWorkerKeepAlive = 0;
                            Class4.archiveWorkerLock.notifyAll();
                            break;
                        }
                        Class23.archiveWorkerKeepAlive = 600;
                    }
                } else {
                    PlayerApperance.sleep(100L);
                    synchronized (Class4.archiveWorkerLock) {
                        if (Class23.archiveWorkerKeepAlive <= 1) {
                            Class23.archiveWorkerKeepAlive = 0;
                            Class4.archiveWorkerLock.notifyAll();
                            break;
                        }
                        Class23.archiveWorkerKeepAlive--;
                    }
                }
            }
        } catch (Exception exception) {
            ClassCheckRequest.reportError(exception, null);
        }
    }

    public static void method1117(int i) {
        aClass3_1204 = null;
        aClass3_1200 = null;
        aClass7_1197 = null;
        aClass57_1196 = null;
        mapedgeJstr = null;
        odSocket = null;
        aClass3_1195 = null;
        aClass46_1206 = null;
        queuedEffectIds = null;
        aClass3_1209 = null;
        aClass3_1199 = null;
        anIntArray1202 = null;
    }

    public static void fetchArchive(FileLoader fileLoader, CacheIO cache, int hash) {
        byte[] archiveSrc = null;
        synchronized (JSocket.archiveRequests) {
            for (ArchiveRequest request = (ArchiveRequest) JSocket.archiveRequests.getFirst(); request != null; request = ((ArchiveRequest) JSocket.archiveRequests.getNext())) {
                if (request.hash == (long) hash && request.cache == cache && request.type == 0) {
                    archiveSrc = request.payload;
                    break;
                }
            }
        }
        if (archiveSrc != null) {
            fileLoader.validateArchive(archiveSrc, hash, true, cache);
        } else {
            byte[] src = cache.lookup(hash);
            fileLoader.validateArchive(src, hash, true, cache);
        }
    }

    public static void method1119(int i, int i_8_, BitmapFont class39_sub5_sub10_sub1,
            int i_9_, int i_10_) {
        if (i_9_ == 41) {
            Class39_Sub5_Sub18.aClass57_2130.method1006(i_9_ ^ 0x23);
            Class39_Sub5_Sub14.aClass39_Sub5_Sub10_Sub4_1909.method695(0, 0);
            class39_sub5_sub10_sub1.method636(Class39_Sub5_Sub9.aClass3_1803,
                    55, 28, 16777215, true);
            if (i_8_ == 0) {
                class39_sub5_sub10_sub1.method636(ImageImpl.aClass3_1574,
                        55, 41, 65280, true);
            }
            if (i_8_ == 1) {
                class39_sub5_sub10_sub1.method636(TextConstants.aClass3_624, 55, 41,
                        16776960, true);
            }
            if (i_8_ == 2) {
                class39_sub5_sub10_sub1.method636(Timer.aClass3_881, 55, 41,
                        16711680, true);
            }
            if (i_8_ == 3) {
                class39_sub5_sub10_sub1.method636(Class39_Sub4.aClass3_1328,
                        55, 41, 65535, true);
            }
            class39_sub5_sub10_sub1.method636(Class32.aClass3_577, 184, 28,
                    16777215, true);
            if (i_10_ == 0) {
                class39_sub5_sub10_sub1.method636(ImageImpl.aClass3_1574,
                        184, 41, 65280, true);
            }
            if (i_10_ == 1) {
                class39_sub5_sub10_sub1.method636(TextConstants.aClass3_624, 184, 41,
                        16776960, true);
            }
            if (i_10_ == 2) {
                class39_sub5_sub10_sub1.method636(Timer.aClass3_881, 184, 41,
                        16711680, true);
            }
            class39_sub5_sub10_sub1.method636(Bzip2Entry.aClass3_1049, 324, 28,
                    16777215, true);
            if (i == 0) {
                class39_sub5_sub10_sub1.method636(ImageImpl.aClass3_1574,
                        324, 41, 65280, true);
            }
            if (i == 1) {
                class39_sub5_sub10_sub1.method636(TextConstants.aClass3_624, 324, 41,
                        16776960, true);
            }
            if (i == 2) {
                class39_sub5_sub10_sub1.method636(Timer.aClass3_881, 324, 41,
                        16711680, true);
            }
            class39_sub5_sub10_sub1.method625(Class34.aClass3_608, 417, 17, 85,
                    25, 16777215, true, 1, 1, 0);
            try {
                Graphics graphics = Class41.canvas.getGraphics();
                Class39_Sub5_Sub18.aClass57_2130.draw(graphics, 0,
                        453);
            } catch (Exception exception) {
                Class41.canvas.repaint();
            }
        }
    }

    public static NpcDefinition getNpcDefinition(int id) {
        NpcDefinition definition = ((NpcDefinition) Class39_Sub5_Sub11.npcDefinitionCache.get((long) id));
        if (definition != null) {
            return definition;
        }
        byte[] is = VarbitDefinition.npcFileLoader.lookupFile(9, id);
        definition = new NpcDefinition();
        definition.id = id;
        if (is != null) {
            definition.decode(new Buffer(is));
        }
        definition.method724((byte) 93);
        Class39_Sub5_Sub11.npcDefinitionCache.put(definition, (long) id);
        return definition;
    }

    public static void method1121(int i) {
        Class14.itemContainerCache = new HashTable(32);
    }

    static {
        aClass3_1195 = aClass3_1199;
        aClass3_1200 = JString.create("sideicons");
        aClass7_1197 = new Cache(100);
        queuedEffectIds = new int[50];
        swapWidgetHash = 0;
        anInt1205 = -1;
        anInt1210 = 0;
        mapedgeJstr = JString.create("mapedge");
        aClass3_1209 = JString.create("Anmelde)2Limit -Uberschritten)3");
        anInt1211 = 1;
        aClass3_1204 = JString.create(":  ");
    }
}
