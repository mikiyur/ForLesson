package hw14;

public class EncryptedString {

	private String string;
	private UniqueKey uniqueKey;
	private int key;

	public EncryptedString(String string, int key) {
		this.key = key;
		uniqueKey = new UniqueKey(key);
		this.string = encryptString(string, key);

	}
	
	public String getDecryptedString(int key) {
		if (this.key!=key) {
			System.out.println("Key is wrong");
		}
		
		int[] encryptInt = CharToIntArray(string.toCharArray());

		for (int i = 0, j = 0; i < encryptInt.length; i++, j++) {
			encryptInt[i] = encryptInt[i] - uniqueKey.getUniqueKey(key)[j];
			if (j == (uniqueKey.getUniqueKey(key).length - 1)) {
				j = 0;
			}
		}
		return String.copyValueOf(IntToCharArray(encryptInt));		
	}
	
	public String getEncryptedString(int key) {
		return string;
	}
	
	private String encryptString(String string, int key) {
		int[] encryptInt = CharToIntArray(string.toCharArray());

		for (int i = 0, j = 0; i < encryptInt.length; i++, j++) {
			encryptInt[i] = encryptInt[i] + uniqueKey.getUniqueKey(key)[j];
			if (j == (uniqueKey.getUniqueKey(key).length - 1)) {
				j = 0;
			}
		}
		
		return String.copyValueOf(IntToCharArray(encryptInt));
	}

	private int[] CharToIntArray(char[] charArray) {
		int[] intArray = new int[charArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) charArray[i];
		}
		return intArray;
	}

	private char[] IntToCharArray(int[] intArray) {
		char[] charArray = new char[intArray.length];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = (char) intArray[i];
		}
		return charArray;
	}

}
