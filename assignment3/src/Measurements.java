public class Measurements extends OperationDecorator
{
    public Measurements(Operation decoratedOperation) {
        super(decoratedOperation);
    }

    @Override
    public int cost()
    {
        return 5 + super.cost();
    }

    @Override
    public String serialize() {
        return "measurements " + super.serialize();
    }
}
