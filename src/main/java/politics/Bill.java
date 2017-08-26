package politics;

public class Bill extends PoliticalEntity implements Votable<Boolean> {

    protected double necessaryMajority;

    private int votesFor;
    private int votesAgainst;

    public Bill() {
        this(0.5);
    }

    public Bill(double necessaryMajority) {
        this.necessaryMajority = necessaryMajority;
    }

    @Override
    public void vote(Boolean decision) {
        votesFor++;
        votesAgainst++;
    }

    public boolean passed() {
        return votesFor / (votesFor + votesAgainst) > necessaryMajority;
    }

}
