package stack;
import java.util.*;


public class P4nxtGreater {

    // right max
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] nxtGreater = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i=arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            }
            else {
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for(int i=0; i<nxtGreater.length; i++) {
            System.out.println(nxtGreater[i] + " ");
        }
    }
}

// in this we also apply another 3 methods
// 1: left max
// 2: right min
// 3: left min