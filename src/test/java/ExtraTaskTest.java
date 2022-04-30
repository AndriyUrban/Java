import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTaskTest {

    private Assertions Assert;

    @Test
    void counter() {
        String string = "t4.546,2,656hetrh";
        String string1="5,3,56,terfdse4454t1";
        assertEquals(ExtraTask.counter(string),8);
        assertEquals(ExtraTask.counter(string1),9);

    }
}