package pekan3_25115302029;

import java.util.Stack;

public class NilaiMaksimum_2511532029 {
    public static int max_2029(Stack<Integer> s_2029){
        Stack<Integer> backup_2029 = new Stack<Integer>();
        int maxValue_2029 = s_2029.pop();
        backup_2029.push(maxValue_2029);
        while (!s_2029.isEmpty()){
            int next_2029 = s_2029.pop();
            backup_2029.push(next_2029);
            maxValue_2029 = Math.max(maxValue_2029,next_2029);
        }
        while (!backup_2029.isEmpty()) {
            s_2029.push(backup_2029.pop());
        }
        return maxValue_2029;
    }
    public static void main(String[] args){
        Stack<Integer> s_2029 = new Stack<Integer>();
        s_2029.push(70);
        s_2029.push(12);
        s_2029.push(20);
        System.out.println("isi stack " + s_2029);
        System.out.println("Stack Teratas " + s_2029.peek());
        System.out.println("Nilai maksimum " + max_2029(s_2029));
    }
}