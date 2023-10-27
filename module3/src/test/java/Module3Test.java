import fr.xcraft.Module3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Module3Test {

    @Test
    void name() {
        String input = """
                {
                    "message_intercepte": "blabla",
                    "chiffrement": "key1 [x2]
                                    key2
                                    key1 [x1]",
                     "cles": "keys"
                }
                """;

        String output = Module3.process(input);

        assertEquals("key1 -> key1 -> key2 -> key1", output);
    }
}
