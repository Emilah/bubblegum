package com.jagex.net;

/* Class16 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import com.jagex.utils.Deque;
import com.jagex.io.Buffer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import com.jagex.config.VarpDefinition;
import com.jagex.world.Entity;
import unpackaged.Class39_Sub5_Sub9;
import com.jagex.utils.ClassCheckRequest;
import com.jagex.world.entities.player.PlayerApperance;
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.io.FileLoader;
import com.jagex.io.Buffer;
import com.jagex.utils.JString;
import com.jagex.sign.Resource;
import com.jagex.sign.Signlink;
import com.jagex.config.Widget;
import com.jagex.script.ScriptExecutor;

public class JSocket implements Runnable {

    public int writePosition = 0;
    public InputStream inputstream;
    public Socket socket;
    public Signlink signlink;
    public static BigInteger aBigInteger292 = (new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789"));
    public OutputStream ouputstream;
    public boolean isStopped = false;
    public Resource threadResource;
    public static JString aClass3_296 = JString.create("Chat panel redrawn");
    public byte[] buffer;
    public static JString aClass3_298;
    public static JString aClass3_299;
    public static JString aClass3_300;
    public static int anInt301 = 128;
    public static int anInt302;
    public int bufferPosition = 0;
    public static Deque archiveRequests;
    public static JString aClass3_305;
    public static JString aClass3_306;
    public boolean aBoolean307 = false;
    public static JString aClass3_308;
    public static JString aClass3_310;
    public static JString aClass3_311;
    public static FileLoader fileLoader5;
    public static int anInt313;

    public static void method216(int i) {
        aClass3_299 = null;
        archiveRequests = null;
        aBigInteger292 = null;
        fileLoader5 = null;
        ScriptExecutor.intVariables = null;
        aClass3_296 = null;
        aClass3_311 = null;
        aClass3_298 = null;
        aClass3_310 = null;
        aClass3_308 = null;
        aClass3_300 = null;
        aClass3_306 = null;
        aClass3_305 = null;
    }

    public void run() {
        try {
            for (;;) {
                int offset;
                int amountWrite;
                synchronized (this) {
                    if (writePosition == bufferPosition) {
                        if (isStopped) {
                            break;
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
                        }
                    }
                    offset = writePosition;
                    if (bufferPosition < writePosition) {
                        amountWrite = 5000 - writePosition;
                    } else {
                        amountWrite = bufferPosition - writePosition;
                    }
                }
                if (amountWrite > 0) {
                    try {
                        ouputstream.write(buffer, offset, amountWrite);
                    } catch (IOException ioexception) {
                        aBoolean307 = true;
                    }
                    writePosition = (writePosition + amountWrite) % 5000;
                    try {
                        if (bufferPosition == writePosition) {
                            ouputstream.flush();
                        }
                    } catch (IOException ioexception) {
                        aBoolean307 = true;
                    }
                }
            }
            try {
                if (inputstream != null) {
                    inputstream.close();
                }
                if (ouputstream != null) {
                    ouputstream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ioexception) {
                /* empty */
            }
            buffer = null;
        } catch (Exception exception) {
            ClassCheckRequest.reportError(exception, null);
        }
    }

    public void read(byte[] dest, int off, int len) throws IOException {
        if (!isStopped) {
            int read;
            for (/**/; len > 0; len -= read) {
                read = inputstream.read(dest, off, len);
                if (read <= 0) {
                    throw new EOFException();
                }
                off += read;
            }
        }
    }

    public void hault() {
        if (!isStopped) {
            synchronized (this) {
                isStopped = true;
                this.notifyAll();
            }
            if (threadResource != null) {
                while (threadResource.returnCode == 0) {
                    PlayerApperance.sleep(1L);
                }
                if (threadResource.returnCode == 1) {
                    try {
                        ((Thread) threadResource.returnObject).join();
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
            threadResource = null;
        }
    }

    public static boolean loadWidget(int parent) {
        if (Entity.widgetsLoaded[parent]) {
            return true;
        }
        if (!VarpDefinition.wigetFileLoader.hasArchive(parent)) {
            return false;
        }
        int amountChildren = VarpDefinition.wigetFileLoader.getAmountChildren(parent);
        if (amountChildren == 0) {
            Entity.widgetsLoaded[parent] = true;
            return true;
        }
        if (AbstractMidiHandler.widgets[parent] == null) {
            AbstractMidiHandler.widgets[parent] = new Widget[amountChildren];
        }
        for (int child = 0; child < amountChildren; child++) {
            if (AbstractMidiHandler.widgets[parent][child] == null) {
                byte[] is = VarpDefinition.wigetFileLoader.lookupFile(parent, child);
                if (is != null) {
                    AbstractMidiHandler.widgets[parent][child] = new Widget();
                    AbstractMidiHandler.widgets[parent][child].id = child + (parent << 16);
                    if (is[0] == -1) {
                        AbstractMidiHandler.widgets[parent][child].decodeNewFormat(new Buffer(is));
                    } else {
                        AbstractMidiHandler.widgets[parent][child].decodeOldFormat(new Buffer(is));
                    }
                }
            }
        }
        Entity.widgetsLoaded[parent] = true;
        return true;
    }

    public int read() throws IOException {
        if (isStopped) {
            return 0;
        }
        return inputstream.read();
    }

    @Override
    public void finalize() {
        hault();
    }

    public int available() throws IOException {
        if (isStopped) {
            return 0;
        }
        return inputstream.available();
    }

    public void write(byte[] src, int off, int len) throws IOException {
        if (!isStopped) {
            if (aBoolean307) {
                aBoolean307 = false;
                throw new IOException();
            }
            if (buffer == null) {
                buffer = new byte[5000];
            }
            synchronized (this) {
                int i_9_ = 0;
                for (/**/; len > i_9_; i_9_++) {
                    buffer[bufferPosition] = src[off + i_9_];
                    bufferPosition = (bufferPosition + 1) % 5000;
                    if (bufferPosition == (writePosition + 4900) % 5000) {
                        throw new IOException();
                    }
                }
                if (threadResource == null) {
                    threadResource = signlink.requestThread(this, 3);
                }
                this.notifyAll();
            }
        }
    }

    public JSocket(Socket sock, Signlink sign) throws IOException {
        signlink = sign;
        socket = sock;
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        inputstream = socket.getInputStream();
        ouputstream = socket.getOutputStream();
    }

    static {
        aClass3_298 = JString.create("Error connecting to server)3");
        aClass3_299 = aClass3_298;
        aClass3_300 = JString.create("und Ihr Passwort ein)3");
        aClass3_306 = JString.create("Username: ");
        aClass3_305 = aClass3_306;
        archiveRequests = new Deque();
        aClass3_310 = JString.create("runes");
        aClass3_311 = JString.create("cyan:");
        anInt313 = 0;
        aClass3_308 = aClass3_311;
    }
}
