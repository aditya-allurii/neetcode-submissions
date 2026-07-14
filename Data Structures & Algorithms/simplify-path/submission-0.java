class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String s : paths){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(String dir : stack){
            ans.append("/").append(dir);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}