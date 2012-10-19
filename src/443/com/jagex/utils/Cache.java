package com.jagex.utils;

import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.graphics.BitmapFont;
import com.jagex.io.Buffer;
import com.jagex.io.CacheIO;
import com.jagex.awt.JCanvas;
import unpackaged.Class1;
import com.jagex.world.Barrier;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class33;
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
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class50;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import com.jagex.audio.AudioHandler;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import com.jagex.Client;
import com.jagex.awt.JApplet;
import com.jagex.script.ClientScript;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FrameBuffer;
import com.jagex.world.entities.GroundItem;
import com.jagex.config.ItemDefinition;
import com.jagex.graphics.JImage;
import com.jagex.awt.events.JKeyListener;
import com.jagex.awt.events.JMouseListener;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.config.ObjectDefinition;
import com.jagex.od.OndemandRequest;
import com.jagex.world.entities.Player;
import com.jagex.world.entities.Projectile;
import com.jagex.script.ScriptState;
import com.jagex.sign.Signlink;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.map.TraversalMap;
import com.jagex.config.Widget;

/* Class7 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class Cache {

    public static int anInt101;
    public static JString aClass3_102 = JString.create("Bitte laden Sie die Seite neu)3");
    public static JString aClass3_103;
    public static byte[][] aByteArrayArray104;
    public static JString aClass3_105;
    public static HashTable aClass19_106;
    public static JString aClass3_107;
    public static Signlink webSignlink;
    public static Player localPlayer;
    public SubNode aClass39_Sub5_110 = new SubNode();
    public static byte[] aByteArray111 = {95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109,
        110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122,
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    public static int[] anIntArray112;
    public static JString huffmanJstr;
    public static JString aClass3_114;
    public static JString aClass3_115;
    public static JString aClass3_116;
    public static JString worldIsFullJstr;
    public static int anInt118;
    public int maximumSize;
    public HashTable hashTable;
    public static boolean aBoolean121;
    public Queue addedNodes = new Queue();
    public static MouseRecorder mouseRecorder;
    public int spaceRemaining;

    public static void drawMessages(byte i) {
        if (Class2.anInt53 != 0) {
            BitmapFont font = Class39_Sub5_Sub14.p12fullFont;
            int i_0_ = 0;
            if (ClassCheckRequest.systemUpdateTime != 0) {
                i_0_ = 1;
            }
            for (int i_1_ = 0; i_1_ < 100; i_1_++) {
                if (Class2.messageBodies[i_1_] != null) {
                    int type = Client.messageTypes[i_1_];
                    JString prefix = StillObject.messagePrefixes[i_1_];
                    int i_3_ = 0;
                    if (prefix != null
                            && prefix.beginsWith(Class37.crown1Jstr)) {
                        prefix = prefix.substring(5);
                        i_3_ = 1;
                    }
                    if (prefix != null
                            && prefix.beginsWith(Class53.crown2Jstr)) {
                        prefix = prefix.substring(5);
                        i_3_ = 2;
                    }
                    if ((type == 3 || type == 7)
                            && (type == 7 || NameTable.anInt177 == 0
                            || (NameTable.anInt177 == 1
                            && JString.method60(21469, prefix)))) {
                        int i_4_ = -(i_0_ * 13) + 329;
                        i_0_++;
                        int i_5_ = 4;
                        font.method647((VarpDefinition.aClass3_1991),
                                i_5_, i_4_, 0);
                        font.method647((VarpDefinition.aClass3_1991),
                                i_5_, i_4_ - 1,
                                65535);
                        i_5_ += font
                                .method637(VarpDefinition.aClass3_1991);
                        i_5_ += font.method645(32);
                        if (i_3_ == 1) {
                            TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1247[0]
                                    .method695(i_5_, i_4_ - 12);
                            i_5_ += 14;
                        }
                        if (i_3_ == 2) {
                            TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1247[1]
                                    .method695(i_5_, i_4_ - 12);
                            i_5_ += 14;
                        }
                        font.method647((Class39_Sub5_Sub11.join(new JString[]{prefix, MouseRecorder.colonJstr,
                                    Class2.messageBodies[i_1_]})),
                                i_5_, i_4_, 0);
                        font.method647((Class39_Sub5_Sub11.join(new JString[]{prefix, MouseRecorder.colonJstr,
                                    Class2.messageBodies[i_1_]})),
                                i_5_, i_4_ - 1, 65535);
                        if (i_0_ >= 5) {
                            break;
                        }
                    }
                    if (type == 5 && NameTable.anInt177 < 2) {
                        int i_6_ = 329 - i_0_ * 13;
                        i_0_++;
                        font.method647((Class2.messageBodies[i_1_]),
                                4, i_6_, 0);
                        font.method647((Class2.messageBodies[i_1_]),
                                4, i_6_ - 1, 65535);
                        if (i_0_ >= 5) {
                            break;
                        }
                    }
                    if (type == 6 && NameTable.anInt177 < 2) {
                        int i_7_ = -(i_0_ * 13) + 329;
                        font.method647((Class39_Sub5_Sub11.join(new JString[]{Class39_Sub14.toJstr,
                                    Class62_Sub2.spaceJstr,
                                    prefix, MouseRecorder.colonJstr,
                                    Class2.messageBodies[i_1_]})),
                                4, i_7_, 0);
                        i_0_++;
                        font.method647((Class39_Sub5_Sub11.join(new JString[]{Class39_Sub14.toJstr,
                                    Class62_Sub2.spaceJstr,
                                    prefix, MouseRecorder.colonJstr,
                                    Class2.messageBodies[i_1_]})),
                                4, i_7_ - 1, 65535);
                        if (i_0_ >= 5) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void remove(long hash) {
        SubNode node = (SubNode) hashTable.get(hash);
        if (node != null) {
            node.unlinkDeque();
            node.unlinkQueue();
            spaceRemaining++;
        }
    }

    public SubNode get(long hash) {
        SubNode node = (SubNode) hashTable.get(hash);
        if (node != null) {
            addedNodes.offerFirst(node);
        }
        return node;
    }

    public void clear() {
        for (;;) {
            SubNode node = addedNodes.pollFirst();
            if (node == null) {
                break;
            }
            node.unlinkDeque();
            node.unlinkQueue();
        }
        spaceRemaining = maximumSize;
    }

    public void put(SubNode node, long hash) {
        if (spaceRemaining != 0) {
            spaceRemaining--;
        } else {
            SubNode nodeToRemove = addedNodes.pollFirst();
            nodeToRemove.unlinkDeque();
            nodeToRemove.unlinkQueue();
            if (nodeToRemove == aClass39_Sub5_110) {
                nodeToRemove = addedNodes.pollFirst();
                nodeToRemove.unlinkDeque();
                nodeToRemove.unlinkQueue();
            }
        }
        hashTable.put(hash, node);
        addedNodes.offerFirst(node);
    }

    public static void method136(int i) {
        aByteArrayArray104 = null;
        aClass3_114 = null;
        mouseRecorder = null;
        aClass3_102 = null;
        localPlayer = null;
        aClass19_106 = null;
        aClass3_105 = null;
        aClass3_107 = null;
        aClass3_115 = null;
        aByteArray111 = null;
        aClass3_116 = null;
        huffmanJstr = null;
        anIntArray112 = null;
        webSignlink = null;
        aClass3_103 = null;
        worldIsFullJstr = null;
    }

    public Cache(int size) {
        maximumSize = size;
        int counter = 1;
        spaceRemaining = size;
        for (/**/; counter + counter < size; counter += counter) {
            /* empty */
        }
        hashTable = new HashTable(counter);
    }

    static {
        anInt101 = 0;
        huffmanJstr = JString.create("huffman");
        aClass3_103 = JString.create(" @whi@(X");
        aClass3_107 = JString.create("backhmid1");
        worldIsFullJstr = JString.create("This world is full)3");
        aClass3_115 = JString.create("headicons_hint");
        aClass3_116 = JString.create("Service unavailable)3");
        aClass3_114 = aClass3_116;
        aClass3_105 = worldIsFullJstr;
        aBoolean121 = false;
        anInt118 = 0;
    }
}
