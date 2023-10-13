package Backtracking;
import java.util.Scanner;

public class NQueens {
     public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[][] board=new int[n][n];
        int row=0;
        System.out.println(NQueensPlace(board,n,row));
        snr.close();
    }
    static boolean NQueensPlace(int[][] board,int n,int row)
    {
        if(row==n)
        {
            printBoard(board,n);
            return true;
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col]=1;
                boolean success=NQueensPlace(board, n, row+1);
                if(success)
                {
                    return true;
                }
                board[row][col]=0;
            }

        }
        return false;
    }
    static boolean isSafe(int[][] board,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
            {
                return false;
            }
            int r=row-i;
            int c=col-i;
            while(r>=0 && c>=0)
            {
                if(board[r][c]==1)
                {
                    return false;
                }
                r--;
                c--;
            }
            r=row-1;c=col+1;
            while(r>=0 && c<board.length)
            {
                if(board[r][c]==1)
                {
                    return false;
                }
                c=c+1;
                r=r-1;
            }
        }
        return true;
    }
    static void printBoard(int[][] board,int n){
        for(int[] row:board)
        {
            for(int col:row){
                System.out.print(col+"  ");
            }
            System.out.println();
        }
    }
}
