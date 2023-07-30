package org.me.music.midi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiManager {
    private final Logger logger = LoggerFactory.getLogger(MidiManager.class);

    private Synthesizer synthesizer;
    private MidiChannel pianoChannel;

    private Thread runningThread;

    public void createSynthesizer() {
        if (synthesizer != null) {
            logger.error("Synthesizer is already exists; previous synthesizer should be destroyed before opening a new one.");
            return;
        }

        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] channels = synthesizer.getChannels();
            pianoChannel = channels[0];
        } catch (MidiUnavailableException exception) {
            logger.error("Could not create synthesizer", exception);
        }
        logger.debug("Synthesizer created");
    }

    public void destroySynthesizer() {
        synthesizer.close();
        synthesizer = null;
        pianoChannel = null;
        logger.debug("Synthesizer destroyed");
    }

    /**
     * Requests the synthesizer play the given note for the given length of time.
     * Runs in a separate thread to avoid blocking the processing of previous notes.
     *
     * @param midiNoteNumber the MIDI integer value corresponding to the note
     * @param velocity       the integer value corresponding to the velocity that the note should be pressed with.
     *                       64 is average.
     * @param durationMs     the length in milliseconds that the note should be played
     */
    public void play(int midiNoteNumber, int velocity, int durationMs) {
        logger.info("Playing note " + midiNoteNumber);
        pianoChannel.noteOn(midiNoteNumber, velocity);

        try {
            Thread.sleep(durationMs);
            logger.info("Turning off note " + midiNoteNumber);
            pianoChannel.noteOff(midiNoteNumber);
        } catch (InterruptedException exception) {
            logger.error("Interruption while playing note " + midiNoteNumber, exception);
        }
    }
}
