package Pekan6_2511532029;

public class Lagu_2511532029 {
    // Atribut data lagu
    String judul_2029;
    String penyanyi_2029;
    // Pointer 
    Lagu_2511532029 next_2029;
    Lagu_2511532029 prev_2029;

    // Constructor
    public Lagu_2511532029(String judul_2029, String penyanyi_2029) {
        this.judul_2029 = judul_2029;
        this.penyanyi_2029 = penyanyi_2029;
        this.next_2029 = null;
        this.prev_2029 = null;
    }

    // Getter & Setter untuk data
    public String getJudul_2029() { return judul_2029; }
    public void setJudul_2029(String judul_2029) { this.judul_2029 = judul_2029; }

    public String getPenyanyi_2029() { return penyanyi_2029; }
    public void setPenyanyi_2029(String penyanyi_2029) { this.penyanyi_2029 = penyanyi_2029; }

    // Getter & Setter untuk pointer
    public Lagu_2511532029 getNext_2029() { return next_2029; }
    public void setNext_2029(Lagu_2511532029 next_2029) { this.next_2029 = next_2029; }

    public Lagu_2511532029 getPrev_2029() { return prev_2029; }
    public void setPrev_2029(Lagu_2511532029 prev_2029) { this.prev_2029 = prev_2029; }
}