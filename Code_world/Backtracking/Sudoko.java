package Backtracking;

//import java.util.Scanner;

public class Sudoko {
    public static void main(String[] args) {
        //Scanner snr=new Scanner(System.in);
        int n=9;
        int[][] grid={ { 3, 1, 6, 5, 7, 0, 4, 9, 2 },
        { 5, 2, 9, 1, 3, 4, 7, 6, 0 },
        { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
        { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
        { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
        { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
        { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
        { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
        { 7, 4, 5, 0, 8, 6, 3, 0, 0 } };
        int row=0,col=0;
        System.out.println(sudokuHelper(grid,n,row,col));
    }
    static void printPuzzle(int[][] puzzle,int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(puzzle[i][j]+"  ");
            }
            System.out.println();
        }
    }
    static boolean sudokuHelper(int[][] puzzle,int n,int row,int col)
    {
        if(row==n-1 && col==n)
        {
            printPuzzle(puzzle,n);
            return true;
        }
        if(col==n)
        {
            row++;
            col=0;
        }
        if(puzzle[row][col]>0)
        {
            return sudokuHelper(puzzle, n, row, col+1);
        }
        for(int value=1;value<=9;value++)
        {
            if(isValid(puzzle, n, row, col, value))
            {
                puzzle[row][col]=value;
                boolean isSuccess=sudokuHelper(puzzle, n, row, col+1);
                if(isSuccess)
                {
                    return true;
                }
                puzzle[row][col]=0;
            }
        }
        return false;
    }
    static boolean isValid(int[][] grid,int n,int r,int c,int value)
    {
        //for row
        for(int col=0;col<n;col++)
        {
            if(grid[r][col]==value)
            {
                return false;
            }
        }
        //for column
        for(int row=0;row<n;row++)
        {
            if(grid[row][c]==value)
            {
                return false;
            }
        }
        //for grid
        int sr=r-r%3;
        int sc=c-c%3;
        for(int row=0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                if(grid[sr+row][sc+col]==value)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
