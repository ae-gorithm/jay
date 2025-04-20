import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class node {
    private char data;
    private node left, right;

    public node(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public node getLeft() {
        return left;
    }

    public node getRight() {
        return right;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public void setRight(node right) {
        this.right = right;
    }
}

public class Main {

    static node[] tree;
    static StringBuilder sb;

    public static void preorder(char data) {
        sb.append(tree[data - 'A'].getData());
        if (tree[data - 'A'].getLeft() != null) {
            preorder(tree[data - 'A'].getLeft().getData());
        }
        if (tree[data - 'A'].getRight() != null) {
            preorder(tree[data - 'A'].getRight().getData());
        }
    }

    public static void inorder(char data) {
        if (tree[data - 'A'].getLeft() != null) {
            inorder(tree[data - 'A'].getLeft().getData());
        }
        sb.append(tree[data - 'A'].getData());
        if (tree[data - 'A'].getRight() != null) {
            inorder(tree[data - 'A'].getRight().getData());
        }
    }

    public static void postorder(char data) {
        if (tree[data - 'A'].getLeft() != null) {
            postorder(tree[data - 'A'].getLeft().getData());
        }
        if (tree[data - 'A'].getRight() != null) {
            postorder(tree[data - 'A'].getRight().getData());
        }
        sb.append(tree[data - 'A'].getData());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new node((char) ('A' + i));
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left != '.') {
                tree[root - 'A'].setLeft(tree[left - 'A']);
            }
            if (right != '.') {
                tree[root - 'A'].setRight(tree[right - 'A']);
            }
        }
        sb = new StringBuilder();
        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        System.out.println(sb);
    }
}
