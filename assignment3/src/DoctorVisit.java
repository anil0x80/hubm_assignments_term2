public class DoctorVisit extends OperationDecorator
{
    public DoctorVisit(Operation decoratedOperation) {
        super(decoratedOperation);
    }

    @Override
    public int cost()
    {
        return 15 + super.cost();
    }

    @Override
    public String serialize() {
        return "doctorvisit " + super.serialize();
    }
}
