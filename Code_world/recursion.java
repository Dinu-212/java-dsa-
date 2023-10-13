import java.util.Scanner;

public class recursion {
    public static void main(String args[])
    {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        System.out.println(specialKeyboard(n));
        /*
        int[][] matrix={{1,0,1},{1,1,0},{0,0,1}};
        int sr=snr.nextInt();
        int sc=snr.nextInt();
        int color=snr.nextInt();
        int[][] ans=floodFill(matrix,sr,sc,color);
        for(int[] row:ans)
        {
            for(int col:row)
            {
                System.out.print(col+" ");
            }
            System.out.println();
        }
        */
        /*
        int n=snr.nextInt();
        int k=snr.nextInt();
        System.out.println(josephousProblem(n,k));
        /* 
        int m=snr.nextInt();
        int n=snr.nextInt();
        System.out.println(getCountAllPaths(m,n));
        */
        snr.close();
    }
    static int specialKeyboard(int n)
    {
        if(n<=6)
        {
            return n;
        }
        int max_length=0;
        for(int i=n-3;i>=1;i--)
        {
            int current_length=(n-i-1)*specialKeyboard(i);//n-i-1 is scppp combo
            if(current_length>max_length)
            {
                max_length=current_length;
            }
        }
        return max_length;

    }
    static void dfs(int[][] matrix,int row,int col,int i_color,int f_color,int[] deltaRow,int[] deltaCol,int[][] ans)
    {
        ans[row][col]=f_color;
        int rows=matrix.length,cols=matrix[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=row+deltaRow[i];
            int ncol=col+deltaCol[i];
            if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && matrix[nrow][ncol]==i_color && ans[nrow][ncol]!=f_color)
            {
                ans[nrow][ncol]=f_color;
                dfs(matrix,nrow,ncol,i_color,f_color,deltaRow,deltaCol,ans);
            }
        }
    }
    static int[][] floodFill(int[][] matrix,int sr,int sc,int fill_color)
    {
        int[][] ans=matrix;
        int inital_color=matrix[sr][sc];
        int[] deltaRow={-1,0,1,0};
        int[] deltaCol={0,1,0,-1};
        dfs(matrix,sr,sc,inital_color,fill_color,deltaRow,deltaCol,ans);
        return ans;
    } 
    static int josephousProblem(int n,int k)
    {
        if(n==1)
        {
            return 0;
        }
        return (josephousProblem(n-1, k)+k)%n;
    }
    static int getCountAllPaths(int m,int n)
    {
        if(m==1 || n==1)
        {
            return 1;
        }
        return getCountAllPaths(m, n-1)+getCountAllPaths(m-1, n);
    }
}
