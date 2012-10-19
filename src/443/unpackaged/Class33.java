package unpackaged;

import com.jagex.world.entities.StillObject;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.utils.NameTable;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.utils.Queue;
import com.jagex.utils.Cache;

/* Class33 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class33
{
    public static JString aClass3_594;
    public static JString aClass3_595
	= JString.create("mapmarker");
    public static byte[][][] aByteArrayArrayArray596;
    public static JString aClass3_597
	= JString.create("mapscene");
    public static int[] anIntArray598 = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2,
					  2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
    public static int mousePositionY = 0;
    public static FileLoader[] fileLoaders = new FileLoader[256];
    public static JString[] actionNames;
    public static int[][] anIntArrayArray602;
    public static FileLoader fileLoader12;
    
    public static boolean method327(int i, byte i_0_) {
	if (i < 0)
	    return false;
	int i_1_ = KeyListenerImpl.actionTypes[i];
	if (i_1_ >= 2000)
	    i_1_ -= 2000;
	if (i_1_ == 31)
	    return true;
	return false;
    }
    
    public static void method328(byte i, AbstractFileLoader class9) {
	Queue.aClass9_971 = class9;
    }
    
    public static void method329(int i) {
	aClass3_595 = null;
	fileLoader12 = null;
	aClass3_594 = null;
	anIntArray598 = null;
	actionNames = null;
	anIntArrayArray602 = null;
	fileLoaders = null;
	aClass3_597 = null;
	aByteArrayArrayArray596 = null;
    }
    
    public static int method330(int i) {
	int i_2_ = 3;
	if (Class43.anInt799 < 310) {
	    int i_3_ = StillObject.fCameraPositionX >> 7;
	    int i_4_ = Node.fCameraPositionY >> 7;
	    int i_5_ = Cache.localPlayer.fPositionX >> 7;
	    if ((TextureLoaderImpl.tileFlags[NameTable.height][i_3_][i_4_]
		 & 0x4)
		!= 0)
		i_2_ = NameTable.height;
	    int i_6_ = Cache.localPlayer.fPositionY >> 7;
	    int i_7_;
	    if (i_4_ < i_5_)
		i_7_ = i_5_ - i_4_;
	    else
		i_7_ = i_4_ - i_5_;
	    int i_8_;
	    if (i_6_ > i_3_)
		i_8_ = i_6_ - i_3_;
	    else
		i_8_ = i_3_ - i_6_;
	    if (i_7_ >= i_8_) {
		int i_9_ = i_8_ * 65536 / i_7_;
		int i_10_ = 32768;
		while (i_4_ != i_5_) {
		    if (i_5_ <= i_4_) {
			if (i_5_ < i_4_)
			    i_4_--;
		    } else
			i_4_++;
		    i_10_ += i_9_;
		    if (((TextureLoaderImpl.tileFlags[NameTable.height]
			  [i_3_][i_4_])
			 & 0x4)
			!= 0)
			i_2_ = NameTable.height;
		    if (i_10_ >= 65536) {
			if (i_6_ > i_3_)
			    i_3_++;
			else if (i_3_ > i_6_)
			    i_3_--;
			i_10_ -= 65536;
			if (((TextureLoaderImpl.tileFlags
			      [NameTable.height][i_3_][i_4_])
			     & 0x4)
			    != 0)
			    i_2_ = NameTable.height;
		    }
		}
	    } else {
		int i_11_ = i_7_ * 65536 / i_8_;
		int i_12_ = 32768;
		while (i_6_ != i_3_) {
		    if (i_6_ > i_3_)
			i_3_++;
		    else if (i_6_ < i_3_)
			i_3_--;
		    if (((TextureLoaderImpl.tileFlags[NameTable.height]
			  [i_3_][i_4_])
			 & 0x4)
			!= 0)
			i_2_ = NameTable.height;
		    i_12_ += i_11_;
		    if (i_12_ >= 65536) {
			i_12_ -= 65536;
			if (i_4_ >= i_5_) {
			    if (i_5_ < i_4_)
				i_4_--;
			} else
			    i_4_++;
			if (((TextureLoaderImpl.tileFlags
			      [NameTable.height][i_3_][i_4_])
			     & 0x4)
			    != 0)
			    i_2_ = NameTable.height;
		    }
		}
	    }
	}
	if (((TextureLoaderImpl.tileFlags[NameTable.height]
	      [Cache.localPlayer.fPositionY >> 7]
	      [Cache.localPlayer.fPositionX >> 7])
	     & 0x4)
	    != 0)
	    i_2_ = NameTable.height;
	return i_2_;
    }
    
    public static void method331(int i) {
	for (StillObject class39_sub11
		 = (StillObject) Class15.stillObjects.getFirst();
	     class39_sub11 != null;
	     class39_sub11 = ((StillObject)
			      Class15.stillObjects.getNext())) {
	    if (class39_sub11.anInt1456 == -1) {
		class39_sub11.anInt1476 = 0;
		Class66.method1106(1, class39_sub11);
	    } else
		class39_sub11.unlinkDeque();
	}
	if (i != -1)
	    aByteArrayArrayArray596 = null;
    }
    
    static {
	aClass3_594 = JString.create("Fallen lassen");
	anIntArrayArray602 = new int[104][104];
	actionNames = new JString[500];
    }
}
