package unpackaged;

import com.jagex.world.Entity;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.Client;
import com.jagex.config.Widget;
import com.jagex.utils.MsTimer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.ArchiveRequest;
import com.jagex.awt.events.JMouseListener;
import com.jagex.awt.events.JKeyListener;
import com.jagex.awt.JApplet;
import com.jagex.utils.HashTable;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;

/* Class68 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class68
{
    public static JString aClass3_1185;
    public static AbstractImage aClass57_1186;
    public static JString aClass3_1187
	= JString.create("Wen m-Ochten Sie entfernen?");
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1188;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_1189;
    public static int anInt1190;
    public static JString aClass3_1191;
    public static JString nullJstr;
    public static JString aClass3_1193;
    public static JString aClass3_1194
	= JString
	      .create("Zu viele Anmelde)2Versuche von Ihrer Adresse");
    
    public static void addFriend(long l) {
	if (l != 0L) {
	    if (Class4.anInt62 >= 100 && Class63.isMember != 1
		|| Class4.anInt62 >= 200)
		JMouseListener.printMessage(0,Class66.blankString, Class1.aClass3_44);
	    else {
		JString class3
		    = Deque.decodeBase37(l).formatUsername();
		for (int i_0_ = 0; Class4.anInt62 > i_0_; i_0_++) {
		    if (JApplet.aLongArray2[i_0_] == l) {
			JMouseListener.printMessage(0,Class66.blankString,
					  (Class39_Sub5_Sub11.join
					   (new JString[] { class3,
							   (VarpDefinition
							    .aClass3_1981) })));
			return;
		    }
		}
		for (int i_1_ = 0; i_1_ < Class15.amountIgnores; i_1_++) {
		    if (l == Class39_Sub5_Sub9.ignoreUsernames[i_1_]) {
			JMouseListener.printMessage(0,Class66.blankString,
					  (Class39_Sub5_Sub11.join
					   ((new JString[]
					     { StillObject.aClass3_1454,
					       class3, Node.aClass3_727 }))));
			return;
		    }
		}
		if (!class3.isEqual((Cache.localPlayer.aClass3_2521))) {
		    Projectile.aClass3Array2188[Class4.anInt62] = class3;
		    JApplet.aLongArray2[Class4.anInt62] = l;
		    Player.anIntArray2533[Class4.anInt62] = 0;
		    Class4.anInt62++;
		    Class39_Sub14.updateTab = true;
		    FrameBuffer.outgoingBuffer.putFrame(90);
		    FrameBuffer.outgoingBuffer.putQword(l);
		}
	    }
	}
    }
    
    public static void method1112(int i, byte i_2_) {
	if (i != -1 && Entity.widgetsLoaded[i]) {
	    VarpDefinition.wigetFileLoader.removeChildBuffers(i);
	    if (AbstractMidiHandler.widgets[i] != null) {
		boolean bool = true;
		for (int i_3_ = 0;
		     i_3_ < (AbstractMidiHandler.widgets
			     [i]).length;
		     i_3_++) {
		    if (AbstractMidiHandler.widgets[i][i_3_]
			!= null) {
			if ((AbstractMidiHandler.widgets[i]
			     [i_3_].type)
			    == 2)
			    bool = false;
			else
			    AbstractMidiHandler.widgets
				[i][i_3_]
				= null;
		    }
		}
		if (bool)
		    AbstractMidiHandler.widgets[i] = null;
		Entity.widgetsLoaded[i] = false;
	    }
	}
    }
    
    public static int encodeHuffmans(Buffer class39_sub6, JString class3,
				 int i) {
	int i_4_ = class39_sub6.offset;
	class39_sub6.putSmartB(class3.length);
	class39_sub6.offset += Class25.huffmans.encode(class3.bytes, 0,
					      class39_sub6.payload,
					      class39_sub6.offset,
					      class3.length);
	return class39_sub6.offset - i_4_;
    }
    
    public static void method1114(int i) {
	aClass3_1194 = null;
	aClass39_Sub5_Sub10_Sub4_1189 = null;
	aClass3_1191 = null;
	aClass3_1187 = null;
	aClass3_1185 = null;
	aClass3_1193 = null;
	aClass57_1186 = null;
	aClass39_Sub5_Sub10_Sub4_1188 = null;
	nullJstr = null;
    }
    
    public static int getConditionValue(Widget widget, int id) {
	if (widget.scriptOpcodes == null || id >= widget.scriptOpcodes.length)
	    return -2;
	try {
	    int[] opcodes = widget.scriptOpcodes[id];
	    int offset = 0;
	    int returnValue = 0;
	    int arithmetic = 0;
	    for (;;) {
		int opcode = opcodes[offset++];
		int operator = 0;
		int queuedArithmetic = 0;
		if (opcode == 0)
		    return returnValue;
		if (opcode == 15)
		    queuedArithmetic = 1;
		if (opcode == 1)
		    operator = MouseRecorder.dynamicLevels[opcodes[offset++]];
		if (opcode == 16)
		    queuedArithmetic = 2;
		if (opcode == 17)
		    queuedArithmetic = 3;
		if (opcode == 2)
		    operator = Class39_Sub12.staticLevels[opcodes[offset++]];
		if (opcode == 3)
		    operator = Class39_Sub14.levelExperience[opcodes[offset++]];
		if (opcode == 4) {
		    int i_12_ = opcodes[offset++] << 16;
		    i_12_ += opcodes[offset++];
		    Widget class39_sub5_sub17_13_ = Class37.getWidget(i_12_);
		    int i_14_ = opcodes[offset++];
		    if (i_14_ != -1
			&& (!Class26.getItemDefinition(i_14_).aBoolean1653
			    || HashTable.members)) {
			for (int i_15_ = 0;
			     (i_15_
			      < class39_sub5_sub17_13_.itemIds.length);
			     i_15_++) {
			    if (class39_sub5_sub17_13_.itemIds[i_15_]
				== i_14_ + 1)
				operator += (class39_sub5_sub17_13_.itemAmounts
					  [i_15_]);
			}
		    }
		}
		if (opcode == 5)
		    operator = Client.stateValues[opcodes[offset++]];
		if (opcode == 6)
		    operator = (Class53.experienceForLevel
			     [Class39_Sub12.staticLevels[opcodes[offset++]] - 1]);
		if (opcode == 7)
		    operator = Client.stateValues[opcodes[offset++]] * 100 / 46875;
		if (opcode == 8)
		    operator = Cache.localPlayer.combatLevel;
		if (opcode == 9) {
		    for (int i_16_ = 0; i_16_ < 25; i_16_++) {
			if (Class50.aBooleanArray934[i_16_])
			    operator += Class39_Sub12.staticLevels[i_16_];
		    }
		}
		if (opcode == 10) {
		    int i_17_ = opcodes[offset++] << 16;
		    i_17_ += opcodes[offset++];
		    Widget class39_sub5_sub17_18_
			= Class37.getWidget(i_17_);
		    int i_19_ = opcodes[offset++];
		    if (i_19_ != -1
			&& (!Class26.getItemDefinition(i_19_).aBoolean1653
			    || HashTable.members)) {
			for (int i_20_ = 0;
			     (class39_sub5_sub17_18_.itemIds.length
			      > i_20_);
			     i_20_++) {
			    if (class39_sub5_sub17_18_.itemIds[i_20_]
				== i_19_ + 1) {
				operator = 999999999;
				break;
			    }
			}
		    }
		}
		if (opcode == 11)
		    operator = ArchiveRequest.runEnergy;
		if (opcode == 12)
		    operator = MsTimer.runEnergy;
		if (opcode == 13) {
		    int i_21_ = Client.stateValues[opcodes[offset++]];
		    int i_22_ = opcodes[offset++];
		    operator = (i_21_ & 1 << i_22_) == 0 ? 0 : 1;
		}
		if (opcode == 14) {
		    int i_23_ = opcodes[offset++];
		    operator = Class44.getVarbitValue(i_23_);
		}
		if (opcode == 18)
		    operator
			= (Class65.anInt1145
			   + (Cache.localPlayer.fPositionY
			      >> 7));
		if (opcode == 19)
		    operator = (Cache.localPlayer.fPositionX
			     >> 7) + JKeyListener.anInt618;
		if (opcode == 20)
		    operator = opcodes[offset++];
		if (queuedArithmetic != 0)
		    arithmetic = queuedArithmetic;
		else {
		    if (arithmetic == 0)
			returnValue += operator;
		    if (arithmetic == 1)
			returnValue -= operator;
		    if (arithmetic == 2 && operator != 0)
			returnValue /= operator;
		    if (arithmetic == 3)
			returnValue *= operator;
		    arithmetic = 0;
		}
	    }
	} catch (Exception exception) {
	    return -1;
	}
    }
    
    static {
	aClass3_1191 = JString.create("Schlie-8en");
	aClass3_1193 = JString.create("Duell akzeptieren");
	aClass3_1185 = (JString.create
			("Begeben Sie sich in ein freies Gebiet)1 um"));
	nullJstr = JString.create("null");
	anInt1190 = 0;
    }
}
