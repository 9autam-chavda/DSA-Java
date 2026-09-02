class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean isEven = true;
        boolean isOdd = true;

        for(int i=0; i<n; i++) {
            boolean isSet = false;
            for(int j=0; j<n; j++) {
                if(i==j){
                    if(nums1[i]%2 == 0) {
                        isSet = true;
                        break;
                    }
                }
                else {
                    int remain = nums1[i] - nums1[j];
                    if(remain%2 == 0) {
                        isSet = true;
                        break;
                    }
                }
            }
            if(!isSet) {
                isEven = false;
                break;
            }
        }

        for(int i=0; i<n; i++) {
            boolean isSet = false;
            for(int j=0; j<n; j++) {
                if(i==j){
                    if(nums1[i]%2 != 0) {
                        isSet = true;
                        break;
                    }
                }
                else {
                    int remain = nums1[i] - nums1[j];
                    if(remain%2 != 0) {
                        isSet = true;
                        break;
                    }
                }
            }
            if(!isSet) {
                isOdd = false;
                break;
            }
        }

        return isEven || isOdd;

    }
}