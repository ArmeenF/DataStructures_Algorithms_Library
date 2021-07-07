import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // dataStructuresTest();
        // binaryTreeTest();
        linkedListTest();
    }

    public static void dataStructuresTest() {
        DataStructures ds = new DataStructures();
        int size = 7;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        list = randomizer(list);
        System.out.println(list);
        ds.bubbleSort(list);
    }

    public static void binaryTreeTest() {
        BinaryTree t = new BinaryTree();

        System.out.println(t.preorder());
        System.out.println(t.inorder());
        System.out.println(t.postorder());
    }

    public static void linkedListTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());
        list.add(5);
        list.add(6);
        list.add(1, 8);
        list.add(2, 13);
        int i = list.remove(2);
        System.out.println(i);
        System.out.println(list);
    }

    public static List<Integer> randomizer(List<Integer> list) {

        // create a new list to return out of the old list
        List<Integer> random = new ArrayList<Integer>();
        Random rand = new Random();

        // while there are items to be randomized
        while (list.size() > 0) {
            int i = Math.abs(rand.nextInt() % list.size());

            random.add(list.remove(i));
        }
        return random;
    }
}
