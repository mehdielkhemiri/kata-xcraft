package fr.xcraft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Module1Test {
    @Test
    void name() {
        String processed = Module1.process("""
                # Message intercepté
                                
                ```
                ...-- -.... .----
                -.- -... ... -.- .- ... . .-- --.. ...-- .- -- ..-. --. ....- -..- .-- -.-. .-. ... -..- - ----- . -... -. ...- -..- -.. .-- -..- ----- .- -..- ... .--- ...- ..--- .. -.. --. .... - .- -... .. --.. .--- --.. .-- -.- ...- ..- -. .--. --- ...- --. ..- -..- .-- .... -..- .-- ...- --. --.- -.. .. -..- --.- -... .... -- .---- .-.-. . ...-- ...- --- . -..- .- -...-
                ```
                                
                # Chiffrement
                                
                ```
                key1 [x2]
                key2
                key1 [x1]
                ```
                                
                # Clés
                                
                ```
                names;value;hexa chars
                key1;k0XMR0W;0x❌❌❌✅
                key2;bsMI41V;0x❌❌✅✅
                ```
                                
                """);


        String expected = """
                   {"Message intercepté": "...-- -.... .----
                                                  -.- -... ... -.- .- ... . .-- --.. ...-- .- -- ..-. --. ....- -..- .-- -.-. .-. ... -..- - ----- . -... -. ...- -..- -.. .-- -..- ----- .- -..- ... .--- ...- ..--- .. -.. --. .... - .- -... .. --.. .--- --.. .-- -.- ...- ..- -. .--. --- ...- --. ..- -..- .-- .... -..- .-- ...- --. --.- -.. .. -..- --.- -... .... -- .---- .-.-. . ...-- ...- --- . -..- .- -...-
                                                  ",
                       "Chiffrement": "key1 [x2]
                                        key2
                                        key1 [x1]",
                       "Clés": "names;value;hexa chars
                                key1;k0XMR0W;0x❌❌❌✅
                                key2;bsMI41V;0x❌❌✅✅"}
                """;

        assertEquals(expected, processed);

    }
}