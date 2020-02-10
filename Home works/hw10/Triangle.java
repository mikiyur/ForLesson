package hw10;

public class Triangle {
	
	private float sideA;
	private float sideB;
	private float sideC;
	private String colour;
	
	public Triangle(float sideA, float sideB, float sideC, String colour) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.colour = colour;
	}

	public float getSideA() {
		return sideA;
	}

	public void setSideA(float sideA) {
		this.sideA = sideA;
	}

	public float getSideB() {
		return sideB;
	}

	public void setSideB(float sideB) {
		this.sideB = sideB;
	}

	public float getSideC() {
		return sideC;
	}

	public void setSideC(float sideC) {
		this.sideC = sideC;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public float perimeter() {
		return (sideA + sideB + sideC);
	}

	public float area() {
		return (float)Math.sqrt((perimeter()/2)*((perimeter()/2) - sideA)*((perimeter()/2) - sideB)*((perimeter()/2) - sideC));
		

	}

	public void print() {
		System.out.println("Triangle:  \ncolour - " + colour + "  sides:  a = " + sideA+ "  b = "+ sideB+ "  c = "+ sideC);
		System.out.println("Perimrter - " + perimeter() + "  Area - " + area() + "\n");
	}

}
