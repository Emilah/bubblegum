package unpackaged;

/* Class34 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.ClassCheckRequest;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.script.ScriptState;
import com.jagex.script.ClientScript;
import com.jagex.utils.JRuntimeException;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.audio.AudioHandler;
import com.jagex.world.Mob;
import com.jagex.world.World;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.od.OndemandRequest;
import com.jagex.config.VarbitDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.JCanvas;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Block;
import com.jagex.io.BufferedFile;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.JImage;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.script.ScriptExecutor;
import com.jagex.utils.Cache;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

public abstract class Class34 {

    public static int anInt604;
    public static int anInt605;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_606;
    public static int anInt607 = 0;
    public static JString aClass3_608;
    public static JString aClass3_609;
    public static AbstractImage aClass57_610;
    public static JString aClass3_611 = JString.create("Okay");
    public static JString aClass3_612;
    public static JString aClass3_613;
    public static JString duelRequestJstr;
    public static JString aClass3_615;

    public abstract void method332(int i, Component component);

    public static void method333(int i, int i_0_, int i_1_) {
        if (i_1_ == 1) {
            FrameBuffer.outgoingBuffer.putFrame(13);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 2) {
            FrameBuffer.outgoingBuffer.putFrame(217);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 3) {
            FrameBuffer.outgoingBuffer.putFrame(161);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 4) {
            FrameBuffer.outgoingBuffer.putFrame(3);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 5) {
            FrameBuffer.outgoingBuffer.putFrame(40);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 6) {
            FrameBuffer.outgoingBuffer.putFrame(73);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 7) {
            FrameBuffer.outgoingBuffer.putFrame(57);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 8) {
            FrameBuffer.outgoingBuffer.putFrame(167);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 9) {
            FrameBuffer.outgoingBuffer.putFrame(28);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        if (i_1_ == 10) {
            FrameBuffer.outgoingBuffer.putFrame(8);
            FrameBuffer.outgoingBuffer.putDword(i);
            FrameBuffer.outgoingBuffer.putWord(i_0_);
        }
        Widget widget = Class62_Sub2.getWidgetChild(i, i_0_);
        if (widget != null && widget.anObjectArray2045 != null) {
            ScriptExecutor.executeClientScript(i_1_, (widget.anObjectArray2045), null, -105, 0, widget, 0);
        }
    }

    public static void method334(int i) {
        aClass39_Sub5_Sub10_Sub4_606 = null;
        aClass3_612 = null;
        aClass3_613 = null;
        aClass3_611 = null;
        aClass3_615 = null;
        aClass3_608 = null;
        aClass57_610 = null;
        duelRequestJstr = null;
        if (i == 1) {
            aClass3_609 = null;
        }
    }

    public static void method335(int i, boolean bool) {
        if ((Cache.localPlayer.fPositionY >> 7
                == Class30.anInt544)
                && (Cache.localPlayer.fPositionX >> 7
                == ArchiveRequest.anInt1407)) {
            Class30.anInt544 = 0;
        }
        int i_3_ = TraversalMap.anInt515;
        if (bool) {
            i_3_ = 1;
        }
        for (int i_4_ = 0; i_3_ > i_4_; i_4_++) {
            Player class39_sub5_sub4_sub4_sub2;
            int i_5_;
            if (bool) {
                class39_sub5_sub4_sub4_sub2 = Cache.localPlayer;
                i_5_ = 33538048;
            } else {
                class39_sub5_sub4_sub4_sub2 = (Class14.players[Class1.anIntArray40[i_4_]]);
                i_5_ = Class1.anIntArray40[i_4_] << 14;
            }
            if (class39_sub5_sub4_sub4_sub2 != null
                    && class39_sub5_sub4_sub4_sub2.method510((byte) -77)) {
                class39_sub5_sub4_sub4_sub2.aBoolean2505 = false;
                int i_6_ = class39_sub5_sub4_sub4_sub2.fPositionX >> 7;
                if ((PlayerApperance.isLowMemory && TraversalMap.anInt515 > 50
                        || TraversalMap.anInt515 > 200)
                        && !bool
                        && (class39_sub5_sub4_sub4_sub2.anInt2317
                        == class39_sub5_sub4_sub4_sub2.anInt2303)) {
                    class39_sub5_sub4_sub4_sub2.aBoolean2505 = true;
                }
                int i_7_ = class39_sub5_sub4_sub4_sub2.fPositionY >> 7;
                if (i_7_ >= 0 && i_7_ < 104 && i_6_ >= 0 && i_6_ < 104) {
                    if ((class39_sub5_sub4_sub4_sub2.aClass39_Sub5_Sub4_Sub6_2520) == null
                            || (Class2.logicCycle
                            < class39_sub5_sub4_sub4_sub2.anInt2512)
                            || (class39_sub5_sub4_sub4_sub2.anInt2523
                            <= Class2.logicCycle)) {
                        if (((class39_sub5_sub4_sub4_sub2.fPositionY & 0x7f)
                                == 64)
                                && ((class39_sub5_sub4_sub4_sub2.fPositionX & 0x7f)
                                == 64)) {
                            if (JCanvas.anInt15
                                    == ScriptState.anIntArrayArray455[i_7_][i_6_]) {
                                continue;
                            }
                            ScriptState.anIntArrayArray455[i_7_][i_6_] = JCanvas.anInt15;
                        }
                        class39_sub5_sub4_sub4_sub2.anInt2524 = Class14.method212((class39_sub5_sub4_sub4_sub2.fPositionY), (class39_sub5_sub4_sub4_sub2.fPositionX), NameTable.height);
                        Class44.world.method375(NameTable.height,
                                class39_sub5_sub4_sub4_sub2.fPositionY,
                                class39_sub5_sub4_sub4_sub2.fPositionX,
                                class39_sub5_sub4_sub4_sub2.anInt2524, 60,
                                class39_sub5_sub4_sub4_sub2,
                                class39_sub5_sub4_sub4_sub2.anInt2251, i_5_,
                                class39_sub5_sub4_sub4_sub2.aBoolean2298);
                    } else {
                        class39_sub5_sub4_sub4_sub2.aBoolean2505 = false;
                        class39_sub5_sub4_sub4_sub2.anInt2524 = Class14.method212((class39_sub5_sub4_sub4_sub2.fPositionY), (class39_sub5_sub4_sub4_sub2.fPositionX), NameTable.height);
                        Class44.world.method406(NameTable.height,
                                class39_sub5_sub4_sub4_sub2.fPositionY,
                                class39_sub5_sub4_sub4_sub2.fPositionX,
                                class39_sub5_sub4_sub4_sub2.anInt2524, 60,
                                class39_sub5_sub4_sub4_sub2,
                                class39_sub5_sub4_sub4_sub2.anInt2251, i_5_,
                                class39_sub5_sub4_sub4_sub2.anInt2511,
                                class39_sub5_sub4_sub4_sub2.anInt2510,
                                class39_sub5_sub4_sub4_sub2.anInt2513,
                                class39_sub5_sub4_sub4_sub2.anInt2522);
                    }
                }
            }
        }
    }

    public static void method336() {
        if (ClassCheckRequest.systemUpdateTime > 1) {
            ClassCheckRequest.systemUpdateTime--;
        }
        if (ClientScript.anInt1692 > 0) {
            ClientScript.anInt1692--;
        }
        if (Widget.aBoolean2116) {
            Widget.aBoolean2116 = false;
            Class37.method354((byte) 102);
        } else {
            for (int i = 0; i < 100; i++) {
                if (!Bzip2Block.readFrame()) {
                    break;
                }
            }
            if (Client.state == 30 || Client.state == 35) {
                if (AbstractImage.aBoolean1000 && Client.state == 30) {
                    Timer.anInt887 = 0;
                    Class30.anInt541 = 0;
                    while (Class39_Sub5_Sub7.method588(-4)) {
                        /* empty */
                    }
                    for (int i_9_ = 0; Class13.activeKeys.length > i_9_;
                            i_9_++) {
                        Class13.activeKeys[i_9_] = false;
                    }
                }
                BufferedFile.handleClassCheckRequests(FrameBuffer.outgoingBuffer);
                synchronized (Cache.mouseRecorder.lock) {
                    if (!Huffman.isFlagged) {
                        Cache.mouseRecorder.anInt561 = 0;
                    } else if (Timer.anInt887 != 0 || Cache.mouseRecorder.anInt561 >= 40) {
                        FrameBuffer.outgoingBuffer.putFrame(133);
                        int i_10_ = 0;
                        FrameBuffer.outgoingBuffer.putByte(0);
                        int i_11_ = (FrameBuffer.outgoingBuffer.offset);
                        for (int i_12_ = 0; Cache.mouseRecorder.anInt561 > i_12_; i_12_++) {
                            if (-i_11_ + (FrameBuffer.outgoingBuffer.offset) >= 240) {
                                break;
                            }
                            i_10_++;
                            int i_13_ = Cache.mouseRecorder.anIntArray571[i_12_];
                            if (i_13_ < 0) {
                                i_13_ = 0;
                            } else if (i_13_ > 764) {
                                i_13_ = 764;
                            }
                            int i_14_ = Cache.mouseRecorder.anIntArray562[i_12_];
                            if (i_14_ < 0) {
                                i_14_ = 0;
                            } else if (i_14_ > 502) {
                                i_14_ = 502;
                            }
                            int i_15_ = i_13_ + i_14_ * 765;
                            if (Cache.mouseRecorder.anIntArray562[i_12_] == -1
                                    && (Cache.mouseRecorder.anIntArray571[i_12_]
                                    == -1)) {
                                i_14_ = -1;
                                i_13_ = -1;
                                i_15_ = 524287;
                            }
                            if (Class39_Sub5_Sub9.anInt1807 == i_13_
                                    && i_14_ == FrameBuffer.anInt2159) {
                                if (Timer.anInt882 < 2047) {
                                    Timer.anInt882++;
                                }
                            } else {
                                int i_16_ = i_13_ - Class39_Sub5_Sub9.anInt1807;
                                Class39_Sub5_Sub9.anInt1807 = i_13_;
                                int i_17_ = -FrameBuffer.anInt2159 + i_14_;
                                FrameBuffer.anInt2159 = i_14_;
                                if (Timer.anInt882 < 8 && i_16_ >= -32
                                        && i_16_ <= 31 && i_17_ >= -32
                                        && i_17_ <= 31) {
                                    i_16_ += 32;
                                    i_17_ += 32;
                                    FrameBuffer.outgoingBuffer.putWord(((Timer.anInt882 << 12)
                                            - (-(i_16_ << 6) - i_17_)));
                                    Timer.anInt882 = 0;
                                } else if (Timer.anInt882 < 8) {
                                    FrameBuffer.outgoingBuffer.putTri(8388608 + (Timer.anInt882
                                            << 19) + i_15_);
                                    Timer.anInt882 = 0;
                                } else {
                                    FrameBuffer.outgoingBuffer.putDword(((Timer.anInt882 << 19) - 1073741824
                                            + i_15_));
                                    Timer.anInt882 = 0;
                                }
                            }
                        }
                        FrameBuffer.outgoingBuffer.putByteLength((FrameBuffer.outgoingBuffer.offset) - i_11_);
                        if (Cache.mouseRecorder.anInt561 > i_10_) {
                            Cache.mouseRecorder.anInt561 -= i_10_;
                            for (int i_18_ = 0;
                                    Cache.mouseRecorder.anInt561 > i_18_;
                                    i_18_++) {
                                Cache.mouseRecorder.anIntArray571[i_18_] = (Cache.mouseRecorder.anIntArray571[i_10_ + i_18_]);
                                Cache.mouseRecorder.anIntArray562[i_18_] = (Cache.mouseRecorder.anIntArray562[i_10_ + i_18_]);
                            }
                        } else {
                            Cache.mouseRecorder.anInt561 = 0;
                        }
                    }
                }
                if (Timer.anInt887 != 0) {
                    long l = ((-Class30.aLong536 + StillGraphic.aLong2331) / 50L);
                    Class30.aLong536 = StillGraphic.aLong2331;
                    if (l > 4095L) {
                        l = 4095L;
                    }
                    int i_19_ = Bzip2Block.mouseClickPositionY;
                    int i_20_ = Class39_Sub4.mouseClickPositionX;
                    if (i_20_ >= 0) {
                        if (i_20_ > 764) {
                            i_20_ = 764;
                        }
                    } else {
                        i_20_ = 0;
                    }
                    if (i_19_ < 0) {
                        i_19_ = 0;
                    } else if (i_19_ > 502) {
                        i_19_ = 502;
                    }
                    int i_21_ = i_20_ + i_19_ * 765;
                    int i_22_ = 0;
                    if (Timer.anInt887 == 2) {
                        i_22_ = 1;
                    }
                    int i_23_ = (int) l;
                    FrameBuffer.outgoingBuffer.putFrame(162);
                    FrameBuffer.outgoingBuffer.putDwordB(i_21_ + (i_22_ << 19) + (i_23_ << 20));
                }
                if (Class13.activeKeys[96]
                        || Class13.activeKeys[97]
                        || Class13.activeKeys[98]
                        || Class13.activeKeys[99]) {
                    Deque.aBoolean914 = true;
                }
                if (Class39_Sub4.anInt1336 > 0) {
                    Class39_Sub4.anInt1336--;
                }
                if (Deque.aBoolean914 && Class39_Sub4.anInt1336 <= 0) {
                    Class39_Sub4.anInt1336 = 20;
                    Deque.aBoolean914 = false;
                    FrameBuffer.outgoingBuffer.putFrame(66);
                    FrameBuffer.outgoingBuffer.putWord128(JSocket.anInt301);
                    FrameBuffer.outgoingBuffer.putWord(anInt605);
                }
                if (!Class43.aBoolean802 != true
                        && !JString.aBoolean1232 == true) {
                    JString.aBoolean1232 = true;
                    FrameBuffer.outgoingBuffer.putFrame(207);
                    ArchiveRequest.anInt1408++;
                    FrameBuffer.outgoingBuffer.putByte(1);
                }
                if (!Class43.aBoolean802 == true
                        && JString.aBoolean1232 == true) {
                    JString.aBoolean1232 = false;
                    FrameBuffer.outgoingBuffer.putFrame(207);
                    ArchiveRequest.anInt1408++;
                    FrameBuffer.outgoingBuffer.putByte(0);
                }
                Class23.method271();
                if (Client.state == 30 || Client.state == 35) {
                    VarbitDefinition.method591((byte) 92);
                    ClientScript.method477((byte) -103);
                    Class39_Sub5_Sub11.anInt1827++;
                    if (Class39_Sub5_Sub11.anInt1827 > 750) {
                        Class37.method354((byte) 48);
                    } else {
                        Class30.method318(0);
                        JString.method91((byte) -126);
                        AudioHandler.method1049((byte) 108);
                        PlayerApperance.anInt856++;
                        if (Class4.crossMode != 0) {
                            Class26.crossFrameNum += 20;
                            if (Class26.crossFrameNum >= 400) {
                                Class4.crossMode = 0;
                            }
                        }
                        if (Class25.anInt459 != 0) {
                            GroundItem.anInt2242++;
                            if (GroundItem.anInt2242 >= 15) {
                                if (Class25.anInt459 == 2) {
                                    Class39_Sub14.updateTab = true;
                                }
                                if (Class25.anInt459 == 3) {
                                    Class14.aBoolean245 = true;
                                }
                                Class25.anInt459 = 0;
                            }
                        }
                        if (Class30.anInt534 != 0) {
                            Widget.anInt2031++;
                            if ((ISAAC.mousePositionX > ClientScript.itemClickPositionX + 5)
                                    || (ISAAC.mousePositionX
                                    < ClientScript.itemClickPositionX - 5)
                                    || (OndemandRequest.itemClickPositionY + 5
                                    < Class33.mousePositionY)
                                    || (Class33.mousePositionY
                                    < OndemandRequest.itemClickPositionY - 5)) {
                                Cache.aBoolean121 = true;
                            }
                            if (Class30.anInt541 == 0) {
                                if (Class30.anInt534 == 3) {
                                    Class14.aBoolean245 = true;
                                }
                                if (Class30.anInt534 == 2) {
                                    Class39_Sub14.updateTab = true;
                                }
                                Class30.anInt534 = 0;
                                if (Cache.aBoolean121 && Widget.anInt2031 >= 5) {
                                    Class41.anInt768 = -1;
                                    JString.method95(33);
                                    if (ArchiveWorker.swapWidgetHash == Class41.anInt768 && (Class14.swapSlotTo != ArchiveRequest.swapSlotFrom)) {
                                        Widget widget = Class37.getWidget((ArchiveWorker.swapWidgetHash));
                                        int type = 0;
                                        if (Client.anInt1274 == 1 && (widget.anInt2078  == 206)) {
                                            type = 1;
                                        }
                                        if ((widget.itemIds[Class14.swapSlotTo]) <= 0) {
                                            type = 0;
                                        }
                                        if (!widget.replaceSwap()) {
                                            if (type != 1) {
                                                widget.swapItem(Class14.swapSlotTo, ArchiveRequest.swapSlotFrom);
                                            } else {
                                                int slotFrom = ArchiveRequest.swapSlotFrom;
                                                int slotTo = Class14.swapSlotTo;
                                                while (slotTo != slotFrom) {
                                                    if (slotTo < slotFrom) {
                                                        widget.swapItem(slotFrom - 1, slotFrom);
                                                        slotFrom--;
                                                    } else if (slotFrom < slotTo) {
                                                        widget.swapItem(slotFrom + 1, slotFrom);
                                                        slotFrom++;
                                                    }
                                                }
                                            }
                                        } else {
                                            int slotFrom = ArchiveRequest.swapSlotFrom;
                                            int slotTo = Class14.swapSlotTo;
                                            widget.itemIds[slotTo] = (widget.itemIds[slotFrom]);
                                            widget.itemAmounts[slotTo] = (widget.itemAmounts[slotFrom]);
                                            widget.itemIds[slotFrom] = -1;
                                            widget.itemAmounts[slotFrom] = 0;
                                        }
                                        FrameBuffer.outgoingBuffer.putFrame(190);
                                        FrameBuffer.outgoingBuffer.putWord(ArchiveRequest.swapSlotFrom);
                                        FrameBuffer.outgoingBuffer.putDword(ArchiveWorker.swapWidgetHash);
                                        FrameBuffer.outgoingBuffer.putByte(type);
                                        FrameBuffer.outgoingBuffer.putWord(Class14.swapSlotTo);
                                    }
                                } else if ((PlayerApperance.anInt868 != 1
                                        && !(Class33.method327((Class39_Sub5_Sub11.actionOffset
                                        - 1),
                                        (byte) -128)))
                                        || (Class39_Sub5_Sub11.actionOffset
                                        <= 2)) {
                                    if (Class39_Sub5_Sub11.actionOffset > 0) {
                                        ScriptState.handleMenuAction((Class39_Sub5_Sub11.actionOffset) - 1,
                                                1);
                                    }
                                } else {
                                    Class39_Sub5_Sub9.method607(701);
                                }
                                Timer.anInt887 = 0;
                                GroundItem.anInt2242 = 10;
                            }
                        }
                        int i_29_ = 34;
                        if (SubNode.screenWidgetId != -1) {
                            AudioHandler.method1050(503, SubNode.screenWidgetId, 0,
                                    0, -72, i_29_, 765);
                            if (ClientScript.screenOverlayId != -1) {
                                AudioHandler.method1050(503,
                                        ClientScript.screenOverlayId,
                                        0, 0, 95, i_29_, 765);
                            }
                        } else {
                            if (StillObject.viewOverlayId == -1) {
                                if (Class26.viewWidgetId != -1) {
                                    AudioHandler.method1050(338, Class26.viewWidgetId,
                                            4, 4, -109, i_29_, 516);
                                }
                            } else {
                                AudioHandler.method1050(338,
                                        StillObject.viewOverlayId, 4,
                                        4, -108, i_29_, 516);
                            }
                            if (StillGraphic.tabOverlayId != -1) {
                                AudioHandler.method1050(466,
                                        (StillGraphic.tabOverlayId),
                                        553, 205, 89, i_29_, 743);
                            } else if ((Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId])
                                    != -1) {
                                AudioHandler.method1050(466,
                                        (Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId]),
                                        553, 205, -121, i_29_, 743);
                            }
                            if (Class39_Sub5_Sub14.chatboxOverlayId == -1) {
                                if (ISAAC.chatboxWidgetId != -1) {
                                    AudioHandler.method1050(453, ISAAC.chatboxWidgetId,
                                            17, 357, 79, i_29_,
                                            496);
                                }
                            } else {
                                AudioHandler.method1050(453,
                                        (Class39_Sub5_Sub14.chatboxOverlayId),
                                        17, 357, -115, i_29_, 496);
                            }
                        }
                        if (SubNode.screenWidgetId == -1) {
                            if (StillObject.viewOverlayId != -1) {
                                AudioHandler.method1050(338,
                                        StillObject.viewOverlayId, 4,
                                        4, 68, i_29_ ^ 0xffffffff,
                                        516);
                            } else if (Class26.viewWidgetId != -1) {
                                AudioHandler.method1050(338, Class26.viewWidgetId, 4, 4,
                                        122, i_29_ ^ 0xffffffff,
                                        516);
                            }
                            if (StillGraphic.tabOverlayId != -1) {
                                AudioHandler.method1050(466,
                                        (StillGraphic.tabOverlayId),
                                        553, 205, 100,
                                        i_29_ ^ 0xffffffff, 743);
                            } else if ((Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId])
                                    != -1) {
                                AudioHandler.method1050(466,
                                        (Class39_Sub5_Sub14.tabWidgetIds[Node.currentTabId]),
                                        553, 205, 105,
                                        i_29_ ^ 0xffffffff, 743);
                            }
                            if (Class39_Sub5_Sub14.chatboxOverlayId != -1) {
                                AudioHandler.method1050(453,
                                        (Class39_Sub5_Sub14.chatboxOverlayId),
                                        17, 357, -115,
                                        i_29_ ^ 0xffffffff, 496);
                            } else if (ISAAC.chatboxWidgetId != -1) {
                                AudioHandler.method1050(453, ISAAC.chatboxWidgetId, 17,
                                        357, 125,
                                        i_29_ ^ 0xffffffff, 496);
                            }
                        } else {
                            AudioHandler.method1050(503, SubNode.screenWidgetId, 0,
                                    0, -81, i_29_ ^ 0xffffffff,
                                    765);
                            if (ClientScript.screenOverlayId != -1) {
                                AudioHandler.method1050(503,
                                        ClientScript.screenOverlayId,
                                        0, 0, 72,
                                        i_29_ ^ 0xffffffff, 765);
                            }
                        }
                        AudioHandler.method1046((byte) 22);
                        if (World.anInt682 != -1) {
                            int i_30_ = World.anInt677;
                            int i_31_ = World.anInt682;
                            boolean bool = (Class26.sendWalkingRoute(0, i_30_, 0, 0, 0, 0, true, 0,
                                    (Cache.localPlayer.queueX[0]),
                                    (Cache.localPlayer.queueY[0]),
                                    i_31_));
                            if (bool) {
                                Class4.crossMode = 1;
                                Class26.crossFrameNum = 0;
                                Class62_Sub2.crossPositionY = Bzip2Block.mouseClickPositionY;
                                AbstractMidiHandler.crossPositionX = Class39_Sub4.mouseClickPositionX;
                            }
                            World.anInt682 = -1;
                        }
                        if (Timer.anInt887 == 1
                                && TextConstants.aClass3_1714 != null) {
                            Timer.anInt887 = 0;
                            TextConstants.aClass3_1714 = null;
                            Class14.aBoolean245 = true;
                        }
                        Node.method411(113);
                        if (SubNode.screenWidgetId == -1) {
                            Class39_Sub12.method872(50);
                            Class47.method948(-124);
                            Class39_Sub5_Sub5.method569((byte) -123);
                        }
                        if (Class30.anInt541 == 1 || Timer.anInt887 == 1) {
                            MsTimer.anInt1547++;
                        }
                        if (VarpDefinition.anInt1982 == -1
                                && Class39_Sub10.anInt1440 == -1
                                && Class39_Sub5_Sub6.anInt1760 == -1) {
                            if (FrameBuffer.anInt2157 > 0) {
                                FrameBuffer.anInt2157--;
                            }
                        } else if (Class30.anInt548
                                > FrameBuffer.anInt2157) {
                            FrameBuffer.anInt2157++;
                            if (FrameBuffer.anInt2157
                                    == Class30.anInt548) {
                                if (Class39_Sub10.anInt1440 != -1) {
                                    Class39_Sub14.updateTab = true;
                                }
                                if (VarpDefinition.anInt1982 != -1) {
                                    Class14.aBoolean245 = true;
                                }
                            }
                        }
                        JString.method62(126);
                        if (TraversalMap.isCameraMoving) {
                            Projectile.updateCameraMovement(2048);
                        }
                        for (int i_32_ = 0; i_32_ < 5; i_32_++) {
                            Class4.anIntArray75[i_32_]++;
                        }
                        Buffer.method814(103);
                        int i_33_ = Class32.method326(-2);
                        int i_34_ = Class39_Sub5_Sub11.method699((byte) 49);
                        if (i_33_ > 4500 && i_34_ > 4500) {
                            ClientScript.anInt1692 = 250;
                            StillGraphic.method535((byte) 106, 4000);
                            FrameBuffer.outgoingBuffer.putFrame(192);
                        }
                        Class41.anInt780++;
                        Class39_Sub4.anInt1335++;
                        FileLoader.anInt1290++;
                        if (FileLoader.anInt1290 > 500) {
                            FileLoader.anInt1290 = 0;
                            int i_35_ = (int) (Math.random() * 8.0);
                            if ((i_35_ & 0x1) == 1) {
                                JRuntimeException.anInt1216 += Wall.anInt643;
                            }
                            if ((i_35_ & 0x4) == 4) {
                                SubNode.anInt1344 += ArchiveWorker.anInt1211;
                            }
                            if ((i_35_ & 0x2) == 2) {
                                Buffer.anInt1361 += Class39_Sub5_Sub11.anInt1828;
                            }
                        }
                        if (Class39_Sub4.anInt1335 > 500) {
                            Class39_Sub4.anInt1335 = 0;
                            int i_36_ = (int) (Math.random() * 8.0);
                            if ((i_36_ & 0x2) == 2) {
                                ClassCheckRequest.anInt1386 += Class37.anInt662;
                            }
                            if ((i_36_ & 0x1) == 1) {
                                ArchiveRequest.anInt1401 += MsTimer.anInt1550;
                            }
                        }
                        if (ClassCheckRequest.anInt1386 < -20) {
                            Class37.anInt662 = 1;
                        }
                        if (ArchiveRequest.anInt1401 < -60) {
                            MsTimer.anInt1550 = 2;
                        }
                        if (JRuntimeException.anInt1216 < -50) {
                            Wall.anInt643 = 2;
                        }
                        if (Buffer.anInt1361 < -55) {
                            Class39_Sub5_Sub11.anInt1828 = 2;
                        }
                        if (Buffer.anInt1361 > 55) {
                            Class39_Sub5_Sub11.anInt1828 = -2;
                        }
                        if (ArchiveRequest.anInt1401 > 60) {
                            MsTimer.anInt1550 = -2;
                        }
                        if (SubNode.anInt1344 < -40) {
                            ArchiveWorker.anInt1211 = 1;
                        }
                        if (ClassCheckRequest.anInt1386 > 10) {
                            Class37.anInt662 = -1;
                        }
                        if (SubNode.anInt1344 > 40) {
                            ArchiveWorker.anInt1211 = -1;
                        }
                        if (JRuntimeException.anInt1216 > 50) {
                            Wall.anInt643 = -2;
                        }
                        if (Class41.anInt780 > 50) {
                            anInt604++;
                            FrameBuffer.outgoingBuffer.putFrame(86);
                        }
                        do {
                            try {
                                if (Class37.gameSocket == null || ((FrameBuffer.outgoingBuffer.offset) <= 0)) {
                                    break;
                                }
                                Class37.gameSocket.write((FrameBuffer.outgoingBuffer.payload), 0, (FrameBuffer.outgoingBuffer.offset));
                                Class41.anInt780 = 0;
                                FrameBuffer.outgoingBuffer.offset = 0;
                            } catch (java.io.IOException ioexception) {
                                Class37.method354((byte) 89);
                                break;
                            }
                            break;
                        } while (false);
                    }
                }
            }
        }
    }

    public abstract void method337(Component component, byte i);

    public abstract int method338(int i);

    public static void method339(AbstractFileLoader class9, AbstractFileLoader class9_37_) {
        Class39_Sub10.aClass9_1424 = class9;
        Buffer.aClass9_1362 = class9_37_;
        JImage.anInt1584 = Buffer.aClass9_1362.getAmountChildren(3);
    }

    public static void drawLoadingScreen(Color color, JString message, int percent) {
        try {
            Graphics graphics = Class41.canvas.getGraphics();
            if (BufferedFile.aFont351 == null) {
                BufferedFile.aFont351 = new Font("Helvetica", 1, 13);
                Class26.aFontMetrics491 = Class41.canvas.getFontMetrics(BufferedFile.aFont351);
            }
            if (ClientScript.aBoolean1690) {
                ClientScript.aBoolean1690 = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, ISAAC.width, Deque.height);
            }
            if (color == null) {
                color = new Color(140, 17, 17);
            }
            try {
                if (StillObject.anImage1464 == null) {
                    StillObject.anImage1464 = Class41.canvas.createImage(304, 34);
                }
                Graphics graphics_39_ = StillObject.anImage1464.getGraphics();
                graphics_39_.setColor(color);
                graphics_39_.drawRect(0, 0, 303, 33);
                graphics_39_.fillRect(2, 2, percent * 3, 30);
                graphics_39_.setColor(Color.black);
                graphics_39_.drawRect(1, 1, 301, 31);
                graphics_39_.fillRect(2 + percent * 3, 2, -(percent * 3) + 300,
                        30);
                graphics_39_.setFont(BufferedFile.aFont351);
                graphics_39_.setColor(Color.white);
                message.draw(graphics_39_, (-message.getStringWidth(Class26.aFontMetrics491) + 304) / 2, 22);
                graphics.drawImage(StillObject.anImage1464,
                        ISAAC.width / 2 - 152,
                        Deque.height / 2 - 18, null);
            } catch (Exception exception) {
                int i_40_ = ISAAC.width / 2 - 152;
                int i_41_ = Deque.height / 2 - 18;
                graphics.setColor(color);
                graphics.drawRect(i_40_, i_41_, 303, 33);
                graphics.fillRect(i_40_ + 2, i_41_ + 2, percent * 3, 30);
                graphics.setColor(Color.black);
                graphics.drawRect(i_40_ + 1, i_41_ + 1, 301, 31);
                graphics.fillRect(percent * 3 + (i_40_ + 2), i_41_ + 2,
                        -(percent * 3) + 300, 30);
                graphics.setFont(BufferedFile.aFont351);
                graphics.setColor(Color.white);
                message.draw(graphics, (i_40_ + (-message.getStringWidth(Class26.aFontMetrics491) + 304) / 2), i_41_ + 22);
            }
        } catch (Exception exception) {
            Class41.canvas.repaint();
        }
    }

    public static void method341(boolean bool) {
        Class4.aClass7_70.clear();
        VarpDefinition.aClass7_1975.clear();
    }

    public static int and(int i, int i_42_) {
        return i & i_42_;
    }

    static {
        anInt605 = 0;
        aClass3_609 = JString.create("mapback");
        duelRequestJstr = JString.create(":duelreq:");
        aClass3_613 = JString.create("slide:");
        aClass3_612 = JString.create("Report abuse");
        aClass3_615 = aClass3_613;
        aClass3_608 = aClass3_612;
    }
}
