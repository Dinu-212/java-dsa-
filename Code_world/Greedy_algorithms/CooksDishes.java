package Greedy_algorithms;
import java.util.*;
public class CooksDishes {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int aMin=Integer.MAX_VALUE,bMin=Integer.MAX_VALUE,cMin=Integer.MAX_VALUE;
        while(n>0)
        {
            char dishName=snr.next().toUpperCase().charAt(0);
            int dishTime=snr.nextInt();
            if(dishName=='A')
            {
                if(aMin>dishTime)
                {
                    aMin=dishTime;
                }
            }
            if(dishName=='B')
            {
                if(bMin>dishTime)
                {
                    bMin=dishTime;
                }
            }
            if(dishName=='C')
            {
                if(cMin>dishTime)
                {
                    cMin=dishTime;
                }
            }
            n--;
        }
        int ans=((aMin+bMin)<cMin)?(aMin+bMin):cMin;
        System.out.println(ans);
        snr.close();
    }
}
