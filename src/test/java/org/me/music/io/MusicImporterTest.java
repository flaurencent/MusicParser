package org.me.music.io;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.mockito.Mockito.spy;

public class MusicImporterTest {
    private static MusicImporter musicImporter;

    @BeforeAll
    static void setup()
    {
        musicImporter = spy(new MusicImporter());
    }

    @Test
    public void testGood()
    {
        musicImporter.open("C:\\Users\\Lauren\\Repositories\\MusicParser\\src\\test\\resources\\good_import_row.txt");
        List<ImportRow> rows = musicImporter.getContents();
        Assertions.assertEquals(1, rows.size());

        ImportRow row =rows.get(0);
        Assertions.assertEquals(10, row.getBase());
        Assertions.assertEquals(20, row.getRotationalMap());
        Assertions.assertEquals(30, row.getMod89Map());
        Assertions.assertEquals(40, row.getShiftedRotationalMap());

        musicImporter.close();
    }

    @AfterAll
    static void teardown()
    {
        musicImporter.close();
    }
}
