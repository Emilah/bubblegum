package unpackaged;

import com.jagex.od.OndemandRequest;
import com.jagex.config.ObjectDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.io.CacheIO;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.od.OndemandHandler;
import com.jagex.utils.Node;
import com.jagex.utils.JString;

/* Class39_Sub10 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class39_Sub10 extends Node {

    public int[] anIntArray1416;
    public static int anInt1417 = -1;
    public Class39_Sub1_Sub2 aClass39_Sub1_Sub2_1418;
    public static JString aClass3_1419;
    public static int anInt1420 = -1;
    public static JString aClass3_1421;
    public static JString aClass3_1422 = JString.create("headicons_prayer");
    public int anInt1423;
    public static AbstractFileLoader aClass9_1424;
    public static JString aClass3_1425 = JString.create("gr-Un:");
    public int anInt1426;
    public int anInt1427;
    public ObjectDefinition aClass39_Sub5_Sub15_1428;
    public static JString p12_full;
    public static int useWithItemWidgetId;
    public static int anInt1431;
    public int anInt1432;
    public int anInt1433;
    public int anInt1434;
    public static JString aClass3_1435;
    public static JString useWithItemJstr = null;
    public static int cameraHeight;
    public int anInt1438;
    public int anInt1439;
    public static int anInt1440;
    public Class39_Sub1_Sub2 aClass39_Sub1_Sub2_1441;
    public int anInt1442;
    public static JString aClass3_1443;
    public static JString aClass3_1444;
    public static AbstractFileLoader aClass9_1445;
    public int anInt1446;
    public static JString aClass3_1447;
    public static JString aClass3_1448;

    public void method864(int i) {
        int i_0_ = anInt1433;
        ObjectDefinition class39_sub5_sub15 = aClass39_Sub5_Sub15_1428.method733(0);
        if (class39_sub5_sub15 == null) {
            anInt1433 = -1;
            anInt1446 = 0;
            anIntArray1416 = null;
            anInt1426 = 0;
            anInt1439 = 0;
        } else {
            anInt1433 = class39_sub5_sub15.anInt1945;
            anIntArray1416 = class39_sub5_sub15.anIntArray1920;
            anInt1426 = class39_sub5_sub15.anInt1956;
            anInt1439 = class39_sub5_sub15.anInt1930;
            anInt1446 = class39_sub5_sub15.anInt1924 * 128;
        }
        if (anInt1433 != i_0_ && aClass39_Sub1_Sub2_1418 != null) {
            Class1.aClass39_Sub1_Sub1_32.method424(aClass39_Sub1_Sub2_1418);
            aClass39_Sub1_Sub2_1418 = null;
        }
    }

    public static void method865(boolean bool) {
        aClass3_1422 = null;
        aClass9_1424 = null;
        aClass3_1421 = null;
        aClass3_1425 = null;
        aClass3_1435 = null;
        aClass3_1447 = null;
        p12_full = null;
        aClass3_1448 = null;
        useWithItemJstr = null;
        aClass3_1443 = null;
        aClass9_1445 = null;
        aClass3_1419 = null;
        aClass3_1444 = null;
    }

    public static void requestArchive(FileLoader fileLoader, int indexId, int archiveId, boolean isPriority, int checksum, byte footerSize) {
        long l = (long) (archiveId + (indexId << 16));
        OndemandRequest request = ((OndemandRequest) Class25.priorityRequestsQueue.get(l));
        if (request == null) {
            request = (OndemandRequest) CacheIO.pendingPriorityRequests.get(l);
            if (request == null) {
                request = ((OndemandRequest) OndemandHandler.requests.get(l));
                if (request != null) {
                    if (isPriority) {
                        request.unlinkQueue();
                        Class25.priorityRequestsQueue.put(l, request);
                        Class39_Sub5_Sub6.queuedPriorityRequests++;
                        Class41.queuedRegularRequests--;
                    }
                } else {
                    if (!isPriority) {
                        request = ((OndemandRequest) OndemandHandler.pendingRegularRequests.get(l));
                        if (request != null) {
                            return;
                        }
                    }
                    request = new OndemandRequest();
                    request.footerSize = footerSize;
                    request.checksum = checksum;
                    request.fileLoader = fileLoader;
                    if (isPriority) {
                        Class25.priorityRequestsQueue.put(l, request);
                        Class39_Sub5_Sub6.queuedPriorityRequests++;
                    } else {
                        OndemandHandler.regularRequestsQueue.offerFirst(request);
                        OndemandHandler.requests.put(l, request);
                        Class41.queuedRegularRequests++;
                    }
                }
            }
        }
    }

    public static IndexedColorSprite method867(byte i, AbstractFileLoader class9, JString class3, JString class3_5_) {
        int i_6_ = class9.lookupArchive(class3);
        if (i != -79) {
            anInt1417 = -32;
        }
        int i_7_ = class9.lookupFile(i_6_, class3_5_);
        return GroundItem.method503(class9, i_7_, i_6_, true);
    }

    static {
        aClass3_1435 = JString.create("Ein kostenloses Spielkonto erstellen)3");
        anInt1440 = -1;
        aClass3_1443 = JString.create("flash2:");
        aClass3_1419 = JString.create("Die Verbindung konnte");
        p12_full = JString.create("p12_full");
        aClass3_1421 = JString.create("@red@");
        aClass3_1444 = JString.create("blinken2:");
        aClass3_1448 = aClass3_1443;
        aClass3_1447 = (JString.create("Wir vermuten ihr Spielkonto wurde gestohlen"));
    }
}
