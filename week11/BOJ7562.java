import java.io.*;
import java.util.*;

class Point {
    private int x, y, cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}

public class Main {

    public static int bfs(int n, boolean[][] visited, Point start, Point end) {
        int[] dx = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] dy = { 1, -1, 1, -1, 2, -2, 2, -2 };
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.getX()][start.getY()] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.getX() == end.getX() && p.getY() == end.getY()) {
                return p.getCnt();
            }
            for (int i = 0; i < 8; i++) {
                int nx = p.getX() + dx[i], ny = p.getY() + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, p.getCnt() + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            sb.append(bfs(n, visited, start, end)).append("\n");
        }
        System.out.print(sb);
    }
}
