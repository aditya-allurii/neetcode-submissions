class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //lets build key value pairs both as strings
        //edge case
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                freq[c - 'a']++;
            }
            //now key
            StringBuilder key = new StringBuilder();
            for(int i = 0;i<26;i++){
                if(freq[i] > 0){
                    key.append((char)('a' + i));
                    key.append("#");
                    key.append(freq[i]);
                }
            }
            //convert to string
            String freqkey = key.toString();
            if(!map.containsKey(freqkey)){
                map.put(freqkey,new ArrayList<>());
            }
            map.get(freqkey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
