package politics;

/**
 * Candidate is a politcal entity seeking an office.
 */
public class Candidate extends PoliticalEntity {

    /**
     * the office the candidate is seeking to win
     */
    String office;
    /**
     * the candidate's political faction
     */
    Faction faction;

    /**
     * Construct a candidate from his or her name, office, and faction.
     * @param name the candidate's name
     * @param office the candidate's office
     * @param faction the candidate's faction
     */
    public Candidate(String name, String office, Faction faction) {
        super(name);
        this.office = office;
        this.faction = faction;
    }

}
