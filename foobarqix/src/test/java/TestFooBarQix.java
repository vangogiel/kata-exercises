import junit.framework.TestCase;

public class TestFooBarQix extends TestCase {

    public void testFooFooFoo() {
        int test = 33;
        assertEquals("FooFooFoo", FooBarQix.process(test));
    }

    public void testFoo() {
        int test = 13;
        assertEquals("Foo", FooBarQix.process(test));
    }

    public void testFooBar() {
        int test = 15;
        assertEquals("FooBarBar", FooBarQix.process(test));
    }

    public void testFooBarQixBar() {
        int test = 105;
        assertEquals("FooBarQixBar", FooBarQix.process(test));
    }

    public void testFooBarQix() {
        int test = Integer.MAX_VALUE;
        assertEquals("QixFooQix", FooBarQix.process(test));
    }

    public void testFooBarBarNve() {
        int test = -15;
        assertEquals("FooBarBar", FooBarQix.process(test));
    }

}
