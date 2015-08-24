class ABC {
	private int x;
	private static int s;
}

.....
main(String[] args) {
	...
	ABC a1 = new ABC();
	ABC a2 = new ABC();
	ABC a3 = new ABC();               
}

//////////////////////////
FractionInterface x;
x = new Fraction;

///////////////////////
class Wrapper {
	private int value;
	...
	public Wrapper(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

main(..) {
	Wrapper w1 = new Wrapper(23);
	System.out.println(w1.getValue());
}


///////////////////////
c

main(..) {
	Wrapper<String> sw;
	sw = new Wrapper<String>("Hello");

	System.out.println(sw.getValue());
}

	Wrapper<Fraction> fw;
	fw = new Wrapper<Fraction>(new Fraction(1,2));

///////////////////////

public interface WrapperInterface<X> {
	public X getValue();
}

class Wrapper<X> implements WrapperInterface<X> {
	private X value;
	public Wrapper(X value) {
		this.value =  value;
	}

	public X getValue() {
		return value;
	}
}


main(...) {
	Wrapper<String> sw;
	sw = new Wrapper<String>("hello");

	WrapperInterface<Fraction> fw;
	fw = new Wrapper<Fraction>(new Fraction(1,2));
}

////////////////// X refer to incompleete data....identifier with scope

public interface ArrayWrapperInterface<X> {
	public X[] getArray();
}


class ArrayWrapper<T> implements ArrayWrapperInterface<T> {
	private T[] a
	
}






































