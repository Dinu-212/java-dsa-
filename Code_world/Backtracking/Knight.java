package Backtracking;
class Knight{
    static int N=8;
     //positions i and j
     static int[] rowDelta={2,1,-1,-2,-2,-1,1,2};
     static int[] colDelta={1,2,2,1,-1,-2,-2,-1};

    //isValid() to check if a move is possible or not 
    static boolean isValid(int board[][],int newRow, int newCol){
        return newRow>=0 && newRow<N && newCol >=0 && newCol<N 
        && board[newRow][newCol]==0;
    }
     //recursive  function to explore all paths
    static boolean SolveMyKnightTour(int board[][],int row, 
    int col, int moves){
        //base condition 
        if(moves==N*N+1){
            board[row][col]=moves-1;
            return true; //all sqaures or blocks are visited
        }
        // to check the position which is valid to make a move
        for(int pos=0;pos<=7;pos++){
            int newRow = row+rowDelta[pos];
            int newCol = col+colDelta[pos];
            //check if the pos is valid or not
            if(isValid(board, newRow, newCol)){
                board[newRow][newCol]=moves;
                //recursively update the move
                if(SolveMyKnightTour(board, newRow, newCol, moves+1)){
                    return true;
                }else{
                    //backtrack if move is not possible 
                    board[newRow][newCol]=0;
                }
              }
            }
        return false;
    }
    static void printMyBoard(int board[][]){
        for(int row[]: board){
            for(int value: row){
                System.out.print(value+ " ");
            } System.out.println();
        }
    }
    public static void main(String[] args) {
         //board[n][n]
        int board[][]=new int[N][N];
        //n=8
        board[0][0]=1;
        if(SolveMyKnightTour(board,0,0,2)){
            //print the board
            printMyBoard(board);
        }

    }
   
}