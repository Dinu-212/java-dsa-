package DP_algorithms;
import java.util.Arrays;
import java.util.Scanner;
//You can only jump 1, 2 and 3 sizes
//The answer is starting from 0 steps, so think 
public class StairCaseClimbing {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[] buffer=new int[n+1];
        Arrays.fill(buffer,-10);
        snr.close();
        System.out.println(DistinctWaysToReachTop(n,buffer));
    }
    static int DistinctWaysToReachTop(int n,int[] buffer)
    {
        if(n==0)
        {
            return 1;
        }
        if(n==1)
        {
            return 2;
        }
        if(n==2)
        {
            return 4;
        }
        if(buffer[n]!=-10)
        {
            return buffer[n];
        }
        buffer[n]=DistinctWaysToReachTop(n-1,buffer)+DistinctWaysToReachTop(n-2,buffer)+DistinctWaysToReachTop(n-3,buffer);
        return buffer[n];
    }
}
