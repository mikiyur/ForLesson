package hw14;

public class Main {

	public static void main(String[] args) {
		
		String string = "Java (������������ �����[4]) � ��'�����-��������� \n "
				+ "���� �������������, �������� 1995 ���� ������� �Sun Microsystems� \n"
				+ " �� �������� ��������� ��������� Java. � 2009 ���� ����� ��������� \n"
				+ " ������� �Oracle�, ��� ���� ���� �������� �Sun Microsystems�. \n "
				+ "� �������� ��������� Java-�������� ����������� � ����-���,\n"
				+ " ���� ��� �������� �������������� ���������� ������� ���\n"
				+ " ��������� ���������.";
		
		int key = 4529;
		EncryptedString letter = new EncryptedString(string, key);
		
		
		System.out.println(letter.getEncryptedString(key));

		
//		System.out.println(letter.getDecryptedString(key));

	}

}
