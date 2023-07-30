package org.me.music.midi;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;

public class MidiManagerTest {

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

    @AfterAll
    static void teardown() {
        midiManager.destroySynthesizer();
    }
}
