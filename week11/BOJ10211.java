import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    max = Math.max(max, arr[j] - arr[i - 1]);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
