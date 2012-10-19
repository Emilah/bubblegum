package com.jagex.graphics;

/* Class57_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import com.jagex.utils.ArrayUtils;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import unpackaged.Class1;
import com.jagex.world.Barrier;
import unpackaged.Class14;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class25;
import unpackaged.Class30;
import unpackaged.Class39_Sub12;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class43;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class68;
import com.jagex.Client;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.world.entities.GroundItem;
import com.jagex.utils.Huffman;
import com.jagex.awt.listeners.JKeyListener;
import com.jagex.awt.listeners.JMouseListener;
import com.jagex.script.ScriptState;

public class JImage extends AbstractImage
        implements ImageProducer, ImageObserver {

    public ImageConsumer anImageConsumer1571;
    public static JString aClass3_1572 = JString.create("On");
    public static int lastHeight;
    public static JString aClass3_1574;
    public ColorModel colorModel;
    public static AbstractImage aClass57_1576;
    public static JString aClass3_1577;
    public static JString aClass3_1578;
    public static JString aClass3_1579 = JString.create("@or3@");
    public static JString aClass3_1580;
    public static Buffer updateTableBuffer;
    public static JString aClass3_1582;
    public static JString aClass3_1583;
    public static int anInt1584;
    public static JString aClass3_1585;
    public static int anInt1586;

    public static int method1011(int i, int i_0_, int i_1_, byte i_2_) {
        int i_3_ = -i_0_ + 256;
        return (((i_0_ * (i_1_ & 0xff00ff) + (i & 0xff00ff) * i_3_ & ~0xff00ff)
                + (i_0_ * (i_1_ & 0xff00) + i_3_ * (i & 0xff00) & 0xff0000))
                >> 8);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
        /* empty */
    }

    public void startProduction(ImageConsumer imageconsumer) {
        addConsumer(imageconsumer);
    }

    public static void method1012(int i) {
        if (JMouseListener.anInt787 == 2) {
            Class4.method104(Class66.anInt1158 * 2,
                    (Class39_Sub5_Sub18.anInt2124
                    + (-JKeyListener.anInt618 + Class25.anInt471 << 7)),
                    -119,
                    ((-Class65.anInt1145 + JString.anInt1229 << 7)
                    + Class43.anInt823));
            if (Class14.anInt224 > -1 && Class2.logicCycle % 20 < 10) {
                Class20.aClass39_Sub5_Sub10_Sub3Array392[0].method670(Class14.anInt224 - 12, Class53.anInt962 - 28);
            }
        }
    }

    public boolean imageUpdate(Image image, int i, int i_4_, int i_5_,
            int i_6_, int i_7_) {
        return true;
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer) {
        anImageConsumer1571 = imageconsumer;
        imageconsumer.setDimensions(width, height);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(colorModel);
        imageconsumer.setHints(14);
    }

    public static void method1014(int i, byte i_14_) {
        if (i_14_ != 99) {
            method1012(-85);
        }
        if (TextureLoaderImpl.audioHandler != null) {
            if (ArchiveRequest.anInt1415 != 0) {
                if (Class39_Sub5_Sub6.aByteArray1768 != null) {
                    Class39_Sub5_Sub18.anInt2120 = i;
                }
            } else if (GroundItem.anInt2239 >= 0) {
                GroundItem.anInt2239 = i;
                TextureLoaderImpl.audioHandler.method1055(0, i, i_14_ - 99);
            }
        }
    }

    public static IndexedColorSprite[] method1015(int i, int i_15_, int i_16_, AbstractFileLoader class9) {
        if (!Client.decodeSprite(class9, i_15_, i_16_)) {
            return null;
        }
        return Barrier.method179((byte) 68);
    }

    public synchronized void method1016(byte i) {
        if (i != -66) {
            anImageConsumer1571 = null;
        }
        if (anImageConsumer1571 != null) {
            anImageConsumer1571.setPixels(0, 0, width, height,
                    colorModel, buffer, 0,
                    width);
            anImageConsumer1571.imageComplete(2);
        }
    }

    public static void method1017(byte i) {
        Class30.anInt544 = 0;
        Huffman.frameSize = 0;
        ScriptState.anInt448 = -1;
        Class39_Sub12.aBoolean1493 = false;
        Class39_Sub5_Sub11.actionOffset = 0;
        if (i == 74) {
            FileLoader.anInt1283 = -1;
            FrameBuffer.outgoingBuffer.offset = 0;
            Class39_Sub5_Sub7.minimapState = 0;
            Class63.anInt1117 = -1;
            Class4.frameId = -1;
            Class39_Sub5_Sub11.anInt1827 = 0;
            ClassCheckRequest.systemUpdateTime = 0;
            Class39_Sub5_Sub11.incomingBuffer.offset = 0;
            for (int i_17_ = 0;
                    Class14.players.length > i_17_;
                    i_17_++) {
                if (Class14.players[i_17_]
                        != null) {
                    Class14.players[i_17_].anInt2260 = -1;
                }
            }
            for (int i_18_ = 0;
                    ((GroundItem.npcs).length
                    > i_18_);
                    i_18_++) {
                if ((GroundItem.npcs[i_18_])
                        != null) {
                    GroundItem.npcs[i_18_].anInt2260 = -1;
                }
            }
            ArchiveWorker.method1121(i ^ ~0x3b);
            Client.setState(30);
        }
    }

    public void setComponent(Component component, int i, int i_19_) {
        height = i_19_;
        buffer = new int[i * i_19_ + 1];
        width = i;
        colorModel = new DirectColorModel(32, 16711680, 65280, 255);
        image = component.createImage(this);
        method1016((byte) -66);
        component.prepareImage(image, this);
        method1016((byte) -66);
        component.prepareImage(image, this);
        method1016((byte) -66);
        component.prepareImage(image, this);
        this.method1006(10);

    }

    public static int getItemAmount(int id, int slot) {
        ItemContainer container = ((ItemContainer) Class14.itemContainerCache.get((long) id));
        if (container == null) {
            return 0;
        }
        if (slot < 0 || container.itemAmts.length <= slot) {
            return 0;
        }
        return container.itemAmts[slot];
    }

    public void draw(Graphics graphics, int i_23_, int i_24_) {
        method1016((byte) -66);
        graphics.drawImage(image, i_23_, i_24_, this);
    }

    public static void parsePopulateUpdate(byte i) {
        while (Class39_Sub5_Sub11.incomingBuffer.getRemainingBits(Huffman.frameSize)
                >= 11) {
            int id = Class39_Sub5_Sub11.incomingBuffer.getBits(11);
            if (id == 2047) {
                break;
            }
            boolean bool = false;
            if (Class14.players[id] == null) {
                bool = true;
                Class14.players[id] = new Player();
                if (ISAAC.appearanceBuffers[id] != null) {
                    Class14.players[id].parseAppearance(ISAAC.appearanceBuffers[id]);
                }
            }
            Class1.anIntArray40[TraversalMap.anInt515++] = id;
            Player player = Class14.players[id];
            player.anInt2290 = Class2.logicCycle;
            int i_26_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
            if (i_26_ == 1) {
                ArchiveRequest.anIntArray1400[anInt1586++] = id;
            }
            int deltaX = Class39_Sub5_Sub11.incomingBuffer.getBits(5);
            if (deltaX > 15) {
                deltaX -= 32;
            }
            int i_28_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
            int i_29_ = (Client.anIntArray1276[Class39_Sub5_Sub11.incomingBuffer.getBits(3)]);
            if (bool) {
                player.anInt2251 = i_29_;
            }
            int deltaY = Class39_Sub5_Sub11.incomingBuffer.getBits(5);
            if (deltaY > 15) {
                deltaY -= 32;
            }
            player.setLocation(deltaY + (Cache.localPlayer.queueX[0]),(Cache.localPlayer.queueY[0]
                    + deltaX),
                    i_28_ == 1);
        }
        Class39_Sub5_Sub11.incomingBuffer.finishBitAccess();
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
        if (imageconsumer != anImageConsumer1571) {
            return false;
        }
        return true;
    }

    public static void method1020(boolean bool) {
        aClass3_1579 = null;
        aClass3_1572 = null;
        aClass3_1578 = null;
        aClass3_1574 = null;
        aClass57_1576 = null;
        updateTableBuffer = null;
        aClass3_1582 = null;
        aClass3_1583 = null;
        aClass3_1580 = null;
        aClass3_1585 = null;
        aClass3_1577 = null;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer) {
        if (anImageConsumer1571 == imageconsumer) {
            anImageConsumer1571 = null;
        }
    }

    static {
        aClass3_1574 = aClass3_1572;
        aClass3_1577 = (JString.create("Moderator)2Option: Spieler f-Ur 48 Stunden stumm schalten: <ON>"));
        aClass3_1578 = JString.create("Privater Chat");
        aClass3_1582 = JString.create("@yel@*V");
        aClass3_1583 = JString.create("Fertigkeit)2");
        lastHeight = 0;
        aClass3_1580 = JString.create("flash1:");
        anInt1586 = 0;
        aClass3_1585 = aClass3_1580;
    }
}
