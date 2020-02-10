package hw14;

public class Main {

	public static void main(String[] args) {
		
		String string = "Java (вимовляється Джава[4]) — об'єктно-орієнтована \n "
				+ "мова програмування, випущена 1995 року компанією «Sun Microsystems» \n"
				+ " як основний компонент платформи Java. З 2009 року мовою займається \n"
				+ " компанія «Oracle», яка того року придбала «Sun Microsystems». \n "
				+ "В офіційній реалізації Java-програми компілюються у байт-код,\n"
				+ " який при виконанні інтерпретується віртуальною машиною для\n"
				+ " конкретної платформи.";
		
		int key = 4529;
		EncryptedString letter = new EncryptedString(string, key);
		
		
		System.out.println(letter.getEncryptedString(key));

		
//		System.out.println(letter.getDecryptedString(key));

	}

}
