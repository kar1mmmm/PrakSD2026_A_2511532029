package pekan3_25115302029;

public class stackArray_2511532029 {
	static final int MAX_2029 = 1000;
	int top_2029;
	int a_2029[] = new int [MAX_2029];
	boolean isEmpty_2029() {
		return (top_2029 < 0);
	}
	stackArray_2511532029(){
		top_2029 = -1;
	}
	boolean push_2029 (int x) {
		if (top_2029 >= (MAX_2029 -1 )) {
			System.out.println("Stack Overflow");
			return false;
		}
		else  {
			a_2029[++top_2029] = x;
			System.out.println(x + "dimasukan data stack");
			return true;
		}
	}
	int pop_2029 () {
		if (top_2029 < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x_2029 = a_2029[top_2029--];
			return x_2029;
		}
	}
	int peek_2029 () {
		if (top_2029 < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x_2029 =a_2029[top_2029];
			return x_2029;
		}
	}
	void print_2029 () {
		for (int i = top_2029; i>-1; i-- ) {
			System.out.print(" " + a_2029[i]);
		}
	}
}
