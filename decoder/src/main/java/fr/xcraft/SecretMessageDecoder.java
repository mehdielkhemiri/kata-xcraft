package fr.xcraft;

public class SecretMessageDecoder {

    static String decode(String input1, String input2) {
        String result1 = Module1.process(input1);
        String result2 = Module2.process(result1);
        String result3 = Module3.process(result1);
        String result4 = Module4.process(input2);
        return Module5.process(result2, result3, result4);
    }

}
