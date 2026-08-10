package sort;

public class mergeSort {
    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Mergesort(int[] arr, int si, int ei) {
        if(si>=ei) {
            return;
        }

        int mid = si+(ei-si)/2;
        Mergesort(arr, si, mid); // right side
        Mergesort(arr, mid+1, ei); // left side

        Merge(arr, si, mid, ei);
    }

    public static void Merge(int[] arr, int si, int mid, int ei) {
        int[] tArr = new int[ei-si+1];

        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei) {
            if(arr[i]<arr[j]) {
                tArr[k] = arr[i];
                i++;
            }
            else {
                tArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i<=mid) {
            tArr[k++]=arr[i++];
        }
        while (j<=ei) {
            tArr[k++]=arr[j++];
        }

        for (k=0, i=si; k<tArr.length; k++, i++) {
            arr[i] = tArr[k];
        }
    }
    public static void main(String[] args) {
        int [] arr = {3, 4, 6, 3, 9, 2};
        Mergesort(arr, 0, arr.length-1);
        printArr(arr);
    }
}

/*
 time complexity of this code : O(nlogn)
 */
