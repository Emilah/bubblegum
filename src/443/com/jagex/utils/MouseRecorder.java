package com.jagex.utils;

import com.jagex.world.Mob;
import com.jagex.sign.Signlink;
import com.jagex.sign.Resource;
import com.jagex.config.VarbitDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.utils.HashTable;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.io.Buffer;
import com.jagex.od.OndemandHandler;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class39_Sub10;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class4;
import unpackaged.Class53;
import com.jagex.world.entities.player.PlayerApperance;

/* Class31 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class MouseRecorder implements Runnable
{
    public static JString aClass3_549;
    public static JString aClass3_550
	= JString.create("Ihre Nachricht an: ");
    public static AbstractImage aClass57_551;
    public static JString aClass3_552
	= JString.create("button near the top of that page)3");
    public boolean aBoolean554 = true;
    public static int[] dynamicLevels;
    public static JString colonJstr = JString.create(": ");
    public static JString aClass3_557;
    public static JString aClass3_558
	= JString.create("Hidden)2");
    public Object lock = new Object();
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array560;
    public int anInt561 = 0;
    public int[] anIntArray562 = new int[500];
    public static JString aClass3_564;
    public static JString aClass3_565;
    public static JString aClass3_566;
    public static JString aClass3_567;
    public static AbstractFileLoader itemFileLoader;
    public static JString aClass3_569;
    public static int useWithAmountChildren;
    public int[] anIntArray571 = new int[500];
    public static JString aClass3_572;
    public static DirectColorSprite[] aClass39_Sub5_Sub10_Sub3Array573;
    
    public void run() {
	while (aBoolean554) {
	    synchronized (lock) {
		if (anInt561 < 500) {
		    anIntArray571[anInt561] = ISAAC.mousePositionX;
		    anIntArray562[anInt561] = Class33.mousePositionY;
		    anInt561++;
		}
	    }
	    PlayerApperance.sleep(50L);
	}
    }
    
    public static void method320(int i) {
	if (i == -23401
	    && (Class39_Sub5_Sub11.actionOffset >= 2 || Class13.anInt208 != 0
		|| ISAAC.aBoolean1100)) {
	    JString class3;
	    if (Class13.anInt208 == 1 && Class39_Sub5_Sub11.actionOffset < 2)
		class3
		    = Class39_Sub5_Sub11.join((new JString[]
						    { (Mob
						       .useJstr),
						      Class53.spaceJstr,
						      (Class39_Sub10
						       .useWithItemJstr),
						      Class13.aClass3_205 }));
	    else if (!ISAAC.aBoolean1100
		     || Class39_Sub5_Sub11.actionOffset >= 2)
		class3 = (Class33.actionNames
			  [Class39_Sub5_Sub11.actionOffset - 1]);
	    else
		class3
		    = Class39_Sub5_Sub11.join((new JString[]
						    { TextConstants.aClass3_1273,
						      Class53.spaceJstr,
						      Class14.aClass3_216,
						      Class13.aClass3_205 }));
	    if (Class39_Sub5_Sub11.actionOffset > 2)
		class3
		    = (Class39_Sub5_Sub11.join
		       (new JString[] { class3, VarbitDefinition.aClass3_1797,
				       AbstractImage.toJstr((Class39_Sub5_Sub11
							   .actionOffset) - 2),
				       StillGraphic.aClass3_2346 }));
	    Class32.aClass39_Sub5_Sub10_Sub1_587.method639(class3, 4, 15,
							   16777215, true,
							   (Class2.logicCycle
							    / 1000));
	}
    }
    
    public static void method321(int i) {
	aClass3_564 = null;
	aClass3_566 = null;
	aClass3_572 = null;
	aClass57_551 = null;
	dynamicLevels = null;
	aClass39_Sub5_Sub10_Sub3Array560 = null;
	OndemandHandler.requests = null;
	aClass3_558 = null;
	aClass3_569 = null;
	aClass3_549 = null;
	aClass3_550 = null;
	aClass3_552 = null;
	aClass39_Sub5_Sub10_Sub3Array573 = null;
	itemFileLoader = null;
	aClass3_567 = null;
	aClass3_557 = null;
	aClass3_565 = null;
	colonJstr = null;
    }
    
    public static void parseClassCheckRequest(Signlink signlink, Buffer buffer) {
	ClassCheckRequest request = new ClassCheckRequest();
	request.size = buffer.getUint8();
	request.uid = buffer.getUint32();
	request.requestTypes = new int[request.size];
	request.fieldValues = new int[request.size];
	request.returnCodes = new int[request.size];
	request.parameterObjSrcs = new byte[request.size][][];
	request.methodResources = new Resource[request.size];
	request.fieldResources = new Resource[request.size];
	for (int i = 0; i < request.size; i++) {
	    try {
		int type = buffer.getUint8();
		if (type == 0 || type == 1 || type == 2) {
		    String className = new String(buffer.getJstr().method78(4484));
		    String fieldName = new String(buffer.getJstr().method78(4484));
		    int value = 0;
		    if (type == 1)
			value = buffer.getUint32();
		    request.requestTypes[i] = type;
		    request.fieldValues[i] = value;
		    request.fieldResources[i] = signlink.requestDeclaredField(Class4.getTypeFromName(className), fieldName);
		} else if (type == 3 || type == 4) {
		    String className = new String(buffer.getJstr().method78(4484));
		    String methodName = new String(buffer.getJstr().method78(4484));
		    int amountParams = buffer.getUint8();
		    String[] paramClasses = new String[amountParams];
		    for (int i_7_ = 0; i_7_ < amountParams; i_7_++)
			paramClasses[i_7_] = new String(buffer.getJstr().method78(4484));
		    byte[][] paramSrcs = new byte[amountParams][];
		    if (type == 3) {
			for (int i_8_ = 0; i_8_ < amountParams; i_8_++) {
			    int length = buffer.getUint32();
			    paramSrcs[i_8_] = new byte[length];
			    buffer.getBytes(paramSrcs[i_8_], 0, length);
			}
		    }
		    request.requestTypes[i] = type;
		    Class[] parameters = new Class[amountParams];
		    for (int j = 0; amountParams > j; j++)
			parameters[j] = Class4.getTypeFromName(paramClasses[j]);
		    request.methodResources[i] = signlink.requestDeclaredMethod(Class4.getTypeFromName(className), methodName, parameters);
		    request.parameterObjSrcs[i] = paramSrcs;
		}
	    } catch (ClassNotFoundException classnotfoundexception) {
		request.returnCodes[i] = -1;
	    } catch (SecurityException securityexception) {
		request.returnCodes[i] = -2;
	    } catch (NullPointerException nullpointerexception) {
		request.returnCodes[i] = -3;
	    } catch (Exception exception) {
		request.returnCodes[i] = -4;
	    } catch (Throwable throwable) {
		request.returnCodes[i] = -5;
	    }
	}
	Class15.classCheckRequests.offerLast(request);
    }
    
    static {
	aClass3_557
	    = JString
		  .create("Spieler kann nicht gefunden werden: ");
	aClass39_Sub5_Sub10_Sub3Array560 = new DirectColorSprite[1000];
	aClass3_549 = aClass3_552;
	dynamicLevels = new int[25];
	Client.state = 0;
	aClass3_564 = JString.create("Benutzername: ");
	aClass3_566
	    = (JString.create
	       ("Please close the interface you have open before using (Wreport abuse(W"));
	aClass3_567
	    = (JString.create
	       ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789(Q(R+R(T(U^(V(Z(X(Y)2_=)0[*U]*W;:(W@(S*X)1<)3>)4?*6*V "));
	aClass3_572 = aClass3_566;
	useWithAmountChildren = -1;
	aClass3_569
	    = JString.create("Bitte warten Sie eine Minute");
	aClass3_565 = aClass3_567;
    }
}
