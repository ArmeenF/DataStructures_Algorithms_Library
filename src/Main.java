import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DataStructures ds = new DataStructures();
        int size = 5;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        list = randomizer(list);
        System.out.println(list);
        ds.mergeSort(list);
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
