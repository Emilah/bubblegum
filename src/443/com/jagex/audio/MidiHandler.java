package com.jagex.audio;

/* Class62_Sub1_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import com.jagex.audio.AbstractMidiHandler;
import com.jagex.utils.Queue;
import java.io.ByteArrayInputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;

public class MidiHandler extends AbstractMidiHandler implements Receiver {

    public static Sequencer sequencer;
    public static volatile boolean aBoolean2161;
    public static Receiver reciever = null;

    public synchronized void method1055(int i, int i_0_, int i_1_) {
        if (sequencer != null) {
            if (i_1_ != 0) {
                destroy();
            }
            updateVolume(i, -1L, i_0_);
        }
    }

    public void updateSequencer(int i, byte[] is, byte i_2_, boolean loop) {
        if (sequencer != null) {
            try {
                Sequence sequence = MidiSystem.getSequence(new ByteArrayInputStream(is));
                sequencer.setSequence(sequence);
                sequencer.setLoopCount(loop ? -1 : 0);
                updateVolume(0, -1L, i);
                aBoolean2161 = true;
                sequencer.start();
            } catch (Exception exception) {
                /* empty */
            }
        }
    }

    public void destroy() {
        if (sequencer != null) {
            sequencer.close();
            sequencer = null;
        }
        if (reciever != null) {
            reciever.close();
            reciever = null;
        }
    }

    public synchronized void send(MidiMessage midimessage, long l) {
        if (aBoolean2161) {
            byte[] is = midimessage.getMessage();
            if (!method1060(is[0] & 0xff, is[1], is.length >= 3 ? is[2] : 0, l)) {
                reciever.send(midimessage, l);
            }
        }
    }

    public void method1053(int i, byte i_3_) {
        if (sequencer != null) {
            method1061(-1L, true, i);
            if (i_3_ <= 44) {
                destroy();
            }
        }
    }

    public void method1054(int i) {
        if (i != 0) {
            close();
        }
    }

    public void send(int i, int i_4_, int i_5_, long l) {
        try {
            ShortMessage shortmessage = new ShortMessage();
            shortmessage.setMessage(i, i_4_, i_5_);
            reciever.send(shortmessage, l);
        } catch (InvalidMidiDataException invalidmididataexception) {
            /* empty */
        }
    }

    public MidiHandler() {
        try {
            reciever = MidiSystem.getReceiver();
            sequencer = MidiSystem.getSequencer(false);
            sequencer.getTransmitter().setReceiver(this);
            sequencer.open();
            method1062(-1L, 0);
        } catch (Exception exception) {
            Queue.method987(-30574);
        }
    }

    public void close() {
        /* empty */
    }

    public void method1048(boolean bool) {
        if (sequencer != null) {
            aBoolean2161 = bool;
            sequencer.stop();
            method1062(-1L, 0);
        }
    }

    static {
        sequencer = null;
        aBoolean2161 = false;
    }
}
