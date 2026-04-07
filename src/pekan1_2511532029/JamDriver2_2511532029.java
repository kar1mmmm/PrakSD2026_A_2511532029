package pekan1_2511532029;
import java.util.Scanner;

public class JamDriver2_2511532029 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Program Driver Objek Jam ===");
        
        // 1. Input Jam Pertama
        System.out.println("\n--- Input Jam 1 ---");
        Jam_2511532029 j1 = buatJamDariInput(input);
        
        // 2. Input Jam Kedua
        System.out.println("\n--- Input Jam 2 ---");
        Jam_2511532029 j2 = buatJamDariInput(input);
        
        // 3. Menampilkan Data
        System.out.println("\n--- Hasil Operasi ---");
        System.out.println("Jam 1 (String)      : " + j1.toString());
        System.out.println("Jam 2 (String)      : " + j2.toString());
        System.out.println("Jam 1 dalam detik   : " + j1.toSecond());
        System.out.println("Jam 2 dalam detik   : " + j2.toSecond());
        
        // 4. Operasi Relasional (Perbandingan)
        int perbandingan = j1.compareTo(j2);
        if (perbandingan > 0) {
            System.out.println("Status              : Jam 1 lebih lambat (setelah) jam 2");
        } else if (perbandingan < 0) {
            System.out.println("Status              : Jam 1 lebih awal (sebelum) Jam 2");
        } else {
            System.out.println("Status              : Jam 1 dan Jam 2 sama persis");
        }
        
        // 5. Operasi aritmatika
        System.out.println("Durasi (j1 ke j2)   : " + Jam_2511532029.durasiDetik(j1, j2) + " detik");
        
        Jam_2511532029 jNext = j1.nextSecond();
        System.out.println("Jam 1 Detik berikutnya: " + jNext);
        
        Jam_2511532029 jPrev = j1.prevSecond();
        System.out.println("Jam 1 Detik sebelumnya: " + jPrev);
        
        // 6. Operasi Penjumlahan Jam
        Jam_2511532029 jHasilPlus = j1.plus(j2);
        System.out.println("Hasil j1 + j2       : " + jHasilPlus);
        
        input.close();
        System.out.println("\nProgram Selesai.");
    }

    /**
     * Prosedur pembantu untuk melakukan input dan validasi.
     * Mengulang input jika angka di luar jangkauan (0-23 atau 0-59).
     */
    private static Jam_2511532029 buatJamDariInput(Scanner sc) {
        int h, m, s;
        while (true) {
            System.out.print("Masukkan jam (0-23)   : ");
            h = sc.nextInt();
            System.out.print("Masukkan menit (0-59) : ");
            m = sc.nextInt();
            System.out.print("Masukkan detik (0-59) : ");
            s = sc.nextInt();

            // Validasi input
            if (h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
                return new Jam_2511532029(h, m, s); // Mengembalikan objek jika valid
            } else {
                System.out.println("[Error] Input tidak valid! Silakan ulangi.");
            }
        }
    }
}