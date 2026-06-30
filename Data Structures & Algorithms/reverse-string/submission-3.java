class Solution {
    public void reverseString(char[] s) {
        //swapping concept using two pointers
        int start = 0;
        int end = s.length-1;
        while(start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}