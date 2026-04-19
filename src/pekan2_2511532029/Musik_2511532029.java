package pekan2_2511532029;

public class Musik_2511532029 {
    
    private String judul_2029;
    private String penyanyi_2029;
    private int durasi_2029;

    // Constructor 
    public Musik_2511532029(String judul_2029, String penyanyi_2029, int durasi_2029) {
        this.judul_2029 = judul_2029;
        this.penyanyi_2029 = penyanyi_2029;
        this.durasi_2029 = durasi_2029;
    }

    // Getter
    public String getJudul_2029() {
    	return judul_2029; 
    }
    
    public String getPenyanyi_2029() {
    	return penyanyi_2029; 
    }
    public int getDurasi_2029() {
    	return durasi_2029; 
    }

    // Setter
    public void setJudul_2029(String judul_2029) {
    	this.judul_2029 = judul_2029; 
    }
    
    public void setPenyanyi_2029(String penyanyi_2029) {
    	this.penyanyi_2029 = penyanyi_2029; 
    }
    
    public void setDurasi_2029(int durasi_2029) { 
    	this.durasi_2029 = durasi_2029; 
    }

    @Override
    public String toString() {
        return "Judul: " + judul_2029 + " | Penyanyi: " + penyanyi_2029 + " | Durasi: " + durasi_2029 + " detik";
    }
}