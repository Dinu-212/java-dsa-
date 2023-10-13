import java.util.*;
public class RatsFoodHouses {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int r=snr.nextInt();
        int unit=snr.nextInt();
        int n=snr.nextInt();
        int[] houses=new int[n];
        for(int i=0;i<n;i++)
        {
            houses[i]=snr.nextInt();
        }
        snr.close();
        System.out.println(findNumberOfHousesFoodSufficientToFeedRats(houses,r,unit));
    }
    static int findNumberOfHousesFoodSufficientToFeedRats(int[] houses,int r,int unit)
    {
        if(houses.length==0)
        {
            return -1;
        }
        int foodCollected=0,counter=0;
        for(int house:houses)
        {
            counter++;
            foodCollected+=house;
            if(foodCollected>=(r*unit))
            {
                return counter;
            }
        }
        return 0;
    }
}
