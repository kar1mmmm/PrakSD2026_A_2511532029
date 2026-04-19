package pekan3_25115302029;

public class Website_2511532029 {
    private String judul_2029;
    private String url_2029;

    public Website_2511532029(String judul_2029, String url_2029) {
        this.judul_2029 = judul_2029;
        this.url_2029 = url_2029;
    }

    public String getJudul_2029() { return judul_2029; }
    public String getUrl_2029() { return url_2029; }

    public void setJudul_2029(String judul_2029) { this.judul_2029 = judul_2029; }
    public void setUrl_2029(String url_2029) { this.url_2029 = url_2029; }

    @Override
    public String toString() {
        return "Judul: " + judul_2029 + "\nURL  : " + url_2029;
    }
}