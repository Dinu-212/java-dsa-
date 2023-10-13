

import java.util.Scanner;
//You can only jump 1, 2 and 3 sizes
//The answer is starting from 0 steps, so think 
public class StairCaseClimbing {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        snr.close();
        System.out.println(DistinctWaysToReachTop(n));
    }
    static int DistinctWaysToReachTop(int n)
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
        return DistinctWaysToReachTop(n-1)+DistinctWaysToReachTop(n-2)+DistinctWaysToReachTop(n-3);
    }
}
