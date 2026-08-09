package collectionframework;

import java.util.ArrayList;
import java.util.List;

public class practice {
    static ArrayList<Integer> arr = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(90);
        list.add(91);
        list.add(92);
        list.add(93);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove(Integer.valueOf(90));
        System.out.println(list);
        list.set(0, 100);
        System.out.println(list);
        System.out.println(list.size());
    }
}
