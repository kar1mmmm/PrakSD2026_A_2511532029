package pekan2_2511532029;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Musik_2511532029> playlist_2029 = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("\n=== Playlist Musik NIM: 2511532029 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Hapus Lagu");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1: 
                    System.out.print("Masukkan Judul: ");
                    String judul_2029 = scanner.nextLine();
                    System.out.print("Masukkan Penyanyi: ");
                    String penyanyi_2029 = scanner.nextLine();
                    System.out.print("Masukkan Durasi(detik): ");
                    int durasi_2029 = scanner.nextInt();
                    scanner.nextLine();
                    
                    playlist_2029.add(new Musik_2511532029(judul_2029, penyanyi_2029, durasi_2029));
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2 :
                    System.out.println("\n--- Daftar Playlist ---");
                    if (playlist_2029.isEmpty()) {
                        System.out.println("Playlist masih kosong.");
                    } else {
                        for (int i = 0; i < playlist_2029.size(); i++) {
                            System.out.println((i + 1) + ". " + playlist_2029.get(i).toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor lagu yang ingin dihapus (1-" + playlist_2029.size() + "): ");
                    int index = scanner.nextInt();
                    if (index >= 1 && index <= playlist_2029.size()) {
                        playlist_2029.remove(index - 1);
                        System.out.println("Lagu berhasil dihapus!");
                    } else {
                        System.out.println("Nomor indeks tidak valid.");
                    }
                    break;

                case 4: 
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        while (pilihan != 4); 
        scanner.close();
    }
}