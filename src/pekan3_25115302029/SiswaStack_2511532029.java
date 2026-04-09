package pekan3_25115302029;
import java.util.ArrayList;

class Siswa_2511532029{
	String nama_2029;
	int nim_2029;
	
	public Siswa_2511532029 (String nama_2029, int nim_2029) {
		this.nama_2029 = nama_2029;
		this.nim_2029 = nim_2029;
	}
	@Override
	public String toString() {
		return "Nim: " + nim_2029 + ", Nama: "+ nama_2029;
	}
	
}

public class SiswaStack_2511532029 {
	private ArrayList<Siswa_2511532029> stack_2029;
	
	public SiswaStack_2511532029() {
		stack_2029 =  new ArrayList<>();
	}
	
	public void push_2029 (Siswa_2511532029 mhs) {
		stack_2029.add(mhs);
	}
	
	public Siswa_2511532029 pop_2029() {
		if (!isEmpty()) {
			return stack_2029.remove(stack_2029.size() - 1);
		}
		return null;
	}
	
	
	public Siswa_2511532029 peek_2029 () {
		if (!isEmpty()) {
			return stack_2029.get(stack_2029.size() -1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack_2029.isEmpty();
	}
	public void tampilkanSiswa() {
		for (int i = stack_2029.size() - 1; i >= 0; i--) {
			System.out.println(stack_2029.get(i));
		}
	}
	public static void main (String[] args) {
		SiswaStack_2511532029 studentStack_2029 =  new SiswaStack_2511532029();
		
		Siswa_2511532029 mhs1 =  new Siswa_2511532029("ali",1);
		Siswa_2511532029 mhs2 =  new Siswa_2511532029("boby",2);
		Siswa_2511532029 mhs3 =  new Siswa_2511532029("charles",3);
		
		studentStack_2029.push_2029(mhs1);
		studentStack_2029.push_2029(mhs2);
		studentStack_2029.push_2029(mhs3);
		
		System.out.println("Siswa di dalam stack");
		studentStack_2029.tampilkanSiswa();
		
		System.out.println("siswa teratas" + studentStack_2029.peek_2029());
		System.out.println("mengeluarkan siswa teratas dari stack: " + studentStack_2029.pop_2029());
		System.out.println("daftar siswa setelah di pop : ");
		studentStack_2029.tampilkanSiswa();
	}
}
