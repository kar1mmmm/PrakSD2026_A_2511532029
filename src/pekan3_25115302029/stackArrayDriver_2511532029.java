package pekan3_25115302029;

public class stackArrayDriver_2511532029 {
	public static void main (String[]args) {
		stackArray_2511532029 s =  new stackArray_2511532029();
		s.push_2029(10);
		s.push_2029(20);
		s.push_2029(30);
		System.out.println(s.pop_2029() + " dikeluarkan dari stack ");
		System.out.println("dikeluarkan dari stack " + s.peek_2029());
		System.out.print("elemen pada stack");
		s.print_2029();
	}
}
