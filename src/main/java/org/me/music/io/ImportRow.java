package org.me.music.io;

public class ImportRow {

    private final int base;
    private final int rotationalMap;
    private final int mod89Map;
    private final int shiftedRotationalMap;

    public ImportRow(int base, int rotationalMap, int mod89Map, int shiftedRotationalMap) {
        this.base = base;
        this.rotationalMap = rotationalMap;
        this.mod89Map = mod89Map;
        this.shiftedRotationalMap = shiftedRotationalMap;
    }

    public int getBase() {
        return base;
    }

    public int getRotationalMap() {
        return rotationalMap;
    }

    public int getMod89Map() {
        return mod89Map;
    }

    public int getShiftedRotationalMap() {
        return shiftedRotationalMap;
    }
}
