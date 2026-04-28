package pekan4_2511532029;
import java.util.*;
public class ReverseData_2511532029 {

	public static void main(String[] args) {
		Queue<Integer> q_2029 = new LinkedList <Integer>();
		q_2029.add(1);
		q_2029.add(2);
		q_2029.add(3);
		System.out.println("sebelum reverse" + q_2029);
		Stack<Integer> s_2029 = new Stack<Integer>();
		while 
			(!q_2029.isEmpty()) {
			s_2029.push(q_2029.remove());
		}
		while (!s_2029.isEmpty()) {
			q_2029.add(s_2029.pop());
		}
		System.out.println("Sesudah reverse = " + q_2029);
	}

}
