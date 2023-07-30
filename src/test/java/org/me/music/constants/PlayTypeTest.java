package org.me.music.constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayTypeTest {
    @Test
    void test() {
        PlayType playType = PlayType.BASE;
        Assertions.assertEquals("Base", playType.displayText);

        playType = PlayType.ROTATIONAL_MAP;
        Assertions.assertEquals("Rotational Map", playType.displayText);

        playType = PlayType.MOD_89_MAP;
        Assertions.assertEquals("Mod 89 Map", playType.displayText);

        playType = PlayType.SHIFTED_ROTATIONAL_MAP;
        Assertions.assertEquals("Shifted Rotational Map", playType.displayText);
    }
}
