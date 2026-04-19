package pekan3_25115302029;
import java.util.Scanner;
import java.util.Stack;
public class stackPostfix_2511532029 {
	public static int postfixEvaluate_2029(String expression)
	{
		Stack <Integer> s_2029 = new Stack <Integer>();
		Scanner input_2029 = new Scanner (expression);
		while (input_2029.hasNext()) {
			if (input_2029.hasNextInt()){
			s_2029.push(input_2029.nextInt());
				}else {
					String operator_2029 = input_2029.next();
					int operand2_2029 = s_2029.pop();
					int operand1_2029 = s_2029.pop();
					if (operator_2029.equals("+")) {
						s_2029.push(operand1_2029 + operand2_2029);
					} else if (operator_2029.equals("-")) {
							s_2029.push(operand1_2029 -  operand2_2029);
						} else if (operator_2029.equals("*")) {
							s_2029.push(operand1_2029 * operand2_2029);
						}else {
							s_2029.push(operand1_2029/operand2_2029);
						}
					}
			}
			input_2029.close();
			return s_2029.pop();
		}
		
	
	public static void main(String[] args) {
		System.out.println("hASIL postfix ="+ postfixEvaluate_2029("5 2 4 * + 7 -"));
	}

}
