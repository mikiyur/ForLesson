package hw23;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("Hello");
		
		
		List <Integer> listInt = new ArrayList<Integer>(list);
		listInt.add(1);
		listInt.add(2);
		listInt.add(listInt.get(1)+listInt.get(2));

		System.out.println(listInt);

	}

}
