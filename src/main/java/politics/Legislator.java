package politics;

import java.util.Random;

public class Legislator extends ElectedOfficial implements BinaryVoter<Bill> {

    public static Random random = new Random();

    public Legislator(String name, Faction faction) {
        super(name, faction);
    }

    public Legislator(Candidate candidate) {
        super(candidate);
    }

    public boolean vote(Bill bill) {
        return random.nextBoolean();
    }

}
