package pekan8_2511532029;

public class QuickSort_2511532029 {
	static void swap_2029(int [] arr, int i_2029, int j_2029) {
		int temp_2029 = arr[i_2029];
		arr[i_2029] = arr[j_2029];
		arr[j_2029] = temp_2029;
	}
	
	static void medianOfThree_2029(int[] arr, int low_2029,int high_2029) {
		int mid_2029 = low_2029 + (high_2029 - low_2029) / 2;
		
		if (arr[low_2029] > arr[mid_2029]) {
			swap_2029(arr,low_2029,mid_2029);
		}
		
		if (arr[low_2029] > arr[high_2029]) {
			swap_2029(arr,low_2029,high_2029);
		}
		
		if (arr[mid_2029] > arr[high_2029]) {
			swap_2029(arr, mid_2029,high_2029);
		}
		swap_2029(arr,mid_2029,high_2029);
	}
	static int partition_2029(int[]arr, int low_2029, int high_2029) {
		medianOfThree_2029(arr,low_2029,high_2029);
		
		int pivot_2029 = arr[high_2029];
		int i_2029 = (low_2029 -1);
		
		for (int j_2029 = low_2029; j_2029 <= high_2029 - 1; j_2029++ ) {
			if (arr[j_2029] < pivot_2029) {
				i_2029++;
				swap_2029(arr,i_2029,j_2029);
			}
		}
		swap_2029(arr, i_2029 + 1, high_2029);
		return (i_2029 + 1);
	}
		static void quickSort_2029(int[]arr, int low_2029,int high_2029) {
			if (low_2029 < high_2029) {
				int pi_2029 = partition_2029(arr, low_2029, high_2029);
				quickSort_2029(arr, low_2029, pi_2029 - 1);
				quickSort_2029(arr, pi_2029 + 1, high_2029);
				
				}
			}
		
		public static void printArr_2029(int[] arr) 
		{
			for (int i_2029 = 0; i_2029 < arr.length; i_2029++) {
			System.out.print(arr[i_2029] + " ");
		}
		System.out.println();
		}
		public static void main(String[] args) {
			int [] arr = {10,7,8,9,1,5};
			int N_2029 = arr.length;
			System.out.print("Data sebelum diurutkan:");
			printArr_2029(arr);
			
			quickSort_2029(arr, 0, N_2029 - 1);
			
			System.out.print("Data terurut quicksort:");
			printArr_2029(arr);

		}

}


