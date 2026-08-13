package practice;

public class kadanes {

    public static void main(String[] args) {
        int[] arr = {-4,-1,4};

    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int i=0; i<arr.length; i++) {
        sum = sum + arr[i];

        if (sum<0) {
            sum = 0;
        }
        max = Math.max(sum, max);
    }
    System.out.println(max);
    }
}
