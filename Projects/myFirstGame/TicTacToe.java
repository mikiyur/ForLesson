package project1;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] field = new char[100];
		char[] fieldLast = new char[100];
		char[] playersIcon = { 'X', 'O', '+', '-' };
		int[] computerPriority = new int[100];
		String[] namePlayers = { "Комп1", "Комп2", "Комп3", "Комп4" };
		String[] playersSkoreNames = new String[10];
		int[] scoreTab = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		boolean computerStrong = true;
		char reply = 'Y';
		boolean go = true;
		int quantityPlayers = 2;
		int quantityField = 3;

		do {

			System.out.println("Поле - " + quantityField + "x" + quantityField);
			System.out.println("Кількість гравців - " + quantityPlayers);
			for (int k = 0; k < quantityPlayers; k++) {
				System.out.println("Гравець " + "   " + namePlayers[k] + " " + playersIcon[k]);
			}
			System.out.println("----------------");
			System.out.println("------МЕНЮ------");
			System.out.println("1 - Старт поєдинку");
			System.out.println("2 - Змінити кількість гравців");
			System.out.println("3 - Змінити розмір поля");
			System.out.println("4 - Змінити Гравців");
			System.out.println("5 - Змінити силу комп'ютерних гавців");
			System.out.println("6 - Вивести на екран бали гравців");
			System.out.println("0 - Завершити гру");

			switch (sc.nextInt()) {
			// -----------------------------Завершуємо гру
			case (0):
				go = false;
				break;

			case (1):
				// -----------------------------Cтарт поєдинку

				reply = 'y';
				while (reply == 'Y' || reply == 'y') {
					field = clearField(field);
					fieldLast = clearField(fieldLast);

					printField(field, quantityField);
					for (int i = 0; i < quantityPlayers; i++) {
						System.out.println(
								" --- Ходить гравець " + (i + 1) + "   " + playersIcon[i] + " " + namePlayers[i]);
						int indexField = 0;
						if (namePlayers[i].substring(0, 4).equals("Комп")) {
							computerPriority = priorityCourse(computerPriority, field, playersIcon[i], quantityField);
							if (!computerStrong) {
								do {
									indexField = (int) Math.round((Math.random() * (quantityField - 1) * 11) + 11);
								} while (!checkIsFieldFree(field, indexField, quantityField));
								field[indexField] = playersIcon[i];
							} else {
								int maxIndex = 0;
								for (int j = 0; j < computerPriority.length; j++) {
									if (computerPriority[j] >= maxIndex && checkIsFieldFree(field, j, quantityField)) {
										maxIndex = computerPriority[j];
										indexField = j;
									}
								}
								do {
									indexField = (int) Math.round((Math.random() * (quantityField - 1) * 11) + 11);
								} while (computerPriority[indexField] != maxIndex
										|| !checkIsFieldFree(field, indexField, quantityField));
								field[indexField] = playersIcon[i];
							}

						} else {

							do {
								System.out.println("Введіть 0 щоб відмінити останній хід:");
								System.out.println("Введіть індекс поля xy:");
								System.out.println("x - горизонтальний номер рядка:");
								System.out.println("y - вертикальний номер рядка:");
								indexField = sc.nextInt();

								if (indexField == 0 && !Arrays.equals(fieldLast, field)) {

									int lastPlayer = (i == 0) ? quantityPlayers - 1 : i-1;


									if (!namePlayers[lastPlayer].substring(0, 4).equals("Комп")) {

										i = lastPlayer;
										field = fieldLast.clone();
										printField(field, quantityField);
										System.out.println("хід відмінено");
										System.out.println(
												" --- Ходить гравець " + "   " + playersIcon[i] + " " + namePlayers[i]);
									}
								} else {
									fieldLast = field.clone();
								}

							} while (!checkIsFieldFree(field, indexField, quantityField));

							field[indexField] = playersIcon[i];
						}

						printField(computerPriority, quantityField); // Пріоритети на екран
						printField(field, quantityField);

						if (isWinner(field, indexField, playersIcon[i], quantityField)) {
							System.out.println(namePlayers[i] + " ПЕРЕМОЖЕЦЬ,  ВІТАЄМО! ");
							for (int j = 0; j < playersSkoreNames.length; j++) {
								if (namePlayers[i].equalsIgnoreCase(playersSkoreNames[j])) {
									scoreTab[j]++;
									break;
								}
								if (playersSkoreNames[j] == null) {
									playersSkoreNames[j] = namePlayers[i];
									scoreTab[j]++;
									break;
								}
							}

							break;
						}
						if (isFull(field, quantityField)) {
							System.out.println("Переможця немає, поле заповнене");
							break;
						}
						if (i == (quantityPlayers - 1)) {
							i = -1;
						}

					}
					do {
						System.out.println("Повторити гру?   Y - так,   N - ні");
						reply = sc.next().charAt(0);
					} while (!checkChar(reply));
				}
				break;

			case (2):
				// ---------кількість гравців

				System.out.println("Введіть кількість гравців (2, 3, 4): ");
				while (true) {
					quantityPlayers = sc.nextInt();
					if (quantityPlayers < 5 && quantityPlayers > 1) {
						break;
					}
					System.out.println("Спробуйте знову (2, 3 або 4 гравці)");
				}
				break;

			case (3):
				// ---------розмір поля
				System.out.println("Виберіть розмір поля від 3 до 9 (N - NхN): ");
				while (true) {
					quantityField = sc.nextInt();
					if (quantityField < 10 && quantityField > 2) {
						break;
					}
					System.out.println("Спробуйте знову (3 - 3х3........9 - 9х9)");
				}
				break;

			case (4):
				// ---------змінити гравців

				for (int i = 0; i < quantityPlayers; i++) {
					char psVsPer;
					do {
						System.out.println("Гравцем " + (i + 1) + " буде комп'ютер?  Y - Комп'ютер,   N - Людина");
						psVsPer = sc.next().charAt(0);
					} while (!checkChar(psVsPer));

					if (psVsPer == 'n' || psVsPer == 'N') {
						System.out.println("Введіть ім'я " + (i + 1) + " гравця");
						sc.nextLine();
						namePlayers[i] = sc.nextLine();
					} else {
						namePlayers[i] = "Комп'ютер";
					}
				}
				break;

			case (5):
				char psVsPer;
				do {
					System.out.println("Виберіть силу комп'ютера?  Y - Сильний,   N - Слабкий");
					psVsPer = sc.next().charAt(0);
				} while (!checkChar(psVsPer));
				computerStrong = (psVsPer == 'y' || psVsPer == 'Y') ? true : false;
				break;

			case (6):
				// --------- бали на екран
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("--------------------------------");
				System.out.println("---------Бали Гравців-----------");
				for (int k = 0; k < playersSkoreNames.length; k++) {
					if (playersSkoreNames[k] != null) {
						System.out.println((k + 1) + " Гравець " + playersSkoreNames[k] + " Перемоги - " + scoreTab[k]);
					}
				}
				System.out.println("--------------------------------");
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				break;
			}
		} while (go);
		sc.close();
	}

	// Метод--------------Перевіряємо правильність вводу Yy?Nn?-------------

	static boolean checkChar(char yYnN) {
//		if (yYnN == 'Y' || yYnN == 'y' || yYnN == 'N' || yYnN == 'n') {
//			return true;
//		}
//		return false;
		return yYnN == 'Y' || yYnN == 'y' || yYnN == 'N' || yYnN == 'n';
	}

	// Метод-------------Очищаємо поле--------------------------------------
	static char[] clearField(char[] field) {
		for (int i = 0; i < field.length; i++) {
			field[i] = ' ';
		}
		return field;
	}

	// Метод--------------Виводимо поле на екран----------------------------
	static void printField(char[] field, int quantityField) {
		System.out.println("\n\n\n\n\n\n\n");

		for (int i = 11; i < (quantityField + 1) * 10; i = i + 10) {
			for (int j = i; j < quantityField + i; j++) {
				if (j == quantityField + i - 1) {
					System.out.println(" " + field[j]);
				} else {
					System.out.print(" " + field[j] + " |");
				}
			}
			if (i / 10 != quantityField) {
				for (int j = 0; j < quantityField; j++) {
					System.out.print("--- ");
				}
			}
			System.out.println();
		}
	}

	// Метод ------------------Перевірка на перемогу-------------
	static boolean isWinner(char[] field, int indexField, char icon, int quantityField) {
		int winIs3 = 0;
		for (int i = indexField - 2; i <= indexField + 2; i++) {
			if (checkIsField(i, quantityField)) {
				if (field[i] == icon) {
					winIs3++;
				} else {
					winIs3 = 0;
				}
			}
			if (winIs3 > 2)
				return true;
		}
		winIs3 = 0;
		for (int i = indexField - 22; i <= indexField + 22; i += 11) {
			if (checkIsField(i, quantityField)) {
				if (field[i] == icon) {
					winIs3++;
				} else {
					winIs3 = 0;
				}
			}
			if (winIs3 > 2)
				return true;
		}
		winIs3 = 0;
		for (int i = indexField - 20; i <= indexField + 20; i += 10) {
			if (checkIsField(i, quantityField)) {
				if (field[i] == icon) {
					winIs3++;
				} else {
					winIs3 = 0;
				}
			}
			if (winIs3 > 2)
				return true;
		}
		winIs3 = 0;
		for (int i = indexField - 18; i <= indexField + 18; i += 9) {
			if (checkIsField(i, quantityField)) {
				if (field[i] == icon) {
					winIs3++;
				} else {
					winIs3 = 0;
				}
			}
			if (winIs3 > 2)
				return true;
		}

		return false;
	}

	// Метод ------------------Перевірка чи поле повне-------------
	static boolean isFull(char[] field, int quantityField) {
		for (int i = 11; i <= 55; i++) {
			if (checkIsField(i, quantityField)) {
				if (field[i] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	// Метод ------------------Перевірка чи комірка в межах поля-------------
	static boolean checkIsField(int indexField, int quantityField) {
		if (indexField / 10 < 1 || indexField / 10 > quantityField)
			return false;
		if (indexField % 10 < 1 || indexField % 10 > quantityField)
			return false;
		return true;
	}

	// Метод -----------------Перевірка чи комірка на полі вільна і в межах--------
	static boolean checkIsFieldFree(char[] field, int indexField, int quantityField) {
//		if (checkIsField(indexField, quantityField)) {
//			if (field[indexField] == ' ')
//				return true;
//		}
//		return false;
		return checkIsField(indexField, quantityField) && field[indexField] == ' ';
	}

	// Метод -----------------розстановка пріоритетів комп'ютера--------------
	static int[] priorityCourse(int[] computerPriority, char[] field, char icon, int quantityField) {
		for (int i = 0; i < computerPriority.length; i++) {
			computerPriority[i] = 0;
		}
		for (int i = 11; i < (quantityField + 1) * 10; i = i + 10) {
			for (int j = i; j < quantityField + i; j++) {
				int lastCheck = 0;
				char lastCheckChar = ' ';
				if (checkIsFieldFree(field, j, quantityField)) {

					for (int k = j - 2; k <= j + 2; k++) {
						if (checkIsField(k, quantityField) && k != j) {
							if (field[k] == icon) { // Своя?
								if (lastCheck == 1)
									computerPriority[j] += 125;
								if (lastCheck == 2)
									computerPriority[j] += 2;
								lastCheck = 1;
								lastCheckChar = field[k];
							} else if (field[k] == ' ') { // Пуста?
								if (lastCheck == 1)
									computerPriority[j] += 2;
								if (lastCheck == 3)
									computerPriority[j] += 1;
								lastCheck = 2;
								lastCheckChar = field[k];
							} else {// Чужа ?
								if (lastCheck == 2)
									computerPriority[j] += 1;
								if (lastCheck == 3 && field[k] == lastCheckChar)
									computerPriority[j] += 18;
								lastCheck = 3;
								lastCheckChar = field[k];

							}
						}
					}
					lastCheck = 0;
					lastCheckChar = ' ';

					for (int k = j - 22; k <= j + 22; k += 11) {
						if (checkIsField(k, quantityField) && k != j) {
							if (field[k] == icon) { // Своя?
								if (lastCheck == 1)
									computerPriority[j] += 125;
								if (lastCheck == 2)
									computerPriority[j] += 2;
								lastCheck = 1;
								lastCheckChar = field[k];
							} else if (field[k] == ' ') { // Пуста?
								if (lastCheck == 1)
									computerPriority[j] += 2;
								if (lastCheck == 3)
									computerPriority[j] += 1;
								lastCheck = 2;
								lastCheckChar = field[k];
							} else {// Чужа ?
								if (lastCheck == 2)
									computerPriority[j] += 1;
								if (lastCheck == 3 && field[k] == lastCheckChar)
									computerPriority[j] += 18;
								lastCheck = 3;
								lastCheckChar = field[k];

							}
						}

					}
					lastCheck = 0;
					lastCheckChar = ' ';
					for (int k = j - 20; k <= j + 20; k += 10) {
						if (checkIsField(k, quantityField) && k != j) {
							if (field[k] == icon) { // Своя?
								if (lastCheck == 1)
									computerPriority[j] += 125;
								if (lastCheck == 2)
									computerPriority[j] += 2;
								lastCheck = 1;
								lastCheckChar = field[k];
							} else if (field[k] == ' ') { // Пуста?
								if (lastCheck == 1)
									computerPriority[j] += 2;
								if (lastCheck == 3)
									computerPriority[j] += 1;
								lastCheck = 2;
								lastCheckChar = field[k];
							} else {// Чужа ?
								if (lastCheck == 2)
									computerPriority[j] += 1;
								if (lastCheck == 3 && field[k] == lastCheckChar)
									computerPriority[j] += 18;
								lastCheck = 3;
								lastCheckChar = field[k];

							}
						}

					}
					lastCheck = 0;
					lastCheckChar = ' ';
					for (int k = j - 18; k <= j + 18; k += 9) {
						if (checkIsField(k, quantityField) && k != j) {
							if (field[k] == icon) { // Своя?
								if (lastCheck == 1)
									computerPriority[j] += 125;
								if (lastCheck == 2)
									computerPriority[j] += 2;
								lastCheck = 1;
								lastCheckChar = field[k];
							} else if (field[k] == ' ') { // Пуста?
								if (lastCheck == 1)
									computerPriority[j] += 2;
								if (lastCheck == 3)
									computerPriority[j] += 1;
								lastCheck = 2;
								lastCheckChar = field[k];
							} else {// Чужа ?
								if (lastCheck == 2)
									computerPriority[j] += 1;
								if (lastCheck == 3 && field[k] == lastCheckChar)
									computerPriority[j] += 18;
								lastCheck = 3;
								lastCheckChar = field[k];

							}
						}

					}

				}
			}

		}
		return computerPriority;
	}

	// Метод2х--------------Виводимо поле приориетів на
	// екран----------------------------
	static void printField(int[] field, int quantityField) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		for (int i = 11; i < (quantityField + 1) * 10; i = i + 10) {
			for (int j = i; j < quantityField + i; j++) {
				if (j == quantityField + i - 1) {
					System.out.println(" " + field[j]);
				} else {
					System.out.print(" " + field[j] + " |");
				}
			}
			if (i / 10 != quantityField) {
				for (int j = 0; j < quantityField; j++) {
					System.out.print("--- ");
				}
			}
			System.out.println();
		}
	}
}
