/**
 * Copyright Evelus, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Hadyn Richard (sini@evel.us), July 2012
 */

package com.jagex.script;

import com.jagex.Client;
import com.jagex.awt.events.JMouseListener;
import com.jagex.config.ItemDefinition;
import com.jagex.config.Widget;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.BitmapFont;
import com.jagex.graphics.JImage;
import com.jagex.net.JSocket;
import com.jagex.utils.Cache;
import com.jagex.utils.Deque;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.utils.MsTimer;
import com.jagex.utils.Node;
import com.jagex.utils.Queue;
import com.jagex.world.entities.GroundItem;
import com.jagex.world.entities.Npc;
import com.jagex.world.map.TraversalMap;
import java.util.Date;
import unpackaged.Class1;
import unpackaged.Class12;
import unpackaged.Class2;
import unpackaged.Class26;
import unpackaged.Class30;
import unpackaged.Class34;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub12;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class43;
import unpackaged.Class44;
import unpackaged.Class62_Sub2;
import unpackaged.Class65;
import unpackaged.Class66;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.utils.MouseRecorder;
import unpackaged.TextureLoaderImpl;

/**
 * Evelus Development
 * Created by Hadyn Richard
 */
public class ScriptExecutor {
    public static JString[] strStack = new JString[1000];
    public static int[] intStack = new int[1000];
    public static int[] intVariables;
    public static JString[] strVariables;
    public static int[][] arrays;
    public static ScriptState[] stateStack;
    public static int sp;
    public static int[] globalIntVars = new int[2000];

    public static void executeClientScript(int i, Object[] params, Widget class39_sub5_sub17, int i_18_, int i_19_, Widget class39_sub5_sub17_20_, int i_21_) {
        int scriptId = ((Integer) params[0]).intValue();
        ClientScript currentClientScript = Class1.getClientScript(scriptId);
        if (currentClientScript != null) {
            int intStackPointer = 0;
            int strStackPointer = 0;
            int offset = -1;
            int[] intOperands = currentClientScript.intOperands;
            int[] opcodes = currentClientScript.opcodes;
            int opcode = -1;
            try {
                strVariables = new JString[currentClientScript.amountStrVars];
                intVariables = new int[currentClientScript.amountIntVars];
                int i_28_ = 0;
                int i_29_ = 0;
                for (int i_30_ = 1; params.length > i_30_; i_30_++) {
                    if (!(params[i_30_] instanceof Integer)) {
                        if (params[i_30_] instanceof JString) {
                            strVariables[i_29_++] = (JString) params[i_30_];
                        }
                    } else {
                        int value = ((Integer) params[i_30_]).intValue();
                        if (value == -2147483647) {
                            value = i_19_;
                        }
                        if (value == -2147483646) {
                            value = i_21_;
                        }
                        if (value == -2147483645) {
                            value = (class39_sub5_sub17_20_ == null ? -1 : class39_sub5_sub17_20_.id);
                        }
                        if (value == -2147483644) {
                            value = i;
                        }
                        if (value == -2147483643) {
                            value = (class39_sub5_sub17_20_ == null ? -1 : class39_sub5_sub17_20_.amountChildren);
                        }
                        if (value == -2147483642) {
                            value = (class39_sub5_sub17 != null ? class39_sub5_sub17.id : -1);
                        }
                        if (value == -2147483641) {
                            value = (class39_sub5_sub17 != null ? class39_sub5_sub17.amountChildren : -1);
                        }
                        intVariables[i_28_++] = value;
                    }
                }
                for (;;) {
                    opcode = opcodes[++offset];
                    if (opcode < 100) {
                        if (opcode == 0) {
                            intStack[intStackPointer++] = intOperands[offset];
                            continue;
                        }
                        if (opcode == 1) {
                            int i_32_ = intOperands[offset];
                            intStack[intStackPointer++] = Client.stateValues[i_32_];
                            continue;
                        }
                        if (opcode == 2) {
                            int id = intOperands[offset];
                            Client.stateValues[id] = intStack[--intStackPointer];
                            continue;
                        }
                        if (opcode == 3) {
                            strStack[strStackPointer++] = currentClientScript.strOperands[offset];
                            continue;
                        }
                        if (opcode == 6) {
                            offset += intOperands[offset];
                            continue;
                        }
                        if (opcode == 7) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer + 1] != intStack[intStackPointer]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 8) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer] == intStack[intStackPointer + 1]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 9) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer] < intStack[intStackPointer + 1]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 10) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer + 1] < intStack[intStackPointer]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 21) {
                            if (sp != 0) {
                                ScriptState scriptState = stateStack[--sp];
                                intVariables = scriptState.intVariables;
                                strVariables = scriptState.strVariables;
                                currentClientScript = scriptState.clientScript;
                                offset = scriptState.offset;
                                intOperands = currentClientScript.intOperands;
                                opcodes = currentClientScript.opcodes;
                                continue;
                            }
                            break;
                        }
                        if (opcode == 25) {
                            int id = intOperands[offset];
                            intStack[intStackPointer++] = Class44.getVarbitValue(id);
                            continue;
                        }
                        if (opcode == 27) {
                            int id = intOperands[offset];
                            Client.setState(intStack[--intStackPointer], id);
                            continue;
                        }
                        if (opcode == 31) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer + 1] >= intStack[intStackPointer]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 32) {
                            intStackPointer -= 2;
                            if (intStack[intStackPointer] >= intStack[intStackPointer + 1]) {
                                offset += intOperands[offset];
                            }
                            continue;
                        }
                        if (opcode == 33) {
                            intStack[intStackPointer++] = intVariables[intOperands[offset]];
                            continue;
                        }
                        if (opcode == 34) {
                            intVariables[intOperands[offset]] = intStack[--intStackPointer];
                            continue;
                        }
                        if (opcode == 35) {
                            strStack[strStackPointer++] = strVariables[intOperands[offset]];
                            continue;
                        }
                        if (opcode == 36) {
                            strVariables[intOperands[offset]] = strStack[--strStackPointer];
                            continue;
                        }
                        if (opcode == 37) {
                            int i_36_ = intOperands[offset];
                            strStackPointer -= i_36_;
                            JString class3 = JString.join(strStack, strStackPointer, i_36_);
                            strStack[strStackPointer++] = class3;
                            continue;
                        }
                        if (opcode == 38) {
                            intStackPointer--;
                            continue;
                        }
                        if (opcode == 39) {
                            strStackPointer--;
                            continue;
                        }
                        if (opcode == 40) {
                            int i_37_ = intOperands[offset];
                            ClientScript clientScript = Class1.getClientScript(i_37_);
                            int[] intVars = new int[clientScript.amountIntVars];
                            JString[] strVars = new JString[clientScript.amountStrVars];
                            for (int i_40_ = 0; i_40_ < clientScript.amountIntParams; i_40_++) {
                                intVars[i_40_] = (intStack[(-clientScript.amountIntParams + (intStackPointer + i_40_))]);
                            }
                            for (int i_41_ = 0; i_41_ < clientScript.amountStrParams; i_41_++) {
                                strVars[i_41_] = (strStack[(strStackPointer - (clientScript.amountStrParams - i_41_))]);
                            }
                            strStackPointer -= clientScript.amountStrParams;
                            intStackPointer -= clientScript.amountIntParams;
                            ScriptState scriptState = new ScriptState();
                            scriptState.offset = offset;
                            offset = -1;
                            scriptState.intVariables = intVariables;
                            scriptState.strVariables = strVariables;
                            scriptState.clientScript = currentClientScript;
                            stateStack[sp++] = scriptState;
                            strVariables = strVars;
                            intVariables = intVars;
                            currentClientScript = clientScript;
                            opcodes = currentClientScript.opcodes;
                            intOperands = currentClientScript.intOperands;
                            continue;
                        }
                        if (opcode == 42) {
                            intStack[intStackPointer++] = globalIntVars[intOperands[offset]];
                            continue;
                        }
                        if (opcode == 43) {
                            globalIntVars[intOperands[offset]] = intStack[--intStackPointer];
                            continue;
                        }
                        if (opcode == 44) {
                            int arrayId = intOperands[offset] >> 16;
                            int initFlag = intOperands[offset] & 65535;
                            int size = intStack[--intStackPointer];
                            if (size < 0 || size > 5000) {
                                throw new RuntimeException();
                            }
                            int initValue = -1;
                            if (initFlag == 'i') {
                                initValue = 0;
                            }
                            ScriptState.arraySizes[arrayId] = size;
                            for (int i_46_ = 0; size > i_46_; i_46_++) {
                                arrays[arrayId][i_46_] = initValue;
                            }
                            continue;
                        }
                        if (opcode == 45) {
                            int arrayId = intOperands[offset];
                            int index = intStack[--intStackPointer];
                            if (index < 0 || index >= ScriptState.arraySizes[arrayId]) {
                                throw new RuntimeException();
                            }
                            intStack[intStackPointer++] = arrays[arrayId][index];
                            continue;
                        }
                        if (opcode == 46) {
                            int i_49_ = intOperands[offset];
                            intStackPointer -= 2;
                            int i_50_ = intStack[intStackPointer];
                            if (i_50_ < 0 || ScriptState.arraySizes[i_49_] <= i_50_) {
                                throw new RuntimeException();
                            }
                            arrays[i_49_][i_50_] = intStack[intStackPointer + 1];
                            continue;
                        }
                    }
                    boolean bool;
                    if (intOperands[offset] != 1) {
                        bool = false;
                    } else {
                        bool = true;
                    }
                    if (opcode >= 1000) {
                        if ((opcode < 1000 || opcode >= 1100) && (opcode < 2000 || opcode >= 2100)) {
                            if ((opcode < 1100 || opcode >= 1200) && (opcode < 2100 || opcode >= 2200)) {
                                if ((opcode < 1200 || opcode >= 1300) && (opcode < 2200 || opcode >= 2300)) {
                                    if (opcode >= 1300 && opcode < 1400 || opcode >= 2300 && opcode < 2400) {
                                        Widget widget;
                                        if (opcode < 2000) {
                                            widget = (!bool ? (Class44.aClass39_Sub5_Sub17_841) : (Class43.aClass39_Sub5_Sub17_810));
                                        } else {
                                            opcode -= 1000;
                                            widget = (Class37.getWidget(intStack[--intStackPointer]));
                                        }
                                        if (opcode == 1300) {
                                            int i_52_ = (intStack[--intStackPointer]) - 1;
                                            if (i_52_ < 0 || i_52_ > 9) {
                                                strStackPointer--;
                                            } else {
                                                widget.method756(1, strStack[--strStackPointer], i_52_);
                                            }
                                        } else if (opcode == 1301) {
                                            intStackPointer -= 2;
                                            int i_53_ = intStack[intStackPointer + 1];
                                            int i_54_ = intStack[intStackPointer];
                                            widget.aClass39_Sub5_Sub17_2040 = (Class62_Sub2.getWidgetChild(i_54_, i_53_));
                                        } else if (opcode == 1302) {
                                            widget.aBoolean2108 = (intStack[--intStackPointer]) == 1;
                                        } else if (opcode == 1303) {
                                            widget.anInt2056 = (intStack[--intStackPointer]);
                                        } else if (opcode == 1304) {
                                            widget.anInt2008 = (intStack[--intStackPointer]);
                                        } else if (opcode == 1305) {
                                            widget.aClass3_2065 = (strStack[--strStackPointer]);
                                        } else {
                                            if (opcode != 1306) {
                                                break;
                                            }
                                            widget.use = (strStack[--strStackPointer]);
                                        }
                                    } else if ((opcode < 1400 || opcode >= 1500) && (opcode < 2400 || opcode >= 2500)) {
                                        if (opcode >= 1600) {
                                            if (opcode < 1700) {
                                                Widget class39_sub5_sub17_55_ = !bool ? (Class44.aClass39_Sub5_Sub17_841) : (Class43.aClass39_Sub5_Sub17_810);
                                                if (opcode == 1600) {
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_55_.scrollX);
                                                } else if (opcode == 1601) {
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_55_.scrollY);
                                                } else if (opcode == 1602) {
                                                    strStack[strStackPointer++] = (class39_sub5_sub17_55_.inactiveText);
                                                } else if (opcode == 1603) {
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_55_.anInt2020);
                                                } else {
                                                    if (opcode != 1604) {
                                                        break;
                                                    }
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_55_.anInt2095);
                                                }
                                            } else if (opcode < 1800) {
                                                Widget class39_sub5_sub17_56_ = bool ? (Class43.aClass39_Sub5_Sub17_810) : (Class44.aClass39_Sub5_Sub17_841);
                                                if (opcode == 1700) {
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_56_.anInt1997);
                                                } else if (opcode == 1701) {
                                                    if ((class39_sub5_sub17_56_.anInt1997) == -1) {
                                                        intStack[intStackPointer++] = 0;
                                                    } else {
                                                        intStack[intStackPointer++] = (class39_sub5_sub17_56_.anInt2096);
                                                    }
                                                } else {
                                                    if (opcode != 1702) {
                                                        break;
                                                    }
                                                    intStack[intStackPointer++] = (class39_sub5_sub17_56_.amountChildren);
                                                }
                                            } else if (opcode >= 2600) {
                                                if (opcode >= 2700) {
                                                    if (opcode < 2800) {
                                                        Widget class39_sub5_sub17_57_ = Class37.getWidget(intStack[--intStackPointer]);
                                                        if (opcode == 2700) {
                                                            intStack[intStackPointer++] = (class39_sub5_sub17_57_.anInt1997);
                                                        } else {
                                                            if (opcode != 2701) {
                                                                break;
                                                            }
                                                            if ((class39_sub5_sub17_57_.anInt1997) != -1) {
                                                                intStack[intStackPointer++] = (class39_sub5_sub17_57_.anInt2096);
                                                            } else {
                                                                intStack[intStackPointer++] = 0;
                                                            }
                                                        }
                                                    } else if (opcode >= 3200) {
                                                        if (opcode >= 3300) {
                                                            if (opcode < 3400) {
                                                                if (opcode == 3300) {
                                                                    intStack[intStackPointer++] = (Class2.logicCycle);
                                                                } else if (opcode == 3301) {
                                                                    intStackPointer -= 2;
                                                                    int i_58_ = intStack[intStackPointer];
                                                                    int i_59_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (StillObject.getItemId(i_58_, i_59_));
                                                                } else if (opcode == 3302) {
                                                                    intStackPointer -= 2;
                                                                    int i_60_ = intStack[intStackPointer];
                                                                    int i_61_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (JImage.getItemAmount(i_60_, i_61_));
                                                                } else if (opcode == 3303) {
                                                                    intStackPointer -= 2;
                                                                    int i_62_ = intStack[(intStackPointer + 1)];
                                                                    int i_63_ = intStack[intStackPointer];
                                                                    intStack[intStackPointer++] = (GroundItem.getItemAmount(i_63_, i_62_));
                                                                } else if (opcode == 3304) {
                                                                    int i_64_ = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (Class65.method1098((byte) 102, i_64_).anInt1746);
                                                                } else if (opcode == 3305) {
                                                                    int id = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (MouseRecorder.dynamicLevels[id]);
                                                                } else {
                                                                    if (opcode != 3306) {
                                                                        break;
                                                                    }
                                                                    int id = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (Class39_Sub12.staticLevels[id]);
                                                                }
                                                            } else if (opcode < 4100) {
                                                                if (opcode == 4000) {
                                                                    intStackPointer -= 2;
                                                                    int i_67_ = intStack[intStackPointer];
                                                                    int i_68_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (i_68_ + i_67_);
                                                                } else if (opcode == 4001) {
                                                                    intStackPointer -= 2;
                                                                    int i_69_ = intStack[intStackPointer];
                                                                    int i_70_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (i_69_ - i_70_);
                                                                } else if (opcode == 4002) {
                                                                    intStackPointer -= 2;
                                                                    int i_71_ = intStack[intStackPointer];
                                                                    int i_72_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (i_72_ * i_71_);
                                                                } else if (opcode == 4003) {
                                                                    intStackPointer -= 2;
                                                                    int i_73_ = intStack[intStackPointer];
                                                                    int i_74_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (i_73_ / i_74_);
                                                                } else if (opcode == 4004) {
                                                                    int amount = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (int) (Math.random() * (double) amount);
                                                                } else if (opcode == 4005) {
                                                                    int amount = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (int) (Math.random() * (double) (amount + 1));
                                                                } else if (opcode == 4006) {
                                                                    intStackPointer -= 5;
                                                                    int i_77_ = intStack[intStackPointer];
                                                                    int i_78_ = intStack[(intStackPointer + 2)];
                                                                    int i_79_ = intStack[(intStackPointer + 1)];
                                                                    int i_80_ = intStack[(intStackPointer + 3)];
                                                                    int i_81_ = intStack[(intStackPointer + 4)];
                                                                    intStack[intStackPointer++] = (i_77_ + ((i_79_ - i_77_) * (-i_78_ + i_81_) / (-i_78_ + i_80_)));
                                                                } else if (opcode == 4007) {
                                                                    intStackPointer -= 2;
                                                                    int i_82_ = intStack[intStackPointer];
                                                                    int i_83_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (i_82_ + (i_83_ * i_82_ / 100));
                                                                } else if (opcode == 4008) {
                                                                    intStackPointer -= 2;
                                                                    int i_84_ = intStack[intStackPointer];
                                                                    int i_85_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (Queue.or(1 << i_85_, i_84_));
                                                                } else if (opcode == 4009) {
                                                                    intStackPointer -= 2;
                                                                    int i_86_ = intStack[intStackPointer];
                                                                    int i_87_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (Class34.and(-(1 << i_87_) - 1, i_86_));
                                                                } else if (opcode == 4010) {
                                                                    intStackPointer -= 2;
                                                                    int i_88_ = intStack[(intStackPointer + 1)];
                                                                    int i_89_ = intStack[intStackPointer];
                                                                    intStack[intStackPointer++] = ((Class34.and(i_89_, 1 << i_88_)) != 0 ? 1 : 0);
                                                                } else if (opcode == 4011) {
                                                                    intStackPointer -= 2;
                                                                    int i_90_ = intStack[(intStackPointer + 1)];
                                                                    int i_91_ = intStack[intStackPointer];
                                                                    intStack[intStackPointer++] = (i_91_ % i_90_);
                                                                } else if (opcode == 4012) {
                                                                    intStackPointer -= 2;
                                                                    int i_92_ = intStack[(intStackPointer + 1)];
                                                                    int i_93_ = intStack[intStackPointer];
                                                                    if (i_93_ != 0) {
                                                                        intStack[intStackPointer++] = (int) Math.pow((double) i_93_, (double) i_92_);
                                                                    } else {
                                                                        intStack[intStackPointer++] = 0;
                                                                    }
                                                                } else if (opcode == 4013) {
                                                                    intStackPointer -= 2;
                                                                    int i_94_ = intStack[intStackPointer];
                                                                    int i_95_ = intStack[(intStackPointer + 1)];
                                                                    if (i_94_ == 0) {
                                                                        intStack[intStackPointer++] = 0;
                                                                    } else if (i_95_ == 0) {
                                                                        intStack[intStackPointer++] = 2147483647;
                                                                    } else {
                                                                        intStack[intStackPointer++] = (int) Math.pow((double) i_94_, 1.0 / (double) i_95_);
                                                                    }
                                                                } else if (opcode == 4014) {
                                                                    intStackPointer -= 2;
                                                                    int i_96_ = intStack[(intStackPointer + 1)];
                                                                    int i_97_ = intStack[intStackPointer];
                                                                    intStack[intStackPointer++] = (Class34.and(i_96_, i_97_));
                                                                } else {
                                                                    if (opcode != 4015) {
                                                                        break;
                                                                    }
                                                                    intStackPointer -= 2;
                                                                    int i_98_ = intStack[intStackPointer];
                                                                    int i_99_ = intStack[(intStackPointer + 1)];
                                                                    intStack[intStackPointer++] = (Queue.or(i_98_, i_99_));
                                                                }
                                                            } else if (opcode >= 4200) {
                                                                if (opcode >= 4300) {
                                                                    break;
                                                                }
                                                                if (opcode == 4200) {
                                                                    int id = intStack[--intStackPointer];
                                                                    strStack[strStackPointer++] = (Class26.getItemDefinition(id).name);
                                                                } else if (opcode == 4201) {
                                                                    intStackPointer -= 2;
                                                                    int i_101_ = intStack[intStackPointer];
                                                                    int i_102_ = intStack[(intStackPointer + 1)];
                                                                    ItemDefinition class39_sub5_sub1 = Class26.getItemDefinition(i_101_);
                                                                    if ((i_102_ >= 1) && (i_102_ <= 5) && (class39_sub5_sub1.groundOptions[i_102_ - 1]) != null) {
                                                                        strStack[strStackPointer++] = class39_sub5_sub1.groundOptions[i_102_ - 1];
                                                                    } else {
                                                                        strStack[strStackPointer++] = Class39_Sub12.aClass3_1492;
                                                                    }
                                                                } else if (opcode == 4202) {
                                                                    intStackPointer -= 2;
                                                                    int i_103_ = intStack[intStackPointer];
                                                                    int i_104_ = intStack[(intStackPointer + 1)];
                                                                    ItemDefinition class39_sub5_sub1 = Class26.getItemDefinition(i_103_);
                                                                    if ((i_104_ < 1) || (i_104_ > 5) || (class39_sub5_sub1.widgetOptions[i_104_ - 1]) == null) {
                                                                        strStack[strStackPointer++] = Class39_Sub12.aClass3_1492;
                                                                    } else {
                                                                        strStack[strStackPointer++] = class39_sub5_sub1.widgetOptions[i_104_ - 1];
                                                                    }
                                                                } else if (opcode == 4203) {
                                                                    int i_105_ = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = (Class26.getItemDefinition(i_105_).anInt1686);
                                                                } else if (opcode == 4204) {
                                                                    int i_106_ = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = ((Class26.getItemDefinition(i_106_).anInt1662) == 1 ? 1 : 0);
                                                                } else if (opcode == 4205) {
                                                                    int i_107_ = intStack[--intStackPointer];
                                                                    ItemDefinition class39_sub5_sub1 = Class26.getItemDefinition(i_107_);
                                                                    if (((class39_sub5_sub1.anInt1644) == -1) && (class39_sub5_sub1.anInt1651 >= 0)) {
                                                                        intStack[intStackPointer++] = class39_sub5_sub1.anInt1651;
                                                                    } else {
                                                                        intStack[intStackPointer++] = i_107_;
                                                                    }
                                                                } else if (opcode == 4206) {
                                                                    int i_108_ = intStack[--intStackPointer];
                                                                    ItemDefinition class39_sub5_sub1 = Class26.getItemDefinition(i_108_);
                                                                    if (((class39_sub5_sub1.anInt1644) >= 0) && (class39_sub5_sub1.anInt1651 >= 0)) {
                                                                        intStack[intStackPointer++] = class39_sub5_sub1.anInt1651;
                                                                    } else {
                                                                        intStack[intStackPointer++] = i_108_;
                                                                    }
                                                                } else {
                                                                    if (opcode != 4207) {
                                                                        break;
                                                                    }
                                                                    int i_109_ = intStack[--intStackPointer];
                                                                    intStack[intStackPointer++] = ((Class26.getItemDefinition(i_109_).aBoolean1653) ? 1 : 0);
                                                                }
                                                            } else if (opcode == 4100) {
                                                                JString class3 = strStack[--strStackPointer];
                                                                int i_110_ = intStack[--intStackPointer];
                                                                strStack[strStackPointer++] = (Class39_Sub5_Sub11.join(new JString[]{class3, AbstractImage.toJstr(i_110_)}));
                                                            } else if (opcode == 4101) {
                                                                strStackPointer -= 2;
                                                                JString class3 = strStack[strStackPointer];
                                                                JString class3_111_ = strStack[(strStackPointer + 1)];
                                                                strStack[strStackPointer++] = (Class39_Sub5_Sub11.join(new JString[]{class3, class3_111_}));
                                                            } else if (opcode == 4102) {
                                                                JString class3 = strStack[--strStackPointer];
                                                                int i_112_ = intStack[--intStackPointer];
                                                                strStack[strStackPointer++] = (Class39_Sub5_Sub11.join(new JString[]{class3, Npc.method519(10, true, i_112_)}));
                                                            } else if (opcode == 4103) {
                                                                JString class3 = strStack[--strStackPointer];
                                                                strStack[strStackPointer++] = (class3.method77());
                                                            } else if (opcode == 4104) {
                                                                int i_113_ = intStack[--intStackPointer];
                                                                long l = ((long) i_113_ + 11745L) * 86400000L;
                                                                JMouseListener.aCalendar786.setTime(new Date(l));
                                                                int i_114_ = JMouseListener.aCalendar786.get(5);
                                                                int i_115_ = JMouseListener.aCalendar786.get(2);
                                                                int i_116_ = JMouseListener.aCalendar786.get(1);
                                                                strStack[strStackPointer++] = (Class39_Sub5_Sub11.join(new JString[]{AbstractImage.toJstr(i_114_), Class12.aClass3_191, Class43.aClass3Array808[i_115_], Class12.aClass3_191, AbstractImage.toJstr(i_116_)}));
                                                            } else if (opcode == 4105) {
                                                                strStackPointer -= 2;
                                                                JString class3 = strStack[strStackPointer];
                                                                JString class3_117_ = strStack[(strStackPointer + 1)];
                                                                if (((Cache.localPlayer.aClass45_2516) == null) || !(Cache.localPlayer.aClass45_2516.isMale)) {
                                                                    strStack[strStackPointer++] = class3;
                                                                } else {
                                                                    strStack[strStackPointer++] = class3_117_;
                                                                }
                                                            } else if (opcode == 4106) {
                                                                int i_118_ = intStack[--intStackPointer];
                                                                strStack[strStackPointer++] = (AbstractImage.toJstr(i_118_));
                                                            } else if (opcode == 4107) {
                                                                strStackPointer -= 2;
                                                                intStack[intStackPointer++] = (strStack[strStackPointer].method96(10445, strStack[(strStackPointer + 1)]));
                                                            } else if (opcode == 4108) {
                                                                intStackPointer -= 2;
                                                                int i_119_ = intStack[(intStackPointer + 1)];
                                                                int i_120_ = intStack[intStackPointer];
                                                                JString class3 = strStack[--strStackPointer];
                                                                byte[] is_121_ = TextureLoaderImpl.fileLoader13.lookupFile(i_119_, 0);
                                                                BitmapFont class39_sub5_sub10_sub1 = new BitmapFont(is_121_);
                                                                intStack[intStackPointer++] = (class39_sub5_sub10_sub1.method634(class3, i_120_));
                                                            } else {
                                                                if (opcode != 4109) {
                                                                    break;
                                                                }
                                                                intStackPointer -= 2;
                                                                JString class3 = strStack[--strStackPointer];
                                                                int i_122_ = intStack[intStackPointer];
                                                                int i_123_ = intStack[(intStackPointer + 1)];
                                                                byte[] is_124_ = TextureLoaderImpl.fileLoader13.lookupFile(i_123_, 0);
                                                                BitmapFont class39_sub5_sub10_sub1 = new BitmapFont(is_124_);
                                                                intStack[intStackPointer++] = (class39_sub5_sub10_sub1.method631(class3, i_122_));
                                                            }
                                                        } else if (opcode == 3200) {
                                                            intStackPointer -= 3;
                                                            TraversalMap.queueSoundEffect(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2]);
                                                        } else if (opcode == 3201) {
                                                            PlayerApperance.method916(intStack[--intStackPointer], -44);
                                                        } else {
                                                            if (opcode != 3202) {
                                                                break;
                                                            }
                                                            intStackPointer -= 2;
                                                            Class37.method351(intStack[intStackPointer + 1], intStack[intStackPointer]);
                                                        }
                                                    } else if (opcode == 3100) {
                                                        JString class3 = strStack[--strStackPointer];
                                                        JMouseListener.printMessage(0, Class39_Sub12.aClass3_1492, class3);
                                                    } else if (opcode == 3101) {
                                                        intStackPointer -= 2;
                                                        MsTimer.method944(Cache.localPlayer, intStack[intStackPointer], -12, intStack[intStackPointer + 1]);
                                                    } else if (opcode == 3102) {
                                                        int i_125_ = intStack[--intStackPointer];
                                                        if (i_125_ >= 0 && (i_125_ < (Class39_Sub5_Sub14.tabWidgetIds).length) && ((Class39_Sub5_Sub14.tabWidgetIds[i_125_]) != -1)) {
                                                            ISAAC.aBoolean1089 = true;
                                                            Class39_Sub14.updateTab = true;
                                                            Node.currentTabId = i_125_;
                                                        }
                                                    } else {
                                                        if (opcode != 3103) {
                                                            break;
                                                        }
                                                        TextureLoaderImpl.closeOverlays();
                                                    }
                                                } else {
                                                    Widget class39_sub5_sub17_126_ = Class37.getWidget(intStack[--intStackPointer]);
                                                    if (opcode == 2600) {
                                                        intStack[intStackPointer++] = (class39_sub5_sub17_126_.scrollX);
                                                    } else if (opcode == 2601) {
                                                        intStack[intStackPointer++] = (class39_sub5_sub17_126_.scrollY);
                                                    } else if (opcode == 2602) {
                                                        strStack[strStackPointer++] = (class39_sub5_sub17_126_.inactiveText);
                                                    } else if (opcode == 2603) {
                                                        intStack[intStackPointer++] = (class39_sub5_sub17_126_.anInt2020);
                                                    } else {
                                                        if (opcode != 2604) {
                                                            break;
                                                        }
                                                        intStack[intStackPointer++] = (class39_sub5_sub17_126_.anInt2095);
                                                    }
                                                }
                                            } else {
                                                Widget widget = Class37.getWidget(intStack[--intStackPointer]);
                                                if (opcode == 2500) {
                                                    intStack[intStackPointer++] = (widget.displayOffsetX);
                                                } else if (opcode == 2501) {
                                                    intStack[intStackPointer++] = (widget.displayOffsetY);
                                                } else if (opcode == 2502) {
                                                    intStack[intStackPointer++] = (widget.width);
                                                } else if (opcode == 2503) {
                                                    intStack[intStackPointer++] = (widget.height);
                                                } else if (opcode == 2504) {
                                                    intStack[intStackPointer++] = (!(widget.aBoolean2055) ? 0 : 1);
                                                } else {
                                                    if (opcode != 2505) {
                                                        break;
                                                    }
                                                    intStack[intStackPointer++] = (widget.anInt2050);
                                                }
                                            }
                                        } else {
                                            Widget widget = !bool ? (Class44.aClass39_Sub5_Sub17_841) : (Class43.aClass39_Sub5_Sub17_810);
                                            if (opcode == 1500) {
                                                intStack[intStackPointer++] = (widget.displayOffsetX);
                                            } else if (opcode == 1501) {
                                                intStack[intStackPointer++] = (widget.displayOffsetY);
                                            } else if (opcode == 1502) {
                                                intStack[intStackPointer++] = (widget.width);
                                            } else if (opcode == 1503) {
                                                intStack[intStackPointer++] = (widget.height);
                                            } else if (opcode == 1504) {
                                                intStack[intStackPointer++] = (widget.aBoolean2055) ? 1 : 0;
                                            } else {
                                                if (opcode != 1505) {
                                                    break;
                                                }
                                                intStack[intStackPointer++] = (widget.anInt2050);
                                            }
                                        }
                                    } else {
                                        Widget widget;
                                        if (opcode >= 2000) {
                                            widget = (Class37.getWidget(intStack[--intStackPointer]));
                                            opcode -= 1000;
                                        } else {
                                            widget = (!bool ? (Class44.aClass39_Sub5_Sub17_841) : (Class43.aClass39_Sub5_Sub17_810));
                                        }
                                        JString paramStr = strStack[--strStackPointer];
                                        Object[] scriptParams = new Object[paramStr.getLength() + 1];
                                        for (int j = scriptParams.length - 1; j >= 1; j--) {
                                            if (paramStr.charAt(j - 1) == 115) {
                                                scriptParams[j] = (strStack[--strStackPointer]);
                                            } else {
                                                scriptParams[j] = (new Integer(intStack[--intStackPointer]));
                                            }
                                        }
                                        scriptParams[0] = new Integer(intStack[--intStackPointer]);
                                        if (opcode == 1406) {
                                            widget.anObjectArray2004 = scriptParams;
                                        }
                                        if (opcode == 1412) {
                                            widget.anObjectArray2075 = scriptParams;
                                        }
                                        if (opcode == 1416) {
                                            widget.anObjectArray2099 = scriptParams;
                                        }
                                        if (opcode == 1408) {
                                            widget.anObjectArray2016 = scriptParams;
                                        }
                                        if (opcode == 1400) {
                                            widget.anObjectArray2035 = scriptParams;
                                        }
                                        if (opcode == 1411) {
                                            widget.anObjectArray2044 = scriptParams;
                                        }
                                        if (opcode == 1401) {
                                            widget.anObjectArray2080 = scriptParams;
                                        }
                                        if (opcode == 1403) {
                                            widget.anObjectArray2019 = scriptParams;
                                        }
                                        if (opcode == 1414) {
                                            widget.anObjectArray2061 = scriptParams;
                                        }
                                        if (opcode == 1410) {
                                            widget.anObjectArray2088 = scriptParams;
                                        }
                                        if (opcode == 1404) {
                                            widget.anObjectArray2100 = scriptParams;
                                        }
                                        if (opcode == 1415) {
                                            widget.anObjectArray2062 = scriptParams;
                                        }
                                        if (opcode == 1417) {
                                            widget.anObjectArray2039 = scriptParams;
                                        }
                                        if (opcode == 1405) {
                                            widget.anObjectArray2018 = scriptParams;
                                        }
                                        widget.aBoolean2047 = true;
                                        if (opcode == 1413) {
                                            widget.anObjectArray2097 = scriptParams;
                                        }
                                        if (opcode == 1407) {
                                            widget.anObjectArray2101 = scriptParams;
                                        }
                                        if (opcode == 1402) {
                                            widget.anObjectArray2085 = scriptParams;
                                        }
                                        if (opcode == 1409) {
                                            widget.anObjectArray2045 = scriptParams;
                                        }
                                    }
                                } else {
                                    Widget widget;
                                    if (opcode < 2000) {
                                        widget = (bool ? (Class43.aClass39_Sub5_Sub17_810) : (Class44.aClass39_Sub5_Sub17_841));
                                    } else {
                                        widget = (Class37.getWidget(intStack[--intStackPointer]));
                                        opcode -= 1000;
                                    }
                                    Deque.method967(widget, (byte) -22);
                                    if (opcode == 1200) {
                                        intStackPointer -= 2;
                                        int i_133_ = intStack[intStackPointer];
                                        int i_134_ = intStack[intStackPointer + 1];
                                        widget.anInt1997 = i_133_;
                                        widget.anInt2096 = i_134_;
                                    } else if (opcode == 1201) {
                                        widget.inactiveModelType = 2;
                                        widget.inactiveAnimationModelId = (intStack[--intStackPointer]);
                                    } else {
                                        if (opcode != 1202) {
                                            break;
                                        }
                                        widget.inactiveModelType = 3;
                                        widget.inactiveAnimationModelId = Cache.localPlayer.aClass45_2516.method928(124);
                                    }
                                }
                            } else {
                                Widget widget;
                                if (opcode < 2000) {
                                    widget = (!bool ? Class44.aClass39_Sub5_Sub17_841 : Class43.aClass39_Sub5_Sub17_810);
                                } else {
                                    opcode -= 1000;
                                    widget = Class37.getWidget(intStack[--intStackPointer]);
                                }
                                Deque.method967(widget, (byte) -22);
                                if (opcode == 1100) {
                                    intStackPointer -= 2;
                                    widget.scrollX = intStack[intStackPointer];
                                    widget.scrollY = (intStack[intStackPointer + 1]);
                                } else if (opcode == 1101) {
                                    widget.inactiveColor = intStack[--intStackPointer];
                                } else if (opcode == 1102) {
                                    widget.drawSolidQuad = (intStack[--intStackPointer] == 1);
                                } else if (opcode == 1103) {
                                    widget.alpha = intStack[--intStackPointer];
                                } else if (opcode == 1104) {
                                    widget.anInt2083 = intStack[--intStackPointer];
                                } else if (opcode == 1105) {
                                    widget.unactiveSpriteId = intStack[--intStackPointer];
                                } else if (opcode == 1106) {
                                    widget.anInt2051 = intStack[--intStackPointer];
                                } else if (opcode == 1107) {
                                    widget.aBoolean2014 = (intStack[--intStackPointer] == 1);
                                } else if (opcode == 1108) {
                                    widget.inactiveModelType = 1;
                                    widget.inactiveAnimationModelId = intStack[--intStackPointer];
                                } else if (opcode == 1109) {
                                    intStackPointer -= 6;
                                    widget.anInt2072 = intStack[intStackPointer];
                                    widget.anInt2058 = (intStack[intStackPointer + 1]);
                                    widget.modelCosineRotationX = (intStack[intStackPointer + 2]);
                                    widget.modelSineRotationX = (intStack[intStackPointer + 3]);
                                    widget.anInt2007 = (intStack[intStackPointer + 4]);
                                    widget.modelRotationY = (intStack[intStackPointer + 5]);
                                } else if (opcode == 1110) {
                                    widget.anInt2103 = intStack[--intStackPointer];
                                } else if (opcode == 1111) {
                                    widget.aBoolean2081 = (intStack[--intStackPointer] == 1);
                                } else if (opcode == 1112) {
                                    widget.inactiveText = (strStack[--strStackPointer]);
                                } else if (opcode == 1113) {
                                    widget.fontId = intStack[--intStackPointer];
                                } else if (opcode == 1114) {
                                    intStackPointer -= 3;
                                    widget.anInt2032 = intStack[intStackPointer];
                                    widget.anInt1996 = (intStack[intStackPointer + 1]);
                                    widget.anInt2036 = (intStack[intStackPointer + 2]);
                                } else if (opcode == 1115) {
                                    widget.drawShadow = (intStack[--intStackPointer] == 1);
                                } else if (opcode == 1116) {
                                    widget.anInt2022 = intStack[--intStackPointer];
                                } else if (opcode == 1117) {
                                    widget.anInt2003 = intStack[--intStackPointer];
                                } else if (opcode == 1118) {
                                    widget.invertVertical = (intStack[--intStackPointer] == 1);
                                } else if (opcode == 1119) {
                                    widget.invertHorizontal = (intStack[--intStackPointer] == 1);
                                } else {
                                    if (opcode != 1120) {
                                        break;
                                    }
                                    intStackPointer -= 2;
                                    widget.anInt2020 = intStack[intStackPointer];
                                    widget.anInt2095 = (intStack[intStackPointer + 1]);
                                }
                            }
                        } else {
                            Widget widget;
                            if (opcode < 2000) {
                                widget = (bool ? Class43.aClass39_Sub5_Sub17_810 : Class44.aClass39_Sub5_Sub17_841);
                            } else {
                                opcode -= 1000;
                                widget = Class37.getWidget(intStack[--intStackPointer]);
                            }
                            Deque.method967(widget, (byte) -22);
                            if (opcode == 1000) {
                                intStackPointer -= 2;
                                widget.displayOffsetX = intStack[intStackPointer];
                                widget.displayOffsetY = intStack[intStackPointer + 1];
                            } else if (opcode == 1001) {
                                intStackPointer -= 2;
                                widget.width = intStack[intStackPointer];
                                widget.height = intStack[intStackPointer + 1];
                            } else {
                                if (opcode != 1003) {
                                    break;
                                }
                                widget.aBoolean2055 = (intStack[--intStackPointer] == 1);
                            }
                        }
                    } else if (opcode == 100) {
                        intStackPointer -= 3;
                        int type = intStack[intStackPointer + 1];
                        int parent = intStack[intStackPointer];
                        int amountChildren = intStack[intStackPointer + 2];
                        if (type == 0) {
                            throw new RuntimeException();
                        }
                        Widget parentWidget = Class37.getWidget(parent);
                        if ((parentWidget.children) == null) {
                            parentWidget.children = new Widget[amountChildren + 1];
                        }
                        if ((parentWidget.children).length <= amountChildren) {
                            Widget[] class39_sub5_sub17s = new Widget[amountChildren + 1];
                            for (int i_141_ = 0; (parentWidget.children).length > i_141_; i_141_++) {
                                class39_sub5_sub17s[i_141_] = (parentWidget.children[i_141_]);
                            }
                            parentWidget.children = class39_sub5_sub17s;
                        }
                        Widget class39_sub5_sub17_142_ = new Widget();
                        class39_sub5_sub17_142_.anInt2050 = class39_sub5_sub17_142_.id = parentWidget.id;
                        class39_sub5_sub17_142_.isNewFormat = true;
                        class39_sub5_sub17_142_.amountChildren = amountChildren;
                        class39_sub5_sub17_142_.type = type;
                        parentWidget.children[amountChildren] = class39_sub5_sub17_142_;
                        if (bool) {
                            Class43.aClass39_Sub5_Sub17_810 = class39_sub5_sub17_142_;
                        } else {
                            Class44.aClass39_Sub5_Sub17_841 = class39_sub5_sub17_142_;
                        }
                        Deque.method967(parentWidget, (byte) -22);
                    } else if (opcode == 101) {
                        Widget class39_sub5_sub17_143_ = !bool ? Class44.aClass39_Sub5_Sub17_841 : Class43.aClass39_Sub5_Sub17_810;
                        Widget widget = Class37.getWidget(class39_sub5_sub17_143_.id);
                        widget.children[class39_sub5_sub17_143_.amountChildren] = null;
                        Deque.method967(widget, (byte) -22);
                    } else if (opcode == 102) {
                        Widget widget = Class37.getWidget(intStack[--intStackPointer]);
                        widget.children = null;
                        Deque.method967(widget, (byte) -22);
                    } else {
                        if (opcode != 200) {
                            break;
                        }
                        intStackPointer -= 2;
                        int parent = intStack[intStackPointer];
                        int child = intStack[intStackPointer + 1];
                        Widget widget = Class62_Sub2.getWidgetChild(parent, child);
                        if (widget == null || child == -1) {
                            intStack[intStackPointer++] = 0;
                        } else {
                            intStack[intStackPointer++] = 1;
                            if (!bool) {
                                Class44.aClass39_Sub5_Sub17_841 = widget;
                            } else {
                                Class43.aClass39_Sub5_Sub17_810 = widget;
                            }
                        }
                    }
                }
            } catch (Exception exception) {
                ClassCheckRequest.method849(exception, 64, "CS2 - scr:" + currentClientScript.hash + " op:" + opcode);
            }
        }
    }

}
