package com.jagex.utils;

import com.jagex.utils.Node;
import com.jagex.utils.JString;
import com.jagex.utils.Deque;
import com.jagex.io.FrameBuffer;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class39_Sub14;
import com.jagex.world.Mob;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.io.AbstractFileLoader;
import com.jagex.od.OndemandHandler;

/* Class19 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class HashTable
{
    public Node iterator;
    public static JString aClass3_356;
    public static byte[] buffer = new byte[520];
    public int size;
    public static JString aClass3_359;
    public long lastFetchedHash;
    public static boolean aBoolean361 = false;
    public Node[] nodes;
    public static int anInt363;
    public Node lastLookup;
    public static Deque aClass49_365;
    public int lookupPosition = 0;
    public static boolean members = false;
    public static JString yelPrefixJstr;
    public static AbstractFileLoader aClass9_369;
    public static int languageId;
    public static JString aClass3_372;
    public static JString aClass3_373;
    public static JString aClass3_374;
    public static JString aClass3_375;
    public static JString aClass3_376;
    public static int[] anIntArray377;
    public static JString aClass3_378;
    public static JString aClass3_379;
    public static JString aClass3_380;
    public static long aLong381;
    public static JString aClass3_382;
    public static JString selectJstr;
    public static JString aClass3_384;
    public static JString aClass3_385;
    public static JString aClass3_386;
    
    public static void removeIgnore(long l) {
	if (l != 0L) {
	    for (int i_0_ = 0; Class15.amountIgnores > i_0_; i_0_++) {
		if (Class39_Sub5_Sub9.ignoreUsernames[i_0_] == l) {
		    Class39_Sub14.updateTab = true;
		    Class15.amountIgnores--;
		    for (int i_1_ = i_0_; i_1_ < Class15.amountIgnores; i_1_++)
			Class39_Sub5_Sub9.ignoreUsernames[i_1_]
			    = Class39_Sub5_Sub9.ignoreUsernames[i_1_ + 1];
		    FrameBuffer.outgoingBuffer
			.putFrame(250);
		    FrameBuffer.outgoingBuffer.putInt64(l);
		    break;
		}
	    }
	}
    }
    
    public void put(long hash, Node node) {
	if (node.prevNode != null)
	    node.unlinkDeque();
	Node head = nodes[(int) (hash & (long) (size - 1))];
	node.prevNode = head.prevNode;
	node.nextNode = head;
	node.prevNode.nextNode = node;
	node.nextNode.prevNode = node;
	node.hash = hash;
    }
    
    public Node quickLookup() {
	lookupPosition = 0;
	return lookup();
    }
    
    public static JString createJstring(byte[] src, int off, int len) {
	JString jstr = new JString();
	jstr.length = 0;
	jstr.bytes = new byte[len];
	for (int i = off; off + len > i; i++) {
	    if (src[i] != 0)
		jstr.bytes[jstr.length++] = src[i];
	}
	return jstr;
    }
    
    public Node lookup() {
	if (lookupPosition > 0 && nodes[lookupPosition - 1] != lastLookup) {
	    Node node = lastLookup;
	    lastLookup = node.nextNode;
	    return node;
	}
	while (size > lookupPosition) {
	    Node node = nodes[lookupPosition++].nextNode;
	    if (node != nodes[lookupPosition - 1]) {
		lastLookup = node.nextNode;
		return node;
	    }
	}
	return null;
    }
    
    public HashTable(int i) {
	size = i;
	nodes = new Node[i];
	for (int i_6_ = 0; i_6_ < i; i_6_++) {
	    Node node = nodes[i_6_] = new Node();
	    node.prevNode = node;
	    node.nextNode = node;
	}
    }
    
    public Node lookupLast() {
	if (iterator == null)
	    return null;
	for (Node head = nodes[(int) (lastFetchedHash & (long) (size - 1))]; head != iterator; iterator = iterator.nextNode) {
	    if (lastFetchedHash == iterator.hash) {
		Node node = iterator;
		iterator = iterator.nextNode;
		return node;
	    }
	}
	iterator = null;
	return null;
    }
    
    public static void method243(int i) {
	aClass49_365 = null;
	aClass9_369 = null;
	anIntArray377 = null;
	aClass3_380 = null;
	aClass3_386 = null;
	aClass3_356 = null;
	aClass3_378 = null;
	aClass3_384 = null;
	aClass3_374 = null;
	aClass3_385 = null;
	OndemandHandler.pendingRegularRequests = null;
	aClass3_379 = null;
	aClass3_372 = null;
	aClass3_382 = null;
	buffer = null;
	aClass3_376 = null;
	yelPrefixJstr = null;
	aClass3_375 = null;
	selectJstr = null;
	aClass3_373 = null;
	aClass3_359 = null;
    }
    
    public static void method244(Mob class39_sub5_sub4_sub4,
				 boolean bool) {
	class39_sub5_sub4_sub4.anInt2274 = 0;
	if (class39_sub5_sub4_sub4.anInt2292 == 0)
	    class39_sub5_sub4_sub4.anInt2294 = 1024;
	if (class39_sub5_sub4_sub4.anInt2292 == 1)
	    class39_sub5_sub4_sub4.anInt2294 = 1536;
	int i = class39_sub5_sub4_sub4.anInt2256 - Class2.logicCycle;
	if (class39_sub5_sub4_sub4.anInt2292 == 2)
	    class39_sub5_sub4_sub4.anInt2294 = 0;
	int i_8_ = (class39_sub5_sub4_sub4.anInt2297 * 64
		    + class39_sub5_sub4_sub4.anInt2287 * 128);
	class39_sub5_sub4_sub4.fPositionY
	    += (i_8_ - class39_sub5_sub4_sub4.fPositionY) / i;
	if (class39_sub5_sub4_sub4.anInt2292 == 3)
	    class39_sub5_sub4_sub4.anInt2294 = 512;
	int i_9_ = (class39_sub5_sub4_sub4.anInt2266 * 128
		    + class39_sub5_sub4_sub4.anInt2297 * 64);
	class39_sub5_sub4_sub4.fPositionX
	    += (i_9_ - class39_sub5_sub4_sub4.fPositionX) / i;
    }
    
    public Node get(long hash) {
	lastFetchedHash = hash;
	Node head = nodes[(int) (hash & (long) (size - 1))];
	for (iterator = head.nextNode; head != iterator; iterator = iterator.nextNode) {
	    if (hash == iterator.hash) {
		Node node = iterator;
		iterator = iterator.nextNode;
		return node;
	    }
	}
	iterator = null;
	return null;
    }
    
    static {
	aClass3_359
	    = JString
		  .create("Enter name of friend to add to list");
	aClass3_356 = aClass3_359;
	yelPrefixJstr = JString.create("@yel@");
	aClass49_365 = new Deque();
	languageId = 0;
	OndemandHandler.pendingRegularRequests = new HashTable(4096);
	aClass3_373 = JString.create("Wordpack geladen)3");
	aClass3_375 = JString.create(" )2> @lre@");
	aClass3_376 = JString.create("Loaded textures");
	aClass3_379 = JString.create("Select");
	aClass3_378
	    = JString
		  .create("Fehler bei der Verbindung zum Server)3");
	aClass3_372
	    = JString.create("Could not complete login)3");
	selectJstr = aClass3_379;
	aClass3_380
	    = (JString.create
	       ("(WSpielkonto wiederherstellen(W Option auf der Hauptseite)3"));
	aClass3_384
	    = JString.create("Lade Ignorieren)2Liste)3)3)3");
	aClass3_382
	    = JString
		  .create("You have only just left another world)3");
	aClass3_374 = aClass3_382;
	aClass3_385 = aClass3_372;
	aClass3_386 = aClass3_376;
    }
}
