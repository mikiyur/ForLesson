package hw10;



public class Main {

	public static void main(String[] args) {
		System.out.println("\n---------------- Part 1 ----------------------\n");

		Rectangle rectangle_1 = new Rectangle(10, 10, "Red");		
		Rectangle rectangle_2 = new Rectangle(55.5f, 43.1f, "Blue");
		rectangle_1.print();
		rectangle_2.print();
		Triangle triangle_1 = new Triangle(10, 10, 10, "Black");
		Triangle triangle_2 = new Triangle(22.2f, 15.1f, 33.3f, "White");
		triangle_1.print();
		triangle_2.print();

		System.out.println("\n\n---------------- Part 2 ----------------------\n");
		Car car_1 = new Car("BMW", "X3", "Black", 320, 1850);
		Car car_2 = new Car("BMW", "X5", "White", 280, 2200);
		Car car_3 = new Car("Mazda", "miata", "Red", 380, 2020);
		car_1.move();
		car_1.print();
		car_2.print();
		car_3.print();
		
		Unicorn unicor_1 = new Unicorn("Petro", "Brown", 3, 330);
		Unicorn unicor_2 = new Unicorn("Oleg", "Pink", 5, 360);
		Unicorn unicor_3 = new Unicorn("Yura", "White", 1, 150);
		unicor_1.print();
		unicor_2.print();
		unicor_3.print();
		unicor_1.feed();
		unicor_1.feed();
		unicor_1.wash();
		unicor_1.print();
	}

}
