class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);

        }
        return sb.toString();
    }
    public List<String> decode(String strs) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < strs.length()){
            int j = i;
            while(strs.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(strs.substring(i,j));
            ans.add(strs.substring(j+1,j+1+len));
            i = j + 1 + len;
        }
        return ans;
    }
}