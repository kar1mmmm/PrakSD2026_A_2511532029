package Pekan6_2511532029;

public class PenelusuranDLL_2511532029 {
	static void forwardTraversal(NodeDLL_2511532029 head_2029) {
		NodeDLL_2511532029 curr_2029 = head_2029;
		while (curr_2029 != null) {
			System.out.print(curr_2029.data_2029  + "<->");
			curr_2029 = curr_2029.next_2029;
		}
		System.out.println();
	}
	
	static void backwardTraversal_2029(NodeDLL_2511532029 tail_2029) {
		NodeDLL_2511532029 curr_2029 = tail_2029;
		while (curr_2029 != null) {
			System.out.println(curr_2029.data_2029 + "<->");
			
			curr_2029 = curr_2029.prev_2029;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		NodeDLL_2511532029 head_2029 = new NodeDLL_2511532029(1);
				NodeDLL_2511532029 second_2029 = new NodeDLL_2511532029(2);
				NodeDLL_2511532029 third_2029 = new NodeDLL_2511532029(3);
				
				head_2029.next_2029 = second_2029;
				second_2029.prev_2029 = head_2029;
				second_2029.next_2029 = third_2029;
				third_2029.prev_2029 = second_2029;
				
				System.out.println("Penelusuran maju:");
				forwardTraversal(head_2029);
				
				System.out.println("Penelusuran mundur:");
				backwardTraversal_2029 (third_2029);
				

	}

}
