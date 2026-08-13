package greedy_algorithms;
import java.util.*;

public class activitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        int [][]  activities = new int[start.length][3];

        for (int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // now we have to sort that 2D array
        // in 2D array we will sort as per end time
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2])); // ->> lamda function in short form 


        int maxact = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxact = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];

        for(int j=0; j<end.length; j++) {
            if(activities[j][1] >= lastend) {
                maxact++;
                ans.add(activities[j][0]);
                lastend = activities[j][2];
            }
        }

        System.out.println("maximum activity can do : " + maxact);
        for(int k=0; k<ans.size(); k++) {
            System.out.println("A" + ans.get(k) + " ");
        }


    }
}
