import static java.lang.Math.abs;

public class MyStack extends MyData
{
    public static void parseFile(MyStack stack, String[] lines)
    {
        String[] nums = lines[0].split(" ");
        for (int i = nums.length - 1; i >= 0; i--)
        {
            stack.add(Integer.parseInt(nums[i]));
        }
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
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
        currentSize++;
        Node node = new Node(data); // create the data
        node.next = top; // next points to down.
        top = node;
    }

    public void add(int data) // for generic usage
    {
        push(data);
    }

    public void removeGreaterThan(int number)
    {
        top = super.removeGreaterThan(top, number);
        currentSize = getSize(top);
    }

    @Override
    public String serialize()
    {
        return super.serialize(top, false);
    }

    public void sort()
    {
        top = super.sort(top, currentSize);
    }

    public int calculateDistance()
    {
        return super.calculateDistance(top);
    }

    public int getDistinctElementCount()
    {
        return super.getDistinctElementCount(top);
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
                pop();
            }
        }
    }

    public void reverseElements(int count)
    {
        top = super.reverseElements(top, count);
    }

    public int pop()
    {
        currentSize--;
        int data = top.data;
        top = top.next; //remove top from the stack.
        return data; //return temporary value
    }

    private Node top; //represents the top of the stack
    private int currentSize;
}
