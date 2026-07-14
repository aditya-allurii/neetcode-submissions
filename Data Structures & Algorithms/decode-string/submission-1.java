class Solution {
    public String decodeString(String s) {
        Stack<String> Stringstack = new Stack<>();
        Stack<Integer> Countstack = new Stack<>();
        String current = "";
        int currentcount = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currentcount = currentcount * 10 + (c - '0');
            }
            else if(Character.isLetter(c)){
                current += c;
            }
            else if(c == '['){
                Stringstack.push(current);
                Countstack.push(currentcount);

                current = "";
                currentcount = 0;
            }else if(c == ']'){
                String prev = Stringstack.pop();
                int count = Countstack.pop();
                String repeated = "";
                for(int j =0;j<count;j++){
                    repeated += current;
                }
                current = prev + repeated;
            }
        }
        return current;
    }
}