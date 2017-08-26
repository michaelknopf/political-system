package politics;

public abstract class ElectedOfficial extends GovernmentOfficial {

    public ElectedOfficial(Candidate candidate) {
        name = candidate.name;
        faction = candidate.faction;
    }

}
