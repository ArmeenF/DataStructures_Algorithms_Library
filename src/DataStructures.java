import java.util.*;

public class DataStructures {
    public static void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean inversion = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                // check for inversion between item j and j+1
                // if so swap them
                if (list.get(j) > list.get(j + 1)) {
                    inversion = true;
                    swap(list, j, j + 1);
                }
            }
            if (!inversion)
                break;
            // loop invariant - principle that is true on every execution of the loop
            // the ith largest item will be stored in the ith largest position after
            // iteration i
            System.out.println(list);
        }
    }

    public static void selectionSort(List<Integer> list) {
        // search for the ith smallest item and put it in the ith position
        for (int i = 0; i < list.size() - 1; i++) {

            // index stores the index of the minimum item
            int index = i;
            // min is the minimum item
            int min = list.get(i);

            // minimize over items i+1 up to n-1
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    index = j;
                }
            }
            swap(list, i, index);
            System.out.println(list);
            // invariant - all items from 0 to i are in the proper position
        }
    }

    public void insertionSort(List<Integer> list) {
        // insert the ith item into items 0 to i-1 in the proper position
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0 && list.get(j) < list.get(j - 1); j--) {
                swap(list, j, j - 1);
            }
            System.out.println(list);
            // invariant - items 0...i will be in order
        }
    }

    public static void merge(List<Integer> list, int start, int finish) {
        int mid = (start + finish) / 2;
        int i = start;
        int j = mid + 1;
        List<Integer> temp = new ArrayList<Integer>();
        while (i < mid + 1 && j < finish + 1) {
            temp.add(list.get(i) < list.get(j) ? list.get(i++) : list.get(j++));
        }
        while (i < mid + 1) {
            temp.add(list.get(i++));
        }
        for (i = 0; i < temp.size(); i++) {
            list.set(start + i, temp.get(i));
        }
    }

    public void mergeSort(List<Integer> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    public static void mergeSort(List<Integer> list, int start, int finish) {
        if (start < finish) {
            System.out.println(start + " " + finish + " " + list);
            int mid = (start + finish) / 2;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, finish);
            merge(list, start, finish);
            System.out.println(start + " " + finish + " " + list);
        }
    }

    public static void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    public static void quickSort(List<Integer> list, int start, int finish) {
        if (start < finish) {
            System.out.println(start + " " + finish + " " + list);
            int pivotpos = start;
            for (int i = start; i < finish + 1; i++) {
                if (list.get(i) < list.get(start))
                    swap(list, ++pivotpos, i);
            }
            swap(list, start, pivotpos);
            quickSort(list, start, pivotpos);
            quickSort(list, pivotpos + 1, finish);
            System.out.println(start + " " + finish + " " + list);
        }
    }
}
