import java.io.*;

public class Main {

    public static int n;
    public static char[][] arr;

    public static void swapArr(int r1, int c1, int r2, int c2) {
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }

    public static int countCandyCol(int col) {
        int maxCnt = 1;
        for (int i = 0; i < n - 1; i++) {
            int cnt = 1;
            char c = arr[i][col];
            for (int j = i + 1; j < n; j++) {
                if (c == arr[j][col]) {
                    cnt++;
                } else {
                    break;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static int countCandyRow(int row) {
        int maxCnt = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            char c = arr[row][i];
            for (int j = i + 1; j < n; j++) {
                if (c == arr[row][j]) {
                    cnt++;
                } else {
                    break;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static int countMaxCandy() {
        int maxCnt = 0;
        for (int k = 0; k < n; k++) {
            maxCnt = Math.max(maxCnt, countCandyRow(k));
            maxCnt = Math.max(maxCnt, countCandyCol(k));
        }
        return maxCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int maxCnt = countMaxCandy();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    swapArr(i, j, i, j + 1);
                    maxCnt = Math.max(maxCnt, countCandyRow(i));
                    maxCnt = Math.max(maxCnt, countCandyCol(j));
                    maxCnt = Math.max(maxCnt, countCandyCol(j + 1));
                    swapArr(i, j, i, j + 1);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[i + 1][j]) {
                    swapArr(i, j, i + 1, j);
                    maxCnt = Math.max(maxCnt, countCandyCol(j));
                    maxCnt = Math.max(maxCnt, countCandyRow(i));
                    maxCnt = Math.max(maxCnt, countCandyRow(i + 1));
                    swapArr(i, j, i + 1, j);
                }
            }
        }
        System.out.println(maxCnt);
    }
}
