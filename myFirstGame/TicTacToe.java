package project1;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] field = new char[100];
        char[] fieldLast = new char[100];
        char[] playersIcon = {'X', 'O', '+', '-'};
        int[] computerPriority = new int[100];
        String[] namePlayers = {"����1", "����2", "����3", "����4"};
        String[] playersSkoreNames = new String[10];
        int[] scoreTab = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean computerStrong = true;
        char reply = 'Y';
        boolean go = true;
        int quantityPlayers = 2;
        int quantityField = 3;

        do {

            System.out.println("���� - " + quantityField + "x" + quantityField);
            System.out.println("ʳ������ ������� - " + quantityPlayers);
            for (int k = 0; k < quantityPlayers; k++) {
                System.out.println("������� " + "   " + namePlayers[k] + " " + playersIcon[k]);
            }
            System.out.println("----------------");
            System.out.println("------����------");
            System.out.println("1 - ����� �������");
            System.out.println("2 - ������ ������� �������");
            System.out.println("3 - ������ ����� ����");
            System.out.println("4 - ������ �������");
            System.out.println("5 - ������ ���� ����'������� ������");
            System.out.println("6 - ������� �� ����� ���� �������");
            System.out.println("0 - ��������� ���");

            switch (sc.nextInt()) {
                // -----------------------------��������� ���
                case (0):
                    go = false;
                    break;

                case (1):
                    // -----------------------------C���� �������

                    reply = 'y';
                    while (reply == 'Y' || reply == 'y') {
                        field = clearField(field);
                        fieldLast = clearField(fieldLast);

                        printField(field, quantityField);
                        for (int i = 0; i < quantityPlayers; i++) {
                            System.out.println(
                                    " --- ������ ������� " + (i + 1) + "   " + playersIcon[i] + " " + namePlayers[i]);
                            int indexField = 0;
                            if (namePlayers[i].substring(0, 4).equals("����")) {
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
                                    System.out.println("������ 0 ��� ������� ������� ���:");
                                    System.out.println("������ ������ ���� xy:");
                                    System.out.println("x - �������������� ����� �����:");
                                    System.out.println("y - ������������ ����� �����:");
                                    indexField = sc.nextInt();

                                    if (indexField == 0 && !Arrays.equals(fieldLast, field)) {

                                        int lastPlayer = (i == 0) ? quantityPlayers - 1 : i - 1;


                                        if (!namePlayers[lastPlayer].substring(0, 4).equals("����")) {

                                            i = lastPlayer;
                                            field = fieldLast.clone();
                                            printField(field, quantityField);
                                            System.out.println("��� �������");
                                            System.out.println(
                                                    " --- ������ ������� " + "   " + playersIcon[i] + " " + namePlayers[i]);
                                        }
                                    } else {
                                        fieldLast = field.clone();
                                    }

                                } while (!checkIsFieldFree(field, indexField, quantityField));

                                field[indexField] = playersIcon[i];
                            }

                            printField(computerPriority, quantityField); // ��������� �� �����
                            printField(field, quantityField);

                            if (isWinner(field, indexField, playersIcon[i], quantityField)) {
                                System.out.println(namePlayers[i] + " ����������,  ²�����! ");
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
                                System.out.println("��������� ����, ���� ���������");
                                break;
                            }
                            if (i == (quantityPlayers - 1)) {
                                i = -1;
                            }

                        }
                        do {
                            System.out.println("��������� ���?   Y - ���,   N - �");
                            reply = sc.next().charAt(0);
                        } while (!checkChar(reply));
                    }
                    break;

                case (2):
                    // ---------������� �������

                    System.out.println("������ ������� ������� (2, 3, 4): ");
                    while (true) {
                        quantityPlayers = sc.nextInt();
                        if (quantityPlayers < 5 && quantityPlayers > 1) {
                            break;
                        }
                        System.out.println("��������� ����� (2, 3 ��� 4 ������)");
                    }
                    break;

                case (3):
                    // ---------����� ����
                    System.out.println("������� ����� ���� �� 3 �� 9 (N - N�N): ");
                    while (true) {
                        quantityField = sc.nextInt();
                        if (quantityField < 10 && quantityField > 2) {
                            break;
                        }
                        System.out.println("��������� ����� (3 - 3�3........9 - 9�9)");
                    }
                    break;

                case (4):
                    // ---------������ �������

                    for (int i = 0; i < quantityPlayers; i++) {
                        char psVsPer;
                        do {
                            System.out.println("������� " + (i + 1) + " ���� ����'����?  Y - ����'����,   N - ������");
                            psVsPer = sc.next().charAt(0);
                        } while (!checkChar(psVsPer));

                        if (psVsPer == 'n' || psVsPer == 'N') {
                            System.out.println("������ ��'� " + (i + 1) + " ������");
                            sc.nextLine();
                            namePlayers[i] = sc.nextLine();
                        } else {
                            namePlayers[i] = "����'����";
                        }
                    }
                    break;

                case (5):
                    char psVsPer;
                    do {
                        System.out.println("������� ���� ����'�����?  Y - �������,   N - �������");
                        psVsPer = sc.next().charAt(0);
                    } while (!checkChar(psVsPer));
                    computerStrong = (psVsPer == 'y' || psVsPer == 'Y') ? true : false;
                    break;

                case (6):
                    // --------- ���� �� �����
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("--------------------------------");
                    System.out.println("---------���� �������-----------");
                    for (int k = 0; k < playersSkoreNames.length; k++) {
                        if (playersSkoreNames[k] != null) {
                            System.out.println((k + 1) + " ������� " + playersSkoreNames[k] + " �������� - " + scoreTab[k]);
                        }
                    }
                    System.out.println("--------------------------------");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    break;
            }
        } while (go);
        sc.close();
    }

    // �����--------------���������� ����������� ����� Yy?Nn?-------------

    static boolean checkChar(char yYnN) {
//		if (yYnN == 'Y' || yYnN == 'y' || yYnN == 'N' || yYnN == 'n') {
//			return true;
//		}
//		return false;
        return yYnN == 'Y' || yYnN == 'y' || yYnN == 'N' || yYnN == 'n';
    }

    // �����-------------������� ����--------------------------------------
    static char[] clearField(char[] field) {
        for (int i = 0; i < field.length; i++) {
            field[i] = ' ';
        }
        return field;
    }

    // �����--------------�������� ���� �� �����----------------------------
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

    // ����� ------------------�������� �� ��������-------------
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

    // ����� ------------------�������� �� ���� �����-------------
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

    // ����� ------------------�������� �� ������ � ����� ����-------------
    static boolean checkIsField(int indexField, int quantityField) {
        if (indexField / 10 < 1 || indexField / 10 > quantityField)
            return false;
        if (indexField % 10 < 1 || indexField % 10 > quantityField)
            return false;
        return true;
    }

    // ����� -----------------�������� �� ������ �� ��� ����� � � �����--------
    static boolean checkIsFieldFree(char[] field, int indexField, int quantityField) {
//		if (checkIsField(indexField, quantityField)) {
//			if (field[indexField] == ' ')
//				return true;
//		}
//		return false;
        return checkIsField(indexField, quantityField) && field[indexField] == ' ';
    }

    // ����� -----------------����������� ��������� ����'�����--------------
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
                            if (field[k] == icon) { // ����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 125;
                                if (lastCheck == 2)
                                    computerPriority[j] += 2;
                                lastCheck = 1;
                                lastCheckChar = field[k];
                            } else if (field[k] == ' ') { // �����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 2;
                                if (lastCheck == 3)
                                    computerPriority[j] += 1;
                                lastCheck = 2;
                                lastCheckChar = field[k];
                            } else {// ���� ?
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
                            if (field[k] == icon) { // ����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 125;
                                if (lastCheck == 2)
                                    computerPriority[j] += 2;
                                lastCheck = 1;
                                lastCheckChar = field[k];
                            } else if (field[k] == ' ') { // �����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 2;
                                if (lastCheck == 3)
                                    computerPriority[j] += 1;
                                lastCheck = 2;
                                lastCheckChar = field[k];
                            } else {// ���� ?
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
                            if (field[k] == icon) { // ����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 125;
                                if (lastCheck == 2)
                                    computerPriority[j] += 2;
                                lastCheck = 1;
                                lastCheckChar = field[k];
                            } else if (field[k] == ' ') { // �����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 2;
                                if (lastCheck == 3)
                                    computerPriority[j] += 1;
                                lastCheck = 2;
                                lastCheckChar = field[k];
                            } else {// ���� ?
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
                            if (field[k] == icon) { // ����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 125;
                                if (lastCheck == 2)
                                    computerPriority[j] += 2;
                                lastCheck = 1;
                                lastCheckChar = field[k];
                            } else if (field[k] == ' ') { // �����?
                                if (lastCheck == 1)
                                    computerPriority[j] += 2;
                                if (lastCheck == 3)
                                    computerPriority[j] += 1;
                                lastCheck = 2;
                                lastCheckChar = field[k];
                            } else {// ���� ?
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

    // �����2�--------------�������� ���� ��������� ��
    // �����----------------------------
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
