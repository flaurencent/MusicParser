package org.me.music.constants;

public enum PlayType {
    BASE("Base"),
    ROTATIONAL_MAP("Rotational Map"),
    MOD_89_MAP("Mod 89 Map"),
    SHIFTED_ROTATIONAL_MAP("Shifted Rotational Map");

    protected final String displayText;

    PlayType(String displayText)
    {
        this.displayText = displayText;
    }
}
