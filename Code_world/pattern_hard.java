//patterns
import java.util.Scanner;
public class pattern_hard
{
public static void main(String args[])
{
    int n;
    Scanner sc=new Scanner(System.in);
    //String s=sc.nextLine();
    //string_pattern(s);
    n=sc.nextInt();
    arrow_pattern(n);
    //cross_pattern(n);
    //mirror_pattern(n);
    sc.close();
}
static void mirror_pattern(int n)
{
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=row;col++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=n;col++)
        {
            System.out.print(" ");
        }
        for(int col=1;col<=row;col++)
        {
            System.out.print(" ");
        }
        for(int col=1;col<=n-row+1;col++)
        {
            System.out.print("*");
        } 
        System.out.println(); 
    }
}
static void string_pattern(String s)
{
    int n=s.length();
    for(int row=0;row<=n-1;row++)
    {
        for(int col=1;col<=n-row-1;col++)
        {
            System.out.print(" ");
        }
        for(int col=0;col<=row;col++)
        {
            System.out.print(s.charAt(col));
        }
        System.out.println();
    }
    for(int row=0;row<=n-1;row++)
    {
        for(int col=row;col<n;col++)
        {
            System.out.print(s.charAt(col));
        }
        System.out.println();
    }
}
static void cross_pattern(int n)
{
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=row;col++)
        {
            if(row==col)
            {
                System.out.print(row);
            }
            else
            {
                System.out.print(" ");
            }
        }
        for(int col=1;col<=n-row;col++)
        {
            System.out.print(" ");
        }
        for(int col=2;col<=n-row;col++)
        {
            System.out.print(" ");
        }
        if(row!=n)
        {
            System.out.print(row);
        }
        System.out.println();
    }
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=n-row;col++)
        {
            if(col==n-row)
            {
                System.out.print(col);
            }
            else
            {
                System.out.print(" ");
            }
        }
        for(int col=1;col<=row;col++)
        {
            System.out.print(" ");
        }
        for(int col=2;col<=row;col++)
        {
            System.out.print(" ");
        }
        for(int col=1;col<=n-row;col++)
        {
            if(col==n-row)

            {
                System.out.print(col);
            }
        }
        System.out.println();
    }
}
static void arrow_pattern(int n)
{
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=row;col++)
        {
            if(col==1 || col==row || row==n)
            {
                System.out.print("* ");
            }
            else
            {
                System.out.print("  ");
            }
        }
        System.out.println();
    }
    for(int row=1;row<=n;row++)
    {
        for(int col=1;col<=n-row;col++)
        {
            if(col==1 || col==row || col==n-row)
            {
                System.out.print("* ");
            }
            else
            {
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}
}
//how to get arrow pattern?
