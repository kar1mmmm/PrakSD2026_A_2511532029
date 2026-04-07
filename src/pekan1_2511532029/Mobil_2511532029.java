package pekan1_2511532029;
import java.util.*;

public class Mobil_2511532029 {

    private String nama;
    private int tahun;
    private int cc;
    private long harga;
    private String merek;
    private ArrayList<Mobil_2511532029> daftarMobil;
    
    public Mobil_2511532029() {
         this.daftarMobil = new ArrayList<>();
    }

    public Mobil_2511532029(String nama, int tahun, int cc, long harga, String merek) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merek = merek; 
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getTahun() { return tahun; }
    public void setTahun(int tahun) { this.tahun = tahun; }

    public int getCc() { return cc; }
    public void setCc(int cc) { this.cc = cc; }

    public long getHarga() { return harga; }
    public void setHarga(long harga) { this.harga = harga; }

    public String getMerek() { return merek; }
    public void setMerek(String merek) { this.merek = merek; }

    public ArrayList<Mobil_2511532029> getDaftarMobil() {
        return daftarMobil;   
    }  

    public void tambahMobil(Mobil_2511532029 m) {
         daftarMobil.add(m);
         System.out.println("Mobil berhasil ditambah: " + m.getNama());
    }
	
    public void hapusMobil(Mobil_2511532029 m) {
        if (daftarMobil.remove(m)) { 
            System.out.println("Mobil " + m.getNama() + " berhasil dihapus.");
        } else {
            System.out.println("Mobil tidak ditemukan.");
        }
    }

    public void tampilkanDaftar() {
        System.out.println("\n=== DAFTAR MOBIL SAAT INI ===");
        for (Mobil_2511532029 m : daftarMobil) {
            System.out.println(m);
        }
    }
	 
    @Override
    public String toString() {
        return String.format("Merek: %-10s | Nama: %-12s | Tahun: %d | CC: %-5d | Harga: Rp %,d", 
                merek, nama, tahun, cc, harga);
    }
}
