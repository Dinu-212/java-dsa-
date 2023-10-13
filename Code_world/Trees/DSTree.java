package Trees;

import java.util.*;

class TNode{
    int data;
    TNode left, right;
    TNode(int data)
    {
        this.data=data;
        left=right=null;
    }
}
class BTree{
    TNode BTreeBuild(){
        Scanner snr = new Scanner(System.in);
        int data=snr.nextInt();
        if (data==-1){
            return null;
        }
        TNode newNode=new TNode(data);
        newNode.left=BTreeBuild();
        newNode.right=BTreeBuild();
        return newNode;
    }
    TNode bstInsert(TNode currentNode,int data){
        if(currentNode==null)
        {
            return new TNode(data);
        }
        if(data<currentNode.data)
        {
            currentNode.left=bstInsert(currentNode.left, data);
        }
        else{
            currentNode.right=bstInsert(currentNode.right, data);
        }
    return currentNode;
    }
    void inOrder(TNode currentNode)
    {
        if(currentNode==null)
        {
            return;
        }
        inOrder(currentNode.left);
        System.out.print(currentNode.data+" ");
        inOrder(currentNode.right);
    }
    void preOrder(TNode currentNode)
    {
        if(currentNode ==null)
        {
            return;
        }
        System.out.print(currentNode.data+" ");
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }
    void postOrder(TNode currentNode)
    {
        if(currentNode==null)
        {
            return;
        }
        postOrder(currentNode.left);
        postOrder(currentNode.right);
        System.out.print(currentNode.data+" ");
    }
    void levelOrder(TNode root)
    {
        if(root==null)
        {
            return;
        }
        Queue<TNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TNode tmp=queue.poll();
            System.out.print(tmp.data+" ");
            if(tmp.left!=null)
            {
                queue.add(tmp.left);
            }
            if (tmp.right!= null){
                queue.add(tmp.right);  
            }
        }
    }
    void rightView(TNode current)
    {
        Queue<TNode> queue=new ArrayDeque<>();
        queue.add(current);
        queue.add(new TNode(-1));
        while(!queue.isEmpty() && queue.peek().data!=-1)
        {
            TNode tmp = queue.poll();
            if(tmp.left!=null)
            {
                queue.add(tmp.left);
            }
            if(tmp.right!=null)
            {
                queue.add(tmp.right);
            }
            if(queue.peek().data==-1)
            {
                System.out.println(tmp.data);
                queue.poll();
                queue.add(new TNode(-1));
            }
        }
    }
    void leftView(TNode current)
    {
        Queue<TNode> queue=new ArrayDeque<>();
        queue.add(current);
        System.out.println(queue.peek().data);
        queue.add(new TNode(-1));
        while(!queue.isEmpty() && queue.peek().data!=-1)
        {
            TNode tmp = queue.poll();
            if(tmp.left!=null)
            {
                queue.add(tmp.left);
            }
            if(tmp.right!=null)
            {
                queue.add(tmp.right);
            }
            if(queue.peek().data==-1)
            {
                queue.poll();
                if(!queue.isEmpty())
                System.out.println(queue.peek().data);
                queue.add(new TNode(-1));
            }
        }
    }
    void traverse(TNode current,int distance,Map<Integer,List<TNode>> dist_elements)
    {
        if(current==null)
        {
            return;
        }
        dist_elements.putIfAbsent(distance,new ArrayList<>());
        dist_elements.get(distance).add(current);
        traverse(current.left,distance-1,dist_elements);
        traverse(current.right,distance+1,dist_elements);
    }
    void verticalOrder(TNode root)
    {
        Map<Integer,List<TNode>> dist_elements=new TreeMap<>();
        traverse(root,0,dist_elements); 
        verticalView(dist_elements);
        topView(dist_elements);
        bottomView(dist_elements);
    }
    void verticalView(Map<Integer,List<TNode>> dist_elements)
    {
        for(int col:dist_elements.keySet())
        {
            for(TNode element:dist_elements.get(col))
            {
                System.out.print(element.data+" ");
            }
            System.out.println();
        }
    }
    void topView(Map<Integer,List<TNode>> dist_elements)
    {
        for(int col:dist_elements.keySet())
        {
            System.out.print(dist_elements.get(col).get(0).data+" ");
        }
        System.out.println();
    }
    void bottomView(Map<Integer,List<TNode>> dist_elements)
    {
        for(int col:dist_elements.keySet())
        {
            List<TNode> col_list=dist_elements.get(col);
            int lastIdx=col_list.size()-1;
            System.out.print(col_list.get(lastIdx).data+" ");
        }
        System.out.println();
    }
    void inorderTraversal(TNode current,List<Integer> inorder_elements)
    {
        if(current==null)
        {
            return ;
        }
        inorderTraversal(current.left, inorder_elements);
        inorder_elements.add(current.data);
        inorderTraversal(current, inorder_elements);
    }
    boolean isBST(TNode root)
    {
        List<Integer> inorder_elements=new ArrayList<>();
        inorderTraversal(root,inorder_elements);
        for(int idx=0;idx<inorder_elements.size()-1;idx++)
        {
            if(inorder_elements.get(idx)>inorder_elements.get(idx+1))
            {
                return false;
            }
        }
        return true;
    }
    int findHeight(TNode current)
    {
        if(current==null)
        {
            return -1;
        }
        int leftHeight=findHeight(current.left);
        int rightHeight=findHeight(current.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    boolean mirrorTest(TNode leftNode,TNode rightNode)
    {
        if(leftNode==null || rightNode==null)
        {
            return leftNode==rightNode;
        }
        if(leftNode.data!=rightNode.data)
        {
            return false;
        }
        return mirrorTest(leftNode.left,rightNode.right) && mirrorTest(leftNode.right,rightNode.left);

    }
    boolean isMirrored(TNode root)
    {
        if(root==null)
        {
            return false;
        }
        return mirrorTest(root.left,root.right);
    }
}
public class DSTree{
    public static void main(String[] args) {
        BTree tree=new BTree();
        TNode root=tree.BTreeBuild();
        System.out.println(tree.isMirrored(root));
        /*
        int[] data={5,2,9,4,6,8,1,10};
        for(int value:data)
        {
            root=tree.bstInsert(root,value);
        }
        */
    }
}