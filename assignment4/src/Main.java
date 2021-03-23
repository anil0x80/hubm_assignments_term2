import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {

        MyQueue queue = new MyQueue();
        MyQueue.parseFile(queue, Objects.requireNonNull(ReadFromFile.readFile("queue.txt")));

        MyStack stack = new MyStack();
        MyStack.parseFile(stack, Objects.requireNonNull(ReadFromFile.readFile("stack.txt")));

        Command command = new Command(Objects.requireNonNull(ReadFromFile.readFile(args[0])));
        command.run(queue, stack);
    }

}
