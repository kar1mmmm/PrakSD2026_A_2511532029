package pekan5_2511532029;

public class Pasien_2511532029 {

    private String namaPasien_2029;
    private String penyakit_2029;
    private int nomorAntrian_2029;
    public Pasien_2511532029 next_2029;

    public Pasien_2511532029(
        String namaPasien_2029,
        String penyakit_2029,
        int nomorAntrian_2029
    ) {
        this.namaPasien_2029 = namaPasien_2029;
        this.penyakit_2029 = penyakit_2029;
        this.nomorAntrian_2029 = nomorAntrian_2029;
        this.next_2029 = null;
    }

    public String getNamaPasien_2029() {
        return namaPasien_2029;
    }

    public String getPenyakit_2029() {
        return penyakit_2029;
    }

    public int getNomorAntrian_2029() {
        return nomorAntrian_2029;
    }
}
