import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Tree<E extends Comparable> {
    private Node root;

    public Tree() {
        root = null;
    }

    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(Node root) {
        return root == null
                ? 0
                : 1 + Math.max(heightHelper(root.left), heightHelper(root.right));
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(Node root) {
        return root == null
                ? 0
                : sizeHelper(root.left) + 1 + sizeHelper(root.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E o) {
        return containsHelper(root, o);
    }

    private boolean containsHelper(Node root, E o) {
        if (root == null) {
            return false;
        } else if (root.value.compareTo(o) == 0) {
            return true;
        } else if (root.value.compareTo(o) > 0) {
            return containsHelper(root.left, o);
        } else {
            return containsHelper(root.left, o);
        }
    }

    public boolean add(E object) {
        if(root == null) {
            root = new Node(object);
            return true;
        } else {
            return addHelper(object, root);
        }
    }

    private boolean addHelper(E object, Node root) {
        if(root.value.compareTo(object) > 0) {
            if(root.left == null) {
                root.left = new Node(object);
                return true;
            } else {
                return addHelper(object, root.left);
            }
        } else if(root.value.compareTo(object) < 0) {
            if(root.right == null) {
                root.right = new Node(object);
                return true;
            } else {
                return addHelper(object, root.right);
            }
        } else {
            return false;
        }
    }

    public void clear() {
        root = null;
    }

    private class Node implements Comparable<Node> {
        private Node right;
        private Node left;
        private final E value;

        private Node(E value) {
            this.right = null;
            this.left = null;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return value.compareTo(node.value);
        }
    }

    public ArrayList toArrayList() {
        ArrayList<E> arrayList = new ArrayList<>();
        toListHelper(root, arrayList);
        return arrayList;
    }

    private void toListHelper(Node root, ArrayList<E> list) {
        if(root != null) {
            list.add(root.value);
            toListHelper(root.right, list);
            toListHelper(root.left, list);
        }
    }
}
