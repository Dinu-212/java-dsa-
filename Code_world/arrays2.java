import java.util.Scanner;
import java.util.Arrays;

public class arrays2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        prime_magic(n);
        /*
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        angry_birds(arr,k);
        */
        /* 
        int m,n;
        m=sc.nextInt();
        n=sc.nextInt();
        int[][] mat=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        spiral_traversal(mat);
        */
        /*chocalate distribution
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        Chocolate_distribution(arr,m);
        */
        sc.close();
    }
    static boolean isPrime(int n)
    {
        if(n==0|| n==1)
        {
            return false;
        }
        for(int i=2;i<=n-1;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    static void prime_magic(int n)
    {
        int counter=0;
        for(int i=3;i<=n;i++)
        {
            if(isPrime(i))
            {
                int sum=2;
                for(int tmp=3;tmp<i;tmp++)
                {
                    if(isPrime(tmp))
                    {
                        sum+=tmp;
                    if(sum==i)
                    {
                        counter++;
                        break;
                    }
                }
                }
            }
        }
        System.out.println(counter);
    }
    static void angry_birds(int arr[],int k)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if((arr[i]+arr[j])/2>=k)
                {
                    System.out.println("("+arr[i]+","+arr[j]+")");
                }
            }
        }
    }
    static void spiral_traversal(int matrix[][])
    {
        int rowStart=0,rowEnd=matrix.length-1;
        int colStart=0,colEnd=matrix[0].length-1;
        while(rowStart>=0 && colStart>=0 && rowEnd<matrix.length && colEnd<matrix.length)
        {
            if(rowStart<=rowEnd)
            {
            //to right
            for(int i=rowStart;i<=colEnd;i++)
            {
                System.out.print(matrix[rowStart][i]+" ");
            }
            rowStart++;
        }
            //to bottom
            if(colStart<=colEnd)
            {
            for(int i=rowStart;i<=rowEnd;i++)
            {
                System.out.print(matrix[i][colEnd]+" ");
            }
            colEnd--;
           }
            //to left
            if(colStart<=colEnd)
            {
                for(int i=colEnd;i>=colStart;i--)
                {
                    System.out.print(matrix[rowEnd][i]+" ");
                }
                rowEnd--;
            }
            //to up
            if(rowStart<=rowEnd)
            {
            for(int i=rowEnd;i>=rowStart;i--)
            {
                System.out.print(matrix[i][colStart]+" ");
            }
            colStart++;
            }
        }
    }
    static void Chocolate_distribution(int arr[],int m)
    {
        Arrays.sort(arr);
        int left=0;
        int right=m-1;
        int min_difference=Integer.MAX_VALUE;
        while(right<arr.length)
        {
            if(min_difference>arr[right]-arr[left])
            {
                min_difference=arr[right]-arr[left];
            }
            left++;
            right++;
        }
        System.out.println(min_difference);
    }
}