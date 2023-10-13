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
class SLinkedList{
    Node head;
    SLinkedList()
    {
        this.head=null;
    }
    void addElement(int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node tmp=head;
            while(tmp.next!=null)
            {
                tmp=tmp.next;
            }
            tmp.next=new Node(data);
        }
    }
    void display()
    {
        Node tmp=head;
        while(tmp!=null)
        {
            System.out.print(tmp.data+"--->");
            tmp=tmp.next;
        }
        System.out.println(tmp);
        
    }
    void addAtBegining(int data)
    {
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    void addAtPosition(int position,int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node tmp=head;
            while(tmp.next!=null && position>1)
            {
                tmp=tmp.next;
                position--;
            }
            if(tmp.next==null)
            {
                tmp.next=new Node(data);
            }
            else
            {
                Node newNode = new Node (data);
                newNode.next=tmp.next;
                tmp.next=newNode;
            }
        }
    }
    void addBetween(int element1,int element2,int data)
    {
        Node tmp=head;
        while(tmp.next!=null && tmp.data!=element1)
        {
            tmp=tmp.next;
        }
        if(tmp.next.data==element2)
        {
            Node newNode = new Node (data);
            newNode.next=tmp.next;
            tmp.next=newNode;
        }
        else{
            System.out.println("Element not found");
        }
    }
    int findMiddle()
    {
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }
    void removeMiddle()
    {
        Node slow=head,fast=head,previous=null;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            previous=slow;
            slow=slow.next;
        }
        previous.next=slow.next;
    }
    int getKthElementFromLast(int k)
    {
        Node fast=head,slow=head;
        while(fast!=null)
        {
            if(k>0)
            {
                fast=fast.next;
                k--;
            }
            else
            {
                fast=fast.next;
                slow=slow.next;
            }
        }
        return slow.data;
    }
    void reverse()
    {
        Node current=head,previous=null,nxtNode=null;
        while(current!=null)
        {
            nxtNode=current.next;
            current.next=previous;
            previous=current;
            current=nxtNode;
        }
        head=previous;
    }
    void rotateByKTimes(int k)
    {
        Node tmp1=head,tmp2=head;
        while(k>1){
            tmp1=tmp1.next;
            k--;
            if(tmp1.next==null)
            {
                tmp1=head;
                continue;
            }
        }
        while(tmp1.next!=null)
        {
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        tmp1.next=head;
        head=tmp2.next;
        tmp2.next=null;


    }
    Node merge(SLinkedList lst1,SLinkedList lst2)
    {
        Node l1=lst1.head,l2=lst2.head;
        if(l1.data>l2.data)
        {
            Node tmp=l1;
            l1=l2;
            l2=tmp;
        }
        Node res=l1;
        while(l1!=null && l2!=null)
        {
            Node tmp=null;
            while(l1!=null && l1.data<=l2.data)
            {
                tmp=l1;
                l1=l1.next;
            }
            tmp.next=l2;
            Node t=l1;
            l1=l2;
            l2=t;
        }
        return res;
    }
    int findJoiningPoint(SLinkedList lst1,SLinkedList lst2)
    {
        Node tmp1=lst1.head,tmp2=lst2.head;
        int counter1=0,counter2=0;
        while(tmp1!=null)
        {
            tmp1=tmp1.next;
            counter1++;
        }
        while(tmp2!=null)
        {
            tmp2=tmp2.next;
            counter2++;
        }
        tmp1=lst1.head;
        tmp2=lst2.head;
        if(counter1>counter2)
        {
            int k=counter1-counter2;
            while(k>0)
            {
                tmp1=tmp1.next;
                k--;
            }
        }
        else if(counter1<counter2)
        {
            int k=counter2-counter1;
            while(k>0)
            {
                tmp2=tmp2.next;
                k--;
            }
        }
        while(tmp1!=null && tmp2!=null)
        {
            if(tmp1.next.data==tmp2.next.data)
            {
                break;
            }
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        return tmp1.next.data;


    }
    SLinkedList createYLL(SLinkedList lst1,SLinkedList lst2)
    {
        Node tmp1=lst1.head,tmp2=lst2.head;
        while(tmp1.data!=4 && tmp1!=null)
        {
            tmp1=tmp1.next;
        }
        while(tmp2.next!=null)
        {
            tmp2=tmp2.next;
        }
        tmp2.next=tmp1;
        return lst2;
    }
}


public class LinkedList {
    public static void main(String args[])   
    {
        SLinkedList sll=new SLinkedList();
        int[] data={1,2,10,12,14};
        int[] elements={5,4,11};
        for(int element:elements)
        {
            sll.addElement(element);
        }
        SLinkedList sll2=new SLinkedList();
        for(int element:data)
        {
            sll2.addElement(element);
        }
        /*
        SLinkedList res=new SLinkedList();
        res.head=new SLinkedList().merge(sll,sll2);
        res.display();
        */
        SLinkedList lst2=new SLinkedList();
        lst2=new SLinkedList().createYLL(sll,sll2);
        int res=new SLinkedList().findJoiningPoint(sll, lst2);
        System.out.println(res);
    }
}
