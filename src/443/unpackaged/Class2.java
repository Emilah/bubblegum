package unpackaged;

/* Class2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.MsTimer;
import com.jagex.utils.Timer;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.config.ItemDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.Client;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.graphics.JImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.JString;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Cache;
import java.math.BigInteger;

public class Class2
{
    public static JString aClass3_45
	= JString.create("@gr1@");
    public static JString aClass3_46
	= JString.create("RuneScape wurde aktualisiert(Q");
    public static BigInteger aBigInteger47;
    public static int logicCycle = 0;
    public static int[] anIntArray49 = new int[5];
    public static int anInt50;
    public static JString aClass3_51;
    public static JString[] messageBodies;
    public static int anInt53;
    public static Cache aClass7_54;
    public static volatile long aLong55;
    public static JString aClass3_56;
    public static JString aClass3_57;
    public static Cache widgetModelCache;
    
    public static synchronized long getSystemTime() {
	long l = System.currentTimeMillis();
	if (l < HashTable.aLong381)
	    Client.aLong1263 += HashTable.aLong381 + -l;
	HashTable.aLong381 = l;
	return Client.aLong1263 + l;
    }
    
    public static void method52(JString class3, boolean bool) {
	if (class3 == null || class3.getLength() == 0)
	    Class67.anInt1184 = 0;
	else {
	    int i = 0;
	    JString[] class3s = new JString[100];
	    JString class3_0_ = class3;
	    for (;;) {
		int i_1_ = class3_0_.method92((byte) 123, 32);
		if (i_1_ == -1) {
		    class3_0_ = class3_0_.method69();
		    if (class3_0_.getLength() > 0)
			class3s[i++] = class3_0_.method77();
		    break;
		}
		JString class3_2_
		    = class3_0_.substring(0, i_1_).method69();
		if (class3_2_.getLength() > 0)
		    class3s[i++] = class3_2_.method77();
		class3_0_ = class3_0_.substring(i_1_ + 1);
	    }
	    Class67.anInt1184 = 0;
	while_1_:
	    for (int i_3_ = 0; Class37.anInt663 > i_3_; i_3_++) {
		ItemDefinition class39_sub5_sub1
		    = Class26.getItemDefinition(i_3_);
		if (class39_sub5_sub1.anInt1644 == -1
		    && class39_sub5_sub1.name != null) {
		    JString class3_4_
			= class39_sub5_sub1.name.method77();
		    for (int i_5_ = 0; i > i_5_; i_5_++) {
			if (class3_4_.method80(22938, class3s[i_5_]) == -1)
			    continue while_1_;
		    }
		    MsTimer.aClass3Array1552[Class67.anInt1184]
			= class3_4_;
		    AbstractMidiHandler.anIntArray1589[Class67.anInt1184] = i_3_;
		    Class67.anInt1184++;
		    if (Class67.anInt1184
			>= MsTimer.aClass3Array1552.length)
			break;
		}
	    }
	}
    }
    
    public static void method53(int i) {
	aClass3_51 = null;
	aClass3_46 = null;
	anIntArray49 = null;
	messageBodies = null;
	aClass3_57 = null;
	widgetModelCache = null;
	aBigInteger47 = null;
	aClass7_54 = null;
	aClass3_45 = null;
	aClass3_56 = null;
    }
    
    public static void parsePlayerUpdate() {
	Huffman.anInt749 = 0;
	JImage.anInt1586 = 0;
	StillGraphic.parseLocalPlayerUpdate();
	AbstractFileLoader.parsePlayerMovementUpdates();
	JImage.parsePopulateUpdate((byte) 127);
	Timer.method936((byte) -101);
	for (int i_6_ = 0; Huffman.anInt749 > i_6_; i_6_++) {
	    int i_7_ = Class26.anIntArray496[i_6_];
	    if (Class14.players[i_7_].anInt2290
		!= logicCycle)
		Class14.players[i_7_] = null;
	}
	if (Huffman.frameSize
	    != Class39_Sub5_Sub11.incomingBuffer.offset)
	    throw new RuntimeException("gpp1 pos:"
				       + (Class39_Sub5_Sub11
					  .incomingBuffer.offset)
				       + " psize:" + Huffman.frameSize);
	for (int i_8_ = 0; i_8_ < TraversalMap.anInt515; i_8_++) {
	    if ((Class14.players
		 [Class1.anIntArray40[i_8_]])
		== null)
		throw new RuntimeException("gpp2 pos:" + i_8_ + " size:"
					   + TraversalMap.anInt515);
	}
    }
    
    static {
	aBigInteger47
	    = (new BigInteger
	       ("58778699976184461502525193738213253649000149147835990136706041084440742975821"));
	aClass3_51 = JString.create("Loaded input handler");
	messageBodies = new JString[100];
	aClass3_56
	    = (JString.create
	       ("Ung-Ultige Verbindung mit einem Anmelde)2Server)3"));
	anInt53 = 0;
	aClass3_57 = aClass3_51;
	aLong55 = 0L;
	aClass7_54 = new Cache(64);
	widgetModelCache = new Cache(50);
    }
}
