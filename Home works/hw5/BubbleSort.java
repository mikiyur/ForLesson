package hw5;

public class BubbleSort {

//	Програма сортує введений масив цілих чисел 
//	за допомогою алгоритму бульбашкового сортування (Bubble Sort).

	public static void main(String[] args) {
		int[] arr = { 10, 45, 7, 63, 2, 78, 9, 78, 45, 99, 54, 12, 78, 9, 155, 124, 1, 15, 12, 3 };
		int m;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					m = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = m;
				}
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
