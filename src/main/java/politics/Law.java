package politics;

public class Law extends PoliticalEntity {

    private boolean constitutional;

    Law(Bill bill) {
        super(bill.name);
        constitutional = true;
    }

    public void declareUnconstitutional() {
        constitutional = false;
    }

}
