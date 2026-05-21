package pekan7_2511532029;

public class Mahasiswa_2511532029 {
    private String nama_2029;
    private String nim_2029;
    private String prodi_2029;

    public Mahasiswa_2511532029(String nama, String nim, String prodi) {
        this.nama_2029 = nama;
        this.nim_2029 = nim;
        this.prodi_2029 = prodi;
    }

    public String getNama_2029() { return nama_2029; }
    public String getNim_2029() { return nim_2029; }
    public String getProdi_2029() { return prodi_2029; }

    public String toString_2029() {
        return nama_2029 + " (" + nim_2029 + ")";
    }
}