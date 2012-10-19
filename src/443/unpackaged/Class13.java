package unpackaged;

/* Class13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.script.ScriptState;
import com.jagex.script.ClientScript;
import com.jagex.sign.Signlink;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import java.awt.Component;
import java.lang.reflect.Method;

public class Class13
{
    public static int[] anIntArray197;
    public static JString aClass3_198;
    public static JString aClass3_199;
    public static boolean[] activeKeys;
    public static JString aClass3_201
	= JString.create("flash3:");
    public static JString aClass3_202;
    public static int anInt203;
    public static JString aClass3_204
	= JString.create("Invalid loginserver requested)3");
    public static JString aClass3_205;
    public static JString aClass3_206;
    public static JString aClass3_207;
    public static int anInt208;
    public static JString aClass3_209;
    
    public void method187() {
	/* empty */
    }
    
    public static void method188(byte i, Component component) {
	Method method = Signlink.aMethod398;
	if (method != null) {
	    try {
		method.invoke(component, new Object[] { Boolean.FALSE });
	    } catch (Throwable throwable) {
		/* empty */
	    }
	}
	component.addKeyListener(Npc.aClass35_2499);
	component.addFocusListener(Npc.aClass35_2499);
    }
    
    public static int computeChecksum(byte[] src, int length) {
	return Class25.computeChecksum(src, 0, length);
    }
    
    public static synchronized void method190(int[] is, int i) {
	int i_1_ = i;
	if (StillGraphic.aBoolean2342)
	    i_1_ <<= 1;
	int i_2_ = 0;
	i_1_ -= 7;
	while (i_2_ < i_1_) {
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	    is[i_2_++] = 0;
	}
	i_1_ += 7;
	while (i_2_ < i_1_)
	    is[i_2_++] = 0;
	if (ScriptState.aClass39_Sub1_439 != null)
	    ScriptState.aClass39_Sub1_439.method415(is, 0, i);
	ClientScript.method483(0, i);
    }
    
    public static synchronized void method191(byte i,
					      Class39_Sub1 class39_sub1) {
	ScriptState.aClass39_Sub1_439 = class39_sub1;
    }
    
    public static void method192(int i) {
	aClass3_207 = null;
	aClass3_204 = null;
	aClass3_206 = null;
	aClass3_202 = null;
	aClass3_201 = null;
	aClass3_209 = null;
	anIntArray197 = null;
	aClass3_199 = null;
	aClass3_198 = null;
	aClass3_205 = null;
	if (i > -96)
	    method188((byte) -17, null);
	activeKeys = null;
    }
    
    public void method193(long l) {
	/* empty */
    }
    
    public static synchronized void method194(int i, int i_3_) {
	if (ScriptState.aClass39_Sub1_439 != null)
	    ScriptState.aClass39_Sub1_439.method417(i_3_);
	ClientScript.method483(0, i_3_);
    }
    
    static {
	anIntArray197 = new int[5];
	aClass3_198 = aClass3_201;
	aClass3_202
	    = (JString.create
	       ("Moderator)2Option: Spieler f-Ur 48 Stunden stumm schalten: <OFF>"));
	aClass3_199 = JString.create("Unable to connect)3");
	aClass3_205 = JString.create(" )2>");
	aClass3_206 = aClass3_199;
	aClass3_207 = aClass3_199;
	anInt208 = 0;
	activeKeys = new boolean[112];
	aClass3_209 = aClass3_204;
    }
}
