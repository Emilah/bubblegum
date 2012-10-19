package com.jagex.od;

import com.jagex.TextConstants;
import com.jagex.io.FileLoader;
import com.jagex.utils.SubNode;

/* Class39_Sub5_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public class OndemandRequest extends SubNode {
    public byte footerSize;
    public static long wroteGatewayTime;
    public static boolean drawFps;
    public FileLoader fileLoader;
    public static int itemClickPositionY;
    public static int anInt1724;
    public int checksum;

    static {
        TextConstants.aClass3_1721 = TextConstants.pleaseCheckMessageCentre;
        TextConstants.aClass3_1714 = null;
        itemClickPositionY = 0;
        drawFps = false;
    }
}
