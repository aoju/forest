package org.aoju.bus.core.codec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaesarTest {

    @Test
    public void caesarTest() {
        String str = "1f2e9df6131b480b9fdddc633cf24996";

        String encode = Caesar.encode(str, 3);

        String decode = Caesar.decode(encode, 3);
        Assertions.assertEquals(str, decode);
    }

}
