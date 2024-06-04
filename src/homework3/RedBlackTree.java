package homework3;

import java.util.ArrayList;


public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;


    public ArrayList<Entry> get(String searchableName) {
        Node x = root;

        int redEdges = 0;
        int blackEdges = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                if (isRed(x.left)) redEdges++;
                else blackEdges++;
                x = x.left;
            } else if (cmp > 0) {
                if (isRed(x.right)) redEdges++;
                else blackEdges++;
                x = x.right;
            } else {
                System.out.println("Red edges: " + redEdges);
                System.out.println("Black edges: " + blackEdges);
                return x.values;
            }
        }
        return null;
    }


    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }


    private Node put(Node h, String key, Entry value) {
        if (h == null) {
            return new Node(key, value, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.values.add(value);
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = 1 + size(h.left) + size(h.right);
        return h;
    }


    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2]; // [black, red]
        countEdges(root, counts);
        return counts;
    }


    private void countEdges(Node x, int[] counts) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            if (isRed(x.left)) counts[1]++;
            else counts[0]++;
        }
        if (x.right != null) {
            if (isRed(x.right)) counts[1]++;
            else counts[0]++;
        }

        countEdges(x.left, counts);
        countEdges(x.right, counts);
    }


    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }
}
