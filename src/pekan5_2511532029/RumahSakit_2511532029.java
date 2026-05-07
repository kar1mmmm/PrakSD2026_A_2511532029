package Pekan5_2511532029;

import java.util.Scanner;

public class RumahSakit_2511532029 {
    private Pasien_2511532029 head_2029;
    private Pasien_2511532029 tail_2029;
    private int counterAntrian_2029; 
    private int jumlahPasien_2029;  

    public RumahSakit_2511532029() {
        this.head_2029 = null;
        this.tail_2029 = null;
        this.counterAntrian_2029 = 0;
        this.jumlahPasien_2029 = 0;
    }
    
    public void daftarkanPasien_2029(String nama_2029, String keluhan_2029) {
        counterAntrian_2029++;
        Pasien_2511532029 baru = new Pasien_2511532029(nama_2029, keluhan_2029, counterAntrian_2029);
        if (head_2029 == null) {
            head_2029 = baru;
            tail_2029 = baru;
        } else {
            tail_2029.next_2029 = baru;
            tail_2029 = baru;
        }
        jumlahPasien_2029++;
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counterAntrian_2029);
    }

    public void panggilPasien_2029() {
        if (head_2029 == null) {
            System.out.println("Antrian kosong, tidak ada pasien yang bisa dipanggil.");
            return;
        }
        Pasien_2511532029 pasienDipanggil_2029 = head_2029;
        System.out.println("\n=== Pasien Dipanggil ===");
        System.out.println("Nomor Antrian : " + pasienDipanggil_2029.getNomorAntrian_2029());
        System.out.println("Nama Pasien   : " + pasienDipanggil_2029.getNamaPasien_2029());
        System.out.println("Keluhan       : " + pasienDipanggil_2029.getPenyakit_2029());
        System.out.println("========================\n");

        head_2029 = head_2029.next_2029;
        if (head_2029 == null) {
            tail_2029 = null;
        }
        jumlahPasien_2029--;
    }

    public void tampilkanAntrian_2029() {		//Tampilkan antrean
        if (head_2029 == null) {
            System.out.println("Antrian saat ini kosong.");
            return;
        }
        System.out.println("\n=== DAFTAR ANTRIAN ===");
        Pasien_2511532029 current_2029 = head_2029;
        int posisi_2029 = 1;
        while (current_2029 != null) {
            System.out.println(posisi_2029 + ". No. Antrian: " + current_2029.getNomorAntrian_2029() +
                               " | Nama: " + current_2029.getNamaPasien_2029() +
                               " | Keluhan: " + current_2029.getPenyakit_2029());
            current_2029 = current_2029.next_2029;
            posisi_2029++;
        }
        System.out.println("======================\n");
    }

    public void cariPasien_2029(String nama_2029) {			//Cari pasien
        if (head_2029 == null) {
            System.out.println("Antrian kosong, tidak ada pasien.");
            return;
        }
        Pasien_2511532029 current_2029 = head_2029;
        boolean ditemukan_2029 = false;
        while (current_2029 != null) {
            if (current_2029.getNamaPasien_2029().equalsIgnoreCase(nama_2029)) {
                System.out.println("Pasien ditemukan!");
                System.out.println("Nomor Antrian : " + current_2029.getNomorAntrian_2029());
                System.out.println("Nama Pasien   : " + current_2029.getNamaPasien_2029());
                System.out.println("Keluhan       : " + current_2029.getPenyakit_2029());
                ditemukan_2029 = true;
                break;
            }
            current_2029 = current_2029.next_2029;
        }
        if (!ditemukan_2029) {
            System.out.println("Pasien dengan nama \"" + nama_2029 + "\" tidak ditemukan dalam antrian.");
        }
    }

    public void cekStatusAntrian_2029() {			//Cek status antrian
        if (head_2029 == null) {
            System.out.println("Status: Antrian kosong.");
            return;
        }
        System.out.println("=== STATUS ANTRIAN ===");
        System.out.println("Jumlah pasien dalam antrian: " + jumlahPasien_2029);
        System.out.println("Pasien terdepan: " + head_2029.getNamaPasien_2029() +
                           " (No. Antrian " + head_2029.getNomorAntrian_2029() + ")");
        System.out.println("=======================");
    }

    public void jalankanMenu_2029() {			// fungsi untuk menjalankan menu
        Scanner scanner_2029 = new Scanner(System.in);
        int pilihan_2029;
        do {
            System.out.println("\n== Antrian Rumah Sakit NIM: 2511532029 ==");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_2029 = scanner_2029.nextInt();
            scanner_2029.nextLine();

            switch (pilihan_2029) {
                case 1:
                    System.out.print("Masukkan Nama Pasien : ");	
                    String nama_2029 = scanner_2029.nextLine();		//input nama pasien
                    System.out.print("Masukkan Keluhan : ");		
                    String keluhan_2029 = scanner_2029.nextLine();	//input keluhan pasien
                    daftarkanPasien_2029(nama_2029, keluhan_2029);
                    break;
                case 2:
                    panggilPasien_2029();							//panggil pasien 
                    break;
                case 3:
                    tampilkanAntrian_2029();						//panggul pasien
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari : ");
                    String cariNama_2029 = scanner_2029.nextLine();		//Cari nama pasien
                    cariPasien_2029(cariNama_2029);
                    break;
                case 5:
                    cekStatusAntrian_2029();					//Cek status antrian
                    break;
                case 6:
                    System.out.println("Terima kasih, program selesai.");		//Program selesai
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan_2029 != 6);
        scanner_2029.close();
    }

    public static void main(String[] args) {
        RumahSakit_2511532029 rs_2029 = new RumahSakit_2511532029();
        rs_2029.jalankanMenu_2029();
    }
}