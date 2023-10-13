class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class LLStack{
    Node top;
    void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
    }
    int pop(){
        int deleted=0;
        deleted=top.data;
        top=top.next;
        return deleted;
    }
    void display(){
        Node tmp=top;
        while(tmp!=null)
        {
            System.out.println(tmp.data);
            tmp=tmp.next;
        }

    }
}


public class StackUsingLL {
    public static void main(String[] args)
    {
        LLStack stack=new LLStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.pop();
        stack.display();
    }
    
}
