package fr.xcraft;

public class SecretMessageDecoder {

    public static String decode(String input) {
        String result1 = Module1.process(input);
        String result2 = Module2.process(result1);
        String result3 = Module3.process(result1);
        String result4 = Module4.process(result1);
        return Module5.process(result2, result3, result4);
    }

}
