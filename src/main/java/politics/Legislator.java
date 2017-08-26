package politics;

import java.util.Random;

/**
 * A legislator is an elected official that is a member of some legislative body
 * and can vote on bills.
 */
public class Legislator extends ElectedOfficial implements BinaryVoter<Bill> {

    /**
     * used for making important decisions that affect millions of people
     */
    public static Random random = new Random();

    /**
     * Construct a Legislator from his or her name and faction
     * @param name the legislator's name
     * @param faction the legislator's faction
     */
    public Legislator(String name, Faction faction) {
        super(name, faction);
    }

    /**
     * Constructs a Legislator from a candidate.  This should be used after
     * a candidate has just won an election for a legislative office.
     * @param candidate the candidate who is becoming a legislator
     */
    public Legislator(Candidate candidate) {
        super(candidate);
    }

    /**
     * Vote in favor or against a proposed bill.
     * @param bill the bill to vote on
     * @return true if the legislator is in favor of the bill, otherwise false
     */
    public boolean vote(Bill bill) {
        return random.nextBoolean();
    }

}
