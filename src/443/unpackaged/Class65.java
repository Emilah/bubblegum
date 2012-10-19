package unpackaged;

/* Class65 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.world.entities.StillObject;
import com.jagex.utils.JRuntimeException;
import com.jagex.config.Widget;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.ArchiveWorker;
import com.jagex.sign.Signlink;
import com.jagex.config.ItemDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.awt.listeners.MouseListenerImpl;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.SubNode;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.od.OndemandHandler;
import com.jagex.utils.Cache;
import java.awt.Component;

public class Class65 {

    public static int[] anIntArray1132;
    public static JString aClass3_1133;
    public static JString aClass3_1134;
    public static int anInt1135;
    public static Widget aClass39_Sub5_Sub17_1136;
    public static int anInt1137 = 0;
    public static JString aClass3_1139;
    public static JString aClass3_1140;
    public static int anInt1141;
    public static JString aClass3_1142;
    public static int anInt1143;
    public static int anInt1145;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1146;
    public static int anInt1147;

    public static void updateGroundItems(int x, int y) {
        Deque deque = Class20.groundItems[NameTable.height][x][y];
        if (deque == null) {
            Class44.world.method373(NameTable.height, x, y);
        } else {
            int i_2_ = -99999999;
            GroundItem class39_sub5_sub4_sub3 = null;
            for (GroundItem groundItem = (GroundItem) deque.getFirst();
                    groundItem != null;
                    groundItem = ((GroundItem) deque.getNext())) {
                ItemDefinition class39_sub5_sub1 = Class26.getItemDefinition(groundItem.itemId);
                int i_4_ = class39_sub5_sub1.anInt1686;
                if (class39_sub5_sub1.anInt1662 == 1) {
                    i_4_ *= groundItem.itemAmount + 1;
                }
                if (i_4_ > i_2_) {
                    class39_sub5_sub4_sub3 = groundItem;
                    i_2_ = i_4_;
                }
            }
            if (class39_sub5_sub4_sub3 == null) {
                Class44.world.method373(NameTable.height, x, y);
            } else {
                deque.offerFirst(class39_sub5_sub4_sub3);
                GroundItem class39_sub5_sub4_sub3_5_ = null;
                int i_6_ = x - (-(y << 7) - 1610612736);
                GroundItem class39_sub5_sub4_sub3_7_ = (GroundItem) deque.getFirst();
                GroundItem class39_sub5_sub4_sub3_8_ = null;
                for (/**/; class39_sub5_sub4_sub3_7_ != null;
                        class39_sub5_sub4_sub3_7_ = ((GroundItem) deque.getNext())) {
                    if (class39_sub5_sub4_sub3_7_.itemId
                            != class39_sub5_sub4_sub3.itemId) {
                        if (class39_sub5_sub4_sub3_5_ == null) {
                            class39_sub5_sub4_sub3_5_ = class39_sub5_sub4_sub3_7_;
                        }
                        if ((class39_sub5_sub4_sub3_7_.itemId
                                != class39_sub5_sub4_sub3_5_.itemId)
                                && class39_sub5_sub4_sub3_8_ == null) {
                            class39_sub5_sub4_sub3_8_ = class39_sub5_sub4_sub3_7_;
                        }
                    }
                }
                Class44.world.method391(NameTable.height, x, y,
                        Class14.method212(x * 128 + 64, y * 128 + 64, NameTable.height),
                        class39_sub5_sub4_sub3, i_6_, class39_sub5_sub4_sub3_5_,
                        class39_sub5_sub4_sub3_8_);
            }
        }
    }

    public static void method1093(int i) {
        anIntArray1132 = null;
        aClass3_1134 = null;
        aClass3_1140 = null;
        aClass3_1139 = null;
        aClass3_1142 = null;
        aClass39_Sub5_Sub17_1136 = null;
        aClass39_Sub5_Sub10_Sub4_1146 = null;
        aClass3_1133 = null;
    }

    public static int[] method1094(int i,
            Widget class39_sub5_sub17) {
        int i_9_ = class39_sub5_sub17.id >> 16;
        if (!JSocket.loadWidget(i_9_)) {
            return null;
        }
        int i_10_ = class39_sub5_sub17.displayOffsetX;
        int i_11_ = class39_sub5_sub17.displayOffsetY;
        Widget class39_sub5_sub17_12_;
        for (int i_13_ = class39_sub5_sub17.anInt2050; i_13_ != -1;
                i_13_ = class39_sub5_sub17_12_.anInt2050) {
            class39_sub5_sub17_12_ = (AbstractMidiHandler.widgets[i_9_][i_13_ & 0xffff]);
            i_11_ += (class39_sub5_sub17_12_.displayOffsetY
                    - class39_sub5_sub17_12_.scrollY);
            i_10_ += (-class39_sub5_sub17_12_.scrollX
                    + class39_sub5_sub17_12_.displayOffsetX);
        }
        int[] is = new int[2];
        is[1] = i_11_;
        is[0] = i_10_;
        return is;
    }

    public static void method1095(int i) {
        synchronized (Class4.archiveWorkerLock) {
            if (Class23.archiveWorkerKeepAlive == 0) {
                Class39_Sub5_Sub9.fileSignlink.requestThread(new ArchiveWorker(), 5);
            }
            Class23.archiveWorkerKeepAlive = 600;
        }
    }

    public static Class39_Sub1_Sub1 method1096(boolean bool, Signlink class21,
            Component component, int i,
            int i_14_) {
        Class15.method214(i_14_, component, bool, class21, 0);
        Class39_Sub1_Sub1 class39_sub1_sub1 = new Class39_Sub1_Sub1();
        Class13.method191((byte) 121, class39_sub1_sub1);
        return class39_sub1_sub1;
    }

    public static void addIgnore(long encodedUsername) {
        if (encodedUsername != 0L) {
            if (Class15.amountIgnores >= 100) {
                MouseListenerImpl.printMessage(0, Class66.blankString, Class23.ignoreListFullJstr);
            } else {
                JString class3 = Deque.decodeBase37(encodedUsername).formatUsername();
                for (int i_15_ = 0; Class15.amountIgnores > i_15_; i_15_++) {
                    if (encodedUsername == Class39_Sub5_Sub9.ignoreUsernames[i_15_]) {
                        MouseListenerImpl.printMessage(0, Class66.blankString, (Class39_Sub5_Sub11.join((new JString[]{class3, SubNode.aClass3_1343}))));
                        return;
                    }
                }
                for (int i_16_ = 0; i_16_ < Class4.anInt62; i_16_++) {
                    if (encodedUsername == JApplet.aLongArray2[i_16_]) {
                        MouseListenerImpl.printMessage(0,Class66.blankString, (Class39_Sub5_Sub11.join((new JString[]{StillObject.aClass3_1467, class3, (JRuntimeException.aClass3_1214)}))));
                        return;
                    }
                }
                if (!class3.isEqual((Cache.localPlayer.aClass3_2521))) {
                    Class39_Sub5_Sub9.ignoreUsernames[Class15.amountIgnores++] = encodedUsername;
                    Class39_Sub14.updateTab = true;
                    FrameBuffer.outgoingBuffer.putFrame(198);
                    FrameBuffer.outgoingBuffer.putQword(encodedUsername);
                }
            }
        }
    }

    public static Class39_Sub5_Sub5 method1098(byte i, int i_17_) {
        Class39_Sub5_Sub5 class39_sub5_sub5 = ((Class39_Sub5_Sub5) FrameBuffer.aClass7_2158.get((long) i_17_));
        if (class39_sub5_sub5 != null) {
            return class39_sub5_sub5;
        }
        byte[] is = Bzip2Entry.aClass9_1072.lookupFile(5, i_17_);
        class39_sub5_sub5 = new Class39_Sub5_Sub5();
        if (is != null) {
            class39_sub5_sub5.method572(new Buffer(is), (byte) 24);
        }
        FrameBuffer.aClass7_2158.put(class39_sub5_sub5,
                (long) i_17_);
        return class39_sub5_sub5;
    }

    public static void method1099(byte i, AbstractFileLoader class9) {
        ItemDefinition.aClass9_1680 = class9;
    }

    static {
        aClass3_1134 = JString.create("Please use a different world)3");
        aClass3_1133 = JString.create("Spiel)2Fenster geladen)3");
        aClass3_1140 = aClass3_1134;
        aClass3_1139 = JString.create("Ausw-=hlen");
        OndemandHandler.odConnectionDelay = 0;
        aClass3_1142 = aClass3_1134;
        anInt1141 = 0;
    }
}
