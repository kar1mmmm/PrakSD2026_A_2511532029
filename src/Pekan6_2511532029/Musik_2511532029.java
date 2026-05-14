package Pekan6_2511532029;
import java.util.Scanner;

public class Musik_2511532029 {
    // Pointer head playlist
    private Lagu_2511532029 head_2029;

    public Musik_2511532029() {
        head_2029 = null;
    }

    // 1. Menambah lagu baru di AKHIR playlist
    public void tambahLagu_2029(String judul_2029, String penyanyi_2029) {
        Lagu_2511532029 new_node_2029 = new Lagu_2511532029(judul_2029, penyanyi_2029);
        
        if (head_2029 == null) {
            head_2029 = new_node_2029;
            return;
        }

        // Traversal ke node terakhir
        Lagu_2511532029 curr_2029 = head_2029;
        while (curr_2029.next_2029 != null) {
            curr_2029 = curr_2029.next_2029;
        }

        // Hubungkan pointer next & prev
        curr_2029.next_2029 = new_node_2029;
        new_node_2029.prev_2029 = curr_2029;
    }

    // 2. Menghapus lagu pertama (head)
    public void hapusLaguAwal_2029() {
        if (head_2029 == null) {
            System.out.println("Playlist kosong, tidak ada lagu yang dihapus.");
            return;
        }

        Lagu_2511532029 temp_2029 = head_2029;
        head_2029 = head_2029.next_2029; // Pindah head ke node berikutnya
        
        if (head_2029 != null) {
            head_2029.prev_2029 = null; // Lepaskan koneksi prev ke node yang dihapus
        }
        System.out.println("Lagu pertama berhasil dihapus.");
    }

    // 3. Menampilkan playlist dari awal ke akhir
    public void tampilMaju_2029() {
        if (head_2029 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Lagu_2511532029 curr_2029 = head_2029;
        System.out.println("\nDaftar Playlist (Maju):");
        while (curr_2029 != null) {
            System.out.println("- " + curr_2029.judul_2029 + " | " + curr_2029.penyanyi_2029);
            curr_2029 = curr_2029.next_2029;
        }
    }

    // 4. Menampilkan playlist dari akhir ke awal
    public void tampilMundur_2029() {
        if (head_2029 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        // Cari node tail terlebih dahulu
        Lagu_2511532029 tail_2029 = head_2029;
        while (tail_2029.next_2029 != null) {
            tail_2029 = tail_2029.next_2029;
        }

        // Traversal mundur menggunakan pointer prev_2029
        Lagu_2511532029 curr_2029 = tail_2029;
        System.out.println("\nDaftar Playlist (Mundur):");
        while (curr_2029 != null) {
            System.out.println("- " + curr_2029.judul_2029 + " | " + curr_2029.penyanyi_2029);
            curr_2029 = curr_2029.prev_2029;
        }
    }

    // 5. Mencari lagu berdasarkan judul 
    public void cariLagu_2029(String judul_2029) {
        if (head_2029 == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Lagu_2511532029 curr_2029 = head_2029;
        boolean ditemukan_2029 = false;

        while (curr_2029 != null) {
            if (curr_2029.judul_2029.equalsIgnoreCase(judul_2029)) {
                System.out.println("Lagu ditemukan: '" + curr_2029.judul_2029 + "' oleh " + curr_2029.penyanyi_2029);
                ditemukan_2029 = true;
                break;
            }
            curr_2029 = curr_2029.next_2029;
        }

        if (!ditemukan_2029) {
            System.out.println("Lagu dengan judul '" + judul_2029 + "' tidak ditemukan.");
        }
    }

    // Main: Menu Interaktif
    public static void main(String[] args) {
        Scanner scanner_2029 = new Scanner(System.in);
        Musik_2511532029 playlist_2029 = new Musik_2511532029();
        int pilihan_2029 = 0;

        do {
            System.out.println("\n=== Playlist Musik NIM: 2511532029 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu Pertama");
            System.out.println("3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            if (scanner_2029.hasNextInt()) {
                pilihan_2029 = scanner_2029.nextInt();
                scanner_2029.nextLine(); // Konsumsi newline
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner_2029.nextLine();
                continue;
            }

            switch (pilihan_2029) {
                case 1:
                    System.out.print("Judul: ");
                    String judul_input_2029 = scanner_2029.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi_input_2029 = scanner_2029.nextLine();
                    playlist_2029.tambahLagu_2029(judul_input_2029, penyanyi_input_2029);
                    System.out.println("Lagu berhasil ditambahkan!");
                    break;
                case 2:
                    playlist_2029.hapusLaguAwal_2029();
                    break;
                case 3:
                    playlist_2029.tampilMaju_2029();
                    break;
                case 4:
                    playlist_2029.tampilMundur_2029();
                    break;
                case 5:
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String cari_2029 = scanner_2029.nextLine();
                    playlist_2029.cariLagu_2029(cari_2029);
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan Playlist Musik.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan_2029 != 6);

        scanner_2029.close();
    }
}