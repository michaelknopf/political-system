package politics;

/**
 * Bill represents a set of provisions to be voted on by a LegislativeBody.
 */
public class Bill extends PoliticalEntity {

    /**
     * the provisions that will be enacted if the bill passes
     */
    private final String[] provisions;

    /**
     * Construct a bill from its name and provisions
     * @param name the name of the bill
     * @param provisions the provisions of the bill
     */
    public Bill(String name, String[] provisions) {
        super(name);
        this.provisions = provisions;
    }

    /**
     * getter for provisions
     * @return the bill's provisions
     */
    public String[] getProvisions() {
        return provisions;
    }

}
