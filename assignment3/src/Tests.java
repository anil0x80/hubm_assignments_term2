public class Tests extends OperationDecorator
{
    public Tests(Operation decoratedOperation) {
        super(decoratedOperation);
    }

    @Override
    public int cost() {
        return 7 + super.cost();
    }

    @Override
    public String serialize() {
        return "tests " + super.serialize();
    }
}
