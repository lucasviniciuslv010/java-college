package problem06.model.util;

import java.util.List;

/*
 * Generics são invariantes
 * */

public class CalculationService {

	// Incomplete
	/*
	  public static <T extends Comparable<T>> T max(List<T> list) {
		T max = list.get(0);
		for (T object : list) {
			if (max.compareTo(object) < 0) {
				max = object;
			}
		}
	  return max;
	}
	*/
	
	// Complete
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		T max = list.get(0);
		for (T object : list) {
			if (max.compareTo(object) < 0) {
				max = object;
			}
		}
		return max;
	}
	
}