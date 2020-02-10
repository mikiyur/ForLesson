package hw3;

import java.util.Scanner;

public class Military {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		if (age < 1 || age > 120) {
			System.out.println("You have entered the wrong age");
		} else if (age < 21 || age > 60) {
			System.out.println("Your age is not appropriate for the military");
		} else if (age > 28) {
			System.out.println("You can get a job in the army under the contract");
		} else {
			System.out.println("You must be in the Army now");
		}
		sc.close();
	}

}
