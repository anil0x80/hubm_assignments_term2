import static java.lang.Math.abs;

public class MyQueue extends MyData
{
    public static void parseFile(MyQueue queue, String[] lines)
    {
        String[] nums = lines[0].split(" ");
        for(String num: nums)
        {
            queue.add(Integer.parseInt(num));
        }
    }

    private Node tail; // add to here
    private Node head; // remove from here
    private int currentSize;

    /*
       * (head) -> * -> * -> * (tail)
     */
    public boolean isEmpty() { return head == null; }
    public int peek() { return head.data; }
    public int getCurrentSize() {return currentSize; }

    public void add(int data)
    {
        currentSize++;
        Node node = new Node(data); // create a new node
        if (head == null) // if queue is empty
        {
            head = node;
        }
        if (tail != null)
        {
            tail.next = node; // add node to queue
        }
        tail = node; // update tail
    }

    @Override
    public String serialize()
    {
        return super.serialize(head, false);
    }

    public void sort()
    {
        head = super.sort(head, currentSize);
    }

    public void removeGreaterThan(int number)
    {
        head = super.removeGreaterThan(head, number);
        currentSize = getSize(head);
    }

    public int calculateDistance()
    {
        return super.calculateDistance(head);
    }

    public int getDistinctElementCount()
    {
        return super.getDistinctElementCount(head);
    }

    public void addOrRemove(int numberOfElements)
    {
        if (numberOfElements > 0)
        {
            for (int i = 0; i < numberOfElements; i++)
            {
                add(getRandomData());
            }
        }
        else
        {
            for (int i = abs(numberOfElements); i > 0; i--)
            {
                remove();
            }
        }
    }

    public void reverseElements(int count)
    {
        head = super.reverseElements(head, count);
    }

    public int remove()
    {
        currentSize--;
        int data = head.data; // FIFO
        head = head.next; // update head
        if (head == null)
            tail = null; // if queue is empty, make tail and head nullptr.
        return data;
    }

}
