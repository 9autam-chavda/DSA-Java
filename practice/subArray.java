package practice;

public class subArray {
    public static void main(String[] args) {
        int[] arr = {2,4,8,10};
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<j+1; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println();
                System.out.println(sum);
                if (sum>max) {
                    max = sum;
                }
            }
            
        }

        System.out.println(max);
            

    }
}
