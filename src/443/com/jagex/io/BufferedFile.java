package com.jagex.io;

/* Class18 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.net.JSocket;
import com.jagex.graphics.AbstractImage;
import com.jagex.graphics.IndexedColorSprite;
import com.jagex.world.entities.StillGraphic;
import com.jagex.utils.ISAAC;
import com.jagex.utils.JString;
import com.jagex.utils.ArrayUtils;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import unpackaged.Class15;
import unpackaged.Class2;
import unpackaged.Class23;
import unpackaged.Class26;
import com.jagex.utils.MouseRecorder;
import unpackaged.Class33;
import unpackaged.Class34;
import unpackaged.Class37;
import com.jagex.world.entities.StillObject;
import unpackaged.Class39_Sub5_Sub11;
import unpackaged.Class39_Sub5_Sub14;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub6;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import unpackaged.Class4;
import unpackaged.Class44;
import unpackaged.Class53;
import com.jagex.Client;
import com.jagex.config.ItemDefinition;
import com.jagex.utils.NameTable;

public class BufferedFile {

    public byte[] readBuffer;
    public long currentPosition;
    public static int[] anIntArray338;
    public long position;
    public long writePosition = -1L;
    public static int writeActiveOffset;
    public long writeFileLength;
    public int amountRead;
    public static int worldId = 1;
    public static int[] anIntArray345;
    public static AbstractImage aClass57_346;
    public long readFileLength;
    public static JString aClass3_348 = JString.create("backright1");
    public long readPosition = -1L;
    public static IndexedColorSprite aClass39_Sub5_Sub10_Sub4_350;
    public static Font aFont351;
    public FileOnDisk fileOnDisk;
    public int amountWritten = 0;
    public byte[] writeBuffer;

    public void setPosition(long position) {
        this.position = position;
    }

    public static JString[] method225(JString[] class3s) {
        JString[] class3s_0_ = new JString[5];
        for (int i_1_ = 0; i_1_ < 5; i_1_++) {
            class3s_0_[i_1_] = Class39_Sub5_Sub11.join((new JString[]{AbstractImage.toJstr(i_1_),
                        MouseRecorder.colonJstr}));
            if (class3s != null && class3s[i_1_] != null) {
                class3s_0_[i_1_] = Class39_Sub5_Sub11.join((new JString[]{class3s_0_[i_1_],
                            class3s[i_1_]}));
            }
        }
        return class3s_0_;
    }

    public void destroy() throws IOException {
        flush();
        fileOnDisk.destroy();
    }

    public void read(byte[] src, int len, int off) throws IOException {
        try {
            if (off + len > src.length) {
                throw new ArrayIndexOutOfBoundsException(len + off - src.length);
            }
            if (writePosition != -1L && position >= writePosition && position + (long) len <= (long) amountWritten + writePosition) {
                ArrayUtils.arrayCopy(writeBuffer, (int) (position - writePosition), src, off, len);
                position += (long) len;
                return;
            }
            long l = position;
            int i_4_ = off;
            int i_5_ = len;
            if (position >= readPosition && position < (long) amountRead + readPosition) {
                int i_6_ = (int) (-position + (readPosition + (long) amountRead));
                if (len < i_6_) {
                    i_6_ = len;
                }
                len -= i_6_;
                ArrayUtils.arrayCopy(readBuffer, (int) (position + -readPosition), src, off, i_6_);
                position += (long) i_6_;
                off += i_6_;
            }
            if (readBuffer.length >= len) {
                if (len > 0) {
                    read();
                    int i_7_ = len;
                    if (amountRead < i_7_) {
                        i_7_ = amountRead;
                    }
                    len -= i_7_;
                    ArrayUtils.arrayCopy(readBuffer, 0, src, off, i_7_);
                    off += i_7_;
                    position += (long) i_7_;
                }
            } else {
                fileOnDisk.seek(position);
                currentPosition = position;
                while (len > 0) {
                    int i_8_ = fileOnDisk.read(src, off, len);
                    if (i_8_ == -1) {
                        break;
                    }
                    len -= i_8_;
                    off += i_8_;
                    currentPosition += (long) i_8_;
                    position += (long) i_8_;
                }
            }
            if (writePosition != -1L) {
                if (writePosition > position && len > 0) {
                    int i_9_ = off + (int) (-position + writePosition);
                    if (len + off < i_9_) {
                        i_9_ = len + off;
                    }
                    while (off < i_9_) {
                        len--;
                        src[off++] = (byte) 0;
                        position++;
                    }
                }
                long l_10_ = -1L;
                if (l >= writePosition - -(long) amountWritten
                        || writePosition - -(long) amountWritten > l + (long) i_5_) {
                    if (writePosition < (long) i_5_ + l
                            && (long) i_5_ + l <= (long) amountWritten + writePosition) {
                        l_10_ = l + (long) i_5_;
                    }
                } else {
                    l_10_ = (long) amountWritten + writePosition;
                }
                long l_11_ = -1L;
                if (writePosition >= l && writePosition < (long) i_5_ + l) {
                    l_11_ = writePosition;
                } else if (l >= writePosition && writePosition - -(long) amountWritten > l) {
                    l_11_ = l;
                }
                if (l_11_ > -1L && l_11_ < l_10_) {
                    int i_12_ = (int) (-l_11_ + l_10_);
                    ArrayUtils.arrayCopy(writeBuffer, (int) (-writePosition + l_11_), src, i_4_ + (int) (l_11_ + -l), i_12_);
                    if (position < l_10_) {
                        len -= l_10_ + -position;
                        position = l_10_;
                    }
                }
            }
        } catch (IOException ioexception) {
            currentPosition = -1L;
            throw ioexception;
        }
        if (len > 0) {
            throw new EOFException();
        }
    }

    public long getLength() {
        return readFileLength;
    }

    public void read() throws IOException {
        amountRead = 0;
        if (position != currentPosition) {
            fileOnDisk.seek(position);
            currentPosition = position;
        }
        readPosition = position;
        int read;
        for (/**/; amountRead < readBuffer.length; amountRead += read) {
            read = fileOnDisk.read(readBuffer, amountRead, readBuffer.length - amountRead);
            if (read == -1) {
                break;
            }
            currentPosition += (long) read;
        }
    }

    public static int method230(boolean bool, AbstractFileLoader class9,
            AbstractFileLoader class9_14_) {
        int i = 0;
        if (class9.isFileLoaded(Class39_Sub5_Sub14.blankJstr,
                Class4.aClass3_69)) {
            i++;
        }
        if (class9_14_.isFileLoaded(Class39_Sub5_Sub14.blankJstr,
                StillObject.aClass3_1481)) {
            i++;
        }
        if (class9_14_.isFileLoaded(Class39_Sub5_Sub14.blankJstr,
                Class23.aClass3_422)) {
            i++;
        }
        if (class9_14_.isFileLoaded(Class39_Sub5_Sub14.blankJstr,
                StillGraphic.aClass3_2339)) {
            i++;
        }
        if (class9_14_.isFileLoaded(Class39_Sub5_Sub14.blankJstr,
                JSocket.aClass3_310)) {
            i++;
        }
        return i;
    }

    public void flush() throws IOException {
        if (writePosition != -1L) {
            if (writePosition != currentPosition) {
                fileOnDisk.seek(writePosition);
                currentPosition = writePosition;
            }
            long pos = -1L;
            fileOnDisk.write(writeBuffer, 0, amountWritten);
            if (readPosition > writePosition || writePosition >= (long) amountRead + readPosition) {
                if (readPosition >= writePosition && readPosition < writePosition + (long) amountWritten) {
                    pos = readPosition;
                }
            } else {
                pos = writePosition;
            }
            currentPosition += (long) amountWritten;
            long cPosition = -1L;
            if (currentPosition > writeFileLength) {
                writeFileLength = currentPosition;
            }
            if (readPosition >= writePosition + (long) amountWritten || readPosition - -(long) amountRead < (long) amountWritten + writePosition) {
                if (readPosition + (long) amountRead > writePosition && ((long) amountRead + readPosition <= (long) amountWritten + writePosition)) {
                    cPosition = (long) amountRead + readPosition;
                }
            } else {
                cPosition = writePosition + (long) amountWritten;
            }
            if (pos > -1L && pos < cPosition) {
                int length = (int) (cPosition - pos);
                ArrayUtils.arrayCopy(writeBuffer, (int) (pos - writePosition), readBuffer, (int) (pos - readPosition), length);
            }
            amountWritten = 0;
            writePosition = -1L;
        }
    }

    public static void method232(int i) {
        anIntArray338 = null;
        anIntArray345 = null;
        aFont351 = null;
        aClass39_Sub5_Sub10_Sub4_350 = null;
        aClass57_346 = null;
        aClass3_348 = null;
    }

    public static void handleClassCheckRequests(FrameBuffer frameBuffer) {
        for (;;) {
            ClassCheckRequest request = (ClassCheckRequest) Class15.classCheckRequests.getFirst();
            if (request == null) {
                break;
            }
            boolean waitForResource = false;
            for (int i_19_ = 0; request.size > i_19_; i_19_++) {
                if (request.fieldResources[i_19_] != null) {
                    if (request.fieldResources[i_19_].returnCode == 2) {
                        request.returnCodes[i_19_] = -5;
                    }
                    if (request.fieldResources[i_19_].returnCode == 0) {
                        waitForResource = true;
                    }
                }
                if (request.methodResources[i_19_] != null) {
                    if (request.methodResources[i_19_].returnCode == 2) {
                        request.returnCodes[i_19_] = -6;
                    }
                    if (request.methodResources[i_19_].returnCode  == 0) {
                        waitForResource = true;
                    }
                }
            }
            if (waitForResource) {
                break;
            }
            frameBuffer.putFrame(194);
            frameBuffer.putByte(0);
            int startOffset = frameBuffer.offset;
            frameBuffer.putDword(request.uid);
            for (int i = 0; i < request.size; i++) {
                if (request.returnCodes[i] != 0) {
                    frameBuffer.putByte((request.returnCodes[i]));
                } else {
                    try {
                        int type = request.requestTypes[i];
                        if (type != 0) {
                            if (type == 1) {
                                Field field = ((Field) (request.fieldResources[i].returnObject));
                                field.setInt(null, (request.fieldValues[i]));
                                frameBuffer.putByte(0);
                            } else if (type == 2) {
                                Field field = ((Field) (request.fieldResources[i].returnObject));
                                int modifiers = field.getModifiers();
                                frameBuffer.putByte(0);
                                frameBuffer.putDword(modifiers);
                            }
                        } else {
                            Field field = (Field) (request.fieldResources[i].returnObject);
                            int value = field.getInt(null);
                            frameBuffer.putByte(0);
                            frameBuffer.putDword(value);
                        }
                        if (type == 3) {
                            Method method = (Method) (request.methodResources[i].returnObject);
                            byte[][] paramSrcs = (request.parameterObjSrcs[i]);
                            Object[] parameters = new Object[paramSrcs.length];
                            for (int i_25_ = 0; i_25_ < paramSrcs.length; i_25_++) {
                                ObjectInputStream objectinputstream = (new ObjectInputStream(new ByteArrayInputStream(paramSrcs[i_25_])));
                                parameters[i_25_] = objectinputstream.readObject();
                            }
                            Object object = method.invoke(null, parameters);
                            if (object == null) {
                                frameBuffer.putByte(0);
                            } else if (!(object instanceof Number)) {
                                if (!(object instanceof JString)) {
                                    frameBuffer.putByte(4);
                                } else {
                                    frameBuffer.putByte(2);
                                    frameBuffer.putJstr(((JString) object));
                                }
                            } else {
                                frameBuffer.putByte(1);
                                frameBuffer.putQword(((Number) object).longValue());
                            }
                        } else if (type == 4) {
                            Method method = (Method) (request.methodResources[i].returnObject);
                            int modifiers = method.getModifiers();
                            frameBuffer.putByte(0);
                            frameBuffer.putDword(modifiers);
                        }
                    } catch (ClassNotFoundException classnotfoundexception) {
                        frameBuffer.putByte(-10);
                    } catch (java.io.InvalidClassException invalidclassexception) {
                        frameBuffer.putByte(-11);
                    } catch (java.io.StreamCorruptedException streamcorruptedexception) {
                        frameBuffer.putByte(-12);
                    } catch (java.io.OptionalDataException optionaldataexception) {
                        frameBuffer.putByte(-13);
                    } catch (IllegalAccessException illegalaccessexception) {
                        frameBuffer.putByte(-14);
                    } catch (IllegalArgumentException illegalargumentexception) {
                        frameBuffer.putByte(-15);
                    } catch (java.lang.reflect.InvocationTargetException invocationtargetexception) {
                        frameBuffer.putByte(-16);
                    } catch (SecurityException securityexception) {
                        frameBuffer.putByte(-17);
                    } catch (IOException ioexception) {
                        frameBuffer.putByte(-18);
                    } catch (NullPointerException nullpointerexception) {
                        frameBuffer.putByte(-19);
                    } catch (Exception exception) {
                        frameBuffer.putByte(-20);
                    } catch (Throwable throwable) {
                        frameBuffer.putByte(-21);
                    }
                }
            }
            frameBuffer.putPayloadChecksum(startOffset);
            frameBuffer.putByteLength(-startOffset + frameBuffer.offset);
            request.unlinkDeque();
        }
        
    }

    public void write(byte[] src, int off, int len) throws IOException {
        try {
            if ((long) len + position > readFileLength) {
                readFileLength = (long) len + position;
            }
            if (writePosition != -1L && (writePosition > position || writePosition + (long) amountWritten < position)) {
                flush();
            }
            if (writePosition != -1L && ((long) writeBuffer.length + writePosition < position + (long) len)) {
                int i_29_ = (int) ((long) writeBuffer.length + writePosition - position);
                len -= i_29_;
                ArrayUtils.arrayCopy(src, off, writeBuffer, (int) (position - writePosition), i_29_);
                position += (long) i_29_;
                amountWritten = writeBuffer.length;
                flush();
                off += i_29_;
            }
            if (len > writeBuffer.length) {
                if (currentPosition != position) {
                    fileOnDisk.seek(position);
                    currentPosition = position;
                }
                fileOnDisk.write(src, off, len);
                long l = -1L;
                if (readPosition >= position + (long) len
                        || (long) amountRead + readPosition < position + (long) len) {
                    if (position < readPosition - -(long) amountRead
                            && readPosition - -(long) amountRead <= (long) len + position) {
                        l = (long) amountRead + readPosition;
                    }
                } else {
                    l = (long) len + position;
                }
                currentPosition += (long) len;
                if (writeFileLength < currentPosition) {
                    writeFileLength = currentPosition;
                }
                long l_30_ = -1L;
                if (position < readPosition || position >= readPosition + (long) amountRead) {
                    if (readPosition >= position && readPosition < (long) len + position) {
                        l_30_ = readPosition;
                    }
                } else {
                    l_30_ = position;
                }
                if (l_30_ > -1L && l_30_ < l) {
                    int i_31_ = (int) (l - l_30_);
                    ArrayUtils.arrayCopy(src, (int) ((long) off + (l_30_ - position)), readBuffer, (int) (-readPosition + l_30_), i_31_);
                }
                position += (long) len;
            } else if (len > 0) {
                if (writePosition == -1L) {
                    writePosition = position;
                }
                ArrayUtils.arrayCopy(src, off, writeBuffer, (int) (position - writePosition), len);
                position += (long) len;
                if ((long) amountWritten < -writePosition + position) {
                    amountWritten = (int) (position - writePosition);
                }
            }
        } catch (IOException ioexception) {
            currentPosition = -1L;
            throw ioexception;
        }
    }

    public static void method235(byte i) {
        if (Class2.anInt53 != 0) {
            int i_32_ = 0;
            if (ClassCheckRequest.systemUpdateTime != 0) {
                i_32_ = 1;
            }
            for (int i_33_ = 0; i_33_ < 100; i_33_++) {
                if (Class2.messageBodies[i_33_] != null) {
                    int type = Client.messageTypes[i_33_];
                    JString class3 = StillObject.messagePrefixes[i_33_];
                    if (class3 != null
                            && class3.beginsWith(Class37.crown1Jstr)) {
                        class3 = class3.substring(5);
                    }
                    if (class3 != null
                            && class3.beginsWith(Class53.crown2Jstr)) {
                        class3 = class3.substring(5);
                    }
                    if ((type == 3 || type == 7)
                            && (type == 7 || NameTable.anInt177 == 0
                            || (NameTable.anInt177 == 1
                            && JString.method60(21469, class3)))) {
                        int i_35_ = 329 - i_32_ * 13;
                        if (ISAAC.mousePositionX > 4
                                && Class33.mousePositionY - 4 > i_35_ - 10
                                && Class33.mousePositionY - 4 <= i_35_ + 3) {
                            int i_36_ = (Class39_Sub5_Sub14.p12fullFont.method637(Class39_Sub5_Sub11.join((new JString[]{VarpDefinition.aClass3_1991,
                                        ArchiveWorker.aClass3_1204, class3,
                                        Class2.messageBodies[i_33_]})))) + 25;
                            if (i_36_ > 450) {
                                i_36_ = 450;
                            }
                            if (ISAAC.mousePositionX < 4 + i_36_) {
                                Class26.anInt482++;
                                Class39_Sub5_Sub6.anInt1759++;
                                if (CacheIO.rights >= 1) {
                                    Class4.anInt60++;
                                    JString.queueAction(2009, 0, 0, 0, Class34.aClass3_608,
                                            (Class39_Sub5_Sub11.join((new JString[]{(Entity.whiPrefixJstr),
                                                class3}))));
                                }
                                JString.queueAction(2021, 0, 0,
                                        0, ItemDefinition.aClass3_1683,
                                        (Class39_Sub5_Sub11.join((new JString[]{(Entity.whiPrefixJstr),
                                            class3}))));
                                JString.queueAction(2031, 0, 0, 0, Class44.aClass3_835,
                                        (Class39_Sub5_Sub11.join((new JString[]{(Entity.whiPrefixJstr),
                                            class3}))));
                            }
                        }
                        if (++i_32_ >= 5) {
                            break;
                        }
                    }
                    if ((type == 5 || type == 6) && NameTable.anInt177 < 2
                            && ++i_32_ >= 5) {
                        break;
                    }
                }
            }
        }
    }

    public static int method236(boolean bool) {
        return 19;
    }

    public BufferedFile(FileOnDisk file, int readBufferSize, int writeBufferSize) throws IOException {
        fileOnDisk = file;
        readFileLength = writeFileLength = file.getLength();
        position = 0L;
        readBuffer = new byte[readBufferSize];
        writeBuffer = new byte[writeBufferSize];
    }

    static {
        writeActiveOffset = 0;
    }
}
