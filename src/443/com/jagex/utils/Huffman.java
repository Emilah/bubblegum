package com.jagex.utils;

/* Class40 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.utils.Queue;
import com.jagex.io.Buffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import unpackaged.Class14;
import unpackaged.Class37;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub18;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class43;
import unpackaged.Class68;
import com.jagex.io.AbstractFileLoader;
import com.jagex.sign.Signlink;
import com.jagex.config.Widget;

public class Huffman
{
    public byte[] lengths;
    public static JString aClass3_745;
    public static JString aClass3_746;
    public static JString aClass3_747
	= JString.create("gelb:");
    public static int anInt748;
    public static int anInt749;
    public static JString aClass3_750
	= JString.create("leuchten3:");
    public static JString mutePlayerOptionOnJstr;
    public static long aLong752;
    public static JString aClass3_753;
    public static int frameSize;
    public static JString aClass3_755;
    public static int anInt756;
    public static int anInt757;
    public static JString aClass3_758;
    public int[] codes;
    public static AbstractFileLoader aClass9_760;
    public int[] codeTree;
    public static int[] anIntArray762;
    public static JString aClass3_763;
    public static boolean isFlagged;
    
    public static Class39_Sub5_Sub18 method881(int i, int i_0_) {
	Class39_Sub5_Sub18 class39_sub5_sub18
	    = ((Class39_Sub5_Sub18)
	       Class4.aClass7_70.get((long) i_0_));
	if (class39_sub5_sub18 != null)
	    return class39_sub5_sub18;
	byte[] is = Class43.aClass9_816.lookupFile(13, i_0_);
	class39_sub5_sub18 = new Class39_Sub5_Sub18();
	class39_sub5_sub18.anInt2137 = i_0_;
	if (is != null)
	    class39_sub5_sub18.method779(180, new Buffer(is));
	Class4.aClass7_70.put(class39_sub5_sub18, (long) i_0_);
	return class39_sub5_sub18;
    }
    
    public static void method882(int i) {
	if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
	    Player.keycodeValues[189] = 26;
	    Player.keycodeValues[192] = 58;
	    Player.keycodeValues[187] = 27;
	    Player.keycodeValues[186] = 57;
	    Player.keycodeValues[221] = 43;
	    Player.keycodeValues[220] = 74;
	    Player.keycodeValues[188] = 71;
	    Player.keycodeValues[190] = 72;
	    Player.keycodeValues[222] = 59;
	    Player.keycodeValues[191] = 73;
	    Player.keycodeValues[223] = 28;
	    Player.keycodeValues[219] = 42;
	} else {
	    Player.keycodeValues[45] = 26;
	    Player.keycodeValues[61] = 27;
	    if (Signlink.aMethod398 == null) {
		Player.keycodeValues[222] = 59;
		Player.keycodeValues[192] = 58;
	    } else {
		Player.keycodeValues[520] = 59;
		Player.keycodeValues[192] = 28;
		Player.keycodeValues[222] = 58;
	    }
	    Player.keycodeValues[44] = 71;
	    Player.keycodeValues[91] = 42;
	    Player.keycodeValues[47] = 73;
	    Player.keycodeValues[59] = 57;
	    Player.keycodeValues[92] = 74;
	    Player.keycodeValues[46] = 72;
	    Player.keycodeValues[93] = 43;
	}
    }
    
    public static boolean parseClientScript(Widget widget) {
	if (widget.conditionOpcodes == null)
	    return false;
	for (int i = 0; widget.conditionOpcodes.length > i; i++) {
	    int value = Class68.getConditionValue(widget, i);
	    int compareTo = widget.conditionValues[i];
	    if (widget.conditionOpcodes[i] == 2) {
		if (compareTo <= value)
		    return false;
	    } else if (widget.conditionOpcodes[i] == 3) {
		if (compareTo >= value)
		    return false;
	    } else if (widget.conditionOpcodes[i] != 4) {
		if (value != compareTo)
		    return false;
	    } else if (value == compareTo)
		return false;
	}
	return true;
    }
    
    public static String method884(Throwable throwable)
	throws IOException {
	String errorString;
	if (throwable instanceof JRuntimeException) {
	    JRuntimeException exception = (JRuntimeException) throwable;
	    throwable = exception.cause;
	    errorString = exception.message + " | ";
	} else
	    errorString = "";
	StringWriter stringwriter = new StringWriter();
	PrintWriter printwriter = new PrintWriter(stringwriter);
	throwable.printStackTrace(printwriter);
	printwriter.close();
	String string_4_ = stringwriter.toString();
	BufferedReader bufferedreader = new BufferedReader(new StringReader(string_4_));
	String string_5_ = bufferedreader.readLine();
	for (;;) {
	    String string_6_ = bufferedreader.readLine();
	    if (string_6_ == null)
		break;
	    int i_7_ = string_6_.indexOf('(');
	    int i_8_ = string_6_.indexOf(')', i_7_ + 1);
	    if (i_7_ >= 0 && i_8_ >= 0) {
		String string_9_ = string_6_.substring(i_7_ + 1, i_8_);
		int i_10_ = string_9_.indexOf(".java:");
		if (i_10_ >= 0) {
		    string_9_ = (string_9_.substring(0, i_10_) + string_9_.substring(i_10_ + 5));
		    errorString += string_9_ + ' ';
		    continue;
		}
		string_6_ = string_6_.substring(0, i_7_);
	    }
	    string_6_ = string_6_.trim();
	    string_6_ = string_6_.substring(string_6_.lastIndexOf(' ') + 1);
	    string_6_ = string_6_.substring(string_6_.lastIndexOf('\t') + 1);
	    errorString += string_6_ + ' ';
	}
	errorString += "| " + (String) string_5_;
	return errorString;
    }
    
    public int decode(int destOff, byte[] dest, int length, int srcOff, byte[] src) {
	if (length == 0)
	    return 0;
	length += destOff;
	int pos = 0;
	int srcOffset = srcOff;
	for (;;) {
	    byte value = src[srcOffset];
	    if (value >= 0)
		pos++;
	    else
		pos = codeTree[pos];
	    int i_18_;
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (length <= destOff)
		    break;
		pos = 0;
	    }
	    if ((value & 0x40) == 0)
		pos++;
	    else
		pos = codeTree[pos];
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (length <= destOff)
		    break;
		pos = 0;
	    }
	    if ((value & 0x20) == 0)
		pos++;
	    else
		pos = codeTree[pos];
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (destOff >= length)
		    break;
		pos = 0;
	    }
	    if ((value & 0x10) != 0)
		pos = codeTree[pos];
	    else
		pos++;
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (destOff >= length)
		    break;
		pos = 0;
	    }
	    if ((value & 0x8) != 0)
		pos = codeTree[pos];
	    else
		pos++;
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (length <= destOff)
		    break;
		pos = 0;
	    }
	    if ((value & 0x4) == 0)
		pos++;
	    else
		pos = codeTree[pos];
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (destOff >= length)
		    break;
		pos = 0;
	    }
	    if ((value & 0x2) != 0)
		pos = codeTree[pos];
	    else
		pos++;
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (length <= destOff)
		    break;
		pos = 0;
	    }
	    if ((value & 0x1) == 0)
		pos++;
	    else
		pos = codeTree[pos];
	    if ((i_18_ = codeTree[pos]) < 0) {
		dest[destOff++] = (byte) (i_18_ ^ 0xffffffff);
		if (length <= destOff)
		    break;
		pos = 0;
	    }
	    srcOffset++;
	}
	return srcOffset + 1 - srcOff;
    }
    
    public int encode(byte[] src, int srcOff, byte[] dest, int destOff, int len) {
	len += srcOff;
	int current = 0;
	int bitOffset = destOff << 3;
	for (/**/; len > srcOff; srcOff++) {
	    int value = src[srcOff] & 0xff;
	    int codeLength = lengths[value];
	    int code = codes[value];
	    if (codeLength == 0)
		throw new RuntimeException("No codeword for data value " + value);
	    int byteOffset = bitOffset >> 3;
	    int localBit = bitOffset & 0x7;
	    current &= -localBit >> 31;
	    int endOffset = byteOffset + (codeLength + (localBit - 1) >> 3);
	    localBit += 24;
	    dest[byteOffset] = (byte) (current = Queue.or(current, code >>> localBit));
	    if (byteOffset < endOffset) {
		localBit -= 8;
		byteOffset++;
		dest[byteOffset] = (byte) (current = code >>> localBit);
		if (endOffset > byteOffset) {
		    byteOffset++;
		    localBit -= 8;
		    dest[byteOffset] = (byte) (current = code >>> localBit);
		    if (byteOffset < endOffset) {
			byteOffset++;
			localBit -= 8;
			dest[byteOffset] = (byte) (current = code >>> localBit);
			if (endOffset > byteOffset) {
			    localBit -= 8;
			    byteOffset++;
			    dest[byteOffset] = (byte) (current = code << -localBit);
			}
		    }
		}
	    }
	    bitOffset += codeLength;
	}
	return -destOff + (bitOffset + 7 >> 3);
    }
    
    public static void method887(byte i) {
	Class39_Sub5_Sub11.npcDefinitionCache.clear();
	Class37.aClass7_655.clear();
    }
    
    public static void method888(int i) {
	if (ItemContainer.aClass42_1502 != null) {
	    synchronized (ItemContainer.aClass42_1502) {
		ItemContainer.aClass42_1502 = null;
	    }
	}
	if (i != 2372)
	    aLong752 = 96L;
    }
    
    public static void updateItemContainer(int id, int slot, int itemId, int itemAmount) {
	ItemContainer container = ((ItemContainer) Class14.itemContainerCache.get((long) id));
	if (container == null) {
	    container = new ItemContainer();
	    Class14.itemContainerCache.put((long) id, container);
	}
	if (container.itemIds.length <= slot) {
	    int[] ids = new int[slot + 1];
	    int[] amts = new int[slot + 1];
	    for (int i_36_ = 0; i_36_ < container.itemIds.length; i_36_++) {
		ids[i_36_] = container.itemIds[i_36_];
		amts[i_36_] = container.itemAmts[i_36_];
	    }
	    for (int i_37_ = container.itemIds.length; i_37_ < slot; i_37_++) {
		ids[i_37_] = -1;
		amts[i_37_] = 0;
	    }
	    container.itemAmts = amts;
	    container.itemIds = ids;
	}
	container.itemIds[slot] = itemId;
	container.itemAmts[slot] = itemAmount;
    }
    
    public Huffman(byte[] src) {
	int amountCodes = src.length;
	codeTree = new int[8];
	codes = new int[amountCodes];
	int[] codeWords = new int[33];
	lengths = src;
	int nextPos = 0;
	for (int i = 0; amountCodes > i; i++) {
	    int length = src[i];
	    if (length != 0) {
		int code = codeWords[length];
		int flag = 1 << 32 - length;
		codes[i] = code;
		int newCode;
		if ((code & flag) == 0) {
		    for (int len = length - 1; len >= 1; len--) {
			int codeWord = codeWords[len];
			if (code != codeWord)
			    break;
			int codeFlag = 1 << 32 - len;
			if ((codeWord & codeFlag) == 0)
			    codeWords[len] = Queue.or(codeFlag, codeWord);
			else {
			    codeWords[len] = codeWords[len - 1];
			    break;
			}
		    }
		    newCode = flag | code;
		} else
		    newCode = codeWords[length - 1];
		codeWords[length] = newCode;
		for (int len = length + 1; len <= 32; len++) {
		    if (codeWords[len] == code)
			codeWords[len] = newCode;
		}
		int treePos = 0;
		for (int i_50_ = 0; length > i_50_; i_50_++) {
		    int activeFlag = Integer.MIN_VALUE >>> i_50_;
		    if ((activeFlag & code) != 0) {
			if (codeTree[treePos] == 0)
			    codeTree[treePos] = nextPos;
			treePos = codeTree[treePos];
		    } else
			treePos++;
		    activeFlag >>>= 1;
		    if (codeTree.length <= treePos) {
			int[] tree = new int[codeTree.length * 2];
			for (int i_53_ = 0; codeTree.length > i_53_; i_53_++)
			    tree[i_53_] = codeTree[i_53_];
			codeTree = tree;
		    }
		}
		codeTree[treePos] = i ^ 0xffffffff;
		if (nextPos <= treePos)
		    nextPos = treePos + 1;
	    }
	}
    }
    
    public static void method890(boolean bool) {
	mutePlayerOptionOnJstr = null;
	aClass9_760 = null;
	aClass3_753 = null;
	aClass3_745 = null;
	aClass3_758 = null;
	aClass3_746 = null;
	anIntArray762 = null;
	aClass3_747 = null;
	aClass3_750 = null;
	aClass3_763 = null;
	aClass3_755 = null;
    }
    
    static {
	anInt749 = 0;
	aLong752 = 0L;
	aClass3_746
	    = (JString.create
	       ("Moderator option: Mute player for 48 hours: <ON>"));
	mutePlayerOptionOnJstr = aClass3_746;
	aClass3_753
	    = JString
		  .create("Enter name of friend to delete from list");
	aClass3_745
	    = JString.create("Bitte versuchen Sie es erneut)3");
	aClass3_758
	    = JString.create("Bitte versuchen Sie)1");
	anInt748 = 0;
	aClass3_763 = (JString.create
		       ("Bitte wenden Sie sich an den Kundendienst)3"));
	anIntArray762 = new int[256];
	isFlagged = false;
	frameSize = 0;
	anInt756 = 0;
	aClass3_755 = aClass3_753;
    }
}
