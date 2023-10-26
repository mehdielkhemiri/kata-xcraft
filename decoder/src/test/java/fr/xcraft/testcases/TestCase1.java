package fr.xcraft.testcases;

import fr.xcraft.SecretMessageDecoder;
import fr.xcraft.util.FileContent;
import fr.xcraft.util.FileContentParameterResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FileContentParameterResolver.class)
class TestCase1 {

    @Test
    void decode_message(@FileContent("secret1.md") String fileContent) {
        assertEquals("", SecretMessageDecoder.decode(fileContent));
    }

}
