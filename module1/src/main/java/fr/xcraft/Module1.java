package fr.xcraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Module1 {

    public static String process(String input) {
        var toto = input.split("```\n" + "\n" + "");
        List<Input> list = new ArrayList<>();

        for (var t :
                toto) {
            var tt = t.split("\n\n```\n");
            tt[0] = tt[0].replace("# ", "");
            var ttt = new Input(tt[0], tt[1]);
            list.add(ttt);
        }
        String collect = list.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(""));
        return "{%s}".formatted(collect);
    }

}
