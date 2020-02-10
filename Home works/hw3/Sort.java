package hw3;

import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tree numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int loop = 2;
		int max;
		while (loop > 0) {
			if (a > b) {
				max = b;
				b = a;
				a = max;
			}
			if (b > c) {
				max = c;
				c = b;
				b = max;
			}
			loop--;
		}
		System.out.println(a + " " + b + " " + c);
		sc.close();
	}
}
