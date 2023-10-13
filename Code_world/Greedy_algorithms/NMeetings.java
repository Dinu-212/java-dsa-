package Greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    Integer start;
    Integer end;
    Meeting(Integer start,Integer end)
    {
        this.start=start;
        this.end=end;
    }
    public int compareTo(Meeting o)
    {
        return this.end-o.end;
    }
    public String toString()
    {
        return "("+start+","+end+")";
    }
}
public class NMeetings {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        List<Meeting> meetings=new ArrayList<>();
        for(int idx=1;idx<=n;idx++)
        {
            int start=snr.nextInt();
            int end=snr.nextInt();
            meetings.add(new Meeting(start, end));
        }
        snr.close();
        System.out.println(findMeetings(meetings));
    }
    static List<Meeting> findMeetings(List<Meeting> meetings)
    {
        Collections.sort(meetings);
        List<Meeting> result=new ArrayList<>();
        Meeting selected=meetings.get(0);
        result.add(selected);
        for(int idx=1;idx<meetings.size();idx++)
        {
            Meeting current=meetings.get(idx);
            if(selected.end<current.start)
            {
                result.add(current);
                selected=current;
            }
        }
        return result;
    }
}
