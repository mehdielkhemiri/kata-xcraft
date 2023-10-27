package fr.xcraft.testcases;

import fr.xcraft.SecretMessageDecoder;
import fr.xcraft.util.FileContent;
import fr.xcraft.util.FileContentParameterResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static fr.xcraft.util.StringUtil.hash;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FileContentParameterResolver.class)
class TestCase2 {

    @Test
    void decode_message(@FileContent("secret2.md") String input) {
        String decoded = SecretMessageDecoder.decode(input);
        assertEquals("o8Hl8M/Lio6WvPmdCkAAm9/w9J/GTcQ9cYy3kTNQMQo=", hash(decoded));
    }

}
