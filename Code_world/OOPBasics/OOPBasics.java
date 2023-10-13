package OOPBasics;

import java.util.*;


class Point implements Comparable<Point>{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public String toString()
    {
        return "("+x+","+y+")";
    }
    public int compareTo(Point p)                                                                                                                                                                                                                                                                                                                                                                                                            
    {
        return this.y-p.y;
    }
}
public class OOPBasics {
    public static void main(String[] args) {
        List<Point> points=new ArrayList<>();
        points.add(new Point(1,2));
        points.add(new Point(7,4));
        points.add(new Point(3,6));
        points.add(new Point(8,8));
        points.add(new Point(8,1));
        System.out.println(points);
        Collections.sort(points);
        System.out.println(points);

    }
}
