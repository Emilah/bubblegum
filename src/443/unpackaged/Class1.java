package unpackaged;

import com.jagex.world.Entity;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.script.ScriptState;
import com.jagex.script.ClientScript;
import com.jagex.config.Widget;
import com.jagex.audio.AudioHandler;
import com.jagex.world.Mob;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.NpcDefinition;
import com.jagex.awt.JCanvas;
import com.jagex.awt.listeners.JMouseListener;
import com.jagex.awt.listeners.JKeyListener;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.DrawingArea;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.AbstractImage;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;

/* Class1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class1
{
    public static int[] anIntArray29;
    public static int[] anIntArray30;
    public static int pendingPriorityRequests;
    public static Class39_Sub1_Sub1 aClass39_Sub1_Sub1_32;
    public static int anInt33 = 0;
    public static JString friendListIsFullJstrEng
	= (JString.create
	   ("Your friendlist is full)3 Max of 100 for free users)1 and 200 for members"));
    public static JString[] aClass3Array35;
    public static int anInt36;
    public static int[] anIntArray37;
    public static int[] anIntArray38;
    public static int[] anIntArray39;
    public static int[] anIntArray40;
    public static int[] anIntArray41;
    public static int[] anIntArray42;
    public static JString aClass3_43;
    public static JString aClass3_44;
    
    public static void method45(int i, boolean bool) {
	for (int i_0_ = 0; i_0_ < ArchiveWorker.anInt1210; i_0_++) {
	    Npc class39_sub5_sub4_sub4_sub1
		= (GroundItem.npcs
		   [Entity.anIntArray1734[i_0_]]);
	    int i_1_
		= (Entity.anIntArray1734[i_0_] << 14) + 536870912;
	    if (class39_sub5_sub4_sub4_sub1 != null
		&& class39_sub5_sub4_sub4_sub1.method510((byte) -77)
		&& !(class39_sub5_sub4_sub4_sub1.definition
		     .aBoolean1883) == !bool
		&& class39_sub5_sub4_sub4_sub1.definition
		       .method716(true)) {
		int i_2_ = class39_sub5_sub4_sub4_sub1.fPositionY >> 7;
		int i_3_ = class39_sub5_sub4_sub4_sub1.fPositionX >> 7;
		if (i_2_ >= 0 && i_2_ < 104 && i_3_ >= 0 && i_3_ < 104) {
		    if (class39_sub5_sub4_sub4_sub1.anInt2297 == 1
			&& (class39_sub5_sub4_sub4_sub1.fPositionY & 0x7f) == 64
			&& ((class39_sub5_sub4_sub4_sub1.fPositionX & 0x7f)
			    == 64)) {
			if (ScriptState.anIntArrayArray455[i_2_][i_3_]
			    == JCanvas.anInt15)
			    continue;
			ScriptState.anIntArrayArray455[i_2_][i_3_]
			    = JCanvas.anInt15;
		    }
		    if (!class39_sub5_sub4_sub4_sub1.definition
			 .aBoolean1886)
			i_1_ -= -2147483648;
		    Class44.world.method375
			(NameTable.height,
			 class39_sub5_sub4_sub4_sub1.fPositionY,
			 class39_sub5_sub4_sub4_sub1.fPositionX,
			 (Class14.method212
			  ((class39_sub5_sub4_sub4_sub1.fPositionY
                            + ((class39_sub5_sub4_sub4_sub1.anInt2297 - 1)
                               * 64)), ((class39_sub5_sub4_sub4_sub1.anInt2297 - 1) * 64
			    + class39_sub5_sub4_sub4_sub1.fPositionX), NameTable.height)),
			 class39_sub5_sub4_sub4_sub1.anInt2297 * 64 - 4,
			 class39_sub5_sub4_sub4_sub1,
			 class39_sub5_sub4_sub4_sub1.anInt2251, i_1_,
			 class39_sub5_sub4_sub4_sub1.aBoolean2298);
		}
	    }
	}
    }
    
    public static ClientScript getClientScript(int scriptId) {
	ClientScript clientScript = ((ClientScript) PlayerApperance.clientScriptCache.get((long) scriptId));
	if (clientScript != null)
	    return clientScript;
	byte[] is = Class33.fileLoader12.lookupFile(scriptId, 0);
	if (is == null)
	    return null;
	clientScript = new ClientScript();
	Buffer buffer = new Buffer(is);
	buffer.offset = buffer.payload.length - 12;
	int amountOpcodes = buffer.getDword();
	clientScript.amountIntVars = buffer.getUword();
	clientScript.amountStrVars = buffer.getUword();
	clientScript.amountIntParams = buffer.getUword();
	int offset = 0;
	clientScript.amountStrParams = buffer.getUword();
	clientScript.strOperands = new JString[amountOpcodes];
	clientScript.opcodes = new int[amountOpcodes];
	clientScript.intOperands = new int[amountOpcodes];
	buffer.offset = 0;
	while (buffer.offset < buffer.payload.length - 12) {
	    int operand = buffer.getUword();
	    if (operand != 3) {
		if (operand < 100 && operand != 21 && operand != 38 && operand != 39)
		    clientScript.intOperands[offset] = buffer.getDword();
		else
		    clientScript.intOperands[offset] = buffer.getUbyte();
	    } else
		clientScript.strOperands[offset] = buffer.getJstr();
	    clientScript.opcodes[offset++] = operand;
	}
	PlayerApperance.clientScriptCache.put(clientScript, (long) scriptId);
	return clientScript;
    }
    
    public static void method47(int i) {
	friendListIsFullJstrEng = null;
	anIntArray42 = null;
	aClass39_Sub1_Sub1_32 = null;
	anIntArray30 = null;
	anIntArray40 = null;
	aClass3_43 = null;
	anIntArray41 = null;
	aClass3_44 = null;
	anIntArray39 = null;
	anIntArray29 = null;
	aClass3Array35 = null;
	anIntArray38 = null;
	anIntArray37 = null;
    }
    
    public static void method48(boolean bool) {
	Class43.anInt829 = 0;
	for (int i = -1; i < ArchiveWorker.anInt1210 + TraversalMap.anInt515; i++) {
	    Mob class39_sub5_sub4_sub4;
	    if (i == -1)
		class39_sub5_sub4_sub4
		    = Cache.localPlayer;
	    else if (TraversalMap.anInt515 > i)
		class39_sub5_sub4_sub4
		    = (Class14.players
		       [anIntArray40[i]]);
	    else
		class39_sub5_sub4_sub4
		    = (GroundItem
		       .npcs
		       [(Entity.anIntArray1734
			 [-TraversalMap.anInt515 + i])]);
	    if (class39_sub5_sub4_sub4 != null
		&& class39_sub5_sub4_sub4.method510((byte) -77)) {
		if (class39_sub5_sub4_sub4
		    instanceof Npc) {
		    NpcDefinition class39_sub5_sub13
			= (((Npc)
			    class39_sub5_sub4_sub4)
			   .definition);
		    if (class39_sub5_sub13.anIntArray1878 != null)
			class39_sub5_sub13
			    = class39_sub5_sub13.method721(5585);
		    if (class39_sub5_sub13 == null)
			continue;
		}
		if (TraversalMap.anInt515 > i) {
		    Player class39_sub5_sub4_sub4_sub2
			= (Player) class39_sub5_sub4_sub4;
		    int i_8_ = 30;
		    if (class39_sub5_sub4_sub4_sub2.anInt2509 != -1
			|| class39_sub5_sub4_sub4_sub2.anInt2507 != -1) {
			JKeyListener.method346((byte) -11,
					  (class39_sub5_sub4_sub4.anInt2308
					   + 15),
					  class39_sub5_sub4_sub4);
			if (Class14.anInt224 > -1) {
			    if (class39_sub5_sub4_sub4_sub2.anInt2509 != -1) {
				MouseRecorder.aClass39_Sub5_Sub10_Sub3Array573
				    [class39_sub5_sub4_sub4_sub2.anInt2509]
				    .method670
				    (Class14.anInt224 - 12,
				     -i_8_ + Class53.anInt962);
				i_8_ += 25;
			    }
			    if (class39_sub5_sub4_sub4_sub2.anInt2507 != -1) {
				AudioHandler.aClass39_Sub5_Sub10_Sub3Array1106
				    [class39_sub5_sub4_sub4_sub2.anInt2507]
				    .method670
				    (Class14.anInt224 - 12,
				     -i_8_ + Class53.anInt962);
				i_8_ += 25;
			    }
			}
		    }
		    if (i >= 0 && JMouseListener.anInt787 == 10
			&& Class34.anInt607 == anIntArray40[i]) {
			JKeyListener.method346((byte) -11,
					  (class39_sub5_sub4_sub4.anInt2308
					   + 15),
					  class39_sub5_sub4_sub4);
			if (Class14.anInt224 > -1)
			    Class20.aClass39_Sub5_Sub10_Sub3Array392[1]
				.method670
				(Class14.anInt224 - 12,
				 Class53.anInt962 - i_8_);
		    }
		} else {
		    NpcDefinition class39_sub5_sub13
			= (((Npc)
			    class39_sub5_sub4_sub4)
			   .definition);
		    if (class39_sub5_sub13.anInt1871 >= 0
			&& (AudioHandler.aClass39_Sub5_Sub10_Sub3Array1106.length
			    > class39_sub5_sub13.anInt1871)) {
			JKeyListener.method346((byte) -11,
					  (class39_sub5_sub4_sub4.anInt2308
					   + 15),
					  class39_sub5_sub4_sub4);
			if (Class14.anInt224 > -1)
			    AudioHandler.aClass39_Sub5_Sub10_Sub3Array1106
				[class39_sub5_sub13.anInt1871].method670
				(Class14.anInt224 - 12, Class53.anInt962 - 30);
		    }
		    if (JMouseListener.anInt787 == 1
			&& (Entity.anIntArray1734
			    [i - TraversalMap.anInt515]) == Class30.anInt542
			&& Class2.logicCycle % 20 < 10) {
			JKeyListener.method346((byte) -11,
					  (class39_sub5_sub4_sub4.anInt2308
					   + 15),
					  class39_sub5_sub4_sub4);
			if (Class14.anInt224 > -1)
			    Class20.aClass39_Sub5_Sub10_Sub3Array392[0]
				.method670
				(Class14.anInt224 - 12, Class53.anInt962 - 28);
		    }
		}
		if (class39_sub5_sub4_sub4.aClass3_2295 != null
		    && (i >= TraversalMap.anInt515 || Bzip2Entry.anInt1051 == 0
			|| Bzip2Entry.anInt1051 == 3
			|| (Bzip2Entry.anInt1051 == 1
			    && JString.method60(21469,
					       (((Player)
						 class39_sub5_sub4_sub4)
						.aClass3_2521))))) {
		    JKeyListener.method346((byte) -11,
				      class39_sub5_sub4_sub4.anInt2308,
				      class39_sub5_sub4_sub4);
		    if (Class14.anInt224 > -1 && anInt36 > Class43.anInt829) {
			anIntArray39[Class43.anInt829]
			    = (Class32.aClass39_Sub5_Sub10_Sub1_587.method637
			       (class39_sub5_sub4_sub4.aClass3_2295)) / 2;
			anIntArray38[Class43.anInt829]
			    = Class32.aClass39_Sub5_Sub10_Sub1_587.anInt2425;
			anIntArray29[Class43.anInt829] = Class14.anInt224;
			anIntArray41[Class43.anInt829] = Class53.anInt962;
			anIntArray42[Class43.anInt829]
			    = class39_sub5_sub4_sub4.anInt2296;
			anIntArray37[Class43.anInt829]
			    = class39_sub5_sub4_sub4.anInt2271;
			anIntArray30[Class43.anInt829]
			    = class39_sub5_sub4_sub4.anInt2259;
			aClass3Array35[Class43.anInt829]
			    = class39_sub5_sub4_sub4.aClass3_2295;
			Class43.anInt829++;
		    }
		}
		if (Class2.logicCycle < class39_sub5_sub4_sub4.anInt2252) {
		    JKeyListener.method346((byte) -11,
				      class39_sub5_sub4_sub4.anInt2308 + 15,
				      class39_sub5_sub4_sub4);
		    if (Class14.anInt224 > -1) {
			int i_9_ = (class39_sub5_sub4_sub4.anInt2318 * 30
				    / class39_sub5_sub4_sub4.anInt2269);
			if (i_9_ > 30)
			    i_9_ = 30;
			DrawingArea.drawQuad(Class14.anInt224 - 15,
						     Class53.anInt962 - 3,
						     i_9_, 5, 65280);
			DrawingArea.drawQuad((Class14.anInt224 - 15
						      + i_9_),
						     Class53.anInt962 - 3,
						     -i_9_ + 30, 5, 16711680);
		    }
		}
		for (int i_10_ = 0; i_10_ < 4; i_10_++) {
		    if (class39_sub5_sub4_sub4.anIntArray2286[i_10_]
			> Class2.logicCycle) {
			JKeyListener.method346((byte) -11,
					  class39_sub5_sub4_sub4.anInt2308 / 2,
					  class39_sub5_sub4_sub4);
			if (Class14.anInt224 > -1) {
			    if (i_10_ == 1)
				Class53.anInt962 -= 20;
			    if (i_10_ == 2) {
				Class53.anInt962 -= 10;
				Class14.anInt224 -= 15;
			    }
			    if (i_10_ == 3) {
				Class14.anInt224 += 15;
				Class53.anInt962 -= 10;
			    }
			    VarpDefinition
				.aClass39_Sub5_Sub10_Sub3Array1992
				[class39_sub5_sub4_sub4.anIntArray2258[i_10_]]
				.method670
				(Class14.anInt224 - 12, Class53.anInt962 - 12);
			    Npc
				.aClass39_Sub5_Sub10_Sub1_2495.method629
				(AbstractImage.toJstr((class39_sub5_sub4_sub4
						     .anIntArray2273[i_10_])),
				 Class14.anInt224, Class53.anInt962 + 4, 0);
			    Npc
				.aClass39_Sub5_Sub10_Sub1_2495.method629
				(AbstractImage.toJstr((class39_sub5_sub4_sub4
						     .anIntArray2273[i_10_])),
				 Class14.anInt224 - 1, Class53.anInt962 + 3,
				 16777215);
			}
		    }
		}
	    }
	}
	for (int i = 0; Class43.anInt829 > i; i++) {
	    int i_11_ = anIntArray41[i];
	    int i_12_ = anIntArray38[i];
	    int i_13_ = anIntArray29[i];
	    int i_14_ = anIntArray39[i];
	    boolean bool_15_ = true;
	    while (bool_15_) {
		bool_15_ = false;
		for (int i_16_ = 0; i_16_ < i; i_16_++) {
		    if (i_11_ + 2 > anIntArray41[i_16_] - anIntArray38[i_16_]
			&& -i_12_ + i_11_ < anIntArray41[i_16_] + 2
			&& (anIntArray39[i_16_] + anIntArray29[i_16_]
			    > i_13_ - i_14_)
			&& (anIntArray29[i_16_] - anIntArray39[i_16_]
			    < i_14_ + i_13_)
			&& (-anIntArray38[i_16_] + anIntArray41[i_16_]
			    < i_11_)) {
			bool_15_ = true;
			i_11_ = -anIntArray38[i_16_] + anIntArray41[i_16_];
		    }
		}
	    }
	    Class14.anInt224 = anIntArray29[i];
	    Class53.anInt962 = anIntArray41[i] = i_11_;
	    JString class3 = aClass3Array35[i];
	    if (Class68.anInt1190 == 0) {
		int i_17_ = 16776960;
		if (anIntArray42[i] < 6)
		    i_17_ = SubNode.anIntArray1342[anIntArray42[i]];
		if (anIntArray42[i] == 6)
		    i_17_
			= JCanvas.anInt15 % 20 < 10 ? 16711680 : 16776960;
		if (anIntArray42[i] == 7)
		    i_17_ = JCanvas.anInt15 % 20 >= 10 ? 65535 : 255;
		if (anIntArray42[i] == 8)
		    i_17_ = JCanvas.anInt15 % 20 >= 10 ? 8454016 : 45056;
		if (anIntArray42[i] == 9) {
		    int i_18_ = 150 - anIntArray30[i];
		    if (i_18_ < 50)
			i_17_ = 16711680 + i_18_ * 1280;
		    else if (i_18_ < 100)
			i_17_ = -((i_18_ - 50) * 327680) + 16776960;
		    else if (i_18_ < 150)
			i_17_ = 65280 + (i_18_ - 100) * 5;
		}
		if (anIntArray42[i] == 10) {
		    int i_19_ = -anIntArray30[i] + 150;
		    if (i_19_ >= 50) {
			if (i_19_ < 100)
			    i_17_ = -(i_19_ * 327680) + 16711935 + 16384000;
			else if (i_19_ < 150)
			    i_17_ = -(i_19_ * 5) + (-32768000 + i_19_ * 327680
						    + 500 + 255);
		    } else
			i_17_ = i_19_ * 5 + 16711680;
		}
		if (anIntArray42[i] == 11) {
		    int i_20_ = 150 - anIntArray30[i];
		    if (i_20_ < 50)
			i_17_ = -(i_20_ * 327685) + 16777215;
		    else if (i_20_ < 100)
			i_17_ = i_20_ * 327685 - 16384250 + 65280;
		    else if (i_20_ < 150)
			i_17_ = 16777215 - (i_20_ - 100) * 327680;
		}
		if (anIntArray37[i] == 0) {
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method629
			(class3, Class14.anInt224, Class53.anInt962 + 1, 0);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method629
			(class3, Class14.anInt224, Class53.anInt962, i_17_);
		}
		if (anIntArray37[i] == 1) {
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method638
			(class3, Class14.anInt224, Class53.anInt962 + 1, 0,
			 JCanvas.anInt15);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method638
			(class3, Class14.anInt224, Class53.anInt962, i_17_,
			 JCanvas.anInt15);
		}
		if (anIntArray37[i] == 2) {
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method644
			(class3, Class14.anInt224, Class53.anInt962 + 1, 0,
			 JCanvas.anInt15);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method644
			(class3, Class14.anInt224, Class53.anInt962, i_17_,
			 JCanvas.anInt15);
		}
		if (anIntArray37[i] == 3) {
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method626
			(class3, Class14.anInt224, Class53.anInt962 + 1, 0,
			 JCanvas.anInt15, -anIntArray30[i] + 150);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method626
			(class3, Class14.anInt224, Class53.anInt962, i_17_,
			 JCanvas.anInt15, 150 - anIntArray30[i]);
		}
		if (anIntArray37[i] == 4) {
		    int i_21_ = Class32.aClass39_Sub5_Sub10_Sub1_587
				    .method637(class3);
		    int i_22_ = (150 - anIntArray30[i]) * (i_21_ + 100) / 150;
		    DrawingArea.setDimensions(Class14.anInt224 - 50, 0,
						 Class14.anInt224 + 50, 334);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method647
			(class3, -i_22_ + 50 + Class14.anInt224,
			 Class53.anInt962 + 1, 0);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method647
			(class3, Class14.anInt224 + 50 - i_22_,
			 Class53.anInt962, i_17_);
		    DrawingArea.resetDimensions();
		}
		if (anIntArray37[i] == 5) {
		    int i_23_ = 0;
		    int i_24_ = 150 - anIntArray30[i];
		    DrawingArea.setDimensions
			(0,
			 (-Class32.aClass39_Sub5_Sub10_Sub1_587.anInt2425 - 1
			  + Class53.anInt962),
			 512, Class53.anInt962 + 5);
		    if (i_24_ >= 25) {
			if (i_24_ > 125)
			    i_23_ = i_24_ - 125;
		    } else
			i_23_ = i_24_ - 25;
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method629
			(class3, Class14.anInt224,
			 Class53.anInt962 + (i_23_ + 1), 0);
		    Class32.aClass39_Sub5_Sub10_Sub1_587.method629
			(class3, Class14.anInt224, Class53.anInt962 + i_23_,
			 i_17_);
		    DrawingArea.resetDimensions();
		}
	    } else {
		Class32.aClass39_Sub5_Sub10_Sub1_587.method629
		    (class3, Class14.anInt224, Class53.anInt962 + 1, 0);
		Class32.aClass39_Sub5_Sub10_Sub1_587.method629
		    (class3, Class14.anInt224, Class53.anInt962, 16776960);
	    }
	}
    }
    
    public static void method49(int i) {
	int i_25_ = Class39_Sub5_Sub7.anInt1784;
	int i_26_ = Class14.anInt227;
	int i_27_ = Widget.anInt2063;
	int i_28_ = 6116423;
	int i_29_ = Huffman.anInt757;
	DrawingArea.drawQuad(i_27_, i_25_, i_26_, i_29_, i_28_);
	DrawingArea.drawQuad(i_27_ + 1, i_25_ + 1, i_26_ - 2, 16, 0);
	DrawingArea.drawQuadOutline(i_27_ + 1, i_25_ + 18, i_26_ - 2,
				     i_29_ - 19, 0);
	Class32.aClass39_Sub5_Sub10_Sub1_587
	    .method647(Wall.aClass3_647, i_27_ + 3, i_25_ + 14, i_28_);
	int i_30_ = Class33.mousePositionY;
	int i_31_ = ISAAC.mousePositionX;
	if (Class37.anInt653 == 0) {
	    i_30_ -= 4;
	    i_31_ -= 4;
	}
	if (Class37.anInt653 == 1) {
	    i_31_ -= 553;
	    i_30_ -= 205;
	}
	if (Class37.anInt653 == 2) {
	    i_31_ -= 17;
	    i_30_ -= 357;
	}
	for (int i_32_ = 0; Class39_Sub5_Sub11.actionOffset > i_32_; i_32_++) {
	    int i_33_ = 16777215;
	    int i_34_ = (i_25_ + 31
			 + (-i_32_ + (Class39_Sub5_Sub11.actionOffset - 1)) * 15);
	    if (i_27_ < i_31_ && i_27_ + i_26_ > i_31_ && i_30_ > i_34_ - 13
		&& i_30_ < i_34_ + 3)
		i_33_ = 16776960;
	    Class32.aClass39_Sub5_Sub10_Sub1_587.method635((Class33
							    .actionNames
							    [i_32_]),
							   i_27_ + 3, i_34_,
							   i_33_, true);
	}
    }
    
    public static void method50(int i) {
	int i_35_ = 256;
	for (int i_36_ = 10; i_36_ < 117; i_36_++) {
	    int i_37_ = (int) (Math.random() * 100.0);
	    if (i_37_ < 50)
		ArchiveWorker.anIntArray1202[(i_35_ - 2 << 7) + i_36_] = 255;
	}
	for (int i_38_ = 0; i_38_ < 100; i_38_++) {
	    int i_39_ = (int) (Math.random() * 128.0) + 128;
	    int i_40_ = (int) (Math.random() * 124.0) + 2;
	    int i_41_ = (i_39_ << 7) + i_40_;
	    ArchiveWorker.anIntArray1202[i_41_] = 192;
	}
	for (int i_42_ = 1; i_42_ < i_35_ - 1; i_42_++) {
	    for (int i_43_ = 1; i_43_ < 127; i_43_++) {
		int i_44_ = i_43_ + (i_42_ << 7);
		Class53.anIntArray969[i_44_]
		    = (ArchiveWorker.anIntArray1202[i_44_ - 128]
		       + (ArchiveWorker.anIntArray1202[i_44_ - 1]
			  + ArchiveWorker.anIntArray1202[i_44_ + 1]
			  + ArchiveWorker.anIntArray1202[i_44_ + 128])) / 4;
	    }
	}
	Class39_Sub5_Sub7.anInt1783 += 128;
	if (Class39_Sub5_Sub7.anInt1783 > Cache.anIntArray112.length) {
	    int i_45_ = (int) (Math.random() * 12.0);
	    Class39_Sub5_Sub7.anInt1783 -= Cache.anIntArray112.length;
	    Bzip2Entry.method1034((AbstractImage.aClass39_Sub5_Sub10_Sub4Array1002
				[i_45_]),
			       (byte) -107);
	}
	for (int i_46_ = 1; i_46_ < i_35_ - 1; i_46_++) {
	    for (int i_47_ = 1; i_47_ < 127; i_47_++) {
		int i_48_ = (i_46_ << 7) + i_47_;
		int i_49_ = (Class53.anIntArray969[i_48_ + 128]
			     - (Cache.anIntArray112
				[(Class39_Sub5_Sub7.anInt1783 + i_48_
				  & Cache.anIntArray112.length - 1)]) / 5);
		if (i_49_ < 0)
		    i_49_ = 0;
		ArchiveWorker.anIntArray1202[i_48_] = i_49_;
	    }
	}
	for (int i_50_ = 0; i_50_ < i_35_ - 1; i_50_++)
	    Huffman.anIntArray762[i_50_] = Huffman.anIntArray762[i_50_ + 1];
	Huffman.anIntArray762[i_35_ - 1]
	    = (int) (Math.sin((double) Class2.logicCycle / 14.0) * 16.0
		     + Math.sin((double) Class2.logicCycle / 15.0) * 14.0
		     + Math.sin((double) Class2.logicCycle / 16.0) * 12.0);
	if (Class20.anInt397 > 0)
	    Class20.anInt397 -= 4;
	if (JCanvas.anInt24 > 0)
	    JCanvas.anInt24 -= 4;
	if (Class20.anInt397 == 0 && JCanvas.anInt24 == 0) {
	    int i_51_ = (int) (Math.random() * 2000.0);
	    if (i_51_ == 0)
		Class20.anInt397 = 1024;
	    if (i_51_ == 1)
		JCanvas.anInt24 = 1024;
	}
    }
    
    static {
	pendingPriorityRequests = 0;
	anIntArray40 = new int[2048];
	aClass3_44 = friendListIsFullJstrEng;
	aClass3_43
	    = JString
		  .create("Fehler beim Laden Ihres Spielcharakters)3");
	anInt36 = 50;
	anIntArray38 = new int[anInt36];
	anIntArray39 = new int[anInt36];
	anIntArray29 = new int[anInt36];
	anIntArray41 = new int[anInt36];
	anIntArray30 = new int[anInt36];
	aClass3Array35 = new JString[anInt36];
	anIntArray42 = new int[anInt36];
	anIntArray37 = new int[anInt36];
    }
}
