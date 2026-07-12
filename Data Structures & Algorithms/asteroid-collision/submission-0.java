class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            boolean alive = true;
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0 && alive){
                if(Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                }else if(Math.abs(asteroid) == stack.peek()){
                    stack.pop();
                    alive = false;
                }else {
                    alive = false;
                }
            }
            if(alive){
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = stack.size() - 1;i >= 0;i--){
            ans[i] = stack.pop();
        }  
        return ans;
    }
}