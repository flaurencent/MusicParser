package org.me.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.me.Main;

public class MainTest {
    @Test
    public void testMain()
    {
        Main.main(new String[]{});
        Assertions.assertTrue(true);
    }
}
