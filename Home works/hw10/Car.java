package hw10;

public class Car {
	
	private String brand;
	private String	model;
	private String	color;
	private int	maxSpeed;
	private int	weight;
	private boolean isMove = false;
	
	
	
	
	public Car(String brand, String model, String color, int maxSpeed, int weight) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
	}
	
	

	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getMaxSpeed() {
		return maxSpeed;
	}



	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}



	public int getWeight_Kg() {
		return weight;
	}



	public void setWeight_Kg(int weight_Kg) {
		this.weight = weight_Kg;
	}



	public void move() {
		System.out.println(isMove? "Машина вже в дорозі":"Машина поїхала"); 
		isMove = true;		
	}
	
	public void stop() {
		System.out.println(isMove? "Машина вже стоїть":"Машина зупинилась"); 
		isMove = false;		
	}
	
	
	public void print() {
		System.out.println("\nCar\n brand- " + brand + "\n model - " + model + "\n color - " + color + "\n maxSpeed - " + maxSpeed
				+ "km/h\n weight_Kg - " + weight + "kg\n В дорозі - " + (isMove?"Так":"Ні"));
		
	}

	
}
