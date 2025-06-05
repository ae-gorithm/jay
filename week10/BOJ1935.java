import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Map<Character, Double> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(br.readLine());
            map.put((char) ('A' + i), num);
        }
        Stack<Double> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(map.get(c));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
}
