package problem12.application;

/*
Fatorial
*/
public class Program {

	public static void main(String[] args) {
		
		System.out.println("5! = " + fat(5));
		System.out.println("5! = " + fatR(5));

	}
	
	// No Recursion
	public static int fat(int num) {
		int total = 1;
		for (int i=num; i>1; i--) {
			total *= i;
		}
		return total;
	}
	
	// With Recursion
	public static int fatR(int num) {
		if (num == 0) {
			return 1;
		}
		return num * fatR(num - 1);
	}

}