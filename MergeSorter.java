package mergesort;

import java.util.Arrays;

public class MergeSorter {

	private int[] array;
	
	// Ctor
	MergeSorter(int[] array) {
		this.array = array;
	}
	
	int[] sort() {
		mergeSortRecurse(array);
		return array;
	}
	
	private void mergeSortRecurse(int[] a) {
		if(a.length <= 1)
			return;
		int mid = a.length/2;
		int left[] = new int[mid];
		int right[] = new int[a.length - mid];
	
		// If a has odd length, right half gets the extra value
		for(int i = 0; i < mid; i++) 
			left[i] = a[i];
		for(int j = mid; j < a.length; j++)
			right[j - mid] = a[j];

		// Sort left and right halves of array
		mergeSortRecurse(left);
		mergeSortRecurse(right);
		
		// Merge the halves
		merge(left, right, a);
	}
	
	private void merge(int[] left, int[] right, int[] sortedArray) {
		int leftIndex = 0;												// Index of left half
		int rightIndex = 0;												// Index right half
		int resultIndex = 0;						// Index of sorted array
		
		while(leftIndex < left.length && rightIndex < right.length) {
			
			if(left[leftIndex] > right[rightIndex]) {					// If value of right is smaller
				sortedArray[resultIndex] = left[leftIndex];					
				leftIndex++;
			}
			else {														// Value of left is smaller
				sortedArray[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		
		// Left index is smaller than length of left half but right index is bigger than right half length
		while(leftIndex < left.length) {							
			sortedArray[resultIndex] = left[leftIndex];
			leftIndex++;
			resultIndex++;
		}
		
		// Right index is smaller than length of right half but left index is bigger than left half length
		while(rightIndex < right.length) {
			sortedArray[resultIndex] = right[rightIndex];
			rightIndex++;
			resultIndex++;
		}
	}
	
	public static void main(String[] args) {
		
		// Vanilla case array: even number of elements and no duplicates
		int[] vanillaArray = {2, 7, 4, 9};
		System.out.println("Vanilla array original: " + Arrays.toString(vanillaArray));
		MergeSorter m = new MergeSorter(vanillaArray);
		System.out.println("Vanilla array sorted: " + Arrays.toString(m.sort()));
		System.out.println();
		
		// Odd number of elements in array
		int[] oddArray = {2, 1, 4, 3, 5};
		System.out.println("Odd array original: " + Arrays.toString(oddArray));
		MergeSorter m1 = new MergeSorter(oddArray);
		System.out.println("Odd array sorted: " + Arrays.toString(m1.sort()));
		System.out.println();
		
		// Duplicate element in array
		int[] duplicateArray = {6, 2, 3, 6};
		System.out.println("Duplicate array original: " + Arrays.toString(duplicateArray));
		MergeSorter m2 = new MergeSorter(duplicateArray);
		System.out.println("Duplicate array sorted: " + Arrays.toString(m2.sort()));
		System.out.println();
		
		// Odd number and duplicate elements in array
		int[] oddDuplicate = {3, 6, 2, 8, 2};
		System.out.println("Odd and duplicate array original: " + Arrays.toString(oddDuplicate));
		MergeSorter m3 = new MergeSorter(oddDuplicate);
		System.out.println("Odd and duplicate array sorted: " + Arrays.toString(m3.sort()));
		System.out.println();
		
		// Already sorted array
		int[] sortedArray = {7, 6, 5, 4, 3, 2, 1};
		System.out.println("Already sorted array original: " + Arrays.toString(sortedArray));
		MergeSorter m4 = new MergeSorter(sortedArray);
		System.out.println("Already sorted array sorted: " + Arrays.toString(m4.sort()));
	}
}
