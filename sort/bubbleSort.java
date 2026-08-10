package sort;

public class bubbleSort {
    public static void main(String[] args) {
        System.out.println("03052025");
        int[] arr = {9,4,3,6,1,2};

        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j+1]<arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int k=0; k<arr.length; k++) {
            System.out.print("\t"+arr[k]);
        }
    }
}
