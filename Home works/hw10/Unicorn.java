package hw10;

public class Unicorn {
	
	private String name;
	private String colour;
	private int age;
	private int weight;
	private boolean isHangry = true;
	private boolean isDirty = true;
	
	public Unicorn(String name, String colour, int age, int weight) {
		this.name = name;
		this.colour = colour;
		this.age = age;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void walk() {
		System.out.println("�� �������� " + name);
	}
	
	public void feed() {
		System.out.println(isHangry?("\n�� ��������� " + name): ("\n"+name + " �� ���� ����") );
		isHangry = false;
	}
	public void wash() {
		System.out.println(isDirty?("\n�� ������ " + name):("\n"+name + " �� ����� ����"));
		isDirty = false;
	}
	
	public void print() {
		System.out.println("\nUnicorn:\n name - " + name + "\n colour - " + colour + "\n age - " + age + "\n weight - " + weight);
		System.out.println("�������� - "+(isHangry?"���":"ͳ"));
		System.out.println("������ - "+(isDirty?"ͳ":"���"));
	}


}
