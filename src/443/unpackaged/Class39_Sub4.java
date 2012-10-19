package unpackaged;

import com.jagex.graphics.GouraudVertex;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.utils.ItemContainer;
import com.jagex.script.ScriptState;
import com.jagex.utils.JRuntimeException;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Mob;
import com.jagex.config.ItemDefinition;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.io.FrameBuffer;
import com.jagex.script.ScriptExecutor;

/* Class39_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class Class39_Sub4 extends Node {

    public static JString aClass3_1324 = JString.create("Hide");
    public JString aClass3_1325;
    public static JString aClass3_1326;
    public static JString aClass3_1327 = JString.create("Walk here");
    public static JString aClass3_1328;
    public static int mouseClickPositionX;
    public static int odBlockOffset;
    public static JString aClass3_1332;
    public static JString aClass3_1333;
    public static JString aClass3_1334;
    public static int anInt1335 = 0;
    public static int anInt1336;
    public static JString aClass3_1337 = JString.create("Verbindung abgebrochen)3");
    public static JString aClass3_1338 = aClass3_1327;
    public static JString aClass3_1339;
    public static JString aClass3_1340;

    public static void method456(byte i, int i_0_, int i_1_, int i_2_,
            int i_3_, int i_4_, int i_5_, int i_6_,
            Widget class39_sub5_sub17) {
        if (!JRuntimeException.aBoolean1221) {
            MsTimer.anInt1561 = 0;
        } else {
            MsTimer.anInt1561 = 32;
        }
        JRuntimeException.aBoolean1221 = false;
        if (i_0_ > i_1_ || i_0_ + 16 <= i_1_ || i_5_ > i_2_
                || i_2_ >= i_5_ + 16) {
            if (i_0_ <= i_1_ && i_1_ < i_0_ + 16 && i_4_ + i_5_ - 16 <= i_2_
                    && i_2_ < i_5_ + i_4_) {
                if (i_3_ == 2 || i_3_ == 3) {
                    Class14.aBoolean245 = true;
                }
                if (i_3_ == 1) {
                    Class39_Sub14.updateTab = true;
                }
                class39_sub5_sub17.scrollY += MsTimer.anInt1547 * 4;
            } else if (i_1_ >= -MsTimer.anInt1561 + i_0_
                    && i_1_ < i_0_ + 16 + MsTimer.anInt1561
                    && i_5_ + 16 <= i_2_ && i_2_ < i_4_ + (i_5_ - 16)
                    && MsTimer.anInt1547 > 0) {
                JRuntimeException.aBoolean1221 = true;
                if (i_3_ == 2 || i_3_ == 3) {
                    Class14.aBoolean245 = true;
                }
                if (i_3_ == 1) {
                    Class39_Sub14.updateTab = true;
                }
                int i_7_ = (i_4_ - 32) * i_4_ / i_6_;
                if (i_7_ < 8) {
                    i_7_ = 8;
                }
                int i_8_ = -i_7_ + (i_4_ - 32);
                int i_9_ = -(i_7_ / 2) - 16 + i_2_ - i_5_;
                class39_sub5_sub17.scrollY = (i_6_ - i_4_) * i_9_ / i_8_;
            }
        } else {
            class39_sub5_sub17.scrollY -= MsTimer.anInt1547 * 4;
            if (i_3_ == 1) {
                Class39_Sub14.updateTab = true;
            }
            if (i_3_ == 2 || i_3_ == 3) {
                Class14.aBoolean245 = true;
            }
        }
        if (TextureLoaderImpl.anInt1252 != 0) {
            int i_10_ = class39_sub5_sub17.width;
            if (i_3_ == -1) {
                i_10_ = 479;
            }
            if (i_0_ - i_10_ <= i_1_ && i_5_ <= i_2_ && i_1_ < i_0_ + 16
                    && i_5_ + i_4_ >= i_2_) {
                class39_sub5_sub17.scrollY += TextureLoaderImpl.anInt1252 * 45;
                if (i_3_ == 2 || i_3_ == 3) {
                    Class14.aBoolean245 = true;
                }
                if (i_3_ == 1) {
                    Class39_Sub14.updateTab = true;
                }
            }
        }
    }

    public static void method457(int i, int i_11_) {
        if (i_11_ != -1 && JSocket.loadWidget(i_11_)) {
            Widget[] class39_sub5_sub17s = AbstractMidiHandler.widgets[i_11_];
            for (int i_12_ = 0; i_12_ < class39_sub5_sub17s.length; i_12_++) {
                Widget class39_sub5_sub17 = class39_sub5_sub17s[i_12_];
                if (class39_sub5_sub17.anObjectArray2033 != null) {
                    ScriptExecutor.executeClientScript(0,
                            (class39_sub5_sub17.anObjectArray2033),
                            null, 120, 0,
                            class39_sub5_sub17, 0);
                }
            }
        }
    }

    public static void method458(int i) {
        aClass3_1326 = null;
        aClass3_1324 = null;
        aClass3_1333 = null;
        aClass3_1327 = null;
        aClass3_1340 = null;
        aClass3_1337 = null;
        aClass3_1338 = null;
        ScriptExecutor.stateStack = null;
        aClass3_1334 = null;
        aClass3_1332 = null;
        aClass3_1328 = null;
        aClass3_1339 = null;
    }

    public static boolean updateWidgets(int i) {
        if (!JSocket.loadWidget(i)) {
            return false;
        }
        boolean bool = false;
        Widget[] widgets = AbstractMidiHandler.widgets[i];
        for (int i_14_ = 0; widgets.length > i_14_; i_14_++) {
            Widget widget = widgets[i_14_];
            if (widget != null && widget.type == 6) {
                if (widget.anInt2103 != -1 || widget.anInt2052 != -1) {
                    boolean bool_15_ = Huffman.parseClientScript(widget);
                    int i_16_;
                    if (!bool_15_) {
                        i_16_ = widget.anInt2103;
                    } else {
                        i_16_ = widget.anInt2052;
                    }
                    if (i_16_ != -1) {
                        Class39_Sub5_Sub11 class39_sub5_sub11 = AbstractMidiHandler.method1064(i_16_, (byte) 54);
                        widget.anInt2079 += PlayerApperance.anInt856;
                        while ((class39_sub5_sub11.anIntArray1831[widget.anInt1999]) < widget.anInt2079) {
                            widget.anInt2079 -= (class39_sub5_sub11.anIntArray1831[widget.anInt1999]);
                            widget.anInt1999++;
                            bool = true;
                            if (widget.anInt1999 >= class39_sub5_sub11.anIntArray1833.length) {
                                widget.anInt1999 -= class39_sub5_sub11.anInt1839;
                                if (widget.anInt1999 < 0 || (widget.anInt1999
                                        >= (class39_sub5_sub11.anIntArray1833).length)) {
                                    widget.anInt1999 = 0;
                                }
                            }
                        }
                    }
                }
                if (widget.anInt2069 != 0 && !widget.isNewFormat) {
                    bool = true;
                    int sineAmount = widget.anInt2069 << 16 >> 16;
                    int cosineAmount = widget.anInt2069 >> 16;
                    cosineAmount *= PlayerApperance.anInt856;
                    sineAmount *= PlayerApperance.anInt856;
                    widget.modelSineRotationX = sineAmount + widget.modelSineRotationX & 0x7ff;
                    widget.modelCosineRotationX = widget.modelCosineRotationX + cosineAmount & 0x7ff;
                }
            }
        }
        return bool;
    }

    public static void method460(int i, int insetX, int boundUpperX, int insetY, int boundLowerY, int i_23_, int mousePositionY, int i_25_, int boundLowerX, Widget[] widgets, int mousePositionX, int boundUpperY) {
        if (boundLowerX <= mousePositionX && boundLowerY <= mousePositionY && mousePositionX < boundUpperX && boundUpperY > mousePositionY) {
            for (int i_29_ = 0; i_29_ < widgets.length; i_29_++) {
                Widget widget = widgets[i_29_];
                if (widget != null && i_23_ == widget.anInt2050 && (!widget.isNewFormat || !widget.method754(HashTable.aBoolean361))) {
                    int widgetBoundLowerX = widget.displayOffsetX + (boundLowerX - insetX);
                    int widgetBoundLowerY = widget.displayOffsetY + (boundLowerY - insetY);
                    if ((widget.anInt2057 >= 0 || widget.anInt2041 != 0) && widgetBoundLowerX <= mousePositionX && mousePositionY >= widgetBoundLowerY && widgetBoundLowerX + widget.width > mousePositionX && mousePositionY < widget.height + widgetBoundLowerY) {
                        if (widget.anInt2057 < 0) {
                            GouraudVertex.anInt904 = i_29_;
                        } else {
                            GouraudVertex.anInt904 = widget.anInt2057;
                        }
                    }
                    if (widget.type == 8 && widgetBoundLowerX <= mousePositionX  && mousePositionY >= widgetBoundLowerY && widget.width + widgetBoundLowerX > mousePositionX && widgetBoundLowerY + widget.height > mousePositionY) {
                        Projectile.anInt2197 = i_29_;
                    }
                    if (widget.type == 0) {
                        if (!widget.isNewFormat && widget.method754(HashTable.aBoolean361) && !ItemDefinition.method473(i_25_, -1, i_29_)) {
                            continue;
                        }
                        method460(-1, widget.scrollX, widgetBoundLowerX + widget.width, widget.scrollY, widgetBoundLowerY, widget.id, mousePositionY, i_25_, widgetBoundLowerX, widgets, mousePositionX, widgetBoundLowerY + widget.height);
                        if (widget.children != null) {
                            method460(-1, widget.scrollX, widget.width + widgetBoundLowerX, widget.scrollY, widgetBoundLowerY, widget.id, mousePositionY, i_25_, widgetBoundLowerX, (widget.children), mousePositionX, widgetBoundLowerY + widget.height);
                        }
                        if ((widget.height < widget.anInt2095) && !widget.isNewFormat) {
                            method456((byte) 121,
                                    widgetBoundLowerX + widget.width,
                                    mousePositionX, mousePositionY, i_25_,
                                    widget.height, widgetBoundLowerY,
                                    widget.anInt2095,
                                    widget);
                        }
                        if (!widget.isNewFormat) {
                            continue;
                        }
                    }
                    if (widget.anInt2089 == 1 && mousePositionX >= widgetBoundLowerX && mousePositionY >= widgetBoundLowerY && mousePositionX < widget.width + widgetBoundLowerX && widget.height + widgetBoundLowerY > mousePositionY) {
                        boolean bool = false;
                        if (widget.anInt2078 != 0) {
                            bool = Class39_Sub5_Sub9.method602(widget, true);
                        }
                        if (!bool) {
                            JString.queueAction(20, 0, 0,
                                    widget.id, widget.aClass3_2068,
                                    Class66.blankString);
                        }
                    }
                    if (widget.anInt2089 == 2
                            && !ISAAC.aBoolean1100 && widgetBoundLowerX <= mousePositionX
                            && widgetBoundLowerY <= mousePositionY
                            && widget.width + widgetBoundLowerX > mousePositionX
                            && widget.height + widgetBoundLowerY > mousePositionY) {
                        JString class3 = widget.method762(HashTable.aBoolean361);
                        if (class3 != null) {
                            StillObject.anInt1473++;
                            JString.queueAction(14, 0, -1,
                                    widget.id, class3,
                                    (Class39_Sub5_Sub11.join((new JString[]{Class41.greenPrefixJstr,
                                        (widget.aClass3_2066)}))));
                        }
                    }
                    if (widget.anInt2089 == 3 && mousePositionX >= widgetBoundLowerX
                            && mousePositionY >= widgetBoundLowerY
                            && widgetBoundLowerX + widget.width > mousePositionX
                            && widget.height + widgetBoundLowerY > mousePositionY) {
                        int i_32_;
                        if (i_25_ == 3) {
                            i_32_ = 24;
                        } else {
                            i_32_ = 29;
                        }
                        JString.queueAction(i_32_, 0, 0,
                                widget.id, StillGraphic.aClass3_2343,
                                Class66.blankString);
                    }
                    if (widget.anInt2089 == 4 && mousePositionX >= widgetBoundLowerX
                            && mousePositionY >= widgetBoundLowerY
                            && widgetBoundLowerX + widget.width > mousePositionX
                            && widgetBoundLowerY + widget.height > mousePositionY) {
                        JString.queueAction(36, 0, 0,
                                widget.id, widget.aClass3_2068,
                                Class66.blankString);
                    }
                    if (widget.anInt2089 == 5 && widgetBoundLowerX <= mousePositionX
                            && widgetBoundLowerY <= mousePositionY
                            && mousePositionX < widget.width + widgetBoundLowerX
                            && mousePositionY < widget.height + widgetBoundLowerY) {
                        JString.queueAction(41, 0, 0,
                                widget.id, widget.aClass3_2068,
                                Class66.blankString);
                    }
                    if (widget.anInt2089 == 6
                            && Class39_Sub10.anInt1420 == -1 && widgetBoundLowerX <= mousePositionX
                            && widgetBoundLowerY <= mousePositionY
                            && widgetBoundLowerX + widget.width > mousePositionX
                            && widgetBoundLowerY + widget.height > mousePositionY) {
                        Class4.anInt65++;
                        JString.queueAction(8, 0, -1,
                                widget.id, widget.aClass3_2068,
                                Class66.blankString);
                    }
                    if (widget.type == 2) {
                        int slot = 0;
                        for (int i_34_ = 0; widget.height > i_34_; i_34_++) {
                            for (int i_35_ = 0; widget.width > i_35_; i_35_++) {
                                int positionX = ((widget.itemOffsetX + 32) * i_35_ + widgetBoundLowerX);
                                int positionY = ((widget.itemOffsetY + 32) * i_34_ + widgetBoundLowerY);
                                if (slot < 20) {                                    
                                    positionX += (widget.itemOffsetsX[slot]);
                                    positionY += (widget.itemOffsetsY[slot]);
                                }
                                if (positionX <= mousePositionX && mousePositionY >= positionY && positionX + 32 > mousePositionX && positionY + 32 > mousePositionY) {
                                    Class41.anInt768 = widget.id;
                                    Class14.swapSlotTo = slot;
                                    if ((widget.itemIds[slot]) > 0) {
                                        ItemDefinition itemDefinition = (Class26.getItemDefinition((widget.itemIds[slot]) - 1));
                                        if (Class13.anInt208 == 1 && widget.displayItemOptions()) {
                                            if ((widget.id != Class39_Sub10.useWithItemWidgetId) || slot != Class23.useWithItemSlot) {
                                                JString.queueAction(18, (itemDefinition.id), slot,  (widget.id), (Mob.useJstr), (Class39_Sub5_Sub11.join((new JString[]{(Class39_Sub10.useWithItemJstr), HashTable.aClass3_375, (itemDefinition.name)}))));
                                            }
                                        } else if (!ISAAC.aBoolean1100 || !widget.displayItemOptions()) {
                                            JString[] options = (itemDefinition.widgetOptions);
                                            if (PlayerApperance.displayOptionIds) {
                                                options = (BufferedFile.method225(options));
                                            }
                                            if (widget.displayItemOptions()) {
                                                for (int i_38_ = 4; i_38_ >= 3;
                                                        i_38_--) {
                                                    if (options == null
                                                            || (options[i_38_]
                                                            == null)) {
                                                        if (i_38_ == 4) {
                                                            JString.queueAction(19, (itemDefinition.id), slot,
                                                                    (widget.id), (ItemContainer.dropJstr),
                                                                    (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                                        (itemDefinition.name)}))));
                                                        }
                                                    } else {
                                                        int i_39_;
                                                        if (i_38_ == 3) {
                                                            i_39_ = 32;
                                                        } else {
                                                            i_39_ = 19;
                                                        }
                                                        JString.queueAction(i_39_, (itemDefinition.id), slot,
                                                                (widget.id), options[i_38_],
                                                                (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                                    (itemDefinition.name)}))));
                                                    }
                                                }
                                            }
                                            if (widget.method758(i ^ ~0x51)) {
                                                JString.queueAction(23, (itemDefinition.id), slot,
                                                        (widget.id), (Mob.useJstr),
                                                        (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                            (itemDefinition.name)}))));
                                            }
                                            if (widget.displayItemOptions() && options != null) {
                                                for (int id = 2; id >= 0; id--) {
                                                    if (options[id] != null) {
                                                        int type = 0;
                                                        if (id == 0) {
                                                            type = 28;
                                                        }
                                                        if (id == 1) {
                                                            type = 16;
                                                        }
                                                        if (id == 2) {
                                                            type = 54;
                                                        }
                                                        JString.queueAction(type, (itemDefinition.id), slot,
                                                                (widget.id), options[id],
                                                                (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                                    (itemDefinition.name)}))));
                                                    }
                                                }
                                            }
                                            options = (widget.itemOptions);
                                            if (PlayerApperance.displayOptionIds) {
                                                options = (BufferedFile.method225(options));
                                            }
                                            if (options != null) {
                                                for (int i_42_ = 4; i_42_ >= 0;
                                                        i_42_--) {
                                                    if (options[i_42_]
                                                            != null) {
                                                        int i_43_ = 0;
                                                        if (i_42_ == 0) {
                                                            i_43_ = 35;
                                                        }
                                                        if (i_42_ == 1) {
                                                            i_43_ = 30;
                                                        }
                                                        if (i_42_ == 2) {
                                                            i_43_ = 26;
                                                        }
                                                        if (i_42_ == 3) {
                                                            i_43_ = 25;
                                                        }
                                                        if (i_42_ == 4) {
                                                            i_43_ = 49;
                                                        }
                                                        JString.queueAction(i_43_, (itemDefinition.id), slot,
                                                                (widget.id), options[i_42_],
                                                                (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                                    (itemDefinition.name)}))));
                                                    }
                                                }
                                            }
                                            JString.queueAction(1004, itemDefinition.id, slot,
                                                    widget.id, (JRuntimeException.examineJstr),
                                                    (Class39_Sub5_Sub11.join((new JString[]{(FrameBuffer.lrePrefixJstr),
                                                        (itemDefinition.name)}))));
                                        } else if ((Class41.anInt776 & 0x10)
                                                == 16) {
                                            JString.queueAction(5, itemDefinition.id, slot,
                                                    widget.id, TextConstants.aClass3_1273,
                                                    (Class39_Sub5_Sub11.join((new JString[]{Class14.aClass3_216,
                                                        HashTable.aClass3_375,
                                                        (itemDefinition.name)}))));
                                        }
                                    }
                                }
                                slot++;
                            }
                        }
                    }
                    if (widget.isNewFormat) {
                        if (ISAAC.aBoolean1100) {
                            if (widget.method750(12117) && (Class41.anInt776 & 0x20) == 32
                                    && mousePositionX >= widgetBoundLowerX && mousePositionY >= widgetBoundLowerY
                                    && widgetBoundLowerX + widget.width > mousePositionX
                                    && (widget.height + widgetBoundLowerY
                                    > mousePositionY)) {
                                JString.queueAction(39, 0, widget.amountChildren,
                                        widget.id, TextConstants.aClass3_1273,
                                        (Class39_Sub5_Sub11.join((new JString[]{Class14.aClass3_216,
                                            Class12.aClass3_192,
                                            (widget.aClass3_2065)}))));
                            }
                        } else if (mousePositionX >= widgetBoundLowerX && widgetBoundLowerY <= mousePositionY && (widget.width + widgetBoundLowerX > mousePositionX) && mousePositionY < (widget.height + widgetBoundLowerY)) {
                            for (int i_44_ = 9; i_44_ >= 5; i_44_--) {
                                JString class3 = (widget.method771(HashTable.aBoolean361,
                                        (byte) 50, i_44_));
                                if (class3 != null) {
                                    Class39_Sub12.anInt1490++;
                                    JString.queueAction(51, i_44_ + 1, widget.amountChildren,
                                            widget.id, class3,
                                            widget.aClass3_2065);
                                }
                            }
                            JString class3 = widget.method762(HashTable.aBoolean361);
                            if (class3 != null) {
                                StillObject.anInt1473++;
                                JString.queueAction(14, 0, widget.amountChildren,
                                        widget.id, class3,
                                        (widget.aClass3_2065));
                            }
                            for (int i_45_ = 4; i_45_ >= 0; i_45_--) {
                                JString class3_46_ = (widget.method771(HashTable.aBoolean361, (byte) -105,
                                        i_45_));
                                if (class3_46_ != null) {
                                    Class39_Sub12.anInt1490++;
                                    JString.queueAction(51, i_45_ + 1, widget.amountChildren,
                                            widget.id, class3_46_,
                                            widget.aClass3_2065);
                                }
                            }
                            if (widget.method768(125)) {
                                Class4.anInt65++;
                                JString.queueAction(8, 0, -1,
                                        widget.id, (widget.aClass3_2068),
                                        Class66.blankString);
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        ScriptExecutor.stateStack = new ScriptState[50];
        odBlockOffset = 0;
        mouseClickPositionX = 0;
        anInt1336 = 0;
        aClass3_1339 = JString.create(")3");
        aClass3_1328 = aClass3_1324;
        aClass3_1333 = JString.create("Connecting to server)3)3)3");
        aClass3_1334 = aClass3_1333;
        aClass3_1340 = JString.create("backvmid2");
        aClass3_1332 = JString.create("System update in: ");
        aClass3_1326 = aClass3_1332;
    }
}
