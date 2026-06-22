class Solution {
    public boolean isAnagram(String s, String t) {
        //we will use hahsmap for frequency count
        Map<Character,Integer> map = new HashMap<>();
        //add characters of String s to map
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //now put the String t characters and decrease their count
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
        }
        //now check the frequencies that is values if they are not zero return false
        for(int count : map.values()){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
