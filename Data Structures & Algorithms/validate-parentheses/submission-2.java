class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if(ch == ')' && stack.peek() != '('){
                    return false;
                }
                if(ch == '}' && stack.peek() != '{'){
                    return false;
                }
                if(ch == ']' && stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
