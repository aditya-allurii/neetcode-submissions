class Solution {
    public String longestCommonPrefix(String[] strs) {

        //edge case

        if(strs == null || strs.length == 0){
            return "";
        }
        //lets assume first string is my common prefix
        String prefix = strs[0];
        //now loop the strings
        for(int i = 1;i<strs.length;i++){
            String currentstring = strs[i];
            while(!currentstring.startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}