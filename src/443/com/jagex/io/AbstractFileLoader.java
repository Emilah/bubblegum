package com.jagex.io;

import com.jagex.Client;
import com.jagex.KeycodeConstants;
import com.jagex.utils.NameTable;
import com.jagex.utils.Bzip2Entry;
import com.jagex.utils.Huffman;
import com.jagex.graphics.ImageImpl;
import com.jagex.graphics.DirectColorSprite;
import com.jagex.world.entities.Projectile;
import com.jagex.utils.JString;
import com.jagex.world.entities.Npc;
import com.jagex.world.entities.Player;
import com.jagex.world.map.TraversalMap;
import com.jagex.io.Buffer;
import com.jagex.utils.ArrayUtils;
import com.jagex.io.ArchiveRequest;
import com.jagex.utils.Bzip2Decompressor;
import unpackaged.Class1;
import com.jagex.world.Barrier;
import unpackaged.Class13;
import unpackaged.Class14;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class25;
import unpackaged.Class26;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class37;
import unpackaged.Class39_Sub14;
import unpackaged.Class39_Sub4;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import unpackaged.Class39_Sub5_Sub7;
import unpackaged.Class39_Sub5_Sub9;
import unpackaged.Class43;
import com.jagex.utils.Timer;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* Class9 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public abstract class AbstractFileLoader {

    public static byte[] unpackContainer(byte[] src) {
        Buffer buffer = new Buffer(src);
        int compression = buffer.getUint8();
        int i_33_ = buffer.getUint32();
        if (i_33_ < 0 || Class39_Sub14.anInt1517 != 0 && i_33_ > Class39_Sub14.anInt1517) {
            throw new RuntimeException();
        }
        if (compression != 0) {
            int i_34_ = buffer.getUint32();
            if (i_34_ < 0 || (Class39_Sub14.anInt1517 != 0 && Class39_Sub14.anInt1517 < i_34_)) {
                throw new RuntimeException();
            }
            byte[] is_35_ = new byte[i_34_];
            if (compression != 1) {
                try {
                    DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(src, 9, i_33_)));
                    datainputstream.readFully(is_35_);
                    datainputstream.close();
                } catch (IOException ioexception) {
                    /* empty */
                }
            } else {
                Bzip2Decompressor.method269(is_35_, i_34_, src, i_33_, 9);
            }
            return is_35_;
        }
        byte[] is_36_ = new byte[i_33_];
        buffer.getBytes(is_36_, 0, i_33_);
        return is_36_;
    }
    public int amountEntries;
    public NameTable archiveNameTable;
    public static JString aClass3_131;
    public boolean removeArchive;
    public static int modeWhat;
    public int[] amountFiles;
    public static JString aClass3_135 = JString.create("Loaded sprites");
    public NameTable[] fileNameTables;
    public byte[][] archiveBuffers;
    public byte[][][] fileBuffers;
    public int[][] fileEntries;
    public static JString aClass3_140;
    public static DirectColorSprite aClass39_Sub5_Sub10_Sub3_141;
    public boolean removeFile;
    public int localChecksum;
    public int[] versions;
    public int[] checksums;
    public int[][] fileNameHashes;
    public int[] entries;
    public static JString aClass3_148;
    public static int ambientEffectVolume;
    public int[] archiveNameHashes;

    public int lookupFile(int id, JString childName) {
        childName = childName.toLowerCase();
        return fileNameTables[id].method184(true, childName.getHashCode());
    }

    public void method144(JString archiveName, byte i) {
        archiveName = archiveName.toLowerCase();
        int i_1_ = archiveNameTable.method184(true, archiveName.getHashCode());
    }

    public void removeAllFileBuffers() {
        for (int i_2_ = 0; i_2_ < fileBuffers.length; i_2_++) {
            if (fileBuffers[i_2_] != null) {
                for (int i_3_ = 0; fileBuffers[i_2_].length > i_3_; i_3_++) {
                    fileBuffers[i_2_][i_3_] = null;
                }
            }
        }
    }

    public int[] getFileEntries(int archiveId) {
        return fileEntries[archiveId];
    }

    public void method147(int i) {
    }

    public int getAmountArchives() {
        return fileBuffers.length;
    }

    public void method149(int id) {
    }

    public static void method150(int i) {
        aClass3_135 = null;
        aClass3_148 = null;
        aClass39_Sub5_Sub10_Sub3_141 = null;
        aClass3_131 = null;
        aClass3_140 = null;
    }

    public byte[] fetchArchive(int id) {
        if (fileBuffers.length == 1) {
            return lookupFile(0, id);
        }
        if (fileBuffers[id].length == 1) {
            return lookupFile(id, 0);
        }
        throw new RuntimeException();
    }

    public boolean isFileLoaded(JString childName, JString archiveName) {
        archiveName = archiveName.toLowerCase();
        childName = childName.toLowerCase();
        int archiveId = archiveNameTable.method184(true, archiveName.getHashCode());
        int childId = fileNameTables[archiveId].method184(true, childName.getHashCode());
        return isArchiveLoaded(archiveId, childId);
    }

    public void removeChildBuffers(int archiveId) {
        for (int i = 0; i < fileBuffers[archiveId].length; i++) {
            fileBuffers[archiveId][i] = null;
        }
    }

    public byte[] lookupFile(int archiveId, int childId) {
        if (archiveId < 0 || fileBuffers.length <= archiveId || fileBuffers[archiveId] == null || childId < 0 || childId >= fileBuffers[archiveId].length) {
            return null;
        }
        if (fileBuffers[archiveId][childId] == null) {
            boolean bool = unpackArchive(archiveId, null);
            if (!bool) {
                method149(archiveId);
                bool = unpackArchive(archiveId, null);
                if (!bool) {
                    return null;
                }
            }
        }
        byte[] is = fileBuffers[archiveId][childId];
        return is;
    }

    public boolean isArchiveLoaded(int archiveId, int childId) {
        if (archiveId < 0 || fileBuffers.length <= archiveId
                || fileBuffers[archiveId] == null || childId < 0
                || fileBuffers[archiveId].length <= childId) {
            return false;
        }
        if (fileBuffers[archiveId][childId] != null) {
            return true;
        }
        if (archiveBuffers[archiveId] != null) {
            return true;
        }
        method149(archiveId);
        if (archiveBuffers[archiveId] != null) {
            return true;
        }
        return false;
    }

    public static void method156(byte i) {
        Class1.method50(-120);
        if (Client.state == 10) {
            int i_16_ = Timer.anInt887;
            int positionX = Class39_Sub4.mouseClickPositionX - 202;
            int positionY = Bzip2Entry.mouseClickPositionY - 171;
            if (Barrier.anInt155 == 0) {
                int i_19_ = 120;
                int i_20_ = 100;
                if (i_16_ == 1 && positionX >= i_20_ - 75 && positionX <= i_20_ + 75
                        && i_19_ - 20 <= positionY && i_19_ + 20 >= positionY) {
                    Class43.anInt815 = 0;
                    Barrier.anInt155 = 3;
                }
                i_20_ = 260;
                if (i_16_ == 1 && i_20_ - 75 <= positionX && i_20_ + 75 >= positionX
                        && positionY >= i_19_ - 20 && positionY <= i_19_ + 20) {
                    Barrier.anInt155 = 2;
                    Class39_Sub5_Sub14.aClass3_1899 = Class14.aClass3_241;
                    Class39_Sub5_Sub14.aClass3_1916 = Class14.aClass3_235;
                    Class39_Sub5_Sub14.aClass3_1896 = Class25.aClass3_470;
                    Class43.anInt815 = 0;
                }
            } else if (Barrier.anInt155 != 2) {
                if (Barrier.anInt155 == 3) {
                    int i_21_ = 180;
                    int i_22_ = 150;
                    if (i_16_ == 1 && positionX >= i_21_ - 75
                            && i_21_ + 75 >= positionX && positionY >= i_22_ - 20
                            && i_22_ + 20 >= positionY) {
                        Barrier.anInt155 = 0;
                    }
                }
            } else {
                int i_23_ = 150;
                int i_24_ = 100;
                int i_25_ = 60;
                i_25_ += 30;
                if (i_16_ == 1 && positionY >= i_25_ - 15 && positionY < i_25_) {
                    Class43.anInt815 = 0;
                }
                i_25_ += 15;
                if (i_16_ == 1 && positionY >= i_25_ - 15 && i_25_ > positionY) {
                    Class43.anInt815 = 1;
                }
                i_25_ += 15;
                if (i_16_ == 1 && positionX >= i_24_ - 75 && i_24_ + 75 >= positionX
                        && i_23_ - 20 <= positionY && positionY <= i_23_ + 20) {
                    Class39_Sub5_Sub14.username = Class39_Sub5_Sub14.username.method81(-32769).formatUsername();
                    Class37.method349(8845, Class39_Sub4.aClass3_1334,
                            Class14.aClass3_267,
                            Class14.aClass3_238);
                    Client.setState(20);
                } else {
                    i_24_ = 260;
                    if (i_16_ == 1 && i_24_ - 75 <= positionX
                            && positionX <= i_24_ + 75 && i_23_ - 20 <= positionY
                            && positionY <= i_23_ + 20) {
                        Barrier.anInt155 = 0;
                        Class39_Sub5_Sub14.password = Class39_Sub5_Sub14.blankJstr;
                        Class39_Sub5_Sub14.username = Class39_Sub5_Sub14.blankJstr;
                    }
                    while (Class39_Sub5_Sub7.method588(-4)) {
                        boolean bool = false;
                        for (int i_26_ = 0;
                                i_26_ < MouseRecorder.aClass3_565.getLength();
                                i_26_++) {
                            if (Projectile.currentKey == MouseRecorder.aClass3_565.charAt(i_26_)) {
                                bool = true;
                                break;
                            }
                        }
                        if (Class43.anInt815 != 0) {
                            if (Class43.anInt815 == 1) {
                                if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE && Class39_Sub5_Sub14.password.getLength() > 0) {
                                    Class39_Sub5_Sub14.password = (Class39_Sub5_Sub14.password.substring(0, Class39_Sub5_Sub14.password.getLength() - 1));
                                }
                                if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER || Class15.currentKeyCode == KeycodeConstants.VK_TAB) {
                                    Class43.anInt815 = 0;
                                }
                                if (bool && Class39_Sub5_Sub14.password.getLength() < 20) {
                                    Class39_Sub5_Sub14.password = (Class39_Sub5_Sub14.password.concat(Projectile.currentKey));
                                }
                            }
                        } else {
                            if (Class15.currentKeyCode == KeycodeConstants.VK_BACK_SPACE
                                    && Class39_Sub5_Sub14.username.getLength() > 0) {
                                Class39_Sub5_Sub14.username = (Class39_Sub5_Sub14.username.substring(0, Class39_Sub5_Sub14.username.getLength() - 1));
                            }
                            if (Class15.currentKeyCode == KeycodeConstants.VK_ENTER || Class15.currentKeyCode == KeycodeConstants.VK_TAB) {
                                Class43.anInt815 = 1;
                            }
                            if (bool && Class39_Sub5_Sub14.username.getLength() < 12) {
                                Class39_Sub5_Sub14.username = (Class39_Sub5_Sub14.username.concat(Projectile.currentKey));
                            }
                        }
                    }
                }
            }
        }
    }

    public byte[] lookupFile(int archiveId, int childId, int[] cipherKeys) {
        if (archiveId < 0 || fileBuffers.length <= archiveId || fileBuffers[archiveId] == null || childId < 0 || childId >= fileBuffers[archiveId].length) {
            return null;
        }
        if (fileBuffers[archiveId][childId] == null) {
            boolean bool = unpackArchive(archiveId, cipherKeys);
            if (!bool) {
                method149(archiveId);
                bool = unpackArchive(archiveId, cipherKeys);
                if (!bool) {
                    return null;
                }
            }
        }
        byte[] archive = fileBuffers[archiveId][childId];
        if (removeFile) {
            fileBuffers[archiveId][childId] = null;
        }
        return archive;
    }

    public int getAmountChildren(int archiveId) {
        return fileBuffers[archiveId].length;
    }

    public boolean getArchivesLoaded() {
        boolean archivesLoaded = true;
        for (int i = 0; entries.length > i; i++) {
            int archiveId = entries[i];
            if (archiveBuffers[archiveId] == null) {
                method149(archiveId);
                if (archiveBuffers[archiveId] == null) {
                    archivesLoaded = false;
                }
            }
        }
        return archivesLoaded;
    }

    public static byte[] method160(int fileId, int i_33_, int archiveId, AbstractFileLoader loader,
            int i_35_) {
        long l = ((long) (fileId + archiveId * 37 & 0xffff) + (long) (archiveId << 16) + ((long) i_35_ << 32));
        if (Npc.aClass7_2493 != null) {
            Class39_Sub5_Sub7 class39_sub5_sub7 = ((Class39_Sub5_Sub7) Npc.aClass7_2493.get(l));
            if (class39_sub5_sub7 != null) {
                return class39_sub5_sub7.aByteArray1785;
            }
        }
        byte[] is = loader.lookupFile(archiveId, fileId);
        if (is == null) {
            return null;
        }
        if (Npc.aClass7_2493 != null) {
            Npc.aClass7_2493.put(new Class39_Sub5_Sub7(is), l);
        }
        return is;
    }

    public boolean unpackArchive(int id, int[] keys) {
        if (archiveBuffers[id] == null) {
            return false;
        }
        int children = amountFiles[id];
        byte[][] buffers = fileBuffers[id];
        boolean childrenLoaded = true;
        int[] childEntries = fileEntries[id];
        for (int i = 0; i < children; i++) {
            if (buffers[childEntries[i]] == null) {
                childrenLoaded = false;
                break;
            }
        }
        if (childrenLoaded) {
            return true;
        }
        byte[] archiveBytes;
        if (keys == null || keys[0] == 0 && keys[1] == 0 && keys[2] == 0 && keys[3] == 0) {
            archiveBytes = archiveBuffers[id];
        } else {
            archiveBytes = new byte[archiveBuffers[id].length];
            ArrayUtils.arrayCopy(archiveBuffers[id], 0, archiveBytes, 0, archiveBytes.length);
            Buffer buffer = new Buffer(archiveBytes);
            buffer.decipherXtea(keys, 0, buffer.payload.length, 5);
        }
        byte[] src = unpackContainer(archiveBytes);
        if (removeArchive) {
            archiveBuffers[id] = null;
        }
        if (children <= 1) {
            buffers[childEntries[0]] = src;
        } else {
            int offset = src.length;
            int iterations = src[--offset] & 0xff;
            int[] offsets = new int[children];
            offset -= children * iterations * 4;
            Buffer buffer = new Buffer(src);
            buffer.offset = offset;
            for (int i = 0; iterations > i; i++) {
                int counter = 0;
                for (int i_48_ = 0; children > i_48_; i_48_++) {
                    counter += buffer.getUint32();
                    offsets[i_48_] += counter;
                }
            }
            for (int i = 0; children > i; i++) {
                if (buffers[childEntries[i]] == null) {
                    buffers[childEntries[i]] = new byte[offsets[i]];
                }
                offsets[i] = 0;
            }
            int counter = 0;
            buffer.offset = offset;
            for (int i = 0; iterations > i; i++) {
                int length = 0;
                for (int j = 0; children > j; j++) {
                    length += buffer.getUint32();
                    ArrayUtils.arrayCopy(src, counter, buffers[childEntries[j]], offsets[j], length);
                    offsets[j] += length;
                    counter += length;
                }
            }
        }
        return true;
    }

    public static void parsePlayerMovementUpdates() {
        int amountPlayers = Class39_Sub5_Sub11.incomingBuffer.getBits(8);
        if (amountPlayers < TraversalMap.anInt515) {
            for (int i_55_ = amountPlayers; i_55_ < TraversalMap.anInt515; i_55_++) {
                Class26.anIntArray496[Huffman.anInt749++] = Class1.anIntArray40[i_55_];
            }
        }
        if (TraversalMap.anInt515 < amountPlayers) {
            throw new RuntimeException("gppov1");
        }
        TraversalMap.anInt515 = 0;
        for (int i_56_ = 0; i_56_ < amountPlayers; i_56_++) {
            int i_57_ = Class1.anIntArray40[i_56_];
            Player class39_sub5_sub4_sub4_sub2 = Class14.players[i_57_];
            int update = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
            if (update == 0) {
                Class1.anIntArray40[TraversalMap.anInt515++] = i_57_;
                class39_sub5_sub4_sub4_sub2.anInt2290 = Class2.logicCycle;
            } else {
                int type = Class39_Sub5_Sub11.incomingBuffer.getBits(2);
                if (type == 0) {
                    Class1.anIntArray40[TraversalMap.anInt515++] = i_57_;
                    class39_sub5_sub4_sub4_sub2.anInt2290 = Class2.logicCycle;
                    ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = i_57_;
                } else if (type == 1) {
                    Class1.anIntArray40[TraversalMap.anInt515++] = i_57_;
                    class39_sub5_sub4_sub4_sub2.anInt2290 = Class2.logicCycle;
                    int i_60_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                    class39_sub5_sub4_sub4_sub2.queueStep(i_60_, false);
                    int i_61_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                    if (i_61_ == 1) {
                        ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = i_57_;
                    }
                } else if (type == 2) {
                    Class1.anIntArray40[TraversalMap.anInt515++] = i_57_;
                    class39_sub5_sub4_sub4_sub2.anInt2290 = Class2.logicCycle;
                    int i_62_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                    class39_sub5_sub4_sub4_sub2.queueStep(i_62_, true);
                    int i_63_ = Class39_Sub5_Sub11.incomingBuffer.getBits(3);
                    class39_sub5_sub4_sub4_sub2.queueStep(i_63_, true);
                    int i_64_ = Class39_Sub5_Sub11.incomingBuffer.getBits(1);
                    if (i_64_ == 1) {
                        ArchiveRequest.anIntArray1400[ImageImpl.anInt1586++] = i_57_;
                    }
                } else if (type == 3) {
                    Class26.anIntArray496[Huffman.anInt749++] = i_57_;
                }
            }
        }
    }

    public int lookupArchive(JString archiveName) {

        archiveName = archiveName.toLowerCase();
        String str = new String(archiveName.bytes);
        return archiveNameTable.method184(true, archiveName.getHashCode());
    }

    public boolean hasArchive(int id) {
        if (archiveBuffers[id] != null) {
            return true;
        }
        method149(id);
        if (archiveBuffers[id] != null) {
            return true;
        }
        return false;
    }

    public byte[] method166(int i) {
        if (fileBuffers.length == 1) {
            return lookupFile(0, i);
        }
        if (fileBuffers[i].length == 1) {
            return lookupFile(i, 0);
        }
        throw new RuntimeException();
    }

    public byte[] lookupFile(JString archiveName, JString fileName) {
        archiveName = archiveName.toLowerCase();
        fileName = fileName.toLowerCase();
        int archiveId = archiveNameTable.method184(true, archiveName.getHashCode());
        int childId = fileNameTables[archiveId].method184(true, fileName.getHashCode());
        return lookupFile(archiveId, childId);
    }

    public void decode(byte[] src) {
        localChecksum = Class13.computeChecksum(src, src.length);
        Buffer buffer = new Buffer(unpackContainer(src));
        int version = buffer.getUint8();
        if (version == 5) {
            int settingFlags = buffer.getUint8();
            int counter = 0;
            int maximumEntry = -1;
            amountEntries = buffer.getUint16();
            entries = new int[amountEntries];
            for (int i = 0; amountEntries > i; i++) {
                entries[i] = counter += buffer.getUint16();
                if (entries[i] > maximumEntry) {
                    maximumEntry = entries[i];
                }
            }
            amountFiles = new int[maximumEntry + 1];
            fileEntries = new int[maximumEntry + 1][];
            versions = new int[maximumEntry + 1];
            checksums = new int[maximumEntry + 1];
            fileBuffers = new byte[maximumEntry + 1][][];
            archiveBuffers = new byte[maximumEntry + 1][];
            if (settingFlags != 0) {
                archiveNameHashes = new int[maximumEntry + 1];
                for (int i = 0; amountEntries > i; i++) {
                    archiveNameHashes[entries[i]] = buffer.getUint32();
                }
                archiveNameTable = new NameTable(archiveNameHashes);
            }
            for (int i_76_ = 0; i_76_ < amountEntries; i_76_++) {
                checksums[entries[i_76_]] = buffer.getUint32();
            }
            for (int i_77_ = 0; amountEntries > i_77_; i_77_++) {
                versions[entries[i_77_]] = buffer.getUint32();
            }
            for (int i_78_ = 0; i_78_ < amountEntries; i_78_++) {
                amountFiles[entries[i_78_]] = buffer.getUint16();
            }
            for (int i_79_ = 0; amountEntries > i_79_; i_79_++) {
                counter = 0;
                int entryId = entries[i_79_];
                int amtChildren = amountFiles[entryId];
                int maximumChild = -1;
                fileEntries[entryId] = new int[amtChildren];
                for (int i_83_ = 0; amtChildren > i_83_; i_83_++) {
                    int fileId = (fileEntries[entryId][i_83_] = counter += buffer.getUint16());
                    if (maximumChild < fileId) {
                        maximumChild = fileId;
                    }
                }
                fileBuffers[entryId] = new byte[maximumChild + 1][];
            }
            if (settingFlags != 0) {
                fileNameHashes = new int[maximumEntry + 1][];
                fileNameTables = new NameTable[maximumEntry + 1];
                for (int i_85_ = 0; amountEntries > i_85_; i_85_++) {
                    int i_86_ = entries[i_85_];
                    int i_87_ = amountFiles[i_86_];
                    fileNameHashes[i_86_] = new int[fileBuffers[i_86_].length];
                    for (int i_88_ = 0; i_88_ < i_87_; i_88_++) {
                        fileNameHashes[i_86_][(fileEntries[i_86_][i_88_])] = buffer.getUint32();
                    }
                    fileNameTables[i_86_] = new NameTable(fileNameHashes[i_86_]);
                }
            }
        }
    }

    public AbstractFileLoader(boolean bool, boolean bool_90_) {
        removeArchive = bool;
        removeFile = bool_90_;
    }

    static {
        aClass3_131 = JString.create("auf der Hautpseite)3");
        aClass3_140 = JString.create("Nehmen");
        aClass3_148 = aClass3_135;
        modeWhat = 0;
        ambientEffectVolume = 127;
    }
}
