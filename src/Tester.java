public class Tester {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(4);

        System.out.println(tree.toArrayList());
        System.out.println("Contains 2: " + tree.contains(2));
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());
    }
}
