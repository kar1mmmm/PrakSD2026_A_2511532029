package pekan3_25115302029;

import java.util.Stack;
import java.util.Scanner;

public class Browser_2511532029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Website_2511532029> history_2029 = new Stack<>();
        int pilihan;

        do {
            System.out.println("\n=== Browser History NIM: 2511532029 ===");
            System.out.println("1. Kunjungi Website ");
            System.out.println("2. Tombol Back ");
            System.out.println("3. Lihat Halaman Aktif");
            System.out.println("4. Cek Status History");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1: 
                    System.out.print("Masukkan Judul: ");
                    String judul_2029 = scanner.nextLine();
                    System.out.print("Masukkan URL: ");
                    String url_2029 = scanner.nextLine();
                    
                    history_2029.push(new Website_2511532029(judul_2029, url_2029));
                    System.out.println("Berhasil mengunjungi halaman!");
                    break;

                case 2: 
                    if (history_2029.isEmpty()) {
                        System.out.println("History kosong. Tidak ada halaman untuk dikembalikan.");
                    } else {
                        Website_2511532029 lastSite = history_2029.pop();
                        System.out.println("Berhasil kembali. Halaman yang dihapus: " + lastSite.getJudul_2029());
                    }
                    break;

                case 3: 
                    if (history_2029.isEmpty()) {
                        System.out.println("History kosong. Tidak ada halaman aktif.");
                    } else {
                        Website_2511532029 currentSite = history_2029.peek();
                        System.out.println("\n--- Halaman Aktif ---");
                        System.out.println(currentSite.toString());
                    }
                    break;

                case 4: 
                    System.out.println("Status History: " + (history_2029.isEmpty() ? "Kosong" : "Terdapat Data"));
                    System.out.println("Jumlah total riwayat tersimpan: " + history_2029.size());
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 5);

        scanner.close();
    }
}