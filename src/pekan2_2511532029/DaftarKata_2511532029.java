package pekan2_2511532029;
import java.util.ArrayList;

public class DaftarKata_2511532029 {
	
	private final ArrayList<String> data;
	
	// konstruktor: inisialisasi list kosong
	public DaftarKata_2511532029() {
		this.data = new ArrayList<>();
	}
	
	/** menambahkan element di akhir list. */
	public void tambah_2511532029(String elemen) {
		data.add(elemen);
	}
	
	/** Menambahkan elemen pada indeks tertentu (menyisipkan) */
	public void tambahPada_2511532029(int index, String elemen) {
		data.add(index, elemen);
	}
	
	/**
	 * Mengubah elemen pada posisi 'index' menjadi 'nilai baru'
	 * Bertindak sebagai "setter" untuk elemen tertentu.
	 */
	public void ubahElemen_2511532029(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	
	/** 
	 * Menghapus elemen pada posisi 'index' dan mengembalikan nilai yang dihapus
	 */
	public String hapusElemen_2511532029(int index) {
		return data.remove(index);
	}
	
	/**
	 * Melakukan iterasi dan mencetak setiap elemen format : [index] nilai
	 * (Metode ini tidak mengembalikan nilai: hanya demonstrasi iterasi)
	 */
	public void iterasiCetak_2511532029() {
		for (int i = 0; i < data.size(); i++) {
			System.out.println("[" + i + "] " + data.get(i));
		}
	}
	
	public String get(int index) {
		return data.get(index);
	}
	
	@Override   
	public String toString() {
		return data.toString();
	}
}