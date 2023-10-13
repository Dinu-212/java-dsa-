import java.util.Stack;

class QueueSS {
    Stack<Integer> stack1;

    QueueSS() {
        stack1 = new Stack<>();
    }

    void enQueue(int data) {
        stack1.push(data);
    }

    int deQueue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // You can choose a suitable value to represent an empty queue.
        }

        // Transfer elements from stack1 to stack2 in reverse order
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Pop the front element from stack2
        int front = stack2.pop();

        // Transfer elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return front;
    }

    void display() {
        System.out.println(stack1);
    }
}

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        QueueSS qss = new QueueSS();
        qss.enQueue(10);
        qss.enQueue(20);
        qss.enQueue(30);
        qss.display();
        System.out.println(qss.deQueue());
        System.out.println(qss.deQueue());
        qss.display();
    }
}
