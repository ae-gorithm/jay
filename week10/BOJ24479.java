import java.io.*;
import java.util.*;

class Point {

    private int x, order;

    private List<Point> adj;

    public Point(int x) {
        this.x = x;
        this.adj = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void addAdj(Point p) {
        adj.add(p);
    }

    public List<Point> getAdj() {
        return adj;
    }

    public void sortAdj() {
        adj.sort(Comparator.comparingInt(Point::getX));
    }

}

public class Main {

    public static int n, m, order = 0;
    public static Point[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new Point[n + 1];
        visited = new boolean[n + 1];
        visited[r] = true;
        for (int i = 1; i <= n; i++) {
            graph[i] = new Point(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].addAdj(graph[b]);
            graph[b].addAdj(graph[a]);
        }
        for (int i = 1; i <= n; i++) {
            graph[i].sortAdj();
        }
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(graph[i].getOrder()).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int r) {
        visited[r] = true;
        graph[r].setOrder(++order);
        for (Point p : graph[r].getAdj()) {
            if (!visited[p.getX()]) {
                dfs(p.getX());
            }
        }
    }
}
