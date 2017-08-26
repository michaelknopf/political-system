package politics;

/**
 * An elected official is a government official that took office through the democratic
 * process.
 */
public abstract class ElectedOfficial extends PoliticalEntity {

    /**
     * The faction that this official belongs to.
     */
    Faction faction;

    /**
     * Constructs an ElectedOfficial with the given name and faction.
     * @param name the official's name
     * @param faction the official's faction
     */
    public ElectedOfficial(String name, Faction faction) {
        super(name);
        this.faction = faction;
    }

    /**
     * Constructs an ElectedOfficial from a candidate.  This should be used after
     * a candidate has just won an election.
     * @param candidate the candidate who is becoming an elected official
     */
    public ElectedOfficial(Candidate candidate) {
        this(candidate.name, candidate.faction);
    }

    /**
     * Of course, an ElectedOfficial has the ability to tweet, which allows them
     * to communicate to their supporters (and opponents) directly.
     * @param message the message to be tweeted
     */
    public void tweet(String message) {
        System.out.println(message);
    }

    /**
     * Produces a string of strong condemnation of some political entity.
     * @param politicalEntity the entity to condemn
     * @param reason the reason for condemnation
     * @return the condemnation
     */
    public String getStrongCondemnation(PoliticalEntity politicalEntity, String reason) {
        return String.format("I strongly condemn %s for %s.", politicalEntity.name, reason);
    }

    /**
     * Resign from office.
     */
    public void resign() {
        // TODO
    }

}
