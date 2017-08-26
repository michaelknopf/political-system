package politics;

public abstract class GovernmentOfficial extends PoliticalEntity {

    Faction faction;

    public void tweet(String message) {
        System.out.println(message);
    }

    public String getStrongCondemnation(PoliticalEntity politicalEntity, String reason) {
        return String.format("I strongly condemn %s for %s.");
    }

    public void resign() {

    }

}
