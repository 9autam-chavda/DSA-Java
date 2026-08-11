package Heaps;
import java.util.ArrayList;

public class heapImpliment {
    static class Heaps {
        ArrayList<Integer> HP = new ArrayList<>();

        public void add(int val) { //O(logn)
            // add value ad last idx
            HP.add(val);

            int x = HP.size()-1; // child idx
            int par = (x-1) / 2; // parent idx

            while (HP.get(x) < HP.get(par)) {
                int temp = HP.get(x);
                HP.set(x, HP.get(par));
                HP.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return HP.get(0);
        }

        private void Heapify (int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < HP.size() && HP.get(minIdx) > HP.get(left)) {
                minIdx = left;
            }

            if(right < HP.size() && HP.get(minIdx) > HP.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                int temp = HP.get(i);
                HP.set(i, HP.get(minIdx));
                HP.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        public int remove () {
            //get the value
            int data = HP.get(0);

            //swap last with first
            int temp = HP.get(HP.size()-1);
            HP.set(0, HP.get(HP.size()-1));
            HP.set(HP.size()-1, temp);

            //Heapify
            Heapify(0);
            return data;

        }

        public boolean isEmpty() {
            return HP.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heaps h = new Heaps();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }

        
    }
}
