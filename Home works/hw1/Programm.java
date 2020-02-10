package hw1;

import java.util.HashSet;

public class Programm {

	public static void main(String[] args) {

		short s1 = 1;
		short s2 = 2;
		int i1 = 30;
		int i2 = 40;
		long l1 = 5;
		long l2 = 6;
		float f1 = 7.7f;
		float f2 = 8.8f;
		double d1 = 99.9;
		double d2 = 101.1;

		short sum = (short) (s2 + s1);
		int difference = i2 - i1;
		long product = l2 * l1;
		float division = f2 / f1;
		double module = d2 % d1;

		System.out.println("sum = " + sum);
		System.out.println("difference = " + difference);
		System.out.println("product = " + product);
		System.out.println("division = " + division);
		System.out.println("module = " + module);
		
		System.out.println("\n--------------------------------");
		int point = 10;
		int a = point + (int)(((1-1)/4d)*point);
		System.out.println(a);


		

	}

}
