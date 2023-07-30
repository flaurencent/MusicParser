package org.me.music.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusicImporter {
    private final Logger logger = LoggerFactory.getLogger(MusicImporter.class);

    private BufferedReader fileReader;

    public MusicImporter() {
    }

    public void open(String fileName) {
        if (fileReader != null) {
            logger.error("Could not open MusicImporter; file reader already exists");
            return;
        }

        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException exception) {
            logger.error("Could not open MusicImporter", exception);
        }
    }

    public List<ImportRow> getContents() {
        List<ImportRow> importedRows = new ArrayList<>();

        fileReader.lines().forEachOrdered(line -> importRow(line).ifPresent(importedRows::add));

        logger.info("Finished importing file");

        return importedRows;
    }

    private Optional<ImportRow> importRow(String row) {
        String[] tokens = row.split("\\s+");
        if (tokens.length != 4) {
            logger.error("Formatting error with line: " + row +
                    "/nExpected format is 4 numbers separated by a space." +
                    "/nSkipping line during import.");
            return Optional.empty();

        } else {
            ImportRow newImportedRow = new ImportRow(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]));
            logger.debug("Imported line " + row);
            return Optional.of(newImportedRow);
        }
    }

    public void close() {
        if (fileReader == null) {
            logger.error("Could not close MusicImporter; file reader is not open");
            return;
        }

        try {

            fileReader.close();
            fileReader = null;
        } catch (IOException exception) {
            logger.error("Could not close MusicImporter", exception);
        }
    }
}