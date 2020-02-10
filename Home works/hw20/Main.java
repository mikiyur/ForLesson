package hw20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		ZooClub zooClub = criateZooClub();
		boolean exit = false;
		Person person;
		String name;
		Pet pet;
		while (!exit) {
			System.out.println("1. Додати учасника клубу\r\n" + "2. Додати тваринку до учасника клубу\r\n"
					+ "3. Видалити тваринку з учасника клубу\r\n" + "4. Видалити учасника з клубу\r\n"
					+ "5. Видалити конкретну тваринку зі всіх власників\r\n" + "6. Вивести на екран зооклуб\r\n"
					+ "7. Вийти з програми");

			switch (takeInteger(bufferedReader)) {
			case 1:
				person = new Person();
				System.out.println("Enter  name of new member:");
				person.setName(takeString(bufferedReader));
				System.out.println("Enter  age of new member :");
				person.setAge(takeInteger(bufferedReader));
				zooClub.getZooClub().put(person, new ArrayList<Pet>());
				break;
			case 2:
				System.out.println("Enter members name:");
				name = takeString(bufferedReader);
				person = takePersonByName(name, zooClub);
				if (person != null) {
					System.out.println("Enter name of new pet");
					String namePet = takeString(bufferedReader);
					System.out.println("Enter type of new pet");
					String typePet = takeString(bufferedReader);
					zooClub.getZooClub().get(person).add(new Pet(namePet, typePet));
					System.out.println("new Pet was added to " + person.getName());
				}
				break;
			case 3:
				System.out.println("Enter members name:");
				name = takeString(bufferedReader);
				person = takePersonByName(name, zooClub);
				if (person != null) {
					System.out.println("Enter pets name");
					String namePet = takeString(bufferedReader);
					pet = takePetByName(namePet, zooClub, person);
					if (pet != null) {
						zooClub.getZooClub().get(person).remove(pet);
					}
				}
				break;
			case 4:
				System.out.println("Enter members name:");
				name = takeString(bufferedReader);
				person = takePersonByName(name, zooClub);
				if (person != null) {
					zooClub.getZooClub().remove(person);
					System.out.println("Person  " + person.getName() + " was removed");
				}
				break;
			case 5:
				System.out.println("Enter type of new pet");
				String typePet = takeString(bufferedReader);
				for (int i = 0; i < zooClub.getZooClub().size(); i++) {
					person = (Person) zooClub.getZooClub().keySet().toArray()[i];
					List<Pet> listPet = zooClub.getZooClub().get(person);
					for (int j = 0; j < listPet.size(); j++) {
						if (typePet.equalsIgnoreCase(listPet.get(j).getType())) {
							System.out.println(listPet.get(j)+" was removed");						
							listPet.remove(j);

						}
					}
				}
				break;
			case 6:
				System.out.println(zooClub.getZooClub());
				break;
			case 7:
				exit = true;
				System.out.println("Good bye!!! ;p");
				break;
			}
		}
	}

	public static int takeInteger(BufferedReader bufferedReader) {
		int value = 0;
		try {
			value = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("It isn't Integer");
		}
		return value;
	}

	public static String takeString(BufferedReader bufferedReader) {
		String value = null;
		try {
			value = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("It isn't String");
		}
		return value;
	}

	public static Person takePersonByName(String name, ZooClub zooClub) {
		Person person = null;
		for (int i = 0; i < zooClub.getZooClub().size(); i++) {
			person = (Person) zooClub.getZooClub().keySet().toArray()[i];
			if (name.equalsIgnoreCase(person.getName())) {
				return person;
			}
		}
		System.out.println("No one is whith this name");
		return null;
	}

	public static Pet takePetByName(String name, ZooClub zooClub, Person person) {
		Pet pet = null;
		for (int i = 0; i < zooClub.getZooClub().get(person).size(); i++) {
			pet = zooClub.getZooClub().get(person).get(i);
			if (name.equalsIgnoreCase(pet.getName())) {
				return pet;
			}
		}
		System.out.println("No one is whith this name");
		return null;
	}

	public static ZooClub criateZooClub() {
		ZooClub zooClub = new ZooClub();
		zooClub.getZooClub().put(new Person("Vasia", 25), new ArrayList<Pet>());
		zooClub.getZooClub().put(new Person("Olia", 22), new ArrayList<Pet>());
		zooClub.getZooClub().put(new Person("Yura", 32), new ArrayList<Pet>());
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[0]).add(new Pet("Wulkan", "Dog"));
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[0]).add(new Pet("Vaska", "Cat"));
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[1]).add(new Pet("Rokky", "Dog"));
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[1]).add(new Pet("Kisa", "Cat"));
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[2]).add(new Pet("Graf", "Dog"));
		zooClub.getZooClub().get(zooClub.getZooClub().keySet().toArray()[2]).add(new Pet("Ryzyk", "Cat"));
		return zooClub;
	}

}
