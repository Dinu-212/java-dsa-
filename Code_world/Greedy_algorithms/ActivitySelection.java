package Greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Activity implements Comparable<Activity>{
    int start;
    int finish;
    Activity(int start,int finish)
    {
        this.start=start;
        this.finish=finish;
    }
    public int compareTo(Activity o){
        return this.finish-o.finish;
    }
    public String toString()
    {
        return "("+start+","+finish+")";
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        List<Activity> activities=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            int start=snr.nextInt();
            int finish=snr.nextInt();
            activities.add(new Activity(start, finish));
        }
        snr.close();
        System.out.println(findActivities(activities));
    }
    static List<Activity> findActivities(List<Activity> activities)
    {
        Collections.sort(activities);
        Activity selected=activities.get(0);
        List<Activity> result=new ArrayList<>();
        result.add(selected);
        for(int idx=1;idx<activities.size();idx++)
        {
            Activity current=activities.get(idx);
            if(selected.finish<=current.start)
            {
                result.add(current);
                selected=current;
            }
        }
        return result;
    }
}
