package sort;

public class insertionSort {
    public static void main(String[] args) {
        System.out.println("03052025");
        int[] arr = {9,4,3,6,1,2};

        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        for(int k=0; k<arr.length; k++) {
            System.out.print("\t"+arr[k]);
        }
    }
    
}
