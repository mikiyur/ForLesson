package hw10;

public class Rectangle {
	private float haight;
	private float lenght;
	private String colour;

	public Rectangle(float haight, float lenght, String colour) {
		this.haight = haight;
		this.lenght = lenght;
		this.colour = colour;
	}

	public float getHaight() {
		return haight;
	}

	public void setHaight(float haight) {
		this.haight = haight;
	}

	public float getLenght() {
		return lenght;
	}

	public void setLenght(float lenght) {
		this.lenght = lenght;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public float perimeter() {
		return (lenght + haight) * 2;
	}

	public float area() {
		return (lenght * haight);
	}

	public void print() {
		System.out.println("Rectangle:  \ncolour - " + colour + "  lenght - " + lenght + "  haight - " + haight);
		System.out.println("Perimrter - " + perimeter() + "  Area - " + area() + "\n");
	}
}
