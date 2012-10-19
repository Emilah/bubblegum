package unpackaged;

import com.jagex.world.Entity;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.ItemContainer;
import com.jagex.script.ScriptState;
import com.jagex.config.Widget;
import com.jagex.config.ObjectDefinition;
import com.jagex.io.FileLoader;
import com.jagex.awt.JCanvas;
import com.jagex.utils.NameTable;
import com.jagex.utils.HashTable;
import com.jagex.world.entities.GroundItem;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.utils.Cache;

/* Class50 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class50 {

    public static JString aClass3_928 = JString.create("Suche nach Updates )2 ");
    public int anInt929;
    public int anInt930;
    public static int anInt931;
    public int anInt932;
    public Entity aClass39_Sub5_Sub4_933;
    public static boolean[] aBooleanArray934 = {true, true, true, true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true, true, true, true,
        true, false, false};
    public int anInt935;
    public static JString aClass3_936 = JString.create("Bitte benutzen Sie eine andere Welt)3");
    public int anInt937;

    public static void updateProjectiles() {
        for (Projectile projectile = ((Projectile) Class23.projectiles.getFirst());
                projectile != null;
                projectile = ((Projectile) Class23.projectiles.getNext())) {
            if (NameTable.height == projectile.anInt2187
                    && projectile.anInt2204 >= Class2.logicCycle) {
                if (projectile.anInt2201 <= Class2.logicCycle) {
                    if (projectile.anInt2193 > 0) {
                        Npc class39_sub5_sub4_sub4_sub1 = (GroundItem.npcs[projectile.anInt2193 - 1]);
                        if (class39_sub5_sub4_sub4_sub1 != null
                                && class39_sub5_sub4_sub4_sub1.fPositionY >= 0
                                && class39_sub5_sub4_sub4_sub1.fPositionY < 13312
                                && class39_sub5_sub4_sub4_sub1.fPositionX >= 0
                                && class39_sub5_sub4_sub4_sub1.fPositionX < 13312) {
                            projectile.method497(((Class14.method212(class39_sub5_sub4_sub4_sub1.fPositionY, class39_sub5_sub4_sub4_sub1.fPositionX, projectile.anInt2187))
                                    - projectile.anInt2195),
                                    118, class39_sub5_sub4_sub4_sub1.fPositionX,
                                    Class2.logicCycle,
                                    class39_sub5_sub4_sub4_sub1.fPositionY);
                        }
                    }
                    if (projectile.anInt2193 < 0) {
                        int i = -projectile.anInt2193 - 1;
                        Player player;
                        if (ItemContainer.localId != i) {
                            player = (Class14.players[i]);
                        } else {
                            player = Cache.localPlayer;
                        }
                        if (player != null
                                && player.fPositionY >= 0
                                && player.fPositionY < 13312
                                && player.fPositionX >= 0
                                && player.fPositionX < 13312) {
                            projectile.method497(((Class14.method212(player.fPositionY, player.fPositionX, projectile.anInt2187))
                                    - projectile.anInt2195),
                                    49, player.fPositionX,
                                    Class2.logicCycle,
                                    player.fPositionY);
                        }
                    }
                    projectile.method498(1024, PlayerApperance.anInt856);
                    Class44.world.method375(NameTable.height,
                            (int) projectile.x,
                            (int) projectile.y,
                            (int) projectile.z, 60,
                            projectile,
                            projectile.anInt2206, -1, false);
                }
            } else {
                projectile.unlinkDeque();
            }
        }
    }

    public static void method971(int i, int i_0_, int i_1_, int i_2_, int i_3_,
            int i_4_) {
        int i_5_ = Class44.world.method379(i, i_2_, i_3_);
        if (i_5_ != 0) {
            int i_6_ = Class44.world.method359(i, i_2_, i_3_, i_5_);
            int i_7_ = i_6_ & 0x1f;
            int i_8_ = i_6_ >> 6 & 0x3;
            int[] is = (Class39_Sub5_Sub4_Sub2.aClass39_Sub5_Sub10_Sub3_2219.pixelBuffer);
            int i_9_ = i_2_ * 4 + 24624 + (-(i_3_ * 512) + 52736) * 4;
            int i_10_ = i_1_;
            int i_11_ = i_5_ >> 14 & 0x7fff;
            if (i_5_ > 0) {
                i_10_ = i_4_;
            }
            ObjectDefinition class39_sub5_sub15 = JCanvas.getObjectDefinition(i_11_);
            if (class39_sub5_sub15.anInt1972 == -1) {
                if (i_7_ == 0 || i_7_ == 2) {
                    if (i_8_ == 0) {
                        is[i_9_] = i_10_;
                        is[i_9_ + 512] = i_10_;
                        is[i_9_ + 1024] = i_10_;
                        is[i_9_ + 1536] = i_10_;
                    } else if (i_8_ == 1) {
                        is[i_9_] = i_10_;
                        is[i_9_ + 1] = i_10_;
                        is[i_9_ + 2] = i_10_;
                        is[i_9_ + 3] = i_10_;
                    } else if (i_8_ == 2) {
                        is[i_9_ + 3] = i_10_;
                        is[i_9_ + 515] = i_10_;
                        is[i_9_ + 1024 + 3] = i_10_;
                        is[i_9_ + 1536 + 3] = i_10_;
                    } else if (i_8_ == 3) {
                        is[i_9_ + 1536] = i_10_;
                        is[i_9_ + 1536 + 1] = i_10_;
                        is[i_9_ + 2 + 1536] = i_10_;
                        is[i_9_ + 1539] = i_10_;
                    }
                }
                if (i_7_ == 3) {
                    if (i_8_ == 0) {
                        is[i_9_] = i_10_;
                    } else if (i_8_ == 1) {
                        is[i_9_ + 3] = i_10_;
                    } else if (i_8_ != 2) {
                        if (i_8_ == 3) {
                            is[i_9_ + 1536] = i_10_;
                        }
                    } else {
                        is[i_9_ + 1539] = i_10_;
                    }
                }
                if (i_7_ == 2) {
                    if (i_8_ == 3) {
                        is[i_9_] = i_10_;
                        is[i_9_ + 512] = i_10_;
                        is[i_9_ + 1024] = i_10_;
                        is[i_9_ + 1536] = i_10_;
                    } else if (i_8_ != 0) {
                        if (i_8_ != 1) {
                            if (i_8_ == 2) {
                                is[i_9_ + 1536] = i_10_;
                                is[i_9_ + 1 + 1536] = i_10_;
                                is[i_9_ + 1536 + 2] = i_10_;
                                is[i_9_ + 1536 + 3] = i_10_;
                            }
                        } else {
                            is[i_9_ + 3] = i_10_;
                            is[i_9_ + 3 + 512] = i_10_;
                            is[i_9_ + 3 + 1024] = i_10_;
                            is[i_9_ + 1536 + 3] = i_10_;
                        }
                    } else {
                        is[i_9_] = i_10_;
                        is[i_9_ + 1] = i_10_;
                        is[i_9_ + 2] = i_10_;
                        is[i_9_ + 3] = i_10_;
                    }
                }
            } else {
                IndexedColorSprite class39_sub5_sub10_sub4 = (FileLoader.aClass39_Sub5_Sub10_Sub4Array1296[class39_sub5_sub15.anInt1972]);
                if (class39_sub5_sub10_sub4 != null) {
                    int i_12_ = ((class39_sub5_sub15.anInt1925 * 4
                            - class39_sub5_sub10_sub4.anInt2480)
                            / 2);
                    int i_13_ = ((-class39_sub5_sub10_sub4.anInt2481
                            + class39_sub5_sub15.anInt1948 * 4)
                            / 2);
                    class39_sub5_sub10_sub4.method695(i_2_ * 4 + (48 + i_12_),
                            (48
                            + (104 - i_3_
                            - (class39_sub5_sub15.anInt1948)) * 4
                            + i_13_));
                }
            }
        }
        i_5_ = Class44.world.method384(i, i_2_, i_3_);
        if (i_5_ != 0) {
            int i_14_ = Class44.world.method359(i, i_2_, i_3_, i_5_);
            int i_15_ = (i_5_ & 0x1fffeba2) >> 14;
            int i_16_ = i_14_ & 0x1f;
            int i_17_ = (i_14_ & 0xc2) >> 6;
            ObjectDefinition class39_sub5_sub15 = JCanvas.getObjectDefinition(i_15_);
            if (class39_sub5_sub15.anInt1972 == -1) {
                if (i_16_ == 9) {
                    int i_18_ = 15658734;
                    int[] is = (Class39_Sub5_Sub4_Sub2.aClass39_Sub5_Sub10_Sub3_2219.pixelBuffer);
                    int i_19_ = (-(i_3_ * 512) + 52736) * 4 + i_2_ * 4 + 24624;
                    if (i_5_ > 0) {
                        i_18_ = 15597568;
                    }
                    if (i_17_ == 0 || i_17_ == 2) {
                        is[i_19_ + 1536] = i_18_;
                        is[i_19_ + 1025] = i_18_;
                        is[i_19_ + 514] = i_18_;
                        is[i_19_ + 3] = i_18_;
                    } else {
                        is[i_19_] = i_18_;
                        is[i_19_ + 513] = i_18_;
                        is[i_19_ + 2 + 1024] = i_18_;
                        is[i_19_ + 1539] = i_18_;
                    }
                }
            } else {
                IndexedColorSprite class39_sub5_sub10_sub4 = (FileLoader.aClass39_Sub5_Sub10_Sub4Array1296[class39_sub5_sub15.anInt1972]);
                if (class39_sub5_sub10_sub4 != null) {
                    int i_20_ = ((class39_sub5_sub15.anInt1925 * 4
                            - class39_sub5_sub10_sub4.anInt2480)
                            / 2);
                    int i_21_ = ((-class39_sub5_sub10_sub4.anInt2481
                            + class39_sub5_sub15.anInt1948 * 4)
                            / 2);
                    class39_sub5_sub10_sub4.method695(48 - (-(i_2_ * 4)
                            - i_20_),
                            (i_21_ + 48
                            + (-(class39_sub5_sub15.anInt1948)
                            - i_3_ + 104) * 4));
                }
            }
        }
        i_5_ = Class44.world.method404(i, i_2_, i_3_);
        if (i_5_ != 0) {
            int i_22_ = i_5_ >> 14 & 0x7fff;
            ObjectDefinition class39_sub5_sub15 = JCanvas.getObjectDefinition(i_22_);
            if (class39_sub5_sub15.anInt1972 != -1) {
                IndexedColorSprite class39_sub5_sub10_sub4 = (FileLoader.aClass39_Sub5_Sub10_Sub4Array1296[class39_sub5_sub15.anInt1972]);
                if (class39_sub5_sub10_sub4 != null) {
                    int i_23_ = ((-class39_sub5_sub10_sub4.anInt2480
                            + class39_sub5_sub15.anInt1925 * 4)
                            / 2);
                    int i_24_ = ((class39_sub5_sub15.anInt1948 * 4
                            - class39_sub5_sub10_sub4.anInt2481)
                            / 2);
                    class39_sub5_sub10_sub4.method695(i_2_ * 4 + 48 + i_23_,
                            ((-i_3_
                            - (class39_sub5_sub15.anInt1948)
                            + 104) * 4
                            + (48 + i_24_)));
                }
            }
        }
    }

    public static JString method972(Widget class39_sub5_sub17,
            int i, JString class3) {
        if ((class3.method80(22938, Class39_Sub5_Sub18.percentJstr)
                ^ 0xffffffff)
                != i) {
            for (;;) {
                int i_25_ = class3.method80(22938, ScriptState.aClass3_443);
                if (i_25_ == -1) {
                    break;
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_25_),
                            (Npc.method521(Class68.getConditionValue(class39_sub5_sub17, 0),
                            999999999)),
                            class3.substring(i_25_ + 2)})));
            }
            for (;;) {
                int i_26_ = class3.method80(22938, Class20.aClass3_389);
                if (i_26_ == -1) {
                    break;
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_26_),
                            (Npc.method521(Class68.getConditionValue(class39_sub5_sub17, 1),
                            999999999)),
                            class3.substring(i_26_ + 2)})));
            }
            for (;;) {
                int i_27_ = class3.method80(22938, Widget.aClass3_2117);
                if (i_27_ == -1) {
                    break;
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_27_),
                            (Npc.method521(Class68.getConditionValue(class39_sub5_sub17, 2),
                            i + 999999999)),
                            class3.substring(i_27_ + 2)})));
            }
            for (;;) {
                int i_28_ = class3.method80(22938, ISAAC.aClass3_1086);
                if (i_28_ == -1) {
                    break;
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_28_),
                            (Npc.method521(Class68.getConditionValue(class39_sub5_sub17, 3),
                            i ^ 0x3b9ac9ff)),
                            class3.substring(i_28_ + 2)})));
            }
            for (;;) {
                int i_29_ = class3.method80(i + 22938, (Npc.aClass3_2494));
                if (i_29_ == -1) {
                    break;
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_29_),
                            (Npc.method521(Class68.getConditionValue(class39_sub5_sub17, 4),
                            i ^ 0x3b9ac9ff)),
                            class3.substring(i_29_ + 2)})));
            }
            for (;;) {
                int i_30_ = class3.method80(22938, Class4.aClass3_78);
                if (i_30_ == -1) {
                    break;
                }
                JString class3_31_ = Class66.blankString;
                if (Player.aClass56_2529 != null) {
                    class3_31_ = method975((Player.aClass56_2529.intParam),
                            -79427592);
                    try {
                        if ((Player.aClass56_2529.returnObject)
                                != null) {
                            byte[] is = ((String) (Player.aClass56_2529.returnObject)).getBytes("ISO-8859-1");
                            class3_31_ = HashTable.createJstring(is, 0,
                                    is.length);
                        }
                    } catch (java.io.UnsupportedEncodingException unsupportedencodingexception) {
                        /* empty */
                    }
                }
                class3 = (Class39_Sub5_Sub11.join((new JString[]{class3.substring(0, i_30_),
                            class3_31_, class3.substring(i_30_ + 4)})));
            }
        }
        return class3;
    }

    public static void method973(int i) {
        aClass3_936 = null;
        aClass3_928 = null;
        aBooleanArray934 = null;
    }

    public static void method974(long l, byte i) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
    }

    public static JString method975(int i, int i_32_) {
        if (i_32_ != -79427592) {
            aClass3_928 = null;
        }
        return (Class39_Sub5_Sub11.join(new JString[]{AbstractImage.toJstr(i >> 24 & 0xff),
                    Class39_Sub4.aClass3_1339,
                    AbstractImage.toJstr(i >> 16 & 0xff),
                    Class39_Sub4.aClass3_1339,
                    AbstractImage.toJstr(i >> 8 & 0xff),
                    Class39_Sub4.aClass3_1339,
                    AbstractImage.toJstr(i & 0xff)}));
    }

    public static int method976(int i, int i_33_, byte i_34_) {
        int i_35_ = i * 57 + i_33_;
        i_35_ ^= i_35_ << 13;
        int i_36_ = (i_35_ * (i_35_ * i_35_ * 15731 + 789221) + 1376312589
                & 0x7fffffff);
        return i_36_ >> 19 & 0xff;
    }

    static {
        anInt931 = 0;
    }
}
