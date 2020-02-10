package hw4;

import java.util.Scanner;

public class Euclide {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int n = sc.nextInt();
		int m =  sc.nextInt();
		while (n!=m) {
			if (m>n) m -= n;
			if (n>m) n -= m;
		}
		System.out.println(m);
		sc.close();
	}

}
