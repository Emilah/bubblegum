package com.jagex.utils;

import com.jagex.config.Model;
import com.jagex.script.ClientScript;
import com.jagex.utils.JRuntimeException;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.awt.JCanvas;
import com.jagex.awt.listeners.JMouseListener;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import unpackaged.Class1;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class20;
import unpackaged.Class26;
import unpackaged.Class33;
import unpackaged.Class39_Sub10;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import com.jagex.world.Entity;
import unpackaged.Class41;
import unpackaged.Class44;
import unpackaged.Class66;
import com.jagex.world.entities.player.PlayerApperance;

/* Class39_Sub13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class ItemContainer extends Node {

    public static int localId = -1;
    public static JMouseListener aClass42_1502;
    public static JString aClass3_1503;
    public int[] itemAmts = new int[1];
    public int[] itemIds = {-1};
    public static JString aClass3_1506 = JString.create("Loaded update list");
    public static JString aClass3_1507;
    public static JString aClass3_1508;
    public static JString dropJstr;

    public static int method873(int i, int i_0_, int i_1_, int i_2_) {
        if (i > 179) {
            i_0_ /= 2;
        }
        if (i > 192) {
            i_0_ /= 2;
        }
        if (i > 217) {
            i_0_ /= 2;
        }
        if (i > 243) {
            i_0_ /= 2;
        }
        int i_3_ = i / 2 + ((i_0_ / 32 << 7) + (i_2_ / 4 << 10));
        return i_3_;
    }

    public static void method874(byte i) {
        aClass3_1507 = null;
        dropJstr = null;
        aClass42_1502 = null;
        aClass3_1503 = null;
        aClass3_1508 = null;
        aClass3_1506 = null;
    }

    public static void method875(int i) {
        int i_4_ = -1;
        if (Class13.anInt208 == 0 && !ISAAC.aBoolean1100) {
            JString.queueAction(33, 0,ISAAC.mousePositionX,
                    Class33.mousePositionY, Class39_Sub4.aClass3_1338, Class66.blankString);
        }
        int i_5_ = 0;
        for (/**/; i_5_ < Model.anInt2413; i_5_++) {
            int hash = Model.anIntArray2408[i_5_];
            int positionX = hash & 0x7f;
            int positionY = (hash & 0x3f85) >> 7;
            int type = (hash & 0x61f56755) >> 29;
            int id = hash >> 14 & 0x7fff;
            if (i_4_ != hash) {
                i_4_ = hash;
                if (type == 2 && Class44.world.method359(NameTable.height, positionX, positionY, hash) >= 0) {
                    ObjectDefinition definition = JCanvas.getObjectDefinition(id);
                    if (definition.anIntArray1961 != null) {
                        definition = definition.method733(0);
                    }
                    if (definition == null) {
                        continue;
                    }
                    if (Class13.anInt208 == 1) {
                        JString.queueAction(45, hash,positionX,
                                positionY, Mob.useJstr,
                                (Class39_Sub5_Sub11.join((new JString[]{Class39_Sub10.useWithItemJstr,
                                    TraversalMap.aClass3_510,
                                    (definition.name)}))));
                    } else if (!ISAAC.aBoolean1100) {
                        JString[] options = definition.options;
                        if (PlayerApperance.displayOptionIds) {
                            options = BufferedFile.method225(options);
                        }
                        if (options != null) {
                            for (int optionId = 4; optionId >= 0; optionId--) {
                                if (options[optionId] != null) {
                                    int actionType = 0;
                                    if (optionId == 0) {
                                        actionType = 55;
                                    }
                                    if (optionId == 1) {
                                        actionType = 57;
                                    }
                                    if (optionId == 2) {
                                        actionType = 43;
                                    }
                                    if (optionId == 3) {
                                        actionType = 6;
                                    }
                                    if (optionId == 4) {
                                        actionType = 1005;
                                    }
                                    JString.queueAction(actionType, hash, positionX, positionY, options[optionId], (Class39_Sub5_Sub11.join((new JString[]{TextConstants.cyanPrefixJstr, (definition.name)}))));
                                }
                            }
                        }
                        JString.queueAction(1006, definition.anInt1931 << 14, positionX, positionY, JRuntimeException.examineJstr, (Class39_Sub5_Sub11.join(new JString[]{TextConstants.cyanPrefixJstr, (definition.name)})));
                    } else if ((Class41.anInt776 & 0x4) == 4) {
                        JString.queueAction(12, hash,positionX, positionY, TextConstants.aClass3_1273,
                                (Class39_Sub5_Sub11.join(new JString[]{Class14.aClass3_216,
                                    TraversalMap.aClass3_510,
                                    (definition.name)})));
                    }
                }
                if (type == 1) {
                    Npc npc = (GroundItem.npcs[id]);
                    if ((npc.definition.anInt1870) == 1 && (npc.fPositionY & 0x7f) == 64 && ((npc.fPositionX & 0x7f) == 64)) {
                        for (int i_13_ = 0; ArchiveWorker.anInt1210 > i_13_;
                                i_13_++) {
                            Npc class39_sub5_sub4_sub4_sub1_14_ = (GroundItem.npcs[Entity.anIntArray1734[i_13_]]);
                            if (class39_sub5_sub4_sub4_sub1_14_ != null
                                    && (class39_sub5_sub4_sub4_sub1_14_
                                    != npc)
                                    && (class39_sub5_sub4_sub4_sub1_14_.definition.anInt1870) == 1
                                    && (npc.fPositionY
                                    == (class39_sub5_sub4_sub4_sub1_14_.fPositionY))
                                    && (npc.fPositionX
                                    == (class39_sub5_sub4_sub4_sub1_14_.fPositionX))) {
                                JApplet.method24((class39_sub5_sub4_sub4_sub1_14_.definition), positionX, positionY, Entity.anIntArray1734[i_13_]);
                            }
                        }
                        for (int i_15_ = 0; TraversalMap.anInt515 > i_15_;
                                i_15_++) {
                            Player player = (Class14.players[Class1.anIntArray40[i_15_]]);
                            if (player != null
                                    && (player.fPositionY
                                    == npc.fPositionY)
                                    && (player.fPositionX
                                    == npc.fPositionX)) {
                                ClientScript.method484(positionX, Class1.anIntArray40[i_15_], positionY,
                                        player, (byte) 61);
                            }
                        }
                    }
                    JApplet.method24((npc.definition), positionX, positionY, id);
                }
                if (type == 0) {
                    Player class39_sub5_sub4_sub4_sub2 = Class14.players[id];
                    if ((class39_sub5_sub4_sub4_sub2.fPositionY & 0x7f) == 64
                            && ((class39_sub5_sub4_sub4_sub2.fPositionX & 0x7f)
                            == 64)) {
                        for (int i_16_ = 0; i_16_ < ArchiveWorker.anInt1210;
                                i_16_++) {
                            Npc class39_sub5_sub4_sub4_sub1 = (GroundItem.npcs[Entity.anIntArray1734[i_16_]]);
                            if (class39_sub5_sub4_sub4_sub1 != null
                                    && (class39_sub5_sub4_sub4_sub1.definition.anInt1870) == 1
                                    && (class39_sub5_sub4_sub4_sub1.fPositionY
                                    == class39_sub5_sub4_sub4_sub2.fPositionY)
                                    && (class39_sub5_sub4_sub4_sub1.fPositionX
                                    == class39_sub5_sub4_sub4_sub2.fPositionX)) {
                                JApplet.method24((class39_sub5_sub4_sub4_sub1.definition), positionX, positionY, Entity.anIntArray1734[i_16_]);
                            }
                        }
                        for (int i_17_ = 0; TraversalMap.anInt515 > i_17_;
                                i_17_++) {
                            Player class39_sub5_sub4_sub4_sub2_18_ = (Class14.players[Class1.anIntArray40[i_17_]]);
                            if (class39_sub5_sub4_sub4_sub2_18_ != null
                                    && (class39_sub5_sub4_sub4_sub2_18_
                                    != class39_sub5_sub4_sub4_sub2)
                                    && (class39_sub5_sub4_sub4_sub2_18_.fPositionY
                                    == class39_sub5_sub4_sub4_sub2.fPositionY)
                                    && (class39_sub5_sub4_sub4_sub2_18_.fPositionX
                                    == class39_sub5_sub4_sub4_sub2.fPositionX)) {
                                ClientScript.method484(positionX, Class1.anIntArray40[i_17_], positionY,
                                        class39_sub5_sub4_sub4_sub2_18_,
                                        (byte) 12);
                            }
                        }
                    }
                    ClientScript.method484(positionX, id, positionY,
                            class39_sub5_sub4_sub4_sub2,
                            (byte) -121);
                }
                if (type == 3) {
                    Deque deque = (Class20.groundItems[NameTable.height][positionX][positionY]);
                    if (deque != null) {
                        for (GroundItem groundItem = ((GroundItem) deque.getLast());
                                groundItem != null;
                                groundItem = ((GroundItem) deque.getPrev())) {
                            ItemDefinition definition = Class26.getItemDefinition((groundItem.itemId));
                            if (Class13.anInt208 != 1) {
                                if (ISAAC.aBoolean1100) {
                                    if ((Class41.anInt776 & 0x1) == 1) {
                                        JString.queueAction(27, groundItem.itemId,positionX, positionY, TextConstants.aClass3_1273,
                                                (Class39_Sub5_Sub11.join((new JString[]{Class14.aClass3_216,
                                                    HashTable.aClass3_375,
                                                    (definition.name)}))));
                                    }
                                } else {
                                    JString[] class3s = definition.groundOptions;
                                    if (PlayerApperance.displayOptionIds) {
                                        class3s = BufferedFile.method225(class3s);
                                    }
                                    for (int i_19_ = 4; i_19_ >= 0; i_19_--) {
                                        if (class3s == null
                                                || class3s[i_19_] == null) {
                                            if (i_19_ == 2) {
                                                JString.queueAction(34, (groundItem.itemId),positionX,
                                                        positionY, (Projectile.aClass3_2190),
                                                        (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                            (definition.name)}))));
                                            }
                                        } else {
                                            int i_20_ = 0;
                                            if (i_19_ == 0) {
                                                i_20_ = 40;
                                            }
                                            if (i_19_ == 1) {
                                                i_20_ = 38;
                                            }
                                            if (i_19_ == 2) {
                                                i_20_ = 34;
                                            }
                                            if (i_19_ == 3) {
                                                i_20_ = 11;
                                            }
                                            if (i_19_ == 4) {
                                                i_20_ = 3;
                                            }
                                            JString.queueAction(i_20_, (groundItem.itemId), positionX, positionY, class3s[i_19_],
                                                    (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                        (definition.name)}))));
                                        }
                                    }
                                    JString.queueAction(1003, groundItem.itemId,positionX,
                                            positionY, JRuntimeException.examineJstr,
                                            (Class39_Sub5_Sub11.join((new JString[]{FrameBuffer.lrePrefixJstr,
                                                (definition.name)}))));
                                }
                            } else {
                                JString.queueAction(4, groundItem.itemId,positionX,
                                        positionY, Mob.useJstr,
                                        (Class39_Sub5_Sub11.join((new JString[]{Class39_Sub10.useWithItemJstr,
                                            HashTable.aClass3_375,
                                            definition.name}))));
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        aClass3_1503 = aClass3_1506;
        aClass3_1507 = JString.create("Name eingeben:");
        aClass42_1502 = new JMouseListener();
        aClass3_1508 = JString.create("Drop");
        dropJstr = aClass3_1508;
    }
}
