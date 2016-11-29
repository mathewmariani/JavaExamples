/**
 *	Docs:
 *	https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
 **/
public class ExceptionsExample {
	public static void main(String[] args) {
		int a[] = new int[2];

		try {
			// try to execute this statement
			System.out.println("Access element three :" + a[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			// we caught a specific exceptions, lets handle it.
			System.out.println("Exception thrown  :" + e);
		} catch(Exception e) {
			// an exception was thrown, but its more general.
			System.out.println("Exception thrown  :" + e);
		} finally {
			// the finally block is executed AFTER the try(-catch) block
			// whether or not an exception was thrown.
			System.out.println("finally statement is executed");
		}

		try {
			System.out.println("Access element one :" + a[1]);
		} catch(Exception e) {
			System.out.println("Exception thrown  :" + e);
		} finally {
			// notice how the exception wasn't thrown but this block was still executed.
			System.out.println("finally statement is executed");
		}
	}
}
