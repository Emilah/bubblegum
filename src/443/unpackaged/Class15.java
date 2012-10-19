package unpackaged;

/* Class15 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.config.VarpDefinition;
import com.jagex.sign.Signlink;
import com.jagex.io.FileLoader;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.JString;
import com.jagex.utils.Deque;
import com.jagex.audio.Effect;
import java.awt.Component;

public class Class15 {

    public static int anInt274;
    public static FileLoader fileLoader1;
    public static int anInt276;
    public static int socialListMessageType;
    public static Deque stillObjects;
    public static JString xJstr;
    public static int anInt280;
    public static long aLong281;
    public static int amountIgnores = 0;
    public static Deque classCheckRequests;
    public static JString aClass3_284;
    public static Effect[] queuedEffects;
    public static JString aClass3_286;
    public static int currentKeyCode;

    public static void method214(int i, Component component, boolean bool,
            Signlink class21, int i_0_) {
        anInt274 = i;
        StillGraphic.aBoolean2342 = bool;
        VarpDefinition.aLong1985 = Class2.getSystemTime();
        try {
            Class13_Sub1 class13_sub1 = ((Class13_Sub1) Class.forName("Class13_Sub1_Sub2").newInstance());
            class13_sub1.method202(component, i, bool);
            class13_sub1.method197(class21, 2048);
            Class20.aClass13_395 = class13_sub1;
        } catch (Throwable throwable) {
            try {
                Class13_Sub1_Sub1 class13_sub1_sub1 = new Class13_Sub1_Sub1(class21);
                class13_sub1_sub1.method202(component, i, bool);
                class13_sub1_sub1.method197(class21, 16384);
                Class20.aClass13_395 = class13_sub1_sub1;
            } catch (Throwable throwable_1_) {
                if ((Signlink.javaVendor.toLowerCase().indexOf("microsoft") ^ 0xffffffff) <= -1) {
                    try {
                        Class20.aClass13_395 = new Class13_Sub2();
                        StillGraphic.aBoolean2342 = false;
                        anInt274 = 8000;
                        return;
                    } catch (Throwable throwable_2_) {
                        /* empty */
                    }
                }
                Class20.aClass13_395 = new Class13();
            }
        }
    }

    public static void method215(byte i) {
        queuedEffects = null;
        aClass3_284 = null;
        classCheckRequests = null;
        fileLoader1 = null;
        aClass3_286 = null;
        xJstr = null;
        stillObjects = null;
    }

    static {
        anInt276 = 20;
        socialListMessageType = 0;
        xJstr = JString.create(" x");
        anInt280 = 0;
        aLong281 = 0L;
        stillObjects = new Deque();
        classCheckRequests = new Deque();
        aClass3_284 = JString.create("Loading friend list");
        queuedEffects = new Effect[50];
        aClass3_286 = aClass3_284;
    }
}
