import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(pooling(matrix, n, n, n));
    }

    public static int pooling(int[][] matrix, int n, int r, int c) {
        int[] arr = new int[4];
        int idx = 0;
        if (n == 2) {
            for (int i = r - 1; i <= r; i++) {
                for (int j = c - 1; j <= c; j++) {
                    arr[idx++] = matrix[i][j];
                }
            }
        } else {
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    arr[idx++] = pooling(matrix, n / 2, r - i * (n / 2), c - j * (n / 2));
                }
            }
        }
        Arrays.sort(arr);
        return arr[2];
    }
}
