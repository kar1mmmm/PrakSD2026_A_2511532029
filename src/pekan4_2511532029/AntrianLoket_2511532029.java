package pekan4_2511532029;

import java.util.Scanner;

public class AntrianLoket_2511532029 {
    private String[] queue_2029;
    private int front_2029;
    private int rear_2029;
    private int max_2029;
    private int size_2029;

    public AntrianLoket_2511532029(int kapasitas) {
        max_2029 = kapasitas;
        queue_2029 = new String[max_2029];
        front_2029 = 0;
        rear_2029 = -1;
        size_2029 = 0;
    }

    public boolean isEmpty() {
        return size_2029 == 0;
    }

    public boolean isFull() {
        return size_2029 == max_2029;
    }

    public void enqueue(String data) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan data.");
            return;
        }
        rear_2029 = (rear_2029 + 1) % max_2029;
        queue_2029[rear_2029] = data;
        size_2029++;
        System.out.println("Data berhasil ditambahkan ke antrian");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada data yang dapat dihapus.");
            return null;
        }
        String dataDihapus = queue_2029[front_2029];
        front_2029 = (front_2029 + 1) % max_2029;
        size_2029--;
        System.out.println(dataDihapus + " telah dilayani");
        return dataDihapus;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Isi antrian:");
        for (int i = 0; i < size_2029; i++) {
            int idx = (front_2029 + i) % max_2029;
            System.out.println((i + 1) + ". " + queue_2029[idx]);
        }
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang dibalik.");
            return;
        }
        String[] temp = new String[size_2029];
        for (int i = 0; i < size_2029; i++) {
            temp[i] = queue_2029[(front_2029 + i) % max_2029];
        }
        for (int i = 0; i < size_2029 / 2; i++) {
            String t = temp[i];
            temp[i] = temp[size_2029 - 1 - i];
            temp[size_2029 - 1 - i] = t;
        }
        front_2029 = 0;
        rear_2029 = size_2029 - 1;
        for (int i = 0; i < size_2029; i++) {
            queue_2029[i] = temp[i];
        }
        System.out.println("Antrian berhasil dibalik.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianLoket_2511532029 antrian = new AntrianLoket_2511532029(5);
        int pilihan;

        System.out.println("=== PROGRAM ANTRIAN LOKET ===");
        do {
            System.out.println("\n1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    antrian.enqueue(nama);
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.display();
                    break;
                case 4:
                    antrian.reverse();
                    antrian.display();
                    break;
                case 5:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}