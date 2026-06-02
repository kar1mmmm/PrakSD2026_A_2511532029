package pekan8_2511532029;

public class MergeSort_2511532029 {
	void Merge_2029(int arr_2029[], int l_2029, int m_2029, int r_2029) {
		int n1_2029 = m_2029 - l_2029 + 1;
		int n2_2029 = r_2029 - m_2029;
		
		int L_2029[] = new int[n1_2029];
		int R_2029[] = new int[n2_2029];
		
		for (int i_2029 = 0; i_2029 < n1_2029; ++i_2029) {
			L_2029[i_2029] = arr_2029[l_2029 + i_2029];
		}
		
		for (int j_2029 = 0; j_2029 < n2_2029; ++j_2029) {
			R_2029[j_2029] = arr_2029[m_2029 + 1 + j_2029]; 
		}
		
		int i_2029 = 0, j_2029 = 0;
		
		int k_2029 = l_2029; 
		
		while(i_2029 < n1_2029 && j_2029 < n2_2029) {
			if (L_2029[i_2029] <= R_2029[j_2029]) {
				arr_2029[k_2029] = L_2029[i_2029];
				i_2029++;
			} else {
				arr_2029[k_2029] = R_2029[j_2029];
				j_2029++;
			}
			k_2029++;
		}
		
		while (i_2029 < n1_2029) {
			arr_2029[k_2029] = L_2029[i_2029];
			i_2029++;
			k_2029++;
		}
		
		while (j_2029 < n2_2029) {
			arr_2029[k_2029] = R_2029[j_2029];
			j_2029++;
			k_2029++;
		}
	}
	
	void sort_2029(int arr_2029[], int l_2029, int r_2029) {
		if (l_2029 < r_2029) {
			
			int m_2029 = (l_2029 + r_2029) / 2;
			
			sort_2029(arr_2029, l_2029, m_2029);
			sort_2029(arr_2029, m_2029 + 1, r_2029); 
			
			Merge_2029(arr_2029, l_2029, m_2029, r_2029);
		}
	}

	static void printArray_2029(int arr_2029[]) {
		int n_2029 = arr_2029.length;
		for (int i_2029 = 0; i_2029 < n_2029; i_2029++) {
			System.out.print(arr_2029[i_2029] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int arr_2029[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Sebelum Terurut");
		printArray_2029(arr_2029);
		
		MergeSort_2511532029 ob_2029 = new MergeSort_2511532029();
		ob_2029.sort_2029(arr_2029, 0, arr_2029.length - 1);
		
		System.out.println("\nSudah Terurut menggunakan merge sort");
		printArray_2029(arr_2029);
	}
}