package politics;

public class Bill extends PoliticalEntity {

    private final String[] provisions;

    public Bill(String name, String[] provisions) {
        super(name);
        this.provisions = provisions;
    }

    public String[] getProvisions() {
        return provisions;
    }

}
