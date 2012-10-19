package unpackaged;

import com.jagex.utils.ItemContainer;
import com.jagex.config.Model;
import com.jagex.utils.JRuntimeException;
import com.jagex.world.Barrier;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.JCanvas;
import com.jagex.utils.NameTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;

/* Class12 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class12 {

    public static JString aClass3_191 = JString.create(")2");
    public static JString aClass3_192;
    public static JString aClass3_193;
    public static int anInt194 = -1;
    public static JString aClass3_195;
    public static int[] actionVars1;

    public static void parseStillEntityFrame() {
        if (Class4.frameId == 79) {
            int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int x = Node.mSectorX + (locationHash >> 4 & 0x7);
            int y = (locationHash & 0x7) + ISAAC.mSectorY;
            int itemId = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int oldAmount = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int newAmount = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            if (x >= 0 && y >= 0 && x < 104 && y < 104) {
                Deque class49 = (Class20.groundItems[NameTable.height][x][y]);
                if (class49 != null) {
                    for (GroundItem groundItem = ((GroundItem) class49.getFirst());
                            groundItem != null;
                            groundItem = ((GroundItem) class49.getNext())) {
                        if ((itemId & 0x7fff) == groundItem.itemId
                                && oldAmount == groundItem.itemAmount) {
                            groundItem.itemAmount = newAmount;
                            break;
                        }
                    }
                    Class65.updateGroundItems(x, y);
                }
            }
        } else if (Class4.frameId == 94) {
            int ignoreId = Class39_Sub5_Sub11.incomingBuffer.getUword128();
            int itemAmount = Class39_Sub5_Sub11.incomingBuffer.getUword128();
            int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            int posX = Node.mSectorX + ((locationHash & 0x7a) >> 4);
            int posY = (locationHash & 0x7) + ISAAC.mSectorY;
            int itemId = Class39_Sub5_Sub11.incomingBuffer.getUword128();
            if (posX >= 0 && posY >= 0 && posX < 104 && posY < 104
                    && ItemContainer.localId != ignoreId) {
                GroundItem groundItem = new GroundItem();
                groundItem.itemAmount = itemAmount;
                groundItem.itemId = itemId;
                if ((Class20.groundItems[NameTable.height][posX][posY])
                        == null) {
                    Class20.groundItems[NameTable.height][posX][posY] = new Deque();
                }
                Class20.groundItems[NameTable.height][posX][posY].offerLast(groundItem);
                Class65.updateGroundItems(posX, posY);
            }
        } else if (Class4.frameId == 84) {
            int itemId = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int posY = (locationHash & 0x7) + ISAAC.mSectorY;
            int posX = Node.mSectorX + ((locationHash & 0x7a) >> 4);
            if (posX >= 0 && posY >= 0 && posX < 104 && posY < 104) {
                Deque class49 = (Class20.groundItems[NameTable.height][posX][posY]);
                if (class49 != null) {
                    for (GroundItem groundItem = ((GroundItem) class49.getFirst());
                            groundItem != null;
                            groundItem = ((GroundItem) class49.getNext())) {
                        if (groundItem.itemId
                                == (itemId & 0x7fff)) {
                            groundItem.unlinkDeque();
                            break;
                        }
                    }
                    if (class49.getFirst() == null) {
                        Class20.groundItems[NameTable.height][posX][posY] = null;
                    }
                    Class65.updateGroundItems(posX, posY);
                }
            }
        } else if (Class4.frameId == 69) {
            int infoHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int typeId = infoHash >> 2;
            int rotation = infoHash & 0x3;
            int type = Class33.anIntArray598[typeId];
            int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
            int posX = (locationHash >> 4 & 0x7) + Node.mSectorX;
            int posY = ISAAC.mSectorY + (locationHash & 0x7);
            if (posX >= 0 && posY >= 0 && posX < 104 && posY < 104) {
                NpcDefinition.spawnStillObject(0, posY, -1, NameTable.height, rotation, typeId, type,
                        -1, posX);
            }
        } else if (Class4.frameId == 101) {
            int i_23_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int i_24_ = (i_23_ & 0x7) + ISAAC.mSectorY;
            int i_25_ = Node.mSectorX + ((i_23_ & 0x7c) >> 4);
            int i_26_ = i_25_ + Class39_Sub5_Sub11.incomingBuffer.getInt8();
            int i_27_ = i_24_ + Class39_Sub5_Sub11.incomingBuffer.getInt8();
            int i_28_ = Class39_Sub5_Sub11.incomingBuffer.getInt16();
            int i_29_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int i_30_ = (Class39_Sub5_Sub11.incomingBuffer.getUint8()
                    * 4);
            int i_31_ = (Class39_Sub5_Sub11.incomingBuffer.getUint8()
                    * 4);
            int i_32_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int i_33_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int i_34_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int i_35_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            if (i_25_ >= 0 && i_24_ >= 0 && i_25_ < 104 && i_24_ < 104
                    && i_26_ >= 0 && i_27_ >= 0 && i_26_ < 104 && i_27_ < 104
                    && i_29_ != 65535) {
                i_27_ = i_27_ * 128 + 64;
                i_25_ = i_25_ * 128 + 64;
                i_24_ = i_24_ * 128 + 64;
                i_26_ = i_26_ * 128 + 64;
                Projectile projectile = (new Projectile(i_29_, NameTable.height, i_25_, i_24_,
                        -i_30_ + Class14.method212(i_25_, i_24_,
                        NameTable.height),
                        i_32_ + Class2.logicCycle, Class2.logicCycle + i_33_, i_34_,
                        i_35_, i_28_, i_31_));
                projectile.method497(-i_31_ + Class14.method212(i_26_, i_27_, NameTable.height), 63, i_27_, i_32_ + Class2.logicCycle, i_26_);
                Class23.projectiles.offerLast(projectile);
            }
        } else if (Class4.frameId == 207) {
            int i_36_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
            int itemId = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int i_38_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int x = ((i_38_ & 0x7a) >> 4) + Node.mSectorX;
            int y = ISAAC.mSectorY + (i_38_ & 0x7);
            if (x >= 0 && y >= 0 && x < 104 && y < 104) {
                GroundItem groundItem = new GroundItem();
                groundItem.itemId = itemId;
                groundItem.itemAmount = i_36_;
                if ((Class20.groundItems[NameTable.height][x][y])
                        == null) {
                    Class20.groundItems[NameTable.height][x][y] = new Deque();
                }
                Class20.groundItems[NameTable.height][x][y].offerLast(groundItem);
                Class65.updateGroundItems(x, y);
            }
        } else {
            if (Class4.frameId == 170) {
                int animationId = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                int infoHash = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                int typeId = infoHash >> 2;
                int rotation = infoHash & 0x3;
                int type = Class33.anIntArray598[typeId];
                int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                int posX = ((locationHash & 0x7e) >> 4) + Node.mSectorX;
                int posY = (locationHash & 0x7) + ISAAC.mSectorY;
                if (posX >= 0 && posY >= 0 && posX < 103 && posY < 103) {
                    int i_49_ = (Class67.heightMap[NameTable.height][posX][posY]);
                    int i_50_ = (Class67.heightMap[NameTable.height][posX + 1][posY]);
                    int i_51_ = (Class67.heightMap[NameTable.height][posX + 1][posY + 1]);
                    int i_52_ = (Class67.heightMap[NameTable.height][posX][posY + 1]);
                    if (type == 0) {
                        Wall class36 = Class44.world.method356(NameTable.height,
                                posX, posY);
                        if (class36 != null) {
                            int i_53_ = class36.anInt637 >> 14 & 0x7fff;
                            if (typeId == 2) {
                                class36.aClass39_Sub5_Sub4_646 = (new Class39_Sub5_Sub4_Sub2(i_53_, 2, 4 + rotation, i_49_, i_50_,
                                        i_51_, i_52_, animationId, false,
                                        class36.aClass39_Sub5_Sub4_646));
                                class36.aClass39_Sub5_Sub4_641 = (new Class39_Sub5_Sub4_Sub2(i_53_, 2, rotation + 1 & 0x3, i_49_,
                                        i_50_, i_51_, i_52_, animationId, false,
                                        class36.aClass39_Sub5_Sub4_641));
                            } else {
                                class36.aClass39_Sub5_Sub4_646 = (new Class39_Sub5_Sub4_Sub2(i_53_, typeId, rotation, i_49_, i_50_,
                                        i_51_, i_52_, animationId, false,
                                        class36.aClass39_Sub5_Sub4_646));
                            }
                        }
                    }
                    if (type == 1) {
                        Class44 class44 = Class44.world.method358(NameTable.height,
                                posX, posY);
                        if (class44 != null) {
                            class44.aClass39_Sub5_Sub4_846 = (new Class39_Sub5_Sub4_Sub2(class44.anInt842 >> 14 & 0x7fff, 4, 0,
                                    i_49_, i_50_, i_51_, i_52_, animationId, false,
                                    class44.aClass39_Sub5_Sub4_846));
                        }
                    }
                    if (type == 2) {
                        if (typeId == 11) {
                            typeId = 10;
                        }
                        Barrier class10 = Class44.world.method374(NameTable.height,
                                posX, posY);
                        if (class10 != null) {
                            class10.aClass39_Sub5_Sub4_154 = (new Class39_Sub5_Sub4_Sub2(class10.anInt157 >> 14 & 0x7fff, typeId,
                                    rotation, i_49_, i_50_, i_51_, i_52_, animationId,
                                    false, class10.aClass39_Sub5_Sub4_154));
                        }
                    }
                    if (type == 3) {
                        Class50 class50 = Class44.world.method400(NameTable.height,
                                posX, posY);
                        if (class50 != null) {
                            class50.aClass39_Sub5_Sub4_933 = (new Class39_Sub5_Sub4_Sub2(class50.anInt935 >> 14 & 0x7fff, 22, rotation,
                                    i_49_, i_50_, i_51_, i_52_, animationId, false,
                                    class50.aClass39_Sub5_Sub4_933));
                        }
                    }
                }
            } else if (Class4.frameId == 122) {
                int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                int posY = ISAAC.mSectorY + (locationHash & 0x7);
                int posX = ((locationHash & 0x78) >> 4) + Node.mSectorX;
                int i_57_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
                int infoHash = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
                int rotation = infoHash & 0x3;
                int typeId = infoHash >> 2;
                int type = Class33.anIntArray598[typeId];
                if (posX >= 0 && posY >= 0 && posX < 104 && posY < 104) {
                    NpcDefinition.spawnStillObject(0, posY, -1,
                            NameTable.height,
                            rotation, typeId, type, i_57_,
                            posX);
                }
            } else if (Class4.frameId == 115) {
                int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
                int posX = Node.mSectorX + (locationHash >> 4 & 0x7);
                int posY = (locationHash & 0x7) + ISAAC.mSectorY;
                int graphicId = Class39_Sub5_Sub11.incomingBuffer.getUint16();
                int heightOffset = Class39_Sub5_Sub11.incomingBuffer.getUint8();
                int delay = Class39_Sub5_Sub11.incomingBuffer.getUint16();
                if (posX >= 0 && posY >= 0 && posX < 104 && posY < 104) {
                    posY = posY * 128 + 64;
                    posX = posX * 128 + 64;
                    StillGraphic stillGraphic = (new StillGraphic(graphicId, NameTable.height, posX, posY,
                            Class14.method212(posX, posY, NameTable.height) - heightOffset,
                            delay, Class2.logicCycle));
                    JRuntimeException.stillGraphics.offerLast(stillGraphic);
                }
            } else {
                if (Class4.frameId == 129) {
                    int i_68_ = Class39_Sub5_Sub11.incomingBuffer.getByteA();
                    int i_69_ = Class39_Sub5_Sub11.incomingBuffer.getByteB();
                    int i_70_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                    int i_71_ = Class39_Sub5_Sub11.incomingBuffer.getByteB();
                    int i_72_ = Class39_Sub5_Sub11.incomingBuffer.getByte128();
                    int i_73_ = Class39_Sub5_Sub11.incomingBuffer.getUword128();
                    int i_74_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
                    int i_75_ = i_74_ >> 2;
                    int type = Class33.anIntArray598[i_75_];
                    int i_77_ = i_74_ & 0x3;
                    int i_78_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
                    int posX = Node.mSectorX + ((i_78_ & 0x77) >> 4);
                    int posY = (i_78_ & 0x7) + ISAAC.mSectorY;
                    int i_81_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
                    int playerId = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
                    Player player;
                    if (playerId == ItemContainer.localId) {
                        player = Cache.localPlayer;
                    } else {
                        player = (Class14.players[playerId]);
                    }
                    if (player != null) {
                        ObjectDefinition objectDefinition = JCanvas.getObjectDefinition(i_70_);
                        int height0 = (Class67.heightMap[NameTable.height][posX][posY + 1]);
                        int height1 = (Class67.heightMap[NameTable.height][posX][posY]);
                        int height2 = (Class67.heightMap[NameTable.height][posX + 1][posY]);
                        int height3 = (Class67.heightMap[NameTable.height][posX + 1][posY + 1]);
                        Model class39_sub5_sub4_sub6 = objectDefinition.method742(66, i_75_, height1,
                                i_77_, height0, height3,
                                height2);
                        if (class39_sub5_sub4_sub6 != null) {
                            NpcDefinition.spawnStillObject(i_73_ + 1, posY,
                                    i_81_ + 1,
                                    NameTable.height, 0, 0,
                                    type, -1, posX);
                            if (i_71_ > i_69_) {
                                int i_87_ = i_71_;
                                i_71_ = i_69_;
                                i_69_ = i_87_;
                            }
                            player.anInt2512 = Class2.logicCycle + i_73_;
                            player.aClass39_Sub5_Sub4_Sub6_2520 = class39_sub5_sub4_sub6;
                            if (i_68_ < i_72_) {
                                int i_88_ = i_72_;
                                i_72_ = i_68_;
                                i_68_ = i_88_;
                            }
                            player.anInt2523 = Class2.logicCycle + i_81_;
                            int i_89_ = objectDefinition.anInt1925;
                            int i_90_ = objectDefinition.anInt1948;
                            if (i_77_ == 1 || i_77_ == 3) {
                                i_90_ = objectDefinition.anInt1925;
                                i_89_ = objectDefinition.anInt1948;
                            }
                            player.anInt2514 = posX * 128 + i_89_ * 64;
                            player.anInt2518 = posY * 128 + i_90_ * 64;
                            player.anInt2519 = (Class14.method212(player.anInt2514, player.anInt2518, NameTable.height));
                            player.anInt2513 = posX + i_69_;
                            player.anInt2510 = i_72_ + posY;
                            player.anInt2511 = i_71_ + posX;
                            player.anInt2522 = posY + i_68_;
                        }
                    }
                }
                if (Class4.frameId == 109) {
                    int locationHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
                    int posX = ((locationHash & 0x75) >> 4) + Node.mSectorX;
                    int posY = ISAAC.mSectorY + (locationHash & 0x7);
                    int effectId = Class39_Sub5_Sub11.incomingBuffer.getUint16();
                    int infoHash = Class39_Sub5_Sub11.incomingBuffer.getUint8();
                    int distance = (infoHash & 0xf0) >> 4;
                    int delay = Class39_Sub5_Sub11.incomingBuffer.getUint8();
                    int loops = infoHash & 0x7;
                    if (posX >= 0 && posY >= 0 && posX < 104
                            && posY < 104) {
                        int len = distance + 1;
                        if ((Cache.localPlayer.queueX[0]) >= posX - len
                                && (posX + len
                                >= (Cache.localPlayer.queueX[0]))
                                && (Cache.localPlayer.queueY[0]) >= posY - len
                                && (posY + len
                                >= (Cache.localPlayer.queueY[0]))
                                && AbstractFileLoader.ambientEffectVolume != 0 && loops > 0
                                && Projectile.queuedEffectOffset < 50) {
                            ArchiveWorker.queuedEffectIds[(Projectile.queuedEffectOffset)] = effectId;
                            FileLoader.queuedEffectLoops[(Projectile.queuedEffectOffset)] = loops;
                            Class39_Sub5_Sub9.queuedEffectDelays[Projectile.queuedEffectOffset] = delay;
                            Class15.queuedEffects[(Projectile.queuedEffectOffset)] = null;
                            FrameBuffer.queuedEffectVolumes[Projectile.queuedEffectOffset] = distance + (posY << 8) + (posX << 16);
                            Projectile.queuedEffectOffset++;
                        }
                    }
                }
            }
        }
    }

    public static void method186(int i) {
        aClass3_195 = null;
        aClass3_192 = null;
        aClass3_193 = null;
        aClass3_191 = null;
        actionVars1 = null;
    }

    static {
        aClass3_193 = JString.create("Der Server wird gerade aktualisiert)3");
        aClass3_192 = JString.create(" )2> ");
        aClass3_195 = JString.create("Abbrechen");
        actionVars1 = new int[500];
    }
}
