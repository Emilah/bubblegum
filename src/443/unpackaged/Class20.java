package unpackaged;

import com.jagex.graphics.TriangleRasterizer;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.config.Model;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.sign.Resource;
import com.jagex.od.OndemandRequest;
import com.jagex.config.ItemDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.FileLoader;
import com.jagex.awt.JApplet;
import com.jagex.io.CacheIO;
import com.jagex.graphics.BitmapFont;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;

/* Class20 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class Class20 {

    public static JString aClass3_387;
    public static JString aClass3_388;
    public static JString aClass3_389 = JString.create("(U2");
    public static Resource aClass56_390;
    public static int[][] anIntArrayArray391;
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array392;
    public static int anInt393;
    public static JString aClass3_394;
    public static Class13 aClass13_395;
    public static Deque[][][] groundItems;
    public static int anInt397;

    public static void removeFriend(long l, byte i) {
        if (l != 0L) {
            for (int i_0_ = 0; i_0_ < Class4.anInt62; i_0_++) {
                if (JApplet.aLongArray2[i_0_] == l) {
                    Class39_Sub14.updateTab = true;
                    Class4.anInt62--;
                    for (int i_1_ = i_0_; Class4.anInt62 > i_1_; i_1_++) {
                        Projectile.aClass3Array2188[i_1_] = (Projectile.aClass3Array2188[i_1_ + 1]);
                        Player.anIntArray2533[i_1_] = (Player.anIntArray2533[i_1_ + 1]);
                        JApplet.aLongArray2[i_1_] = JApplet.aLongArray2[i_1_ + 1];
                    }
                    FrameBuffer.outgoingBuffer.putFrame(159);
                    FrameBuffer.outgoingBuffer.putInt64(l);
                    break;
                }
            }
            int i_2_ = -61 / ((-84 - i) / 38);
        }
    }

    public static void method247(byte i) {
        aClass13_395 = null;
        aClass3_387 = null;
        aClass39_Sub5_Sub10_Sub3Array392 = null;
        aClass56_390 = null;
        aClass3_388 = null;
        aClass3_394 = null;
        aClass3_389 = null;
        anIntArrayArray391 = null;
        groundItems = null;
    }

    public static boolean drawWidgets(Widget[] widgets, int i, int i_3_, int i_4_,
            int drawY, int i_6_, int width, int i_8_, int height, int drawX) {
        DrawingArea.setDimensions(drawX, drawY, width, height);
        boolean bool = true;
        for (int i_11_ = 0; i_11_ < widgets.length; i_11_++) {
            Widget widget = widgets[i_11_];
            if (widget != null
                    && widget.anInt2050 == i_4_) {
                if (widget.anInt2078 > 0) {
                    CacheIO.method123(widget, 114);
                }
                int x = widget.displayOffsetX + (drawX - i_6_);
                int y = widget.displayOffsetY + (drawY - i_3_);
                int fillAlpha = widget.alpha;
                if (NpcDefinition.aClass39_Sub5_Sub17_1864
                        == widget) {
                    Widget class39_sub5_sub17_15_ = Class44.method914(widget, (byte) -126);
                    if (class39_sub5_sub17_15_ == null) {
                        NpcDefinition.aClass39_Sub5_Sub17_1864 = null;
                    } else {
                        int[] is = Class65.method1094(-6622,
                                class39_sub5_sub17_15_);
                        int[] is_16_ = Class65.method1094(i_8_ ^ ~0x3fae,
                                widget);
                        if (!widget.aBoolean2108) {
                            fillAlpha = 128;
                        }
                        int i_17_ = Class33.mousePositionY - FileLoader.anInt1303;
                        int i_18_ = -ItemDefinition.anInt1684 + ISAAC.mousePositionX;
                        if (i_18_ <= widget.anInt2056
                                && -widget.anInt2056 <= i_18_
                                && i_17_ <= widget.anInt2056
                                && i_17_ >= -widget.anInt2056
                                && !Class37.aBoolean654) {
                            i_18_ = 0;
                            i_17_ = 0;
                        } else if ((widget.anInt2008
                                < JApplet.anInt8)
                                || Class37.aBoolean654) {
                            Class37.aBoolean654 = true;
                        } else {
                            i_17_ = 0;
                            i_18_ = 0;
                        }
                        int i_19_ = is_16_[1] - is[1] + i_17_;
                        if (i_19_ < 0) {
                            i_19_ = 0;
                        }
                        int i_20_ = i_18_ + is_16_[0] - is[0];
                        if (i_20_ < 0) {
                            i_20_ = 0;
                        }
                        if (widget.width + i_20_
                                > class39_sub5_sub17_15_.width) {
                            i_20_ = (class39_sub5_sub17_15_.width
                                    - widget.width);
                        }
                        if (class39_sub5_sub17_15_.height
                                < i_19_ + widget.height) {
                            i_19_ = (class39_sub5_sub17_15_.height
                                    - widget.height);
                        }
                        x = i_20_ + is[0];
                        y = i_19_ + is[1];
                    }
                }
                if ((!widget.isNewFormat
                        || (x <= DrawingArea.areaWidth
                        && y <= DrawingArea.areaHeight
                        && (DrawingArea.areaOffsetX
                        <= x + widget.width)
                        && (DrawingArea.areaOffsetY
                        <= y + widget.height)))
                        && (!widget.isNewFormat
                        || !widget.method754(HashTable.aBoolean361))) {
                    if (widget.type == 0) {
                        if (!widget.isNewFormat
                                && widget.method754(HashTable.aBoolean361)
                                && !ItemDefinition.method473(i, -1, i_11_)) {
                            continue;
                        }
                        if (!widget.isNewFormat) {
                            if (widget.scrollY
                                    > (-widget.height
                                    + widget.anInt2095)) {
                                widget.scrollY = (-widget.height
                                        + widget.anInt2095);
                            }
                            if (widget.scrollY < 0) {
                                widget.scrollY = 0;
                            }
                        }
                        bool &= drawWidgets(widgets, i,
                                widget.scrollY,
                                widget.id, y,
                                widget.scrollX,
                                x + widget.width,
                                i_8_,
                                widget.height + y,
                                x);
                        if (widget.children
                                != null) {
                            bool &= drawWidgets((widget.children),
                                    i, widget.scrollY,
                                    widget.id,
                                    y,
                                    widget.scrollX,
                                    (widget.width
                                    + x),
                                    9843,
                                    (y
                                    + widget.height),
                                    x);
                        }
                        DrawingArea.setDimensions(drawX, drawY, width, height);
                        if ((widget.height
                                < widget.anInt2095)
                                && !widget.isNewFormat) {
                            Class4.method102((widget.width
                                    + x),
                                    widget.scrollY,
                                    widget.anInt2095,
                                    y, 18734,
                                    widget.height);
                        }
                    }
                    if (widget.type != 1) {
                        if (widget.type == 2) {
                            int i_21_ = 0;
                            for (int itemY = 0; itemY < widget.height; itemY++) {
                                for (int itemX = 0; widget.width > itemX; itemX++) {
                                    int positionX = x + (widget.itemOffsetX + 32) * itemX;
                                    int positionY = ((widget.itemOffsetY + 32) * itemY + y);
                                    if (i_21_ < 20) {
                                        positionY += (widget.itemOffsetsY[i_21_]);
                                        positionX += (widget.itemOffsetsX[i_21_]);
                                    }
                                    if ((widget.itemIds[i_21_]) > 0) {
                                        int itemId = ((widget.itemIds[i_21_]) - 1);
                                        boolean bool_27_ = false;
                                        boolean bool_28_ = false;
                                        if (((DrawingArea.areaOffsetX - 32 < positionX) && (DrawingArea.areaWidth > positionX) && positionY > (DrawingArea.areaOffsetY) - 32 && (DrawingArea.areaHeight > positionY)) || (Class30.anInt534 != 0 && i_21_ == (ArchiveRequest.swapSlotFrom))) {
                                            DirectColorSprite sprite;
                                            if (Class13.anInt208 != 1 || i_21_ != Class23.useWithItemSlot || ((widget.id) != (Class39_Sub10.useWithItemWidgetId))) {
                                                sprite = (FrameBuffer.getItemSprite(itemId, 3153952, false, (widget.itemAmounts[i_21_]), i_8_ ^ 0x264d, 1));
                                            } else {
                                                sprite = (FrameBuffer.getItemSprite(itemId, 0, false, (widget.itemAmounts[i_21_]), 115, 2));
                                            }
                                            if (sprite == null) {
                                                bool = false;
                                            } else if (Class30.anInt534 != 0
                                                    && (ArchiveRequest.swapSlotFrom
                                                    == i_21_)
                                                    && (ArchiveWorker.swapWidgetHash
                                                    == (widget.id))) {
                                                int mouseDeltaY = (Class33.mousePositionY
                                                        - (OndemandRequest.itemClickPositionY));
                                                if (mouseDeltaY < 5 && mouseDeltaY > -5) {
                                                    mouseDeltaY = 0;
                                                }
                                                int mouseDeltaX = (ISAAC.mousePositionX
                                                        - (ClientScript.itemClickPositionX));
                                                if (mouseDeltaX < 5 && mouseDeltaX > -5) {
                                                    mouseDeltaX = 0;
                                                }
                                                if ((Widget.anInt2031)
                                                        < 5) {
                                                    mouseDeltaX = 0;
                                                    mouseDeltaY = 0;
                                                }
                                                sprite.method676(mouseDeltaX + positionX,
                                                        mouseDeltaY + positionY, 128);
                                                if (i_4_ != -1) {
                                                    Widget class39_sub5_sub17_31_ = (widgets[i_4_ & 0xffff]);
                                                    if (((DrawingArea.areaOffsetY)
                                                            > mouseDeltaY + positionY)
                                                            && (class39_sub5_sub17_31_.scrollY) > 0) {
                                                        int i_32_ = ((-mouseDeltaY
                                                                + ((DrawingArea.areaOffsetY)
                                                                - positionY))
                                                                * (PlayerApperance.anInt856)
                                                                / 3);
                                                        if (i_32_
                                                                > (PlayerApperance.anInt856
                                                                * 10)) {
                                                            i_32_ = ((PlayerApperance.anInt856)
                                                                    * 10);
                                                        }
                                                        if ((class39_sub5_sub17_31_.scrollY)
                                                                < i_32_) {
                                                            i_32_ = (class39_sub5_sub17_31_.scrollY);
                                                        }
                                                        OndemandRequest.itemClickPositionY += i_32_;
                                                        class39_sub5_sub17_31_.scrollY -= i_32_;
                                                    }
                                                    if (((DrawingArea.areaHeight)
                                                            < positionY + mouseDeltaY + 32)
                                                            && ((class39_sub5_sub17_31_.scrollY)
                                                            < (-(class39_sub5_sub17_31_.height)
                                                            + (class39_sub5_sub17_31_.anInt2095)))) {
                                                        int i_33_ = ((-(DrawingArea.areaHeight)
                                                                + (mouseDeltaY
                                                                + positionY)
                                                                + 32)
                                                                * (PlayerApperance.anInt856)
                                                                / 3);
                                                        if (i_33_
                                                                > (PlayerApperance.anInt856
                                                                * 10)) {
                                                            i_33_ = ((PlayerApperance.anInt856)
                                                                    * 10);
                                                        }
                                                        if ((-(class39_sub5_sub17_31_.scrollY)
                                                                + (-(class39_sub5_sub17_31_.height)
                                                                + (class39_sub5_sub17_31_.anInt2095)))
                                                                < i_33_) {
                                                            i_33_ = (-(class39_sub5_sub17_31_.height)
                                                                    + (class39_sub5_sub17_31_.anInt2095)
                                                                    - (class39_sub5_sub17_31_.scrollY));
                                                        }
                                                        OndemandRequest.itemClickPositionY -= i_33_;
                                                        class39_sub5_sub17_31_.scrollY += i_33_;
                                                    }
                                                }
                                            } else if (Class25.anInt459 == 0
                                                    || (i_21_
                                                    != (Class39_Sub5_Sub5.anInt1739))
                                                    || (Class65.anInt1137
                                                    != (widget.id))) {
                                                sprite.method670(positionX, positionY);
                                            } else {
                                                sprite.method676(positionX, positionY, 128);
                                            }
                                        }
                                    } else if ((widget.defaultSpriteIds) != null
                                            && i_21_ < 20) {
                                        DirectColorSprite sprite = (widget.method759(i_21_, i_8_ ^ ~0x2673));
                                        if (sprite == null) {
                                            if (Class39_Sub5_Sub12.aBoolean1856) {
                                                bool = false;
                                            }
                                        } else {
                                            sprite.method670(positionX, positionY);
                                        }
                                    }
                                    i_21_++;
                                }
                            }
                        } else if (widget.type == 3) {
                            int color;
                            if (Huffman.parseClientScript(widget)) {
                                color = widget.activeColor;
                                if (ItemDefinition.method473(i, i_8_ - 9844, i_11_) && widget.anInt2086 != 0) {
                                    color = widget.anInt2086;
                                }
                            } else {
                                color = widget.inactiveColor;
                                if (ItemDefinition.method473(i, -1, i_11_) && widget.anInt2041 != 0) {
                                    color = widget.anInt2041;
                                }
                            }
                            if (fillAlpha == 0) {
                                if (!widget.drawSolidQuad) {
                                    DrawingArea.drawQuadOutline(x, y, widget.width, widget.height, color);
                                } else {
                                    DrawingArea.drawQuad(x, y, widget.width, widget.height, color);
                                }
                            } else if (widget.drawSolidQuad) {
                                DrawingArea.drawQuadOverlay(x, y, widget.width, widget.height, color, 256 - (fillAlpha & 0xff));
                            } else {
                                DrawingArea.drawQuadOutlineOverlay(x, y, widget.width, widget.height, color, -(fillAlpha & 0xff) + 256);
                            }
                        } else if (widget.type == 4) {
                            BitmapFont font = widget.getFont();
                            if (font == null) {
                                if (Class39_Sub5_Sub12.aBoolean1856) {
                                    bool = false;
                                }
                            } else {
                                JString jstr = widget.inactiveText;
                                int color;
                                if (!Huffman.parseClientScript(widget)) {
                                    color = widget.inactiveColor;
                                    if (ItemDefinition.method473(i, -1, i_11_) && widget.anInt2041 != 0) {
                                        color = widget.anInt2041;
                                    }
                                } else {
                                    color = widget.activeColor;
                                    if (ItemDefinition.method473(i, -1,
                                            i_11_)
                                            && widget.anInt2086 != 0) {
                                        color = widget.anInt2086;
                                    }
                                    if (widget.activeText.getLength()
                                            > 0) {
                                        jstr = widget.activeText;
                                    }
                                }
                                if (widget.isNewFormat && widget.anInt1997 != -1) {
                                    ItemDefinition itemDefinition = Class26.getItemDefinition((widget.anInt1997));
                                    jstr = itemDefinition.name;
                                    if (jstr == null) {
                                        jstr = Wall.nullJstr;
                                    }
                                    if ((itemDefinition.anInt1662 == 1 || widget.anInt2096 != 1) && widget.anInt2096 != -1) {
                                        jstr = (Class39_Sub5_Sub11.join((new JString[]{ jstr, Class15.xJstr, (Class62_Sub2.method1083((widget.anInt2096)))})));
                                    }
                                }
                                if ((widget.id == Class39_Sub10.anInt1420) && (JString.anInt1231  == widget.amountChildren)) {
                                    jstr = Class39_Sub5_Sub4_Sub2.aClass3_2230;
                                    color = widget.inactiveColor;
                                }
                                if (DrawingArea.bufferWidth == 479) {
                                    if (color == 16776960) {
                                        color = 255;
                                    }
                                    if (color == 49152) {
                                        color = 16777215;
                                    }
                                }
                                jstr = Class50.method972(widget,
                                        0, jstr);
                                font.method625(jstr, x, y,
                                        widget.width,
                                        widget.height, color,
                                        widget.drawShadow,
                                        widget.anInt2032,
                                        widget.anInt1996,
                                        widget.anInt2036);
                            }
                        } else if (widget.type == 5) {
                            if (!widget.isNewFormat) {
                                DirectColorSprite class39_sub5_sub10_sub3 = (widget.getSprite(Huffman.parseClientScript(widget)));
                                if (class39_sub5_sub10_sub3 == null) {
                                    if (Class39_Sub5_Sub12.aBoolean1856) {
                                        bool = false;
                                    }
                                } else {
                                    class39_sub5_sub10_sub3.method670(x,
                                            y);
                                }
                            } else {
                                DirectColorSprite sprite;
                                if (widget.anInt1997 != -1) {
                                    sprite = (FrameBuffer.getItemSprite(widget.anInt1997,
                                            widget.anInt2003,
                                            false,
                                            widget.anInt2096, 68,
                                            widget.anInt2022));
                                } else {
                                    sprite = widget.getSprite(false);
                                }
                                if (sprite == null) {
                                    if (Class39_Sub5_Sub12.aBoolean1856) {
                                        bool = false;
                                    }
                                } else {
                                    int i_36_ = sprite.anInt2475;
                                    int i_37_ = sprite.anInt2477;
                                    if (!widget.aBoolean2014) {
                                        int i_38_ = (widget.width
                                                * 4096 / i_36_);
                                        if (widget.anInt2051 != 0) {
                                            sprite.method684(x + (widget.width) / 2,
                                                    (widget.height
                                                    / 2) + y,
                                                    widget.anInt2051,
                                                    i_38_);
                                        } else if (fillAlpha != 0) {
                                            sprite.method680(x, y,
                                                    widget.width,
                                                    widget.height,
                                                    256 - (fillAlpha & 0xff));
                                        } else if ((widget.width
                                                != i_36_)
                                                || (widget.height) != i_37_) {
                                            sprite.method687(x, y,
                                                    widget.width,
                                                    widget.height);
                                        } else {
                                            sprite.method670(x, y);
                                        }
                                    } else {
                                        int i_39_ = x;
                                        int[] is = new int[4];
                                        DrawingArea.getDimensions(is);
                                        if (i_39_ < is[0]) {
                                            i_39_ = is[0];
                                        }
                                        int i_40_ = y;
                                        if (i_40_ < is[1]) {
                                            i_40_ = is[1];
                                        }
                                        int i_41_ = (widget.width
                                                + x);
                                        int i_42_ = (widget.height
                                                + y);
                                        if (is[3] < i_42_) {
                                            i_42_ = is[3];
                                        }
                                        if (is[2] < i_41_) {
                                            i_41_ = is[2];
                                        }
                                        DrawingArea.setDimensions(i_39_,
                                                i_40_,
                                                i_41_,
                                                i_42_);
                                        int i_43_ = ((widget.height
                                                + i_37_ - 1)
                                                / i_37_);
                                        int i_44_ = ((widget.width
                                                - (-i_36_ + 1))
                                                / i_36_);
                                        for (int i_45_ = 0; i_45_ < i_44_;
                                                i_45_++) {
                                            for (int i_46_ = 0; i_43_ > i_46_;
                                                    i_46_++) {
                                                if ((widget.anInt2051)
                                                        != 0) {
                                                    sprite.method684((i_45_ * i_36_ + x
                                                            + i_36_ / 2),
                                                            (y + i_37_ * i_46_
                                                            + i_37_ / 2),
                                                            (widget.anInt2051),
                                                            4096);
                                                } else if (fillAlpha != 0) {
                                                    sprite.method676(x + i_45_ * i_36_,
                                                            i_37_ * i_46_ + y,
                                                            (-(fillAlpha & 0xff)
                                                            + 256));
                                                } else {
                                                    sprite.method670(i_45_ * i_36_ + x,
                                                            (i_46_ * i_37_
                                                            + y));
                                                }
                                            }
                                        }
                                        DrawingArea.setDimensions(is);
                                    }
                                }
                            }
                        } else if (widget.type == 6) {
                            boolean bool_47_ = Huffman.parseClientScript(widget);
                            int i_48_;
                            if (bool_47_) {
                                i_48_ = widget.anInt2052;
                            } else {
                                i_48_ = widget.anInt2103;
                            }
                            Object object = null;
                            Model model;
                            if (widget.inactiveModelType == 5) {
                                if (widget.inactiveAnimationModelId == 0) {
                                    model = (ClientScript.playerApperance.method922(-27537, null, null, -1, -1));
                                } else {
                                    model = Cache.localPlayer.method489(true);
                                }
                            } else if (i_48_ == -1) {
                                model = (widget.method775(i_8_ - 9861, -1, bool_47_,
                                        (Cache.localPlayer.aClass45_2516),
                                        null));
                                if (model == null
                                        && Class39_Sub5_Sub12.aBoolean1856) {
                                    bool = false;
                                }
                            } else {
                                Class39_Sub5_Sub11 class39_sub5_sub11 = AbstractMidiHandler.method1064(i_48_,
                                        (byte) 54);
                                model = (widget.method775(-99, widget.anInt1999,
                                        bool_47_,
                                        (Cache.localPlayer.aClass45_2516),
                                        class39_sub5_sub11));
                                if (model == null
                                        && Class39_Sub5_Sub12.aBoolean1856) {
                                    bool = false;
                                }
                            }
                            int i_49_ = widget.modelCosineRotationX;
                            int i_50_ = widget.modelSineRotationX;
                            int i_51_ = widget.anInt2007;
                            int i_52_ = widget.anInt2072;
                            int i_53_ = widget.anInt2058;
                            int i_54_ = widget.modelRotationY;
                            if (widget.anInt1997 != -1) {
                                ItemDefinition item = Class26.getItemDefinition((widget.anInt1997));
                                if (item != null) {
                                    item = (item.method476(widget.anInt2096,
                                            (byte) 71));
                                    model = item.getModel(1, true, (byte) -123);
                                    i_52_ = item.anInt1674;
                                    i_54_ = item.anInt1649;
                                    i_49_ = item.anInt1669;
                                    i_51_ = item.anInt1656;
                                    i_53_ = item.anInt1654;
                                    if (widget.width > 0) {
                                        i_54_ = (i_54_ * 32
                                                / widget.width);
                                    }
                                    i_50_ = item.anInt1676;
                                }
                            }
                            TriangleRasterizer.method659(x + widget.width / 2,
                                    y + widget.height / 2);
                            int i_55_ = ((TriangleRasterizer.cosineTable[i_49_]) * i_54_
                                    >> 16);
                            int i_56_ = ((TriangleRasterizer.sineTable[i_49_]) * i_54_
                                    >> 16);
                            if (model != null) {
                                if (!widget.isNewFormat) {
                                    model.method549(0, i_50_,
                                            0, i_49_,
                                            0, i_56_,
                                            i_55_);
                                } else {
                                    model.updateDimensions();
                                    if (widget.aBoolean2081) {
                                        model.render(0, i_50_, i_51_, i_49_, i_52_,
                                                (model.anInt1726
                                                / 2) + i_56_ + i_53_,
                                                i_55_ + i_53_, i_54_);
                                    } else {
                                        model.method549(0, i_50_, i_51_, i_49_, i_52_,
                                                i_53_ + (model.anInt1726) / 2 + i_56_,
                                                i_55_ + i_53_);
                                    }
                                }
                            }
                            TriangleRasterizer.method654();
                        } else {
                            if (widget.type == 7) {
                                BitmapFont font = widget.getFont();
                                if (font == null) {
                                    if (Class39_Sub5_Sub12.aBoolean1856) {
                                        bool = false;
                                    }
                                    continue;
                                }
                                int i_57_ = 0;
                                for (int i_58_ = 0;
                                        i_58_ < widget.height;
                                        i_58_++) {
                                    for (int i_59_ = 0;
                                            i_59_ < widget.width;
                                            i_59_++) {
                                        if ((widget.itemIds[i_57_])
                                                > 0) {
                                            ItemDefinition itemDefinition = (Class26.getItemDefinition((widget.itemIds[i_57_]) - 1));
                                            JString jstr = (itemDefinition.name);
                                            if (jstr == null) {
                                                jstr = Wall.nullJstr;
                                            }
                                            if ((itemDefinition.anInt1662
                                                    == 1)
                                                    || ((widget.itemAmounts[i_57_])
                                                    != 1)) {
                                                jstr = (Class39_Sub5_Sub11.join((new JString[]{jstr,
                                                            Class15.xJstr,
                                                            (Class62_Sub2.method1083((widget.itemAmounts[i_57_])))})));
                                            }
                                            int i_60_ = ((i_59_
                                                    * (115
                                                    + (widget.itemOffsetX)))
                                                    + x);
                                            int i_61_ = (i_58_ * ((widget.itemOffsetY)
                                                    + 12)
                                                    + y);
                                            if (widget.anInt2032
                                                    != 0) {
                                                if ((widget.anInt2032)
                                                        != 1) {
                                                    font.method627(jstr,
                                                            (i_60_
                                                            + (widget.width)
                                                            - 1),
                                                            i_61_,
                                                            (widget.inactiveColor),
                                                            (widget.drawShadow));
                                                } else {
                                                    font.method636(jstr,
                                                            (i_60_
                                                            + (widget.width) / 2),
                                                            i_61_,
                                                            (widget.inactiveColor),
                                                            (widget.drawShadow));
                                                }
                                            } else {
                                                font.method635(jstr, i_60_, i_61_,
                                                        (widget.inactiveColor),
                                                        (widget.drawShadow));
                                            }
                                        }
                                        i_57_++;
                                    }
                                }
                            }
                            if (widget.type == 8
                                    && Class53.method986(i_11_, i, 1)
                                    && (Class30.anInt548
                                    == FrameBuffer.anInt2157)) {
                                int i_62_ = 0;
                                int i_63_ = 0;
                                JString class3 = widget.inactiveText;
                                BitmapFont class39_sub5_sub10_sub1 = (Class39_Sub5_Sub14.p12fullFont);
                                class3 = Class50.method972(widget,
                                        0, class3);
                                while (class3.getLength() > 0) {
                                    int i_64_ = class3.method80(22938,
                                            (Class39_Sub5_Sub9.aClass3_1814));
                                    JString class3_65_;
                                    if (i_64_ != -1) {
                                        class3_65_ = class3.substring(0, i_64_);
                                        class3 = class3.substring(i_64_ + 2);
                                    } else {
                                        class3_65_ = class3;
                                        class3 = Class66.blankString;
                                    }
                                    int i_66_ = class39_sub5_sub10_sub1.method646(class3_65_);
                                    if (i_66_ > i_63_) {
                                        i_63_ = i_66_;
                                    }
                                    i_62_ += (class39_sub5_sub10_sub1.anInt2425
                                            + 1);
                                }
                                i_63_ += 6;
                                int i_67_ = (widget.width - 5
                                        + (x - i_63_));
                                i_62_ += 7;
                                int i_68_ = widget.height + 5 + y;
                                if (height < i_68_ + i_62_) {
                                    i_68_ = -i_62_ + height;
                                }
                                if (x + 5 > i_67_) {
                                    i_67_ = x + 5;
                                }
                                if (width < i_67_ + i_63_) {
                                    i_67_ = -i_63_ + width;
                                }
                                DrawingArea.drawQuad(i_67_, i_68_,
                                        i_63_, i_62_,
                                        16777120);
                                DrawingArea.drawQuadOutline(i_67_, i_68_,
                                        i_63_, i_62_, 0);
                                class3 = widget.inactiveText;
                                int i_69_ = (class39_sub5_sub10_sub1.anInt2425
                                        + 2 + i_68_);
                                class3 = Class50.method972(widget,
                                        0, class3);
                                while (class3.getLength() > 0) {
                                    int i_70_ = class3.method80(i_8_ ^ 0x7fe9,
                                            (Class39_Sub5_Sub9.aClass3_1814));
                                    JString class3_71_;
                                    if (i_70_ != -1) {
                                        class3_71_ = class3.substring(0, i_70_);
                                        class3 = class3.substring(i_70_ + 2);
                                    } else {
                                        class3_71_ = class3;
                                        class3 = Class66.blankString;
                                    }
                                    class39_sub5_sub10_sub1.method635(class3_71_, i_67_ + 3, i_69_, 0,
                                            false);
                                    i_69_ += (class39_sub5_sub10_sub1.anInt2425
                                            + 1);
                                }
                            }
                            if (widget.type == 9) {
                                if (widget.anInt2083 == 1) {
                                    DrawingArea.method612(x, y,
                                            widget.width + x,
                                            y + widget.height,
                                            widget.inactiveColor);
                                } else {
                                    int i_72_ = (widget.width >= 0
                                            ? widget.width
                                            : -widget.width);
                                    int i_73_ = (widget.height >= 0
                                            ? widget.height
                                            : -widget.height);
                                    int i_74_ = i_72_;
                                    if (i_74_ < i_73_) {
                                        i_74_ = i_73_;
                                    }
                                    if (i_74_ != 0) {
                                        int i_75_ = ((widget.width
                                                << 16)
                                                / i_74_);
                                        int i_76_ = ((widget.height
                                                << 16)
                                                / i_74_);
                                        if (i_76_ <= i_75_) {
                                            i_75_ = -i_75_;
                                        } else {
                                            i_76_ = -i_76_;
                                        }
                                        int i_77_ = ((widget.anInt2083
                                                * i_76_)
                                                >> 17);
                                        int i_78_ = (i_76_ * (widget.anInt2083) + 1
                                                >> 17);
                                        int i_79_ = ((widget.anInt2083
                                                * i_75_)
                                                >> 17);
                                        int i_80_ = ((widget.anInt2083
                                                * i_75_) + 1
                                                >> 17);
                                        int i_81_ = i_77_ + x;
                                        int i_82_ = (widget.width
                                                + (x - i_78_));
                                        int i_83_ = (y
                                                + (widget.height
                                                - i_80_));
                                        int i_84_ = -i_80_ + y;
                                        int i_85_ = -i_78_ + x;
                                        int i_86_ = (x
                                                + (widget.width
                                                + i_77_));
                                        int i_87_ = (i_79_ + y
                                                + widget.height);
                                        TriangleRasterizer.method666(i_81_, i_85_, i_82_);
                                        int i_88_ = i_79_ + y;
                                        TriangleRasterizer.method662(i_88_, i_84_, i_83_, i_81_, i_85_,
                                                i_82_,
                                                widget.inactiveColor);
                                        TriangleRasterizer.method666(i_81_, i_82_, i_86_);
                                        TriangleRasterizer.method662(i_88_, i_83_, i_87_, i_81_, i_82_,
                                                i_86_,
                                                widget.inactiveColor);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i_8_ != 9843) {
            return true;
        }
        return bool;
    }

    static {
        aClass3_388 = JString.create("Please try again)3");
        aClass3_394 = JString.create("@or1@");
        anInt393 = 0;
        aClass3_387 = aClass3_388;
        groundItems = new Deque[4][104][104];
        anInt397 = 0;
    }
}
