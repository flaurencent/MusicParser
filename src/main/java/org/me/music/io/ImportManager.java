package org.me.music.io;

import org.me.music.midi.MidiManager;
import org.me.music.ui.ImportDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ImportManager {

    private final Logger logger = LoggerFactory.getLogger(ImportManager.class);

    private static ImportManager instance;
    protected static MusicImporter _musicImporter;
    protected static MidiManager _midiManager;

    private static final int SHIFT_VALUE = 31;

    protected ImportManager() {
        _midiManager.createSynthesizer();
    }

    public static ImportManager getInstance() {
        if (instance == null) {
            _musicImporter = new MusicImporter();
            _midiManager = new MidiManager();
            instance = new ImportManager();
        }

        return instance;
    }

    public void shutdown() {
        _midiManager.destroySynthesizer();
    }

    public void playFile(String text, int type) {
        _musicImporter.open(text);

        List<ImportRow> rows = _musicImporter.getContents();
        for (ImportRow row : rows) {
            switch (type) {
                case 1:
                    _midiManager.play(row.getBase() + SHIFT_VALUE, 64, 1000);
                    break;
                case 2:
                    _midiManager.play(row.getRotationalMap() + SHIFT_VALUE, 64, 1000);
                    break;
                case 3:
                    _midiManager.play(row.getMod89Map() + SHIFT_VALUE, 64, 1000);
                    break;
                case 4:
                    _midiManager.play(row.getShiftedRotationalMap() + SHIFT_VALUE, 64, 1000);
                    break;
                default:
                    logger.error("Unsupported column " + type);
                    break;
            }
        }

        _musicImporter.close();
    }

    public void displayDialog() {
        ImportDialog importDialog = new ImportDialog(null);
        importDialog.setVisible(true);
    }
}
