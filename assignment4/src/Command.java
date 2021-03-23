public class Command
{
    public Command(String[] commands)
    {
        this.commands = commands;
    }


    public void run(MyQueue queue, MyStack stack)
    {
        WriteToFile queueOut = new WriteToFile("queueOut.txt");
        WriteToFile stackOut = new WriteToFile("stackOut.txt");
        for(String command: commands)
        {
            String[] splitted = command.split(" ");
            boolean isStack = splitted[0].equals("S");
            switch(splitted[1])
            {
                case "removeGreater":
                    String number = splitted[2];
                    if(isStack)
                    {
                        stack.removeGreaterThan(Integer.parseInt(number));
                        stackOut.write("After removeGreater " + number + ":\n" );
                        stackOut.write(stack.serialize() + "\n");
                    }
                    else
                    {
                        queue.removeGreaterThan(Integer.parseInt(number));
                        queueOut.write("After removeGreater " + number + ":\n" );
                        queueOut.write(queue.serialize() + "\n");
                    }
                    break;
                case "calculateDistance":
                    int distance = isStack ? stack.calculateDistance() : queue.calculateDistance();
                    if(isStack)
                    {
                        stackOut.write("After calculateDistance:\n");
                        stackOut.write("Total distance=" + Integer.toString(distance) + "\n");
                    }
                    else
                    {
                        queueOut.write("After calculateDistance:\n");
                        queueOut.write("Total distance=" + Integer.toString(distance) + "\n");
                    }
                    break;
                case "addOrRemove":
                    String num = splitted[2];
                    if(isStack)
                    {
                        //After addOrRemove -1:
                        stack.addOrRemove(Integer.parseInt(num));
                        stackOut.write("After addOrRemove " + num + ":\n");
                        stackOut.write(stack.serialize() + "\n");
                    }
                    else
                    {
                        queue.addOrRemove(Integer.parseInt(num));
                        queueOut.write("After addOrRemove " + num + ":\n");
                        queueOut.write(queue.serialize() + "\n");
                    }
                    break;
                case "reverse":
                    String reverseCount = splitted[2];
                    if(isStack)
                    {
                        //After reverse 5:
                        stack.reverseElements(Integer.parseInt(reverseCount));
                        stackOut.write("After reverse " + reverseCount + ":\n");
                        stackOut.write(stack.serialize() + "\n");
                    }
                    else
                    {
                        queue.reverseElements(Integer.parseInt(reverseCount));
                        queueOut.write("After reverse " + reverseCount + ":\n");
                        queueOut.write(queue.serialize() + "\n");
                    }
                    break;
                case "sortElements":
                    if(isStack)
                    {
                        //After sortElements:
                        stack.sort();
                        stackOut.write("After sortElements:\n");
                        stackOut.write(stack.serialize() + "\n");
                    }
                    else
                    {
                        queue.sort();
                        queueOut.write("After sortElements:\n");
                        queueOut.write(queue.serialize() + "\n");
                    }
                    break;
                case "distinctElements":
                    int distinctElements = isStack ? stack.getDistinctElementCount() : queue.getDistinctElementCount();
                    if(isStack)
                    {
                        stackOut.write("After distinctElements:\n");
                        stackOut.write("Total distinct element=" + Integer.toString(distinctElements) + "\n");
                    }
                    else
                    {
                        queueOut.write("After distinctElements:\n");
                        queueOut.write("Total distinct element=" + Integer.toString(distinctElements) + "\n");
                    }
                    break;
                default:
                    break;
            }
        }

        WriteToFile queueOrig = new WriteToFile("queue.txt");
        WriteToFile stackOrig = new WriteToFile("stack.txt");
        queueOrig.write(queue.serialize());
        stackOrig.write(stack.serialize());

        queueOut.end();
        stackOut.end();
        queueOrig.end();
        stackOrig.end();
    }

    String[] commands;
}
