package Backtracking;

public class RatInMaze {
    static int n=5;
    public static void main(String[] args) {
        int[][] matrix={{1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,1,0,1},
                        {1,1,1,0,1},
                        {1,1,1,1,1}};
        System.out.println(solve(matrix));
    }
    static boolean solveMyMaze(int[][] matrix,int row,int col,int[][] sol)
    {
        if(row==n-1 && col==n-1 && matrix[row][col]==1)
        {
            sol[row][col]=1;
            return true;
        }
        if(isSafe(matrix, row, col))
        {
            if(sol[row][col]==1)
            {
                return false;
            }
            sol[row][col]=1;
            if(solveMyMaze(matrix, row, col+1, sol))
            {
                return true;
            }
            if(solveMyMaze(matrix, row+1, col, sol))
            {
                return true;
            }
            //backtrack and move back to the previous decision tree
            sol[row][col]=0;
            return false;
        }
        return false;
    }
    static boolean solve(int[][] matrix)
    {
        int sol[][]=new int[n][n];
        if(solveMyMaze(matrix,0,0,sol)){
            //write function to print the solution matrix
            for(int[] cell:sol)
            {
                for(int c:cell)
                {
                    System.out.print(c+"  ");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }
    static boolean isSafe(int[][] matrix,int row,int col)
    {
        return (row>=0 && row<n && col>=0 && col<n && matrix[row][col]==1);
    }
}
