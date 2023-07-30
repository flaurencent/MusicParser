package org.me.music.midi;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.spy;

public class MidiManagerTest {

    private final static Logger logger = LoggerFactory.getLogger(MidiManagerTest.class);

    private static MidiManager midiManager;

    private static final int MIDI_C4 = 60;
    private static final int MIDI_AVERAGE_VELOCITY = 64;

    @BeforeAll
    public static void setup() {
        midiManager = spy(new MidiManager());

        midiManager.createSynthesizer();
    }

    @Test
    void testPlay() {
        midiManager.play(MIDI_C4, MIDI_AVERAGE_VELOCITY, 1000);
    }

    @Test
    void testDuplicate() {
        midiManager.createSynthesizer();
    }

    @AfterAll
    static void teardown() {
        midiManager.destroySynthesizer();
    }
}
