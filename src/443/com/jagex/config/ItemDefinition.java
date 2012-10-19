package com.jagex.config;

import com.jagex.io.AbstractFileLoader;
import com.jagex.io.FileLoader;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.Client;
import com.jagex.io.CacheIO;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.io.BufferedFile;
import com.jagex.graphics.ImageImpl;
import com.jagex.world.entities.StillGraphic;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.SubNode;
import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import com.jagex.utils.Queue;
import com.jagex.io.FrameBuffer;
import com.jagex.io.Buffer;
import com.jagex.utils.Cache;
import com.jagex.io.ArchiveWorker;
import unpackaged.Class12;
import unpackaged.Class2;
import unpackaged.Class23;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class32;
import unpackaged.Class34;
import unpackaged.Class37;
import unpackaged.Class39_Sub10;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import com.jagex.utils.ItemContainer;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub18;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class4;
import unpackaged.Class43;
import unpackaged.Class44;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MsTimer;
import unpackaged.Class47;
import com.jagex.graphics.GouraudVertex;
import unpackaged.Class53;
import unpackaged.TextureLoaderImpl;
import unpackaged.Class63;
import unpackaged.Class65;
import unpackaged.Class68;

/* Class39_Sub5_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class ItemDefinition extends SubNode
{
    public int anInt1641;
    public int[] anIntArray1642;
    public int anInt1643;
    public int anInt1644 = -1;
    public int anInt1645;
    public int[] anIntArray1646;
    public int anInt1647 = 0;
    public int anInt1648;
    public int anInt1649;
    public int anInt1650 = 0;
    public int anInt1651;
    public int id;
    public boolean aBoolean1653;
    public int anInt1654;
    public int anInt1655;
    public int anInt1656;
    public JString[] widgetOptions;
    public int[] anIntArray1658;
    public int anInt1659;
    public int anInt1660;
    public JString name;
    public int anInt1662;
    public static Cache aClass7_1663 = new Cache(100);
    public int anInt1664;
    public int anInt1665;
    public int anInt1666;
    public int anInt1667;
    public int anInt1668;
    public int anInt1669;
    public int[] anIntArray1670;
    public static byte[][][] aByteArrayArrayArray1671;
    public JString[] groundOptions;
    public int anInt1673;
    public int anInt1674;
    public int anInt1675;
    public int anInt1676;
    public int anInt1677;
    public int anInt1678;
    public int anInt1679;
    public static AbstractFileLoader aClass9_1680;
    public static JString aClass3_1681 = JString.create("");
    public static int[] anIntArray1682;
    public static JString aClass3_1683;
    public static int anInt1684 = 0;
    public static JString aClass3_1685;
    public int anInt1686;
    public static JString aClass3_1687;
    public static byte[][] aByteArrayArray1688 = new byte[1000][];
    
    public boolean method463(boolean bool, int i) {
	int i_0_ = anInt1645;
	int i_1_ = anInt1664;
	int i_2_ = anInt1660;
	if (bool) {
	    i_2_ = anInt1666;
	    i_1_ = anInt1643;
	    i_0_ = anInt1667;
	}
	if (i_0_ == -1)
	    return true;
	boolean bool_3_ = true;
	if (!Class4.aClass9_71.isArchiveLoaded(i_0_, 0))
	    bool_3_ = false;
	if (i_1_ != -1 && !Class4.aClass9_71.isArchiveLoaded(i_1_, 0))
	    bool_3_ = false;
	if (i_2_ != -1 && !Class4.aClass9_71.isArchiveLoaded(i_2_, 0))
	    bool_3_ = false;
	return bool_3_;
    }
    
    public void decode(int i, Buffer class39_sub6) {
	for (;;) {
	    int i_4_ = class39_sub6.getUint8();
	    if (i_4_ == 0)
		break;
	    method465((byte) 113, class39_sub6, i_4_);
	}
    }
    
    public void method465(byte i, Buffer class39_sub6, int i_5_) {
	int i_6_ = 104 % ((i - 22) / 57);
	if (i_5_ == 1)
	    anInt1655 = class39_sub6.getUint16();
	else if (i_5_ != 2) {
	    if (i_5_ != 4) {
		if (i_5_ == 5)
		    anInt1669 = class39_sub6.getUint16();
		else if (i_5_ != 6) {
		    if (i_5_ == 7) {
			anInt1674 = class39_sub6.getUint16();
			if (anInt1674 > 32767)
			    anInt1674 -= 65536;
		    } else if (i_5_ == 8) {
			anInt1654 = class39_sub6.getUint16();
			if (anInt1654 > 32767)
			    anInt1654 -= 65536;
		    } else if (i_5_ != 11) {
			if (i_5_ != 12) {
			    if (i_5_ == 16)
				aBoolean1653 = true;
			    else if (i_5_ != 23) {
				if (i_5_ == 24)
				    anInt1664 = class39_sub6.getUint16();
				else if (i_5_ == 25) {
				    anInt1667 = class39_sub6.getUint16();
				    anInt1679
					= class39_sub6.getUint8();
				} else if (i_5_ == 26)
				    anInt1643 = class39_sub6.getUint16();
				else if (i_5_ >= 30 && i_5_ < 35) {
				    groundOptions[i_5_ - 30]
					= class39_sub6.getJstr();
				    if (groundOptions[i_5_ - 30].equalTo
					(FileLoader.aClass3_1299))
					groundOptions[i_5_ - 30] = null;
				} else if (i_5_ >= 35 && i_5_ < 40)
				    widgetOptions[i_5_ - 35]
					= class39_sub6.getJstr();
				else if (i_5_ == 40) {
				    int i_7_
					= class39_sub6.getUint8();
				    anIntArray1658 = new int[i_7_];
				    anIntArray1642 = new int[i_7_];
				    for (int i_8_ = 0; i_8_ < i_7_; i_8_++) {
					anIntArray1658[i_8_]
					    = class39_sub6.getUint16();
					anIntArray1642[i_8_]
					    = class39_sub6.getUint16();
				    }
				} else if (i_5_ == 78)
				    anInt1660 = class39_sub6.getUint16();
				else if (i_5_ == 79)
				    anInt1666 = class39_sub6.getUint16();
				else if (i_5_ != 90) {
				    if (i_5_ == 91)
					anInt1648
					    = class39_sub6.getUint16();
				    else if (i_5_ != 92) {
					if (i_5_ != 93) {
					    if (i_5_ == 95)
						anInt1656
						    = class39_sub6
							  .getUint16();
					    else if (i_5_ != 97) {
						if (i_5_ == 98)
						    anInt1644
							= class39_sub6
							      .getUint16();
						else if (i_5_ < 100
							 || i_5_ >= 110) {
						    if (i_5_ == 110)
							anInt1668
							    = (class39_sub6
								   .getUint16
							       ());
						    else if (i_5_ == 111)
							anInt1677
							    = (class39_sub6
								   .getUint16
							       ());
						    else if (i_5_ == 112)
							anInt1641
							    = (class39_sub6
								   .getUint16
							       ());
						    else if (i_5_ != 113) {
							if (i_5_ != 114) {
							    if (i_5_ == 115)
								anInt1650
								    = (class39_sub6
									   .getUint8
								       ());
							} else
							    anInt1673
								= (class39_sub6
								       .getInt8
								   ()) * 5;
						    } else
							anInt1647
							    = (class39_sub6
								   .getInt8
							       ());
						} else {
						    if (anIntArray1670
							== null) {
							anIntArray1670
							    = new int[10];
							anIntArray1646
							    = new int[10];
						    }
						    anIntArray1670[i_5_ - 100]
							= class39_sub6
							      .getUint16();
						    anIntArray1646[i_5_ - 100]
							= class39_sub6
							      .getUint16();
						}
					    } else
						anInt1651
						    = class39_sub6
							  .getUint16();
					} else
					    anInt1678
						= class39_sub6.getUint16();
				    } else
					anInt1675
					    = class39_sub6.getUint16();
				} else
				    anInt1665 = class39_sub6.getUint16();
			    } else {
				anInt1645 = class39_sub6.getUint16();
				anInt1659 = class39_sub6.getUint8();
			    }
			} else
			    anInt1686 = class39_sub6.getUint32();
		    } else
			anInt1662 = 1;
		} else
		    anInt1676 = class39_sub6.getUint16();
	    } else
		anInt1649 = class39_sub6.getUint16();
	} else
	    name = class39_sub6.getJstr();
    }
    
    public boolean method466(int i, boolean bool) {
	int i_9_ = anInt1665;
	int i_10_ = anInt1675;
	if (bool) {
	    i_9_ = anInt1648;
	    i_10_ = anInt1678;
	}
	if (i_9_ == -1)
	    return true;
	boolean bool_11_ = true;
	if (!Class4.aClass9_71.isArchiveLoaded(i_9_, 0))
	    bool_11_ = false;
	if (i_10_ != -1 && !Class4.aClass9_71.isArchiveLoaded(i_10_, 0))
	    bool_11_ = false;
	return bool_11_;
    }
    
    public void method467(int i, ItemDefinition class39_sub5_sub1_12_,
			  ItemDefinition class39_sub5_sub1_13_) {
	anIntArray1658 = class39_sub5_sub1_13_.anIntArray1658;
	anInt1662 = i;
	anInt1655 = class39_sub5_sub1_13_.anInt1655;
	anIntArray1642 = class39_sub5_sub1_13_.anIntArray1642;
	anInt1654 = class39_sub5_sub1_13_.anInt1654;
	anInt1676 = class39_sub5_sub1_13_.anInt1676;
	anInt1674 = class39_sub5_sub1_13_.anInt1674;
	name = class39_sub5_sub1_12_.name;
	anInt1656 = class39_sub5_sub1_13_.anInt1656;
	anInt1686 = class39_sub5_sub1_12_.anInt1686;
	anInt1649 = class39_sub5_sub1_13_.anInt1649;
	anInt1669 = class39_sub5_sub1_13_.anInt1669;
	aBoolean1653 = class39_sub5_sub1_12_.aBoolean1653;
    }
    
    public Model getModel(int i, boolean bool, byte i_14_) {
	if (anIntArray1670 != null && i > 1) {
	    int i_15_ = -1;
	    for (int i_16_ = 0; i_16_ < 10; i_16_++) {
		if (anIntArray1646[i_16_] <= i && anIntArray1646[i_16_] != 0)
		    i_15_ = anIntArray1670[i_16_];
	    }
	    if (i_15_ != -1)
		return Class26.getItemDefinition(i_15_).getModel(1, bool,
							       (byte) -114);
	}
	if (bool) {
	    Model class39_sub5_sub4_sub6
		= ((Model)
		   StillGraphic.aClass7_2324
		       .get((long) id));
	    if (class39_sub5_sub4_sub6 != null)
		return class39_sub5_sub4_sub6;
	}
	Model class39_sub5_sub4_sub6
	    = Model.getModel(Class4.aClass9_71, anInt1655,
					       0);
	if (class39_sub5_sub4_sub6 == null)
	    return null;
	if (anInt1668 != 128 || anInt1677 != 128 || anInt1641 != 128)
	    class39_sub5_sub4_sub6.method559(anInt1668, anInt1677, anInt1641);
	if (anIntArray1658 != null) {
	    for (int i_17_ = 0; i_17_ < anIntArray1658.length; i_17_++)
		class39_sub5_sub4_sub6.method563(anIntArray1658[i_17_],
						 anIntArray1642[i_17_]);
	}
	if (bool) {
	    class39_sub5_sub4_sub6.applyLightingVector(anInt1647 + 64, anInt1673 + 768,
					     -50, -10, -50, true);
	    class39_sub5_sub4_sub6.aBoolean2374 = true;
	    StillGraphic.aClass7_2324.put
		(class39_sub5_sub4_sub6, (long) id);
	}
	return class39_sub5_sub4_sub6;
    }
    
    public Model method469(byte i, boolean bool) {
	int i_18_ = anInt1675;
	int i_19_ = anInt1665;
	if (bool) {
	    i_18_ = anInt1678;
	    i_19_ = anInt1648;
	}
	if (i_19_ == -1)
	    return null;
	Model class39_sub5_sub4_sub6
	    = Model.getModel(Class4.aClass9_71, i_19_, 0);
	if (i_18_ != -1) {
	    Model class39_sub5_sub4_sub6_20_
		= Model.getModel(Class4.aClass9_71, i_18_,
						   0);
	    Model[] class39_sub5_sub4_sub6s
		= { class39_sub5_sub4_sub6, class39_sub5_sub4_sub6_20_ };
	    class39_sub5_sub4_sub6
		= new Model(class39_sub5_sub4_sub6s, 2);
	}
	if (anIntArray1658 != null) {
	    for (int i_21_ = 0; anIntArray1658.length > i_21_; i_21_++)
		class39_sub5_sub4_sub6.method563(anIntArray1658[i_21_],
						 anIntArray1642[i_21_]);
	}
	return class39_sub5_sub4_sub6;
    }
    
    public static void method470() {
	if (SubNode.aBoolean1341) {
	    Class68.aClass39_Sub5_Sub10_Sub4_1188 = null;
	    ObjectDefinition.aClass39_Sub5_Sub10_Sub4_1927 = null;
	    Class68.aClass39_Sub5_Sub10_Sub4_1189 = null;
	    BufferedFile.aClass57_346 = null;
	    Class39_Sub12.aClass39_Sub5_Sub10_Sub4_1495 = null;
	    Queue.aClass39_Sub5_Sub10_Sub4_973 = null;
	    Class4.aClass39_Sub5_Sub10_Sub4_67 = null;
	    MsTimer.anIntArray1564 = null;
	    Class47.aClass39_Sub5_Sub10_Sub4_891 = null;
	    Class39_Sub5_Sub14.aClass39_Sub5_Sub10_Sub4_1909 = null;
	    Class65.aClass39_Sub5_Sub10_Sub4_1146 = null;
	    KeyListenerImpl.aClass39_Sub5_Sub10_Sub4_629 = null;
	    TraversalMap.aClass57_516 = null;
	    Widget.anIntArray2109 = null;
	    NameTable.aClass57_182 = null;
	    TextureLoaderImpl.aClass39_Sub5_Sub10_Sub4Array1243 = null;
	    Widget.aClass57_2114 = null;
	    Queue.aClass57_981 = null;
	    Class39_Sub5_Sub7.aClass57_1778 = null;
	    Class53.anIntArray970 = null;
	    TextureLoaderImpl.aClass57_1248 = null;
	    Class30.aClass39_Sub5_Sub10_Sub4_539 = null;
	    Class39_Sub5_Sub7.anIntArray1789 = null;
	    Class34.aClass39_Sub5_Sub10_Sub4_606 = null;
	    PlayerApperance.aClass39_Sub5_Sub10_Sub4_866 = null;
	    ArchiveWorker.aClass57_1196 = null;
	    BufferedFile.aClass39_Sub5_Sub10_Sub4_350 = null;
	    BufferedFile.anIntArray345 = null;
	    Class63.aClass57_1122 = null;
	    FrameBuffer.aClass57_2155 = null;
	    Npc.aClass39_Sub5_Sub10_Sub4_2500 = null;
	    Class23.graphics = null;
	    Widget.anIntArray2006 = null;
	    Class39_Sub5_Sub18.aClass57_2130 = null;
	    TraversalMap.aClass57_514 = null;
	    Class43.aClass57_812 = null;
	    NpcDefinition.aClass57_1867 = null;
	    SubNode.aBoolean1341 = false;
	    Class32.anIntArray586 = null;
	    VarpDefinition.aClass39_Sub5_Sub10_Sub4_1988 = null;
	    ImageImpl.aClass57_1576 = null;
	}
    }
    
    public static void method471(int i, int i_22_, int i_23_) {
	int i_24_ = 0;
	for (int i_25_ = 0; i_25_ < 100; i_25_++) {
	    if (Class2.messageBodies[i_25_] != null) {
		int i_26_ = Node.anInt741 + 4 + (-(i_24_ * 14) + 70);
		int type = Client.messageTypes[i_25_];
		if (i_26_ < -20)
		    break;
		if (type == 0)
		    i_24_++;
		JString class3 = StillObject.messagePrefixes[i_25_];
		if (class3 != null
		    && class3.beginsWith(Class37.crown1Jstr))
		    class3 = class3.substring(5);
		if (class3 != null
		    && class3.beginsWith(Class53.crown2Jstr))
		    class3 = class3.substring(5);
		if ((type == 1 || type == 2)
		    && (type == 1 || Bzip2Entry.anInt1051 == 0
			|| (Bzip2Entry.anInt1051 == 1
			    && JString.method60(i ^ ~0x53dc, class3)))) {
		    i_24_++;
		    if (i_26_ - 14 < i_22_ && i_26_ >= i_22_
			&& !class3.isEqual((Cache
					     .localPlayer
					     .aClass3_2521))) {
			Class26.anInt482++;
			if (CacheIO.rights >= 1) {
			    JString.queueAction(9, 0, 0, 0, Class34.aClass3_608,
					    (Class39_Sub5_Sub11.join
					     (new JString[] { (Entity
							      .whiPrefixJstr),
							     class3 })));
			    Class4.anInt60++;
			}
			JString.queueAction(21,  0, 0, 0, aClass3_1683,
					(Class39_Sub5_Sub11.join
					 ((new JString[]
					   { Entity.whiPrefixJstr,
					     class3 }))));
			JString.queueAction(31,  0, 0, 0, Class44.aClass3_835,
					(Class39_Sub5_Sub11.join
					 ((new JString[]
					   { Entity.whiPrefixJstr,
					     class3 }))));
			Class39_Sub5_Sub6.anInt1759++;
		    }
		}
		if ((type == 3 || type == 7) && Class2.anInt53 == 0
		    && (type == 7 || NameTable.anInt177 == 0
			|| NameTable.anInt177 == 1 && JString.method60(21469,
								    class3))) {
		    if (i_26_ - 14 < i_22_ && i_26_ >= i_22_) {
			if (CacheIO.rights >= 1) {
			    Class4.anInt60++;
			    JString.queueAction(9, 0, 0, 0, Class34.aClass3_608,
					    (Class39_Sub5_Sub11.join
					     (new JString[] { (Entity
							      .whiPrefixJstr),
							     class3 })));
			}
			Class39_Sub5_Sub6.anInt1759++;
			JString.queueAction(21, 0, 0, 0, aClass3_1683,
					(Class39_Sub5_Sub11.join
					 ((new JString[]
					   { Entity.whiPrefixJstr,
					     class3 }))));
			JString.queueAction(31, 0, 0, 0, Class44.aClass3_835,
					(Class39_Sub5_Sub11.join
					 ((new JString[]
					   { Entity.whiPrefixJstr,
					     class3 }))));
			Class26.anInt482++;
		    }
		    i_24_++;
		}
		if (type == 4
		    && (Cache.anInt118 == 0
			|| Cache.anInt118 == 1 && JString.method60(i ^ ~0x53dc,
								   class3))) {
		    if (i_26_ - 14 < i_22_ && i_26_ >= i_22_)
			JString.queueAction
			    (15,                                       0, 0, 0, Npc.aClass3_2504,
			     Class39_Sub5_Sub11.join((new JString[]
							   { (Entity
							      .whiPrefixJstr),
							     class3 })));
		    i_24_++;
		}
		if ((type == 5 || type == 6) && Class2.anInt53 == 0
		    && NameTable.anInt177 < 2)
		    i_24_++;
		if (type == 8
		    && (Cache.anInt118 == 0
			|| Cache.anInt118 == 1 && JString.method60(i ^ ~0x53dc,
								   class3))) {
		    i_24_++;
		    if (i_26_ - 14 < i_22_ && i_26_ >= i_22_)
			JString.queueAction(37,                        0, 0, 0, Widget.aClass3_2002,
					(Class39_Sub5_Sub11.join
					 ((new JString[]
					   { Entity.whiPrefixJstr,
					     class3 }))));
		}
	    }
	}
	if (i != -2)
	    method473(-71, -33, 84);
    }
    
    public static void method472(int i) {
	anIntArray1682 = null;
	aClass3_1687 = null;
	aClass9_1680 = null;
	aClass3_1683 = null;
	aByteArrayArray1688 = null;
	aClass3_1681 = null;
	aClass7_1663 = null;
	aClass3_1685 = null;
	aByteArrayArrayArray1671 = null;
    }
    
    public static boolean method473(int i, int i_28_, int i_29_) {
	if ((i ^ 0xffffffff) == i_28_ && i_29_ == Class39_Sub10.anInt1417)
	    return true;
	if (i == 1 && i_29_ == Class12.anInt194)
	    return true;
	if ((i == 2 || i == 3) && Widget.anInt2071 == i_29_)
	    return true;
	return false;
    }
    
    public Model method474(boolean bool, int i) {
	int i_30_ = anInt1664;
	int i_31_ = anInt1660;
	int i_32_ = anInt1645;
	if (bool) {
	    i_31_ = anInt1666;
	    i_30_ = anInt1643;
	    i_32_ = anInt1667;
	}
	if (i_32_ == -1)
	    return null;
	Model class39_sub5_sub4_sub6
	    = Model.getModel(Class4.aClass9_71, i_32_, 0);
	if (i_30_ != -1) {
	    Model class39_sub5_sub4_sub6_33_
		= Model.getModel(Class4.aClass9_71, i_30_,
						   0);
	    if (i_31_ != -1) {
		Model class39_sub5_sub4_sub6_34_
		    = Model.getModel(Class4.aClass9_71,
						       i_31_, 0);
		Model[] class39_sub5_sub4_sub6s
		    = { class39_sub5_sub4_sub6, class39_sub5_sub4_sub6_33_,
			class39_sub5_sub4_sub6_34_ };
		class39_sub5_sub4_sub6
		    = new Model(class39_sub5_sub4_sub6s, 3);
	    } else {
		Model[] class39_sub5_sub4_sub6s
		    = { class39_sub5_sub4_sub6, class39_sub5_sub4_sub6_33_ };
		class39_sub5_sub4_sub6
		    = new Model(class39_sub5_sub4_sub6s, 2);
	    }
	}
	if (!bool && anInt1659 != 0)
	    class39_sub5_sub4_sub6.translateVertices(0, anInt1659, 0);
	if (bool && anInt1679 != 0)
	    class39_sub5_sub4_sub6.translateVertices(0, anInt1679, 0);
	if (anIntArray1658 != null) {
	    for (int i_35_ = 0; i_35_ < anIntArray1658.length; i_35_++)
		class39_sub5_sub4_sub6.method563(anIntArray1658[i_35_],
						 anIntArray1642[i_35_]);
	}
	return class39_sub5_sub4_sub6;
    }
    
    public void method475(byte i) {
	/* empty */
    }
    
    public ItemDefinition method476(int i, byte i_36_) {
	if (anIntArray1670 != null && i > 1) {
	    int i_37_ = -1;
	    for (int i_38_ = 0; i_38_ < 10; i_38_++) {
		if (anIntArray1646[i_38_] <= i && anIntArray1646[i_38_] != 0)
		    i_37_ = anIntArray1670[i_38_];
	    }
	    if (i_37_ != -1)
		return Class26.getItemDefinition(i_37_);
	}
	if (i_36_ != 71)
	    method472(25);
	return this;
    }
    
    public ItemDefinition() {
	anInt1645 = -1;
	anInt1656 = 0;
	anInt1660 = -1;
	anInt1648 = -1;
	anInt1643 = -1;
	anInt1654 = 0;
	widgetOptions = new JString[] { null, null, null, null,
					  ItemContainer.dropJstr };
	anInt1664 = -1;
	anInt1659 = 0;
	aBoolean1653 = false;
	anInt1649 = 2000;
	anInt1665 = -1;
	name = GouraudVertex.aClass3_899;
	anInt1673 = 0;
	anInt1651 = -1;
	anInt1667 = -1;
	anInt1666 = -1;
	anInt1669 = 0;
	anInt1641 = 128;
	anInt1675 = -1;
	anInt1674 = 0;
	anInt1668 = 128;
	anInt1662 = 0;
	anInt1676 = 0;
	anInt1678 = -1;
	anInt1679 = 0;
	groundOptions
	    = new JString[] { null, null, Projectile.aClass3_2190,
			     null, null };
	anInt1677 = 128;
	anInt1686 = 1;
    }
    
    static {
	aClass3_1685 = JString.create("Add ignore");
	aClass3_1687 = JString.create("leuchten1:");
	aClass3_1683 = aClass3_1685;
    }
}
