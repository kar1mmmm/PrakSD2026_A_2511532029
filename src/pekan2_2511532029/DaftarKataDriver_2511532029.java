package pekan2_2511532029;

public class DaftarKataDriver_2511532029 {

	public static void main(String[] args) {
		DaftarKata_2511532029 al = new DaftarKata_2511532029();
		
		// Add element
		al.tambah_2511532029("Kami");
		al.tambah_2511532029("Informatika");
		
		// Insert element
		al.tambahPada_2511532029(1, "Mahasiswa");
				
		// Print
		System.out.printf("Awal			: %s%n",al);
		
		// Change element (index 1)
		al.ubahElemen_2511532029(1, "Departmenen");
		System.out.printf("Setelah Ubah		: %s%n", al);
		
		// Delete
		String terhapus = al.hapusElemen_2511532029(0);
		System.out.printf("Terhapus 		: %s%n", terhapus);
		System.out.printf("Setelah Hapus		: %s%n", al);
		
		// Iteration
		System.out.print("Iterasi 		: ");
		al.iterasiCetak_2511532029();
		System.out.println();
	}

}