package Pekan6_2511532029;

public class HapusDLL_2511532029 {
	public static NodeDLL_2511532029 delHead_2029(NodeDLL_2511532029 head_2029) {
		if (head_2029 == null) {
			return null;}
		NodeDLL_2511532029 temp_2029 = head_2029;
		head_2029  = head_2029.next_2029;
		if (head_2029 != null) {
			head_2029.prev_2029 = null;
			
		} 
		return head_2029;}
			
		
		
		public static NodeDLL_2511532029 delLast_2029(NodeDLL_2511532029 head_2029) {
			if (head_2029 ==  null) {
				return null;	}
			if (head_2029.next_2029 == null) {
				return null;
			}
			NodeDLL_2511532029 curr_2029 = head_2029;
			while (curr_2029.next_2029 != null) {
				curr_2029 = curr_2029.next_2029;
			}
			if (curr_2029.prev_2029 != null) {
				curr_2029.prev_2029.next_2029 = null;
			}
		return head_2029;
	}
		
		public static NodeDLL_2511532029 delPos_2029(NodeDLL_2511532029 head_2029, int pos_2029) {
			if (head_2029 == null) {
				return head_2029; }
			NodeDLL_2511532029 curr_2029 = head_2029;
			
			for (int i_2029 = 1 ; curr_2029 != null && i_2029 < pos_2029; ++i_2029) {
				curr_2029 = curr_2029.next_2029;
			}
			if (curr_2029 == null) {
				return head_2029;
			}
			if (curr_2029.prev_2029 != null) {
				curr_2029.prev_2029.next_2029 = curr_2029.next_2029;
			}
			if (curr_2029.next_2029 != null) {
				curr_2029.next_2029.prev_2029 = curr_2029.prev_2029;
			}
			return head_2029;
		}
		
		public static void printList_2029(NodeDLL_2511532029 head_2029) {
			NodeDLL_2511532029 curr_2029 = head_2029;
			while (curr_2029 != null) {
				System.out.print(curr_2029.data_2029 + "<->");
				curr_2029 = curr_2029.next_2029;
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
			NodeDLL_2511532029 head_2029 = new NodeDLL_2511532029(1);
			head_2029.next_2029 = new NodeDLL_2511532029(2);
			head_2029.next_2029.prev_2029 = head_2029;
			head_2029.next_2029.next_2029 = new NodeDLL_2511532029(3);
			head_2029.next_2029.next_2029.prev_2029 = head_2029.next_2029;
			head_2029.next_2029.next_2029.next_2029 = new NodeDLL_2511532029 (4);
			head_2029.next_2029.next_2029.next_2029.prev_2029 = head_2029.next_2029.next_2029;
			head_2029.next_2029.next_2029.next_2029.next_2029 = new NodeDLL_2511532029(5);
			head_2029.next_2029.next_2029.next_2029.next_2029.prev_2029 = head_2029.next_2029.next_2029.next_2029;
			
			System.out.print("DLL Awal : ");
			printList_2029(head_2029);
			
			System.out.print("setelah dihapus : ");
			head_2029 = delHead_2029(head_2029);
			printList_2029(head_2029);
			
			
			System.out.print("Setelah node terakhir dihapus");
			head_2029 = delLast_2029(head_2029);
			printList_2029(head_2029);
			
			System.out.print("menghapus kode kedua");
			head_2029 = delPos_2029(head_2029, 2);
			
			printList_2029(head_2029);
			
			
			
			
		}
}


