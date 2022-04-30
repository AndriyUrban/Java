import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInputBracketsTest {

    @Test
    void check() {
        String string = "tt(tt)";
        String string1 = "((tt)(())";
        assertTrue(CheckInputBrackets.check(string));
        assertFalse(CheckInputBrackets.check(string1));
    }
}