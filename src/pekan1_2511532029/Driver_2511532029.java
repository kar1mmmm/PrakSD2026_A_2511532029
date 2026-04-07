package pekan1_2511532029;

public class Driver_2511532029 {
    public static void main(String[] args) {
      
        Mobil_2511532029 manager = new Mobil_2511532029();

     
        Mobil_2511532029 m1 = new Mobil_2511532029("Avanza", 2020, 1300, 150000000L, "Toyota");
        Mobil_2511532029 m2 = new Mobil_2511532029("Mustang GT", 2018, 5000, 3000000000L, "Ford");
        Mobil_2511532029 m3 = new Mobil_2511532029("911", 2023, 2000, 1750000000L, "Porsche");
     
        manager.tambahMobil(m1);
        manager.tambahMobil(m2);
        manager.tambahMobil(m3);
        
        manager.tampilkanDaftar();

        manager.hapusMobil(m1);
        
        manager.tampilkanDaftar();
    }
}
