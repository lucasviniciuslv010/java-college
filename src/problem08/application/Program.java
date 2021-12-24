package problem08.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Faça um método que copia os elementos de uma lista para uma
outra lista que pode ser mais genérica que a primeira.
*/

public class Program {

	public static void main(String[] args) {
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
		
		//================================================
		
		/* 
		 * Covariance
		 *
		List<Integer> myInts = Arrays.asList(1, 3, 5, 0, 2, 9);
		List<? extends Number> myNumbers = myInts;
		
		Number x = myNumbers.get(0); // GET OK
		//myNumbers.add(2); // PUT ERROR
		
		
		 * 
		 * Contravariance
		 *
		List<Object> myObjs = Arrays.asList("Maria", "Grey", "João");
		List<? super Number> list = myObjs;
		
		list.add(5); // PUT OK
		//Number y = list.get(0); GET ERROR
		*/
	}

	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);		}
	}
	
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	
}