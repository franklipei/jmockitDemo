public final class SomeClass
{
    SomeOtherClass other;

//    public SomeOtherClass getOther() {
//        return mock;
//    }
//
//    public void setOther(SomeOtherClass mock) {
//        this.mock = mock;
//    }

//    SomeClass(SomeOtherClass mock){
//        this.mock = mock;
//    }


    int i;
    int someIntegralProperty;


    SomeClass(int someIntegralProperty1, int someIntegralProperty2){
        this.someIntegralProperty = someIntegralProperty1;
        this.someIntegralProperty = someIntegralProperty2;
    }

	public String doSomething(int i)
	{
//		SomeOtherClass mock = new SomeOtherClass("data");
        System.out.println("instance mock of SomeOtherClass is " + other.toString() + other.performSomeOperation(1));
		return other.performSomeOperation(i);
	}
}
