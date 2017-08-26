package politics;

import java.util.ArrayList;
import java.util.List;

public abstract class LegislativeBody extends PoliticalEntity {

    private List<Legislator> legislators;
    private int numberOfRepresentatives;

    public void voteOnLaw() {

    }

    public int getNumberOfRepresentatives() {
        return numberOfRepresentatives;
    }

    public void setNumberOfRepresentatives(int numberOfRepresentatives) {
        this.numberOfRepresentatives = numberOfRepresentatives;
    }

    public List<Legislator> getLegislators() {
        return legislators;
    }

    public void addLegislator(Legislator legislator) {
        legislators.add(legislator);
    }

    public void removeLegislator(Legislator legislator) {
        legislators.remove(legislator);
    }

    LegislativeBody() {
        legislators = new ArrayList<Legislator>();
    }

}
