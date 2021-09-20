import junit.framework.TestCase;

public class TestRomanNumerals extends TestCase {

    public void testOne() {
        String actualRoman = RomanNumerals.toRoman(1);
        assertEquals("I", actualRoman);
    }

    public void testFour() {
        String actualRoman = RomanNumerals.toRoman(4);
        assertEquals("IV", actualRoman);
    }

    public void testFifteen() {
        String actualRoman = RomanNumerals.toRoman(15);
        assertEquals("XV", actualRoman);
    }

    public void test49() {
        String actualRoman = RomanNumerals.toRoman(49);
        assertEquals("XLIX", actualRoman);
    }

    public void test50() {
        String actualRoman = RomanNumerals.toRoman(50);
        assertEquals("L", actualRoman);
    }

    public void test99() {
        String actualRoman = RomanNumerals.toRoman(99);
        assertEquals("XCIX", actualRoman);
    }

    public void test499() {
        String actualRoman = RomanNumerals.toRoman(499);
        assertEquals("CDXCIX", actualRoman);
    }

    public void test999() {
        String actualRoman = RomanNumerals.toRoman(999);
        assertEquals("CMXCIX", actualRoman);
    }

    public void test3465() {
        String actualRoman = RomanNumerals.toRoman(3465);
        assertEquals("MMMCDLXV", actualRoman);
    }

    public void testRomanToArabic() {
        assertEquals(3465, RomanNumerals.toArabic("MMMCDLXV"));
    }
}
