package unpackaged;

import com.jagex.utils.ClassCheckRequest;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.world.entities.StillObject;
import com.jagex.config.VarpDefinition;
import com.jagex.utils.MouseRecorder;
import com.jagex.script.ScriptState;
import com.jagex.script.ClientScript;
import com.jagex.utils.MsTimer;
import com.jagex.world.Mob;
import com.jagex.od.OndemandRequest;
import com.jagex.io.FileLoader;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.io.CacheIO;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.BitmapFont;
import com.jagex.graphics.DrawingArea;
import com.jagex.graphics.AbstractImage;
import com.jagex.od.OndemandHandler;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.utils.Queue;
import com.jagex.utils.Deque;
import com.jagex.utils.Cache;

/* Class32 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class32
{
    public boolean aBoolean574 = true;
    public int anInt575;
    public int anInt576;
    public static JString aClass3_577;
    public static JString aClass3_578
	= JString.create("Passwort: ");
    public int anInt579;
    public int anInt580;
    public static JString aClass3_581
	= JString.create("Private chat");
    public int anInt582;
    public int anInt584;
    public static AbstractImage aClass57_585;
    public static int[] anIntArray586;
    public static BitmapFont aClass39_Sub5_Sub10_Sub1_587;
    public static JString aClass3_588;
    public static int anInt589;
    public static int anInt590;
    public static JString aClass3_591;
    public static JString aClass3_592;
    public static JString underscoreJstr;
    
    public static int method323(int i, int i_0_, int i_1_, int i_2_) {
	int i_3_ = i_1_ / i;
	int i_4_ = i_2_ / i;
	int i_5_ = i - 1 & i_1_;
	int i_6_ = i_2_ & i - 1;
	int i_7_ = Class39_Sub14.method878(-26, i_4_, i_3_);
	int i_8_ = Class39_Sub14.method878(-26, i_4_, i_3_ + 1);
	int i_9_ = Class39_Sub14.method878(-26, i_4_ + 1, i_3_);
	int i_10_ = Class39_Sub14.method878(-26, i_4_ + 1, i_3_ + 1);
	int i_11_ = ClassCheckRequest.method851(i_5_, i_8_, i_7_, i, -247888528);
	int i_12_ = ClassCheckRequest.method851(i_5_, i_10_, i_9_, i, -247888528);
	return ClassCheckRequest.method851(i_6_, i_12_, i_11_, i, -247888528);
    }
    
    public static void method324(int i) {
	aClass3_588 = null;
	anIntArray586 = null;
	aClass3_581 = null;
	aClass3_591 = null;
	OndemandHandler.regularRequestsQueue = null;
	underscoreJstr = null;
	aClass39_Sub5_Sub10_Sub1_587 = null;
	aClass3_578 = null;
	aClass3_592 = null;
	aClass57_585 = null;
	aClass3_577 = null;
    }
    
    public static void method325(byte i) {
	Class39_Sub5_Sub14.aBoolean1908 = true;
	ISAAC.method1043(-1540585334);
	if (!Class39_Sub12.aBoolean1489) {
	    if (Mob.keyboardInputType != 1) {
		if (Mob.keyboardInputType == 2) {
		    aClass39_Sub5_Sub10_Sub1_587.method629
			(StillGraphic.aClass3_2340, 239, 40, 0);
		    aClass39_Sub5_Sub10_Sub1_587.method629
			(Class39_Sub5_Sub11.join((new JString[]
						       { Class66.inputMessageJstr,
							 (ScriptState
							  .aClass3_456) })),
			 239, 60, 128);
		} else if (Mob.keyboardInputType == 3) {
		    if (Class66.aClass3_1159 != Class66.inputMessageJstr) {
			Class2.method52(Class66.inputMessageJstr, false);
			Class66.aClass3_1159 = Class66.inputMessageJstr;
		    }
		    BitmapFont class39_sub5_sub10_sub1
			= Class39_Sub5_Sub14.p12fullFont;
		    DrawingArea.setDimensions(0, 0, 463, 77);
		    for (int i_13_ = 0; i_13_ < Class67.anInt1184; i_13_++) {
			int i_14_
			    = i_13_ * 14 + (18 - Class39_Sub14.anInt1511);
			if (i_14_ > 0 && i_14_ < 110)
			    class39_sub5_sub10_sub1.method629
				(MsTimer.aClass3Array1552[i_13_], 239,
				 i_14_, 0);
		    }
		    DrawingArea.resetDimensions();
		    if (Class67.anInt1184 > 5)
			Class4.method102(463, Class39_Sub14.anInt1511,
					 Class67.anInt1184 * 14 + 7, 0, 18734,
					 77);
		    if (Class66.inputMessageJstr.getLength() != 0) {
			if (Class67.anInt1184 == 0)
			    aClass39_Sub5_Sub10_Sub1_587
				.method629(Bzip2Entry.aClass3_1050, 239, 40, 0);
		    } else
			aClass39_Sub5_Sub10_Sub1_587
			    .method629(ISAAC.aClass3_1098, 239, 40, 255);
		    class39_sub5_sub10_sub1.method629
			(Class39_Sub5_Sub11.join((new JString[]
						       { Class66.inputMessageJstr,
							 (ScriptState
							  .aClass3_456) })),
			 239, 90, 0);
		    DrawingArea.drawHorizontalLine(0, 77, 479, 0);
		} else if (TextConstants.aClass3_1714 != null) {
		    aClass39_Sub5_Sub10_Sub1_587.method625((TextConstants
							    .aClass3_1714),
							   10, 20, 459, 40, 0,
							   false, 1, 1, 0);
		    aClass39_Sub5_Sub10_Sub1_587.method629((ClientScript
							    .aClass3_1701),
							   239, 80, 128);
		} else if (Class39_Sub5_Sub14.chatboxOverlayId == -1) {
		    if (ISAAC.chatboxWidgetId != -1) {
			boolean bool
			    = Deque.drawWidgets(96, 479, 0, ISAAC.chatboxWidgetId,
						0, -1, 3);
			if (!bool)
			    Class14.aBoolean245 = true;
		    } else {
			BitmapFont font  = Class39_Sub5_Sub14.p12fullFont;
			DrawingArea.setDimensions(0, 0, 463, 77);
			int i_15_ = 0;
			for (int i_16_ = 0; i_16_ < 100; i_16_++) {
			    if (Class2.messageBodies[i_16_] != null) {
				int type = Client.messageTypes[i_16_];
				JString prefix = StillObject.messagePrefixes[i_16_];
				int i_18_ = -(i_15_ * 14) + Node.anInt741 + 70;
				int i_19_ = 0;
				if (prefix != null
				    && prefix.beginsWith(Class37.crown1Jstr)) {
				    prefix = prefix.substring(5);
				    i_19_ = 1;
				}
				if (prefix != null
				    && prefix.beginsWith(Class53.crown2Jstr)) {
				    prefix = prefix.substring(5);
				    i_19_ = 2;
				}
				if (type == 0) {
				    i_15_++;
				    if (i_18_ > 0 && i_18_ < 110)
					font.method647(Class2.messageBodies[i_16_], 4, i_18_, 0);
				}
				if ((type == 1 || type == 2)
				    && (type == 1 || Bzip2Entry.anInt1051 == 0
					|| (Bzip2Entry.anInt1051 == 1
					    && JString.method60(21469,
							       prefix)))) {
				    if (i_18_ > 0 && i_18_ < 110) {
					int i_20_ = 4;
					if (i_19_ == 1) {
					    TextureLoaderImpl
						.aClass39_Sub5_Sub10_Sub4Array1247
						[0]
						.method695(i_20_, i_18_ - 12);
					    i_20_ += 14;
					}
					if (i_19_ == 2) {
					    TextureLoaderImpl
						.aClass39_Sub5_Sub10_Sub4Array1247
						[1]
						.method695(i_20_, i_18_ - 12);
					    i_20_ += 14;
					}
					font.method647
					    ((Class39_Sub5_Sub11.join
					      ((new JString[]
						{ prefix, (TextConstants
							   .colon) }))),
					     i_20_, i_18_, 0);
					i_20_ += font
						     .method637(prefix) + 8;
					font.method647
					    (Class2.messageBodies[i_16_],
					     i_20_, i_18_, 255);
				    }
				    i_15_++;
				}
				if ((type == 3 || type == 7)
				    && Class2.anInt53 == 0
				    && (type == 7 || NameTable.anInt177 == 0
					|| (NameTable.anInt177 == 1
					    && JString.method60(21469,
							       prefix)))) {
				    i_15_++;
				    if (i_18_ > 0 && i_18_ < 110) {
					int i_21_ = 4;
					font.method647
					    (VarpDefinition.aClass3_1991,
					     i_21_, i_18_, 0);
					i_21_ += (font
						      .method637
						  (VarpDefinition
						   .aClass3_1991));
					i_21_ += font
						     .method645(32);
					if (i_19_ == 1) {
					    TextureLoaderImpl
						.aClass39_Sub5_Sub10_Sub4Array1247
						[0]
						.method695(i_21_, i_18_ - 12);
					    i_21_ += 14;
					}
					if (i_19_ == 2) {
					    TextureLoaderImpl
						.aClass39_Sub5_Sub10_Sub4Array1247
						[1]
						.method695(i_21_, i_18_ - 12);
					    i_21_ += 14;
					}
					font.method647
					    ((Class39_Sub5_Sub11.join
					      ((new JString[]
						{ prefix, (TextConstants
							   .colon) }))),
					     i_21_, i_18_, 0);
					i_21_ += font
						     .method637(prefix) + 8;
					font.method647
					    (Class2.messageBodies[i_16_],
					     i_21_, i_18_, 8388608);
				    }
				}
				if (type == 4
				    && (Cache.anInt118 == 0
					|| (Cache.anInt118 == 1
					    && JString.method60(21469,
							       prefix)))) {
				    if (i_18_ > 0 && i_18_ < 110)
					font.method647
					    ((Class39_Sub5_Sub11.join
					      ((new JString[]
						{ prefix,
						  Class62_Sub2.spaceJstr,
						  (Class2.messageBodies
						   [i_16_]) }))),
					     4, i_18_, 8388736);
				    i_15_++;
				}
				if (type == 5 && Class2.anInt53 == 0
				    && NameTable.anInt177 < 2) {
				    if (i_18_ > 0 && i_18_ < 110)
					font.method647
					    (Class2.messageBodies[i_16_], 4,
					     i_18_, 8388608);
				    i_15_++;
				}
				if (type == 6 && Class2.anInt53 == 0
				    && NameTable.anInt177 < 2) {
				    if (i_18_ > 0 && i_18_ < 110) {
					font.method647
					    ((Class39_Sub5_Sub11.join
					      ((new JString[]
						{ Class39_Sub14.toJstr,
						  Class62_Sub2.spaceJstr,
						  prefix,
						  (TextConstants
						   .colon) }))),
					     4, i_18_, 0);
					font.method647
					    (Class2.messageBodies[i_16_],
					     (font.method637
					      (Class39_Sub5_Sub11.join
					       ((new JString[]
						 { Class39_Sub14.toJstr,
						   Class62_Sub2.spaceJstr,
						   prefix })))) + 12,
					     i_18_, 8388608);
				    }
				    i_15_++;
				}
				if (type == 8
				    && (Cache.anInt118 == 0
					|| (Cache.anInt118 == 1
					    && JString.method60(21469,
							       prefix)))) {
				    i_15_++;
				    if (i_18_ > 0 && i_18_ < 110)
					font.method647
					    ((Class39_Sub5_Sub11.join
					      ((new JString[]
						{ prefix,
						  Class62_Sub2.spaceJstr,
						  (Class2.messageBodies
						   [i_16_]) }))),
					     4, i_18_, 8270336);
				}
			    }
			}
			DrawingArea.resetDimensions();
			Deque.anInt912 = i_15_ * 14 + 7;
			if (Deque.anInt912 < 78)
			    Deque.anInt912 = 78;
			Class4.method102(463,
					 (-Node.anInt741 + Deque.anInt912
					  - 77),
					 Deque.anInt912, 0, 18734, 77);
			JString class3;
			if (Cache.localPlayer != null
			    && (Cache.localPlayer
				.aClass3_2521) != null)
			    class3 = (Cache.localPlayer
				      .aClass3_2521);
			else
			    class3 = Class39_Sub5_Sub14.username;
			font.method647
			    ((Class39_Sub5_Sub11.join
			      (new JString[] { class3,
					      TextConstants.colon })),
			     4, 90, 0);
			font.method647
			    (Class39_Sub5_Sub11.join((new JString[]
							   { (Class66
							      .chatMessageJstr),
							     (ScriptState
							      .aClass3_456) })),
			     (font.method637
			      (Class39_Sub5_Sub11.join
			       (new JString[] { class3, MouseRecorder.colonJstr }))) + 6,
			     90, 255);
			DrawingArea.drawHorizontalLine(0, 77, 479, 0);
		    }
		} else {
		    boolean bool
			= Deque.drawWidgets(96, 479, 0,
					    Class39_Sub5_Sub14.chatboxOverlayId, 0,
					    -1, 2);
		    if (!bool)
			Class14.aBoolean245 = true;
		}
	    } else {
		aClass39_Sub5_Sub10_Sub1_587.method629(PlayerApperance.aClass3_859,
						       239, 40, 0);
		aClass39_Sub5_Sub10_Sub1_587.method629
		    (Class39_Sub5_Sub11.join((new JString[]
						   { Class66.inputMessageJstr,
						     ScriptState.aClass3_456 })),
		     239, 60, 128);
	    }
	} else {
	    aClass39_Sub5_Sub10_Sub1_587.method629(Class66.aClass3_1150, 239,
						   40, 0);
	    aClass39_Sub5_Sub10_Sub1_587.method629
		(Class39_Sub5_Sub11.join((new JString[]
					       { Class66.socialListMessage,
						 ScriptState.aClass3_456 })),
		 239, 60, 128);
	}
	int i_22_ = 32 % ((24 - i) / 50);
	if (Class39_Sub12.aBoolean1493 && Class37.anInt653 == 2)
	    Class1.method49(-53);
	CacheIO.method127(17);
    }
    
    public Class32(int i, int i_23_, int i_24_, int i_25_, int i_26_,
		   int i_27_, boolean bool) {
	anInt584 = i_27_;
	anInt576 = i_23_;
	anInt580 = i_24_;
	aBoolean574 = bool;
	anInt582 = i_25_;
	anInt575 = i;
	anInt579 = i_26_;
    }
    
    public static int method326(int i) {
	return FileLoader.anInt1302++;
    }
    
    static {
	aClass3_577 = aClass3_581;
	aClass3_588 = JString.create("::fpsoff");
	underscoreJstr = JString.create("_");
	aClass3_591
	    = JString
		  .create("Enter name of player to delete from list");
	aClass3_592 = aClass3_591;
	anInt589 = (int) (Math.random() * 17.0) - 8;
    }
}
