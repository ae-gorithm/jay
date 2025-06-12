import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = 2 * n;
        int[] belts = new int[m];
        boolean[] robots = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            belts[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        while (true) {
            int tmp = belts[m - 1];
            for (int i = m - 1; i > 0; i--) {
                belts[i] = belts[i - 1];
            }
            belts[0] = tmp;
            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;
            robots[n - 1] = false;
            for (int i = n - 2; i > 0; i--) {
                if (robots[i] && !robots[i + 1] && belts[i + 1] > 0) {
                    robots[i + 1] = true;
                    robots[i] = false;
                    belts[i + 1]--;
                }
            }
            if (!robots[0] && belts[0] > 0) {
                robots[0] = true;
                belts[0]--;
            }
            cnt++;
            int zeroCnt = 0;
            for (int i = 0; i < m; i++) {
                if (belts[i] == 0) {
                    zeroCnt++;
                }
            }
            if (zeroCnt >= k) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
