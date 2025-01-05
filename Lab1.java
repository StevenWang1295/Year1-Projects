//Steven Wang

import java.util.ArrayList;
import java.util.List;

public class Lab1 {

	public static void main(String[] args) {
		List<Integer> integerList = List.of(1, 2, 3, 2, 4, 5, 2);
		List<String> stringList = List.of("Dog", "Cat", "Bird", "Fish");
		List<Character> charList = List.of('f', '5', 'h', '6', 'g', '5');
		List<Boolean> booleanList = List.of(true, false, true, true, false, false, true);
		//All Lists
		
		System.out.println("Original List: " + integerList);
		List<Integer> newListWithout2 = createListWithoutElements(integerList, 2);
		System.out.println("New List without 2: " + newListWithout2 + "\n");
		
		System.out.println("Original List: " + stringList);
		List<String> newListWithoutCat = createListWithoutElements(stringList, "Cat");
		System.out.println("New List without Cat: " + newListWithoutCat + "\n");
		
		System.out.println("Original List: " + charList);
		List<Character> newListWithout5 = createListWithoutElements(charList, '5');
		System.out.println("New List without 2nd value: " + newListWithout5 + "\n");
		
		System.out.println("Original List: " + booleanList);
		List<Boolean> newListWithoutT = createListWithoutElements(booleanList, true);
		System.out.println("New List without T: " + newListWithoutT + "\n");
		//createListWithout examples
		
		System.out.println("---------------------------------\n");
		
		prettyPrint(integerList, "Integer");
		System.out.println();
		
		prettyPrint(stringList, "String");
		System.out.println();
		
		prettyPrint(charList, "Character");
		System.out.println();
		
		prettyPrint(booleanList, "Boolean");
		System.out.println();
		//Pretty print examples
	}
	
	public static <T> List<T> createListWithoutElements(List<T> OrigL, T num) {
		List<T> newList = new ArrayList<T>();
		
		for (int i = 0; i < OrigL.size(); i++) {
			if (OrigL.get(i) != num) {
				newList.add(OrigL.get(i));
			}
		}	
		return newList;
	}
	
	public static <T> void prettyPrint(List<T> list, String type) {
		System.out.println("Printing <" + type + "> List:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Element " + (i+1) + ": " + list.get(i));
		}
	}
	
}
