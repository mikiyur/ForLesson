package hw20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooClub {
	private Map <Person, List<Pet>> zooClub;
	
	public ZooClub() {
		zooClub = new HashMap<Person, List<Pet>>();
	}

	public Map<Person, List<Pet>> getZooClub() {
		return zooClub;
	}

	public void setZooClub(Map<Person, List<Pet>> zooClub) {
		this.zooClub = zooClub;
	}

}
