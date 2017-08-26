package politics;

import java.util.Random;

/**
 * A citizen represents a member of a political system that can directly
 * vote in an election where a group of candidates are running against
 * each other.
 */
public class Citizen extends PoliticalEntity implements Voter<Candidate> {

    /**
     * used for making decisions
     */
    protected static Random random = new Random();

    /**
     * Construct a citizen from his or her name.
     * @param name the name of the citizen
     */
    public Citizen(String name) {
        super(name);
    }

    /**
     * Cast a vote on a group of candidates.
     * @param candidates The candidates to choose from.
     * @return The index of the chosen candidate.
     */
    @Override
    public int vote(Candidate[] candidates) {
        return random.nextInt(candidates.length);
    }

}
