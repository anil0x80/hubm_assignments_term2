public class OperationDecorator implements Operation
{
    private Operation decoratedOperation;

    public OperationDecorator(Operation decoratedOperation)
    {
        super();
        this.decoratedOperation = decoratedOperation;
    }

    public void add(Operation decoratedoperation)
    {
        if (decoratedOperation == null)
            this.decoratedOperation = decoratedoperation;
        else
        {
            ((OperationDecorator)this.decoratedOperation).add(decoratedoperation);
        }
    }

    public OperationDecorator()
    {
        super();
        this.decoratedOperation = null;
    }

    public String serialize()
    {
        return decoratedOperation.serialize();
    }

    @Override
    public int cost() {
        return decoratedOperation.cost();
    }
}
