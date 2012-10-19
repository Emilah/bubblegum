package com.jagex.awt.listeners;

/* Class42 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.io.Buffer;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import com.jagex.world.Barrier;
import unpackaged.Class14;
import unpackaged.Class2;
import unpackaged.Class23;
import com.jagex.world.entities.StillObject;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import com.jagex.utils.Timer;
import com.jagex.script.ClientScript;
import com.jagex.io.FileLoader;
import com.jagex.od.OndemandHandler;
import com.jagex.od.OndemandRequest;
import com.jagex.script.ScriptExecutor;

public class JMouseListener
        implements MouseListener, MouseMotionListener, FocusListener {

    public static boolean aBoolean785 = false;
    public static Calendar aCalendar786 = Calendar.getInstance();
    public static int anInt787 = 0;
    public static JString aClass3_789;
    public static JString aClass3_790 = JString.create("sich mit einer anderen Welt zu verbinden)3");
    public static volatile int anInt791;
    public static JString chalRequestJstr;
    public static int anInt793;
    public static JString aClass3_794;
    public static JString aClass3_795;

    public static int method901(int i, int i_0_, int i_1_, boolean bool) {
        i &= 0x3;
        if (i == 0) {
            return i_0_;
        }
        if (i == 1) {
            return i_1_;
        }
        if (i == 2) {
            return 7 - i_0_;
        }
        return 7 - i_1_;
    }

    public void focusGained(FocusEvent focusevent) {
        /* empty */
    }

    public synchronized void mouseExited(MouseEvent mouseevent) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            Projectile.queuedMousePositionX = -1;
            Barrier.queuedMousePositionY = -1;
        }
    }

    public synchronized void mouseReleased(MouseEvent mouseevent) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            ClientScript.anInt1699 = 0;
        }
        if (mouseevent.isPopupTrigger()) {
            mouseevent.consume();
        }
    }

    public static void printMessage(int type, JString class3, JString class3_2_) {
        if (type == 0 && ISAAC.chatboxWidgetId != -1) {
            TextConstants.aClass3_1714 = class3_2_;
            Timer.anInt887 = 0;
        }
        if (Class39_Sub5_Sub14.chatboxOverlayId == -1) {
            Class14.aBoolean245 = true;
        }
        for (int i_3_ = 99; i_3_ > 0; i_3_--) {
            Client.messageTypes[i_3_] = Client.messageTypes[i_3_ - 1];
            StillObject.messagePrefixes[i_3_] = StillObject.messagePrefixes[i_3_ - 1];
            Class2.messageBodies[i_3_] = Class2.messageBodies[i_3_ - 1];
        }
        Client.messageTypes[0] = type;
        StillObject.messagePrefixes[0] = class3;
        Class2.messageBodies[0] = class3_2_;
    }

    public synchronized void mousePressed(MouseEvent mouseevent) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            anInt791 = mouseevent.getX();
            Class41.anInt784 = mouseevent.getY();
            Class2.aLong55 = Class2.getSystemTime();
            if (mouseevent.isMetaDown()) {
                Class23.anInt430 = 2;
                ClientScript.anInt1699 = 2;
            } else {
                Class23.anInt430 = 1;
                ClientScript.anInt1699 = 1;
            }
        }
        if (mouseevent.isPopupTrigger()) {
            mouseevent.consume();
        }
    }

    public synchronized void mouseDragged(MouseEvent event) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            Projectile.queuedMousePositionX = event.getX();
            Barrier.queuedMousePositionY = event.getY();
        }
    }

    public synchronized void mouseMoved(MouseEvent event) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            Projectile.queuedMousePositionX = event.getX();
            Barrier.queuedMousePositionY = event.getY();
        }
    }

    public synchronized void focusLost(FocusEvent focusevent) {
        if (ItemContainer.aClass42_1502 != null) {
            ClientScript.anInt1699 = 0;
        }
    }

    public synchronized void mouseEntered(MouseEvent mouseevent) {
        if (ItemContainer.aClass42_1502 != null) {
            FileLoader.anInt1302 = 0;
            Projectile.queuedMousePositionX = mouseevent.getX();
            Barrier.queuedMousePositionY = mouseevent.getY();
        }
    }

    public void mouseClicked(MouseEvent mouseevent) {
        if (mouseevent.isPopupTrigger()) {
            mouseevent.consume();
        }
    }

    public static void method903(int i) {
        aClass3_795 = null;
        aClass3_794 = null;
        aClass3_789 = null;
        chalRequestJstr = null;
        OndemandHandler.requestBuffer = null;
        aCalendar786 = null;
        ScriptExecutor.strVariables = null;
        aClass3_790 = null;
    }

    static {
        aClass3_789 = JString.create("green:");
        chalRequestJstr = JString.create(":chalreq:");
        anInt791 = 0;
        aClass3_794 = JString.create("@gr2@");
        aClass3_795 = aClass3_789;
    }
}
