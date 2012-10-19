/**
 * Copyright Evelus, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Hadyn Richard (sini@evel.us), July 2012
 */

package com.jagex.utils;

import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.audio.AudioHandler;
import com.jagex.awt.JApplet;
import com.jagex.awt.JCanvas;
import com.jagex.awt.events.JKeyListener;
import com.jagex.awt.events.JMouseListener;
import com.jagex.config.ItemDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.config.Widget;
import com.jagex.graphics.JImage;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.io.Buffer;
import com.jagex.io.CacheIO;
import com.jagex.io.FileLoader;
import com.jagex.io.FrameBuffer;
import com.jagex.net.JSocket;
import com.jagex.od.OndemandRequest;
import com.jagex.world.Barrier;
import com.jagex.world.Mob;
import com.jagex.world.entities.GroundItem;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.entities.Projectile;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.map.TraversalMap;
import unpackaged.Class1;
import unpackaged.Class12;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Wall;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class44;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class50;
import unpackaged.Class53;
import unpackaged.Class62_Sub2;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import unpackaged.Class67;
import unpackaged.Class68;
import com.jagex.script.ClientScript;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.script.ScriptState;
import unpackaged.TextureLoaderImpl;

/**
 * Evelus Development
 * Created by Hadyn Richard
 */
public final class LanguageUtils {

    public static void setMessagesToGerman() {
        Class23.okJstr = Class34.aClass3_611;
        Class1.aClass3_44 = Timer.aClass3_878;
        TextConstants.aClass3_623 = Class50.aClass3_928;
        StillObject.aClass3_1467 = AudioHandler.aClass3_1114;
        Player.cancelJstr = Class12.aClass3_195;
        AudioHandler.aClass3_1109 = Class2.aClass3_46;
        StillObject.aClass3_1468 = ClientScript.aClass3_1695;
        Class47.aClass3_895 = Class68.aClass3_1185;
        Class39_Sub5_Sub5.aClass3_1741 = StillGraphic.aClass3_2329;
        Class30.aClass3_535 = Class66.aClass3_1149;
        Queue.aClass3_977 = Class43.aClass3_817;
        Class2.aClass3_57 = Entity.aClass3_1733;
        Class63.aClass3_1129 = FileLoader.aClass3_1289;
        Class23.aClass3_424 = MouseRecorder.aClass3_569;
        SubNode.aClass3_1343 = Class39_Sub5_Sub14.aClass3_1911;
        Queue.aClass3_976 = GroundItem.aClass3_2236;
        PlayerApperance.aClass3_864 = Deque.aClass3_913;
        TextConstants.aClass3_1264 = StillGraphic.aClass3_2344;
        Class39_Sub4.aClass3_1334 = Class39_Sub5_Sub12.aClass3_1851;
        Class14.aClass3_247 = JMouseListener.aClass3_790;
        Class39_Sub5_Sub6.aClass3_1751 = Class39_Sub5_Sub6.aClass3_1771;
        Class14.aClass3_236 = GroundItem.aClass3_2237;
        Class14.aClass3_272 = ItemDefinition.aClass3_1681;
        Class14.aClass3_219 = Node.aClass3_735;
        Class62_Sub2.aClass3_1601 = Npc.aClass3_2487;
        Class14.aClass3_223 = Class53.aClass3_956;
        Class39_Sub5_Sub7.aClass3_1786 = TextConstants.aClass3_1238;
        Player.aClass3_2528 = HashTable.aClass3_373;
        AudioHandler.aClass3_1113 = FrameBuffer.aClass3_2152;
        Class14.aClass3_260 = ItemDefinition.aClass3_1681;
        Class26.loadingSpritesJstr = Class4.aClass3_66;
        ISAAC.aClass3_1085 = Class53.aClass3_966;
        StillGraphic.aClass3_2346 = Class25.aClass3_469;
        TextConstants.aClass3_1234 = Class43.aClass3_805;
        JCanvas.aClass3_13 = Class39_Sub5_Sub6.aClass3_1770;
        Class14.aClass3_255 = ItemDefinition.aClass3_1681;
        Class39_Sub4.aClass3_1338 = Class14.aClass3_210;
        Class14.aClass3_270 = FrameBuffer.aClass3_2143;
        Class41.aClass3_781 = MouseRecorder.aClass3_550;
        StillObject.aClass3_1454 = AudioHandler.aClass3_1114;
        Class14.aClass3_263 = ItemDefinition.aClass3_1681;
        SubNode.aClass3_1346 = Wall.aClass3_645;
        HashTable.aClass3_374 = Class41.aClass3_767;
        Class14.aClass3_259 = Class39_Sub14.aClass3_1513;
        VarpDefinition.aClass3_1991 = StillGraphic.aClass3_2335;
        Class15.aClass3_286 = ScriptState.aClass3_441;
        TextConstants.aClass3_1721 = TextureLoaderImpl.aClass3_1246;
        Class37.aClass3_659 = Buffer.aClass3_1369;
        Class14.aClass3_220 = Huffman.aClass3_758;
        Class13.aClass3_206 = Class47.aClass3_889;
        TextConstants.aClass3_616 = GroundItem.aClass3_2249;
        ArchiveWorker.aClass3_1195 = Node.aClass3_740;
        MouseRecorder.aClass3_549 = VarpDefinition.aClass3_1990;
        Npc.aClass3_2496 = Buffer.aClass3_1359;
        ItemContainer.aClass3_1503 = Player.aClass3_2530;
        ClientScript.aClass3_1689 = GouraudVertex.aClass3_906;
        TraversalMap.aClass3_519 = Class26.aClass3_486;
        Mob.aClass3_2289 = Class39_Sub5_Sub18.aClass3_2131;
        Class39_Sub12.aClass3_1485 = TextConstants.aClass3_1722;
        Class34.aClass3_608 = Timer.aClass3_873;
        Class14.aClass3_250 = JMouseListener.aClass3_790;
        Class25.aClass3_460 = Huffman.aClass3_763;
        StillGraphic.aClass3_2327 = Cache.aClass3_102;
        Class14.aClass3_261 = ItemDefinition.aClass3_1681;
        Class32.aClass3_592 = ISAAC.aClass3_1092;
        JApplet.attackJstr = GroundItem.aClass3_2235;
        TextConstants.aClass3_624 = Class41.aClass3_772;
        Class14.aClass3_235 = Class47.aClass3_890;
        Class14.aClass3_243 = ItemDefinition.aClass3_1681;
        TextConstants.aClass3_1593 = Class39_Sub14.aClass3_1510;
        StillObject.aClass3_1475 = Class41.aClass3_770;
        Class39_Sub5_Sub14.aClass3_1913 = JImage.aClass3_1583;
        Class13.aClass3_207 = Class47.aClass3_889;
        Class14.aClass3_248 = GroundItem.aClass3_2237;
        FileLoader.aClass3_1286 = FileLoader.aClass3_1292;
        Class14.aClass3_238 = ItemDefinition.aClass3_1681;
        AudioHandler.aClass3_1116 = Class12.aClass3_193;
        ObjectDefinition.aClass3_1966 = MsTimer.aClass3_1557;
        Class39_Sub5_Sub5.aClass3_1736 = Class68.aClass3_1194;
        Class14.aClass3_273 = ItemDefinition.aClass3_1681;
        Huffman.aClass3_755 = Class68.aClass3_1187;
        Class39_Sub5_Sub7.aClass3_1777 = Bzip2Entry.aClass3_1074;
        Bzip2Entry.aClass3_1050 = Class67.aClass3_1178;
        HashTable.aClass3_356 = Wall.aClass3_652;
        Class30.aClass3_537 = StillGraphic.aClass3_2341;
        Queue.aClass3_983 = Class39_Sub4.aClass3_1337;
        Class53.spaceJstr = Class25.aClass3_466;
        Class34.aClass3_615 = ObjectDefinition.aClass3_1947;
        Class4.aClass3_77 = SubNode.aClass3_1347;
        Class14.aClass3_251 = ItemDefinition.aClass3_1681;
        Class14.aClass3_214 = Huffman.aClass3_758;
        Class39_Sub5_Sub5.aClass3_1747 = MsTimer.aClass3_1567;
        Bzip2Entry.aClass3_1049 = Deque.aClass3_909;
        PlayerApperance.aClass3_865 = Class53.aClass3_961;
        Timer.aClass3_875 = JRuntimeException.aClass3_1219;
        JRuntimeException.examineJstr = Class39_Sub12.aClass3_1483;
        Class63.aClass3_1118 = Class4.aClass3_72;
        Class39_Sub5_Sub6.aClass3_1766 = JCanvas.aClass3_19;
        Class66.aClass3_1165 = GroundItem.aClass3_2234;
        TextConstants.aClass3_1277 = Class39_Sub5_Sub11.aClass3_1842;
        Class14.aClass3_237 = ItemDefinition.aClass3_1681;
        Npc.aClass3_2504 = AudioHandler.aClass3_1108;
        Class14.aClass3_252 = ItemDefinition.aClass3_1681;
        TextConstants.aClass3_1279 = Class65.aClass3_1133;
        StillGraphic.aClass3_2343 = Class68.aClass3_1191;
        Class32.aClass3_577 = JImage.aClass3_1578;
        StillGraphic.aClass3_2340 = ItemContainer.aClass3_1507;
        Timer.aClass3_877 = Wall.aClass3_639;
        Class14.aClass3_240 = ItemDefinition.aClass3_1681;
        ClientScript.aClass3_1698 = ClientScript.aClass3_1695;
        FileLoader.aClass3_1299 = Class39_Sub5_Sub5.aClass3_1735;
        Class25.aClass3_470 = JSocket.aClass3_300;
        Class39_Sub4.aClass3_1328 = Class39_Sub5_Sub5.aClass3_1735;
        JApplet.aClass3_10 = Queue.aClass3_988;
        JCanvas.aClass3_16 = TextConstants.aClass3_619;
        HashTable.aClass3_385 = Class39_Sub10.aClass3_1419;
        MouseRecorder.aClass3_572 = Barrier.aClass3_167;
        Class23.ignoreListFullJstr = Class39_Sub5_Sub9.aClass3_1816;
        Class23.aClass3_427 = MouseRecorder.aClass3_569;
        Class14.aClass3_212 = Class50.aClass3_936;
        Class39_Sub10.aClass3_1448 = Class39_Sub10.aClass3_1444;
        Class39_Sub5_Sub4_Sub2.aClass3_2222 = Class43.aClass3_828;
        Deque.aClass3_910 = Class32.aClass3_578;
        Class39_Sub5_Sub5.aClass3_1745 = Queue.aClass3_986;
        ScriptState.aClass3_442 = Class39_Sub5_Sub14.aClass3_1910;
        Class63.aClass3_1123 = Mob.aClass3_2302;
        Class39_Sub5_Sub12.aClass3_1850 = Node.aClass3_731;
        Class14.aClass3_253 = JRuntimeException.aClass3_1218;
        Class14.aClass3_234 = Class50.aClass3_936;
        Class14.aClass3_267 = ItemDefinition.aClass3_1681;
        TextConstants.aClass3_622 = Class39_Sub5_Sub9.aClass3_1805;
        Mob.useJstr = Class39_Sub5_Sub18.aClass3_2135;
        Wall.aClass3_647 = ArchiveRequest.aClass3_1402;
        Class39_Sub14.aClass3_1521 = Class26.aClass3_474;
        Class39_Sub4.aClass3_1326 = PlayerApperance.aClass3_860;
        Projectile.aClass3_2190 = AbstractFileLoader.aClass3_140;
        Class4.aClass3_68 = Entity.aClass3_1729;
        Class39_Sub5_Sub7.aClass3_1787 = Huffman.aClass3_750;
        Class14.loadingWordpackJstr = ScriptState.aClass3_444;
        Class14.aClass3_258 = Class44.aClass3_839;
        Barrier.aClass3_168 = Barrier.aClass3_170;
        Class37.aClass3_660 = Buffer.aClass3_1369;
        Class25.aClass3_458 = JCanvas.aClass3_18;
        TextureLoaderImpl.aClass3_1253 = Queue.aClass3_974;
        JSocket.aClass3_305 = MouseRecorder.aClass3_564;
        Node.aClass3_727 = Class39_Sub14.aClass3_1522;
        Class14.aClass3_257 = AbstractFileLoader.aClass3_131;
        Class44.aClass3_847 = Class53.aClass3_963;
        JImage.aClass3_1574 = Buffer.aClass3_1356;
        JMouseListener.aClass3_795 = Class39_Sub10.aClass3_1425;
        Class39_Sub5_Sub4_Sub2.aClass3_2218 = Huffman.aClass3_747;
        Class14.aClass3_268 = ItemDefinition.aClass3_1681;
        Class14.aClass3_256 = Queue.aClass3_991;
        PlayerApperance.aClass3_859 = Class39_Sub5_Sub12.aClass3_1852;
        Timer.continueJstr = Class39_Sub5_Sub18.aClass3_2129;
        Widget.aClass3_2002 = Class68.aClass3_1193;
        NameTable.aClass3_190 = NameTable.aClass3_181;
        Class47.aClass3_896 = MsTimer.aClass3_1556;
        ItemContainer.dropJstr = Class33.aClass3_594;
        Class14.aClass3_269 = ItemDefinition.aClass3_1681;
        ObjectDefinition.aClass3_1973 = Class39_Sub5_Sub12.aClass3_1858;
        Timer.aClass3_881 = ObjectDefinition.aClass3_1940;
        Class4.aClass3_59 = GouraudVertex.aClass3_902;
        JRuntimeException.aClass3_1214 = Class67.aClass3_1174;
        HashTable.selectJstr = Class65.aClass3_1139;
        ISAAC.aClass3_1082 = Class1.aClass3_43;
        Class14.aClass3_241 = ItemDefinition.aClass3_1681;
        ISAAC.aClass3_1098 = Mob.aClass3_2278;
        VarpDefinition.aClass3_1981 = Class30.aClass3_546;
        Class39_Sub5_Sub9.aClass3_1803 = Queue.aClass3_980;
        Huffman.mutePlayerOptionOnJstr = JImage.aClass3_1577;
        Class39_Sub14.toJstr = CacheIO.aClass3_96;
        Class67.aClass3_1176 = CacheIO.aClass3_100;
        Class13.aClass3_209 = Class2.aClass3_56;
        Timer.aClass3_876 = Mob.aClass3_2309;
        Class14.aClass3_249 = Class39_Sub5_Sub4_Sub2.aClass3_2224;
        Class14.aClass3_228 = JCanvas.aClass3_17;
        HashTable.aClass3_386 = Class63.aClass3_1121;
        Class39_Sub5_Sub4_Sub2.aClass3_2230 = Queue.aClass3_991;
        Class53.aClass3_958 = Deque.aClass3_917;
        ItemDefinition.aClass3_1683 = TraversalMap.aClass3_512;
        Buffer.aClass3_1365 = MouseRecorder.aClass3_557;
        Class14.aClass3_217 = Class50.aClass3_936;
        StillGraphic.aClass3_2353 = HashTable.aClass3_384;
        Class13.aClass3_198 = Wall.aClass3_635;
        FrameBuffer.aClass3_2144 = ItemDefinition.aClass3_1687;
        Wall.aClass3_634 = Buffer.aClass3_1363;
        Class44.aClass3_835 = Class62_Sub2.aClass3_1598;
        Class14.aClass3_271 = HashTable.aClass3_380;
        Class14.aClass3_244 = ItemDefinition.aClass3_1681;
        Deque.aClass3_926 = NameTable.aClass3_188;
        Class65.aClass3_1142 = ScriptState.aClass3_445;
        Class39_Sub5_Sub6.aClass3_1769 = Npc.aClass3_2498;
        AbstractFileLoader.aClass3_148 = Class39_Sub12.aClass3_1484;
        Class14.aClass3_265 = Class50.aClass3_936;
        Class66.aClass3_1162 = Player.aClass3_2535;
        Class20.aClass3_387 = Huffman.aClass3_745;
        Barrier.mutePlayerOptionOffJstr = Class13.aClass3_202;
        JSocket.aClass3_308 = VarpDefinition.aClass3_1993;
        Class39_Sub5_Sub11.aClass3_1845 = Class39_Sub10.aClass3_1435;
        Class53.aClass3_967 = Npc.aClass3_2497;
        Class14.aClass3_266 = Widget.aClass3_2070;
        Class14.aClass3_215 = Class39_Sub10.aClass3_1447;
        StillObject.aClass3_1465 = StillObject.aClass3_1463;
        Class65.aClass3_1140 = ItemDefinition.aClass3_1681;
        TextConstants.aClass3_1270 = StillGraphic.aClass3_2348;
        Cache.aClass3_105 = GroundItem.aClass3_2244;
        ClientScript.aClass3_1701 = Class39_Sub5_Sub14.aClass3_1898;
        Class4.aClass3_79 = TextureLoaderImpl.aClass3_1249;
        Class63.aClass3_1119 = ScriptState.aClass3_452;
        JSocket.aClass3_299 = HashTable.aClass3_378;
        Projectile.aClass3_2182 = ArchiveWorker.aClass3_1209;
        Projectile.aClass3_2196 = Barrier.aClass3_166;
        Class25.aClass3_462 = Class67.aClass3_1173;
        JImage.aClass3_1585 = Class62_Sub2.aClass3_1603;
        Class39_Sub12.aClass3_1496 = TextureLoaderImpl.aClass3_1250;
    }
    
    /**
     * Prevent construction;
     */
    private LanguageUtils ( ) { }

}