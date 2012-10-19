package com.jagex;

/* client - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.awt.JApplet;
import com.jagex.io.CacheIO;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Decompressor;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.BitmapFont;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
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
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import com.jagex.audio.Filter;
import com.jagex.audio.Instrument;
import java.net.InetAddress;
import java.net.Socket;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.awt.JCanvas;
import unpackaged.Class1;
import com.jagex.world.Barrier;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class13_Sub1;
import unpackaged.Class13_Sub1_Sub1;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class17;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import com.jagex.world.World;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import com.jagex.graphics.TriangleRasterizer;
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
import com.jagex.utils.ClassCheckRequest;
import com.jagex.config.Texture;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Timer;
import com.jagex.utils.MsTimer;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class5;
import unpackaged.Class50;
import unpackaged.Class51;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import com.jagex.audio.AudioHandler;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.audio.MidiHandler;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import com.jagex.script.ClientScript;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.config.ItemDefinition;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.awt.listeners.MouseListenerImpl;
import com.jagex.config.Model;
import com.jagex.config.NpcDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.od.OndemandRequest;
import com.jagex.utils.JRuntimeException;
import com.jagex.script.ScriptState;
import com.jagex.sign.Signlink;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.Widget;
import com.jagex.od.OndemandHandler;
import com.jagex.sign.Resource;
import com.jagex.utils.LanguageUtils;
import java.io.IOException;

public class Client extends JApplet {

    public static long aLong1263;
    public static AbstractImage aClass57_1267;
    public static int[] messageTypes;
    public static int anInt1269;
    public static int anInt1274 = 0;
    public static int[] incomingSizes;
    public static int[] anIntArray1276;
    public static long encodedUsername;
    public static int anInt1280;
    public static int state;
    public static int loginStage = 0;
    public static FrameBuffer loginBuffer;
    public static Resource gameSocket;
    public static int[] stateValues;

    public static void method34(int i) {
        TextConstants.loadingConfig = null;
        TextConstants.aClass3_1279 = null;
        if (i == 111) {
            TextConstants.aClass3_1264 = null;
            TextConstants.aClass3_1277 = null;
            TextConstants.noReplyLoginserver = null;
            TextConstants.level = null;
            TextConstants.aClass3_1270 = null;
            anIntArray1276 = null;
            messageTypes = null;
            TextConstants.aClass3_1273 = null;
            aClass57_1267 = null;
            TextConstants.loadedGamescreen = null;
            incomingSizes = null;
        }
    }

    public static void setState(int i) {
        if (i != state) {
            if (state == 0) {
                Class62_Sub2.method1080((byte) -76);
            }
            if (i == 20 || i == 40) {
                loginStage = 0;
                Class15.anInt280 = 0;
                ArchiveRequest.loginAttempts = 0;
            }
            if (i != 20 && i != 40 && ObjectDefinition.aClass16_1935 != null) {
                ObjectDefinition.aClass16_1935.hault();
                ObjectDefinition.aClass16_1935 = null;
            }
            if (state == 25 || state == 40) {
                ClientScript.method481(-6414);
                DrawingArea.reset();
            }
            if (state == 25) {
                Class66.anInt1157 = 1;
                VarbitDefinition.anInt1798 = 0;
                JRuntimeException.anInt1222 = 0;
                Class39_Sub5_Sub11.anInt1843 = 1;
                Class1.anInt33 = 0;
            }
            if (i == 0 || i == 35) {
                ItemDefinition.method470();
                TraversalMap.method298((byte) 82);
                if (Class34.aClass57_610 == null) {
                    Class34.aClass57_610 = Queue.method994(Class41.canvas, 765, 503, (byte) -106);
                }
            }
            if (i == 5 || i == 10 || i == 20) {
                Class34.aClass57_610 = null;
                ItemDefinition.method470();
                Entity.method490(Class41.canvas, TraversalMap.fileLoader8, 17056, Class66.fileLoader10);
            }
            if (i == 25 || i == 30 || i == 40) {
                Class34.aClass57_610 = null;
                TraversalMap.method298((byte) 82);
                GouraudVertex.method952(Class41.canvas, TraversalMap.fileLoader8);
            }
            ClientScript.aBoolean1690 = true;
            state = i;
        }
    }

    public static void handleLogin() {
        try {
            if (loginStage == 0) {
                if (Class37.gameSocket != null) {
                    Class37.gameSocket.hault();
                    Class37.gameSocket = null;
                }
                loginStage = 1;
                gameSocket = null;
                Widget.aBoolean2116 = false;
                Class15.anInt280 = 0;
            }
            if (loginStage == 1) {
                if (gameSocket == null) {
                    gameSocket = Class39_Sub5_Sub9.fileSignlink.requestSocket(HashTable.anInt363);
                }
                if (gameSocket.returnCode == 2) {
                    throw new IOException();
                }
                if (gameSocket.returnCode == 1) {
                    Class37.gameSocket = new JSocket((Socket) (gameSocket.returnObject), Class39_Sub5_Sub9.fileSignlink);
                    loginStage = 2;
                    gameSocket = null;
                }
            }
            if (loginStage == 2) {
                long l = encodedUsername = Class39_Sub5_Sub14.username.encodeBase37();
                FrameBuffer.outgoingBuffer.offset = 0;
                FrameBuffer.outgoingBuffer.putByte(14);
                int i_48_ = (int) (l >> 16 & 31L);
                FrameBuffer.outgoingBuffer.putByte(i_48_);
                Class37.gameSocket.write(FrameBuffer.outgoingBuffer.payload, 0, 2);
                Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                loginStage = 3;
            }
            if (loginStage == 3) {
                int response = Class37.gameSocket.read();
                if (response != 0) {
                    Barrier.handleLoginError(response, 24);
                    return;
                }
                loginStage = 4;
                Class39_Sub5_Sub11.incomingBuffer.offset = 0;
            }
            if (loginStage == 4) {
                if (Class39_Sub5_Sub11.incomingBuffer.offset < 8) {
                    int i_50_ = Class37.gameSocket.available();
                    if ((-Class39_Sub5_Sub11.incomingBuffer.offset + 8) < i_50_) {
                        i_50_ = 8 - (Class39_Sub5_Sub11.incomingBuffer.offset);
                    }
                    if (i_50_ > 0) {
                        Class37.gameSocket.read(Class39_Sub5_Sub11.incomingBuffer.payload, Class39_Sub5_Sub11.incomingBuffer.offset, i_50_);
                        Class39_Sub5_Sub11.incomingBuffer.offset += i_50_;
                    }
                }
                if (Class39_Sub5_Sub11.incomingBuffer.offset == 8) {
                    Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                    KeyListenerImpl.isaacSeed = Class39_Sub5_Sub11.incomingBuffer.getQword();
                    loginStage = 5;
                }
            }
            if (loginStage == 5) {
                FrameBuffer.outgoingBuffer.offset = 0;
                int[] seeds = new int[4];
                seeds[0] = (int) (Math.random() * 9.9999999E7);
                seeds[1] = (int) (Math.random() * 9.9999999E7);
                seeds[3] = (int) KeyListenerImpl.isaacSeed;
                seeds[2] = (int) (KeyListenerImpl.isaacSeed >> 32);
                FrameBuffer.outgoingBuffer.putByte(10);
                FrameBuffer.outgoingBuffer.putDword(seeds[0]);
                FrameBuffer.outgoingBuffer.putDword(seeds[1]);
                FrameBuffer.outgoingBuffer.putDword(seeds[2]);
                FrameBuffer.outgoingBuffer.putDword(seeds[3]);
                FrameBuffer.outgoingBuffer.putDword(Class39_Sub5_Sub9.fileSignlink.clientUid);
                FrameBuffer.outgoingBuffer.putQword(Class39_Sub5_Sub14.username.encodeBase37());
                FrameBuffer.outgoingBuffer.putJstr(Class39_Sub5_Sub14.password);
                FrameBuffer.outgoingBuffer.applyRsa(Class2.aBigInteger47, JSocket.aBigInteger292, -17694);
                loginBuffer.offset = 0;
                if (state == 40) {
                    loginBuffer.putByte(18);
                } else {
                    loginBuffer.putByte(16);
                }
                loginBuffer.putByte(FrameBuffer.outgoingBuffer.offset + 61);
                loginBuffer.putDword(443);
                loginBuffer.putByte(!PlayerApperance.isLowMemory ? 0 : 1);
                loginBuffer.putDword(Buffer.fileLoader0.localChecksum);
                loginBuffer.putDword(Class15.fileLoader1.localChecksum);
                loginBuffer.putDword(Class67.fileLoader2.localChecksum);
                loginBuffer.putDword(Node.fileLoader3.localChecksum);
                loginBuffer.putDword(Node.fileLoader4.localChecksum);
                loginBuffer.putDword(JSocket.fileLoader5.localChecksum);
                loginBuffer.putDword(Projectile.fileLoader6.localChecksum);
                loginBuffer.putDword(PlayerApperance.fileLoader7.localChecksum);
                loginBuffer.putDword(TraversalMap.fileLoader8.localChecksum);
                loginBuffer.putDword(Widget.fileLoader9.localChecksum);
                loginBuffer.putDword(Class66.fileLoader10.localChecksum);
                loginBuffer.putDword(Wall.fileLoader11.localChecksum);
                loginBuffer.putDword(Class33.fileLoader12.localChecksum);
                loginBuffer.putDword(TextureLoaderImpl.fileLoader13.localChecksum);
                loginBuffer.putBytes(FrameBuffer.outgoingBuffer.payload, 0, FrameBuffer.outgoingBuffer.offset);
                Class37.gameSocket.write(loginBuffer.payload, 0, loginBuffer.offset);
                FrameBuffer.outgoingBuffer.initIsaac(seeds);
                for (int i_51_ = 0; i_51_ < 4; i_51_++) {
                    seeds[i_51_] += 50;
                }
                Class39_Sub5_Sub11.incomingBuffer.initIsaac(seeds);
                loginStage = 6;
            }
            if (loginStage == 6 && Class37.gameSocket.available() > 0) {
                int response = Class37.gameSocket.read();
                if (response != 21 || state != 20) {
                    if (response == 2) {
                        loginStage = 9;
                    } else {
                        if (response == 15 && state == 40) {
                            ImageImpl.method1017((byte) 74);
                            return;
                        }
                        if (response == 23 && ArchiveRequest.loginAttempts < 1) {
                            ArchiveRequest.loginAttempts++;
                            loginStage = 0;
                        } else {
                            Barrier.handleLoginError(response, 24);
                            return;
                        }
                    }
                } else {
                    loginStage = 7;
                }
            }
            if (loginStage == 7 && Class37.gameSocket.available() > 0) {
                VarbitDefinition.anInt1790 = Class37.gameSocket.read() * 60 + 180;
                loginStage = 8;
            }
            if (loginStage == 8) {
                Class15.anInt280 = 0;
                Class37.method349(8845, Class53.aClass3_967, Class39_Sub5_Sub11.join(new JString[]{AbstractImage.toJstr((VarbitDefinition.anInt1790) / 60), TraversalMap.aClass3_519}), HashTable.aClass3_374);
                if (--VarbitDefinition.anInt1790 <= 0) {
                    loginStage = 0;
                }
            } else {
                if (loginStage == 9 && Class37.gameSocket.available() >= 8) {
                    CacheIO.rights = Class37.gameSocket.read();
                    Huffman.isFlagged = Class37.gameSocket.read() == 1;
                    ItemContainer.localId = Class37.gameSocket.read();
                    ItemContainer.localId <<= 8;
                    ItemContainer.localId += Class37.gameSocket.read();
                    Class63.isMember = Class37.gameSocket.read();
                    Class37.gameSocket.read(Class39_Sub5_Sub11.incomingBuffer.payload, 0, 1);
                    Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                    Class4.frameId = Class39_Sub5_Sub11.incomingBuffer.getFrame();
                    Class37.gameSocket.read(Class39_Sub5_Sub11.incomingBuffer.payload, 0, 2);
                    Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                    Huffman.frameSize = Class39_Sub5_Sub11.incomingBuffer.getUword();
                    loginStage = 10;
                }
                if (loginStage == 10) {
                    if (Class37.gameSocket.available() >= Huffman.frameSize) {
                        Class39_Sub5_Sub11.incomingBuffer.offset = 0;
                        Class37.gameSocket.read(Class39_Sub5_Sub11.incomingBuffer.payload, 0, Huffman.frameSize);
                        Mob.method511((byte) 95);
                        Class62_Sub2.anInt1597 = -1;
                        Class25.parseMapRebuild(false);
                        Class4.frameId = -1;
                    }
                } else {
                    Class15.anInt280++;
                    if (Class15.anInt280 > 2000) {
                        if (ArchiveRequest.loginAttempts < 1) {
                            loginStage = 0;
                            if (Entity.anInt1732 == HashTable.anInt363) {
                                HashTable.anInt363 = Bzip2Entry.anInt1078;
                            } else {
                                HashTable.anInt363 = Entity.anInt1732;
                            }
                            ArchiveRequest.loginAttempts++;
                        } else {
                            Barrier.handleLoginError(-3, 24);
                        }
                    }
                }
            }
        } catch (IOException ioex) {
            if (ArchiveRequest.loginAttempts < 1) {
                ArchiveRequest.loginAttempts++;
                loginStage = 0;
                if (Entity.anInt1732 == HashTable.anInt363) {
                    HashTable.anInt363 = Bzip2Entry.anInt1078;
                } else {
                    HashTable.anInt363 = Entity.anInt1732;
                }
            } else {
                Barrier.handleLoginError(-2, 24);
            }
        }
    }

    public static void setMapLocation(int mSectorX, int mSectorY, int mPositionX, int mPositionY, int height) {
        if (mSectorX != Class62_Sub2.anInt1597 || mSectorY != Class65.anInt1147 || height != ImageImpl.lastHeight && PlayerApperance.isLowMemory) {
            Class62_Sub2.anInt1597 = mSectorX;
            Class65.anInt1147 = mSectorY;
            ImageImpl.lastHeight = height;
            if (!PlayerApperance.isLowMemory) {
                ImageImpl.lastHeight = 0;
            }
            setState(25);
            Class26.method294(false, NameTable.aClass3_190, null, 118);
            int i_5_ = Class65.anInt1145;
            Class65.anInt1145 = mSectorX * 8 - 48;
            int i_6_ = KeyListenerImpl.anInt618;
            int i_7_ = -i_5_ + Class65.anInt1145;
            i_5_ = Class65.anInt1145;
            KeyListenerImpl.anInt618 = mSectorY * 8 - 48;
            int i_8_ = -i_6_ + KeyListenerImpl.anInt618;
            i_6_ = KeyListenerImpl.anInt618;
            for (int i_9_ = 0; i_9_ < 32768; i_9_++) {
                Npc npc = GroundItem.npcs[i_9_];
                if (npc != null) {
                    for (int i_10_ = 0; i_10_ < 10; i_10_++) {
                        npc.queueX[i_10_] -= i_7_;
                        npc.queueY[i_10_] -= i_8_;
                    }
                    npc.fPositionX -= i_8_ * 128;
                    npc.fPositionY -= i_7_ * 128;
                }
            }
            for (int i_11_ = 0; i_11_ < 2048; i_11_++) {
                Player player = Class14.players[i_11_];
                if (player != null) {
                    for (int i_12_ = 0; i_12_ < 10; i_12_++) {
                        player.queueX[i_12_] -= i_7_;
                        player.queueY[i_12_] -= i_8_;
                    }
                    player.fPositionX -= i_8_ * 128;
                    player.fPositionY -= i_7_ * 128;
                }
            }
            NameTable.height = height;
            int i_13_ = 0;
            int i_14_ = 104;
            int i_15_ = 1;
            Cache.localPlayer.setLocation(mPositionX, mPositionY, false);
            int i_16_ = 0;
            if (i_7_ < 0) {
                i_13_ = 103;
                i_14_ = -1;
                i_15_ = -1;
            }
            int i_17_ = 104;
            int i_18_ = 1;
            if (i_8_ < 0) {
                i_17_ = -1;
                i_18_ = -1;
                i_16_ = 103;
            }
            for (int i_19_ = i_13_; i_19_ != i_14_; i_19_ += i_15_) {
                for (int i_20_ = i_16_; i_17_ != i_20_; i_20_ += i_18_) {
                    int i_21_ = i_7_ + i_19_;
                    int i_22_ = i_20_ + i_8_;
                    for (int i_23_ = 0; i_23_ < 4; i_23_++) {
                        if (i_21_ >= 0 && i_22_ >= 0 && i_21_ < 104 && i_22_ < 104) {
                            Class20.groundItems[i_23_][i_19_][i_20_] = (Class20.groundItems[i_23_][i_21_][i_22_]);
                        } else {
                            Class20.groundItems[i_23_][i_19_][i_20_] = null;
                        }
                    }
                }
            }
            for (StillObject class39_sub11 = (StillObject) Class15.stillObjects.getFirst(); class39_sub11 != null; class39_sub11 = (StillObject) Class15.stillObjects.getNext()) {
                class39_sub11.positionY -= i_8_;
                class39_sub11.positionX -= i_7_;
                if (class39_sub11.positionX < 0 || class39_sub11.positionY < 0 || class39_sub11.positionX >= 104 || class39_sub11.positionY >= 104) {
                    class39_sub11.unlinkDeque();
                }
            }
            Projectile.queuedEffectOffset = 0;
            if (Class30.anInt544 != 0) {
                ArchiveRequest.anInt1407 -= i_8_;
                Class30.anInt544 -= i_7_;
            }
            ArchiveRequest.anInt1411 = -1;
            TraversalMap.isCameraMoving = false;
            JRuntimeException.stillGraphics.removeAll();
            Class23.projectiles.removeAll();
        }
    }

    public static boolean decodeSprite(AbstractFileLoader fileTable, int archiveId, int childId) {
        byte[] is = fileTable.lookupFile(archiveId, childId);
        if (is == null) {
            return false;
        }
        ClassCheckRequest.decodeSprite(is);
        return true;
    }

    public static void setState(int value, int id) {
        VarbitDefinition varbit = Class25.getVarbit(id);
        int i_39_ = varbit.anInt1793;
        int settingId = varbit.stateId;
        int i_41_ = varbit.anInt1794;
        int i_42_ = ClientScript.bitMasks[-i_39_ + i_41_];
        if (value < 0 || value > i_42_) {
            value = 0;
        }
        i_42_ <<= i_39_;
        stateValues[settingId] = Queue.or(Class34.and(i_42_ ^ -1, stateValues[settingId]), Class34.and(i_42_, value << i_39_));
    }

    public void handleDrawCycle(boolean bool) {
        if (ClassCheckRequest.aBoolean1373) {
            VarpDefinition.detachListeners(Class41.canvas);
            Class53.method982(-15828, Class41.canvas);
            if (Class43.aClass34_814 != null) {
                Class43.aClass34_814.method332(99, Class41.canvas);
            }
            this.method28(64);
            Class13.method188((byte) -70, Class41.canvas);
            ClientScript.attachListeners(Class41.canvas);
            if (Class43.aClass34_814 != null) {
                Class43.aClass34_814.method337(Class41.canvas, (byte) 114);
            }
        }
        if (state != 0) {
            if (state != 5) {
                if (state != 10) {
                    if (state != 20) {
                        if (state != 25) {
                            if (state == 30) {
                                Buffer.method823(0);
                            } else if (state != 35) {
                                if (state == 40) {
                                    Class26.method294(false, Queue.aClass3_983, Class63.aClass3_1118, -94);
                                }
                            } else {
                                ArchiveRequest.method858((byte) -127);
                            }
                        } else if (Class1.anInt33 != 1) {
                            if (Class1.anInt33 != 2) {
                                Class26.method294(false, NameTable.aClass3_190, null, -109);
                            } else {
                                if (Class39_Sub5_Sub11.anInt1843 < JRuntimeException.anInt1222) {
                                    Class39_Sub5_Sub11.anInt1843 = JRuntimeException.anInt1222;
                                }
                                int i = (50 + ((-JRuntimeException.anInt1222 + Class39_Sub5_Sub11.anInt1843) * 50 / Class39_Sub5_Sub11.anInt1843));
                                Class26.method294(true, NameTable.aClass3_190, (Class39_Sub5_Sub11.join((new JString[]{(Mob.aClass3_2319), AbstractImage.toJstr(i), Buffer.aClass3_1360}))), 75);
                            }
                        } else {
                            if (Class66.anInt1157 < VarbitDefinition.anInt1798) {
                                Class66.anInt1157 = VarbitDefinition.anInt1798;
                            }
                            int i = ((-VarbitDefinition.anInt1798 + Class66.anInt1157) * 50 / Class66.anInt1157);
                            Class26.method294(true, NameTable.aClass3_190, (Class39_Sub5_Sub11.join((new JString[]{Mob.aClass3_2319, AbstractImage.toJstr(i), Buffer.aClass3_1360}))), -122);
                        }
                    } else {
                        Class39_Sub5_Sub12.method709((Npc.aClass39_Sub5_Sub10_Sub1_2495), -27620, Class32.aClass39_Sub5_Sub10_Sub1_587);
                    }
                } else {
                    Class39_Sub5_Sub12.method709((Npc.aClass39_Sub5_Sub10_Sub1_2495), -27620, Class32.aClass39_Sub5_Sub10_Sub1_587);
                }
            } else {
                Class39_Sub5_Sub12.method709((Npc.aClass39_Sub5_Sub10_Sub1_2495), -27620, Class32.aClass39_Sub5_Sub10_Sub1_587);
            }
        } else {
            Class34.drawLoadingScreen(null, Class39_Sub5_Sub14.loadingMessage, ClassCheckRequest.loadingPercent);
        }
        MsTimer.anInt1547 = 0;
        TextureLoaderImpl.anInt1252 = 0;
        
    }

    public void method31(int i) {
        method34(111);
        JString.method64((byte) 97);
        JApplet.method21((byte) -60);
        Timer.method932(-84);
        AbstractImage.method1008(-90);
        MouseRecorder.method321(3);
        Buffer.method782((byte) -124);
        JSocket.method216(-1);
        FileLoader.method176((byte) 105);
        BufferedFile.method232(-1);
        CacheIO.method129(true);
        Npc.method523(124);
        FrameBuffer.method839(false);
        BitmapFont.method643();
        World.method402();
        TraversalMap.method303(17448960);
        Player.method529(false);
        Deque.method968((byte) 92);
        Widget.method765((byte) -58);
        Class34.method334(i - 502);
        Class43.method904(i ^ ~0x1f7);
        PlayerApperance.method920(0);
        Mob.method507(-29);
        StillObject.method868(28549);
        NpcDefinition.method717((byte) 102);
        HashTable.method243(-126);
        Node.method409(false);
        ISAAC.method1041(false);
        Class14.method213(-31054);
        Cache.method136(92);
        Class39_Sub5_Sub11.method704((byte) -58);
        Model.method550();
        Class53.method983((byte) 112);
        JRuntimeException.method1122((byte) 78);
        Class68.method1114(15);
        Class39_Sub14.method880(i - 498);
        Barrier.method181(i ^ ~0x1af);
        Class26.method289(127);
        Entity.method491(-3157);
        Wall.method348((byte) -45);
        Class44.method915(false);
        Class50.method973(2);
        Class32.method324(239);
        Class17.method223();
        KeyListenerImpl.method344(-13461);
        MouseListenerImpl.method903(-6088);
        Class2.method53(0);
        SubNode.method462(i ^ i);
        AbstractFileLoader.method150(29320);
        ArchiveWorker.method1117(41);
        Class41.method897(106);
        Class13.method192(i ^ ~0x188);
        Class65.method1093(114);
        Class20.method247((byte) 114);
        Class37.method350(103);
        Queue.method995((byte) -52);
        TextConstants.destroy();
        Class66.method1102((byte) 126);
        TriangleRasterizer.method652();
        DrawingArea.destroy();
        NameTable.method183(118);
        Class23.method272(i - 504);
        Class63.method1088(i ^ 0x1f7);
        Class39_Sub5_Sub14.method729(102);
        Class39_Sub5_Sub9.method600(i ^ ~0x6328);
        Class39_Sub5_Sub6.method578(false);
        ObjectDefinition.method738(65535);
        ItemDefinition.method472(-30765);
        Class39_Sub5_Sub12.method711(18051);
        Class39_Sub5_Sub18.method780(true);
        VarbitDefinition.method598((byte) -81);
        VarpDefinition.method749(0);
        TextureLoaderImpl.method998((byte) 126);
        Texture.method856();
        Huffman.method890(true);
        Class30.method316(0);
        Class47.method945(false);
        Class33.method329(28375);
        ItemContainer.method874((byte) -79);
        Class39_Sub10.method865(false);
        ClientScript.method482(24311);
        Class15.method215((byte) 117);
        Instrument.method1028();
        GouraudVertex.method950((byte) -121);
        Projectile.method493(-30);
        StillGraphic.method531((byte) 121);
        Class12.method186(83);
        ScriptState.method280(false);
        GroundItem.method501((byte) -6);
        Class39_Sub5_Sub4_Sub2.method499(68);
        Class39_Sub4.method458(-95);
        Class4.method100((byte) 121);
        JCanvas.method42(296);
        MsTimer.method943(false);
        ImageImpl.method1020(true);
        Class67.method1108((byte) -127);
        Filter.method1024();
        Class25.method286(i ^ ~0x1fbf);
        Class51.method977();
        Class39_Sub12.method871(15003);
        Bzip2Decompressor.method266();
        Bzip2Entry.method1031(83);
        ArchiveRequest.method859(false);
        AudioHandler.method1058(-43);
        Class39_Sub5_Sub7.method587(-57);
        Class13_Sub1.method198();
        Class13_Sub1_Sub1.method205();
        Class1.method47(29053);
        ClassCheckRequest.method847((byte) -87);
        Class39_Sub5_Sub5.method571(1000);
        AbstractMidiHandler.method1067(-109);
        Class5.method112();
        Class62_Sub2.method1073(i ^ ~0x493691e0);
    }

    public void method22(int i) {
        if (Cache.mouseRecorder != null) {
            Cache.mouseRecorder.aBoolean554 = false;
        }
        Cache.mouseRecorder = null;
        if (Class37.gameSocket != null) {
            Class37.gameSocket.hault();
            Class37.gameSocket = null;
        }
        Class4.method101((byte) -88);
        Huffman.method888(i - 1886);
        Class43.aClass34_814 = null;
        Class41.method896(-119);
        Class41.method898(0);
        Npc.method525((byte) -127);
        Mob.method517((byte) -125);
        do {
            try {
                if (Class43.mainFile != null) {
                    Class43.mainFile.destroy();
                }
                if (Npc.indexFiles != null) {
                    for (int i_3_ = 0; (Npc.indexFiles.length > i_3_); i_3_++) {
                        if (Npc.indexFiles[i_3_] != null) {
                            Npc.indexFiles[i_3_].destroy();
                        }
                    }
                }
                if (Class25.tableFile == null) {
                    break;
                }
                Class25.tableFile.destroy();
            } catch (java.io.IOException ioexception) {
                break;
            }
            break;
        } while (false);
    }

    public void init() {
        if (this.isHostValid()) {
            BufferedFile.worldId = Integer.parseInt(this.getParameter("worldid"));
            AbstractFileLoader.modeWhat = Integer.parseInt(this.getParameter("modewhat"));
            Class39_Sub5_Sub6.modeWhere = Integer.parseInt(this.getParameter("modewhere"));
            String string = this.getParameter("lowmem");
            if (string == null || !string.equals("1")) {
                Deque.setHighMemory(1);
            } else {
                Npc.setLowMemory((byte) -125);
            }
            String membersStr = this.getParameter("members");
            if (membersStr == null || !membersStr.equals("1")) {
                HashTable.members = false;
            } else {
                HashTable.members = true;
            }
            String langStr = this.getParameter("lang");
            if (langStr != null && langStr.equals("1")) {
                LanguageUtils.setMessagesToGerman();
                HashTable.languageId = 1;
            }
            this.initialize(48, 503, AbstractFileLoader.modeWhat + 32, 443, 765);
        }
    }

    public void handleLogic(byte i) {
        Class2.logicCycle++;
        updateOndemand();
        StillGraphic.validateArchives();
        Class41.method895((byte) -93);
        Class39_Sub5_Sub5.method573(6);
        VarbitDefinition.method595(3116);
        Class39_Sub5_Sub18.getMousePosition();
        if (Class43.aClass34_814 != null) {
            int i_7_ = Class43.aClass34_814.method338(i + 107);
            AudioHandler.anInt1107 = i_7_;
            TextureLoaderImpl.anInt1252 += i_7_;
        }
        if (state != 0) {
            if (state != 5) {
                if (state != 10) {
                    if (state == 20) {
                        AbstractFileLoader.method156((byte) 125);
                        handleLogin();
                    } else if (state == 25) {
                        Class62_Sub2.rebuildMap();
                    }
                } else {
                    AbstractFileLoader.method156((byte) 121);
                }
            } else {
                Class39_Sub12.method870();
                ScriptState.method275(-33);
            }
        } else {
            Class39_Sub12.method870();
            ScriptState.method275(-33);
        }
        if (state == 30) {
            Class34.method336();
        } else if (state == 35) {
            Class34.method336();
        } else if (state == 40) {
            handleLogin();
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 6) {
                JString.printArgsUsage();
            }
            BufferedFile.worldId = Integer.parseInt(args[0]);
            if (args[1].equals("live")) {
                Class39_Sub5_Sub6.modeWhere = 0;
            } else if (!args[1].equals("office")) {
                if (args[1].equals("local")) {
                    Class39_Sub5_Sub6.modeWhere = 2;
                } else {
                    JString.printArgsUsage();
                }
            } else {
                Class39_Sub5_Sub6.modeWhere = 1;
            }
            if (args[2].equals("live")) {
                AbstractFileLoader.modeWhat = 0;
            } else if (args[2].equals("rc")) {
                AbstractFileLoader.modeWhat = 1;
            } else if (!args[2].equals("wip")) {
                JString.printArgsUsage();
            } else {
                AbstractFileLoader.modeWhat = 2;
            }
            if (args[3].equals("lowmem")) {
                Npc.setLowMemory((byte) -126);
            } else if (args[3].equals("highmem")) {
                Deque.setHighMemory(1);
            } else {
                JString.printArgsUsage();
            }
            if (args[4].equals("free")) {
                HashTable.members = false;
            } else if (args[4].equals("members")) {
                HashTable.members = true;
            } else {
                JString.printArgsUsage();
            }
            if (args[5].equals("english")) {
                HashTable.languageId = 0;
            } else if (!args[5].equals("german")) {
                JString.printArgsUsage();
            } else {
                LanguageUtils.setMessagesToGerman();
                HashTable.languageId = 1;
            }
            TextureLoaderImpl.audioHandler = new MidiHandler();
            Client client = new Client();
            client.initialize(443, InetAddress.getLocalHost(), "runescape", 765, 503, 14, AbstractFileLoader.modeWhat + 32);
        } catch (Exception exception) {
            ClassCheckRequest.method849(exception, 64, null);
        }
    }

    public void method20(boolean bool) {
        if (!bool) {
            Entity.anInt1732 = (Class39_Sub5_Sub6.modeWhere != 0 ? 43594 : BufferedFile.worldId + 40000);
            Bzip2Entry.anInt1078 = (Class39_Sub5_Sub6.modeWhere != 0 ? BufferedFile.worldId + 50000 : 443);
            HashTable.anInt363 = Entity.anInt1732;
            Huffman.method882(116);
            Class13.method188((byte) -95, Class41.canvas);
            ClientScript.attachListeners(Class41.canvas);
            Class43.aClass34_814 = Projectile.method492(true);
            if (Class43.aClass34_814 != null) {
                Class43.aClass34_814.method337(Class41.canvas, (byte) 87);
            }
            Class37.anInt656 = Signlink.anInt415;
            try {
                if (Class39_Sub5_Sub9.fileSignlink.mainArchive != null) {
                    Class43.mainFile = new BufferedFile((Class39_Sub5_Sub9.fileSignlink.mainArchive), 5200, 0);
                    for (int i = 0; i < 14; i++) {
                        Npc.indexFiles[i] = new BufferedFile((Class39_Sub5_Sub9.fileSignlink.cacheArchives[i]), 6000, 0);
                    }
                    Class25.tableFile = new BufferedFile(Class39_Sub5_Sub9.fileSignlink.tableArchive, 6000, 0);
                    Class14.tableCache = new CacheIO(255, Class43.mainFile, Class25.tableFile, 500000);
                    Class39_Sub5_Sub9.fileSignlink.mainArchive = null;
                    Class39_Sub5_Sub9.fileSignlink.cacheArchives = null;
                    Class39_Sub5_Sub9.fileSignlink.tableArchive = null;
                }
            } catch (java.io.IOException ioexception) {
                Class43.mainFile = null;
                Class25.tableFile = null;
                Class14.tableCache = null;
            }
            if (Class39_Sub5_Sub6.modeWhere != 0) {
                OndemandRequest.drawFps = true;
            }
            Class65.aClass39_Sub5_Sub17_1136 = new Widget();
        }
    }
    
    
    public void handleOdConnect() {
        if (Class20.anInt393 >= 4) {
            displayErrorPage("js5crc");
            state = 1000;
        } else {
            if (OndemandHandler.errors >= 4) {
                if (state <= 5) {
                    displayErrorPage("js5io");
                    state = 1000;
                    return;
                }
                OndemandHandler.odConnectionDelay = 3000;
                OndemandHandler.errors = 3;
            }
            if (OndemandHandler.odConnectionDelay-- <= 0) {
                do {
                    try {
                        if (ObjectDefinition.odStage == 0) {
                            Class20.aClass56_390 = Class39_Sub5_Sub9.fileSignlink.requestSocket(HashTable.anInt363);
                            ObjectDefinition.odStage++;
                        }
                        if (ObjectDefinition.odStage == 1) {
                            if (Class20.aClass56_390.returnCode == 2) {
                                handleOdError(-1);
                                break;
                            }
                            if (Class20.aClass56_390.returnCode == 1) {
                                ObjectDefinition.odStage++;
                            }
                        }
                        if (ObjectDefinition.odStage == 2) {
                            ArchiveWorker.odSocket = new JSocket((Socket) (Class20.aClass56_390.returnObject), Class39_Sub5_Sub9.fileSignlink);
                            Buffer buffer = new Buffer(5);
                            buffer.putByte(15);
                            buffer.putDword(443);
                            ArchiveWorker.odSocket.write(buffer.payload, 0, 5);
                            ObjectDefinition.odStage++;
                            OndemandRequest.wroteGatewayTime = Class2.getSystemTime();
                        }
                        if (ObjectDefinition.odStage == 3) {
                            if (state > 5 && ArchiveWorker.odSocket.available() <= 0) {
                                if ((-OndemandRequest.wroteGatewayTime + Class2.getSystemTime()) > 30000L) {
                                    handleOdError(-2);
                                    break;
                                }
                            } else {
                                int response = ArchiveWorker.odSocket.read();
                                if (response != 0) {
                                    handleOdError(response);
                                    break;
                                }
                                ObjectDefinition.odStage++;
                            }
                        }
                        if (ObjectDefinition.odStage != 4) {
                            break;
                        }
                        OndemandHandler.writeConnect(ArchiveWorker.odSocket, state > 20);
                        Projectile.anInt2192 = 0;
                        ObjectDefinition.odStage = 0;
                        Class20.aClass56_390 = null;
                        ArchiveWorker.odSocket = null;
                    } catch (IOException ioexception) {
                        handleOdError(-3);
                        break;
                    }
                    break;
                } while (false);
            }
        }
    }

    public void updateOndemand() {
        if (state != 1000) {
            boolean bool = OndemandHandler.cycle();
            if (!bool) {
                handleOdConnect();
            }
        }
    }
    
    public void handleOdError(int opcode) {
        if (Entity.anInt1732 == HashTable.anInt363) {
            HashTable.anInt363 = Bzip2Entry.anInt1078;
        } else {
            HashTable.anInt363 = Entity.anInt1732;
        }
        ObjectDefinition.odStage = 0;
        Projectile.anInt2192++;
        ArchiveWorker.odSocket = null;
        Class20.aClass56_390 = null;
        if (Projectile.anInt2192 < 2 || opcode != 7 && opcode != 9) {
            if (Projectile.anInt2192 < 2 || opcode != 6) {
                if (Projectile.anInt2192 >= 4) {
                    if (state > 5) {
                        OndemandHandler.odConnectionDelay = 3000;
                    } else {
                        displayErrorPage("js5connect");
                        state = 1000;
                    }
                }
            } else {
                displayErrorPage("js5connect_outofdate");
                state = 1000;
            }
        } else if (state > 5) {
            OndemandHandler.odConnectionDelay = 3000;
        } else {
            displayErrorPage("js5connect_full");
            state = 1000;
        }
    }

    static {
        messageTypes = new int[100];
        anInt1269 = 0;
        anIntArray1276 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        TextConstants.aClass3_1273 = null;
        incomingSizes = (new int[]{0, 0, 0, 6, 0, 0, 2, 0, 0, 0,
                                   1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                   0, 0, 10, 0, 6, -1, 0, 0, 0, -2,
                                   0, 4, 0, 0, 0, 0, 0, 0, 0, 0,
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                   0, 0, 0, 0, 0, 0, 0, 1, 6, 0,
                                   0, 0, 3, 0, 0, 0, 0, 0, 0, 2,
                                   0, 0, 2, 8, 6, 0, 0, -1, 0, 7,
                                   0, 5, 2, 0, 3, 0, 0, 1, 6, 0,
                                   3, 3, 0, 0, 7, 6, 6, 2, 0, 0,
                                   0, 15, 0, 0, 0, 0, 0, 0, 0, 5, 6, 6, 0, 0, 0, 6, 0, 2, 0, 0, 0, -2, 4, 0, 0, 0, 0, 0, 0, 14, -1, 0, 0, 2, 0, 0, 0, 10, 0, 0, 2, 0, 0, 0, 0, 0, 4, 10, 1, 2, 0, 0, 0, 0, 4, 5, 4, -1, 0, -2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 10, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, -2, 2, 0, 5, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 1, 6, -2, 0, 2, 0, 8, 0, 5, 0, 1, 0, -2, 0, 0, 6, 0, 0, -2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        TextConstants.aClass3_1270 = TextConstants.level;
        TextConstants.aClass3_1277 = TextConstants.loadingConfig;
        TextConstants.aClass3_1264 = TextConstants.noReplyLoginserver;
        TextConstants.aClass3_1279 = TextConstants.loadedGamescreen;
    }
}
