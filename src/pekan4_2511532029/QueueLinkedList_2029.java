package pekan4_2511532029;

import java.util.Queue;
import java.util.*;

public class QueueLinkedList_2029 {

	public static void main(String[] args) {
		Queue<Integer> q_2029 = new LinkedList<>();
		
		for (int i_2029 =  0; i_2029 < 6; i_2029++)
			q_2029.add(i_2029);
		 System.out.println("Elemen Antrean" + q_2029);
		
		 int hapus_2029 = q_2029.remove();
		 System.out.println("Hapus elemen = " + hapus_2029);
		 System.out.println(q_2029);
		 
		 int depan_2029 = q_2029.peek();
		 System.out.println("Kepala antrean = " + depan_2029);
		 
		 int banyak_2029 = q_2029.size();
		 System.out.println("Size antran =" + banyak_2029);
		 
	}

}
