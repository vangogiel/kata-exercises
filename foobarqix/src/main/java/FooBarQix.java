import java.util.Arrays;

public class FooBarQix {

    public static String process(int input) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(FooBarQixEnum.values())
                .forEach(v -> sb.append(getMethod(input, v)));
        for (char c : String.valueOf(input).toCharArray()) {
            Arrays.stream(FooBarQixEnum.values())
                    .forEach(v -> sb.append(c == v.string ? v.desc : ""));
        }
        return sb.toString();
    }

    private enum FooBarQixEnum {

        FOO(3, '3', "Foo"),
        BAR(5, '5', "Bar"),
        QIX(7, '7', "Qix");

        private int number;
        private char string;
        private String desc;

        FooBarQixEnum(int number, char string, String desc) {
            this.number = number;
            this.string = string;
            this.desc = desc;
        }
    }

    private static String getMethod(int input, FooBarQix.FooBarQixEnum s) {
        return (input % s.number == 0) ? s.desc : "";
    }
}
