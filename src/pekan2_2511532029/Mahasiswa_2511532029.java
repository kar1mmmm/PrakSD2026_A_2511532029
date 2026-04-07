package pekan2_2511532029;

public class Mahasiswa_2511532029{
	String nim;
	String nama;
	String prodi;
	Mahasiswa_2511532029 (String nim, String nama, String prodi){
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
	}
	@Override
	public String toString() {
		return "NIM: " + nim + ", Nama: " + nama + ", Prodi: " + prodi;
	}

}