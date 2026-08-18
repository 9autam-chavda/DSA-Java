class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numRows; i++) {
            int idx = i;
            int downidx = 2 * (numRows - 1 - i);
            int upidx = 2 * i;
            boolean downdirection = true;

            while(idx < s.length()) {
                sb.append(s.charAt(idx));

                if(i==0) {
                    idx += downidx;
                }
                else if (i == numRows-1) {
                    idx += upidx;
                }
                else {
                    if (downdirection) {
                        idx += downidx;
                    }
                    else {
                        idx += upidx;
                    }
                    downdirection = !downdirection;
                }
            }
        }

        return sb.toString();
    }
}