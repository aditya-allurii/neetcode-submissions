class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0;row<9;row++){
            Set<Character> rowset = new HashSet<>();
            for(int col = 0;col<9;col++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(rowset.contains(board[row][col])){
                    return false;
                }
                rowset.add(board[row][col]);
            }
        }
        for(int col = 0;col<9;col++){
            Set<Character> colset = new HashSet<>();
            for(int row = 0;row<9;row++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(colset.contains(board[row][col])){
                    return false;
                }
                colset.add(board[row][col]);
            }
        } 
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {

    for (int boxCol = 0; boxCol < 9; boxCol += 3) {

        Set<Character> boxSet = new HashSet<>();

        for (int row = boxRow; row < boxRow + 3; row++) {

            for (int col = boxCol; col < boxCol + 3; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                if (boxSet.contains(board[row][col])) {
                    return false;
                }

                boxSet.add(board[row][col]);
            }
        }
    }
        }
        return true;
    }
}
