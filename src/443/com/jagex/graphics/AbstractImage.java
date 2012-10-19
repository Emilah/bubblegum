package com.jagex.graphics;

/* Class57 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.script.ScriptExecutor;
import com.jagex.utils.JString;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import unpackaged.Class43;
import com.jagex.utils.Timer;
import com.jagex.utils.MsTimer;

public abstract class AbstractImage
{
    public int[] buffer;
    public Image image;
    public static boolean aBoolean1000 = true;
    public int width;
    public static IndexedColorSprite[] aClass39_Sub5_Sub10_Sub4Array1002;
    public int height;
    
    public abstract void setComponent(Component component,int i, int i_0_);
    
    public void method1006(int i) {
	DrawingArea.setBuffer(buffer, width, height);
    }
    
    public static JString toJstr(int i) {
	return Class43.toJstr(false, 10, i);
    }
    
    public static void method1008(int i) {
	ScriptExecutor.globalIntVars = null;
	aClass39_Sub5_Sub10_Sub4Array1002 = null;
    }
    
    public static Timer method1009(byte i) {
	try {
	    return (Timer) Class.forName("Class46_Sub2").newInstance();
	} catch (Throwable throwable) {
	    return new MsTimer();
	}
    }
    
    public abstract void draw(Graphics graphics, int width, int height);
}
