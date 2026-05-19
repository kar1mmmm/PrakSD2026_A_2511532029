package pekan7_2511532029;

public class InsertionSort_2511532029 {
    public static void insertionSort_2029(int[] arr_2029) {
        int n_2029 = arr_2029.length;
        // Mulai dari indeks 1 karena elemen pertama dianggap sudah terurut
        for (int i_2029 = 1; i_2029 < n_2029; i_2029++) {
            int key_2029 = arr_2029[i_2029];
            int j_2029 = i_2029 - 1;
            // Geser elemen yang lebih besar dari key ke kanan
            while (j_2029 >= 0 && arr_2029[j_2029] > key_2029) {
                arr_2029[j_2029+ 1] = arr_2029[j_2029];
                j_2029--;
            }
            // Tempatkan key pada posisi yang tepat
            arr_2029[j_2029 + 1] = key_2029;
        }
    }

    public static void main(String[] args) {
        int arr_2029[] = {23, 78, 45, 8, 32, 56, 1};
        int n_2029 = arr_2029.length;
        
        System.out.print("Array yang belum terurut: ");
        for (int i_2029 = 0; i_2029 < n_2029; i_2029++) {
            System.out.print(arr_2029[i_2029] + " ");
        }
        System.out.println();
        
        insertionSort_2029(arr_2029);
        
        System.out.print("Array yang sudah terurut: ");
        for (int i_2029 = 0; i_2029 < n_2029; i_2029++) {
            System.out.print(arr_2029[i_2029] + " ");
        }
        System.out.println();
    }
}