package Pekan5_2511532029;

public class PencarianSSL_2511532029 {
	static boolean searchKey_2029 (NodeSSL_2511532029 head, int key) {
		NodeSSL_2511532029 curr_2029 = head;
		while (curr_2029 != null) {
			if (curr_2029.data_2029 == key)
				return true;
			curr_2029 = curr_2029.next_2029;	}
		
		return false;	}
	
		public static void traversal (NodeSSL_2511532029 head) {
			NodeSSL_2511532029 curr_2029 = head;
			
			while (curr_2029 != null) {
				System.out.print(" " + curr_2029.data_2029);
				curr_2029 = curr_2029.next_2029;	}
			System.out.println();	}

	public static void main(String[] args) {
		NodeSSL_2511532029 head = new NodeSSL_2511532029(14);
		head.next_2029 = new NodeSSL_2511532029(21);
		head.next_2029.next_2029 = new NodeSSL_2511532029(13);
		head.next_2029.next_2029.next_2029 = new NodeSSL_2511532029(30);
		head.next_2029.next_2029.next_2029.next_2029 = new NodeSSL_2511532029(10);
		System.out.print("Penelusuran SSL : ");
		traversal(head);
		
		int key = 30;
		System.out.print("cari data " + key+ "=");
			if (searchKey_2029(head,key))
				System.out.println("Ketemu");
			else 
				System.out.println("tidak ada");

	}

}
