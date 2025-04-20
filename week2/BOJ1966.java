import java.io.*;
import java.util.*;

class Point {

    private int idx, priority;

    public Point(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }

    public int getIdx() {
        return idx;
    }

    public int getPriority() {
        return priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            Queue<Point> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Point(i, priority));
                pQueue.offer(priority);
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int maxPriority = pQueue.peek();
                if (p.getPriority() == maxPriority) {
                    pQueue.poll();
                    cnt++;
                    if (p.getIdx() == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    queue.offer(p);
                }
            }
        }
        System.out.print(sb);
    }
}
