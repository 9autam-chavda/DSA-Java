package sort;

public class selectionSort {
    public static void main(String[] args) {
        System.out.println("03052025");
        int[] arr = {9,4,3,6,1,2};

        for(int i=0; i<arr.length-1; i++) {
            int smallest = i; 
            for(int j=i+1; j<arr.length; j++) {
                if (arr[smallest]>arr[j]) {
                    smallest=j;
                }
            }
            int temp = arr[i];
                arr[i] = arr[smallest];
                arr [smallest] = temp;
        }

        for(int k=0; k<arr.length; k++) {
            System.out.print("\t"+arr[k]);
        }
    }
}
