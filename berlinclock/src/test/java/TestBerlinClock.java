import junit.framework.TestCase;


public class TestBerlinClock extends TestCase {

    public void testOddSeconds() {
        assertEquals("O", BerlinClock.getSeconds(01));
    }

    public void testEvenSeconds() {
        assertEquals("Y", BerlinClock.getSeconds(12));
    }

    public void testOddHours() {
        assertEquals("RRRO OOOO", BerlinClock.getHours(15));
    }

    public void testEvenHours() {
        assertEquals("RRRO ROOO", BerlinClock.getHours(16));
    }

    public void testMidnightHours() {
        assertEquals("OOOO OOOO", BerlinClock.getHours(00));
    }

    public void testMaxHours() {
        assertEquals("RRRR RRRO", BerlinClock.getHours(23));
    }

    public void testLessThan5Minutes() {
        assertEquals("OOOOOOOOOOO YYYY", BerlinClock.getMinutes(4));
    }

    public void testMoreThan15Minutes() {
        assertEquals("YYROOOOOOOO YOOO", BerlinClock.getMinutes(16));
    }

    public void testZeroMinutes() {
        assertEquals("OOOOOOOOOOO OOOO", BerlinClock.getMinutes(00));
    }

    public void testMaxMinutes() {
        assertEquals("YYRYYRYYRYY YYYY", BerlinClock.getMinutes(59));
    }

    public void testMaxTime() {
        assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", BerlinClock.getTime("23:59:59"));
    }

    public void testMinTime() {
        assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", BerlinClock.getTime("00:00:00"));
    }

    public void testNotValidTime() {
        assertEquals("", BerlinClock.getTime("30:70:70"));
    }
}
