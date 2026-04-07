package pekan2_2511532029;
import java.util.*;
public class MahasiswaDriver_2511532029 {
	// 1.Method untuk menampilkan menu 
	public static  void tampilkanMenu_2511532029() {
		System.out.println("\nMenu: ");
		System.out.println("1.Tambah Mahasiswa");
		System.out.println("2.Tampilkan Semua Mahasiswa");
		System.out.println("3.Hapus Mahasiswa Berdasarkan NIM");
		System.out.println("4.Cari Mahasiswa Berdasarkan NIM");
		System.out.println("5.Keluar");
	}
	
	// 2.Method untuk tambah mahasiswa
	public static void tambahMahasiswa_2511532029 (ArrayList<Mahasiswa_2511532029> list, Scanner sc) {
		System.out.println("Masukan NIM : ");
		String nim = sc.nextLine();
		System.out.println("Masukan Nama : ");
		String nama = sc.nextLine();
		System.out.println("Masukan Prodi : ");
		String prodi = sc.nextLine();
		list.add(new Mahasiswa_2511532029 (nim, nama, prodi));
		System.out.println("Mahasiwa berhasil ditambahkan");
	}
	
	// 3. Method untuk tampilkan semua data 
	public static void tampilkanSemuaMahasiswa_2511532029 (ArrayList<Mahasiswa_2511532029> list) {
		if (list.isEmpty()) {
			System.out.println("Daftar mahasiswa kosong");
		} else {
			System.out.println("Data mahasiswa :");
			for (Mahasiswa_2511532029 mhs : list) {
				System.out.println(mhs);
		}
	}
}
	// 4.Method untuk hapus mahasiswa bardasarkan NIM
	public static void hapusMahasiswa_2511532029 (ArrayList<Mahasiswa_2511532029> list, Scanner sc) {
		System.out.println("Masukan NIM yang akan dihapus:");
		String nimHapus = sc.nextLine();
		boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
		
		if (removed) {
			System.out.println("Data dengan NIM" + nimHapus + "Berhasil dihapus.");
		} else {
			System.out.println("NIM Tidak ditemukan.");
		}
	}
	
	// 5.Method untuk cari mahasiwa berdasarkan NIM
	public static void cariMahasiswa_2511532029 (ArrayList<Mahasiswa_2511532029> list, Scanner sc) {
		System.out.println("Masukan NIM yang dicari:");
		String nimCari = sc.nextLine();
		boolean ditemukan = false ;
		
		for (Mahasiswa_2511532029 mhs :  list) {
			if (mhs.nim.equals(nimCari)) {
				System.out.println("Hasil Pencarian:" + mhs);
				ditemukan =  true;
				break;
			}
		}
		
		if (!ditemukan ) {
			System.out.println("NIM tidak ada.");
		}
	}
	
	public static void main (String[]args) {
		ArrayList<Mahasiswa_2511532029> mahasiswaList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
	
	do {
		tampilkanMenu_2511532029();
		System.out.println("Pilih Menu:");
		choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
			case 1:
				tambahMahasiswa_2511532029(mahasiswaList, scanner);
				break;
			case 2:
				tampilkanSemuaMahasiswa_2511532029(mahasiswaList);
				break;
			case 3:
				hapusMahasiswa_2511532029(mahasiswaList, scanner);
				break;
			case 4:
				cariMahasiswa_2511532029(mahasiswaList, scanner);
				break;
			case 5:
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid");
		}
	} while (choice != 5);
	scanner.close();
}
}
