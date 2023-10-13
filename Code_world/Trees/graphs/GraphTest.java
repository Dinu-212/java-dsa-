package Trees.graphs;

import java.util.*;

class GraphDS{
    Map<Integer,List<Integer>> graph=new HashMap<>();
    void addEdge(int source,int destination){
        graph.putIfAbsent(source,new ArrayList<Integer>());
        graph.get(source).add(destination);
        graph.putIfAbsent(destination,new ArrayList<Integer>());
        graph.get(destination).add(source);
    }
    void printGraph()
    {
        for(Integer vertex:graph.keySet())
        {
            System.out.println(vertex+":"+graph.get(vertex));
        }
    }
    void bfsTraversal(int start)
    {
        Queue<Integer> queue=new ArrayDeque<>();
        Map<Integer,Boolean> isVisited=new HashMap<>();
        for(int vertex:graph.keySet())
        {
            isVisited.put(vertex,false);
        }
        queue.add(start);
        isVisited.put(start,true);
        while(!queue.isEmpty())
        {
            int tmp=queue.poll();
            System.out.print(tmp+" ");
            for(int nbr:graph.get(tmp))
            {
                if(isVisited.get(nbr)!=true)
                {
                    queue.add(nbr);
                    isVisited.put(nbr,true);
                }
            }
        }
    }
    void shortestPaths(int start,int end)
    {
        Queue<Integer> queue=new ArrayDeque<>();
        Map<Integer,Boolean> isVisited=new HashMap<>();
        Map<Integer,Integer> distance=new HashMap<>();
        for(int vertex:graph.keySet())
        {
            isVisited.put(vertex,false);
        }
        queue.add(start);
        isVisited.put(start,true);
        distance.put(start,0);
        while(!queue.isEmpty())
        {
            int tmp=queue.poll();
            System.out.print(tmp+" ");
            for(int nbr:graph.get(tmp))
            {
                if(isVisited.get(nbr)!=true)
                {
                    queue.add(nbr);
                    isVisited.put(nbr,true);
                    distance.put(nbr,distance.get(tmp)+1);
                    if(nbr==end)
                    {
                        System.out.println("Distance between "+start+" and "+ end+" is "+distance.get(end));
                        return;
                    }
                }
            }
        }
    }
    void parentNodes(int start)
    {
        Queue<Integer> queue=new ArrayDeque<>();
        Map<Integer,Boolean> isVisited=new HashMap<>();
        Map<Integer,List<Integer>> parentChild=new HashMap<>();
        for(int vertex:graph.keySet())
        {
            isVisited.put(vertex,false);
        }
        queue.add(start);
        isVisited.put(start,true);
        while(!queue.isEmpty())
        {
            int tmp=queue.poll();
            System.out.print(tmp+" ");
            parentChild.putIfAbsent(tmp,new ArrayList<Integer>());
            for(int nbr:graph.get(tmp))
            {
                if(isVisited.get(nbr)!=true)
                {
                    queue.add(nbr);
                    isVisited.put(nbr,true);
                    parentChild.get(tmp).add(nbr);
                }
            }
        }
        System.out.println(parentChild);
    }
    void dfsTraversal(int start){
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Boolean> isVisited=new HashMap<>();
        for(int vertex:graph.keySet())
        {
            isVisited.put(vertex,false);
        }
        stack.push(start);
        isVisited.put(start,true);
        while(!stack.isEmpty())
        {
            int tmp=stack.pop();
            System.out.print(tmp+" ");
            for(int nbr:graph.get(tmp))
            {
                if(!isVisited.get(nbr))
                {
                    stack.push(nbr);
                    isVisited.put(nbr,true);
                }
            }
        }
    }
    
}


public class GraphTest {
    public static void main(String[] args) {
        GraphDS g=new GraphDS();
        Scanner snr=new Scanner(System.in);
        int edges_count=snr.nextInt();
        for(int i=1;i<=edges_count;i++)
        {
            int source=snr.nextInt();
            int destination=snr.nextInt();
            g.addEdge(source, destination);
        }
        g.printGraph();
        g.bfsTraversal(1);
        g.shortestPaths(1,5);
        g.parentNodes(1);
        g.dfsTraversal(4);i
    }
}
