package hw2;

import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int price = 80;
		System.out.println("Enter the number of thinks do you wont to buy:");
		int number = sc.nextInt();
		if (number < 0) {
			System.out.println("Yu made a mistake, go out!!!");

		} else if ((number * price) < 1000) {
			System.out.println("Yu have to pay " + (number * price) + "$");
		} else {
			System.out.println("Total prise - "+ (number * price) + "$" + " discount 10% - " + (number * price)*0.9f);
			System.out.println("Yu have to pay " + (number * price)*0.9f + "$");
		}
		sc.close();
	}
}
