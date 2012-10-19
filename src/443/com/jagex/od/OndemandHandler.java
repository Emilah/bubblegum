/**
 * Copyright Evelus, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Hadyn Richard (sini@evel.us), July 2012
 */

package com.jagex.od;

import com.jagex.Client;
import com.jagex.awt.JApplet;
import com.jagex.awt.JCanvas;
import com.jagex.awt.listeners.KeyListenerImpl;
import com.jagex.awt.listeners.MouseListenerImpl;
import com.jagex.config.ObjectDefinition;
import com.jagex.graphics.JImage;
import com.jagex.io.ArchiveWorker;
import com.jagex.io.Buffer;
import com.jagex.io.CacheIO;
import com.jagex.io.FileLoader;
import com.jagex.net.JSocket;
import com.jagex.od.OndemandRequest;
import com.jagex.utils.Bzip2Entry;
import com.jagex.utils.Deque;
import com.jagex.utils.HashTable;
import com.jagex.utils.Huffman;
import com.jagex.utils.Queue;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Projectile;
import java.io.IOException;
import java.net.Socket;
import unpackaged.Class1;
import unpackaged.Class2;
import unpackaged.Class20;
import unpackaged.Class25;
import unpackaged.Class32;
import unpackaged.Class33;
import unpackaged.Class39_Sub4;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class41;
import unpackaged.Class63;
import unpackaged.Class65;
import com.jagex.utils.MouseRecorder;

/**
 * Evelus Development
 * Created by Hadyn Richard
 */
public class OndemandHandler {
    
    public static byte encryptionKey = 0;
    public static HashTable pendingRegularRequests;
    public static int odConnectionDelay;
    public static int errors = 0;
    public static JSocket socket;
    public static Queue regularRequestsQueue = new Queue();
    public static HashTable requests;
    public static Buffer requestBuffer;

    public static boolean cycle() {
        long l = Class2.getSystemTime();
        int i_2_ = (int) (-Bzip2Entry.aLong1063 + l);
        Bzip2Entry.aLong1063 = l;
        if (i_2_ > 200) {
            i_2_ = 200;
        }
        Huffman.anInt748 += i_2_;
        if (JCanvas.pendingRegularRequests == 0 && Class1.pendingPriorityRequests == 0 && Class41.queuedRegularRequests == 0 && Class39_Sub5_Sub6.queuedPriorityRequests == 0) {
            return true;
        }
        if (socket == null) {
            return false;
        }
        try {
            if (Huffman.anInt748 > 30000) {
                throw new IOException();
            }
            for (; Class1.pendingPriorityRequests < 20; Class1.pendingPriorityRequests++) {
                if (Class39_Sub5_Sub6.queuedPriorityRequests <= 0) {
                    break;
                }
                OndemandRequest request = (OndemandRequest) Class25.priorityRequestsQueue.quickLookup();
                Buffer buffer = new Buffer(4);
                buffer.putByte(1);
                buffer.putTri((int) request.hash);
                socket.write(buffer.payload, 0, 4);
                CacheIO.pendingPriorityRequests.put(request.hash, request);
                Class39_Sub5_Sub6.queuedPriorityRequests--;
            }
            for (; JCanvas.pendingRegularRequests < 20 && Class41.queuedRegularRequests > 0; JCanvas.pendingRegularRequests++) {
                OndemandRequest request = (OndemandRequest) regularRequestsQueue.peekFirst();
                Buffer buffer = new Buffer(4);
                buffer.putByte(0);
                buffer.putTri((int) request.hash);
                socket.write(buffer.payload, 0, 4);
                request.unlinkQueue();
                pendingRegularRequests.put(request.hash, request);
                Class41.queuedRegularRequests--;
            }
            int cycle = 0;
            for (; cycle < 100; cycle++) {
                int avail = socket.available();
                if (avail < 0) {
                    throw new IOException();
                }
                if (avail == 0) {
                    break;
                }
                Huffman.anInt748 = 0;
                int amountRead = 0;
                if (FileLoader.currentOdRequest != null) {
                    if (Class39_Sub4.odBlockOffset == 0) {
                        amountRead = 1;
                    }
                } else {
                    amountRead = 8;
                }
                if (amountRead > 0) {
                    int amountBytes = amountRead - JApplet.odBuffer.offset;
                    if (amountBytes > avail) {
                        amountBytes = avail;
                    }
                    socket.read(JApplet.odBuffer.payload, JApplet.odBuffer.offset, amountBytes);
                    if (encryptionKey != 0) {
                        for (int i_7_ = 0; i_7_ < amountBytes; i_7_++) {
                            JApplet.odBuffer.payload[JApplet.odBuffer.offset + i_7_] = (byte) (Npc.xor(JApplet.odBuffer.payload[(JApplet.odBuffer.offset) + i_7_], encryptionKey));
                        }
                    }
                    JApplet.odBuffer.offset += amountBytes;
                    if (amountRead > JApplet.odBuffer.offset) {
                        break;
                    }
                    if (FileLoader.currentOdRequest == null) {
                        JApplet.odBuffer.offset = 0;
                        int indexId = JApplet.odBuffer.getUbyte();
                        int archiveId = JApplet.odBuffer.getUword();
                        int flags = JApplet.odBuffer.getUbyte();
                        long hash = (long) (archiveId + (indexId << 16));
                        int size = JApplet.odBuffer.getDword();
                        OndemandRequest request = (OndemandRequest) CacheIO.pendingPriorityRequests.get(hash);
                        Class41.isCurrentRequestPriority = true;
                        if (request == null) {
                            request = ((OndemandRequest) pendingRegularRequests.get(hash));
                            Class41.isCurrentRequestPriority = false;
                        }
                        if (request == null) {
                            throw new IOException();
                        }
                        FileLoader.currentOdRequest = request;
                        int i_13_ = flags != 0 ? 9 : 5;
                        requestBuffer = new Buffer(i_13_ + (size + (FileLoader.currentOdRequest.footerSize)));
                        requestBuffer.putByte(flags);
                        requestBuffer.putDword(size);
                        Class39_Sub4.odBlockOffset = 8;
                        JApplet.odBuffer.offset = 0;
                    } else if (Class39_Sub4.odBlockOffset == 0) {
                        if (JApplet.odBuffer.payload[0] == -1) {
                            JApplet.odBuffer.offset = 0;
                            Class39_Sub4.odBlockOffset = 1;
                        } else {
                            FileLoader.currentOdRequest = null;
                        }
                    }
                } else {
                    int length = -FileLoader.currentOdRequest.footerSize + requestBuffer.payload.length;
                    int i_15_ = -Class39_Sub4.odBlockOffset + 512;
                    if (length - requestBuffer.offset < i_15_) {
                        i_15_ = length - requestBuffer.offset;
                    }
                    if (avail < i_15_) {
                        i_15_ = avail;
                    }
                    socket.read(requestBuffer.payload, requestBuffer.offset, i_15_);
                    if (encryptionKey != 0) {
                        for (int i_16_ = 0; i_15_ > i_16_; i_16_++) {
                            requestBuffer.payload[requestBuffer.offset + i_16_] = (byte) (requestBuffer.payload[(requestBuffer.offset) + i_16_] ^ encryptionKey);
                        }
                    }
                    requestBuffer.offset += i_15_;
                    Class39_Sub4.odBlockOffset += i_15_;
                    if (length == requestBuffer.offset) {
                        if (FileLoader.currentOdRequest.hash == 16711935L) {
                            JImage.updateTableBuffer = requestBuffer;
                            for (int i_17_ = 0; i_17_ < 256; i_17_++) {
                                FileLoader class9_sub1 = Class33.fileLoaders[i_17_];
                                if (class9_sub1 != null) {
                                    JImage.updateTableBuffer.offset = i_17_ * 4 + 5;
                                    int checksum = JImage.updateTableBuffer.getDword();
                                    class9_sub1.setChecksum(checksum);
                                }
                            }
                        } else {
                            VarpDefinition.crc.reset();
                            VarpDefinition.crc.update(requestBuffer.payload, 0, length);
                            int checksum = (int) VarpDefinition.crc.getValue();
                            if (FileLoader.currentOdRequest.checksum != checksum) {
                                try {
                                    socket.hault();
                                } catch (Exception exception) {
                                    /* empty */
                                }
                                encryptionKey = (byte) (int) (Math.random() * 255.0 + 1.0);
                                socket = null;
                                Class20.anInt393++;
                                return false;
                            }
                            errors = 0;
                            Class20.anInt393 = 0;
                            FileLoader.currentOdRequest.fileLoader.method175(requestBuffer.payload, Class41.isCurrentRequestPriority, (FileLoader.currentOdRequest.hash & 16711680L) == 16711680L, (int) ((FileLoader.currentOdRequest.hash) & 65535L));
                        }
                        FileLoader.currentOdRequest.unlinkDeque();
                        if (Class41.isCurrentRequestPriority) {
                            Class1.pendingPriorityRequests--;
                        } else {
                            JCanvas.pendingRegularRequests--;
                        }
                        FileLoader.currentOdRequest = null;
                        requestBuffer = null;
                        Class39_Sub4.odBlockOffset = 0;
                    } else {
                        if (Class39_Sub4.odBlockOffset != 512) {
                            break;
                        }
                        Class39_Sub4.odBlockOffset = 0;
                    }
                }
            }
            return true;
        } catch (IOException ioexception) {
            try {
                socket.hault();
            } catch (Exception exception) {
                /* empty */
            }
            ioexception.printStackTrace();
            socket = null;
            errors++;
            return false;
        }
    }

    public static void writeConnect(JSocket s, boolean bool) {
        if (socket != null) {
            try {
                socket.hault();
            } catch (Exception exception) {
                /* empty */
            }
            socket = null;
        }
        socket = s;
        writeStatus(bool);
        FileLoader.currentOdRequest = null;
        Class39_Sub4.odBlockOffset = 0;
        JApplet.odBuffer.offset = 0;
        requestBuffer = null;
        for (;;) {
            OndemandRequest ondemandRequest = (OndemandRequest) CacheIO.pendingPriorityRequests.quickLookup();
            if (ondemandRequest == null) {
                break;
            }
            Class25.priorityRequestsQueue.put(ondemandRequest.hash, ondemandRequest);
            Class1.pendingPriorityRequests--;
            Class39_Sub5_Sub6.queuedPriorityRequests++;
        }
        for (;;) {
            OndemandRequest request = (OndemandRequest) pendingRegularRequests.quickLookup();
            if (request == null) {
                break;
            }
            regularRequestsQueue.offerLast(request);
            requests.put(request.hash, request);
            Class41.queuedRegularRequests++;
            JCanvas.pendingRegularRequests--;
        }
        if (encryptionKey != 0) {
            try {
                Buffer buffer = new Buffer(4);
                buffer.putByte(4);
                buffer.putByte(encryptionKey);
                buffer.putWord(0);
                socket.write(buffer.payload, 0, 4);
            } catch (IOException ioexception) {
                try {
                    socket.hault();
                } catch (Exception exception) {
                    /* empty */
                }
                errors++;
                socket = null;
            }
        }
        Huffman.anInt748 = 0;
        Bzip2Entry.aLong1063 = Class2.getSystemTime();
    }

    public static void writeStatus(boolean bool) {
        if (socket != null) {
            try {
                Buffer buffer = new Buffer(4);
                buffer.putByte(!bool ? 3 : 2);
                buffer.putTri(0);
                socket.write(buffer.payload, 0, 4);
            } catch (IOException ioex) {
                try {
                    socket.hault();
                } catch (Exception ex) {
                    /* empty */
                }
                socket = null;
                errors++;
            }
        }
    }
    
    static {
        requests = new HashTable(4096);
    }
}