package pekan4_2511532029;
import java.util.*;
public class LiterasiQueue_2511532029 {

	public static void main(String[] args) {
		Queue<String> q_2029 = new LinkedList<>();
		
		q_2029.add("praktikum");
		q_2029.add("struktur");
		q_2029.add("data");
		q_2029.add("dan");
		q_2029.add("algoritma");
		Iterator<String> iterator_2029 = q_2029.iterator();
		while (iterator_2029.hasNext()) {
			System.out.print(iterator_2029.next()+ " ");
		}
		
		
	}

}
