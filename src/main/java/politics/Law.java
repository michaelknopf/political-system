package politics;

public class Law extends PoliticalEntity implements Ruleable {

    private boolean constitutional;

    Law(Bill bill) {
        constitutional = true;
    }

    @Override
    public void rule(boolean inFavor) {
        constitutional = inFavor;
    }

}
