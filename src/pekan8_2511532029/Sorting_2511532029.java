package pekan8_2511532029;

import java.util.Scanner;

public class Sorting_2511532029 {
    private Lagu_2511532029[] dataLagu_2029 = new Lagu_2511532029[20];
    private int jumlahLagu_2029 = 0;
    private Scanner scanner_2029 = new Scanner(System.in);

    // Method untuk menambah lagu (input manual)
    public void inputData_2029() {
        if (jumlahLagu_2029 >= 20) {
            System.out.println("Playlist sudah penuh (maksimal 20 lagu)!");
            return;
        }

        System.out.print("Masukkan Judul: ");
        String judul = scanner_2029.nextLine();
        System.out.print("Masukkan Penyanyi: ");
        String penyanyi = scanner_2029.nextLine();
        System.out.print("Masukkan Durasi (detik): ");
        int durasi = scanner_2029.nextInt();
        scanner_2029.nextLine(); // consume newline

        dataLagu_2029[jumlahLagu_2029] = new Lagu_2511532029(judul, penyanyi, durasi);
        jumlahLagu_2029++;
        System.out.println("Data Berhasil Dibuat");
    }

    // Method untuk menampilkan semua lagu
    public void tampilData_2029() {
        if (jumlahLagu_2029 == 0) {
            System.out.println("Belum ada data lagu.");
            return;
        }
        for (int i = 0; i < jumlahLagu_2029; i++) {
            System.out.println(i + ". " + dataLagu_2029[i].judul + " - " 
                    + dataLagu_2029[i].durasi + " detik");
        }
    }

    // ========== SHELL SORT (urutkan berdasarkan JUDUL A-Z) ==========
    public void shellSort_2029() {
        int n = jumlahLagu_2029;
        // Mulai dengan gap besar, lalu perkecil
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Lagu_2511532029 temp = dataLagu_2029[i];
                int j = i;
                // Bandingkan judul (case insensitive) untuk urutan A-Z
                while (j >= gap && dataLagu_2029[j - gap].judul.compareToIgnoreCase(temp.judul) > 0) {
                    dataLagu_2029[j] = dataLagu_2029[j - gap];
                    j -= gap;
                }
                dataLagu_2029[j] = temp;
            }
        }
        System.out.println("Shell Sort selesai (berdasarkan Judul A-Z)");
    }

    // ========== MENU UTAMA ==========
    public void menu_2029() {
        int pilihan;
        do {
            System.out.println("\n=== Sorting Playlist NIM: 2511532029 ===");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Mulai Sorting (Shell Sort - Judul A-Z)");
            System.out.println("3. Exit");
            System.out.print("pilihan: ");
            pilihan = scanner_2029.nextInt();
            scanner_2029.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    inputData_2029();
                    break;
                case 2:
                    if (jumlahLagu_2029 == 0) {
                        System.out.println("Tidak ada data. Silakan masukkan data terlebih dahulu.");
                        break;
                    }
                    System.out.println("\nData Sebelum Sorting:");
                    tampilData_2029();

                    shellSort_2029();

                    System.out.println("\nData Setelah Sorting (Judul A-Z):");
                    tampilData_2029();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
    }

    public static void main(String[] args) {
        Sorting_2511532029 program = new Sorting_2511532029();
        program.menu_2029();
    }
}