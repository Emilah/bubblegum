package unpackaged;

import com.jagex.script.ClientScript;
import com.jagex.Client;
import com.jagex.config.Widget;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.world.Mob;
import com.jagex.config.ObjectDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.utils.Cache;

/* Class37 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class37
{
    public static int anInt653;
    public static boolean aBoolean654 = false;
    public static Cache aClass7_655;
    public static int anInt656;
    public static JString aClass3_657 = JString.create("K");
    public static AbstractFileLoader aClass9_658;
    public static JString aClass3_659 = aClass3_657;
    public static JString aClass3_660 = aClass3_657;
    public static JString crown1Jstr;
    public static int anInt662;
    public static int anInt663;
    public static JSocket gameSocket;
    
    public static void method349(int i, JString class3, JString class3_0_,
				 JString class3_1_) {
	Class39_Sub5_Sub14.aClass3_1896 = class3;
	Class39_Sub5_Sub14.aClass3_1916 = class3_1_;
	Class39_Sub5_Sub14.aClass3_1899 = class3_0_;
    }
    
    public static void method350(int i) {
	gameSocket = null;
	aClass7_655 = null;
	aClass3_659 = null;
	crown1Jstr = null;
	aClass3_660 = null;
	aClass3_657 = null;
	aClass9_658 = null;
    }
    
    public static void method351(int i_2_, int i_3_) {
	if (Mob.musicVolume != 0 && i_3_ != -1) {
	    Class41.method891(0, 1, false, Wall.fileLoader11, Mob.musicVolume, i_3_);
	    JSocket.anInt313 = i_2_;
	}
    }
    
    public static boolean isAlphaNumericChar(int i_4_) {
	if (i_4_ >= 97 && i_4_ <= 122)
	    return true;
	if (i_4_ >= 65 && i_4_ <= 90)
	    return true;
	if (i_4_ >= 48 && i_4_ <= 57)
	    return true;
	return false;
    }
    
    public static Widget getWidget(int widgetHash) {
	int child = widgetHash & 0xffff;
	int parent = widgetHash >> 16;
	if (AbstractMidiHandler.widgets[parent] == null || (AbstractMidiHandler.widgets[parent][child] == null)) {
	    boolean bool = JSocket.loadWidget(parent);
	    if (!bool) {
                return null;
            }
	}
	return AbstractMidiHandler.widgets[parent][child];
    }
    
    public static void method354(byte i) {
	if (ClientScript.anInt1692 > 0)
	    ISAAC.logout();
	else {
	    Client.setState(40);
	    ObjectDefinition.aClass16_1935 = gameSocket;
	    gameSocket = null;
	}
    }
    
    static {
	aClass7_655 = new Cache(50);
	crown1Jstr = JString.create("@cr1@");
	anInt662 = 1;
    }
}
