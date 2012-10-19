package com.jagex.script;

/* Class39_Sub5_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.utils.JRuntimeException;
import com.jagex.config.Widget;
import com.jagex.audio.AudioHandler;
import com.jagex.world.Mob;
import com.jagex.world.World;
import com.jagex.io.ArchiveRequest;
import com.jagex.io.ArchiveWorker;
import com.jagex.config.ItemDefinition;
import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.Client;
import com.jagex.TextConstants;
import com.jagex.awt.JApplet;
import com.jagex.utils.NameTable;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.JImage;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.net.JSocket;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import com.jagex.utils.Cache;
import com.jagex.audio.Effect;
import java.awt.Component;
import unpackaged.Class1;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Class39_Sub10;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub1_Sub2;
import unpackaged.Class39_Sub3_Sub1;
import unpackaged.Class39_Sub4;
import com.jagex.graphics.TriangleRasterizer;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub5;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class41;
import unpackaged.Class43;
import unpackaged.Class53;
import unpackaged.Class66;
import unpackaged.Class67;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.TextureLoaderImpl;

public class ClientScript extends SubNode
{
    public static JString aClass3_1689;
    public static volatile boolean aBoolean1690 = true;
    public static JString aClass3_1691;
    public static int anInt1692;
    public static Class43 aClass43_1693;
    public int[] opcodes;
    public static JString aClass3_1695 = JString.create("M");
    public int[] intOperands;
    public static JString loadingTexturesJstr;
    public static JString aClass3_1698;
    public static volatile int anInt1699;
    public int amountStrParams;
    public static JString aClass3_1701;
    public static int itemClickPositionX;
    public static int anInt1703;
    public static JString aClass3_1704;
    public static PlayerApperance playerApperance;
    public static int anInt1706;
    public int amountIntParams;
    public JString[] strOperands;
    public int amountStrVars;
    public int amountIntVars;
    public static int[] bitMasks;
    public static DirectColorSprite aClass39_Sub5_Sub10_Sub3_1712;
    public static int screenOverlayId;
    
    public static void method477(byte i) {
	for (int j = 0; Projectile.queuedEffectOffset > j; j++) {
	    Class39_Sub5_Sub9.queuedEffectDelays[j]--;
	    if (Class39_Sub5_Sub9.queuedEffectDelays[j] < -10) {
		Projectile.queuedEffectOffset--;
		for (int i_1_ = j; i_1_ < Projectile.queuedEffectOffset;
		     i_1_++) {
		    ArchiveWorker.queuedEffectIds[i_1_]
			= ArchiveWorker.queuedEffectIds[i_1_ + 1];
		    Class15.queuedEffects[i_1_]
			= Class15.queuedEffects[i_1_ + 1];
		    FileLoader.queuedEffectLoops[i_1_]
			= FileLoader.queuedEffectLoops[i_1_ + 1];
		    Class39_Sub5_Sub9.queuedEffectDelays[i_1_]
			= Class39_Sub5_Sub9.queuedEffectDelays[i_1_ + 1];
		    FrameBuffer.queuedEffectVolumes[i_1_]
			= FrameBuffer.queuedEffectVolumes[i_1_ + 1];
		}
		j--;
	    } else {
		Effect class52 = Class15.queuedEffects[j];
		if (class52 == null) {
		    class52
			= Effect.createEffect(Node.fileLoader4,
					    ArchiveWorker.queuedEffectIds[j], 0);
		    if (class52 == null)
			continue;
		    Class39_Sub5_Sub9.queuedEffectDelays[j]
			+= class52.getDelay();
		    Class15.queuedEffects[j] = class52;
		}
		if (Class39_Sub5_Sub9.queuedEffectDelays[j] < 0) {
		    int volume;
		    if (FrameBuffer.queuedEffectVolumes[j] != 0) {
			int distance
			    = ((FrameBuffer.queuedEffectVolumes[j] & 0xff)
			       * 128);
			int posX = ((FrameBuffer.queuedEffectVolumes[j]
				     & 0xff0000)
				    >> 16);
			int deltaX = (posX * 128- (-64 + (Cache.localPlayer.fPositionY)));
			if (deltaX < 0) {
                            deltaX = -deltaX;
                        }
			int posY = (FrameBuffer.queuedEffectVolumes[j] >> 8 & 0xff);
			int deltaY = (-(Cache.localPlayer.fPositionX) + posY * 128 + 64);
			if (deltaY < 0) {
                            deltaY = -deltaY;
                        }
			int length = deltaY + deltaX - 128;
			if (distance < length) {
			    Class39_Sub5_Sub9.queuedEffectDelays[j] = -100;
			    continue;
			}
			if (length < 0) {
                            length = 0;
                        }
			volume = AbstractFileLoader.ambientEffectVolume * (distance - length) / distance;
		    } else {
                        volume = Class39_Sub5_Sub9.effectVolume;
                    }
		    Class39_Sub3_Sub1 class39_sub3_sub1
			= class52.method981().method455(aClass43_1693);
		    Class39_Sub1_Sub2 class39_sub1_sub2
			= Class39_Sub1_Sub2.method444(class39_sub3_sub1, 100,
						      volume);
		    class39_sub1_sub2
			.method448(FileLoader.queuedEffectLoops[j] - 1);
		    Class1.aClass39_Sub1_Sub1_32.method421(class39_sub1_sub2);
		    Class39_Sub5_Sub9.queuedEffectDelays[j] = -100;
		}
	    }
	}
	if (JSocket.anInt313 > 0) {
	    JSocket.anInt313 -= 20;
	    if (JSocket.anInt313 < 0)
		JSocket.anInt313 = 0;
	    if (JSocket.anInt313 == 0 && Mob.musicVolume != 0 && ArchiveWorker.anInt1205 != -1)
		Class41.method891(0, 0, false, Projectile.fileLoader6, Mob.musicVolume, ArchiveWorker.anInt1205);
	}
    }
    
    public static void attachListeners(Component component) {
	component.addMouseListener(ItemContainer.aClass42_1502);
	component.addMouseMotionListener(ItemContainer.aClass42_1502);
	component.addFocusListener(ItemContainer.aClass42_1502);
    }
    
    public static void method479(int i, World class38, TraversalMap[] class27s) {
	for (int i_9_ = 0; i_9_ < 4; i_9_++) {
	    for (int i_10_ = 0; i_10_ < 104; i_10_++) {
		for (int i_11_ = 0; i_11_ < 104; i_11_++) {
		    if ((TextureLoaderImpl.tileFlags[i_9_][i_10_][i_11_]
			 & 0x1)
			== 1) {
			int i_12_ = i_9_;
			if ((TextureLoaderImpl.tileFlags[1][i_10_][i_11_]
			     & 0x2)
			    == 2)
			    i_12_--;
			if (i_12_ >= 0)
			    class27s[i_12_].method306((byte) -85, i_11_,
						      i_10_);
		    }
		}
	    }
	}
	Class32.anInt589 += (int) (Math.random() * 5.0) - 2;
	if (Class32.anInt589 < -8)
	    Class32.anInt589 = -8;
	Node.anInt737 += (int) (Math.random() * 5.0) - 2;
	if (Node.anInt737 < -16)
	    Node.anInt737 = -16;
	if (Node.anInt737 > 16)
	    Node.anInt737 = 16;
	if (Class32.anInt589 > 8)
	    Class32.anInt589 = 8;
	for (int i_13_ = 0; i_13_ < 4; i_13_++) {
	    byte[][] is = ItemDefinition.aByteArrayArrayArray1671[i_13_];
	    int i_14_ = (int) Math.sqrt(5100.0);
	    int i_15_ = i_14_ * 768 >> 8;
	    for (int i_16_ = 1; i_16_ < 103; i_16_++) {
		for (int i_17_ = 1; i_17_ < 103; i_17_++) {
		    int i_18_ = ((Class67.heightMap[i_13_]
				  [i_17_ + 1][i_16_])
				 - (Class67.heightMap[i_13_]
				    [i_17_ - 1][i_16_]));
		    int i_19_ = (-(Class67.heightMap[i_13_]
				   [i_17_][i_16_ - 1])
				 + (Class67.heightMap[i_13_]
				    [i_17_][i_16_ + 1]));
		    int i_20_ = (int) Math.sqrt((double) (i_19_ * i_19_
							  + (i_18_ * i_18_
							     + 65536)));
		    int i_21_ = 65536 / i_20_;
		    int i_22_ = (i_18_ << 8) / i_20_;
		    int i_23_ = (i_19_ << 8) / i_20_;
		    int i_24_ = 96 + (i_23_ * -50
				      + (i_22_ * -50 + i_21_ * -10)) / i_15_;
		    int i_25_ = ((is[i_17_][i_16_] >> 1)
				 + ((is[i_17_][i_16_ + 1] >> 3)
				    + (is[i_17_][i_16_ - 1] >> 2))
				 + (is[i_17_ + 1][i_16_] >> 3)
				 + (is[i_17_ - 1][i_16_] >> 2));
		    Class20.anIntArrayArray391[i_17_][i_16_] = -i_25_ + i_24_;
		}
	    }
	    for (int i_26_ = 0; i_26_ < 104; i_26_++) {
		Class14.anIntArray239[i_26_] = 0;
		Class39_Sub5_Sub9.anIntArray1809[i_26_] = 0;
		VarpDefinition.anIntArray1984[i_26_] = 0;
		Class39_Sub5_Sub4_Sub2.anIntArray2231[i_26_] = 0;
		NameTable.anIntArray187[i_26_] = 0;
	    }
	    for (int i_27_ = -5; i_27_ < 109; i_27_++) {
		for (int i_28_ = 0; i_28_ < 104; i_28_++) {
		    int i_29_ = i_27_ + 5;
		    if (i_29_ >= 0 && i_29_ < 104) {
			int i_30_ = ((Class39_Sub14.aByteArrayArrayArray1516
				      [i_13_][i_29_][i_28_])
				     & 0xff);
			if (i_30_ > 0) {
			    Class39_Sub5_Sub9 class39_sub5_sub9
				= Class39_Sub5_Sub5.method574(i_30_ - 1,
							      (byte) 47);
			    Class14.anIntArray239[i_28_]
				+= class39_sub5_sub9.anInt1813;
			    Class39_Sub5_Sub9.anIntArray1809[i_28_]
				+= class39_sub5_sub9.anInt1812;
			    VarpDefinition.anIntArray1984[i_28_]
				+= class39_sub5_sub9.anInt1801;
			    Class39_Sub5_Sub4_Sub2.anIntArray2231[i_28_]
				+= class39_sub5_sub9.anInt1800;
			    NameTable.anIntArray187[i_28_]++;
			}
		    }
		    int i_31_ = i_27_ - 5;
		    if (i_31_ >= 0 && i_31_ < 104) {
			int i_32_ = ((Class39_Sub14.aByteArrayArrayArray1516
				      [i_13_][i_31_][i_28_])
				     & 0xff);
			if (i_32_ > 0) {
			    Class39_Sub5_Sub9 class39_sub5_sub9
				= Class39_Sub5_Sub5.method574(i_32_ - 1,
							      (byte) 83);
			    Class14.anIntArray239[i_28_]
				-= class39_sub5_sub9.anInt1813;
			    Class39_Sub5_Sub9.anIntArray1809[i_28_]
				-= class39_sub5_sub9.anInt1812;
			    VarpDefinition.anIntArray1984[i_28_]
				-= class39_sub5_sub9.anInt1801;
			    Class39_Sub5_Sub4_Sub2.anIntArray2231[i_28_]
				-= class39_sub5_sub9.anInt1800;
			    NameTable.anIntArray187[i_28_]--;
			}
		    }
		}
		if (i_27_ >= 1 && i_27_ < 103) {
		    int i_33_ = 0;
		    int i_34_ = 0;
		    int i_35_ = 0;
		    int i_36_ = 0;
		    int i_37_ = 0;
		    for (int i_38_ = -5; i_38_ < 109; i_38_++) {
			int i_39_ = i_38_ + 5;
			if (i_39_ >= 0 && i_39_ < 104) {
			    i_33_ += Class14.anIntArray239[i_39_];
			    i_37_ += (Class39_Sub5_Sub4_Sub2.anIntArray2231
				      [i_39_]);
			    i_35_ += Class39_Sub5_Sub9.anIntArray1809[i_39_];
			    i_36_ += NameTable.anIntArray187[i_39_];
			    i_34_ += VarpDefinition.anIntArray1984[i_39_];
			}
			int i_40_ = i_38_ - 5;
			if (i_40_ >= 0 && i_40_ < 104) {
			    i_35_ -= Class39_Sub5_Sub9.anIntArray1809[i_40_];
			    i_37_ -= (Class39_Sub5_Sub4_Sub2.anIntArray2231
				      [i_40_]);
			    i_36_ -= NameTable.anIntArray187[i_40_];
			    i_34_ -= VarpDefinition.anIntArray1984[i_40_];
			    i_33_ -= Class14.anIntArray239[i_40_];
			}
			if (i_38_ >= 1 && i_38_ < 103
			    && (!PlayerApperance.isLowMemory
				|| ((TextureLoaderImpl.tileFlags[0][i_27_]
				     [i_38_])
				    & 0x2) != 0
				|| (((TextureLoaderImpl.tileFlags[i_13_]
				      [i_27_][i_38_])
				     & 0x10) == 0
				    && (PlayerApperance.method927(i_38_, i_27_, i_13_,
							  (byte) 23)
					== JImage.lastHeight)))) {
			    if (i_13_ < TraversalMap.anInt518)
				TraversalMap.anInt518 = i_13_;
			    int i_41_ = (Class39_Sub14.aByteArrayArrayArray1516
					 [i_13_][i_27_][i_38_]) & 0xff;
			    int i_42_ = ((Class33.aByteArrayArrayArray596
					  [i_13_][i_27_][i_38_])
					 & 0xff);
			    if (i_41_ > 0 || i_42_ > 0) {
				int i_43_ = (Class67.heightMap
					     [i_13_][i_27_][i_38_]);
				int i_44_ = (Class67.heightMap
					     [i_13_][i_27_ + 1][i_38_]);
				int i_45_ = (Class67.heightMap
					     [i_13_][i_27_][i_38_ + 1]);
				int i_46_ = (Class67.heightMap
					     [i_13_][i_27_ + 1][i_38_ + 1]);
				int i_47_
				    = Class20.anIntArrayArray391[i_27_][i_38_];
				int i_48_ = (Class20.anIntArrayArray391
					     [i_27_ + 1][i_38_]);
				int i_49_ = -1;
				int i_50_ = (Class20.anIntArrayArray391[i_27_]
					     [i_38_ + 1]);
				int i_51_ = (Class20.anIntArrayArray391
					     [i_27_ + 1][i_38_ + 1]);
				int i_52_ = -1;
				if (i_41_ > 0) {
				    int i_53_ = i_33_ * 256 / i_37_;
				    int i_54_ = i_34_ / i_36_;
				    int i_55_ = i_35_ / i_36_;
				    i_49_
					= ItemContainer.method873(i_54_, i_55_,
								  17, i_53_);
				    i_54_ += Node.anInt737;
				    i_53_ = i_53_ + Class32.anInt589 & 0xff;
				    if (i_54_ >= 0) {
					if (i_54_ > 255)
					    i_54_ = 255;
				    } else
					i_54_ = 0;
				    i_52_
					= ItemContainer.method873(i_54_, i_55_,
								  -107, i_53_);
				}
				if (i_13_ > 0) {
				    boolean bool = true;
				    if (i_41_ == 0
					&& (Class67.aByteArrayArrayArray1179
					    [i_13_][i_27_][i_38_]) != 0)
					bool = false;
				    if (i_42_ > 0 && !(AudioHandler.method1052
						       (i_42_ - 1, (byte) 120)
						       .aBoolean1894))
					bool = false;
				    if (bool && i_43_ == i_44_
					&& i_46_ == i_43_ && i_43_ == i_45_)
					ArchiveRequest
					    .anIntArrayArrayArray1412[i_13_]
					    [i_27_][i_38_]
					    = (Queue.or
					       ((ArchiveRequest
						 .anIntArrayArrayArray1412
						 [i_13_][i_27_][i_38_]),
						2340));
				}
				int i_56_ = 0;
				if (i_52_ != -1)
				    i_56_ = (TriangleRasterizer
					     .anIntArray2452
					     [Node.method412(96, i_52_,
								(byte) -128)]);
				if (i_42_ != 0) {
				    int i_57_
					= ((Class67.aByteArrayArrayArray1179
					    [i_13_][i_27_][i_38_])
					   + 1);
				    byte i_58_
					= (ISAAC.aByteArrayArrayArray1081
					   [i_13_][i_27_][i_38_]);
				    Class39_Sub5_Sub14 class39_sub5_sub14
					= AudioHandler.method1052(i_42_ - 1,
							     (byte) 98);
				    int i_59_ = class39_sub5_sub14.anInt1901;
				    int i_60_;
				    int i_61_;
				    if (i_59_ < 0) {
					if (class39_sub5_sub14.anInt1915
					    == 16711935) {
					    i_60_ = -2;
					    i_61_ = -2;
					    i_59_ = -1;
					} else {
					    i_61_ = (ItemContainer.method873
						     ((class39_sub5_sub14
						       .anInt1893),
						      (class39_sub5_sub14
						       .anInt1917),
						      -101,
						      (class39_sub5_sub14
						       .anInt1900)));
					    int i_62_
						= (class39_sub5_sub14.anInt1900
						   + Class32.anInt589) & 0xff;
					    int i_63_ = (Node.anInt737
							 + (class39_sub5_sub14
							    .anInt1893));
					    if (i_63_ >= 0) {
						if (i_63_ > 255)
						    i_63_ = 255;
					    } else
						i_63_ = 0;
					    i_60_ = (ItemContainer.method873
						     (i_63_,
						      (class39_sub5_sub14
						       .anInt1917),
						      76, i_62_));
					}
				    } else {
					i_60_ = TriangleRasterizer
						    .textureLoader
						    .method7(105, i_59_);
					i_61_ = -1;
				    }
				    int i_64_ = 0;
				    if (i_60_ != -2)
					i_64_ = (TriangleRasterizer
						 .anIntArray2452
						 [(GroundItem
						       .method506
						   (i_60_, 96, (byte) 122))]);
				    if (class39_sub5_sub14.anInt1907 != -1) {
					int i_65_
					    = (Node.anInt737
					       + class39_sub5_sub14.anInt1902);
					int i_66_
					    = ((Class32.anInt589
						+ class39_sub5_sub14.anInt1892)
					       & 0xff);
					if (i_65_ >= 0) {
					    if (i_65_ > 255)
						i_65_ = 255;
					} else
					    i_65_ = 0;
					i_60_ = (ItemContainer.method873
						 (i_65_,
						  class39_sub5_sub14.anInt1890,
						  -123, i_66_));
					i_64_ = (TriangleRasterizer
						 .anIntArray2452
						 [(GroundItem
						       .method506
						   (i_60_, 96, (byte) 122))]);
				    }
				    class38.method368
					(i_13_, i_27_, i_38_, i_57_, i_58_,
					 i_59_, i_43_, i_44_, i_46_, i_45_,
					 Node.method412(i_47_, i_49_,
							   (byte) -124),
					 Node.method412(i_48_, i_49_,
							   (byte) -123),
					 Node.method412(i_51_, i_49_,
							   (byte) -121),
					 Node.method412(i_50_, i_49_,
							   (byte) -121),
					 (GroundItem.method506
					  (i_61_, i_47_, (byte) 122)),
					 (GroundItem.method506
					  (i_61_, i_48_, (byte) 122)),
					 (GroundItem.method506
					  (i_61_, i_51_, (byte) 122)),
					 (GroundItem.method506
					  (i_61_, i_50_, (byte) 122)),
					 i_56_, i_64_);
				} else
				    class38.method368
					(i_13_, i_27_, i_38_, 0, 0, -1, i_43_,
					 i_44_, i_46_, i_45_,
					 Node.method412(i_47_, i_49_,
							   (byte) -113),
					 Node.method412(i_48_, i_49_,
							   (byte) -126),
					 Node.method412(i_51_, i_49_,
							   (byte) -128),
					 Node.method412(i_50_, i_49_,
							   (byte) -127),
					 0, 0, 0, 0, i_56_, 0);
			    }
			}
		    }
		}
	    }
	    for (int i_67_ = 1; i_67_ < 103; i_67_++) {
		for (int i_68_ = 1; i_68_ < 103; i_68_++)
		    class38.method362(i_13_, i_68_, i_67_,
				      PlayerApperance.method927(i_67_, i_68_, i_13_,
							(byte) 23));
	    }
	    Class39_Sub14.aByteArrayArrayArray1516[i_13_] = null;
	    Class33.aByteArrayArrayArray596[i_13_] = null;
	    Class67.aByteArrayArrayArray1179[i_13_] = null;
	    ISAAC.aByteArrayArrayArray1081[i_13_] = null;
	    ItemDefinition.aByteArrayArrayArray1671[i_13_] = null;
	}
	class38.method395(-50, -10, -50);
	for (int i_69_ = 0; i_69_ < 104; i_69_++) {
	    for (int i_70_ = 0; i_70_ < 104; i_70_++) {
		if ((TextureLoaderImpl.tileFlags[1][i_69_][i_70_] & 0x2)
		    == 2)
		    class38.method370(i_69_, i_70_);
	    }
	}
	int i_71_ = 1;
	int i_72_ = 2;
	int i_73_ = 4;
	for (int i_74_ = 0; i_74_ < 4; i_74_++) {
	    if (i_74_ > 0) {
		i_71_ <<= 3;
		i_73_ <<= 3;
		i_72_ <<= 3;
	    }
	    for (int i_75_ = 0; i_75_ <= i_74_; i_75_++) {
		for (int i_76_ = 0; i_76_ <= 104; i_76_++) {
		    for (int i_77_ = 0; i_77_ <= 104; i_77_++) {
			if ((i_71_ & (ArchiveRequest.anIntArrayArrayArray1412
				      [i_75_][i_77_][i_76_]))
			    != 0) {
			    int i_78_ = i_76_;
			    int i_79_ = i_75_;
			    for (/**/;
				 (i_78_ > 0
				  && ((ArchiveRequest.anIntArrayArrayArray1412
				       [i_75_][i_77_][i_78_ - 1])
				      & i_71_) != 0);
				 i_78_--) {
				/* empty */
			    }
			    int i_80_ = i_76_;
			    int i_81_ = i_75_;
			    for (/**/; i_80_ < 104; i_80_++) {
				if ((i_71_
				     & (ArchiveRequest.anIntArrayArrayArray1412
					[i_75_][i_77_][i_80_ + 1]))
				    == 0)
				    break;
			    }
			while_2_:
			    for (/**/; i_79_ > 0; i_79_--) {
				for (int i_82_ = i_78_; i_82_ <= i_80_;
				     i_82_++) {
				    if ((i_71_ & (ArchiveRequest
						  .anIntArrayArrayArray1412
						  [i_79_ - 1][i_77_][i_82_]))
					== 0)
					break while_2_;
				}
			    }
			while_3_:
			    for (/**/; i_81_ < i_74_; i_81_++) {
				for (int i_83_ = i_78_; i_83_ <= i_80_;
				     i_83_++) {
				    if ((i_71_ & (ArchiveRequest
						  .anIntArrayArrayArray1412
						  [i_81_ + 1][i_77_][i_83_]))
					== 0)
					break while_3_;
				}
			    }
			    int i_84_
				= (-i_79_ + 1 + i_81_) * (-i_78_ + 1 + i_80_);
			    if (i_84_ >= 8) {
				int i_85_ = 240;
				int i_86_ = (Class67.heightMap
					     [i_79_][i_77_][i_78_]);
				int i_87_ = -i_85_ + (Class67
						      .heightMap
						      [i_81_][i_77_][i_78_]);
				World.method388(i_74_, 1, i_77_ * 128,
						  i_77_ * 128, i_78_ * 128,
						  i_80_ * 128 + 128, i_87_,
						  i_86_);
				for (int i_88_ = i_79_; i_88_ <= i_81_;
				     i_88_++) {
				    for (int i_89_ = i_78_; i_89_ <= i_80_;
					 i_89_++)
					ArchiveRequest
					    .anIntArrayArrayArray1412[i_88_]
					    [i_77_][i_89_]
					    = (Class34.and
					       ((ArchiveRequest
						 .anIntArrayArrayArray1412
						 [i_88_][i_77_][i_89_]),
						i_71_ ^ 0xffffffff));
				}
			    }
			}
			if ((i_72_ & (ArchiveRequest.anIntArrayArrayArray1412
				      [i_75_][i_77_][i_76_]))
			    != 0) {
			    int i_90_;
			    for (i_90_ = i_77_;
				 (i_90_ > 0
				  && ((ArchiveRequest.anIntArrayArrayArray1412
				       [i_75_][i_90_ - 1][i_76_])
				      & i_72_) != 0);
				 i_90_--) {
				/* empty */
			    }
			    int i_91_;
			    for (i_91_ = i_77_;
				 (i_91_ < 104
				  && (i_72_
				      & (ArchiveRequest.anIntArrayArrayArray1412
					 [i_75_][i_91_ + 1][i_76_])) != 0);
				 i_91_++) {
				/* empty */
			    }
			    int i_92_ = i_75_;
			    int i_93_;
			while_4_:
			    for (i_93_ = i_75_; i_93_ > 0; i_93_--) {
				for (int i_94_ = i_90_; i_91_ >= i_94_;
				     i_94_++) {
				    if (((ArchiveRequest.anIntArrayArrayArray1412
					  [i_93_ - 1][i_94_][i_76_])
					 & i_72_)
					== 0)
					break while_4_;
				}
			    }
			while_5_:
			    for (/**/; i_92_ < i_74_; i_92_++) {
				for (int i_95_ = i_90_; i_95_ <= i_91_;
				     i_95_++) {
				    if ((i_72_ & (ArchiveRequest
						  .anIntArrayArrayArray1412
						  [i_92_ + 1][i_95_][i_76_]))
					== 0)
					break while_5_;
				}
			    }
			    int i_96_
				= (i_92_ + 1 - i_93_) * (-i_90_ + i_91_ + 1);
			    if (i_96_ >= 8) {
				int i_97_ = 240;
				int i_98_ = (Class67.heightMap
					     [i_93_][i_90_][i_76_]);
				int i_99_ = -i_97_ + (Class67
						      .heightMap
						      [i_92_][i_90_][i_76_]);
				World.method388(i_74_, 2, i_90_ * 128,
						  i_91_ * 128 + 128,
						  i_76_ * 128, i_76_ * 128,
						  i_99_, i_98_);
				for (int i_100_ = i_93_; i_100_ <= i_92_;
				     i_100_++) {
				    for (int i_101_ = i_90_; i_101_ <= i_91_;
					 i_101_++)
					ArchiveRequest
					    .anIntArrayArrayArray1412[i_100_]
					    [i_101_][i_76_]
					    = (Class34.and
					       ((ArchiveRequest
						 .anIntArrayArrayArray1412
						 [i_100_][i_101_][i_76_]),
						i_72_ ^ 0xffffffff));
				}
			    }
			}
			if ((i_73_ & (ArchiveRequest.anIntArrayArrayArray1412
				      [i_75_][i_77_][i_76_]))
			    != 0) {
			    int i_102_ = i_77_;
			    int i_103_ = i_77_;
			    int i_104_;
			    for (i_104_ = i_76_;
				 (i_104_ > 0
				  && ((ArchiveRequest.anIntArrayArrayArray1412
				       [i_75_][i_77_][i_104_ - 1])
				      & i_73_) != 0);
				 i_104_--) {
				/* empty */
			    }
			    int i_105_;
			    for (i_105_ = i_76_; i_105_ < 104; i_105_++) {
				if (((ArchiveRequest.anIntArrayArrayArray1412
				      [i_75_][i_77_][i_105_ + 1])
				     & i_73_)
				    == 0)
				    break;
			    }
			while_6_:
			    for (/**/; i_102_ > 0; i_102_--) {
				for (int i_106_ = i_104_; i_106_ <= i_105_;
				     i_106_++) {
				    if (((ArchiveRequest.anIntArrayArrayArray1412
					  [i_75_][i_102_ - 1][i_106_])
					 & i_73_)
					== 0)
					break while_6_;
				}
			    }
			while_7_:
			    for (/**/; i_103_ < 104; i_103_++) {
				for (int i_107_ = i_104_; i_107_ <= i_105_;
				     i_107_++) {
				    if (((ArchiveRequest.anIntArrayArrayArray1412
					  [i_75_][i_103_ + 1][i_107_])
					 & i_73_)
					== 0)
					break while_7_;
				}
			    }
			    if ((i_103_ - (i_102_ - 1)) * (i_105_ - i_104_ + 1)
				>= 4) {
				int i_108_ = (Class67.heightMap
					      [i_75_][i_102_][i_104_]);
				World.method388(i_74_, 4, i_102_ * 128,
						  i_103_ * 128 + 128,
						  i_104_ * 128,
						  i_105_ * 128 + 128, i_108_,
						  i_108_);
				for (int i_109_ = i_102_; i_103_ >= i_109_;
				     i_109_++) {
				    for (int i_110_ = i_104_; i_105_ >= i_110_;
					 i_110_++)
					ArchiveRequest
					    .anIntArrayArrayArray1412[i_75_]
					    [i_109_][i_110_]
					    = (Class34.and
					       ((ArchiveRequest
						 .anIntArrayArrayArray1412
						 [i_75_][i_109_][i_110_]),
						i_73_ ^ 0xffffffff));
				}
			    }
			}
		    }
		}
	    }
	}
    }
    
    public static void method480
	(byte i, Mob class39_sub5_sub4_sub4, int i_111_) {
	if (class39_sub5_sub4_sub4.fPositionY < 128
	    || class39_sub5_sub4_sub4.fPositionX < 128
	    || class39_sub5_sub4_sub4.fPositionY >= 13184
	    || class39_sub5_sub4_sub4.fPositionX >= 13184) {
	    class39_sub5_sub4_sub4.anInt2268 = -1;
	    class39_sub5_sub4_sub4.anInt2270 = -1;
	    class39_sub5_sub4_sub4.anInt2256 = 0;
	    class39_sub5_sub4_sub4.anInt2261 = 0;
	    class39_sub5_sub4_sub4.fPositionX
		= (class39_sub5_sub4_sub4.anInt2297 * 64
		   + class39_sub5_sub4_sub4.queueY[0] * 128);
	    class39_sub5_sub4_sub4.fPositionY
		= (class39_sub5_sub4_sub4.anInt2297 * 64
		   + class39_sub5_sub4_sub4.queueX[0] * 128);
	    class39_sub5_sub4_sub4.method515(0);
	}
	if (Cache.localPlayer == class39_sub5_sub4_sub4
	    && (class39_sub5_sub4_sub4.fPositionY < 1536
		|| class39_sub5_sub4_sub4.fPositionX < 1536
		|| class39_sub5_sub4_sub4.fPositionY >= 11776
		|| class39_sub5_sub4_sub4.fPositionX >= 11776)) {
	    class39_sub5_sub4_sub4.anInt2256 = 0;
	    class39_sub5_sub4_sub4.anInt2270 = -1;
	    class39_sub5_sub4_sub4.fPositionY
		= (class39_sub5_sub4_sub4.queueX[0] * 128
		   + class39_sub5_sub4_sub4.anInt2297 * 64);
	    class39_sub5_sub4_sub4.fPositionX
		= (class39_sub5_sub4_sub4.queueY[0] * 128
		   + class39_sub5_sub4_sub4.anInt2297 * 64);
	    class39_sub5_sub4_sub4.anInt2268 = -1;
	    class39_sub5_sub4_sub4.anInt2261 = 0;
	    class39_sub5_sub4_sub4.method515(0);
	}
	if (Class2.logicCycle < class39_sub5_sub4_sub4.anInt2256)
	    HashTable.method244(class39_sub5_sub4_sub4, false);
	else if (Class2.logicCycle <= class39_sub5_sub4_sub4.anInt2261)
	    Class39_Sub5_Sub7.method584(class39_sub5_sub4_sub4, (byte) -80);
	else
	    Class66.method1105(-2, class39_sub5_sub4_sub4);
	Queue.method990(true, class39_sub5_sub4_sub4);
	ClassCheckRequest.method846(class39_sub5_sub4_sub4, 1000000);
    }
    
    public static void method481(int i) {
	Class23.graphics.method1006(10);
	Class39_Sub5_Sub7.anIntArray1789
	    = TriangleRasterizer
		  .method657(Class39_Sub5_Sub7.anIntArray1789);
    }
    
    public static void method482(int i) {
	aClass3_1689 = null;
	aClass43_1693 = null;
	bitMasks = null;
	aClass3_1704 = null;
	loadingTexturesJstr = null;
	playerApperance = null;
	aClass3_1701 = null;
	aClass3_1695 = null;
	aClass3_1691 = null;
	aClass3_1698 = null;
	aClass39_Sub5_Sub10_Sub3_1712 = null;
    }
    
    public static void method483(int i, int i_112_) {
	for (anInt1706 += i_112_; Class15.anInt274 <= anInt1706;
	     anInt1706 -= Class15.anInt274)
	    StillGraphic.anInt2334
		-= StillGraphic.anInt2334 >> 2;
	StillGraphic.anInt2334 -= i_112_ * 1000;
	if (StillGraphic.anInt2334 < i)
	    StillGraphic.anInt2334 = 0;
    }
    
    public static void method484
	(int positionX, int id, int positionY,
	 Player class39_sub5_sub4_sub4_sub2,
	 byte i_115_) {
	if ((class39_sub5_sub4_sub4_sub2
	     != Cache.localPlayer)
	    && Class39_Sub5_Sub11.actionOffset < 400) {
	    JString class3;
	    if (class39_sub5_sub4_sub4_sub2.anInt2508 == 0)
		class3
		    = (Class39_Sub5_Sub11.join
		       ((new JString[]
			 { class39_sub5_sub4_sub4_sub2.aClass3_2521,
			   (Class39_Sub5_Sub6.method579
			    (Cache.localPlayer.combatLevel,
			     class39_sub5_sub4_sub4_sub2.combatLevel, false)),
			   Class39_Sub5_Sub18.aClass3_2118,
			   TextConstants.aClass3_1270,
			   AbstractImage.toJstr((class39_sub5_sub4_sub4_sub2
					       .combatLevel)),
			   Queue.aClass3_984 })));
	    else
		class3 = (Class39_Sub5_Sub11.join
			  ((new JString[]
			    { class39_sub5_sub4_sub4_sub2.aClass3_2521,
			      Class39_Sub5_Sub18.aClass3_2118,
			      Class39_Sub5_Sub14.aClass3_1913,
			      AbstractImage.toJstr((class39_sub5_sub4_sub4_sub2
						  .anInt2508)),
			      Queue.aClass3_984 })));
	    if (Class13.anInt208 == 1)
		JString.queueAction(58, id,positionX, positionY, Mob.useJstr,
				(Class39_Sub5_Sub11.join
				 ((new JString[]
				   { Class39_Sub10.useWithItemJstr,
				     Widget.aClass3_2110,
				     class3 }))));
	    else if (ISAAC.aBoolean1100) {
		if ((Class41.anInt776 & 0x8) == 8)
		    JString.queueAction(7, id,positionX, positionY, TextConstants.aClass3_1273,
				    (Class39_Sub5_Sub11.join
				     ((new JString[]
				       { Class14.aClass3_216,
					 Widget.aClass3_2110,
					 class3 }))));
	    } else {
		for (int i_116_ = 4; i_116_ >= 0; i_116_--) {
		    if (Class39_Sub14.playerOptions[i_116_] != null) {
			int i_117_ = 0;
			int actionType = 0;
			if (!Class39_Sub14.playerOptions[i_116_]
				 .equalTo(JApplet.attackJstr)) {
			    if (JRuntimeException.aBooleanArray1225
				[i_116_])
				i_117_ = 2000;
			} else {
			    if (class39_sub5_sub4_sub4_sub2.combatLevel
				> (Cache.localPlayer
				   .combatLevel))
				i_117_ = 2000;
			    if ((Cache.localPlayer
				 .anInt2526) != 0
				&& (class39_sub5_sub4_sub4_sub2.anInt2526
				    != 0)) {
				if (class39_sub5_sub4_sub4_sub2.anInt2526
				    != (Cache.localPlayer
					.anInt2526))
				    i_117_ = 0;
				else
				    i_117_ = 2000;
			    }
			}
			if (i_116_ == 0)
			    actionType = 44 + i_117_;
			if (i_116_ == 1)
			    actionType = i_117_ + 22;
			if (i_116_ == 2)
			    actionType = i_117_ + 52;
			if (i_116_ == 3)
			    actionType = i_117_ + 56;
			if (i_116_ == 4)
			    actionType = i_117_ + 1;
			JString.queueAction
			    (actionType, id, positionX, positionY, Class39_Sub14.playerOptions[i_116_],
			     Class39_Sub5_Sub11.join((new JString[]
							   { (Entity
							      .whiPrefixJstr),
							     class3 })));
		    }
		}
	    }
	    for (int i_119_ = 0; i_119_ < Class39_Sub5_Sub11.actionOffset;
		 i_119_++) {
		if (KeyListenerImpl.actionTypes[i_119_] == 33) {
		    Class33.actionNames[i_119_]
			= Class39_Sub5_Sub11.join((new JString[]
							{ (Class39_Sub4
							   .aClass3_1338),
							  Class53.spaceJstr,
							  (Entity
							   .whiPrefixJstr),
							  class3 }));
		    break;
		}
	    }
	}
    }
    
    static {
	anInt1692 = 0;
	anInt1699 = 0;
	loadingTexturesJstr = JString.create("Loading textures )2 ");
	itemClickPositionX = 0;
	anInt1703 = -1;
	aClass3_1691 = JString.create("M");
	aClass3_1698 = aClass3_1691;
	aClass3_1704 = JString.create("Click to continue");
	aClass3_1689 = loadingTexturesJstr;
	aClass3_1701 = aClass3_1704;
	playerApperance = new PlayerApperance();
	bitMasks = new int[32];
	int i = 2;
	for (int i_120_ = 0; i_120_ < 32; i_120_++) {
	    bitMasks[i_120_] = i - 1;
	    i += i;
	}
	screenOverlayId = -1;
    }
}
