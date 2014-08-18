package datastruct.personal.integerOps;

public class IntegerToString {

	final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

	final static char [] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'} ;

	public static void main(String[] args) {
		int number = 1235761;
		System.out.println("printing the Integer MAX >>" + Integer.MAX_VALUE);
		System.out.println("printing the Integer MIN >>" + Integer.MIN_VALUE);

		System.out.println("printing String of integer >>" + int_to_string(number));
	}


	public static int stringSize(int number) {
		for(int i= 0; ; i++)
			if (number <=sizeTable[i]) return i+1;

	}

	/**refer to implementation to Integer.toString()*/
	public static String int_to_string(int number){
		int size = stringSize(number);
		char[] buffer = new char[size];


		while (number > 10) {
			int res = number - (number/10)*10;
			number = number/10;
			buffer[--size] = DigitOnes[res];
		}
		buffer[--size] = DigitOnes[number];

		return new String(buffer);
	}
}
