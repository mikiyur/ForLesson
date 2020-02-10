package hw2;

import java.util.Scanner;

public class StudentsTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of your points");
		int points = sc.nextInt();

		System.out.println("-----------  option 1  ------------");

		if ((points + 100) % 15 == 0 && points <= 200 && points >= -100) {
			System.out.println("You answered " + (points + 100) / 15 + " questions correctly");
		} else {
			System.out.println("You have entered the wrong number of points");
		}

		System.out.println("\n\n-----------  option 2  ------------");

		System.out.println("You answered " + (points + 100) / 15f + " questions correctly");
		sc.close();
	}

}
