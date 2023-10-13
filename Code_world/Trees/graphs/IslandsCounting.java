package Trees.graphs;

import java.util.*;
class Cell{
    int row,col;
    Cell(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}

public class IslandsCounting {
    public static void main(String[] args) {
        int matrix[][]={{1,1,0,0},
                        {0,1,0,1},
                        {1,0,0,0},
                        {0,0,0,0},
                        {1,0,1,0}};
        System.out.println(islandsCounting(matrix));
    }
    static int islandsCounting(int[][] matrix)
    {
        int counter=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean[][] isVisited=new boolean[rows][cols];
        int[] deltaRow={-1,0,1,0};
        int[] deltaCol={0,1,0,-1};
        for(int row=0;row<rows;row++)
        {
            for(int col=0;col<cols;col++)
            {
                if(!isVisited[row][col] && matrix[row][col]==1)
                {
                    counter++;
                    bfs(row,col,matrix,isVisited,deltaRow,deltaCol);
                }
            }
        }
        return counter;
    }
    static void bfs(int row,int col,int[][] matrix,boolean[][] isVisited,int[] delRow,int[] delCol)
    {
        Queue<Cell> queue=new ArrayDeque<>();
        int r=matrix.length,c=matrix[0].length;
        queue.add(new Cell(row,col));
        isVisited[row][col]=true;
        while(!queue.isEmpty())
        {
            Cell tmp=queue.poll();
            for(int i=0;i<4;i++)
            {
                int nrow=tmp.row+delRow[i];
                int ncol=tmp.col+delCol[i];
                if(isValid(nrow,ncol,r,c) && !isVisited[nrow][ncol] && matrix[nrow][ncol]==1)
                {
                    bfs(nrow,ncol,matrix,isVisited,delRow,delCol);
                }
            }
        }
    }
    static boolean isValid(int row, int col, int rows, int cols)
    {
        if(row>=0 && row<rows && col>=0 && col<cols)
        {
            return true;
        }
        return false;
    }
}
