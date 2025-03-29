import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int target = arr[i];
            int leftCnt = 0;
            for (int j = 0; j < deque.size(); j++) {
                int p = deque.pollFirst();
                if (p == target) {
                    leftCnt = j;
                }
                deque.addLast(p);
            }
            int rightCnt = deque.size() - leftCnt;
            if (leftCnt <= rightCnt) {
                cnt += leftCnt;
                for (int j = 0; j < leftCnt; j++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                cnt += rightCnt;
                for (int j = 0; j < rightCnt; j++) {
                    deque.addFirst(deque.pollLast());
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
