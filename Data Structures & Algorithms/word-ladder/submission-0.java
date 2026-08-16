class Solution {
    class Pair{
        String word;
        int distance;
        Pair(String word,int distance){
            this.word = word;
            this.distance = distance;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //we store pair->(word,distance)
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));//intitially store the starting word with distance=1
        Set<String> set = new HashSet<>(wordList);//visited or not

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String word = current.word;
            int distance = current.distance;
            for(int i = 0;i < word.length();i++){
                char[] chars = word.toCharArray();
                //make all possible words
                for(char c = 'a';c <= 'z';c++){
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(set.contains(newWord)){
                        //check it if equals to endword
                        if(newWord.equals(endWord)){
                            return distance + 1;
                        }
                        set.remove(newWord);
                        queue.offer(new Pair(newWord,distance + 1));
                    }
                }
            }
        }
        return 0;
    }
}
