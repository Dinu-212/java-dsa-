package Greedy_algorithms;
import java.util.*;
public class MaximizeToys {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int budget=snr.nextInt();
        int[] toyCosts=new int[n];
        for(int idx=0;idx<n;idx++)
        {
            toyCosts[idx]=snr.nextInt();
        }
        findMaximumToys(toyCosts,budget);
        snr.close();
    }
    static void findMaximumToys(int[] toys,int budget)
    {
        int count=0;
        Arrays.sort(toys);
        for(int idx=0;idx<toys.length;idx++)
        {
            if(budget>toys[idx])
            {
                budget-=toys[idx];
                count++;
            }
            if(budget==0)
            {
                break;
            }
        }
        System.out.println(count);
    }
}
