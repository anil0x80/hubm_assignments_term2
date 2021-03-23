import static java.lang.Math.abs;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class MyData
{
    public abstract void add(int data);
    public abstract String serialize();
    public String serialize (Node first, boolean reverse)
    {
        if (first == null)
            return "";
        StringBuilder serialized = new StringBuilder();
        Node currentNode = first;
        while(currentNode != null)
        {
            int data = currentNode.data;
            serialized.append(Integer.toString(data));
            if (currentNode.next != null)
                serialized.append(" ");
            currentNode = currentNode.next;
        }
        return reverse ? serialized.reverse().toString() : serialized.toString();
    }

    Node get(Node node, int index)
    {
        Node currentNode = node;
        for(int i = 0; i < index; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    void swap(Node left, Node right)
    {
        int tempData = left.data;
        left.data = right.data;
        left.next = right;
        right.data = tempData;
    }

    public Node removeGreaterThan(Node first, int number)
    {
        if (first.next == null) //list only has 1 element
        {
            return (first.data > number) ? null : first;
        }
        Node previousNode = first;
        Node currentNode = first;
        while(currentNode != null)
        {
            int data = currentNode.data;
            if (data > number)
            {
                if (currentNode == first) //we need to remove the top element,
                {
                    first = currentNode.next;
                    previousNode = first;
                    currentNode = first;
                    continue;
                }
                else // slip currentNode out.
                {
                    previousNode.next = currentNode.next; //if currentNode is the last element, previousNode.next = nul
                    currentNode = currentNode.next;
                }
            }
            else
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return first;
    }

    public int calculateDistance(Node first)
    {
        int sum = 0;
        Node currentNode = first;
        while(currentNode != null)
        {
            Node anotherNode = currentNode.next;
            while(anotherNode != null)
            {
                sum += abs(currentNode.data - anotherNode.data);
                anotherNode = anotherNode.next;
            }
            currentNode = currentNode.next;
        }
        return sum;
    }

    public int getRandomData()
    {
        return ThreadLocalRandom.current().nextInt(0, 51);
    }

    public Node reverseElements(Node first, int count)
    {
        if (count == 0)
            return first;

        Node[] reversed = new Node[count]; //allocate memory to store reversed nodes
        Node currentNode = first;
        for(int i = 0; i < count; i++) //reverse first count elements.
        {
            if (i == 0) // point to next element after count
                reversed[count - 1] = new Node(currentNode.data, null);
            else
                reversed[count - i - 1] = new Node(currentNode.data, reversed[count - i]);

            currentNode = currentNode.next;
        }

        reversed[count - 1].next = currentNode;
        return reversed[0];
    }

    public Node sort(Node first, int size) //bubble sort
    {
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < size - 1; i++)
            {
                Node left = get(first, i);
                Node right = get(first, i +1);
                if (left.data > right.data)
                {
                    swap(left, right);
                    sorted = false;
                }

            }
        }

        return first;
    }

    public int getDistinctElementCount(Node first)
    {
        Set<Integer> distinctElements = new HashSet<Integer>();
        Node currentNode = first;
        while(currentNode != null)
        {
            distinctElements.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return distinctElements.size();
    }

    public int getSize(Node first)
    {
        int size = 0;
        Node currentNode = first;
        while(currentNode != null)
        {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
}
