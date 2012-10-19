package com.jagex.awt;

/* Canvas_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.utils.NameTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import unpackaged.Class1;
import unpackaged.Class26;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MsTimer;
import unpackaged.Class47;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import com.jagex.config.ObjectDefinition;
import com.jagex.od.OndemandRequest;
import com.jagex.config.Widget;

public class JCanvas extends Canvas {

    public static JString aClass3_13;
    public static JString aClass3_14 = JString.create("white:");
    public static int anInt15;
    public static JString aClass3_16;
    public static JString aClass3_17 = (JString.create("und die Schaltfl-=che (WSpielkonto erstellen(W am"));
    public static JString aClass3_18;
    public static JString aClass3_19;
    public static JString aClass3_20;
    public static int pendingRegularRequests;
    public Component component;
    public static JString aClass3_23;
    public static int anInt24;

    @Override
    public void update(Graphics graphics) {
        component.update(graphics);
    }

    public static void method39(int i) {
        Cache.drawMessages((byte) 54);
        if (Class4.crossMode == 1) {
            Class47.crossSprites[Class26.crossFrameNum / 100].method670(AbstractMidiHandler.crossPositionX - 8 - 4,
                    Class62_Sub2.crossPositionY - 8 - 4);
        }
        if (Class4.crossMode == 2) {
            Class47.crossSprites[Class26.crossFrameNum / 100 + 4].method670(AbstractMidiHandler.crossPositionX - 8 - 4,
                    Class62_Sub2.crossPositionY - 8 - 4);
        }
        if (Class26.viewWidgetId != -1) {
            Class39_Sub4.updateWidgets(Class26.viewWidgetId);
            Deque.drawWidgets(334, 512, 0, Class26.viewWidgetId, 0, -1, 4);
        }
        if (StillObject.viewOverlayId != -1) {
            Class39_Sub4.updateWidgets(StillObject.viewOverlayId);
            Deque.drawWidgets(334, 512, 0, StillObject.viewOverlayId, 0, -1, 0);
        }
        Entity.method487(false);
        if (!Class39_Sub12.aBoolean1493) {
            JString.method95(i ^ ~0x7d26);
            MouseRecorder.method320(-23401);
        } else if (Class37.anInt653 == 0) {
            Class1.method49(-104);
        }
        if (Huffman.anInt756 == 1) {
            Widget.aClass39_Sub5_Sub10_Sub3_2113.method670(472, 296);
        }
        if (OndemandRequest.drawFps) {
            int i_0_ = 507;
            int i_1_ = 16776960;
            int i_2_ = 20;
            Class39_Sub5_Sub14.p12fullFont.method630((Class39_Sub5_Sub11.join((new JString[]{Class39_Sub5_Sub6.fpsJstr, AbstractImage.toJstr(Class39_Sub5_Sub18.anInt2119)}))),
                    i_0_, i_2_, 16776960);
            i_2_ += 15;
            Runtime runtime = Runtime.getRuntime();
            int i_3_ = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
            if (i_3_ > 32768 && PlayerApperance.isLowMemory) {
                i_1_ = 0xFF0000;
            }
            if (i_3_ > 65536 && !PlayerApperance.isLowMemory) {
                i_1_ = 0xFF0000;
            }
            Class39_Sub5_Sub14.p12fullFont.method630((Class39_Sub5_Sub11.join(new JString[]{StillGraphic.aClass3_2328,
                        AbstractImage.toJstr(i_3_),
                        Class63.aClass3_1125})),
                    i_0_, i_2_, i_1_);
            i_2_ += 15;
            if (Class44.aBoolean833) {
                Class39_Sub5_Sub14.p12fullFont.method630(TextConstants.sidePanelRedrawnEng, i_0_, i_2_, 16711680);
                Class44.aBoolean833 = false;
                i_2_ += 15;
            }
            if (Class39_Sub5_Sub14.aBoolean1908) {
                Class39_Sub5_Sub14.p12fullFont.method630(JSocket.aClass3_296, i_0_, i_2_, 16711680);
                Class39_Sub5_Sub14.aBoolean1908 = false;
                i_2_ += 15;
            }
            if (NameTable.aBoolean183) {
                Class39_Sub5_Sub14.p12fullFont.method630(MsTimer.iconsRedrawnJstr, i_0_, i_2_, 0xFF0000);
                NameTable.aBoolean183 = false;
                i_2_ += 15;
            }
        }
        if (ClassCheckRequest.systemUpdateTime != 0) {
            int i_4_ = ClassCheckRequest.systemUpdateTime / 50;
            int i_5_ = i_4_ / 60;
            i_4_ %= 60;
            if (i_4_ < 10) {
                Class39_Sub5_Sub14.p12fullFont.method647((Class39_Sub5_Sub11.join(new JString[]{Class39_Sub4.aClass3_1326,
                            AbstractImage.toJstr(i_5_),
                            Node.aClass3_743,
                            AbstractImage.toJstr(i_4_)})),
                        4, 329, 16776960);
            } else {
                Class39_Sub5_Sub14.p12fullFont.method647((Class39_Sub5_Sub11.join(new JString[]{Class39_Sub4.aClass3_1326,
                            AbstractImage.toJstr(i_5_),
                            TextConstants.colon,
                            AbstractImage.toJstr(i_4_)})),
                        4, 329, 16776960);
            }
        }
        
    }

    public void paint(Graphics graphics) {
        component.paint(graphics);
    }

    public static ObjectDefinition getObjectDefinition(int i) {
        ObjectDefinition class39_sub5_sub15 = ((ObjectDefinition) NameTable.objectDefinitionCache.get((long) i));
        if (class39_sub5_sub15 != null) {
            return class39_sub5_sub15;
        }
        byte[] is = Deque.objectFileLoader.lookupFile(6, i);
        class39_sub5_sub15 = new ObjectDefinition();
        class39_sub5_sub15.anInt1931 = i;
        if (is != null) {
            class39_sub5_sub15.decode(new Buffer(is));
        }
        class39_sub5_sub15.method739(false);
        if (class39_sub5_sub15.aBoolean1953) {
            class39_sub5_sub15.aBoolean1949 = false;
            class39_sub5_sub15.aBoolean1928 = false;
        }
        NameTable.objectDefinitionCache.put(class39_sub5_sub15, (long) i);
        return class39_sub5_sub15;
    }

    public static void method41(byte i) {
        for (Class39_Sub10 class39_sub10 = (Class39_Sub10) Class4.aClass49_74.getFirst();
                class39_sub10 != null;
                class39_sub10 = (Class39_Sub10) Class4.aClass49_74.getNext()) {
            if (class39_sub10.aClass39_Sub5_Sub15_1428 != null) {
                class39_sub10.method864(-67);
            }
        }
    }

    public JCanvas(Component component) {
        this.component = component;
    }

    public static void method42(int i) {
        aClass3_20 = null;
        aClass3_16 = null;
        aClass3_23 = null;
        aClass3_17 = null;
        aClass3_13 = null;
        aClass3_14 = null;
        aClass3_18 = null;
        aClass3_19 = null;
    }

    static {
        aClass3_13 = aClass3_14;
        aClass3_20 = JString.create("Cabbage");
        pendingRegularRequests = 0;
        aClass3_18 = JString.create("Zu viele Verbindungen von Ihrer Adresse)3");
        anInt15 = 0;
        aClass3_23 = JString.create("Login server offline)3");
        aClass3_19 = JString.create("Neuer Benutzer");
        aClass3_16 = aClass3_23;
        anInt24 = 0;
    }
}
