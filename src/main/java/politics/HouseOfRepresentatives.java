package politics;

public class HouseOfRepresentatives extends LegislativeBody {

    HouseOfRepresentatives() {
        super("House of Representatives");
    }

    void impeach(President president) {
        president.impeach();
    }

}
