package politics;

public class BinaryElection<T> extends Election<T> {

    public BinaryElection(T proposal, BinaryVoter<T>[] voters) {
        super((T[]) new Object[] { null, proposal }, voters);
    }

    public Boolean isSuccessful() {
        if (isTie()) {
            return null;
        }
        return getWinner() != null;
    }

}
