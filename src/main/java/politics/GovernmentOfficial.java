package politics;

public abstract class GovernmentOfficial extends PoliticalEntity {

    Faction faction;

    public GovernmentOfficial(String name, Faction faction) {
        super(name);
        this.faction = faction;
    }

    public void tweet(String message) {
        System.out.println(message);
    }

    public String getStrongCondemnation(PoliticalEntity politicalEntity, String reason) {
        return String.format("I strongly condemn %s for %s.", politicalEntity.name, reason);
    }

    public void resign() {

    }

}
