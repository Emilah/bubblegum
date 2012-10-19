package com.jagex.world;

/* Class10 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.od.OndemandRequest;
import com.jagex.config.ObjectDefinition;
import com.jagex.io.FileLoader;
import com.jagex.awt.JCanvas;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.utils.HashTable;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.utils.Cache;
import java.awt.Frame;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class25;
import unpackaged.Class30;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub5_Sub12;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MsTimer;
import unpackaged.Class47;
import com.jagex.audio.AudioHandler;
import com.jagex.audio.AbstractMidiHandler;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class66;
import com.jagex.utils.JRuntimeException;

public class Barrier
{
    public int anInt151;
    public int anInt152;
    public int anInt153;
    public Entity aClass39_Sub5_Sub4_154;
    public static int anInt155;
    public int anInt156;
    public int anInt157 = 0;
    public int anInt158;
    public int anInt159;
    public static JString commandPrefixJstr = JString.create("::");
    public int anInt161;
    public int anInt162;
    public static Frame frame;
    public static JString aClass3_164
	= JString.create("This world is running a closed Beta)3");
    public static JString mutePlayerOptionOffJstrEng;
    public static JString aClass3_166;
    public static JString aClass3_167;
    public static JString aClass3_168;
    public int anInt169;
    public static JString aClass3_170;
    public int anInt171 = 0;
    public static volatile int queuedMousePositionY;
    public static JString mutePlayerOptionOffJstr;
    public int anInt174;
    public int anInt175;
    
    public static IndexedColorSprite[] method179(byte i) {
	IndexedColorSprite[] class39_sub5_sub10_sub4s
	    = new IndexedColorSprite[JSocket.anInt302];
	for (int i_0_ = 0; i_0_ < JSocket.anInt302; i_0_++) {
	    IndexedColorSprite class39_sub5_sub10_sub4
		= (class39_sub5_sub10_sub4s[i_0_]
		   = new IndexedColorSprite());
	    class39_sub5_sub10_sub4.anInt2482 = Class13.anInt203;
	    class39_sub5_sub10_sub4.anInt2483 = Class39_Sub5_Sub12.anInt1854;
	    class39_sub5_sub10_sub4.offsetX
		= MsTimer.anIntArray1548[i_0_];
	    class39_sub5_sub10_sub4.offsetY
		= SubNode.anIntArray1352[i_0_];
	    class39_sub5_sub10_sub4.anInt2480
		= Class39_Sub5_Sub9.anIntArray1799[i_0_];
	    class39_sub5_sub10_sub4.anInt2481
		= Class39_Sub14.anIntArray1512[i_0_];
	    class39_sub5_sub10_sub4.colors
		= StillObject.anIntArray1460;
	    class39_sub5_sub10_sub4.index
		= TraversalMap.aByteArrayArray517[i_0_];
	}
	JRuntimeException.method1123();
	return class39_sub5_sub10_sub4s;
    }
    
    public static void handleLoginError(int i, int i_1_) {
	if (i == -3)
	    Class37.method349(8845, Class14.aClass3_214, Class14.aClass3_247,
			      Queue.aClass3_976);
	else if (i != -2) {
	    if (i != -1) {
		if (i != 3) {
		    if (i != 4) {
			if (i != 5) {
			    if (i != 6) {
				if (i == 7)
				    Class37.method349(8845,
						      Class65.aClass3_1142,
						      Class14.aClass3_252,
						      Cache.aClass3_105);
				else if (i == 8)
				    Class37.method349(8845,
						      JCanvas.aClass3_16,
						      Class14.aClass3_269,
						      Class13.aClass3_206);
				else if (i == 9)
				    Class37.method349(8845,
						      Class25.aClass3_458,
						      Class14.aClass3_273,
						      (Projectile
						       .aClass3_2182));
				else if (i == 10)
				    Class37.method349(8845,
						      Class63.aClass3_1119,
						      Class14.aClass3_272,
						      Class13.aClass3_207);
				else if (i != 11) {
				    if (i == 12)
					Class37.method349(i_1_ + 8821,
							  TextConstants.aClass3_616,
							  Class14.aClass3_266,
							  PlayerApperance.aClass3_865);
				    else if (i == 13)
					Class37.method349(8845,
							  Class14.aClass3_219,
							  Class14.aClass3_265,
							  HashTable.aClass3_385);
				    else if (i != 14) {
					if (i != 16) {
					    if (i != 17) {
						if (i == 18)
						    Class37.method349
							(8845,
							 Class66.aClass3_1162,
							 Class14.aClass3_271,
							 Class14.aClass3_215);
						else if (i != 19) {
						    if (i == 20)
							Class37.method349
							    (8845,
							     (Class14
							      .aClass3_217),
							     (Class14
							      .aClass3_268),
							     (Class13
							      .aClass3_209));
						    else if (i == 22)
							Class37.method349
							    (i_1_ ^ 0x2295,
							     (Class20
							      .aClass3_387),
							     (Class14
							      .aClass3_251),
							     (Class66
							      .aClass3_1165));
						    else if (i != 23) {
							if (i != 24) {
							    if (i != 25) {
								if (i == 26)
								    Class37
									.method349
									(8845,
									 (Queue
									  .aClass3_977),
									 (Class14
									  .aClass3_258),
									 (Class39_Sub5_Sub5
									  .aClass3_1745));
								else if (i
									 != 27)
								    Class37
									.method349
									(8845,
									 (Class14
									  .aClass3_234),
									 (Class14
									  .aClass3_260),
									 (TextConstants
									  .aClass3_1234));
								else
								    Class37
									.method349
									(8845,
									 (Cache
									  .aClass3_114),
									 (Class14
									  .aClass3_242),
									 (Class14
									  .aClass3_254));
							    } else
								Class37
								    .method349
								    ((i_1_
								      + 8821),
								     (Class14
								      .aClass3_212),
								     (Class14
								      .aClass3_261),
								     (Class63
								      .aClass3_1123));
							} else
							    Class37.method349
								(i_1_ ^ 0x2295,
								 (Class25
								  .aClass3_460),
								 (Class14
								  .aClass3_237),
								 (ISAAC
								  .aClass3_1082));
						    } else
							Class37.method349
							    (8845,
							     (Class23
							      .aClass3_424),
							     (Class14
							      .aClass3_248),
							     (TextConstants
							      .aClass3_1264));
						} else
						    Class37.method349
							(8845,
							 (TextConstants
							  .aClass3_1593),
							 Class65.aClass3_1140,
							 aClass3_168);
					    } else
						Class37.method349
						    (i_1_ + 8821,
						     Class47.aClass3_895,
						     Class14.aClass3_249,
						     Class14.aClass3_223);
					} else
					    Class37.method349
						(8845, Class30.aClass3_537,
						 Class14.aClass3_270,
						 (Class39_Sub5_Sub5
						  .aClass3_1736));
				    } else
					Class37.method349(8845,
							  Class23.aClass3_427,
							  Class14.aClass3_236,
							  (AudioHandler
							   .aClass3_1116));
				} else
				    Class37.method349(8845, Class4.aClass3_68,
						      Class14.aClass3_257,
						      (Projectile
						       .aClass3_2196));
			    } else
				Class37.method349(8845,
						  (StillGraphic
						   .aClass3_2327),
						  Class14.aClass3_243,
						  AudioHandler.aClass3_1109);
			} else
			    Class37.method349(8845, Class4.aClass3_59,
					      Class14.aClass3_259,
					      Class39_Sub5_Sub5.aClass3_1747);
		    } else
			Class37.method349(8845, TextConstants.aClass3_1721,
					  Class14.aClass3_255,
					  FileLoader.aClass3_1286);
		} else
		    Class37.method349(i_1_ + 8821, Class39_Sub14.aClass3_1521,
				      Class14.aClass3_244,
				      Class14.aClass3_253);
	    } else
		Class37.method349(8845, Class14.aClass3_220,
				  Class14.aClass3_250,
				  ObjectDefinition.aClass3_1973);
	} else
	    Class37.method349(i_1_ ^ 0x2295, JSocket.aClass3_299,
			      Class14.aClass3_263, Class14.aClass3_240);
	Client.setState(10);
    }
    
    public static void method181(int i) {
	aClass3_167 = null;
	aClass3_168 = null;
	mutePlayerOptionOffJstrEng = null;
	aClass3_170 = null;
	mutePlayerOptionOffJstr = null;
	frame = null;
	int i_2_ = 104 / ((i + 2) / 60);
	commandPrefixJstr = null;
	aClass3_166 = null;
	aClass3_164 = null;
    }
    
    static {
	anInt155 = 0;
	aClass3_168 = aClass3_164;
	aClass3_170 = (JString.create
		       ("Diese Betatest)2Welt ist nur f-Ur eingeladene"));
	aClass3_167
	    = (JString.create
	       ("Bitte schlie-8en Sie die momentan ge-Offnete Benutzeroberfl-=che)1 bevor Sie die (WRegelversto-8 melden(W Option benutzen"));
	mutePlayerOptionOffJstrEng
	    = (JString.create
	       ("Moderator option: Mute player for 48 hours: <OFF>"));
	mutePlayerOptionOffJstr = mutePlayerOptionOffJstrEng;
	aClass3_166
	    = (JString.create
	       ("Wir vermuten)1 dass jemand Ihr Passwort kennt)3"));
	queuedMousePositionY = -1;
    }
}
