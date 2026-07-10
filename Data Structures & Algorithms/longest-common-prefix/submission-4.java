class Solution {
    public String longestCommonPrefix(String[] strs) {
        //edge case handling
        if(strs == null || strs.length == 0){
            return "";
        }
        //let us take first element as common prefix for all
        String commonPrefix = strs[0];
        //now iterate the arry
        for(int i = 1;i < strs.length;i++){
            String currentString = strs[i];
            //now checking if my currentString starts with commonPrefix.If not will remove last element and continue
            while(!currentString.startsWith(commonPrefix)){
                commonPrefix = commonPrefix.substring(0,commonPrefix.length()-1);
                if(commonPrefix.isEmpty()){
                    return "";
                }
            }
        }
        return commonPrefix;
    }
}