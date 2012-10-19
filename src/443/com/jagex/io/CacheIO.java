package com.jagex.io;

/* Class6 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.io.BufferedFile;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.JImage;
import com.jagex.graphics.AbstractImage;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Deque;
import java.awt.Graphics;
import com.jagex.awt.JCanvas;
import com.jagex.world.Barrier;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class23;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class34;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub4_Sub2;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class41;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import unpackaged.TextureLoaderImpl;
import com.jagex.audio.AudioHandler;
import unpackaged.Class62_Sub1_Sub2;
import unpackaged.Class66;
import unpackaged.Class68;
import com.jagex.script.ClientScript;
import unpackaged.Runnable_Impl1;
import com.jagex.sign.Signlink;
import com.jagex.config.Widget;

public class CacheIO
{
    public BufferedFile aClass18_92 = null;
    public BufferedFile aClass18_93 = null;
    public int id;
    public static HashTable pendingPriorityRequests;
    public static JString aClass3_96;
    public static int rights = 0;
    public int anInt98 = 65000;
    public static int anInt99;
    public static JString aClass3_100;
    
    public static boolean method122(Signlink class21, int i, boolean bool) {
	ArchiveRequest.anInt1415 = 20;
	try {
	    TextureLoaderImpl.audioHandler
		= (AudioHandler) Class.forName("Class62_Sub1_Sub1").newInstance();
	    return true;
	} catch (Throwable throwable) {
	    Runnable_Impl1 runnable_impl1 = class21.method251(i ^ i);
	    if (runnable_impl1 != null) {
		TextureLoaderImpl.audioHandler
		    = new Class62_Sub1_Sub2(class21, runnable_impl1);
		return true;
	    }
	    return false;
	}
    }
    
    public static void method123(Widget widget,
				 int i) {
	int i_0_ = widget.anInt2078;
	if (i_0_ >= 1 && i_0_ <= 100 || i_0_ >= 701 && i_0_ <= 800) {
	    if (Class14.anInt232 == 0) {
		if (i_0_ == 1) {
		    widget.inactiveText = Class15.aClass3_286;
		    widget.anInt2089 = 0;
		    return;
		}
		if (i_0_ == 2) {
		    widget.inactiveText
			= Class39_Sub5_Sub4_Sub2.aClass3_2230;
		    widget.anInt2089 = 0;
		    return;
		}
	    }
	    if (Class14.anInt232 == 1) {
		if (i_0_ == 1) {
		    widget.inactiveText
			= SubNode.aClass3_1346;
		    widget.anInt2089 = 0;
		    return;
		}
		if (i_0_ == 2) {
		    widget.inactiveText
			= Class39_Sub5_Sub4_Sub2.aClass3_2222;
		    widget.anInt2089 = 0;
		    return;
		}
		if (i_0_ == 3) {
		    widget.inactiveText = Class14.aClass3_256;
		    widget.anInt2089 = 0;
		    return;
		}
	    }
	    if (i_0_ > 700)
		i_0_ -= 601;
	    else
		i_0_--;
	    int i_1_ = Class4.anInt62;
	    if (Class14.anInt232 != 2)
		i_1_ = 0;
	    if (i_1_ <= i_0_) {
		widget.anInt2089 = 0;
		widget.inactiveText = Class66.blankString;
	    } else {
		widget.inactiveText
		    = Projectile.aClass3Array2188[i_0_];
		widget.anInt2089 = 1;
	    }
	} else if (i_0_ >= 101 && i_0_ <= 200 || i_0_ >= 801 && i_0_ <= 900) {
	    if (i_0_ > 800)
		i_0_ -= 701;
	    else
		i_0_ -= 101;
	    int i_2_ = Class4.anInt62;
	    if (Class14.anInt232 != 2)
		i_2_ = 0;
	    if (i_0_ >= i_2_) {
		widget.inactiveText = Class66.blankString;
		widget.anInt2089 = 0;
	    } else {
		if (Player.anIntArray2533[i_0_] == 0)
		    widget.inactiveText
			= Class39_Sub5_Sub11.join((new JString[]
							{ (Class39_Sub10
							   .aClass3_1421),
							  (PlayerApperance
							   .aClass3_864) }));
		else if (Player.anIntArray2533[i_0_]
			 >= 5000) {
		    if (Player.anIntArray2533[i_0_]
			!= BufferedFile.worldId)
			widget.inactiveText
			    = (Class39_Sub5_Sub11.join
			       ((new JString[]
				 { HashTable.yelPrefixJstr, Class44.aClass3_847,
				   (AbstractImage.toJstr
				    ((Player
				      .anIntArray2533[i_0_]) - 5000)) })));
		    else
			widget.inactiveText
			    = (Class39_Sub5_Sub11.join
			       ((new JString[]
				 { Class41.greenPrefixJstr, Class44.aClass3_847,
				   (AbstractImage.toJstr
				    ((Player
				      .anIntArray2533[i_0_]) - 5000)) })));
		} else if (Player.anIntArray2533[i_0_]
			   != BufferedFile.worldId)
		    widget.inactiveText
			= (Class39_Sub5_Sub11.join
			   ((new JString[]
			     { HashTable.yelPrefixJstr, StillObject.aClass3_1465,
			       AbstractImage.toJstr((Player
						   .anIntArray2533[i_0_])) })));
		else
		    widget.inactiveText
			= (Class39_Sub5_Sub11.join
			   ((new JString[]
			     { Class41.greenPrefixJstr, StillObject.aClass3_1465,
			       AbstractImage.toJstr((Player
						   .anIntArray2533[i_0_])) })));
		widget.anInt2089 = 1;
	    }
	} else if (i_0_ == 203) {
	    int i_3_ = Class4.anInt62;
	    if (Class14.anInt232 != 2)
		i_3_ = 0;
	    widget.anInt2095 = i_3_ * 15 + 20;
	    if (widget.height >= widget.anInt2095)
		widget.anInt2095
		    = widget.height + 1;
	} else if (i_0_ >= 401 && i_0_ <= 500) {
	    i_0_ -= 401;
	    if (i_0_ == 0 && Class14.anInt232 == 0) {
		widget.anInt2089 = 0;
		widget.inactiveText
		    = StillGraphic.aClass3_2353;
	    } else if (i_0_ == 1 && Class14.anInt232 == 0) {
		widget.inactiveText
		    = Class39_Sub5_Sub4_Sub2.aClass3_2230;
		widget.anInt2089 = 0;
	    } else {
		int i_4_ = Class15.amountIgnores;
		if (Class14.anInt232 == 0)
		    i_4_ = 0;
		if (i_4_ <= i_0_) {
		    widget.inactiveText = Class66.blankString;
		    widget.anInt2089 = 0;
		} else {
		    widget.inactiveText
			= Deque.decodeBase37
			      (Class39_Sub5_Sub9.ignoreUsernames[i_0_])
			      .formatUsername();
		    widget.anInt2089 = 1;
		}
	    }
	} else if (i_0_ == 503) {
	    widget.anInt2095 = Class15.amountIgnores * 15 + 20;
	    if (widget.height >= widget.anInt2095)
		widget.anInt2095
		    = widget.height + 1;
	} else if (i_0_ == 324) {
	    if (FileLoader.anInt1287 == -1) {
		Class23.anInt436 = widget.activeSpriteId;
		FileLoader.anInt1287 = widget.unactiveSpriteId;
	    }
	    if (!ClientScript.playerApperance.isMale)
		widget.unactiveSpriteId = Class23.anInt436;
	    else
		widget.unactiveSpriteId = FileLoader.anInt1287;
	} else if (i_0_ == 325) {
	    if (FileLoader.anInt1287 == -1) {
		Class23.anInt436 = widget.activeSpriteId;
		FileLoader.anInt1287 = widget.unactiveSpriteId;
	    }
	    if (ClientScript.playerApperance.isMale)
		widget.unactiveSpriteId = Class23.anInt436;
	    else
		widget.unactiveSpriteId = FileLoader.anInt1287;
	} else if (i_0_ == 327) {
	    widget.modelCosineRotationX = 150;
	    widget.modelSineRotationX
		= ((int) (Math.sin((double) Class2.logicCycle / 40.0) * 256.0)
		   & 0x7ff);
	    widget.inactiveModelType = 5;
	    widget.inactiveAnimationModelId = 0;
	} else if (i_0_ == 328) {
	    widget.modelCosineRotationX = 150;
	    widget.modelSineRotationX
		= ((int) (Math.sin((double) Class2.logicCycle / 40.0) * 256.0)
		   & 0x7ff);
	    widget.inactiveModelType = 5;
	    widget.inactiveAnimationModelId = 1;
	} else {
	    int i_5_ = -5 % ((i - 52) / 55);
	    if (i_0_ == 600)
		widget.inactiveText
		    = Class39_Sub5_Sub11.join((new JString[]
						    { Class66.reportUsername,
						      Class4.aClass3_73 }));
	    else if (i_0_ == 620) {
		if (rights >= 1) {
		    if (Class39_Sub12.aBoolean1487) {
			widget.inactiveText = Huffman.mutePlayerOptionOnJstr;
			widget.inactiveColor = 0xFF0000;
		    } else {
			widget.inactiveText = Barrier.mutePlayerOptionOffJstr;
			widget.inactiveColor = 0xFFFFFF;
		    }
		} else
		    widget.inactiveText = Class66.blankString;
	    }
	}
    }
    
    public boolean insert(byte[] src, int i_6_, int i_7_) {
	synchronized (aClass18_93) {
	    if (i_7_ < 0 || anInt98 < i_7_)
		throw new IllegalArgumentException();
	    boolean bool = insert((byte) -122, i_6_, true, i_7_, src);
	    if (!bool)
		bool = insert((byte) -70, i_6_, false, i_7_, src);
	    return bool;
	}
    }
    
    public boolean insert(byte i, int archiveId, boolean bool, int len,
			     byte[] is) {
	synchronized (aClass18_93) {
	    try {
		if (i >= -37)
		    aClass3_100 = null;
		int blockId;
		if (!bool) {
		    blockId = (int) ((aClass18_93.getLength() + 519L) / 520L);
		    if (blockId == 0)
			blockId = 1;
		} else {
		    if (aClass18_92.getLength() < (long) (archiveId * 6 + 6))
			return false;
		    aClass18_92.setPosition((long) (archiveId * 6));
		    aClass18_92.read(HashTable.buffer, 6, 0);
		    blockId = ((HashTable.buffer[3] << 16 & 0xff0000)
			     + ((HashTable.buffer[4] & 0xff) << 8)
			     + (HashTable.buffer[5] & 0xff));
		    if (blockId <= 0
			|| (long) blockId > aClass18_93.getLength() / 520L)
			return false;
		}
		HashTable.buffer[5] = (byte) blockId;
		HashTable.buffer[4] = (byte) (blockId >> 8);
		HashTable.buffer[0] = (byte) (len >> 16);
		int i_11_ = 0;
		HashTable.buffer[1] = (byte) (len >> 8);
		HashTable.buffer[2] = (byte) len;
		HashTable.buffer[3] = (byte) (blockId >> 16);
		aClass18_92.setPosition((long) (archiveId * 6));
		aClass18_92.write(HashTable.buffer,0, 6);
		int i_12_ = 0;
		int i_13_;
		for (/**/; len > i_11_; i_11_ += i_13_) {
		    int i_14_ = 0;
		    if (bool) {
			aClass18_93.setPosition((long) (blockId * 520));
			try {
			    aClass18_93.read(HashTable.buffer, 8,
						  0);
			} catch (java.io.EOFException eofexception) {
			    break;
			}
			i_14_ = ((HashTable.buffer[6] & 0xff)
				 + ((HashTable.buffer[5] << 8 & 0xff00)
				    + (HashTable.buffer[4] << 16
				       & 0xff0000)));
			i_13_ = ((HashTable.buffer[0] << 8 & 0xff00)
				 + (HashTable.buffer[1] & 0xff));
			int i_15_ = HashTable.buffer[7] & 0xff;
			int i_16_ = (((HashTable.buffer[2] & 0xff) << 8)
				     + (HashTable.buffer[3] & 0xff));
			if (i_13_ != archiveId || i_16_ != i_12_
			    || id != i_15_)
			    return false;
			if (i_14_ < 0 || ((long) i_14_
					  > aClass18_93.getLength() / 520L))
			    return false;
		    }
		    if (i_14_ == 0) {
			bool = false;
			i_14_ = (int) ((aClass18_93.getLength() + 519L)
				       / 520L);
			if (i_14_ == 0)
			    i_14_++;
			if (blockId == i_14_)
			    i_14_++;
		    }
		    HashTable.buffer[3] = (byte) i_12_;
		    i_13_ = -i_11_ + len;
		    HashTable.buffer[2] = (byte) (i_12_ >> 8);
		    if (len - i_11_ <= 512)
			i_14_ = 0;
		    HashTable.buffer[6] = (byte) i_14_;
		    HashTable.buffer[4] = (byte) (i_14_ >> 16);
		    i_12_++;
		    HashTable.buffer[5] = (byte) (i_14_ >> 8);
		    HashTable.buffer[7] = (byte) id;
		    if (i_13_ > 512)
			i_13_ = 512;
		    HashTable.buffer[0] = (byte) (archiveId >> 8);
		    HashTable.buffer[1] = (byte) archiveId;
		    aClass18_93.setPosition((long) (blockId * 520));
		    blockId = i_14_;
		    aClass18_93.write(HashTable.buffer,0, 8);
		    aClass18_93.write(is, i_11_, i_13_);
		}
		return true;
	    } catch (java.io.IOException ioexception) {
		return false;
	    }
	}
    }
    
    public byte[] lookup(int id) {
	synchronized (aClass18_93) {
	    try {
		if (aClass18_92.getLength() < (long) (id * 6 + 6))
		    return null;
		aClass18_92.setPosition((long) (id * 6));
		aClass18_92.read(HashTable.buffer, 6, 0);
		int i_18_
		    = ((HashTable.buffer[2] & 0xff)
		       + (((HashTable.buffer[1] & 0xff) << 8)
			  + (HashTable.buffer[0] << 16 & 0xff0000)));
		int i_19_ = ((HashTable.buffer[5] & 0xff)
			     + ((HashTable.buffer[4] << 8 & 0xff00)
				+ ((HashTable.buffer[3] & 0xff) << 16)));
		if (i_18_ < 0 || i_18_ > anInt98)
		    return null;
		if (i_19_ <= 0
		    || (long) i_19_ > aClass18_93.getLength() / 520L)
		    return null;
		int i_20_ = 0;
		int i_21_ = 0;
		byte[] is = new byte[i_18_];
		while (i_21_ < i_18_) {
		    if (i_19_ == 0)
			return null;
		    int i_22_ = i_18_ - i_21_;
		    aClass18_93.setPosition((long) (i_19_ * 520));
		    if (i_22_ > 512)
			i_22_ = 512;
		    aClass18_93.read(HashTable.buffer, i_22_ + 8,
					  0);
		    int i_23_ = ((HashTable.buffer[6] & 0xff)
				 + ((HashTable.buffer[4] & 0xff) << 16)
				 + ((HashTable.buffer[5] & 0xff) << 8));
		    int i_24_ = HashTable.buffer[7] & 0xff;
		    int i_25_ = ((HashTable.buffer[3] & 0xff)
				 + ((HashTable.buffer[2] & 0xff) << 8));
		    int i_26_ = ((HashTable.buffer[1] & 0xff)
				 + (HashTable.buffer[0] << 8 & 0xff00));
		    if (i_26_ != id || i_20_ != i_25_ || this.id != i_24_)
			return null;
		    if (i_23_ < 0
			|| aClass18_93.getLength() / 520L < (long) i_23_)
			return null;
		    for (int i_27_ = 0; i_22_ > i_27_; i_27_++)
			is[i_21_++] = HashTable.buffer[i_27_ + 8];
		    i_20_++;
		    i_19_ = i_23_;
		}
		return is;
	    } catch (java.io.IOException ioexception) {
		return null;
	    }
	}
    }
    
    @Override
    public String toString() {
	return "Cache:" + id;
    }
    
    public static void method127(int i) {
	try {
	    Graphics graphics = Class41.canvas.getGraphics();
	    TraversalMap.aClass57_514.draw(graphics, i, 357);
	} catch (Exception exception) {
	    Class41.canvas.repaint();
	}
    }
    
    public static void method128(byte i) {
	if (Class20.anInt397 > 0) {
	    for (int i_28_ = 0; i_28_ < 256; i_28_++) {
		if (Class20.anInt397 > 768)
		    GroundItem.anIntArray2245[i_28_]
			= JImage.method1011(BufferedFile.anIntArray338[i_28_],
						  -Class20.anInt397 + 1024,
						  Class23.anIntArray423[i_28_],
						  (byte) -27);
		else if (Class20.anInt397 > 256)
		    GroundItem.anIntArray2245[i_28_]
			= Class23.anIntArray423[i_28_];
		else
		    GroundItem.anIntArray2245[i_28_]
			= JImage.method1011(Class23.anIntArray423[i_28_],
						  -Class20.anInt397 + 256,
						  BufferedFile.anIntArray338[i_28_],
						  (byte) 122);
	    }
	} else if (JCanvas.anInt24 <= 0) {
	    for (int i_29_ = 0; i_29_ < 256; i_29_++)
		GroundItem.anIntArray2245[i_29_]
		    = BufferedFile.anIntArray338[i_29_];
	} else {
	    for (int i_30_ = 0; i_30_ < 256; i_30_++) {
		if (JCanvas.anInt24 <= 768) {
		    if (JCanvas.anInt24 > 256)
			GroundItem.anIntArray2245[i_30_]
			    = GroundItem.anIntArray2247[i_30_];
		    else
			GroundItem.anIntArray2245[i_30_]
			    = (JImage.method1011
			       (GroundItem.anIntArray2247[i_30_],
				-JCanvas.anInt24 + 256,
				BufferedFile.anIntArray338[i_30_], (byte) -100));
		} else
		    GroundItem.anIntArray2245[i_30_]
			= JImage.method1011(BufferedFile.anIntArray338[i_30_],
						  -JCanvas.anInt24 + 1024,
						  (GroundItem
						   .anIntArray2247[i_30_]),
						  (byte) -64);
	    }
	}
	int i_31_ = 256;
	for (int i_32_ = 0; i_32_ < 33920; i_32_++)
	    MouseRecorder.aClass57_551.buffer[i_32_]
		= Deque.aClass39_Sub5_Sub10_Sub3_920.pixelBuffer[i_32_];
	int i_33_ = 0;
	int i_34_ = 1152;
	for (int i_35_ = 1; i_35_ < i_31_ - 1; i_35_++) {
	    int i_36_
		= (-i_35_ + i_31_) * Huffman.anIntArray762[i_35_] / i_31_;
	    int i_37_ = 22 + i_36_;
	    if (i_37_ < 0)
		i_37_ = 0;
	    i_33_ += i_37_;
	    for (int i_38_ = i_37_; i_38_ < 128; i_38_++) {
		int i_39_ = ArchiveWorker.anIntArray1202[i_33_++];
		if (i_39_ != 0) {
		    int i_40_ = i_39_;
		    int i_41_ = MouseRecorder.aClass57_551.buffer[i_34_];
		    int i_42_ = -i_39_ + 256;
		    i_39_ = GroundItem.anIntArray2245[i_39_];
		    MouseRecorder.aClass57_551.buffer[i_34_++]
			= (Class34.and((i_40_ * Class34.and(i_39_,
									65280)
					      + (i_42_
						 * Class34.and(65280,
								     i_41_))),
					     16711680)
			   + (Class34.and
			      (-16711936,
			       (i_40_ * Class34.and(16711935, i_39_)
				+ i_42_ * Class34.and(i_41_,
							    16711935))))) >> 8;
		} else
		    i_34_++;
	    }
	    i_34_ += i_37_;
	}
	int i_43_ = -58 % ((-21 - i) / 52);
	i_33_ = 0;
	for (int i_44_ = 0; i_44_ < 33920; i_44_++)
	    Class68.aClass57_1186.buffer[i_44_]
		= ISAAC.aClass39_Sub5_Sub10_Sub3_1096.pixelBuffer[i_44_];
	i_34_ = 1176;
	for (int i_45_ = 1; i_45_ < i_31_ - 1; i_45_++) {
	    int i_46_
		= (-i_45_ + i_31_) * Huffman.anIntArray762[i_45_] / i_31_;
	    int i_47_ = -i_46_ + 103;
	    i_34_ += i_46_;
	    for (int i_48_ = 0; i_48_ < i_47_; i_48_++) {
		int i_49_ = ArchiveWorker.anIntArray1202[i_33_++];
		if (i_49_ != 0) {
		    int i_50_ = i_49_;
		    int i_51_ = 256 - i_49_;
		    i_49_ = GroundItem.anIntArray2245[i_49_];
		    int i_52_ = Class68.aClass57_1186.buffer[i_34_];
		    Class68.aClass57_1186.buffer[i_34_++]
			= ((Class34.and(-16711936,
					      ((Class34.and(i_49_,
								  16711935)
						* i_50_)
					       + (i_51_
						  * Class34.and(16711935,
								      i_52_))))
			    + (Class34.and
			       (16711680,
				(i_51_ * Class34.and(i_52_, 65280)
				 + i_50_ * Class34.and(65280, i_49_)))))
			   >> 8);
		} else
		    i_34_++;
	    }
	    i_34_ += -i_47_ + 128 - i_46_;
	    i_33_ += 128 - i_47_;
	}
    }
    
    public static void method129(boolean bool) {
	aClass3_100 = null;
	pendingPriorityRequests = null;
	aClass3_96 = null;
    }
    
    public CacheIO(int i, BufferedFile class18, BufferedFile class18_53_, int i_54_) {
	aClass18_92 = class18_53_;
	anInt98 = i_54_;
	id = i;
	aClass18_93 = class18;
    }
    
    static {
	aClass3_96 = JString.create("Empf-=nger:");
	anInt99 = 0;
	pendingPriorityRequests = new HashTable(32);
	aClass3_100
	    = (JString.create
	       ("Um ein neues Spielkonto zu erstellen)1 m-Ussen Sie"));
    }
}
