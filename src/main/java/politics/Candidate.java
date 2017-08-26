package politics;

public class Candidate extends PoliticalEntity {

    String officeSought;
    Faction faction;

    public Candidate(String name, String officeSought, Faction faction) {
        super(name);
        this.officeSought = officeSought;
        this.faction = faction;
    }

}
