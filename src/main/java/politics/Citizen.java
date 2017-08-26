package politics;

import java.util.Random;

public class Citizen extends PoliticalEntity implements Voter<Candidate> {

    protected static Random random = new Random();

    public int vote(Candidate[] candidates) {
        return choose(candidates);
    }

    private int choose(Candidate[] candidates) {
        return random.nextInt(candidates.length);
    }

}
