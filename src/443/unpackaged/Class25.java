package unpackaged;

/* Class25 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.ClassCheckRequest;
import com.jagex.graphics.TriangleRasterizer;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.config.Widget;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Barrier;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveRequest;
import com.jagex.od.OndemandRequest;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.ItemDefinition;
import com.jagex.awt.events.JKeyListener;
import com.jagex.Client;
import com.jagex.awt.JApplet;
import com.jagex.io.CacheIO;
import com.jagex.utils.Bzip2Entry;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.JImage;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.script.ScriptExecutor;
import com.jagex.utils.Cache;
import java.io.IOException;
import java.net.Socket;

public class Class25 {

    public static JString aClass3_457 = JString.create("Remove");
    public static JString aClass3_458;
    public static int anInt459 = 0;
    public static JString aClass3_460;
    public static HashTable priorityRequestsQueue;
    public static JString aClass3_462;
    public static JString aClass3_463 = JString.create("Please contact customer support)3");
    public static JString aClass3_464;
    public static JApplet anApplet_Sub1_465;
    public static JString aClass3_466;
    public static BufferedFile tableFile;
    public static JString aClass3_468;
    public static JString aClass3_469;
    public static JString aClass3_470;
    public static int anInt471;
    public static Huffman huffmans;

    public static void method281(int i, int i_0_, int widgetId, boolean bool) {
        Widget class39_sub5_sub17 = Class62_Sub2.getWidgetChild(widgetId, i_0_);
        if (class39_sub5_sub17 != null
                && class39_sub5_sub17.anObjectArray2099 != null) {
            ScriptExecutor.executeClientScript(0,
                    (class39_sub5_sub17.anObjectArray2099),
                    null, 114, 0, class39_sub5_sub17,
                    0);
        }
        ISAAC.aBoolean1100 = bool;
        MouseRecorder.useWithAmountChildren = i_0_;
        Class41.anInt776 = i;
        Class41.useWithWidgetId = widgetId;
    }

    public static int computeChecksum(byte[] src, int startOff, int endOff) {
        int checksum = -1;
        for (int i = startOff; endOff > i; i++) {
            checksum = (ClassCheckRequest.anIntArray1375[(checksum ^ src[i]) & 0xff] ^ checksum >>> 8);
        }
        checksum ^= 0xffffffff;
        return checksum;
    }

    public static void method283(int i, int mousePositionX, int mousePositionY, int i_9_, int i_10_, int widgetId, int boundUpperX, int height) {
        if (JSocket.loadWidget(widgetId)) {
            Class39_Sub4.method460(-1, 0, boundUpperX, 0, i_9_, -1, mousePositionY, i_10_, i, AbstractMidiHandler.widgets[widgetId], mousePositionX, height);
        }
    }

    public static void parseMapRebuild(boolean bool) {
        Class63.isCustomMap = bool;
        if (!Class63.isCustomMap) {
            int sPositionX = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int mPositionY = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int mPositionX = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            int height = Class39_Sub5_Sub11.incomingBuffer.getUbyte128();
            int counter = ((Huffman.frameSize - Class39_Sub5_Sub11.incomingBuffer.offset) / 16);
            Class14.anIntArrayArray221 = new int[counter][4];
            for (int i_19_ = 0; i_19_ < counter; i_19_++) {
                for (int i_20_ = 0; i_20_ < 4; i_20_++) {
                    Class14.anIntArrayArray221[i_19_][i_20_] = Class39_Sub5_Sub11.incomingBuffer.getDwordA();
                }
            }
            int sPositionY = Class39_Sub5_Sub11.incomingBuffer.getUword128();
            Class65.anIntArray1132 = new int[counter];
            TextureLoaderImpl.anIntArray1255 = new int[counter];
            Cache.aByteArrayArray104 = new byte[counter][];
            VarpDefinition.aByteArrayArray1989 = new byte[counter][];
            boolean isLoaded = false;
            ItemDefinition.anIntArray1682 = new int[counter];
            counter = 0;
            if ((sPositionX / 8 == 48 || sPositionX / 8 == 49) && sPositionY / 8 == 48) {
                isLoaded = true;
            }
            if (sPositionX / 8 == 48 && sPositionY / 8 == 148) {
                isLoaded = true;
            }
            for (int x = (sPositionX - 6) / 8; (sPositionX + 6) / 8 >= x;
                    x++) {
                for (int y = (sPositionY - 6) / 8; y <= (sPositionY + 6) / 8; y++) {
                    int i_25_ = (x << 8) + y;
                    if (!isLoaded || (y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47))) {
                        Class65.anIntArray1132[counter] = i_25_;
                        ItemDefinition.anIntArray1682[counter] = (JSocket.fileLoader5.lookupArchive((Class39_Sub5_Sub11.join((new JString[]{JApplet.mJstr, AbstractImage.toJstr(x), Class32.underscoreJstr, AbstractImage.toJstr(y)})))));
                        TextureLoaderImpl.anIntArray1255[counter] = (JSocket.fileLoader5.lookupArchive((Class39_Sub5_Sub11.join((new JString[]{ObjectDefinition.aClass3_1946,
                                    AbstractImage.toJstr(x),
                                    Class32.underscoreJstr,
                                    AbstractImage.toJstr(y)})))));
                        counter++;
                    }
                }
            }
            Client.setMapLocation(sPositionX, sPositionY, mPositionX, mPositionY, height);
        } else {
            Class39_Sub5_Sub11.incomingBuffer.initBitAccess();
            for (int i_26_ = 0; i_26_ < 4; i_26_++) {
                for (int i_27_ = 0; i_27_ < 13; i_27_++) {
                    for (int i_28_ = 0; i_28_ < 13; i_28_++) {
                        int i_29_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                        if (i_29_ == 1) {
                            Class39_Sub5_Sub6.anIntArrayArrayArray1755[i_26_][i_27_][i_28_] = Class39_Sub5_Sub11.incomingBuffer.getBits(26);
                        } else {
                            Class39_Sub5_Sub6.anIntArrayArrayArray1755[i_26_][i_27_][i_28_] = -1;
                        }
                    }
                }
            }
            Class39_Sub5_Sub11.incomingBuffer.finishBitAccess();
            int i_30_ = ((-Class39_Sub5_Sub11.incomingBuffer.offset
                    + Huffman.frameSize)
                    / 16);
            Class14.anIntArrayArray221 = new int[i_30_][4];
            for (int i_31_ = 0; i_30_ > i_31_; i_31_++) {
                for (int i_32_ = 0; i_32_ < 4; i_32_++) {
                    Class14.anIntArrayArray221[i_31_][i_32_] = Class39_Sub5_Sub11.incomingBuffer.getDword();
                }
            }
            int i_33_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            int i_34_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int i_35_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe128();
            int i_36_ = Class39_Sub5_Sub11.incomingBuffer.getUwordLe();
            int i_37_ = Class39_Sub5_Sub11.incomingBuffer.getUbyteA();
            ItemDefinition.anIntArray1682 = new int[i_30_];
            Class65.anIntArray1132 = new int[i_30_];
            Cache.aByteArrayArray104 = new byte[i_30_][];
            TextureLoaderImpl.anIntArray1255 = new int[i_30_];
            VarpDefinition.aByteArrayArray1989 = new byte[i_30_][];
            i_30_ = 0;
            for (int i_38_ = 0; i_38_ < 4; i_38_++) {
                for (int i_39_ = 0; i_39_ < 13; i_39_++) {
                    for (int i_40_ = 0; i_40_ < 13; i_40_++) {
                        int i_41_ = (Class39_Sub5_Sub6.anIntArrayArrayArray1755[i_38_][i_39_][i_40_]);
                        if (i_41_ != -1) {
                            int i_42_ = (i_41_ & 0x3ff9) >> 3;
                            int i_43_ = (i_41_ & 0xfff459) >> 14;
                            int i_44_ = i_42_ / 8 + (i_43_ / 8 << 8);
                            for (int i_45_ = 0; i_45_ < i_30_; i_45_++) {
                                if (Class65.anIntArray1132[i_45_] == i_44_) {
                                    i_44_ = -1;
                                    break;
                                }
                            }
                            if (i_44_ != -1) {
                                Class65.anIntArray1132[i_30_] = i_44_;
                                int i_46_ = i_44_ >> 8 & 0xff;
                                int i_47_ = i_44_ & 0xff;
                                ItemDefinition.anIntArray1682[i_30_] = (JSocket.fileLoader5.lookupArchive((Class39_Sub5_Sub11.join((new JString[]{JApplet.mJstr,
                                            AbstractImage.toJstr(i_46_),
                                            Class32.underscoreJstr,
                                            AbstractImage.toJstr(i_47_)})))));
                                TextureLoaderImpl.anIntArray1255[i_30_] = (JSocket.fileLoader5.lookupArchive((Class39_Sub5_Sub11.join((new JString[]{ObjectDefinition.aClass3_1946,
                                            AbstractImage.toJstr(i_46_),
                                            Class32.underscoreJstr,
                                            AbstractImage.toJstr(i_47_)})))));
                                i_30_++;
                            }
                        }
                    }
                }
            }
            Client.setMapLocation(i_34_, i_36_, i_35_,
                    i_33_, i_37_);
        }
    }

    public static void method286(int i) {
        aClass3_460 = null;
        aClass3_464 = null;
        aClass3_470 = null;
        aClass3_462 = null;
        if (i != -7753) {
            anInt459 = 57;
        }
        huffmans = null;
        tableFile = null;
        aClass3_468 = null;
        priorityRequestsQueue = null;
        aClass3_457 = null;
        aClass3_469 = null;
        aClass3_458 = null;
        aClass3_466 = null;
        aClass3_463 = null;
    }

    public static VarbitDefinition getVarbit(int id) {
        VarbitDefinition varbit = ((VarbitDefinition) Widget.varbitCache.get((long) id));
        if (varbit != null) {
            return varbit;
        }
        byte[] is = Queue.aClass9_971.lookupFile(14, id);
        varbit = new VarbitDefinition();
        if (is != null) {
            varbit.decode(new Buffer(is));
        }
        Widget.varbitCache.put(varbit, (long) id);
        return varbit;
    }

    public static void method288(byte i) {
        Class39_Sub5_Sub7.aClass57_1778.method1006(10);
        PlayerApperance.aClass39_Sub5_Sub10_Sub4_866.method695(0, 0);
        Widget.anIntArray2006 = TriangleRasterizer.method657(Widget.anIntArray2006);
    }

    static {
        aClass3_460 = aClass3_463;
        anApplet_Sub1_465 = null;
        aClass3_464 = JString.create("Too many connections from your address)3");
        aClass3_458 = aClass3_464;
        aClass3_462 = aClass3_457;
        aClass3_466 = JString.create(": ");
        priorityRequestsQueue = new HashTable(4096);
        aClass3_468 = JString.create("Enter your username (V password)3");
        anInt471 = 0;
        aClass3_470 = aClass3_468;
        aClass3_469 = JString.create(" weitere Optionen");
    }
}
