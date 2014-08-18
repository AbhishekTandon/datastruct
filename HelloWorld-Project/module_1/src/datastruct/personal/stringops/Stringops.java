package datastruct.personal.stringops;

public class Stringops {

	public static void main(String[] args) {
		String str = "some string to process ";
		char[] chars =  str.toCharArray();

		char[] repStr = ReplaceFun(chars, chars.length);

		for (char c: repStr) System.out.println("char >>" + c);
	}

	public static char[] ReplaceFun(char[] str, int length) {

		int spaceCount = 0, newLength, i = 0;

		for (i = 0; i < length; i++) {
			if (str[i] == ' '){
				spaceCount++;
			}
		}
		newLength = length + spaceCount * (3 - 1);
		char[] repStr = new char[newLength];
		for (i = length - 1; i >= 0; i--) {
			if (str[i] ==' '){
				repStr[newLength - 1] ='0';
				repStr[newLength - 2] ='2';
				repStr[newLength - 3] ='%';
				newLength = newLength - 3;
			} else {
				repStr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return repStr;
	}
}
