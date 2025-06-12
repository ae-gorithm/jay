import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static Integer[] dp;

    public static int lis(int idx) {
        if (dp[idx] == null) {
            dp[idx] = arr[idx];
            for (int i = idx - 1; i > 0; i--) {
                if (arr[i] < arr[idx]) {
                    dp[idx] = Math.max(dp[idx], lis(i) + arr[idx]);
                }
            }
        }
        return dp[idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, lis(i));
        }
        System.out.println(max);
    }
}