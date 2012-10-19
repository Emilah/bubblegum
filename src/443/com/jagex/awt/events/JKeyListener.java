package com.jagex.awt.events;

/* Class35 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.awt.JApplet;
import com.jagex.io.CacheIO;
import com.jagex.utils.Bzip2Block;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.JImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import com.jagex.io.ArchiveRequest;
import com.jagex.awt.JCanvas;
import unpackaged.Class1;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class25;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import com.jagex.utils.Timer;
import com.jagex.utils.MsTimer;
import unpackaged.Class65;
import com.jagex.io.FileLoader;
import com.jagex.od.OndemandHandler;
import com.jagex.od.OndemandRequest;

public class JKeyListener implements KeyListener, FocusListener {
    public static int anInt618;
    public static int[] actionTypes;
    public static long isaacSeed;
    public static boolean aBoolean628;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_629;

    public synchronized void keyPressed(KeyEvent keyevent) {
        if (Npc.aClass35_2499 != null) {
            Class39_Sub5_Sub7.anInt1779 = 0;
            int keycode = keyevent.getKeyCode();
            if (keycode < 0 || keycode >= Player.keycodeValues.length) {
                keycode = -1;
            } else {
                keycode = Player.keycodeValues[keycode];
                if ((keycode & 0x80) != 0) {
                    keycode = -1;
                }
            }
            int i_0_;
            if (keycode != 85 && keycode != 80 && keycode != 84 && keycode != 0 && keycode != 101) {
                i_0_ = VarpDefinition.method744(keyevent, 8);
            } else {
                i_0_ = -1;
            }
            if (BufferedFile.writeActiveOffset >= 0 && keycode >= 0) {
                Class39_Sub5_Sub11.activeKeyQueue[BufferedFile.writeActiveOffset] = keycode;
                BufferedFile.writeActiveOffset = BufferedFile.writeActiveOffset + 1 & 0x7f;
                if (BufferedFile.writeActiveOffset == Timer.readOffset) {
                    BufferedFile.writeActiveOffset = -1;
                }
            }
            if (keycode >= 0 || i_0_ >= 0) {
                int i_1_ = Mob.writeQueueOffset + 1 & 0x7f;
                if (i_1_ != Buffer.readQueueOffset) {
                    Timer.keyCodeQueue[Mob.writeQueueOffset] = keycode;
                    MsTimer.keyQueue[(Mob.writeQueueOffset)] = i_0_;
                    Mob.writeQueueOffset = i_1_;
                }
            }
        }
        keyevent.consume();
    }

    public static void method344(int i) {
        aClass39_Sub5_Sub10_Sub4_629 = null;
        TextConstants.aClass3_622 = null;
        TextConstants.aClass3_617 = null;
        TextConstants.aClass3_616 = null;
        TextConstants.aClass3_623 = null;
        TextConstants.aClass3_627 = null;
        TextConstants.aClass3_625 = null;
        actionTypes = null;
        TextConstants.aClass3_624 = null;
        TextConstants.aClass3_620 = null;
        TextConstants.aClass3_619 = null;
    }

    public void focusGained(FocusEvent focusevent) {
        /* empty */
    }

    public static int method345(byte i) {
        return 5;
    }

    public static void method346(byte i, int i_20_, Mob class39_sub5_sub4_sub4) {
        Class4.method104(i_20_, class39_sub5_sub4_sub4.fPositionX, i + 99,
                class39_sub5_sub4_sub4.fPositionY);
        if (i != -11) {
            OndemandHandler.cycle();
        }
    }

    public synchronized void keyReleased(KeyEvent keyevent) {
        if (Npc.aClass35_2499 != null) {
            Class39_Sub5_Sub7.anInt1779 = 0;
            int i = keyevent.getKeyCode();
            if (i >= 0 && Player.keycodeValues.length > i) {
                i = Player.keycodeValues[i] & ~0x80;
            } else {
                i = -1;
            }
            if (BufferedFile.writeActiveOffset >= 0 && i >= 0) {
                Class39_Sub5_Sub11.activeKeyQueue[BufferedFile.writeActiveOffset] = i ^ 0xffffffff;
                BufferedFile.writeActiveOffset = BufferedFile.writeActiveOffset + 1 & 0x7f;
                if (BufferedFile.writeActiveOffset == Timer.readOffset) {
                    BufferedFile.writeActiveOffset = -1;
                }
            }
        }
        keyevent.consume();
    }

    public synchronized void focusLost(FocusEvent focusevent) {
        if (Npc.aClass35_2499 != null) {
            BufferedFile.writeActiveOffset = -1;
        }
    }

    public void keyTyped(KeyEvent keyevent) {
        keyevent.consume();
    }

    public static void fetchArchive(boolean bool, CacheIO class6, FileLoader class9_sub1, int i) {
        ArchiveRequest request = new ArchiveRequest();
        request.loader = class9_sub1;
        request.cache = class6;
        request.hash = (long) i;
        request.type = 1;
        synchronized (JSocket.archiveRequests) {
            JSocket.archiveRequests.offerLast(request);
        }
        Class65.method1095(117);
    }

    static {
        TextConstants.aClass3_616 = TextConstants.aClass3_617;
        TextConstants.aClass3_619 = JString.create("Der Anmelde)2Server ist offline)3");
        actionTypes = new int[500];
        TextConstants.aClass3_625 = JString.create("Friends");
        TextConstants.aClass3_624 = TextConstants.aClass3_625;
        isaacSeed = 0L;
        TextConstants.aClass3_620 = JString.create("Checking for updates )2 ");
        TextConstants.aClass3_623 = TextConstants.aClass3_620;
        TextConstants.aClass3_627 = JString.create("Loading game screen )2 ");
        TextConstants.aClass3_622 = TextConstants.aClass3_627;
    }
}
