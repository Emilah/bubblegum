package com.jagex.utils;

import com.jagex.world.entities.player.PlayerApperance;

/* Class46_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class NsTimer extends Timer
{
    public long aLong1569;
    
    public void reset(int i) {
	method938((byte) -113);
	if (i != 0)
	    aLong1569 = 67L;
    }
    
    public void method938(byte i) {
	aLong1569 = System.nanoTime();
	if (i >= -20)
	    method938((byte) 9);
    }
    
    public NsTimer() {
	method938((byte) -82);
    }
    
    public int method939(int i, int i_0_, int i_1_) {
	long l = aLong1569 - System.nanoTime();
	long l_2_ = (long) i_0_ * 1000000L;
	if (i != 4)
	    aLong1569 = 56L;
	int i_3_ = 0;
	if (l_2_ > l)
	    l = l_2_;
	PlayerApperance.sleep(l / 1000000L);
	long l_4_;
	for (l_4_ = System.nanoTime();
	     i_3_ < 10 && (i_3_ < 1 || aLong1569 < l_4_); i_3_++)
	    aLong1569 += (long) i_1_ * 1000000L;
	if (l_4_ > aLong1569)
	    aLong1569 = l_4_;
	return i_3_;
    }
}
