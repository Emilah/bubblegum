package com.jagex.awt;

/* Applet_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.awt.listeners.MouseListenerImpl;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import com.jagex.io.ArchiveWorker;
import com.jagex.world.Barrier;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class25;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class41;
import unpackaged.Class43;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MsTimer;
import unpackaged.Class53;
import com.jagex.audio.AudioHandler;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class63;
import unpackaged.Class67;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.script.ClientScript;
import com.jagex.config.Model;
import com.jagex.config.NpcDefinition;
import com.jagex.od.OndemandHandler;
import com.jagex.utils.JRuntimeException;
import com.jagex.sign.Signlink;

public abstract class JApplet extends Applet implements Runnable, FocusListener, WindowListener {
    public static long[] aLongArray2 = new long[200];
    public static Buffer odBuffer;
    public static JString mJstr = JString.create("m");
    public boolean errorPageDisplayed = false;
    public static JString aClass3_6;
    public static JString attackJstr;
    public static int anInt8;
    public static JString attackJstrEng;
    public static JString aClass3_10;
    public static int anInt11;
    public static boolean aBoolean12;

    public void windowClosing(WindowEvent windowevent) {
        destroy();
    }

    public void start() {
        if (this == Class25.anApplet_Sub1_465 && !AudioHandler.aBoolean1112) {
            Class15.aLong281 = 0L;
        }
    }

    public String getParameter(String string) {
        if (Barrier.frame != null) {
            return null;
        }
        if (Class39_Sub5_Sub9.fileSignlink != null
                && Class39_Sub5_Sub9.fileSignlink.anApplet416 != this) {
            return Class39_Sub5_Sub9.fileSignlink.anApplet416.getParameter(string);
        }
        return super.getParameter(string);
    }

    public void focusGained(FocusEvent focusevent) {
        PlayerApperance.inFocus = true;
        ClientScript.aBoolean1690 = true;
    }

    public void run() {
        try {
            if (Signlink.javaVendor != null) {
                String javaVendor = Signlink.javaVendor.toLowerCase();
                if (javaVendor.indexOf("sun") == -1 && javaVendor.indexOf("apple") == -1) {
                    if (javaVendor.indexOf("ibm") != -1 && (Signlink.javaVersion == null || Signlink.javaVersion.equals("1.4.2"))) {
                        displayErrorPage("wrongjava");
                        return;
                    }
                } else {
                    String javaVersion = Signlink.javaVersion;
                    if (javaVersion.equals("1.1") || javaVersion.startsWith("1.1.") || javaVersion.equals("1.2") || javaVersion.startsWith("1.2.")) {
                        displayErrorPage("wrongjava");
                        return;
                    }
                    Class39_Sub5_Sub6.anInt1773 = 5;
                }
            }
            if (Class39_Sub5_Sub9.fileSignlink.anApplet416 != null) {
                Method method = Signlink.aMethod417;
                if (method != null) {
                    try {
                        method.invoke((Class39_Sub5_Sub9.fileSignlink.anApplet416),
                                new Object[]{Boolean.TRUE});
                    } catch (Throwable throwable) {
                        /* empty */
                    }
                }
            }
            method28(54);
            Class34.aClass57_610 = Queue.method994(Class41.canvas, ISAAC.width,
                    Deque.height, (byte) -120);
            method20(false);
            ArchiveWorker.aClass46_1206 = AbstractImage.method1009((byte) 89);
            ArchiveWorker.aClass46_1206.method938((byte) -50);
            while (Class15.aLong281 == 0L
                    || Class2.getSystemTime() < Class15.aLong281) {
                Class2.anInt50 = ArchiveWorker.aClass46_1206.method939(4,
                        (Class39_Sub5_Sub6.anInt1773),
                        Class15.anInt276);
                for (int i = 0; Class2.anInt50 > i; i++) {
                    method16(-1);
                }
                method30((byte) 90);
            }
        } catch (Exception exception) {
            ClassCheckRequest.reportError(exception, null);
            displayErrorPage("crash");
        }
        method27((byte) 77);
    }

    public void windowDeiconified(WindowEvent windowevent) {
        /* empty */
    }

    public void method16(int i) {
        long l = Class2.getSystemTime();
        long l_1_ = Class67.aLongArray1172[Class39_Sub5_Sub7.anInt1781];
        if (l_1_ != 0L && l_1_ < l) {
            /* empty */
        }
        Class67.aLongArray1172[Class39_Sub5_Sub7.anInt1781] = l;
        Class39_Sub5_Sub7.anInt1781 = Class39_Sub5_Sub7.anInt1781 - i & 0x1f;
        synchronized (this) {
            Class43.aBoolean802 = PlayerApperance.inFocus;
        }
        handleLogic((byte) 19);
    }

    public void initialize(int i, int i_2_, int i_3_, int i_4_, int i_5_) {
        try {
            if (Class25.anApplet_Sub1_465 != null) {
                AbstractMidiHandler.anInt1595++;
                if (AbstractMidiHandler.anInt1595 >= 3) {
                    displayErrorPage("alreadyloaded");
                } else {
                    getAppletContext().showDocument(getDocumentBase());
                }
            } else {
                ArchiveWorker.anInt1198 = i_4_;
                Deque.height = i_2_;
                ISAAC.width = i_5_;
                Class25.anApplet_Sub1_465 = this;
                if (Class39_Sub5_Sub9.fileSignlink == null) {
                    Cache.webSignlink = Class39_Sub5_Sub9.fileSignlink = new Signlink(false, this, InetAddress.getByName(getCodeBase().getHost()), i_3_, null, 0);
                }
                Class39_Sub5_Sub9.fileSignlink.requestThread(this, 1);
            }
        } catch (Exception exception) {
            ClassCheckRequest.reportError(exception, null);
            displayErrorPage("crash");
        }
    }

    public void windowIconified(WindowEvent windowevent) {
        /* empty */
    }

    public static void method18(Signlink class21) {
        Cache.webSignlink = Class39_Sub5_Sub9.fileSignlink = class21;
    }

    public void displayErrorPage(String string) {
        if (!errorPageDisplayed) {
            errorPageDisplayed = true;
            System.out.println("error_game_" + string);
            try {
                getAppletContext().showDocument(new URL(getCodeBase(), ("error_game_" + string + ".ws")));
            } catch (Exception exception) {
                /* empty */
            }
        }
    }

    public abstract void method20(boolean bool);

    @Override
    public AppletContext getAppletContext() {
        if (Barrier.frame != null) {
            return null;
        }
        if (Class39_Sub5_Sub9.fileSignlink != null
                && Class39_Sub5_Sub9.fileSignlink.anApplet416 != this) {
            return Class39_Sub5_Sub9.fileSignlink.anApplet416.getAppletContext();
        }
        return super.getAppletContext();
    }

    public static void method21(byte i) {
        odBuffer = null;
        aLongArray2 = null;
        mJstr = null;
        attackJstr = null;
        attackJstrEng = null;
        aClass3_10 = null;
        aClass3_6 = null;
    }

    public abstract void method22(int i);

    public void initialize(int i, InetAddress inetaddress, String gameName,
            int w, int h, int maximumIndexId, int fileStore) {
        try {
            Class25.anApplet_Sub1_465 = this;
            ArchiveWorker.anInt1198 = i;
            Deque.height = h;
            ISAAC.width = w;
            Barrier.frame = new Frame();
            Barrier.frame.setTitle("Evelus");
            Barrier.frame.setResizable(false);
            Barrier.frame.addWindowListener(this);
            Barrier.frame.setVisible(true);
            Barrier.frame.toFront();
            Insets insets = Barrier.frame.getInsets();
            Barrier.frame.setSize(insets.right + (insets.left + w), insets.top + h + insets.bottom);
            Cache.webSignlink = Class39_Sub5_Sub9.fileSignlink = new Signlink(true, null, inetaddress, fileStore, gameName, maximumIndexId);
            Class39_Sub5_Sub9.fileSignlink.requestThread(this, 1);
        } catch (Exception exception) {
            ClassCheckRequest.reportError(exception, null);
        }
    }

    @Override
    public URL getCodeBase() {
        if (Barrier.frame != null) {
            return null;
        }
        if (Class39_Sub5_Sub9.fileSignlink != null
                && this != Class39_Sub5_Sub9.fileSignlink.anApplet416) {
            return Class39_Sub5_Sub9.fileSignlink.anApplet416.getCodeBase();
        }
        return super.getCodeBase();
    }

    public static void method24(NpcDefinition definition, int positionX, int positionY, int id) {
        if (Class39_Sub5_Sub11.actionOffset < 400) {
            if (definition.anIntArray1878 != null) {
                definition = definition.method721(5585);
            }
            if (definition != null && definition.aBoolean1886) {
                JString name = definition.name;
                if (definition.anInt1859 != 0) {
                    name = (Class39_Sub5_Sub11.join((new JString[]{name,
                                (Class39_Sub5_Sub6.method579((Cache.localPlayer.combatLevel),
                                definition.anInt1859, false)),
                                Class39_Sub5_Sub18.aClass3_2118,
                                TextConstants.aClass3_1270,
                                AbstractImage.toJstr((definition.anInt1859)),
                                Queue.aClass3_984})));
                }
                if (Class13.anInt208 != 1) {
                    if (ISAAC.aBoolean1100) {
                        if ((Class41.anInt776 & 0x2) == 2) {
                            JString.queueAction(48, id,positionX, positionY, TextConstants.aClass3_1273, (Class39_Sub5_Sub11.join((new JString[]{Class14.aClass3_216, (Class39_Sub5_Sub9.aClass3_1817), name}))));
                        }
                    } else {
                        JString[] options = definition.options;
                        if (PlayerApperance.displayOptionIds) {
                            options = BufferedFile.method225(options);
                        }
                        if (options != null) {
                            for (int i_14_ = 4; i_14_ >= 0; i_14_--) {
                                if (options[i_14_] != null && !options[i_14_].equalTo(attackJstr)) {
                                    int i_15_ = 0;
                                    if (i_14_ == 0) {
                                        i_15_ = 42;
                                    }
                                    if (i_14_ == 1) {
                                        i_15_ = 17;
                                    }
                                    if (i_14_ == 2) {
                                        i_15_ = 13;
                                    }
                                    if (i_14_ == 3) {
                                        i_15_ = 53;
                                    }
                                    if (i_14_ == 4) {
                                        i_15_ = 46;
                                    }
                                    JString.queueAction(i_15_, id, positionX, positionY, options[i_14_], (Class39_Sub5_Sub11.join((new JString[]{HashTable.yelPrefixJstr, name}))));
                                }
                            }
                        }
                        if (options != null) {
                            for (int i_16_ = 4; i_16_ >= 0; i_16_--) {
                                if (options[i_16_] != null && options[i_16_].equalTo(attackJstr)) {
                                    int actionType = 0;
                                    int i_18_ = 0;
                                    if ((Cache.localPlayer.combatLevel) < definition.anInt1859) {
                                        i_18_ = 2000;
                                    }
                                    if (i_16_ == 0) {
                                        actionType = i_18_ + 42;
                                    }
                                    if (i_16_ == 1) {
                                        actionType = i_18_ + 17;
                                    }
                                    if (i_16_ == 2) {
                                        actionType = i_18_ + 13;
                                    }
                                    if (i_16_ == 3) {
                                        actionType = 53 + i_18_;
                                    }
                                    if (i_16_ == 4) {
                                        actionType = i_18_ + 46;
                                    }
                                    JString.queueAction(actionType, id, positionX, positionY, options[i_16_], (Class39_Sub5_Sub11.join((new JString[]{HashTable.yelPrefixJstr,
                                                name}))));
                                }
                            }
                        }
                        JString.queueAction(1001, id,positionX,
                                positionY, JRuntimeException.examineJstr,
                                (Class39_Sub5_Sub11.join(new JString[]{HashTable.yelPrefixJstr,
                                    name})));
                    }
                } else {
                    JString.queueAction(47, id,positionX,
                            positionY, Mob.useJstr,
                            (Class39_Sub5_Sub11.join((new JString[]{Class39_Sub10.useWithItemJstr,
                                Class39_Sub5_Sub9.aClass3_1817,
                                name}))));
                }
            }
        }
    }

    public static void method25(Player class39_sub5_sub4_sub4_sub2, byte i,
            int i_19_, int i_20_) {
        if ((i_20_ & 0x40) != 0) {
            int i_21_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
            byte[] is = new byte[i_21_];
            Buffer class39_sub6 = new Buffer(is);
            Class39_Sub5_Sub11.incomingBuffer.getBytes128(is, 0, i_21_);
            ISAAC.appearanceBuffers[i_19_] = class39_sub6;
            class39_sub5_sub4_sub4_sub2.parseAppearance(class39_sub6);
        }
        if ((i_20_ & 0x100) != 0) {
            class39_sub5_sub4_sub4_sub2.anInt2287 = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
            class39_sub5_sub4_sub4_sub2.anInt2266 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            class39_sub5_sub4_sub4_sub2.anInt2279 = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
            class39_sub5_sub4_sub4_sub2.anInt2277 = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
            class39_sub5_sub4_sub4_sub2.anInt2256 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128() + Class2.logicCycle;
            class39_sub5_sub4_sub4_sub2.anInt2261 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128() + Class2.logicCycle;
            class39_sub5_sub4_sub4_sub2.anInt2292 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            class39_sub5_sub4_sub4_sub2.method515(0);
        }
        if ((i_20_ & 0x200) != 0) {
            class39_sub5_sub4_sub4_sub2.anInt2270 = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int i_22_ = Class39_Sub5_Sub11.incomingBuffer.getDwordB();
            class39_sub5_sub4_sub4_sub2.anInt2272 = (i_22_ & 0xffff) + Class2.logicCycle;
            if (class39_sub5_sub4_sub4_sub2.anInt2270 == 65535) {
                class39_sub5_sub4_sub4_sub2.anInt2270 = -1;
            }
            class39_sub5_sub4_sub4_sub2.anInt2304 = 0;
            class39_sub5_sub4_sub4_sub2.anInt2276 = 0;
            class39_sub5_sub4_sub4_sub2.anInt2288 = i_22_ >> 16;
            if (Class2.logicCycle < class39_sub5_sub4_sub4_sub2.anInt2272) {
                class39_sub5_sub4_sub4_sub2.anInt2276 = -1;
            }
        }
        if ((i_20_ & 0x1) != 0) {
            class39_sub5_sub4_sub4_sub2.aClass3_2295 = Class39_Sub5_Sub11.incomingBuffer.getJstr();
            if (class39_sub5_sub4_sub4_sub2.aClass3_2295.charAt(0)
                    != 126) {
                if (class39_sub5_sub4_sub4_sub2
                        == Cache.localPlayer) {
                    MouseListenerImpl.printMessage(2,class39_sub5_sub4_sub4_sub2.aClass3_2521,
                            class39_sub5_sub4_sub4_sub2.aClass3_2295);
                }
            } else {
                class39_sub5_sub4_sub4_sub2.aClass3_2295 = class39_sub5_sub4_sub4_sub2.aClass3_2295.substring(1);
                MouseListenerImpl.printMessage(2,class39_sub5_sub4_sub4_sub2.aClass3_2521,
                        class39_sub5_sub4_sub4_sub2.aClass3_2295);
            }
            class39_sub5_sub4_sub4_sub2.anInt2271 = 0;
            class39_sub5_sub4_sub4_sub2.anInt2259 = 150;
            class39_sub5_sub4_sub4_sub2.anInt2296 = 0;
        }
        if ((i_20_ & 0x10) != 0) {
            class39_sub5_sub4_sub4_sub2.anInt2260 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            if (class39_sub5_sub4_sub4_sub2.anInt2260 == 65535) {
                class39_sub5_sub4_sub4_sub2.anInt2260 = -1;
            }
        }
        if ((i_20_ & 0x2) != 0) {
            class39_sub5_sub4_sub4_sub2.anInt2316 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            class39_sub5_sub4_sub4_sub2.anInt2300 = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
        }
        if ((i_20_ & 0x8) != 0) {
            int i_23_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            int i_24_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            if (i_23_ == 65535) {
                i_23_ = -1;
            }
            MsTimer.method944(class39_sub5_sub4_sub4_sub2, i_23_, -8,
                    i_24_);
        }
        if ((i_20_ & 0x4) != 0) {
            int i_25_ = Class39_Sub5_Sub11.incomingBuffer.getUint16();
            int i_26_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int i_27_ = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
            int i_28_ = Class39_Sub5_Sub11.incomingBuffer.offset;
            if (class39_sub5_sub4_sub4_sub2.aClass3_2521 != null
                    && class39_sub5_sub4_sub4_sub2.aClass45_2516 != null) {
                long l = class39_sub5_sub4_sub4_sub2.aClass3_2521.encodeBase37();
                boolean bool = false;
                if (i_26_ <= 1) {
                    for (int i_29_ = 0; Class15.amountIgnores > i_29_; i_29_++) {
                        if (Class39_Sub5_Sub9.ignoreUsernames[i_29_] == l) {
                            bool = true;
                            break;
                        }
                    }
                }
                if (!bool && Wall.anInt630 == 0) {
                    Player.aClass39_Sub6_2515.offset = 0;
                    Class39_Sub5_Sub11.incomingBuffer.getBytesReverse((Player.aClass39_Sub6_2515.payload), 0, i_27_);
                    Player.aClass39_Sub6_2515.offset = 0;
                    JString class3 = Class63.decodeHuffmans(Player.aClass39_Sub6_2515).method58(true);
                    class39_sub5_sub4_sub4_sub2.aClass3_2295 = class3.method69();
                    class39_sub5_sub4_sub4_sub2.anInt2259 = 150;
                    class39_sub5_sub4_sub4_sub2.anInt2296 = i_25_ >> 8;
                    class39_sub5_sub4_sub4_sub2.anInt2271 = i_25_ & 0xff;
                    if (i_26_ == 2 || i_26_ == 3) {
                        MouseListenerImpl.printMessage(1,(Class39_Sub5_Sub11.join((new JString[]{Class53.crown2Jstr,
                                    (class39_sub5_sub4_sub4_sub2.aClass3_2521)}))),
                                class3);
                    } else if (i_26_ != 1) {
                        MouseListenerImpl.printMessage(2,(class39_sub5_sub4_sub4_sub2.aClass3_2521),
                                class3);
                    } else {
                        MouseListenerImpl.printMessage(1,(Class39_Sub5_Sub11.join((new JString[]{Class37.crown1Jstr,
                                    (class39_sub5_sub4_sub4_sub2.aClass3_2521)}))),
                                class3);
                    }
                }
            }
            Class39_Sub5_Sub11.incomingBuffer.offset = i_28_ + i_27_;
        }
        if ((i_20_ & 0x400) != 0) {
            int i_30_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            int i_31_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteB();
            class39_sub5_sub4_sub4_sub2.method513(-89, Class2.logicCycle, i_30_,
                    i_31_);
            class39_sub5_sub4_sub4_sub2.anInt2252 = Class2.logicCycle + 300;
            class39_sub5_sub4_sub4_sub2.anInt2318 = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
            class39_sub5_sub4_sub4_sub2.anInt2269 = Class39_Sub5_Sub11.incomingBuffer.getUint8();
        }
        if ((i_20_ & 0x20) != 0) {
            int i_32_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            int i_33_ = Class39_Sub5_Sub11.incomingBuffer.getUint8();
            class39_sub5_sub4_sub4_sub2.method513(-116, Class2.logicCycle, i_32_,
                    i_33_);
            class39_sub5_sub4_sub4_sub2.anInt2252 = Class2.logicCycle + 300;
            class39_sub5_sub4_sub4_sub2.anInt2318 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            class39_sub5_sub4_sub4_sub2.anInt2269 = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
        }
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void windowOpened(WindowEvent windowevent) {
        /* empty */
    }

    public static void method26(int i, int i_34_, int i_35_, int i_36_,
            int i_37_, int i_38_, int i_39_) {
        int i_40_ = -i_38_ + 2048 & 0x7ff;
        int i_41_ = -i_35_ + 2048 & 0x7ff;
        int i_42_ = 0;
        int i_43_ = 0;
        int i_44_ = i_37_;
        if (i_40_ != 0) {
            int i_45_ = Model.anIntArray2394[i_40_];
            int i_46_ = Model.anIntArray2418[i_40_];
            int i_47_ = i_46_ * i_42_ - i_44_ * i_45_ >> 16;
            i_44_ = i_45_ * i_42_ + i_44_ * i_46_ >> 16;
            i_42_ = i_47_;
        }
        if (i_41_ != 0) {
            int i_48_ = Model.anIntArray2394[i_41_];
            int i_49_ = Model.anIntArray2418[i_41_];
            int i_50_ = i_44_ * i_48_ + i_49_ * i_43_ >> 16;
            i_44_ = -(i_48_ * i_43_) + i_49_ * i_44_ >> 16;
            i_43_ = i_50_;
        }
        Node.fCameraPositionY = -i_44_ + i_36_;
        Class43.anInt799 = i_38_;
        Class39_Sub10.cameraHeight = i_39_ - i_42_;
        Mob.anInt2315 = i_35_;
        StillObject.fCameraPositionX = i_34_ - i_43_;
    }

    public synchronized void method27(byte i) {
        if (i <= 56) {
            OndemandHandler.encryptionKey = (byte) -114;
        }
        if (!AudioHandler.aBoolean1112) {
            AudioHandler.aBoolean1112 = true;
            try {
                Class41.canvas.removeFocusListener(this);
            } catch (Exception exception) {
                /* empty */
            }
            try {
                method22(4258);
            } catch (Exception exception) {
                /* empty */
            }
            if (Barrier.frame != null) {
                try {
                    System.exit(0);
                } catch (Throwable throwable) {
                    /* empty */
                }
            }
            if (Class39_Sub5_Sub9.fileSignlink != null) {
                try {
                    Class39_Sub5_Sub9.fileSignlink.destroy();
                } catch (Exception exception) {
                    /* empty */
                }
            }
            method31(503);
        }
    }

    public synchronized void method28(int i) {
        Container container;
        if (Barrier.frame != null) {
            container = Barrier.frame;
        } else {
            container = Class39_Sub5_Sub9.fileSignlink.anApplet416;
        }
        if (Class41.canvas != null) {
            Class41.canvas.removeFocusListener(this);
            container.remove(Class41.canvas);
        }
        Class41.canvas = new JCanvas(this);
        container.add(Class41.canvas);
        Class41.canvas.setSize(ISAAC.width, Deque.height);
        Class41.canvas.setVisible(true);
        if (Barrier.frame != null) {
            Insets insets = Barrier.frame.getInsets();
            Class41.canvas.setLocation(insets.left, insets.top);
        } else {
            Class41.canvas.setLocation(0, 0);
        }
        Class41.canvas.addFocusListener(this);
        Class41.canvas.requestFocus();
        ClientScript.aBoolean1690 = true;
        ClassCheckRequest.aBoolean1373 = false;
        Class41.aLong782 = Class2.getSystemTime();
    }

    public synchronized void paint(Graphics graphics) {
        if (this == Class25.anApplet_Sub1_465 && !AudioHandler.aBoolean1112) {
            ClientScript.aBoolean1690 = true;
            if (Signlink.javaVersion != null
                    && Signlink.javaVersion.startsWith("1.5")
                    && Class2.getSystemTime() - Class41.aLong782 > 1000L) {
                Rectangle rectangle = graphics.getClipBounds();
                if (rectangle == null
                        || (ISAAC.width <= rectangle.width
                        && Deque.height <= rectangle.height)) {
                    ClassCheckRequest.aBoolean1373 = true;
                }
            }
        }
    }

    public void stop() {
        if (this == Class25.anApplet_Sub1_465 && !AudioHandler.aBoolean1112) {
            Class15.aLong281 = Class2.getSystemTime() + 4000L;
        }
    }

    public boolean isHostValid() {
        String string = getDocumentBase().getHost().toLowerCase();
        if (string.endsWith("jagex.com")) {
            return true;
        }
        if (string.endsWith("runescape.com")) {
            return true;
        }
        if (string.endsWith("127.0.0.1")) {
            return true;
        }
        for (/**/;
                (string.length() > 0 && string.charAt(string.length() - 1) >= '0'
                && string.charAt(string.length() - 1) <= '9');
                string = string.substring(0, string.length() - 1)) {
            /* empty */
        }
        if (string.endsWith("192.168.1.")) {
            return true;
        }
        displayErrorPage("invalidhost");
        return false;
    }

    public void destroy() {
        if (this == Class25.anApplet_Sub1_465 && !AudioHandler.aBoolean1112) {
            Class15.aLong281 = Class2.getSystemTime();
            PlayerApperance.sleep(5000L);
            Cache.webSignlink = null;
            method27((byte) 92);
        }
    }

    public void windowClosed(WindowEvent windowevent) {
        /* empty */
    }

    public void windowDeactivated(WindowEvent windowevent) {
        /* empty */
    }

    public void method30(byte i) {
        if (i < 67) {
            method21((byte) 122);
        }
        long l = Class2.getSystemTime();
        long l_51_ = ClassCheckRequest.aLongArray1374[MouseListenerImpl.anInt793];
        ClassCheckRequest.aLongArray1374[MouseListenerImpl.anInt793] = l;
        if (l_51_ != 0L && l_51_ < l) {
            int i_52_ = (int) (l + -l_51_);
            Class39_Sub5_Sub18.anInt2119 = (32000 + (i_52_ >> 1)) / i_52_;
        }
        MouseListenerImpl.anInt793 = MouseListenerImpl.anInt793 + 1 & 0x1f;
        if (PlayerApperance.anInt855++ > 50) {
            PlayerApperance.anInt855 -= 50;
            ClientScript.aBoolean1690 = true;
            Class41.canvas.setSize(ISAAC.width, Deque.height);
            Class41.canvas.setVisible(true);
            if (Barrier.frame == null) {
                Class41.canvas.setLocation(0, 0);
            } else {
                Insets insets = Barrier.frame.getInsets();
                Class41.canvas.setLocation(insets.left, insets.top);
            }
        }
        handleDrawCycle(true);
    }

    public abstract void method31(int i);

    public abstract void init();

    public URL getDocumentBase() {
        if (Barrier.frame != null) {
            return null;
        }
        if (Class39_Sub5_Sub9.fileSignlink != null
                && this != Class39_Sub5_Sub9.fileSignlink.anApplet416) {
            return Class39_Sub5_Sub9.fileSignlink.anApplet416.getDocumentBase();
        }
        return super.getDocumentBase();
    }

    public void focusLost(FocusEvent focusevent) {
        PlayerApperance.inFocus = false;
    }

    public void windowActivated(WindowEvent windowevent) {
        /* empty */
    }

    public abstract void handleDrawCycle(boolean bool);

    public abstract void handleLogic(byte i);

    static {
        odBuffer = new Buffer(8);
        aClass3_6 = JString.create("Loading title screen )2 ");
        aClass3_10 = aClass3_6;
        attackJstrEng = JString.create("Attack");
        attackJstr = attackJstrEng;
    }
}
