package hw14;

import java.util.Random;

public class UniqueKey {

	private int[] uniqueKey = new int[10];
	public Random rand = new Random();

	public UniqueKey(int key) {
		for (int i = 0; i < uniqueKey.length; i++) {
			uniqueKey[i] = rand.nextInt(999);
		}
		encryptUniqueKey(key);
	}
	
	public int[] getUniqueKey(int key) {
		return decryptUniqueKey(key);
	}

	private void encryptUniqueKey(int key) {
		for (int i = 0; i < uniqueKey.length; i++) {
			uniqueKey[i] = uniqueKey[i]+key;
		}
/*Тут зберігатимемо зашифрований ключ в файл і очистимо цей ключ	
		for (int i = 0; i < uniqueKey.length; i++) {
			uniqueKey[i] = 0;}*/		
	}

	private  int[] decryptUniqueKey(int key) {
//		Тут зчитаємо зашифрований ключ з файла
		int[] decryptionUniqueKey = uniqueKey.clone();
		for (int i = 0; i < decryptionUniqueKey.length; i++) {
			decryptionUniqueKey[i] = decryptionUniqueKey[i]-key;
		}	
		return decryptionUniqueKey;
	}
}
