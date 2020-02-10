package hw5;

import java.util.Scanner;

public class RacoinalN {
	
//	1. Користувач вводить число n і n різних раціональних чисел.
//	Всі числа треба записати в масив розміром n. 
//	Програма рахує і виводить на екран найменше, найбільша та 
//	середнє арифметичне значення всіх чисел масиву.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tre number of length of array: ");
		float[] arr = new float[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter a rational number: ");
			arr[i] = sc.nextFloat();
		}
		float max = arr[0];
		float min = arr[0];
		float mid = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			mid += arr[i];
		}
		System.out.println("Max = " + max + "  Min = " + min + "  Arithmetic mean = " + mid / arr.length);
		sc.close();
	}

}
