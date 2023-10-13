class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class LLQueue{
    Node front,rear;
    LLQueue(){
        front=rear=null;
    }
    void enQueue(int data)
    {
        Node newNode=new Node(data);
        if(rear==null)
        {
            front=rear=newNode;
        }
        else{
            rear.next =newNode;
            rear=newNode;
        }   
    }
    int deQueue()
    {
        int deleted=0;
        deleted=front.data;
        front=front.next;
        return deleted;
    }
    void display()
    {
        if(rear==null)
        {
        System.out.print("Empty");
        }
        else{
        Node tmp=front;
        while(tmp!=null)
        {
            System.out.print(tmp.data+" ");
            tmp=tmp.next;
        }
    }
    }
}

public class QueueUsingLL {
    public static void main(String[] args)
    {
        LLQueue queue=new LLQueue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.display();
        queue.deQueue();
        queue.deQueue();
        queue.display();
    }
}
