package com.jagex.world.entities;

import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import com.jagex.utils.Bzip2Block;
import com.jagex.io.CacheIO;
import com.jagex.awt.JCanvas;
import unpackaged.Class1;
import unpackaged.Class14;
import unpackaged.Class2;
import unpackaged.Class25;
import unpackaged.Class26;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class32;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub4;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class63;
import unpackaged.Class65;
import com.jagex.Client;
import com.jagex.awt.JApplet;
import com.jagex.io.FileLoader;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.awt.events.JMouseListener;
import com.jagex.config.Model;
import com.jagex.od.OndemandRequest;
import com.jagex.config.Widget;

/* Class39_Sub5_Sub4_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class GroundItem extends Entity
{
    public static int[][] anIntArrayArray2233;
    public static JString aClass3_2234;
    public static JString aClass3_2235
	= JString.create("Angreifen");
    public static JString aClass3_2236;
    public static JString aClass3_2237
	= JString.create("und loggen sich dann erneut ein)3");
    public static int cameraPositionX;
    public static int anInt2239 = -1;
    public static Model[] aClass39_Sub5_Sub4_Sub6Array2240;
    public static Npc[] npcs;
    public static int anInt2242;
    public int itemAmount;
    public static JString aClass3_2244;
    public static int[] anIntArray2245;
    public static JString aClass3_2246;
    public static int[] anIntArray2247;
    public int itemId;
    public static JString aClass3_2249;
    
    public static void method501(byte i) {
	aClass3_2244 = null;
	anIntArrayArray2233 = null;
	aClass3_2246 = null;
	anIntArray2247 = null;
	npcs = null;
	aClass3_2236 = null;
	aClass39_Sub5_Sub4_Sub6Array2240 = null;
	aClass3_2235 = null;
	anIntArray2245 = null;
	aClass3_2234 = null;
	aClass3_2249 = null;
	aClass3_2237 = null;
    }
    
    public Model method489(boolean bool) {
	if (bool != true)
	    return null;
	return Class26.getItemDefinition(itemId).getModel(itemAmount, true,
							  (byte) -124);
    }
    
    public static IndexedColorSprite method503(AbstractFileLoader class9, int i,
						    int i_0_, boolean bool) {
	if (!Client.decodeSprite(class9, i_0_, i))
	    return null;
	return Bzip2Block.method1036(false);
    }
    
    public static Widget method504
	(int i, int i_1_, int i_2_, Widget class39_sub5_sub17,
	 Widget class39_sub5_sub17_3_) {
	Widget class39_sub5_sub17_4_
	    = Class39_Sub5_Sub7.method585(class39_sub5_sub17_3_.id, i,
					  class39_sub5_sub17_3_.width,
					  (AbstractMidiHandler
					   .widgets
					   [(class39_sub5_sub17_3_.id
					     >> 16)]),
					  i_1_,
					  class39_sub5_sub17_3_.scrollX,
					  class39_sub5_sub17_3_.height,
					  class39_sub5_sub17, i_2_, 0, -123,
					  class39_sub5_sub17_3_.scrollY);
	if (class39_sub5_sub17_4_ != null)
	    return class39_sub5_sub17_4_;
	if (class39_sub5_sub17_3_.children != null)
	    class39_sub5_sub17_4_
		= Class39_Sub5_Sub7.method585(class39_sub5_sub17_3_.id,
					      i,
					      class39_sub5_sub17_3_.width,
					      (class39_sub5_sub17_3_
					       .children),
					      i_1_,
					      class39_sub5_sub17_3_.scrollX,
					      class39_sub5_sub17_3_.height,
					      class39_sub5_sub17, 0, 0, -114,
					      class39_sub5_sub17_3_.scrollY);
	return class39_sub5_sub17_4_;
    }
    
    public static int getItemAmount(int id, int itemId) {
	ItemContainer container = ((ItemContainer) Class14.itemContainerCache.get((long) id));
	if (container == null) {
            return 0;
        }
	if (itemId == -1) {
            return 0;
        }
	int amount = 0;
	for (int i = 0; i < container.itemAmts.length; i++) {
	    if (itemId == container.itemIds[i]) {
                amount += container.itemAmts[i];
            }
	}
	return amount;
    }
    
    public static int method506(int i, int i_9_, byte i_10_) {
	if (i == -2)
	    return 12345678;
	if (i == -1) {
	    if (i_9_ < 0)
		i_9_ = 0;
	    else if (i_9_ > 127)
		i_9_ = 127;
	    i_9_ = -i_9_ + 127;
	    return i_9_;
	}
	i_9_ = i_9_ * (i & 0x7f) / 128;
	if (i_9_ >= 2) {
	    if (i_9_ > 126)
		i_9_ = 126;
	} else
	    i_9_ = 2;
	return (i & 0xff80) + i_9_;
    }
    
    static {
	aClass3_2236
	    = JString
		  .create("Anmelde)2Zeitlimit -Uberschritten)3");
	anIntArrayArray2233
	    = (new int[][]
	       { { 6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433,
		   2983, 54193 },
		 { 8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094,
		   10153, 56621, 4783, 1341, 16578, 35003, 25239 },
		 { 25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430,
		   24094, 10153, 56621, 4783, 1341, 16578, 35003 },
		 { 4626, 11146, 6439, 12, 4758, 10270 },
		 { 4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574 } });
	aClass3_2234
	    = JString.create("Ung-Ultiges Anmelde)2Paket)3");
	aClass39_Sub5_Sub4_Sub6Array2240 = new Model[4];
	npcs
	    = new Npc[32768];
	anInt2242 = 0;
	aClass3_2244
	    = JString.create("Diese Welt ist voll)3");
	aClass3_2246 = JString.create("@or2@");
	aClass3_2249
	    = JString
		  .create("Bitte starten Sie eine Mitgliedschaft");
    }
}
