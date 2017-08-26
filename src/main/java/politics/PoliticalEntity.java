package politics;

/**
 * All classes in a political system inherit from PoliticalEntity.
 */
public abstract class PoliticalEntity {

    /**
     * The entity's name
     */
    String name;

    /**
     * Construct a political entity from his or her name.
     * @param name the entity's name
     */
    public PoliticalEntity(String name) {
        this.name = name;
    }

}
