class Solution {
    public String longestCommonPrefix(String[] strs) {
        //edge case 
        if(strs == null || strs.length == 0){
            return "";
        }
        //let us take 1st string as longestprefix one 
        String prefix = strs[0];
        //loop through the strs
        for(int i = 1;i<strs.length;i++){
            //take the current string
            String currentString = strs[i];
            //now i will check my current starts with prfeix or not if not then i will reduce my prefix by removing the last chars
            while(!currentString.startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length() == 0){
                    //also we can write prefix.isEmpty()
                    return "";
                }
            }
        }
        return prefix;
    }
}