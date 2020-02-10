package hw3;

import java.util.Scanner;

public class FormatTime {
	
//	long seconds = decade+year*2+month*3+day*4+hour*5+minute*6+7;	
	
	public static void main(String[] args) {
		int decade = 315360000;
		int year = 31536000;
		int month = 2592000;
		int day = 86400;
		int hour = 3600;
		int minute = 60;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter seconds: ");
		long seconds = sc.nextLong();
	
		if (seconds/decade!=0)System.out.println("Decades " + seconds/decade);
		if ((seconds%decade)/year!=0)System.out.println("Years " + (seconds%decade)/year);
		if ((seconds%year)/month!=0)System.out.println("Months " + (seconds%year)/month);
		if (((seconds%year)%month)/day!=0)System.out.println("Days " + ((seconds%year)%month)/day);
		if ((seconds%day)/hour!=0)System.out.println("Hours " + (seconds%day)/hour);
		if ((seconds%hour)/minute!=0)System.out.println("Minutes " + (seconds%hour)/minute);	
		if (seconds%minute!=0)System.out.println("Seconds " + seconds%minute);
		sc.close();
	}

}
