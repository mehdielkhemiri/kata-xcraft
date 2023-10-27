package fr.xcraft.testcases;

import fr.xcraft.Module1;
import fr.xcraft.Module2;
import fr.xcraft.Module3;
import fr.xcraft.Module4;
import fr.xcraft.SecretMessageDecoder;
import fr.xcraft.util.FileContent;
import fr.xcraft.util.FileContentParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static fr.xcraft.util.StringUtil.hash;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FileContentParameterResolver.class)
class TestCase1 {

    private String input;

    @BeforeEach
    void setUp(@FileContent("secret1.md") String fileContent) {
        input = fileContent;
    }

    @Test
    void decode_message() {
        String decodedMessage = SecretMessageDecoder.decode(input);
        String expectedHash = "dHn+pUsg1wUwIm3vmt59pS6xw38aE1E8Ug30w35H1qE=";
        assertEquals(expectedHash, hash(decodedMessage));
    }

    @Nested
    class IntermediaryTests {

        private final String module1output = Module1.process(input);

        @Test
        void module2_intermediary_output() {
            String expected = "KBsKASEWZ3AMFG4XWCRSXT0eBnVXdWx0AXsjV2IdGhtaBiZjZWkVUnpoVGUXWhxwVGQdIXQBHm1+E3VoExA=";
            assertEquals(expected, Module2.process(module1output));
        }

        @Test
        void module3_intermediary_output() {
            String expected = "key1 -> key1 -> key2 -> key1";
            assertEquals(expected, Module3.process(module1output));
        }

        @Test
        void module4_intermediary_output() {
            String expected = """
                    key1
                    B08D207
                    key2
                    62734D49343156
                    """;
            assertEquals(expected, Module4.process(module1output));
        }

    }

}
