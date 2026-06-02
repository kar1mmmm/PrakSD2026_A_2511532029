package pekan8_2511532029;

public class ShellSort_2511532029 {
	
	public static void ShellSort_2029(int[] A) {
		int n_2029 = A.length;
		int gap_2029 = n_2029 / 2;
		while (gap_2029 > 0) {
			for (int i_2029 = gap_2029; i_2029 < n_2029; i_2029++) {
				int temp_2029 = A[i_2029];
				int j_2029 = i_2029;
				while (j_2029 >= gap_2029 && A[j_2029 - gap_2029] > temp_2029) {
					A[j_2029] = A[j_2029 - gap_2029];
					j_2029 = j_2029 - gap_2029;
				}
				A[gap_2029] = temp_2029;
			}
			gap_2029 = gap_2029 / 2;
		}
	}
	
	public static void main(String[] args) {
		int[] data_2029 = {3,10,4,6,8,9,7,2,1,5};
		 System.out.print("sebelum: ");
		 printArray(data_2029);
		 
		 ShellSort_2029(data_2029);
		 
		 System.out.print("sesudah (shel sort):");
		 printArray(data_2029);
	}
	public static void printArray (int[] arr) {
		for (int i_2029 : arr) System.out.print(i_2029 + "");
		System.out.println();
	}

}
