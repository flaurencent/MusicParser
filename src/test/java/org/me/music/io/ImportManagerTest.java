package org.me.music.io;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ImportManagerTest {
    private static ImportManager importManager;

    private static MusicImporter musicImporter;

    public static String TEST_FILE = "C:\\Users\\Lauren\\Repositories\\MusicParser\\src\\test\\resources\\good_import_row.txt";

    @BeforeAll
    public static void setup() {
        musicImporter = spy(MusicImporter.class);

        ImportManager._musicImporter = musicImporter;
        importManager = ImportManager.getInstance();
    }

    @Test
    public void testOption1() {
        /*
        importManager.playFile(TEST_FILE, 1);
        verify(musicImporter).open(any());
        verify(musicImporter.getContents());
        verify(musicImporter).close();

        importManager.playFile(TEST_FILE, 2);
        verify(musicImporter).open(any());
        verify(musicImporter.getContents());
        verify(musicImporter).close();

        importManager.playFile(TEST_FILE, 3);
        verify(musicImporter).open(any());
        verify(musicImporter.getContents());
        verify(musicImporter).close();

        importManager.playFile(TEST_FILE, 4);
        verify(musicImporter).open(any());
        verify(musicImporter.getContents());
        verify(musicImporter).close();*/
    }

    @AfterAll
    public static void shutdown() {
        importManager.shutdown();
    }
}
