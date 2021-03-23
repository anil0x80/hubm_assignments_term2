public class Imaging extends OperationDecorator
{
    public Imaging(Operation decoratedOperation) {
        super(decoratedOperation);
    }

    @Override
    public int cost()
    {
        return 10 + super.cost();
    }

    @Override
    public String serialize() {
        return "imaging " + super.serialize();
    }
}
