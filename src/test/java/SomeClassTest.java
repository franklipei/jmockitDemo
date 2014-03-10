import static org.junit.Assert.*;

import org.junit.*;
import mockit.*;

public final class SomeClassTest {
    @Tested
    SomeClass sut;

    @Injectable
    int someIntegralProperty2 = 2;

    @Injectable
    int someIntegralProperty = 1;
//    @Injectable
//    @NonStrict
//    SomeOtherClass mock2;//a mocked field

    @Injectable
    SomeOtherClass mock;

    @Test
    public void testSomething3() {

        new NonStrictExpectations() {
            {
                mock.performSomeOperation(anyInt);
                result = "mocked";
            }
        };

        System.out.println("instance mock of SomeOtherClass is " + mock.toString() + mock.performSomeOperation(1));
        System.out.println(sut.i + "/" + sut.someIntegralProperty);

//        Deencapsulation.setField(sut, "mock", mock);

        assertEquals("mocked", sut.doSomething(1234));
    }

    @Test
    public void testSomething() {
        //Record phase
        new Expectations() {
            //The use of @Mocked annotation is optional for mock parameters and for mock fields declared inside expectation blocks.
//            @Injectable
//            SomeOtherClass mock;

            {
                new SomeOtherClass(anyString);
                times = 0;

//                mock.performSomeOperation(anyInt);
//                result = "mocked";

//                mock2.performSomeOperation(anyInt);
//                result = "mocked2";
//                System.out.println("instance mock of SomeOtherClass is " + mock.toString() + ", " + mock.performSomeOperation(1));

            }
        };
//        System.out.println("instance mock2 of SomeOtherClass is " + mock2.toString() + ", " + mock2.performSomeOperation(1));


        //Replay phase
        assertEquals("mocked", sut.doSomething(1234));

        //Verify phase
        //When one or more types get mocked non-strictly in a test, we often end up with a non-empty verification phase.
//        new Verifications() {
//            {
//                new SomeOtherClass(anyString);
//                times = 0;
//            }
//        };
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

