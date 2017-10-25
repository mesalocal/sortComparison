package sortcomparison;

import java.util.*;

import org.apache.commons.lang3.*;

public class Main {
	public static void main(String args[]) {
		Sorter blah = new BasicSorter();
		String result;

		ArrayList<String> list = new ArrayList<String>();
		// list.add("b");
		// list.add("da");
		// list.add("e");
		// list.add("a");
		// list.add("z");
		// list.add("f");
		// list.add("d");
		//
		// list.add("b");
		// list.add("da");
		// list.add("e");
		// list.add("a");
		// list.add("z");
		// list.add("f");
		// list.add("d");
		//
		// list.add("b");
		// list.add("da");
		// list.add("e");
		// list.add("a");
		// list.add("z");
		// list.add("f");
		// list.add("d");
		// // blah.insertionSort(list, 0, 7);
		// // blah.insertionSort(list, 1, 6);
		// // blah.insertionSort(list, 1, 7);// should get error
		// blah.insertionSort(list, 4, 2);
		for (int i = 0; i < 32; i++) {
			result = RandomStringUtils.randomAlphabetic(2).toLowerCase();
			// result = RandomStringUtils.randomAscii(5);
			list.add(result);
		}
		// blah.insertionSort(list, 0, 20000);
		System.out.println("og " + list);
		blah.mergeSort(list, 0, 32);
		System.out.println("ms " + list);

		blah.insertionSort(list, 0, 32);
		System.out.println("in " + list);

	}
}
