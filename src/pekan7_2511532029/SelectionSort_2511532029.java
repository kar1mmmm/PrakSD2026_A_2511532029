package pekan7_2511532029;

public class SelectionSort_2511532029 {
    public static void selectionSort_2029(int[] arr_2029) {
        int n_2029 = arr_2029.length;
        for (int i_2029 = 0; i_2029 < n_2029 - 1; i_2029++) {
            int minIndex_2029 = i_2029;
            for (int j_2029 = i_2029 + 1; j_2029 < n_2029; j_2029++) {
                if (arr_2029[j_2029] < arr_2029[minIndex_2029]) {
                    minIndex_2029 = j_2029;
                }
            }
            // Tukar elemen
            int temp_2029 = arr_2029[i_2029];
            arr_2029[i_2029] = arr_2029[minIndex_2029];
            arr_2029[minIndex_2029] = temp_2029;
        }
    }

    public static void main(String[] args) {
        int arr_2029[] = {23, 78, 45, 8, 32, 56, 1};
        int n = arr_2029.length;

        System.out.print("Array yang belum terurut: ");
        for (int i_2029 = 0; i_2029< n; i_2029++)
            System.out.print(arr_2029[i_2029] + " ");
        System.out.println();

        selectionSort_2029(arr_2029);

        System.out.print("Array yang sudah terurut: ");
        for (int i_2029= 0; i_2029 < n; i_2029++)
            System.out.print(arr_2029[i_2029] + " ");
        System.out.println();
    }
}