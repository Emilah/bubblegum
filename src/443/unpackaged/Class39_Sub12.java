package unpackaged;

import com.jagex.utils.ClassCheckRequest;
import com.jagex.graphics.TriangleRasterizer;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.utils.ItemContainer;
import com.jagex.script.ScriptState;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.audio.AudioHandler;
import com.jagex.world.World;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.NpcDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.events.JKeyListener;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.io.CacheIO;
import com.jagex.utils.Bzip2Block;
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;

/* Class39_Sub12 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class Class39_Sub12 extends Node {

    public static JString aClass3_1482 = JString.create("scrollbar");
    public static JString aClass3_1483;
    public static JString aClass3_1484;
    public static JString aClass3_1485;
    public int[][] anIntArrayArray1486;
    public static boolean aBoolean1487;
    public static JString aClass3_1488;
    public static boolean aBoolean1489;
    public static int anInt1490;
    public static int[] staticLevels = new int[25];
    public static JString aClass3_1492;
    public static boolean aBoolean1493;
    public int anInt1494;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1495;
    public static JString aClass3_1496;
    public int[] anIntArray1497;
    public static boolean aBoolean1498;
    public static JString aClass3_1499;
    public int anInt1500;

    public static void method870() {
        if (Class26.loadingStage == 0) {
            Class44.world = new World(4, 104, 104, Class67.heightMap);
            for (int i_0_ = 0; i_0_ < 4; i_0_++) {
                Class39_Sub5_Sub12.traversalMaps[i_0_] = new TraversalMap(104, 104);
            }
            Class39_Sub5_Sub4_Sub2.aClass39_Sub5_Sub10_Sub3_2219 = new DirectColorSprite(512, 512);
            ClassCheckRequest.loadingPercent = 5;
            Class39_Sub5_Sub14.loadingMessage = AudioHandler.aClass3_1113;
            Class26.loadingStage = 20;
        } else if (Class26.loadingStage == 20) {
            int[] is = new int[9];
            for (int i_1_ = 0; i_1_ < 9; i_1_++) {
                int i_2_ = i_1_ * 32 + 128 + 15;
                int i_3_ = TriangleRasterizer.sineTable[i_2_];
                int i_4_ = i_2_ * 3 + 600;
                is[i_1_] = i_3_ * i_4_ >> 16;
            }
            World.method403(is, 500, 800, 512, 334);
            ClassCheckRequest.loadingPercent = 10;
            Class26.loadingStage = 30;
            Class39_Sub5_Sub14.loadingMessage = Class39_Sub5_Sub5.aClass3_1741;
        } else {
            if (Class26.loadingStage == 30) {
                Buffer.fileLoader0 = ClassCheckRequest.createFileLoader(0, true, true, false);
                Class15.fileLoader1 = ClassCheckRequest.createFileLoader(1, true, true, false);
                Class67.fileLoader2 = ClassCheckRequest.createFileLoader(2, false, true, true);
                Node.fileLoader3 = ClassCheckRequest.createFileLoader(3, true, true, false);
                Node.fileLoader4 = ClassCheckRequest.createFileLoader(4, true, true, false);
                JSocket.fileLoader5 = ClassCheckRequest.createFileLoader(5, true, true, true);
                Projectile.fileLoader6 = ClassCheckRequest.createFileLoader(6, true, false, true);
                PlayerApperance.fileLoader7 = ClassCheckRequest.createFileLoader(7, true, true, false);
                TraversalMap.fileLoader8 = ClassCheckRequest.createFileLoader(8, true, true, false);
                Widget.fileLoader9 = ClassCheckRequest.createFileLoader(9, true, true, false);
                Class66.fileLoader10 = ClassCheckRequest.createFileLoader(10, true, true, false);
                Wall.fileLoader11 = ClassCheckRequest.createFileLoader(11, true, true, false);
                Class33.fileLoader12 = ClassCheckRequest.createFileLoader(12, true, true, false);
                TextureLoaderImpl.fileLoader13 = ClassCheckRequest.createFileLoader(13, false, true, true);
                ClassCheckRequest.loadingPercent = 20;
                Class39_Sub5_Sub14.loadingMessage = Class47.aClass3_896;
                Class26.loadingStage = 40;
            } else if (Class26.loadingStage == 40) {
                int i_6_ = 0;
                i_6_ += Buffer.fileLoader0.method177(0) * 5 / 100;
                i_6_ += Class15.fileLoader1.method177(0) * 5 / 100;
                i_6_ += Class67.fileLoader2.method177(0) * 5 / 100;
                i_6_ += Node.fileLoader3.method177(0) * 5 / 100;
                i_6_ += Node.fileLoader4.method177(0) * 5 / 100;
                i_6_ += JSocket.fileLoader5.method177(0) * 5 / 100;
                i_6_ += (Projectile.fileLoader6.method177(0)
                        * 5 / 100);
                i_6_ += PlayerApperance.fileLoader7.method177(0) * 40 / 100;
                i_6_ += TraversalMap.fileLoader8.method177(0) * 5 / 100;
                i_6_ += (Widget.fileLoader9.method177(0) * 3
                        / 100);
                i_6_ += Class66.fileLoader10.method177(0) * 5 / 100;
                i_6_ += Wall.fileLoader11.method177(0) * 5 / 100;
                i_6_ += Class33.fileLoader12.method177(0) * 5 / 100;
                i_6_ += TextureLoaderImpl.fileLoader13.method177(0) * 2 / 100;
                if (i_6_ != 100) {
                    if (i_6_ != 0) {
                        Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{TextConstants.aClass3_623,
                                    AbstractImage.toJstr(i_6_),
                                    Class39_Sub5_Sub18.percentJstr})));
                    }
                    ClassCheckRequest.loadingPercent = 30;
                } else {
                    ClassCheckRequest.loadingPercent = 30;
                    Class39_Sub5_Sub14.loadingMessage = ItemContainer.aClass3_1503;
                    Class26.loadingStage = 45;
                }
            } else if (Class26.loadingStage == 45) {
                Class66.method1101(0, Class39_Sub5_Sub9.fileSignlink, 32031,
                        !PlayerApperance.isLowMemory);
                Class1.aClass39_Sub1_Sub1_32 = Class65.method1096(false,
                        Class39_Sub5_Sub9.fileSignlink,
                        Class41.canvas, 20697, 22050);
                ClientScript.aClass43_1693 = new Class43(22050, Class15.anInt274);
                ClassCheckRequest.loadingPercent = 35;
                Class26.loadingStage = 50;
                Class39_Sub5_Sub14.loadingMessage = Class39_Sub5_Sub6.aClass3_1751;
            } else if (Class26.loadingStage == 50) {
                int i_7_ = 0;
                if (Npc.aClass39_Sub5_Sub10_Sub1_2495
                        == null) {
                    Npc.aClass39_Sub5_Sub10_Sub1_2495 = MsTimer.createBitmapFont(TraversalMap.fileLoader8, (Class39_Sub5_Sub14.aClass3_1895),
                            Class66.blankString);
                } else {
                    i_7_++;
                }
                if (Class39_Sub5_Sub14.p12fullFont == null) {
                    Class39_Sub5_Sub14.p12fullFont = MsTimer.createBitmapFont(TraversalMap.fileLoader8, Class39_Sub10.p12_full, Class66.blankString);
                } else {
                    i_7_++;
                }
                if (Class32.aClass39_Sub5_Sub10_Sub1_587 == null) {
                    Class32.aClass39_Sub5_Sub10_Sub1_587 = MsTimer.createBitmapFont(TraversalMap.fileLoader8, (FrameBuffer.b12_full),
                            Class66.blankString);
                } else {
                    i_7_++;
                }
                if (i_7_ < 3) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join(new JString[]{Deque.aClass3_926,
                                AbstractImage.toJstr(i_7_ * 100 / 3),
                                Class39_Sub5_Sub18.percentJstr}));
                    ClassCheckRequest.loadingPercent = 40;
                } else {
                    ClassCheckRequest.loadingPercent = 40;
                    Class26.loadingStage = 60;
                    Class39_Sub5_Sub14.loadingMessage = Class39_Sub5_Sub7.aClass3_1786;
                }
            } else if (Class26.loadingStage == 60) {
                int i_8_ = BufferedFile.method230(true, Class66.fileLoader10,
                        TraversalMap.fileLoader8);
                int i_9_ = JKeyListener.method345((byte) 64);
                if (i_9_ > i_8_) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{JApplet.aClass3_10,
                                AbstractImage.toJstr(i_8_ * 100 / i_9_),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 50;
                } else {
                    ClassCheckRequest.loadingPercent = 50;
                    Class39_Sub5_Sub14.loadingMessage = ArchiveWorker.aClass3_1195;
                    Client.setState(5);
                    Class26.loadingStage = 70;
                }
            } else if (Class26.loadingStage == 70) {
                if (!Class67.fileLoader2.getArchivesLoaded()) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{TextConstants.aClass3_1277,
                                AbstractImage.toJstr(Class67.fileLoader2.method169(125)),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 60;
                } else {
                    Class65.method1099((byte) 119, Class67.fileLoader2);
                    Class62_Sub2.method1076(16965, Class67.fileLoader2);
                    Class34.method339(PlayerApperance.fileLoader7,
                            Class67.fileLoader2);
                    ScriptState.setObjectFileLoaders(PlayerApperance.isLowMemory, PlayerApperance.fileLoader7, Class67.fileLoader2, 64);
                    Class47.setNpcFileLoaders(Class67.fileLoader2, PlayerApperance.fileLoader7);
                    Bzip2Block.method1032(PlayerApperance.fileLoader7, (byte) -113,
                            Class67.fileLoader2,
                            (Npc.aClass39_Sub5_Sub10_Sub1_2495),
                            HashTable.members);
                    Class67.method1110(Class15.fileLoader1,
                            Class67.fileLoader2,
                            Buffer.fileLoader0, 102);
                    NpcDefinition.method715((byte) -16,
                            Class67.fileLoader2,
                            PlayerApperance.fileLoader7);
                    Class33.method328((byte) 80, Class67.fileLoader2);
                    Timer.method937(52, Class67.fileLoader2);
                    NpcDefinition.method714(PlayerApperance.fileLoader7,
                            (byte) 64,
                            TraversalMap.fileLoader8,
                            Node.fileLoader3);
                    Class39_Sub5_Sub14.loadingMessage = StillObject.aClass3_1475;
                    Class26.loadingStage = 80;
                    ClassCheckRequest.loadingPercent = 60;
                }
            } else if (Class26.loadingStage == 80) {
                int spritesLoaded = 0;
                if (AbstractFileLoader.aClass39_Sub5_Sub10_Sub3_141 != null) {
                    spritesLoaded++;
                } else {
                    AbstractFileLoader.aClass39_Sub5_Sub10_Sub3_141 = Class39_Sub5_Sub9.method599(Class41.compassJstr,
                            Class66.blankString,
                            (TraversalMap.fileLoader8));
                }
                if (ClientScript.aClass39_Sub5_Sub10_Sub3_1712 != null) {
                    spritesLoaded++;
                } else {
                    ClientScript.aClass39_Sub5_Sub10_Sub3_1712 = Class39_Sub5_Sub9.method599(ArchiveWorker.mapedgeJstr,
                            Class66.blankString,
                            (TraversalMap.fileLoader8));
                }
                if (FileLoader.aClass39_Sub5_Sub10_Sub4Array1296 != null) {
                    spritesLoaded++;
                } else {
                    FileLoader.aClass39_Sub5_Sub10_Sub4Array1296 = Class39_Sub5_Sub12.method713((byte) 122,
                            (TraversalMap.fileLoader8),
                            Class66.blankString,
                            Class33.aClass3_597);
                }
                if (Projectile.aClass39_Sub5_Sub10_Sub3Array2205
                        == null) {
                    Projectile.aClass39_Sub5_Sub10_Sub3Array2205 = ClassCheckRequest.method852(ClassCheckRequest.aClass3_1388,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                } else {
                    spritesLoaded++;
                }
                if (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1992
                        != null) {
                    spritesLoaded++;
                } else {
                    VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1992 = ClassCheckRequest.method852(StillObject.aClass3_1479,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (MouseRecorder.aClass39_Sub5_Sub10_Sub3Array573 != null) {
                    spritesLoaded++;
                } else {
                    MouseRecorder.aClass39_Sub5_Sub10_Sub3Array573 = ClassCheckRequest.method852(StillObject.aClass3_1480,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (AudioHandler.aClass39_Sub5_Sub10_Sub3Array1106 != null) {
                    spritesLoaded++;
                } else {
                    AudioHandler.aClass39_Sub5_Sub10_Sub3Array1106 = ClassCheckRequest.method852(Class39_Sub10.aClass3_1422,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (Class20.aClass39_Sub5_Sub10_Sub3Array392 != null) {
                    spritesLoaded++;
                } else {
                    Class20.aClass39_Sub5_Sub10_Sub3Array392 = ClassCheckRequest.method852(Cache.aClass3_115,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (Widget.aClass39_Sub5_Sub10_Sub3_2113 == null) {
                    Widget.aClass39_Sub5_Sub10_Sub3_2113 = Class39_Sub5_Sub9.method599((ClassCheckRequest.aClass3_1384),
                            Class66.blankString,
                            (TraversalMap.fileLoader8));
                } else {
                    spritesLoaded++;
                }
                if (Wall.aClass39_Sub5_Sub10_Sub3Array648 != null) {
                    spritesLoaded++;
                } else {
                    Wall.aClass39_Sub5_Sub10_Sub3Array648 = ClassCheckRequest.method852(Class33.aClass3_595,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (Class47.crossSprites != null) {
                    spritesLoaded++;
                } else {
                    Class47.crossSprites = ClassCheckRequest.method852(ScriptState.aClass3_446,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986
                        != null) {
                    spritesLoaded++;
                } else {
                    VarpDefinition.aClass39_Sub5_Sub10_Sub3Array1986 = ClassCheckRequest.method852(Deque.aClass3_927,
                            TraversalMap.fileLoader8,
                            Class66.blankString, -30253);
                }
                if (Class62_Sub2.aClass39_Sub5_Sub10_Sub4Array1607 == null) {
                    Class62_Sub2.aClass39_Sub5_Sub10_Sub4Array1607 = Class39_Sub5_Sub12.method713((byte) -86,
                            (TraversalMap.fileLoader8),
                            Class66.blankString,
                            aClass3_1482);
                } else {
                    spritesLoaded++;
                }
                if (TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1247 != null) {
                    spritesLoaded++;
                } else {
                    TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1247 = Class39_Sub5_Sub12.method713((byte) 99,
                            (TraversalMap.fileLoader8),
                            Class66.blankString,
                            (Class39_Sub5_Sub4_Sub2.aClass3_2228));
                }
                if (spritesLoaded < 14) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{Class26.loadingSpritesJstr, AbstractImage.toJstr(spritesLoaded * 100 / 14), Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 70;
                } else {
                    int i_11_ = (int) (Math.random() * 21.0) - 10;
                    ClientScript.aClass39_Sub5_Sub10_Sub3_1712.method689();
                    int i_12_ = (int) (Math.random() * 21.0) - 10;
                    int i_13_ = (int) (Math.random() * 21.0) - 10;
                    int i_14_ = (int) (Math.random() * 41.0) - 20;
                    for (int i_15_ = 0;
                            ((Projectile.aClass39_Sub5_Sub10_Sub3Array2205).length
                            > i_15_);
                            i_15_++) {
                        Projectile.aClass39_Sub5_Sub10_Sub3Array2205[i_15_].method667(i_11_ + i_14_, i_14_ + i_13_, i_14_ + i_12_);
                    }
                    FileLoader.aClass39_Sub5_Sub10_Sub4Array1296[0].method693(i_14_ + i_11_, i_13_ + i_14_, i_12_ + i_14_);
                    Class26.loadingStage = 85;
                    Class39_Sub5_Sub14.loadingMessage = AbstractFileLoader.aClass3_148;
                    ClassCheckRequest.loadingPercent = 70;
                }
            } else if (Class26.loadingStage == 85) {
                int i_16_ = ArchiveRequest.method861((byte) -63,
                        TraversalMap.fileLoader8);
                int i_17_ = BufferedFile.method236(false);
                if (i_16_ < i_17_) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{TextConstants.aClass3_622,
                                AbstractImage.toJstr(i_16_ * 100 / i_17_),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 80;
                } else {
                    ClassCheckRequest.loadingPercent = 80;
                    Class39_Sub5_Sub14.loadingMessage = TextConstants.aClass3_1279;
                    Class26.loadingStage = 90;
                }
            } else if (Class26.loadingStage == 90) {
                if (!Widget.fileLoader9.getArchivesLoaded()) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{ClientScript.aClass3_1689, AbstractImage.toJstr(Widget.fileLoader9.method169(79)), Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 90;
                } else {
                    TextureLoaderImpl textureLoader = new TextureLoaderImpl(Widget.fileLoader9, TraversalMap.fileLoader8, 20, 0.8, PlayerApperance.isLowMemory ? 64 : 128);
                    TriangleRasterizer.setTextureLoader(textureLoader);
                    TriangleRasterizer.method650(0.8);
                    Class26.loadingStage = 110;
                    ClassCheckRequest.loadingPercent = 90;
                    Class39_Sub5_Sub14.loadingMessage = HashTable.aClass3_386;
                }
            } else if (Class26.loadingStage == 110) {
                Cache.mouseRecorder = new MouseRecorder();
                Class39_Sub5_Sub9.fileSignlink.requestThread(Cache.mouseRecorder, 10);
                Class39_Sub5_Sub14.loadingMessage = Class2.aClass3_57;
                Class26.loadingStage = 120;
                ClassCheckRequest.loadingPercent = 94;
            } else if (Class26.loadingStage == 120) {
                if (!Class66.fileLoader10.method152(22411, Class66.blankString, Cache.huffmanJstr)) {
                    Class39_Sub5_Sub14.loadingMessage = Class39_Sub5_Sub11.join((new JString[]{Class14.loadingWordpackJstr, (Buffer.aClass3_1366)}));
                    ClassCheckRequest.loadingPercent = 96;
                } else {
                    Huffman huffmans = new Huffman(Class66.fileLoader10.lookupFile(Cache.huffmanJstr, Class66.blankString));
                    AbstractMidiHandler.setHuffmans(huffmans);
                    ClassCheckRequest.loadingPercent = 96;
                    Class39_Sub5_Sub14.loadingMessage = Player.aClass3_2528;
                    Class26.loadingStage = 130;
                }
            } else if (Class26.loadingStage == 130) {
                if (!Node.fileLoader3.getArchivesLoaded()) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{ObjectDefinition.aClass3_1966,
                                AbstractImage.toJstr(Node.fileLoader3.method169(71) * 4 / 5),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 100;
                } else if (!Class33.fileLoader12.getArchivesLoaded()) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{ObjectDefinition.aClass3_1966,
                                AbstractImage.toJstr((Class33.fileLoader12.method169(108) / 6
                                + 80)),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 100;
                } else if (!TextureLoaderImpl.fileLoader13.getArchivesLoaded()) {
                    Class39_Sub5_Sub14.loadingMessage = (Class39_Sub5_Sub11.join((new JString[]{ObjectDefinition.aClass3_1966,
                                AbstractImage.toJstr((TextureLoaderImpl.fileLoader13.method169(74) / 20
                                + 96)),
                                Class39_Sub5_Sub18.percentJstr})));
                    ClassCheckRequest.loadingPercent = 100;
                } else {
                    ClassCheckRequest.loadingPercent = 100;
                    Class26.loadingStage = 140;
                    Class39_Sub5_Sub14.loadingMessage = Wall.aClass3_634;
                }
            } else if (Class26.loadingStage == 140) {
                Client.setState(10);
            }
        }
    }

    public static void method871(int i) {
        staticLevels = null;
        aClass3_1499 = null;
        aClass3_1484 = null;
        aClass3_1496 = null;
        aClass39_Sub5_Sub10_Sub4_1495 = null;
        aClass3_1483 = null;
        aClass3_1492 = null;
        aClass3_1485 = null;
        aClass3_1488 = null;
        aClass3_1482 = null;
    }

    public static void method872(int i) {
        if (Class39_Sub5_Sub7.minimapState == 0) {
            if (Timer.anInt887 == 1) {
                int i_18_ = Class39_Sub4.mouseClickPositionX - 25 - 550;
                int i_19_ = Bzip2Block.mouseClickPositionY - 4 - 5;
                if (i_18_ >= 0 && i_19_ >= 0 && i_18_ < 146 && i_19_ < 151) {
                    i_18_ -= 73;
                    int i_20_ = Class34.anInt605 + ArchiveRequest.anInt1401 & 0x7ff;
                    int i_21_ = TriangleRasterizer.sineTable[i_20_];
                    i_21_ = (ClassCheckRequest.anInt1386 + 256) * i_21_ >> 8;
                    i_19_ -= 75;
                    int i_22_ = TriangleRasterizer.cosineTable[i_20_];
                    i_22_ = i_22_ * (ClassCheckRequest.anInt1386 + 256) >> 8;
                    int i_23_ = i_18_ * i_22_ + i_19_ * i_21_ >> 11;
                    int i_24_ = ((Cache.localPlayer.fPositionY
                            + i_23_)
                            >> 7);
                    int i_25_ = i_22_ * i_19_ - i_21_ * i_18_ >> 11;
                    int i_26_ = (-i_25_ + (Cache.localPlayer.fPositionX)
                            >> 7);
                    boolean bool = Class26.sendWalkingRoute(0, i_26_, 0, 1, 0, 0, true,
                            0,
                            (Cache.localPlayer.queueX[0]),
                            (Cache.localPlayer.queueY[0]),
                            i_24_);
                    if (bool) {
                        FrameBuffer.outgoingBuffer.putByte(i_18_);
                        FrameBuffer.outgoingBuffer.putByte(i_19_);
                        FrameBuffer.outgoingBuffer.putWord(Class34.anInt605);
                        FrameBuffer.outgoingBuffer.putByte(57);
                        FrameBuffer.outgoingBuffer.putByte(ArchiveRequest.anInt1401);
                        FrameBuffer.outgoingBuffer.putByte(ClassCheckRequest.anInt1386);
                        FrameBuffer.outgoingBuffer.putByte(89);
                        FrameBuffer.outgoingBuffer.putWord((Cache.localPlayer.fPositionY));
                        FrameBuffer.outgoingBuffer.putWord((Cache.localPlayer.fPositionX));
                        FrameBuffer.outgoingBuffer.putByte(CacheIO.anInt99);
                        FrameBuffer.outgoingBuffer.putByte(63);
                    }
                }
            }
        }
    }

    public Class39_Sub12(int i, byte[] is) {
        anInt1494 = i;
        Buffer class39_sub6 = new Buffer(is);
        anInt1500 = class39_sub6.getUbyte();
        anIntArrayArray1486 = new int[anInt1500][];
        anIntArray1497 = new int[anInt1500];
        for (int i_27_ = 0; i_27_ < anInt1500; i_27_++) {
            anIntArray1497[i_27_] = class39_sub6.getUbyte();
        }
        for (int i_28_ = 0; anInt1500 > i_28_; i_28_++) {
            anIntArrayArray1486[i_28_] = new int[class39_sub6.getUbyte()];
        }
        for (int i_29_ = 0; i_29_ < anInt1500; i_29_++) {
            for (int i_30_ = 0; i_30_ < anIntArrayArray1486[i_29_].length;
                    i_30_++) {
                anIntArrayArray1486[i_29_][i_30_] = class39_sub6.getUbyte();
            }
        }
    }

    static {
        aClass3_1488 = JString.create("Enter name of player to add to list");
        aClass3_1484 = JString.create("Sprites geladen)3");
        aClass3_1483 = JString.create("Untersuchen");
        aBoolean1487 = false;
        aClass3_1496 = aClass3_1488;
        aBoolean1493 = false;
        aClass3_1492 = JString.create("");
        aClass3_1499 = JString.create("red:");
        aBoolean1489 = false;
        aClass3_1485 = aClass3_1499;
    }
}
