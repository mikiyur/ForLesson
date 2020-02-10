package hw5;

import java.util.Scanner;

//4. Програма, що заповнює масив введеного розміру рандомними 
//цілими числами в діапазоні [-9999; 9999]
//3. Програма шукає в масиві прості числа і виводить їх.

public class Primenumbe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tre number of length of array: ");
		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.round(Math.random() * 19998 - 9999);
		}
		for (int i : arr) {
			if (checkPrime(Math.abs(i))) System.out.println(i);
		}
		sc.close();
	}

	static boolean checkPrime(int i) {
		if (i == 0 || i == 1 || i == 2 || i == 3) {
			return true;
		} else {
			for (int j = 2; j <= Math.round(Math.sqrt(i)); j++) {
				if (0 == i % j) {
					return false;
				}
			}
			return true;
		}
	}
}
