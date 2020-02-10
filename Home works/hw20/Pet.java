package hw20;

public class Pet {
	private String name;
	private String type;
	
	public Pet(String name, String type) {
		this.name = name;
		this.type = type;
	}
	public Pet() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Pet name-" + name + ", type-" + type;
	}

}
