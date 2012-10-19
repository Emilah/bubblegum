package com.jagex.io;

/* Class39_Sub6 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.Client;
import com.jagex.KeycodeConstants;
import com.jagex.TextConstants;
import com.jagex.net.JSocket;
import com.jagex.utils.Cache;
import java.math.BigInteger;
import com.jagex.utils.Bzip2Block;
import com.jagex.awt.JCanvas;
import com.jagex.world.Barrier;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class43;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.Timer;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import com.jagex.script.ClientScript;
import com.jagex.utils.Deque;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.utils.ISAAC;
import com.jagex.graphics.JImage;
import com.jagex.awt.events.JMouseListener;
import com.jagex.utils.JString;
import com.jagex.utils.NameTable;
import com.jagex.utils.Node;
import com.jagex.world.entities.Npc;
import com.jagex.od.OndemandRequest;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.JRuntimeException;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.SubNode;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.Widget;

public class Buffer extends Node {
    public static JString aClass3_1354;
    public static int[] anIntArray1355;
    public static JString aClass3_1356 = JString.create("An");
    public int offset;
    public static FileLoader fileLoader0;
    public static JString aClass3_1359;
    public static JString aClass3_1360;
    public static int anInt1361 = 0;
    public static AbstractFileLoader aClass9_1362;
    public static JString aClass3_1363;
    public static int anInt1364;
    public static JString aClass3_1365;
    public static JString aClass3_1366;
    public byte[] payload;
    public static int readQueueOffset;
    public static JString aClass3_1369;
    public static JString aClass3_1370;

    public void getBytes128(byte[] dest, int off, int len) {
        for (int pos = off; pos < len + off; pos++) {
            dest[pos] = (byte) (payload[offset++] - 128);
        }
    }

    public static void method782(byte i) {
        aClass3_1365 = null;
        aClass3_1369 = null;
        aClass9_1362 = null;
        anIntArray1355 = null;
        fileLoader0 = null;
        aClass3_1360 = null;
        aClass3_1354 = null;
        aClass3_1366 = null;
        aClass3_1363 = null;
        aClass3_1359 = null;
        aClass3_1370 = null;
        aClass3_1356 = null;
    }

    public void getBytesReverse(byte[] dest, int off, int len) {
        for (int pos = off + len - 1; pos >= off; pos--) {
            dest[pos] = payload[offset++];
        }
    }

    public int getUbyte() {
        return payload[offset++] & 0xff;
    }

    public void putByteA(int i_6_) {
        payload[offset++] = (byte) -i_6_;
    }

    public void putWordLe(int value) {
        payload[offset++] = (byte) value;
        payload[offset++] = (byte) (value >> 8);
    }

    public static void method787(int i) {
        JRuntimeException.aClass7_1220.clear();
    }

    public int getUbyte128() {
        return payload[offset++] - 128 & 0xff;
    }

    public void putDwordLe(int value) {
        payload[offset++] = (byte) value;
        payload[offset++] = (byte) (value >> 8);
        payload[offset++] = (byte) (value >> 16);
        payload[offset++] = (byte) (value >> 24);
    }

    public void putBytes(byte[] src, int off, int len) {
        for (int i = off; i < len + off; i++) {
            payload[offset++] = src[i];
        }
    }

    public int putPayloadChecksum(int startOff) {
        int checksum = Class25.computeChecksum(payload, startOff, offset);
        putDword(checksum);
        return checksum;
    }

    public int getWord128() {
        offset += 2;
        int i = ((payload[offset - 2] << 8 & 0xff00)
                + (payload[offset - 1] - 128 & 0xff));
        if (i > 32767) {
            i -= 65536;
        }
        return i;
    }

    public int getUtri() {
        offset += 3;
        return ((payload[offset - 2] << 8 & 0xff00)
                + ((payload[offset - 3] << 16 & 0xff0000)
                + (payload[offset - 1] & 0xff)));
    }

    public int getWordLe() {
        offset += 2;
        int i_14_ = (((payload[offset - 1] & 0xff) << 8)
                + (payload[offset - 2] & 0xff));
        if (i_14_ > 32767) {
            i_14_ -= 65536;
        }
        return i_14_;
    }

    public long getQword() {
        long l = (long) getDword() & 0xffffffffL;
        long l_15_ = (long) getDword() & 0xffffffffL;
        return l_15_ + (l << 32);
    }

    public void putWordLe128(int i_16_) {
        payload[offset++] = (byte) (i_16_ + 128);
        payload[offset++] = (byte) (i_16_ >> 8);
    }

    public void putByteB(int i) {
        payload[offset++] = (byte) (-i + 128);
    }

    public int method798(int i) {
        int i_17_ = payload[offset++];
        int i_18_ = 0;
        for (/**/; i_17_ < 0; i_17_ = payload[offset++]) {
            i_18_ = (i_18_ | i_17_ & 0x7f) << 7;
        }
        return i_17_ | i_18_;
    }

    public byte getByteB() {
        return (byte) (128 - payload[offset++]);
    }

    public int getUword() {
        offset += 2;
        return ((payload[offset - 1] & 0xff)
                + ((payload[offset - 2] & 0xff) << 8));
    }

    public int getUwordLe() {
        offset += 2;
        return ((payload[offset - 1] << 8 & 0xff00)
                + (payload[offset - 2] & 0xff));
    }

    public byte getByte() {
        return payload[offset++];
    }

    public void putQword(long l) {
        payload[offset++] = (byte) (int) (l >> 56);
        payload[offset++] = (byte) (int) (l >> 48);
        payload[offset++] = (byte) (int) (l >> 40);
        payload[offset++] = (byte) (int) (l >> 32);
        payload[offset++] = (byte) (int) (l >> 24);
        payload[offset++] = (byte) (int) (l >> 16);
        payload[offset++] = (byte) (int) (l >> 8);
        payload[offset++] = (byte) (int) l;
    }

    public int getUbyteB() {
        return 128 - payload[offset++] & 0xff;
    }

    public void putByte(int i_20_) {
        payload[offset++] = (byte) i_20_;
    }

    public void putTri(int i_21_) {
        payload[offset++] = (byte) (i_21_ >> 16);
        payload[offset++] = (byte) (i_21_ >> 8);
        payload[offset++] = (byte) i_21_;
    }

    public void decipherXtea(int[] keys, int i, int i_22_, int i_23_) {
        int i_24_ = offset;
        int i_25_ = (i_22_ - i_23_) / 8;
        offset = i_23_;
        for (int i_26_ = i; i_25_ > i_26_; i_26_++) {
            int v0 = getDword();
            int i_28_ = 32;
            int counter = -957401312;
            int delta = -1640531527;
            int v1 = getDword();
            while (i_28_-- > 0) {
                v1 -= (keys[(counter & 0x1ff1) >>> 11] + counter
                        ^ v0 + (v0 << 4 ^ v0 >>> 5));
                counter -= delta;
                v0 -= (v1 + (v1 << 4 ^ v1 >>> 5)
                        ^ counter + keys[counter & 0x3]);
            }
            offset -= 8;
            putDword(v0);
            putDword(v1);
        }
        offset = i_24_;
    }

    public void putDword(int i) {
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    public int getWord() {
        offset += 2;
        int i_33_ = ((payload[offset - 1] & 0xff)
                + (payload[offset - 2] << 8 & 0xff00));
        if (i_33_ > 32767) {
            i_33_ -= 65536;
        }
        return i_33_;
    }

    public byte getByteA() {
        return (byte) -payload[offset++];
    }

    public int getDword() {
        offset += 4;
        return (((payload[offset - 2] & 0xff) << 8)
                + ((payload[offset - 3] & 0xff) << 16)
                + (payload[offset - 4] << 24 & ~0xffffff)
                + (payload[offset - 1] & 0xff));
    }

    public int getDwordB() {
        offset += 4;
        return (((payload[offset - 1] & 0xff) << 8)
                + ((payload[offset - 4] & 0xff) << 16)
                + (((payload[offset - 3] & 0xff) << 24)
                + (payload[offset - 2] & 0xff)));
    }

    public byte getByte128() {
        return (byte) (payload[offset++] - 128);
    }

    public static void method814(int i) {
        while (Class39_Sub5_Sub7.method588(-4)) {
            if (StillObject.viewOverlayId == -1 || Class26.anInt473 != StillObject.viewOverlayId) {
                if (!Class39_Sub12.aBoolean1489) {
                    if (Mob.keyboardInputType != 1) {
                        if (Mob.keyboardInputType == 2) {
                            if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE && Class66.inputMessageJstr.getLength() > 0) {
                                Class66.inputMessageJstr = (Class66.inputMessageJstr.substring(0, Class66.inputMessageJstr.getLength() - 1));
                                Class14.aBoolean245 = true;
                            }
                            if ((Class37.isAlphaNumericChar((Projectile.currentKey)) || Projectile.currentKey == 32) && Class66.inputMessageJstr.getLength() < 12) {
                                Class66.inputMessageJstr = (Class66.inputMessageJstr.concat(Projectile.currentKey));
                                Class14.aBoolean245 = true;
                            }
                            if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER) {
                                if (Class66.inputMessageJstr.getLength() > 0) {
                                    FrameBuffer.outgoingBuffer.putFrame(22);
                                    FrameBuffer.outgoingBuffer.putQword(Class66.inputMessageJstr.encodeBase37());
                                }
                                Mob.keyboardInputType = 0;
                                Class14.aBoolean245 = true;
                            }
                        } else if (Mob.keyboardInputType != 3) {
                            if (Class39_Sub5_Sub14.chatboxOverlayId == -1
                                    && SubNode.screenWidgetId == -1) {
                                if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE
                                        && (Class66.chatMessageJstr.getLength()
                                        > 0)) {
                                    Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(0, Class66.chatMessageJstr.getLength() - 1));
                                    Class14.aBoolean245 = true;
                                }
                                if (Class26.isValidChar((Projectile.currentKey))
                                        && (Class66.chatMessageJstr.getLength()
                                        < 80)) {
                                    Class66.chatMessageJstr = (Class66.chatMessageJstr.concat(Projectile.currentKey));
                                    Class14.aBoolean245 = true;
                                }
                                if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER
                                        && (Class66.chatMessageJstr.getLength()
                                        > 0)) {
                                    if (CacheIO.rights == 2) {
                                        if (Class66.chatMessageJstr.isEqual(Class39_Sub5_Sub18.aClass3_2138)) {
                                            Class37.method354((byte) 81);
                                        }
                                        if (Class66.chatMessageJstr.isEqual((Class39_Sub5_Sub4_Sub2.aClass3_2213))) {
                                            OndemandRequest.drawFps = true;
                                        }
                                        if (Class66.chatMessageJstr.isEqual(Class32.aClass3_588)) {
                                            OndemandRequest.drawFps = false;
                                        }
                                        if (Class66.chatMessageJstr.isEqual(NameTable.aClass3_185)) {
                                            for (int i_34_ = 0; i_34_ < 4;
                                                    i_34_++) {
                                                for (int i_35_ = 1;
                                                        i_35_ < 103; i_35_++) {
                                                    for (int i_36_ = 1;
                                                            i_36_ < 103; i_36_++) {
                                                        Class39_Sub5_Sub12.traversalMaps[i_34_].adjancency[i_35_][i_36_] = 0;
                                                    }
                                                }
                                            }
                                        }
                                        if ((Class66.chatMessageJstr.isEqual(Class39_Sub5_Sub18.aClass3_2123))
                                                && (Class39_Sub5_Sub6.modeWhere
                                                == 2)) {
                                            throw new RuntimeException();
                                        }
                                        if (Class66.chatMessageJstr.isEqual(ArchiveRequest.aClass3_1414)) {
                                            HashTable.aBoolean361 = true;
                                        }
                                    }
                                    if (Class66.chatMessageJstr.beginsWith(Barrier.commandPrefixJstr)) {
                                        FrameBuffer.outgoingBuffer.putFrame(174);
                                        FrameBuffer.outgoingBuffer.putByte(Class66.chatMessageJstr.getLength() - 1);
                                        FrameBuffer.outgoingBuffer.putJstr(Class66.chatMessageJstr.substring(2));
                                    } else {
                                        int i_37_ = 0;
                                        int i_38_ = 0;
                                        JString class3 = Class66.chatMessageJstr.method77();
                                        if (!class3.beginsWith((Class39_Sub5_Sub4_Sub2.aClass3_2218))) {
                                            if (class3.beginsWith(Class39_Sub12.aClass3_1485)) {
                                                Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Class39_Sub12.aClass3_1485.getLength()));
                                                i_37_ = 1;
                                            } else if (!class3.beginsWith(JMouseListener.aClass3_795)) {
                                                if (!class3.beginsWith(JSocket.aClass3_308)) {
                                                    if (class3.beginsWith((Npc.aClass3_2496))) {
                                                        i_37_ = 4;
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((Npc.aClass3_2496.getLength())));
                                                    } else if (class3.beginsWith((JCanvas.aClass3_13))) {
                                                        i_37_ = 5;
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((JCanvas.aClass3_13.getLength())));
                                                    } else if (class3.beginsWith((JImage.aClass3_1585))) {
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((JImage.aClass3_1585.getLength())));
                                                        i_37_ = 6;
                                                    } else if (class3.beginsWith((Class39_Sub10.aClass3_1448))) {
                                                        i_37_ = 7;
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((Class39_Sub10.aClass3_1448.getLength())));
                                                    } else if (class3.beginsWith((Class13.aClass3_198))) {
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((Class13.aClass3_198.getLength())));
                                                        i_37_ = 8;
                                                    } else if (class3.beginsWith((FrameBuffer.aClass3_2144))) {
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((FrameBuffer.aClass3_2144.getLength())));
                                                        i_37_ = 9;
                                                    } else if (class3.beginsWith((Class63.aClass3_1129))) {
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((Class63.aClass3_1129.getLength())));
                                                        i_37_ = 10;
                                                    } else if (class3.beginsWith((Class39_Sub5_Sub7.aClass3_1787))) {
                                                        i_37_ = 11;
                                                        Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((Class39_Sub5_Sub7.aClass3_1787.getLength())));
                                                    }
                                                } else {
                                                    Class66.chatMessageJstr = (Class66.chatMessageJstr.substring((JSocket.aClass3_308.getLength())));
                                                    i_37_ = 3;
                                                }
                                            } else {
                                                i_37_ = 2;
                                                Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(JMouseListener.aClass3_795.getLength()));
                                            }
                                        } else {
                                            i_37_ = 0;
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Class39_Sub5_Sub4_Sub2.aClass3_2218.getLength()));
                                        }
                                        class3 = Class66.chatMessageJstr.method77();
                                        if (class3.beginsWith((Class53.aClass3_958))) {
                                            i_38_ = 1;
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Class53.aClass3_958.getLength()));
                                        } else if (class3.beginsWith((Class39_Sub5_Sub12.aClass3_1850))) {
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Class39_Sub5_Sub12.aClass3_1850.getLength()));
                                            i_38_ = 2;
                                        } else if (class3.beginsWith(Timer.aClass3_877)) {
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Timer.aClass3_877.getLength()));
                                            i_38_ = 3;
                                        } else if (class3.beginsWith(TextureLoaderImpl.aClass3_1253)) {
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(TextureLoaderImpl.aClass3_1253.getLength()));
                                            i_38_ = 4;
                                        } else if (class3.beginsWith(Class34.aClass3_615)) {
                                            i_38_ = 5;
                                            Class66.chatMessageJstr = (Class66.chatMessageJstr.substring(Class34.aClass3_615.getLength()));
                                        }
                                        FrameBuffer.outgoingBuffer.putFrame(4);
                                        FrameBuffer.outgoingBuffer.putByte(0);
                                        int offset = (FrameBuffer.outgoingBuffer.offset);
                                        FrameBuffer.outgoingBuffer.putByte(i_37_);
                                        FrameBuffer.outgoingBuffer.putByte(i_38_);
                                        Class68.encodeHuffmans((FrameBuffer.outgoingBuffer),
                                                Class66.chatMessageJstr, -110);
                                        FrameBuffer.outgoingBuffer.putByteLength((FrameBuffer.outgoingBuffer.offset) - offset);
                                        if (Bzip2Block.anInt1051 == 2) {
                                            Mob.aBoolean2253 = true;
                                            Bzip2Block.anInt1051 = 3;
                                            Projectile.anInt2203++;
                                            FrameBuffer.outgoingBuffer.putFrame(76);
                                            FrameBuffer.outgoingBuffer.putByte(Bzip2Block.anInt1051);
                                            FrameBuffer.outgoingBuffer.putByte(NameTable.anInt177);
                                            FrameBuffer.outgoingBuffer.putByte(Cache.anInt118);
                                        }
                                    }
                                    Class14.aBoolean245 = true;
                                    Class66.chatMessageJstr = Class66.blankString;
                                }
                            }
                        } else {
                            if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE && Class66.inputMessageJstr.getLength() > 0) {
                                Class66.inputMessageJstr = (Class66.inputMessageJstr.substring(0, (Class66.inputMessageJstr.getLength() - 1)));
                                Class14.aBoolean245 = true;
                            }
                            if (Class26.isValidChar((Projectile.currentKey))  && Class66.inputMessageJstr.getLength() < 40) {
                                Class66.inputMessageJstr = (Class66.inputMessageJstr.concat(Projectile.currentKey));
                                Class14.aBoolean245 = true;
                            }
                        }
                    } else {
                        if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE && Class66.inputMessageJstr.getLength() > 0) {
                            Class66.inputMessageJstr = (Class66.inputMessageJstr.substring(0, Class66.inputMessageJstr.getLength() - 1));
                            Class14.aBoolean245 = true;
                        }
                        if (Class43.isNumericChar(Projectile.currentKey) && Class66.inputMessageJstr.getLength() < 10) {
                            Class66.inputMessageJstr = (Class66.inputMessageJstr.concat(Projectile.currentKey));
                            Class14.aBoolean245 = true;
                        }
                        if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER) {
                            if (Class66.inputMessageJstr.getLength() > 0) {
                                int i_40_ = 0;
                                if (Class66.inputMessageJstr.isValidNumber(22415)) {
                                    i_40_ = Class66.inputMessageJstr.toInteger();
                                }
                                FrameBuffer.outgoingBuffer.putFrame(74);
                                FrameBuffer.outgoingBuffer.putDword(i_40_);
                            }
                            Mob.keyboardInputType = 0;
                            Class14.aBoolean245 = true;
                        }
                    }
                } else {
                    if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE
                            && Class66.socialListMessage.getLength() > 0) {
                        Class66.socialListMessage = (Class66.socialListMessage.substring(0, Class66.socialListMessage.getLength() - 1));
                        Class14.aBoolean245 = true;
                    }
                    if (Class26.isValidChar(Projectile.currentKey)
                            && Class66.socialListMessage.getLength() < 80) {
                        Class66.socialListMessage = (Class66.socialListMessage.concat(Projectile.currentKey));
                        Class14.aBoolean245 = true;
                    }
                    if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER) {
                        Class14.aBoolean245 = true;
                        Class39_Sub12.aBoolean1489 = false;
                        if (Class15.socialListMessageType == 1) {
                            long l = Class66.socialListMessage.encodeBase37();
                            Class68.addFriend(l);
                        }
                        if (Class15.socialListMessageType == 2 && Class4.anInt62 > 0) {
                            long l = Class66.socialListMessage.encodeBase37();
                            Class20.removeFriend(l, (byte) -123);
                        }
                        if (Class15.socialListMessageType == 3 && Class66.socialListMessage.getLength() > 0) {
                            FrameBuffer.outgoingBuffer.putFrame(50);
                            FrameBuffer.outgoingBuffer.putByte(0);
                            int i_41_ = (FrameBuffer.outgoingBuffer.offset);
                            FrameBuffer.outgoingBuffer.putQword(Huffman.aLong752);
                            Class68.encodeHuffmans((FrameBuffer.outgoingBuffer),
                                    Class66.socialListMessage, -126);
                            FrameBuffer.outgoingBuffer.putByteLength(-i_41_ + (FrameBuffer.outgoingBuffer.offset));
                            if (NameTable.anInt177 == 2) {
                                Mob.aBoolean2253 = true;
                                Projectile.anInt2203++;
                                NameTable.anInt177 = 1;
                                FrameBuffer.outgoingBuffer.putFrame(76);
                                FrameBuffer.outgoingBuffer.putByte(Bzip2Block.anInt1051);
                                FrameBuffer.outgoingBuffer.putByte(NameTable.anInt177);
                                FrameBuffer.outgoingBuffer.putByte(Cache.anInt118);
                            }
                        }
                        if (Class15.socialListMessageType == 4 && Class15.amountIgnores < 100) {
                            long l = Class66.socialListMessage.encodeBase37();
                            Class65.addIgnore(l);
                        }
                        if (Class15.socialListMessageType == 5 && Class15.amountIgnores > 0) {
                            long l = Class66.socialListMessage.encodeBase37();
                            HashTable.removeIgnore(l);
                        }
                    }
                }
            } else {
                if (Class15.currentKeyCode == 85
                        && Class66.reportUsername.getLength() > 0) {
                    Class66.reportUsername = (Class66.reportUsername.substring(0, Class66.reportUsername.getLength() - 1));
                }
                if ((Class37.isAlphaNumericChar(Projectile.currentKey)
                        || Projectile.currentKey == 32)
                        && Class66.reportUsername.getLength() < 12) {
                    Class66.reportUsername = Class66.reportUsername.concat((Projectile.currentKey));
                }
            }
        }
    }

    public int getUbyteA() {
        return -payload[offset++] & 0xff;
    }

    public void putByteLength(int length) {
        payload[-length + offset - 1] = (byte) length;
    }

    public int getSmartA() {
        int i_43_ = payload[offset] & 0xff;
        if (i_43_ < 128) {
            return getUbyte() - 64;
        }
        return getUword() - 49152;
    }

    public int getUword128() {
        offset += 2;
        return ((payload[offset - 1] - 128 & 0xff)
                + (payload[offset - 2] << 8 & 0xff00));
    }

    public void putDwordA(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) (i >> 16);
    }

    public int getWordLe128() {
        offset += 2;
        int i_45_ = ((payload[offset - 1] << 8 & 0xff00)
                + (payload[offset - 2] - 128 & 0xff));
        if (i_45_ > 32767) {
            i_45_ -= 65536;
        }
        return i_45_;
    }

    public int getDwordLe() {
        offset += 4;
        return ((payload[offset - 4] & 0xff)
                + (((payload[offset - 2] & 0xff) << 16)
                + (payload[offset - 1] << 24 & ~0xffffff))
                + ((payload[offset - 3] & 0xff) << 8));
    }

    public int getUtriA() {
        offset += 3;
        return ((payload[offset - 2] & 0xff)
                + (payload[offset - 1] << 8 & 0xff00)
                + (payload[offset - 3] << 16 & 0xff0000));
    }

    public static void method823(int i) {
        if (ClientScript.aBoolean1690) {
            ClientScript.aBoolean1690 = false;
            VarbitDefinition.method590(false);
            Class14.aBoolean245 = true;
            Mob.aBoolean2253 = true;
            Class39_Sub14.updateTab = true;
            ISAAC.aBoolean1089 = true;
        }
        Class39_Sub5_Sub7.method589((byte) 101);
        if (Class39_Sub12.aBoolean1493 && Class37.anInt653 == 1) {
            Class39_Sub14.updateTab = true;
        }
        if (StillGraphic.tabOverlayId != -1) {
            boolean bool = Class39_Sub4.updateWidgets(StillGraphic.tabOverlayId);
            if (bool) {
                Class39_Sub14.updateTab = true;
            }
        }
        if (Class25.anInt459 == 2) {
            Class39_Sub14.updateTab = true;
        }
        if (Class30.anInt534 == 2) {
            Class39_Sub14.updateTab = true;
        }
        if (Class39_Sub14.updateTab) {
            Class39_Sub14.updateTab = false;
            JRuntimeException.method1124((byte) 44);
        }
        if (Class39_Sub5_Sub14.chatboxOverlayId == -1) {
            Class65.aClass39_Sub5_Sub17_1136.scrollY = -Node.anInt741 - 77 + Deque.anInt912;
            if (ISAAC.mousePositionX > 17 && ISAAC.mousePositionX < 560
                    && Class33.mousePositionY > 332) {
                Class39_Sub4.method456((byte) 121, 463, ISAAC.mousePositionX - 17,
                        Class33.mousePositionY - 357, -1, 77, 0,
                        Deque.anInt912,
                        Class65.aClass39_Sub5_Sub17_1136);
            }
            int i_46_ = (-Class65.aClass39_Sub5_Sub17_1136.scrollY
                    + (Deque.anInt912 - 77));
            if (i_46_ < 0) {
                i_46_ = 0;
            }
            if (i_46_ > Deque.anInt912 - 77) {
                i_46_ = Deque.anInt912 - 77;
            }
            if (Node.anInt741 != i_46_) {
                Class14.aBoolean245 = true;
                Node.anInt741 = i_46_;
            }
        }
        if (Class39_Sub5_Sub14.chatboxOverlayId == -1
                && Mob.keyboardInputType == 3) {
            Class65.aClass39_Sub5_Sub17_1136.scrollY = Class39_Sub14.anInt1511;
            int i_47_ = Class67.anInt1184 * 14 + 7;
            if (ISAAC.mousePositionX > 17 && ISAAC.mousePositionX < 560
                    && Class33.mousePositionY > 332) {
                Class39_Sub4.method456((byte) 121, 463, ISAAC.mousePositionX - 17,
                        Class33.mousePositionY - 357, -1, 77, 0,
                        i_47_,
                        Class65.aClass39_Sub5_Sub17_1136);
            }
            int i_48_ = Class65.aClass39_Sub5_Sub17_1136.scrollY;
            if (i_48_ < 0) {
                i_48_ = 0;
            }
            if (i_47_ - 77 < i_48_) {
                i_48_ = i_47_ - 77;
            }
            if (i_48_ != Class39_Sub14.anInt1511) {
                Class39_Sub14.anInt1511 = i_48_;
                Class14.aBoolean245 = true;
            }
        }
        if (i != (Class39_Sub5_Sub14.chatboxOverlayId ^ 0xffffffff)) {
            boolean bool = Class39_Sub4.updateWidgets(Class39_Sub5_Sub14.chatboxOverlayId);
            if (bool) {
                Class14.aBoolean245 = true;
            }
        }
        if (Class25.anInt459 == 3) {
            Class14.aBoolean245 = true;
        }
        if (Class30.anInt534 == 3) {
            Class14.aBoolean245 = true;
        }
        if (TextConstants.aClass3_1714 != null) {
            Class14.aBoolean245 = true;
        }
        if (Class39_Sub12.aBoolean1493 && Class37.anInt653 == 2) {
            Class14.aBoolean245 = true;
        }
        if (Class14.aBoolean245) {
            Class14.aBoolean245 = false;
            Class32.method325((byte) -85);
        }
        Widget.method761((byte) 45);
        if (ClientScript.anInt1703 != -1) {
            ISAAC.aBoolean1089 = true;
        }
        if (ISAAC.aBoolean1089) {
            if (ClientScript.anInt1703 != -1 && ClientScript.anInt1703 == Node.currentTabId) {
                ClientScript.anInt1703 = -1;
                FrameBuffer.outgoingBuffer.putFrame(65);
                FrameBuffer.outgoingBuffer.putByte(Node.currentTabId);
            }
            NameTable.aBoolean183 = true;
            ISAAC.aBoolean1089 = false;
            VarpDefinition.method748(Class39_Sub5_Sub14.tabWidgetIds,
                    (StillGraphic.tabOverlayId
                    == -1),
                    (byte) 82,
                    (Class2.logicCycle % 20 >= 10
                    ? ClientScript.anInt1703 : -1),
                    Node.currentTabId);
        }
        if (Mob.aBoolean2253) {
            NameTable.aBoolean183 = true;
            Mob.aBoolean2253 = false;
            ArchiveWorker.method1119(Cache.anInt118, Bzip2Block.anInt1051,
                    (Class39_Sub5_Sub14.p12fullFont),
                    41, NameTable.anInt177);
        }
        Npc.method520(-118, PlayerApperance.anInt856,
                Cache.localPlayer.fPositionY,
                Cache.localPlayer.fPositionX,
                NameTable.height);
        PlayerApperance.anInt856 = 0;
    }

    public JString getJstr() {
        int i_49_ = offset;
        while (payload[offset++] != 0) {
            /* empty */
        }
        return HashTable.createJstring(payload, i_49_,
                offset - i_49_ - 1);
    }

    public void getBytes(byte[] dest, int off, int len) {
        for (int i = off; i < off + len; i++) {
            dest[i] = payload[offset++];
        }
    }

    public int getSmartB() {
        int i_52_ = payload[offset] & 0xff;
        if (i_52_ >= 128) {
            return getUword() - 32768;
        }
        return getUbyte();
    }

    public void putDwordB(int i) {
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) i;
        payload[offset++] = (byte) (i >> 8);
    }

    public void applyRsa(BigInteger publicExponent, BigInteger modulus, int i) {
        int i_55_ = offset;
        offset = 0;
        byte[] is = new byte[i_55_];
        getBytes(is, 0, i_55_);
        BigInteger biginteger_56_ = new BigInteger(is);
        BigInteger biginteger_57_ = biginteger_56_;//.modPow(publicExponent, modulus);
        byte[] is_58_ = biginteger_57_.toByteArray();
        offset = 0;
        putByte(is_58_.length);
        putBytes(is_58_, 0, is_58_.length);
    }

    public Buffer(int i) {
        payload = Class4.getByteArray(i);
        offset = 0;
    }

    public Buffer(byte[] is) {
        payload = is;
        offset = 0;
    }

    public int getDwordA() {
        offset += 4;
        return ((payload[offset - 3] & 0xff)
                + (payload[offset - 4] << 8 & 0xff00)
                + ((payload[offset - 1] << 16 & 0xff0000)
                + ((payload[offset - 2] & 0xff) << 24)));
    }

    public void putSmartB(int value) {
        if (value >= 0 && value < 128) {
            putByte(value);
        } else if (value >= 0 && value < 32768) {
            putWord(value + 32768);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void putWord(int value) {
        payload[offset++] = (byte) (value >> 8);
        payload[offset++] = (byte) value;
    }

    public void putWord128(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) (i + 128);
    }

    public int getUwordLe128() {
        offset += 2;
        return (((payload[offset - 1] & 0xff) << 8) + (payload[offset - 2] - 128 & 0xff));
    }

    public void putJstr(JString jstr) {
        offset += jstr.method83(40, 0, payload, offset, jstr.getLength());
        payload[offset++] = (byte) 0;
    }

    static {
        aClass3_1360 = JString.create("(U(Y");
        aClass3_1354 = JString.create("Unable to find ");
        aClass3_1359 = JString.create("lila:");
        anInt1364 = 0;
        aClass3_1363 = JString.create("Benutzeroberfl-=che geladen)3");
        aClass3_1366 = JString.create("0(U");
        aClass3_1365 = aClass3_1354;
        aClass3_1370 = JString.create("null");
        aClass3_1369 = JString.create("T");
        readQueueOffset = 0;
    }
}
