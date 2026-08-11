package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    static class student implements Comparable<student> {
        int rank;
        String name;

        student (int rank, String name) {
            this.rank = rank;
            this.name = name;
        }
        
        @Override
        public int compareTo(student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<student> s = new PriorityQueue<>(Comparator.reverseOrder());

        s.add(new student(9, "gautam"));
        s.add(new student(99, "gc"));
        s.add(new student(8, "pr"));
        s.add(new student(89, "ad"));

        while (!s.isEmpty()) {
            System.out.println(s.peek().name + "->" + s.peek().rank);
            s.remove();
        }
    }
}
