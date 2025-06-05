import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[] sours, bitters;
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sours = new int[n];
        bitters = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sours[i] = Integer.parseInt(st.nextToken());
            bitters[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            cook(i + 1, sours[i], bitters[i]);
            visited[i] = false;
        }
        System.out.println(min);
    }

    public static void cook(int idx, int sourSum, int bitterSum) {
        min = Math.min(min, Math.abs(sourSum - bitterSum));
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cook(i + 1, sourSum * sours[i], bitterSum + bitters[i]);
                visited[i] = false;
            }
        }
    }
}
