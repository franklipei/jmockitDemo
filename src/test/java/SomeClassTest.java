import static org.junit.Assert.*;

import org.junit.*;
import mockit.*;

public final class SomeClassTest {
    @Tested
    SomeClass sut;
//    @Injectable
//    @NonStrict
//    SomeOtherClass mock;

    @Test
    public void testSomething() {
        //Record phase
        new Expectations() {
            @Mocked
            SomeOtherClass mock;

            {
                new SomeOtherClass(anyString);
                times = 1;

                mock.performSomeOperation(anyInt);
                result = "mocked";
            }
        };

        //Replay phase
        assertEquals("mocked", sut.doSomething(1234));

        //Verify phase
        //When one or more types get mocked non-strictly in a test, we often end up with a non-empty verification phase.
        new Verifications() {
            {
                new SomeOtherClass(anyString);
                times = 0;
            }
        };
    }

    @Test
    public void testSomething2() {
        new MockUp<SomeOtherClass>() {
            @Mock
            public String performSomeOperation(int value) {
                assertEquals(1234, value);
                return "mocked";
            }
        };

        //Replay phase
        assertEquals("mocked", sut.doSomething(1234));
    }
}

