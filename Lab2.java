//Steven Wang

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lab2 {

	public static void main(String[] args) {
		System.out.println("Task 1");
		
		List<Integer> firstList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			firstList.add(i);
		}
		RemoveElements(firstList, 2);

		List<Integer> secondList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) { secondList.add(4);}
		secondList.add(2);
		RemoveElements(secondList, 4);

		List<String> thirdList = List.of( "a", "b", "c", "a");
		RemoveElements(thirdList, "a");
		
		System.out.println("Task 2");
		seriesTest(10);
	}

	private static <T> List<T> createWithoutElementsRec(List<T> list, T element) {
		List<T> newList = new ArrayList<T>();

		for (int i = 0; i < list.size(); i++) {

			if (!(list.get(i).equals(element))) {
				newList.add(list.get(i));
			} else {
				List<T> newerList = new ArrayList<T>();

				for (int j = i+1; j < list.size(); j++) {
					newerList.add(list.get(j));
				}
				newList.addAll(createWithoutElementsRec(newerList, element));
				break;
			}

		}
		return newList;
	}

	public static <T> void RemoveElements(List<T> list, T element) {
		System.out.println(createWithoutElementsRec(list, element));
	}

	public static long seriesTerm(int n) {
		// Base cases: f(0) = 0, f(1) = 1
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			// Recursive case: f(n) = 2 * f(n-1) + 3 * f(n-2)
			return 2 * seriesTerm(n - 1) + 3 * seriesTerm(n - 2);
		}
	}

	public static long seriesTermTail(int n, int index, long f0, long f1) {
		if (n == 0) {
			return f0;
		} else if (index >= n-1) {
			return f1;
		} else {
			long old_f0 = f0;

			f0 = f1;
			f1 = 2*f1+3*old_f0;

			return seriesTermTail(n, index+1, f0, f1);
		}
	}

	public static void seriesTest(int n) {
		for (int i = 0; i <= n; i++) {
			boolean bool = seriesTerm(i) == seriesTermTail(i, 0, 0, 1);
			System.out.println("Testing for " + i + ": " + bool);
		}
	}

}
