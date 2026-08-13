package practice;

import java.util.ArrayList;

public class swapListElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(3);
        list.add(7);

        System.out.println(list);

        int temp = list.get(0);
        list.set(0, list.get(2));
        list.set(2, temp);

        System.out.println(list);
        }
}
