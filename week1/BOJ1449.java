import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken()) * 2 + 1;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) * 2;
        }
        Arrays.sort(arr);
        int m = arr[n - 1] + 2;
        boolean[] pipes = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            pipes[arr[i] - 1] = pipes[arr[i]] = pipes[arr[i] + 1] = true;
        }
        int cnt = 0;
        for (int i = 0; i <= m; i++) {
            if (pipes[i]) {
                cnt++;
                for (int j = i; j < i + l && j <= m; j++) {
                    pipes[j] = false;
                }
            }
        }
        System.out.println(cnt);
    }
}
