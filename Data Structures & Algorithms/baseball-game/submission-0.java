class Solution {
    public int calPoints(String[] operations) {
        //create a stack
        Deque<Integer> stack = new ArrayDeque<>();

        for(String op : operations){
            if(op.equals("+")){
                int first = stack.pop();//remove last temporarily
                int second = stack.peek();
                //now push back first
                stack.push(first);
                stack.push(first + second);
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(op.equals("C")){
                stack.pop();
            }else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}