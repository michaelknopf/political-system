package politics;

import java.util.ArrayList;
import java.util.List;

/**
 * A LegislativeBody is a collection of legislators who vote
 * together on bills.
 */
public class LegislativeBody extends PoliticalEntity {

    /**
     * the legislators that make up the LegislativeBody
     */
    private List<Legislator> legislators;

    /**
     * Construct a LegislativeBody from its name
     * @param name the name of the LegislativeBody
     */
    LegislativeBody(String name) {
        super(name);

        // initialize legislators
        legislators = new ArrayList<>();
    }

    /**
     * hold a vote within the legislative body on a given bill
     * @param bill the bill to be voted on
     * @return true if the bill passed, otherwise false
     */
    public Boolean voteOnBill(Bill bill) {

        // construct a binary election
        BinaryElection<Bill> binaryElection = new BinaryElection<>(
                bill,
                legislators.toArray(new Legislator[legislators.size()])     // convert the legislators to an array
        );

        // allow legislators to cast their votes
        binaryElection.conductElection();

        // return result of election
        return binaryElection.isSuccessful();
    }

    /**
     * getter method for legislators
     * @return the legislators
     */
    public List<Legislator> getLegislators() {
        return legislators;
    }

    /**
     * add a legislator to the legislative body
     * @param legislator the legislator to add
     */
    public void addLegislator(Legislator legislator) {
        legislators.add(legislator);
    }

    /**
     * remove a legislator from the legislative body
     * @param legislator the legislator to remove
     */
    public void removeLegislator(Legislator legislator) {
        legislators.remove(legislator);
    }


}
