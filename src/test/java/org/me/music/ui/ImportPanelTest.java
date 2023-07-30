package org.me.music.ui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.me.music.constants.PlayType;
import org.me.music.io.ImportManager;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ImportPanelTest {

    private ImportPanel importPanel = new ImportPanel();
    private ImportManager importManager = mock();

    @BeforeAll
    public static void setup() {

    }

    @Test
    public void testPlayButton() {
        /*
        importPanel.setPlayTypeComboBoxValue(PlayType.BASE);
        verify(importManager).playFile(any(), eq(1));

        importPanel.setPlayTypeComboBoxValue(PlayType.ROTATIONAL_MAP);
        verify(importManager).playFile(any(), 2);

        importPanel.setPlayTypeComboBoxValue(PlayType.MOD_89_MAP);
        verify(importManager).playFile(any(), 3);

        importPanel.setPlayTypeComboBoxValue(PlayType.SHIFTED_ROTATIONAL_MAP);
        verify(importManager).playFile(any(), 4);*/
    }
}
