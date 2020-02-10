package hw24;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		MyMap <Integer,String> map = new MyMap <Integer,String>();
		
		System.out.println("\n\t-------------  \t1  --------------");
		map.add(1, "one");
		map.add(2, "two");
		map.add(3, "tree");
		map.add(4, "four");
		map.printMap();
		System.out.println("\n\n\t-------------  \t2  --------------");		
		map.add(1, "first");
		map.printMap();
		System.out.println("\n\n\t-------------  \t3  --------------");				
		map.removeKey(4);
		map.removeValue("tree");
		map.printMap();
		System.out.println("\n\n\t-------------  \t4  --------------");			
		map.printAllKeys();
		map.printAllValue();

		
	}

}
