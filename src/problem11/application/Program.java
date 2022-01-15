package problem11.application;

/*
Inversão de uma sequência
*/

public class Program {

	public static void main(String[] args) {
		
		String[] array = new String[]{"Pedro", "Maria", "Alex", "Grey", "Luke", "Prince", "Bob"};
		
		printArray(array);
		invertArray(array);
		printArray(array);
		
	}
	
	public static <T> void printArray(T[] array) {
		System.out.print("[");
		for (int i=0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		if (array.length > 0) {
			System.out.print(array[array.length - 1]);
		}
		System.out.println("]");
	}
	
	public static <T> T[] invertArray(T[] array) {
		T temp;
		int end = array.length - 1;
		for (int i=0; i < array.length/2; i++) {
			temp = array[i];
			array[i] = array[end];
			array[end] = temp;
			end--;
		}
		return array;
	}

}