package politics;

public abstract class ElectedOfficial extends GovernmentOfficial {

    public ElectedOfficial(String name, Faction faction) {
        super(name, faction);
    }

    public ElectedOfficial(Candidate candidate) {
        super(candidate.name, candidate.faction);
    }

}
