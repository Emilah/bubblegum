package unpackaged;

/* Class23 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.Widget;
import com.jagex.io.ArchiveRequest;
import com.jagex.od.OndemandRequest;
import com.jagex.io.AbstractFileLoader;
import com.jagex.Client;
import com.jagex.utils.NameTable;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.utils.Deque;
import com.jagex.utils.Cache;
import java.util.zip.CRC32;

public class Class23
{
    public static CRC32 crc;
    public static JString aClass3_422
	= JString.create("titlebox");
    public static int[] anIntArray423;
    public static JString aClass3_424;
    public static int anInt425;
    public static byte[][] aByteArrayArray426;
    public static JString aClass3_427;
    public static int useWithItemSlot;
    public static JString aClass3_429
	= JString.create("Please wait 1 minute and try again)3");
    public static volatile int anInt430 = 0;
    public static JString ignoreListFullJstr;
    public static JString ignoreListFullJstrEng;
    public static int archiveWorkerKeepAlive;
    public static Deque projectiles;
    public static AbstractImage graphics;
    public static int anInt436;
    public static JString okJstr;
    public static JString okJstrEng;
    
    public static void method271() {
	if (PlayerApperance.isLowMemory && NameTable.height != ImageImpl.lastHeight)
	    Client.setMapLocation(Class62_Sub2.anInt1597, Class65.anInt1147, Cache.localPlayer.queueX[0], Cache.localPlayer.queueY[0], NameTable.height);
	else if (ArchiveRequest.anInt1411 != NameTable.height) {
	    ArchiveRequest.anInt1411 = NameTable.height;
	    Deque.method958((byte) -112, NameTable.height);
	}
    }
    
    public static void method272(int i) {
	aClass3_429 = null;
	ignoreListFullJstrEng = null;
	graphics = null;
	crc = null;
	aClass3_422 = null;
	projectiles = null;
	ignoreListFullJstr = null;
	okJstrEng = null;
	okJstr = null;
	if (i != -1)
	    anInt430 = 118;
	aClass3_427 = null;
	anIntArray423 = null;
	aByteArrayArray426 = null;
	aClass3_424 = null;
    }
    
    public static DirectColorSprite[] method273
	(int i, byte i_0_, int i_1_, AbstractFileLoader class9) {
	if (!Client.decodeSprite(class9, i_1_, i))
	    return null;
	return Widget.method764(5563);
    }
    
    public static int method274(byte i) {
	int i_2_ = Class14.method212(StillObject.fCameraPositionX, Node.fCameraPositionY, NameTable.height);
	if (-Class39_Sub10.cameraHeight + i_2_ < 800
	    && ((TextureLoaderImpl.tileFlags[NameTable.height]
		 [StillObject.fCameraPositionX >> 7][Node.fCameraPositionY >> 7])
		& 0x4) != 0)
	    return NameTable.height;
	return 3;
    }
    
    static {
	aClass3_424 = aClass3_429;
	aClass3_427 = aClass3_429;
	aByteArrayArray426 = new byte[250][];
	crc = new CRC32();
	archiveWorkerKeepAlive = 0;
	ignoreListFullJstrEng
	    = JString
		  .create("Your ignore list is full)3 Max of 100 hit");
	ignoreListFullJstr = ignoreListFullJstrEng;
	projectiles = new Deque();
	anInt436 = -1;
	okJstrEng = JString.create("Ok");
	okJstr = okJstrEng;
    }
}
