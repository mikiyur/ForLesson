package hw18;

public class Main {

	public static void main(String[] args) {
		MyArrayList<Integer> myArr1 = new MyArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
			myArr1.add(i);
		}
		
		MyArrayList<String> myArr2 = new MyArrayList<String>();		
		for (int i = 0; i < 12; i++) {
			myArr2.add(i+"s");
		}
		System.out.println(myArr1);
		System.out.println(myArr2);
		
		System.out.println("Test get (index 3) - " +  myArr2.get(3));
		System.out.println("Test contains (\"11s\") - "+ myArr2.contains("11s"));
		System.out.println("Test contains (\"12s\") - "+ myArr2.contains("12s"));

		System.out.println();
	}

}
