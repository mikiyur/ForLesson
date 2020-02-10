package hw4;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = sc.nextInt();
		long j1 = 1;
		long j2 = 0;
		long k = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(k += j1);
			j1 = j2;
			j2 = k;
		}
		sc.close();
	}

}
