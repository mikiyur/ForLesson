package hw2;

import java.util.Scanner;

public class QEquation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Solve the quadratic equation of the type: a(x^2)+bx+c=0");

		System.out.println("Enter the a: ");
		float a = sc.nextFloat();

		System.out.println("Enter the b: ");
		float b = sc.nextFloat();

		System.out.println("Enter the c: ");
		float c = sc.nextFloat();

		if (a == 0) {
			System.out.println("It`s linear equation: bx+c=0");
			System.out.println("x = " + (-c) / b);
			
		} else {
			if (b == 0 && c == 0) {
				System.out.println("It`s not a complete quadratic equation: a(x^2)=0");
				System.out.println("x = 0");
				
			} else if (b == 0) {
				System.out.println("It`s not a complete quadratic equation: a(x^2)+c=0");
				if (-c / a > 0) {
					System.out.println("x1 = " + Math.sqrt((-c) / a) + "  x2 = " + (-Math.sqrt((-c)) / a));
				} else {
					System.out.println("quadratic equation no has valid solutions");
				}

			} else if (c == 0) {
				System.out.println("It`s not a complete quadratic equation: a(x^2)+bx=0");
				System.out.println("x1 = 0  x2 = " + (-b) / a);
				
			} else {
				System.out.println("It`s complete quadratic equation: a(x^2)+bx+c=0");
				double d = ((b * b) - (4 * a * c));
				System.out.println("Discriminant  D = " + d);
				if (d < 0) {
					System.out.println("quadratic equation no has valid solutions");
				} else if (d == 0) {
					System.out.println("x1 = x2 = " + (-b) / (2 * a));
				} else {
					System.out.println("x1 = " + ((-b)+Math.sqrt(d))/(2*a) + "  x2 = " + (((-b)-Math.sqrt(d)))/(2*a));
				}
			}
		}
		sc.close();
	}
}
