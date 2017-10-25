package sortcomparison;

import java.util.*;

public class BasicSorter implements Sorter {
	/**
	 * Sorts part or all of a list in ascending order.
	 * 
	 * @param data
	 *            The list of elements to sort
	 * @param firstIndex
	 *            Index of the first element to be sorted.
	 * @param numberToSort
	 *            The number of elements in the section to be sorted.
	 */
	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		String temp;
		for (int i = firstIndex; i < (numberToSort + firstIndex - 1); i++) {
			int j = i;
			int k = numberToSort;

			while (j >= (firstIndex) && (data.get(j + 1).compareTo(data.get(j)) < 0) && (k-- - 1 != 0)) {
				temp = data.get(j + 1);
				data.set(j + 1, data.get(j));
				data.set(j, temp);
				j--;

			}
		} // end for
			// while (j >= 0 && (data.get(j + 1).compareTo(data.get(j)) < 0) &&
			// (k--
			// - 1 != 0)) {
			// temp = data.get(j + 1);
			// data.set(j + 1, data.get(j));
			// data.set(j, temp);
			// j--;
			//
			// }

	}

	/**
	 * Sorts part or all of the list, data, in ascending order. quickSort()
	 * must: - Call the insertionSort() function in this interface for segments
	 * of size 15 or less. - Use the median-of-three method to prevent O(n^2)
	 * running time for sorted data sets - Call the partition() function in this
	 * interface to do its partitioning.
	 * 
	 * @param data
	 *            The list of elements to sort
	 * @param firstIndex
	 *            Index of the first element to be sorted.
	 * @param numberToSort
	 *            The number of elements in the section to be sorted.
	 */
	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		int pivotIndex;
		int low = firstIndex;
		int high = numberToSort;

		if (numberToSort <= 15) {
			insertionSort(data, firstIndex, numberToSort);
			// System.out.println("calling insertion sort between " + firstIndex
			// + " and " + (firstIndex + numberToSort));
		}

		//
		// System.out.println("low = " + low + " high = " + high);
		// System.out.println("data = ");
		// System.out.println(data);
		else {
			pivotIndex = partition(data, low, numberToSort);
			// System.out.println("DATA RANGE FROM " + firstIndex + " TO " +
			// (firstIndex + numberToSort));
			// System.out.println("pivot " + pivotIndex + ": left numbertosort =
			// " + (pivotIndex - low)
			// + " right numbertosort = " + (high - (pivotIndex - firstIndex) -
			// 1));
			quickSort(data, low, pivotIndex - low);
			// System.out.println("going right");
			quickSort(data, pivotIndex + 1, (high - (pivotIndex - firstIndex) - 1));

		}

	}

	/**
	 * Partitions part (or all) of the list. The range of indices included in
	 * the partitioning is [firstIndex, firstIndex + numberToPartition -1].
	 * 
	 * @param data
	 * @param firstIndex
	 * @param numberToPartition
	 * @return The index, relative to data[0], where the pivot value is located
	 *         at the end of this partitioning.
	 */
	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {
		// swapping two numbers to make "random"
		String tempStr = data.get(firstIndex);
		data.set(firstIndex, data.get(firstIndex + numberToPartition / 2));
		data.set(firstIndex + numberToPartition / 2, tempStr);

		String temp;
		String pivot = data.get(firstIndex);
		int tooBigNdx = firstIndex + 1;
		int tooSmallNdx = firstIndex + numberToPartition - 1;

		while (tooBigNdx < tooSmallNdx) {
			while ((tooBigNdx < tooSmallNdx) && (data.get(tooBigNdx).compareTo(pivot) <= 0))
				tooBigNdx++;
			while ((tooSmallNdx > firstIndex) && (data.get(tooSmallNdx).compareTo(pivot) > 0))
				tooSmallNdx--;
			if (tooBigNdx < tooSmallNdx) {
				temp = data.get(tooSmallNdx);
				data.set(tooSmallNdx, data.get(tooBigNdx));
				data.set(tooBigNdx, temp);
			}
		}

		if (pivot.compareTo(data.get(tooSmallNdx)) >= 0) {
			temp = data.get(tooSmallNdx);
			data.set(tooSmallNdx, data.get(firstIndex));
			data.set(firstIndex, temp);
			return tooSmallNdx;
		}

		return firstIndex;

	}

	/**
	 * Sorts part or all of a list in ascending order.
	 * 
	 * mergeSort() must: - Call the insertionSort() function in this interface
	 * for segments of size 15 or less. - Call the merge() function in this
	 * interface to do its merging.
	 * 
	 * @param data
	 *            list of elements to sort
	 * @param firstIndex
	 *            Index of the first element to be sorted.
	 * @param numberToSort
	 *            The number of elements in the section to be sorted.
	 */
	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		int leftSize, rightSize;
		leftSize = numberToSort / 2;
		rightSize = numberToSort - numberToSort / 2;
		// System.out.println(numberToSort + " left " + leftSize + " right " +
		// rightSize);

		if (numberToSort <= 15)
			insertionSort(data, firstIndex, numberToSort);

		else {
			// System.out.println("leftSize = " + leftSize);
			// System.out.println("rightSize = " + rightSize);
			mergeSort(data, firstIndex, leftSize);
			// System.out.println("makes it left");
			mergeSort(data, firstIndex + leftSize, rightSize);
			// System.out.println("makes it right");

			if (data.get(firstIndex + leftSize - 1).compareTo(data.get(firstIndex + leftSize)) > 0) {
				// System.out.println("firstIndex = " + firstIndex + " leftSize
				// = " + leftSize + " rightSize = " + rightSize);
				merge(data, firstIndex, leftSize, rightSize);
				// System.out.println("made it through merge");
			}

		}

	}

	/**
	 * Merges two sorted segments into a single sorted segment. The left and
	 * right segments are contiguous.
	 * 
	 * @param data
	 *            The list of elements to merge
	 * @param firstIndex
	 *            Index of the first element of the left segment.
	 * @param leftSegmentSize
	 *            The number of elements in the left segment.
	 * @param rightSegmentSize
	 *            The number of elements in the right segment.
	 */
	@Override
	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {
		ArrayList<String> temp = new ArrayList<String>();
		int ls = 0;
		int rs = 0;
		int i = 0;

		// System.out.println("enter");

		while (ls != leftSegmentSize && rs != rightSegmentSize) {
			if (data.get(firstIndex + ls).compareTo(data.get(firstIndex + leftSegmentSize + rs)) >= 0) {
				temp.add(data.get(firstIndex + leftSegmentSize + rs));
				rs++;

			} else {
				temp.add(data.get(firstIndex + ls));
				ls++;
			}
		}

		while (ls != leftSegmentSize) {
			temp.add(data.get(firstIndex + ls));
			ls++;
		}

		while (rs != rightSegmentSize) {
			temp.add(data.get(firstIndex + leftSegmentSize + rs));
			rs++;
		}

		// System.out.println(data.size() - firstIndex);

		// supper snazzy code
		while (i != (leftSegmentSize + rightSegmentSize)) {
			data.set(firstIndex + i, temp.get(i));
			i++;
		}

	}

	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

}
