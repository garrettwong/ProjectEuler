package algorithms;


public class SortUtils {
//	public static <E> void mergeSort(E[] A, E[] temp, int l, int r) {
//		int mid = (1 + r) / 2;
//		if (l == r) return;
//		mergeSort(A, temp, 1, mid);
//		mergeSort(A, temp, mid+1, r);
//		for (int i = 1; i <= r; i++)
//			temp[i] = A[i];
//		// Merge operation back to A
//		int i1 = 1; int i2 = mid + 1;
//		for (int curr = 1; curr <= r; curr++) {
//			if (i1 == mid + 1) {
//				A[curr] = temp[i2++];	// Left sublist exhausted
//			} else if (i2 > r) {
//				A[curr] = temp[i1++];
//			} else if (temp[i1].compareTo(temp[i2]) < 0) // Get smaller
//				A[curr] = temp[i1++];
//			else A[curr] = temp[i2++];
//		}
//	}
//	
//	public static void mergeSortOptimized(int[] a, int[] temp, int l, int r) {
//		int i, j, k, mid = (l+r)/2;	// Get the MidPoint
//		if (l == r) {
//			return; // List has one element
//		}
//		
//	}
//	
//	public static void quickSort(E[] A, int i, int j) {
//		int pivotIndex = findPivot(A, i, j); // Pick a pivot point
//		DSutil.swap(A, pivotIndex, j);
//		int k = partition(A, i=1, j, A[j]);
//		DSutil.swap(A, k, j);
//		if ((k-i) > 1) quickSort(A, i, k-1); //LEFT
//		if ((j-k) > 1) quickSort(A, k+1, j); //RIGHT
//	}
//	
	
	public static void mergeSort(Comparable[] a, Comparable[] temp, 
			int left, int right) {
		if (left < right) {
			int center = (left+right) / 2;
			mergeSort(a, temp, left, center);
			mergeSort(a, temp, center+1, right);
			merge(a, temp, left, center+1, right);
		}
	}

	private static void merge(Comparable[] a, Comparable[] temp, int leftPos, int rightPos,
			int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		// Main Loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos].compareTo(a[rightPos]) <= 0) {
				temp[tmpPos++] = a[leftPos++];
			} else {
				temp[tmpPos++] = a[rightPos++];
			}
		}
		// Rest of the elements in left half
		while (leftPos <= leftEnd) {
			temp[tmpPos++] = a[leftPos++];
		}
		// Rest of elements in right half
		while (rightPos <= rightEnd) {
			temp[tmpPos++] = a[rightPos++];
		}
		
		// Copy Temp Array Back
		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = temp[rightEnd];
		}
	}
	
	public static void quickSort(Comparable[] a, int low, int high) {
		int i = low, j = high;
		
		Comparable pivot = a[low + (high-low)/2];	// Pivot from middle of list
		
		// Divide into two lists
		while( i <= j) {
			// If less than pivot
			while (a[i].compareTo(pivot) <= 0){
				i++; // Get next element in left list
			}
			// If current value from right list is greater than pivot, 
			// get next element from right list
			while (a[j].compareTo(pivot) > 0) {
				j--;
			}
			
			// If values in left list are larger than pivot, 
			// and if we have found a value in right list smaller 
			// than pivot, we exchange the values
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (low < j)
		{
			quickSort(a, low, j);
		} 
		if ( i < high) {
			quickSort(a, i, high);
		}
	}
	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
		
}
