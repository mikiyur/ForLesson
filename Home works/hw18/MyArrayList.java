package hw18;



public class MyArrayList<T> {
	private T[] arr;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr = (T[]) new Object[10];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(T value) {
		try {
			if (size == arr.length) {
				T[] temp = arr;
				arr = (T[]) new Object[arr.length + (arr.length / 2)];
				System.arraycopy(temp, 0, arr, 0, temp.length);				
			}
			arr[size] = value;
			size++;
			return true;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public T get(int index){
		return arr[index];
	}
	public boolean contains (T value){
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
/*	public boolean sort() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i]>=arr[j]) {
				................................				
				}
			}
		}	
		return true;
	}
*/
	@Override
	public String toString() {
		String string = "MyArray ";
		for (int i = 0; i < size; i++) {
			string += arr[i]+ " ";
		}
		return string;

	}
	
}
