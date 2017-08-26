package politics;

import java.util.ArrayList;
import java.util.List;

public class LegislativeBody extends PoliticalEntity {

    private List<Legislator> legislators;

    LegislativeBody(String name) {
        super(name);
        legislators = new ArrayList<>();
    }

    public boolean voteOnBill(Bill bill) {
        BinaryElection<Bill> binaryElection = new BinaryElection<>(
                bill,
                legislators.toArray(new Legislator[legislators.size()])
        );
        binaryElection.conductElection();
        return binaryElection.isSuccessful();
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


}
