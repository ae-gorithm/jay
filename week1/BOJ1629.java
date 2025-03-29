import java.io.*;
import java.util.*;

public class Main {

    public static long cal(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long p = cal(a, b / 2, c);
        if (b % 2 == 1) {
            return (p * p % c) * a % c;
        }
        return p * p % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(cal(a, b, c));
    }
}
