package unpackaged;

import com.jagex.utils.Timer;
import com.jagex.config.VarbitDefinition;
import com.jagex.config.ObjectDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.utils.Bzip2Entry;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;

/* Class47 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class47
{
    public static JString aClass3_889
	= JString
	      .create("Verbindung konnte nicht hergestellt werden)3");
    public static JString aClass3_890;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_891;
    public static JString aClass3_892
	= JString.create("Connecting to update server");
    public static DirectColorSprite[] crossSprites;
    public static boolean aBoolean894;
    public static JString aClass3_895;
    public static JString aClass3_896;
    public static JString aClass3_897;
    public static AbstractFileLoader aClass9_898;
    
    public static void method945(boolean bool) {
	aClass3_890 = null;
	aClass3_892 = null;
	aClass3_889 = null;
	aClass3_895 = null;
	aClass3_897 = null;
	crossSprites = null;
	aClass39_Sub5_Sub10_Sub4_891 = null;
	aClass9_898 = null;
	aClass3_896 = null;
    }
    
    public static boolean hasAudioHandler() {
	if (TextureLoaderImpl.audioHandler == null)
	    return false;
	return true;
    }
    
    public static void setNpcFileLoaders(AbstractFileLoader class9, AbstractFileLoader class9_0_) {
	VarbitDefinition.npcFileLoader = class9;
	ObjectDefinition.modelFileLoader = class9_0_;
    }
    
    public static void method948(int i) {
	if (Timer.anInt887 == 1) {
	    if (Class39_Sub4.mouseClickPositionX >= 539 && Class39_Sub4.mouseClickPositionX <= 573
		&& Bzip2Entry.mouseClickPositionY >= 169 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[0] != -1) {
		Node.currentTabId = 0;
		ISAAC.aBoolean1089 = true;
		Class39_Sub14.updateTab = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 569 && Class39_Sub4.mouseClickPositionX <= 599
		&& Bzip2Entry.mouseClickPositionY >= 168 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[1] != -1) {
		Node.currentTabId = 1;
		ISAAC.aBoolean1089 = true;
		Class39_Sub14.updateTab = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 597 && Class39_Sub4.mouseClickPositionX <= 627
		&& Bzip2Entry.mouseClickPositionY >= 168 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[2] != -1) {
		Class39_Sub14.updateTab = true;
		Node.currentTabId = 2;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 625 && Class39_Sub4.mouseClickPositionX <= 669
		&& Bzip2Entry.mouseClickPositionY >= 168 && Bzip2Entry.mouseClickPositionY < 203
		&& Class39_Sub5_Sub14.tabWidgetIds[3] != -1) {
		Class39_Sub14.updateTab = true;
		Node.currentTabId = 3;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 666 && Class39_Sub4.mouseClickPositionX <= 696
		&& Bzip2Entry.mouseClickPositionY >= 168 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[4] != -1) {
		Class39_Sub14.updateTab = true;
		ISAAC.aBoolean1089 = true;
		Node.currentTabId = 4;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 694 && Class39_Sub4.mouseClickPositionX <= 724
		&& Bzip2Entry.mouseClickPositionY >= 168 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[5] != -1) {
		ISAAC.aBoolean1089 = true;
		Node.currentTabId = 5;
		Class39_Sub14.updateTab = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 722 && Class39_Sub4.mouseClickPositionX <= 756
		&& Bzip2Entry.mouseClickPositionY >= 169 && Bzip2Entry.mouseClickPositionY < 205
		&& Class39_Sub5_Sub14.tabWidgetIds[6] != -1) {
		Class39_Sub14.updateTab = true;
		Node.currentTabId = 6;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 540 && Class39_Sub4.mouseClickPositionX <= 574
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 502
		&& Class39_Sub5_Sub14.tabWidgetIds[7] != -1) {
		Class39_Sub14.updateTab = true;
		Node.currentTabId = 7;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 572 && Class39_Sub4.mouseClickPositionX <= 602
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 503
		&& Class39_Sub5_Sub14.tabWidgetIds[8] != -1) {
		Node.currentTabId = 8;
		Class39_Sub14.updateTab = true;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 599 && Class39_Sub4.mouseClickPositionX <= 629
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 503
		&& Class39_Sub5_Sub14.tabWidgetIds[9] != -1) {
		Node.currentTabId = 9;
		Class39_Sub14.updateTab = true;
		ISAAC.aBoolean1089 = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 627 && Class39_Sub4.mouseClickPositionX <= 671
		&& Bzip2Entry.mouseClickPositionY >= 467 && Bzip2Entry.mouseClickPositionY < 502
		&& Class39_Sub5_Sub14.tabWidgetIds[10] != -1) {
		Node.currentTabId = 10;
		ISAAC.aBoolean1089 = true;
		Class39_Sub14.updateTab = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 669 && Class39_Sub4.mouseClickPositionX <= 699
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 503
		&& Class39_Sub5_Sub14.tabWidgetIds[11] != -1) {
		ISAAC.aBoolean1089 = true;
		Class39_Sub14.updateTab = true;
		Node.currentTabId = 11;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 696 && Class39_Sub4.mouseClickPositionX <= 726
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 503
		&& Class39_Sub5_Sub14.tabWidgetIds[12] != -1) {
		Node.currentTabId = 12;
		ISAAC.aBoolean1089 = true;
		Class39_Sub14.updateTab = true;
	    }
	    if (Class39_Sub4.mouseClickPositionX >= 724 && Class39_Sub4.mouseClickPositionX <= 758
		&& Bzip2Entry.mouseClickPositionY >= 466 && Bzip2Entry.mouseClickPositionY < 502
		&& Class39_Sub5_Sub14.tabWidgetIds[13] != -1) {
		Class39_Sub14.updateTab = true;
		ISAAC.aBoolean1089 = true;
		Node.currentTabId = 13;
	    }
	}
    }
    
    public static void method949(int i) {
	Class39_Sub5_Sub6.aClass7_1762.clear();
	if (i != -5794)
	    method945(false);
    }
    
    static {
	aClass3_890
	    = JString.create("Geben Sie Ihren Benutzernamen");
	aClass3_896 = aClass3_892;
	aClass3_897
	    = (JString.create
	       ("To play on this world move to a free area first"));
	aClass3_895 = aClass3_897;
    }
}
