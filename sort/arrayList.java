package sort;

import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(4);
        list.add(3);
        list.add(6);

        System.out.println("Original ArrayList: " + list);

        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Reverse Sorted ArrayList: " + list);
    }
}
