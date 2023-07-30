package org.me.music.io;

import org.me.music.midi.MidiManager;
import org.me.music.ui.ImportDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImportManager {

    private final Logger logger = LoggerFactory.getLogger(ImportManager.class);

    private static ImportManager instance;
    public static MusicImporter musicImporter;
    public static MidiManager midiManager;

    private static final int SHIFT_VALUE = 31;

    public ImportManager() {
        midiManager.createSynthesizer();
    }

    public static ImportManager getInstance() {
        if (instance == null) {
            musicImporter = new MusicImporter();
            midiManager = new MidiManager();
            instance = new ImportManager();
        }

        return instance;
    }

    public void shutdown() {
        midiManager.destroySynthesizer();
    }

    public void playFile(String text, int type) {
        musicImporter.open(text);
        for (ImportRow row : musicImporter.getContents()) {
            switch (type) {
                case 1:
                    midiManager.play(row.getBase() + SHIFT_VALUE, 64, 1000);
                    break;
                case 2:
                    midiManager.play(row.getRotationalMap() + SHIFT_VALUE, 64, 1000);
                    break;
                case 3:
                    midiManager.play(row.getMod89Map() + SHIFT_VALUE, 64, 1000);
                    break;
                case 4:
                    midiManager.play(row.getShiftedRotationalMap() + SHIFT_VALUE, 64, 1000);
                    break;
                default:
                    logger.error("Unsupported column " + type);
                    break;
            }
        }
        musicImporter.close();
    }

    public void displayDialog() {
        ImportDialog importDialog = new ImportDialog(null);
        importDialog.setVisible(true);
    }
}
