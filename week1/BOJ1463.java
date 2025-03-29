import java.io.*;
import java.util.*;

class Point {

    private int x, cnt;

    public Point(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getCnt() {
        return cnt;
    }
}

public class Main {

    public static int bfs(int n) {
        Queue<Point> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Point(1, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.getX(), cnt = p.getCnt();
            if (x == n) {
                return cnt;
            }
            if (x > n || visited.contains(x)) {
                continue;
            }
            visited.add(x);
            queue.offer(new Point(x * 3, cnt + 1));
            queue.offer(new Point(x * 2, cnt + 1));
            queue.offer(new Point(x + 1, cnt + 1));
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bfs(n));
    }
}
