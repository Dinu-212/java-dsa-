package DP_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[] coins=new int[n];
        int amount=snr.nextInt();
        Arrays.setAll(coins,(i)->snr.nextInt());
        snr.close();
        System.out.println(MinCoinsToCoinChange(coins,amount));
    }
    static int MinCoinsToCoinChange(int[] coins,int amount)
    {
        if(amount<=0)
        {
            return 0;
        }
        int[] buffer=new int[amount+1];
        for(int i=1;i<=amount;i++)
        {
            buffer[i]=Integer.MAX_VALUE;
            for(int coin:coins)
            {
                if(coin<=i && buffer[i-coin]!=Integer.MAX_VALUE)
                {
                    
                    buffer[i]=Math.min(buffer[i],1+buffer[i-coin]);
                }
            }
        }
        if(buffer[amount]!=Integer.MAX_VALUE)
        {
            return buffer[amount];
        }
        return -1;
    }
}
