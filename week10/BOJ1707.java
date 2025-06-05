import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int v, e;
    public static boolean[] visited, checked;
    public static ArrayList<Integer>[] list;
    public static Queue<Integer> queue;

    public static boolean bfs(int idx) {
        queue.offer(idx);
        checked[idx] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            visited[p] = true;
            if (list[p] != null) {
                for (int e : list[p]) {
                    if (!visited[e]) {
                        checked[e] = !checked[p];
                        queue.offer(e);
                    } else if (checked[p] == checked[e]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            visited = new boolean[v + 1];
            checked = new boolean[v + 1];
            list = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                list[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            boolean isTwoWayGraph = true;
            queue = new LinkedList<>();
            for (int i = 1; i <= v; i++) {
                if (!visited[i]) {
                    if (!bfs(i)) {
                        sb.append("NO\n");
                        isTwoWayGraph = false;
                        break;
                    }
                }
            }
            if (isTwoWayGraph) {
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }
}
