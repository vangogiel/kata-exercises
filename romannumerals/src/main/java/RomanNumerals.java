import java.util.Arrays;
import java.util.Optional;

public class RomanNumerals {

    private RomanNumerals() {
    }

    public static String toRoman(int number) {
        StringBuilder sb = new StringBuilder();
        for (RomanNumeralsEnum entry : RomanNumeralsEnum.values()) {
            while (number >= entry.intValue) {
                sb.append(entry.toString());
                number -= entry.intValue;
            }
        }
        return sb.toString();
    }

    public static int toArabic(String roman) {
        int arabic = 0;
        for (int i = 0; i < roman.length(); i++) {
            String subString = roman.substring(i, i + 1);
            if (i < roman.length() - 1) {
                String secoondSubString = roman.substring(i, i + 2);
                Optional<RomanNumeralsEnum> secondValue = Arrays.stream(RomanNumeralsEnum.values())
                        .filter(v -> v.string.equals(secoondSubString))
                        .findFirst();
                Optional<RomanNumeralsEnum> firstValue = Arrays.stream(RomanNumeralsEnum.values())
                        .filter(v -> v.string.equals(subString))
                        .findFirst();
                if (secondValue.isPresent()) {
                    arabic += secondValue.get().intValue;
                    i++;
                } else {
                    arabic += firstValue.get().intValue;
                }
            } else {
                Optional<RomanNumeralsEnum> firstValue = Arrays.stream(RomanNumeralsEnum.values())
                        .filter(v -> v.string.equals(subString))
                        .findFirst();
                arabic += firstValue.get().intValue;
            }
        }
        return arabic;
    }

    enum RomanNumeralsEnum {

        M("M", 1000),
        CM("CM", 900),
        D("D", 500),
        CD("CD", 400),
        C("C", 100),
        XC("XC", 90),
        L("L", 50),
        XL("XL", 40),
        X("X", 10),
        IX("IX", 9),
        V("V", 5),
        IV("IV", 4),
        I("I", 1);

        String string;
        int intValue;

        RomanNumeralsEnum(String string, int intValue) {
            this.string = string;
            this.intValue = intValue;
        }
    }
}
