public class MyStack
{
    private static class Node
    {
        private int data;
        private Node next; // next node
        private Node(int data)
        {
            this.data = data;
        }
    }

    public MyStack()
    {
        size = 10;
    }

    public boolean isFull() //this looks retarded, as there is no point in a stack with a fixed size...
    {
        return currentSize == size;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int top()
    {
        return top.data;
    }
    /* LAYOUT:
            *  //top
            *  //top.next
            *  //top.next
     */
    public void push(int data)
    {
        if (isFull()) //do not add elements if stack is full
            return;
        currentSize++;
        Node node = new Node(data); // create the data
        node.next = top; // next points to down.
        top = node;
    }

    public int pop()
    {
        currentSize--;
        int data = top.data;
        top = top.next; //remove top from the stack.
        return data; //return temporary value
    }

    private Node top; //represents the top of the stack
    private int size;
    private int currentSize;
}
